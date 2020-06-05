package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresRetabet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Retabet {
    public static List<Cuotas> parseador(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            Elements equiposs = betfairLaLiga.getElementsByClass("players jcont");
            Elements equipoi = equiposs.select("li");
            Elements cuotass = betfairLaLiga.getElementsByClass("jpr");

            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();
            for (Element element : equipoi) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposLaLiga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposBundesliga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposPremier(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposCalcio(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposEredivise(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposLigue1(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresRetabet.estandarizadorEquiposPrimeira(equipos);
                        listaPartidos.add(equipo);
                        break;

                }

            }


            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : cuotass) {
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
                    String porcentajefinaltexto = String.valueOf(porcentajefinal);
                    String porcentajefinalredondeado = String.format("%.2f", porcentajefinal);


                    String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), listaCuotas.get(c), listaCuotas.get(d), listaCuotas.get(e), porcentajefinalredondeado.replace(",", "."));
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
