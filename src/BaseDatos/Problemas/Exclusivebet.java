package BaseDatos.Problemas;

import Modelo.Cuotas;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exclusivebet {
    public static List<Cuotas> parseador(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            System.out.println(betfairLaLiga);
            //Cuotas
            Elements gp = betfairLaLiga.select("button [class=OddsButton]"); //con esto obtengo las cuotas de 1x2, porque en bwin tambien esta la tabla de +-2.5 goles
           Elements cuotasBetfairLaLiga = gp.select("[class*='ui-runner-price ui']");
            //Nombre equipos
            Elements nombreEquiposBetfairLaLiga = betfairLaLiga.select("span[class=team-name]");

            lista = new ArrayList<>();

            ArrayList<String> listaPartidosBetfairLaLiga = new ArrayList<>();
            for (Element element : nombreEquiposBetfairLaLiga) {
                String equipos = element.text();

            }


            ArrayList<String> listaCuotasBetfairLaLiga = new ArrayList<>();
            for (Element element : cuotasBetfairLaLiga) {
                String cuotas = element.text();
                listaCuotasBetfairLaLiga.add(cuotas);
            }

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;


            if (listaPartidosBetfairLaLiga.size() != 0) {
                for (int i = 0; i < (listaPartidosBetfairLaLiga.size() / 2); i++) {
                    String cuota1 = listaCuotasBetfairLaLiga.get(c);
                    String cuotax = listaCuotasBetfairLaLiga.get(d);
                    String cuota2 = listaCuotasBetfairLaLiga.get(e);
                    double cuota1double = Double.parseDouble(cuota1);
                    double cuotaxdouble = Double.parseDouble(cuotax);
                    double cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1 / cuota1double);
                    double porcentajex = (1 / cuotaxdouble);
                    double porcentaje2 = (1 / cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                    String porcentajefinaltexto = String.valueOf(porcentajefinal);


                    String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaPartidosBetfairLaLiga.get(a), listaPartidosBetfairLaLiga.get(b), listaCuotasBetfairLaLiga.get(c), listaCuotasBetfairLaLiga.get(d), listaCuotasBetfairLaLiga.get(e), porcentajefinaltexto);
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
