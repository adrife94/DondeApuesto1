package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresGoldenPark;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class GoldenPark {
    public static List<Cuotas> parseadorGolden(String casa, String liga, String url ){
        List<Cuotas> lista = null;
             try {

                 //No muestra todos los eventos porque hay que darle a ver todos los partidos para que aparezcan, y con jsoup solo obtenemos el html pero no podemos interactuar con el

            Document goldenPark = Jsoup.connect(url).get();
            Elements gp = goldenPark.select("div [class=snc-odds-odd nb-load]");
            Elements gps = goldenPark.select("div [class=snc-odds-title-event]");
                 lista = new ArrayList<>();

            ArrayList<String> listaCuotaGolden = new ArrayList<>();
            for (Element element : gp) {
                String equipos = element.text();
                listaCuotaGolden.add(equipos);
            }

            ArrayList<String> listaPartidosGolden = new ArrayList<>();
            for (Element element : gps) {
                String equipos = element.text();
                listaPartidosGolden.add(equipos);
            }

            ArrayList<String> listaEquiposGolden = new ArrayList<>();
            for (String  element : listaPartidosGolden) {
                int num = element.indexOf("/");
                String a = element.substring(0, num - 1);
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposLaLiga(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposBundesliga(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposPremier(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposCalcio(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposEredivise(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposLigue1(a);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposPrimeira(a);
                        listaEquiposGolden.add(equipo);
                        break;

                }
                String b = element.substring(num + 2);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposLaLiga(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposBundesliga(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposPremier(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposCalcio(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposEredivise(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposLigue1(b);
                        listaEquiposGolden.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresGoldenPark.estandarizadorEquiposPrimeira(b);
                        listaEquiposGolden.add(equipo);
                        break;
                }
            }


            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;


            if(listaEquiposGolden.size()!= 0) {

                for (int i=0 ; i<= listaEquiposGolden.size() - 1; i++ ) {

                        String cuota1 = listaCuotaGolden.get(c).replace(",", ".");
                        String cuotax = listaCuotaGolden.get(d).replace(",", ".");
                        String cuota2 = listaCuotaGolden.get(e).replace(",", ".");
                        double cuota1double = Double.parseDouble(cuota1);
                        double cuotaxdouble = Double.parseDouble(cuotax);
                        double cuota2double = Double.parseDouble(cuota2);

                        double porcenatje1 = (1/cuota1double);
                        double porcentajex = (1/cuotaxdouble);
                        double porcentaje2 = (1/cuota2double);

                        double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                        String porcentajefinaltexto = String.valueOf(porcentajefinal);


                        String numid = Integer.toString(numeroidentificador);
                        Cuotas cuota = new Cuotas(listaEquiposGolden.get(a), listaEquiposGolden.get(b), listaCuotaGolden.get(c), listaCuotaGolden.get(d), listaCuotaGolden.get(e), porcentajefinaltexto);
                        lista.add(cuota);
                        a+=2;
                        b+=2;
                        c+=3;
                        d+=3;
                        e+=3;

                }

            }else {

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


}
