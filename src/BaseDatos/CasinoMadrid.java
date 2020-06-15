package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresCasinoMadrid;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CasinoMadrid {
    public static List<Cuotas> parseadorMadrid(String casa, String liga, String url, Date date ) {
        PostgreSqlConexion postgreSqlConexion = new PostgreSqlConexion(casa);
        EventoBaseDatos eventoBaseDatos = new EventoBaseDatos(postgreSqlConexion);
        List<Cuotas> lista = null;
        try {

            Document madrid = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements elementosEquip = madrid.select("div [class=snc-bet-information-actors text-ellipsis uk-flex]");//.not("span[class=top-selns]"); Si ponemos elements es para muchos, element para uno. Y con lo que esta entrecomillado filtramos.
            Elements elementosCuota = madrid.select("div [class=snc-bet-choices-items]");
            Elements elementosCuotas = elementosCuota.select("a");
            Elements elementosCuo = elementosEquip.select("a");

            lista = new ArrayList<>();

            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : elementosCuotas) {
                String e = element.text();
                String equipos = e.substring(2);
                listaCuotas.add(equipos);
            }

            ArrayList<String> listaEquipos = new ArrayList<>();
            for (Element element : elementosCuo) {
                String equipos = element.text();
                String equipo;
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposLaLiga(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposBundesliga(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposPremier(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposCalcio(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposEredivise(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposLigue1(equipos);
                        listaEquipos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresCasinoMadrid.estandarizadorEquiposPrimeira(equipos);
                        listaEquipos.add(equipo);
                        break;

                }


            }



            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;



                if(listaEquipos.size()!= 0) {

                    for (int i=0 ; i<=(listaEquipos.size() / 2) - 1 ; i++ ) {
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

                        String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                        double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                        eventoBaseDatos.crearTabla(listaEquipos.get(a).replace(" ", ""), listaEquipos.get(b).replace(" ", ""));

                        Cuotas cuotas = new Cuotas(listaEquipos.get(a), listaEquipos.get(b), date, cuota1double, cuotaxdouble, cuota2double, porcentajefonalredondeadodouble, liga, "2019-2020" );

                        eventoBaseDatos.InsertarCuotas(cuotas, listaEquipos.get(a), listaEquipos.get(b));

                    //    String numid = Integer.toString(numeroidentificador);
                        Cuotas cuota = new Cuotas(listaEquipos.get(a), listaEquipos.get(b), cuota1, cuotax, cuota2, porcentajefinalredondeado.replace(",", "."));
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
