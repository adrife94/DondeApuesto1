package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresJuegging;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Juegging {
    public static List<Cuotas> parseador(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            Elements equipos = betfairLaLiga.getElementsByClass("partido");
            Elements cuo = betfairLaLiga.select("ul[des=1X2]");
            Elements cuotas = cuo.select("span[class=coef]");
            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();
            for (Element element : equipos) {
                String equipo = element.text();
                String equiposs = element.text();
                int num = equipo.indexOf("vs.");
                int num2 = equipo.indexOf("(+");
                String equipolocal = equipo.substring(0, num - 1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                }

                String b = equiposs.substring(num + 4,num2 -1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(b);
                        listaPartidos.add(equipo);
                        break;
                }

            }


            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : cuotas) {
                String cuota = element.text();
                listaCuotas.add(cuota);


            }

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;


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

                    String porcentajefinalredondeado = String.format("%.2f", beneficio);

                    Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), cuota1, cuotax, cuota2,  porcentajefinalredondeado.replace(",", "."));
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
