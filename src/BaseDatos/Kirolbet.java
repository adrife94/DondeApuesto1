package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresCasinoMadrid;
import Modelo.EstandarizadorNombresKirolbet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kirolbet {
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
                String equiposs = element.text();
                int num = equiposs.indexOf("vs.");
                int num2 = equiposs.indexOf("(+");
                String equipolocal = equiposs.substring(0, num - 1);
                String equipovisitante = equiposs.substring(num + 4,num2 -1);
                String equipo, equipo2;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposLaLiga(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposLaLiga(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposBundesliga(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposBundesliga(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposPremier(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposPremier(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposCalcio(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposCalcio(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposEredivise(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposEredivise(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposLigue1(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposLigue1(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresKirolbet.estandarizadorEquiposPrimeira(equipolocal);
                        equipo2 = EstandarizadorNombresKirolbet.estandarizadorEquiposPrimeira(equipovisitante);
                        listaPartidos.add(equipo);
                        listaPartidos.add(equipo2);
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
                for (int i = 0; i < (listaPartidos.size() / 2) - 1; i++) {
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
                    String porcentajefinaltexto = String.valueOf(porcentajefinal);


                    String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), listaCuotas.get(c), listaCuotas.get(d), listaCuotas.get(e), porcentajefinaltexto);
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
