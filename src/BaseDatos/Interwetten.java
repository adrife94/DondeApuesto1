package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresInterwetten;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class Interwetten {
    public static List<Cuotas> parseadorInterwetten(String casa, String liga, String url ) {
        List<Cuotas> lista = null;
        try {

//Aunque parezca que no recoge bien la info, aunque este desorganizado debido a los pares e impares
            Document interwett = Jsoup.connect(url).get();
            Elements elementosEquip1 = interwett.select("tr [class=b n3x]");
            Elements elementosCuot1 = elementosEquip1.select("strong");
            Elements elementosNombre1 = elementosEquip1.select("td [itemprop=name]");

            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();

            for (Element element : elementosNombre1) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposLaLiga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposBundesliga(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposPremier(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposCalcio(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposEredivise(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposLigue1(equipos);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresInterwetten.estandarizadorEquiposPrimeira(equipos);
                        listaPartidos.add(equipo);
                        break;
                }
            }

            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : elementosCuot1) {
                String equipos = element.text();
                listaCuotas.add(equipos);

            }

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificador = 1;

            if(listaPartidos.size()!= 0) {

                for (int i=0 ; i<=(listaPartidos.size() / 3) -1; i++ ) {

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
                    //    String porcentajefinaltexto = String.valueOf(porcentajefinal);

                    double resultado = (100 /porcentajefinal * 100) - 100;

                    double beneficio = (resultado/100) * 100;

                        String porcentajefinalredondeado = String.format("%.2f", beneficio);




                   //     String numid = Integer.toString(numeroidentificador);
                        Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(e), cuota1, cuotax, cuota2,  porcentajefinalredondeado.replace(",", "."));
                        lista.add(cuota);
                        a+=3;
                        b+=2;
                        c+=3;
                        d+=3;
                        e+=3;

                    }

                }
            else {

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


}
