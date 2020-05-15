package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresSportium;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sportium {

    public static List<Cuotas> parseadorSportium( String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

            Document SportiumLaLiga = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements clasesSportiumLaLiga = SportiumLaLiga.getElementsByClass("coupon coupon-horizontal coupon-scoreboard video-enabled");
            Elements cuotasSportiumLaLiga = clasesSportiumLaLiga.select("span[class=price dec]");
            Elements nombreEquiposSportiumLaLiga = clasesSportiumLaLiga.select("span[class=seln-name]");
            Elements fechaEquiposSportium = SportiumLaLiga.select("span[class=date]");
            Elements horaEquiposSportium = clasesSportiumLaLiga.select("span[class=time]");

            lista = new ArrayList<>();


            ArrayList<String> listaPartidosSportiumLaLiga = new ArrayList<>();
            for (Element element : nombreEquiposSportiumLaLiga) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposLaLiga(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposBundesliga(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposPremier(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposCalcio(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposEredivise(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposLigue1(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresSportium.estandarizadorEquiposPrimeira(equipos);
                        listaPartidosSportiumLaLiga.add(equipo);
                        break;

                }





            }

            ArrayList<String> listaCuotasSportiumLaLiga = new ArrayList<>();
            for (Element element : cuotasSportiumLaLiga) {
                String equipos = element.text();
                listaCuotasSportiumLaLiga.add(equipos);
            }

            ArrayList<String> listaFechasSportiumLaLiga = new ArrayList<>();
            for (Element element : fechaEquiposSportium) {
                String equipos = element.text();
                listaFechasSportiumLaLiga.add(equipos);
            }

            ArrayList<String> listaHorasSportiumLaLiga = new ArrayList<>();
            for (Element element : horaEquiposSportium) {
                String equipos = element.text();
                listaHorasSportiumLaLiga.add(equipos);
            }


            int a = 0;
            int numhorafecha = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;

            if (listaPartidosSportiumLaLiga.size() != 0) {
                for (int i = 0; i < (listaPartidosSportiumLaLiga.size() / 2); i++) {
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");

                    String cuota1 = listaCuotasSportiumLaLiga.get(c);
                    String cuotax = listaCuotasSportiumLaLiga.get(d);
                    String cuota2 = listaCuotasSportiumLaLiga.get(e);
                    double cuota1double = Double.parseDouble(cuota1);
                    double cuotaxdouble = Double.parseDouble(cuotax);
                    double cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1/cuota1double);
                    double porcentajex = (1/cuotaxdouble);
                    double porcentaje2 = (1/cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                    String porcentajefinaltexto = String.valueOf(porcentajefinal);
                    String porcentajefinaltextotruncado = decimalFormat.format(porcentajefinal);
                    String porcentajefinaltextotruncadopunto = porcentajefinaltextotruncado.replace(",", ".");


                    String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaPartidosSportiumLaLiga.get(a), listaPartidosSportiumLaLiga.get(b), listaCuotasSportiumLaLiga.get(c), listaCuotasSportiumLaLiga.get(d), listaCuotasSportiumLaLiga.get(e), porcentajefinaltextotruncadopunto, listaFechasSportiumLaLiga.get(numhorafecha),listaHorasSportiumLaLiga.get(numhorafecha));
                    lista.add(cuota);
                    a+=2;
                    b+=2;
                    c+=3;
                    d+=3;
                    e+=3;
                    numhorafecha++;


                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return lista;
    }


}
