package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresSissal;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sissal {
    public static List<Cuotas> parseador(String casa, String liga, String url, Date date) {
        PostgreSqlConexion postgreSqlConexion = new PostgreSqlConexion(casa);
        EventoBaseDatos eventoBaseDatos = new EventoBaseDatos(postgreSqlConexion);
        List<Cuotas> lista = null;
        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            Elements equiposs = betfairLaLiga.getElementsByClass("snc-odds-title-event");
            Elements cuotass = betfairLaLiga.getElementsByClass("snc-odds-odd nb-load ");

            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();
            for (Element element : equiposs) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposLaLiga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposBundesliga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposPremier(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposCalcio(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposEredivise(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposLigue1(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresSissal.estandarizadorEquiposPrimeira(equipos);
                        listaPartidos.add(equipo);
                        break;
                }

            }


            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : cuotass) {
                String cuo = element.text();
                String cuota = cuo.substring(2);
                listaCuotas.add(cuota);


            }

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;


            if (listaPartidos.size() != 0) {
                for (int i = 0; i < (listaPartidos.size() / 2); i++) {
                    String cuota1 = listaCuotas.get(c).replace(",", ".");
                    String cuotax = listaCuotas.get(d).replace(",", ".");
                    String cuota2 = listaCuotas.get(e).replace(",", ".");
                    double cuota1double = Double.parseDouble(cuota1);
                    double cuotaxdouble = Double.parseDouble(cuotax);
                    double cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1 / cuota1double);
                    double porcentajex = (1 / cuotaxdouble);
                    double porcentaje2 = (1 / cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;

                    double resultado = (100 /porcentajefinal * 100) - 100;

                    double beneficio = (resultado/100) * 100;

                    String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                    double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                    eventoBaseDatos.crearTabla(listaPartidos.get(a).replace(" ", ""), listaPartidos.get(b).replace(" ", ""));

                    Cuotas cuotas = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), date, cuota1double, cuotaxdouble, cuota2double, porcentajefonalredondeadodouble, liga, "2019-2020" );

                    eventoBaseDatos.InsertarCuotas(cuotas, listaPartidos.get(a), listaPartidos.get(b));


                    Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), cuota1, cuotax, cuota2, porcentajefinalredondeado.replace(",", "."));
                    lista.add(cuota);
                    a += 2;
                    b += 2;
                    c += 3;
                    d += 3;
                    e += 3;
                }

            } else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;

    }
}
