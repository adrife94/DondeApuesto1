package BaseDatos;


import Modelo.Cuotas;
import Modelo.EstandarizadorNombresMarcaApuestas;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MarcaApuestas {
    public static List<Cuotas> parseadorMarca (String casa, String liga, String url, Date date ){
        PostgreSqlConexion postgreSqlConexion = new PostgreSqlConexion(casa);
        EventoBaseDatos eventoBaseDatos = new EventoBaseDatos(postgreSqlConexion);
        List<Cuotas> lista = null;
        Document marca;
        Elements tabla3corredores = null, elementosCuota = null, elementosEqipo = null;
        try {

            if (liga.equals("LaLiga")) {
                marca = Jsoup.connect(url).get();//Con Basino Barcelona el pequeño problema es que te devuelve en un mismo elemento FC Sevilla / Leganés, en vez de los equipos por separado
                tabla3corredores  = marca.getElementsByClass("coupon coupon-horizontal coupon-scoreboard ");
                //Cuota
                elementosCuota  = tabla3corredores.select("span[class=price dec]");
                //Equipo
                elementosEqipo = tabla3corredores.select("span[class=seln-name]");
            } else {
                marca = Jsoup.connect(url).get();//Con Basino Barcelona el pequeño problema es que te devuelve en un mismo elemento FC Sevilla / Leganés, en vez de los equipos por separado
                tabla3corredores  = marca.getElementsByClass("coupon coupon-horizontal coupon-scoreboard video-enabled");
                //Cuota
                elementosCuota  = tabla3corredores.select("span[class=price dec]");
                //Equipo
                elementosEqipo = tabla3corredores.select("span[class=seln-name]");
            }



            lista = new ArrayList<>();

        ArrayList<String> listaCuotaMarca = new ArrayList<>();
        for (Element element : elementosCuota) {
            String equipos = element.text();
            listaCuotaMarca.add(equipos);
        }

        ArrayList<String> listaPartidosMarca = new ArrayList<>();
        for (Element element : elementosEqipo) {
            String equipos = element.text();
            String equipo;
            switch (liga) {
                case "LaLiga":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposLaLiga(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Bundesliga":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposBundesliga(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Premier":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposPremier(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Calcio":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposCalcio(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Eredivise":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposEredivise(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Ligue1":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposLigue1(equipos);
                    listaPartidosMarca.add(equipo);
                    break;
                case "Primeira":
                    equipo = EstandarizadorNombresMarcaApuestas.estandarizadorEquiposPrimeira(equipos);
                    listaPartidosMarca.add(equipo);
                    break;

            }
        }

        int a = 0;
        int b = 1;
        int c = 0;
        int d = 1;
        int e = 2;


            if(listaPartidosMarca.size()!= 0) {

                for (int i = 0; i <= (listaPartidosMarca.size() / 2) - 1; i++) {
                    String cuota1 = listaCuotaMarca.get(c);
                    String cuotax = listaCuotaMarca.get(d);
                    String cuota2 = listaCuotaMarca.get(e);
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

                    eventoBaseDatos.crearTabla(listaPartidosMarca.get(a).replace(" ", ""), listaPartidosMarca.get(b).replace(" ", ""));

                    Cuotas cuotas = new Cuotas(listaPartidosMarca.get(a), listaPartidosMarca.get(b), date, cuota1double, cuotaxdouble, cuota2double, porcentajefonalredondeadodouble, liga, "2019-2020" );

                    eventoBaseDatos.InsertarCuotas(cuotas, listaPartidosMarca.get(a), listaPartidosMarca.get(b));


                    Cuotas cuota = new Cuotas(listaPartidosMarca.get(a), listaPartidosMarca.get(b), listaCuotaMarca.get(c), listaCuotaMarca.get(d), listaCuotaMarca.get(e), porcentajefinalredondeado.replace(",", "."));
                    lista.add(cuota);
                    a+=2;
                    b+=2;
                    c+=3;
                    d+=3;
                    e+=3;

                }
            }else {

            }




    } catch (Exception nn) {
        nn.printStackTrace();
    }
return lista;
}


}
