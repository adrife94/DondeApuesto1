package BaseDatos.Problemas;

import Modelo.Cuotas;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Versus {
    public static List<Cuotas> parseador(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

            Document versus = Jsoup.connect(url).get();
            System.out.println(versus);
            Elements equipos = versus.select("div[class=bet-event-main-row]");
            Elements cuo = versus.select("ul[des=1X2]");
            Elements cuotas = cuo.select("span[class=coef]");
            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();
            for (Element element : equipos) {
                String equipo = element.text();
                int num = equipo.indexOf("vs.");
                int num2 = equipo.indexOf("(+");
                String equipolocal = equipo.substring(0, num - 1);
                String equipovisitante = equipo.substring(num + 4, num2 -1);
                listaPartidos.add(equipolocal);
                listaPartidos.add(equipovisitante);

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
