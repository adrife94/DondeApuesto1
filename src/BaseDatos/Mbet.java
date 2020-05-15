package BaseDatos;


import Modelo.Cuotas;
import Modelo.EstandarizadorNombresMbet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;


public class Mbet {
    public static List<Cuotas> parseadorMbet(String casa, String liga, String url) {
        List<Cuotas> lista = null;
        try {


            Document mbet = Jsoup.connect(url).get();//Mbet distingue los partidos de hoy del resto de dias
            Elements cuotalocal = mbet.getElementsByClass("price height-column-with-price    first-in-main-row  coupone-width-3");
            Elements cuotaxVisitante = mbet.getElementsByClass("price height-column-with-price    coupone-width-3");
            Elements elementosEquip = mbet.select("div [class=member-link]");



            lista = new ArrayList<>();

            int i = 0;

            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : cuotalocal) {
                String cuota1 = element.text();
                String cuotax = String.valueOf(cuotaxVisitante.get(i).text());
                String cuota2 = String.valueOf(cuotaxVisitante.get(i+1).text());
                listaCuotas.add(cuota1);
                listaCuotas.add(cuotax);
                listaCuotas.add(cuota2);
                i+=2;
            }

            ArrayList<String> listaEquipos = new ArrayList<>();
            for (Element element : elementosEquip) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposLaLiga(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposBundesliga(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposPremier(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposCalcio(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposEredivise(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposLigue1(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresMbet.estandarizadorEquiposPrimeira(equipos);
                        listaEquipos.add(equipo);
                        break;

                }

            }
   /*         ArrayList<String> listaE = new ArrayList<>();
            for (Element element : elementosCuotaX2) {
                String equipos = element.text();
                listaE.add(equipos);
            }


            int tamano2array = elementosCuota1.size() + elementosCuotaX2.size();

            ArrayList<String> listaCuo = new ArrayList<>();
            int a = 0;
            int c = 0;
            int b = 1;*/


        /*    for (int i = 0; i <= (tamano2array / 3) - 1; i++) {
                listaCuotas.add(listaEqu.get(a));
                listaCuotas.add(listaE.get(c));
                listaCuotas.add(listaE.get(b));
                a++;
                c += 2;
                b += 2;
            }*/


            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;


            if (listaEquipos.size() != 0) {
                for (int v = 0; v < (listaEquipos.size() / 2) ; v++) {
                    String cuota1 = listaCuotas.get(c);
                    String cuotax = listaCuotas.get(d);
                    String cuota2 = listaCuotas.get(e);
                    double cuota1double = Double.parseDouble(cuota1);
                    double cuotaxdouble = Double.parseDouble(cuotax);
                    double cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1/cuota1double);
                    double porcentajex = (1/cuotaxdouble);
                    double porcentaje2 = (1/cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                    String porcentajefinaltexto = String.valueOf(porcentajefinal);


                    String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaEquipos.get(a), listaEquipos.get(b), listaCuotas.get(c), listaCuotas.get(d), listaCuotas.get(e), porcentajefinaltexto);
                    lista.add(cuota);
                    a+=2;
                    b+=2;
                    c+=3;
                    d+=3;
                    e+=3;

                }
            } else {

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;

    }
}
