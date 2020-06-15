package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresSuertia;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Suertia {
    public static List<Cuotas> parseadorSuertia(String casa, String liga, String url, Date date ) {
        PostgreSqlConexion postgreSqlConexion = new PostgreSqlConexion(casa);
        EventoBaseDatos eventoBaseDatos = new EventoBaseDatos(postgreSqlConexion);
        List<Cuotas> lista = null;

        try {
            Document suertia = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements elementosEquip = suertia.select("div [class=snc-bets-item snc-bets-item-withoutactor]");//.not("span[class=top-selns]"); Si ponemos elements es para muchos, element para uno. Y con lo que esta entrecomillado filtramos.
            Elements elementosCuot = elementosEquip.select("div [class=snc-event]");
            Elements elementosCuotass = elementosEquip.select("div [class=odd-without-actor]");

            lista = new ArrayList<>();

                ArrayList<String> listaEquiposSuertia = new ArrayList<>();
            for (Element element : elementosCuot) {
                String equipos = element.text();
                listaEquiposSuertia.add(equipos);
            }

            ArrayList<String> listaCuotaSuertia = new ArrayList<>();
            for (Element element : elementosCuotass) {
                String equipos = element.text();
                listaCuotaSuertia.add(equipos);

            }


            ArrayList<String> listaPartidosSuertia = new ArrayList<>();
            for (String  element : listaEquiposSuertia) {
                int num = element.indexOf("/");
                String a = element.substring(0, num - 1);
                String b = element.substring(num + 2);
                String equipo1, equipo2;
                switch (liga) {
                    case "LaLiga":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposLaLiga(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposLaLiga(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Bundesliga":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposBundesliga(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposBundesliga(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Premier":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposPremier(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposPremier(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Calcio":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposCalcio(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposCalcio(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Eredivise":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposEredivise(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposEredivise(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Ligue1":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposLigue1(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposLigue1(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;
                    case "Primeira":
                        equipo1 = EstandarizadorNombresSuertia.estandarizadorEquiposPrimeira(a);
                        equipo2 = EstandarizadorNombresSuertia.estandarizadorEquiposPrimeira(b);
                        listaPartidosSuertia.add(equipo1);
                        listaPartidosSuertia.add(equipo2);
                        break;

                }
            }
            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;


                if(listaPartidosSuertia.size()!= 0) {

                    for (int i=0 ; i<=(listaPartidosSuertia.size() / 2) - 1; i++ ) {

                        String cuota1 = listaCuotaSuertia.get(c).replace(",", ".");
                        String cuotax = listaCuotaSuertia.get(d).replace(",", ".");
                        String cuota2 = listaCuotaSuertia.get(e).replace(",", ".");
                        double cuota1double = Double.parseDouble(cuota1);
                        double cuotaxdouble = Double.parseDouble(cuotax);
                        double cuota2double = Double.parseDouble(cuota2);

                        double porcenatje1 = (1/cuota1double);
                        double porcentajex = (1/cuotaxdouble);
                        double porcentaje2 = (1/cuota2double);

                        double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;


                        double resultado = (100 /porcentajefinal * 100) - 100;

                        double beneficio = (resultado/100) * 100;

                        String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                        double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                        eventoBaseDatos.crearTabla(listaPartidosSuertia.get(a).replace(" ", ""), listaPartidosSuertia.get(b).replace(" ", ""));

                        Cuotas cuotass = new Cuotas(listaPartidosSuertia.get(a), listaPartidosSuertia.get(b), date, cuota1double, cuotaxdouble, cuota2double, porcentajefonalredondeadodouble, liga, "2019-2020" );

                        eventoBaseDatos.InsertarCuotas(cuotass, listaPartidosSuertia.get(a), listaPartidosSuertia.get(b));

                        Cuotas cuota = new Cuotas(listaPartidosSuertia.get(a), listaPartidosSuertia.get(b), cuota1, cuotax, cuota2, porcentajefinalredondeado.replace(",", "."));
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
