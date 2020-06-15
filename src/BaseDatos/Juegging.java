package BaseDatos;

import Modelo.Cuotas;
import Modelo.EstandarizadorNombresJuegging;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Juegging {
    public static List<Cuotas> parseador(String casa, String liga, String url, Date date) {
        PostgreSqlConexion postgreSqlConexion = new PostgreSqlConexion(casa);
        EventoBaseDatos eventoBaseDatos = new EventoBaseDatos(postgreSqlConexion);
        List<Cuotas> lista = null;
        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            Elements eventos = betfairLaLiga.getElementsByClass("filtroCategoria filtroCat-40");
            Elements equipos = eventos.select("span[class=partido]");
            Elements cuo = eventos.select("ul[des=1X2]").select("span[class=coef]");
         //   Elements cuotas = cuo.select("span[class=coef]");
            lista = new ArrayList<>();

            ArrayList<String> listaPartidos = new ArrayList<>();

            ArrayList<String> listaCuotas = new ArrayList<>();

            String cuota1a, cuota2a, cuota3a;



            for (int i = 0; i < eventos.size(); i++) {
                try {
                    cuota1a = eventos.get(i).select("ul[des=1X2]").select("span[class=coef]").get(0).text();
                    cuota2a = eventos.get(i).select("ul[des=1X2]").select("span[class=coef]").get(1).text();
                    cuota3a = eventos.get(i).select("ul[des=1X2]").select("span[class=coef]").get(2).text();
                    String e = cuo.get(i).text();
                    String cuota = cuo.get(i).text();
                } catch (Exception e) {
                    cuota1a = "";
                    cuota2a = "";
                    cuota3a = "";
                }
                listaCuotas.add(cuota1a);
                listaCuotas.add(cuota2a);
                listaCuotas.add(cuota3a);
                String equipo = equipos.get(i).text();
                String equiposs = equipos.get(i).text();
                int num = equipo.indexOf("vs.");
                int num2 = equipo.indexOf("(+");
                String equipolocal = equipo.substring(0, num - 1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                }

                String b = equiposs.substring(num + 4,num2 -1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(b);
                        listaPartidos.add(equipo);
                        break;
                }
            }

          /*  ArrayList<String> listaPartidos = new ArrayList<>();
            for (Element element : equipos) {
                String equipo = element.text();
                String equiposs = element.text();
                int num = equipo.indexOf("vs.");
                int num2 = equipo.indexOf("(+");
                String equipolocal = equipo.substring(0, num - 1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(equipolocal);
                        listaPartidos.add(equipo);
                        break;
                }

                String b = equiposs.substring(num + 4,num2 -1);
                switch (liga) {
                    case "LaLiga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLaLiga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Bundesliga":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposBundesliga(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Premier":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPremier(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Calcio":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposCalcio(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Eredivise":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposEredivise(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Ligue1":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposLigue1(b);
                        listaPartidos.add(equipo);
                        break;
                    case "Primeira":
                        equipo = EstandarizadorNombresJuegging.estandarizadorEquiposPrimeira(b);
                        listaPartidos.add(equipo);
                        break;
                }

            }


            ArrayList<String> listaCuotas = new ArrayList<>();
            for (Element element : cuotas) {
                String cuota = element.text();
                listaCuotas.add(cuota);


            }*/

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;

            double cuota1double = 0;
            double cuotaxdouble = 0;
            double cuota2double = 0;
            double porcentajefonalredondeadodouble = 0;
            String porcentajefinalredondeado = "";



            if (listaPartidos.size() != 0) {
                for (int i = 0; i < (listaPartidos.size() / 2) ; i++) {
                    String cuota1 = listaCuotas.get(c).replace(",", ".");
                    String cuotax = listaCuotas.get(d).replace(",", ".");
                    String cuota2 = listaCuotas.get(e).replace(",", ".");

                    try {

                    cuota1double = Double.parseDouble(cuota1);
                    cuotaxdouble = Double.parseDouble(cuotax);
                    cuota2double = Double.parseDouble(cuota2);

                    double porcenatje1 = (1 / cuota1double);
                    double porcentajex = (1 / cuotaxdouble);
                    double porcentaje2 = (1 / cuota2double);

                    double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;

                    double resultado = (100 /porcentajefinal * 100) - 100;

                    double beneficio = (resultado/100) * 100;

                    porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                    porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                    } catch (Exception es) {
                    cuota1 = "-";
                    cuota2 = "-";
                    cuotax = "-";
                    porcentajefinalredondeado = "-";
                    }

                    eventoBaseDatos.crearTabla(listaPartidos.get(a).replace(" ", ""), listaPartidos.get(b).replace(" ", ""));

                    Cuotas cuotass = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), date, cuota1double, cuotaxdouble, cuota2double, porcentajefonalredondeadodouble, liga, "2019-2020" );

                    eventoBaseDatos.InsertarCuotas(cuotass, listaPartidos.get(a), listaPartidos.get(b));


                    Cuotas cuota = new Cuotas(listaPartidos.get(a), listaPartidos.get(b), cuota1, cuotax, cuota2,  porcentajefinalredondeado.replace(",", "."));
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
