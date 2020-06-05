package BaseDatos;

import Modelo.Cuotas;

import Modelo.EstandarizadorNombresCasinoBarcelona;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class CasinoBarcelona {

    public static List<Cuotas> parseadorBarcelona(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
    try {


        Document barcelona = Jsoup.connect(url).get();  //Con Basino Barcelona el pequeño problema es que te devuelve en un mismo elemento FC Sevilla / Leganés, en vez de los equipos por separado
        //Cuota
        Elements elementosEquipos = barcelona.select("div [class=snc-event]");
        //Equipo
        Elements elementosCuotas = barcelona.select("div [class=snc-load uk-flex ]");

        lista = new ArrayList<>();

        ArrayList<String> listaPartidos = new ArrayList<>();
        for (Element element : elementosEquipos) {
        String equipos = element.text();
        listaPartidos.add(equipos);
        }

        ArrayList<String> listaEquipos = new ArrayList<>();
        for (String  element : listaPartidos) {
            int num = element.indexOf("/");
            String a = element.substring(0,num - 1);
            String b = element.substring(num + 2);

            String equipo, equipo1;
            switch (liga) {
                case "LaLiga":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposLaLiga(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposLaLiga(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Bundesliga":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposBundesliga(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposBundesliga(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Premier":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposPremier(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposPremier(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Calcio":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposCalcio(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposCalcio(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Eredivise":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposEredivise(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposEredivise(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Ligue1":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposEredivise(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposEredivise(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;
                case "Primeira":
                    equipo = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposPrimeira(a);
                    equipo1 = EstandarizadorNombresCasinoBarcelona.estandarizadorEquiposPrimeira(b);
                    listaEquipos.add(equipo);
                    listaEquipos.add(equipo1);
                    break;

            }

        }

        ArrayList<String> listaCuotas = new ArrayList<>();
        for (Element element : elementosCuotas) {
        String equipos = element.text();
        listaCuotas.add(equipos);
        }


        int a = 0;
        int b = 1;
        int c = 0;
        int d = 1;
        int e = 2;
        int numeroidentificador = 1;



            if (listaEquipos.size()!=0) {

                for (int i=0;i <= (listaEquipos.size() / 2) -1; i++ ) {

                    String cuota1 = listaCuotas.get(c).replace(",", ".");
                    String cuotax = listaCuotas.get(d).replace(",", ".");
                    String cuota2 = listaCuotas.get(e).replace(",", ".");
                    double cuota1double = Double.parseDouble(cuota1);
                    double cuotaxdouble = Double.parseDouble(cuotax);
                    double cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1/cuota1double);
                    double porcentajex = (1/cuotaxdouble);
                    double porcentaje2 = (1/cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
               //     String porcentajefinaltexto = String.valueOf(porcentajefinal);
                    double resultado = (100 /porcentajefinal * 100) - 100;

                    double beneficio = (resultado/100) * 100;

                    String porcentajefinalredondeado = String.format("%.2f", beneficio);

               //     String numid = Integer.toString(numeroidentificador);
                    Cuotas cuota = new Cuotas(listaEquipos.get(a), listaEquipos.get(b), cuota1, cuotax, cuota2, porcentajefinalredondeado.replace(",", "."));
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
