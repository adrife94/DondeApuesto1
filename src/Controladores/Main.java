package Controladores;

import BaseDatos.*;
import Modelo.Cuotas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = "/Main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parametro = request.getParameter("instruccion");

        if (parametro == null) {
            parametro = "listar";
        }

        switch (parametro) {
            case "listar":
                obtenerCuotas(request,response);
                break;
            /*case "insertarBBDD":
                try {
                    agregarProductos(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "cargar":
                try {
                    cargarProductos(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "actualizarBBDD":
                try {
                    actualizaProductos(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "borrar":
                try {
                    eliminarProductos(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;*/
            default:
                obtenerCuotas(request, response);
        }
    }

    private void obtenerCuotas(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("Sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga", date);

            cuotasBetfair = Betfair.parseadorBetfair("Betfair","Bundesliga", "https://www.betfair.es/sport/football?id=59&competitionEventId=605621&action=loadCompetition&modules=multipickavbId@1006&selectedTabType=COMPETITION", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("Juegging","Bundesliga", "https://apuestas.juegging.es/esp/Sport/Competicion/351");
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("Interwetten","Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional");
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("MarcaApuestas","Bundesliga", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV");
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("Mbet","Bundesliga", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436");
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("Kirolbet","Bundesliga", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351");
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

            cuotasRetabet = Retabet.parseador ("Retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);

            cuotasSissal = Sissal.parseador ("Sissal","Bundesliga", "https://apuestas.sisal.es/es/competicion/268-bundesliga");
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("Suertia","Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga");
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("CasinoBarcelona","Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga");
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("CasinoMadrid","Bundesliga", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga");
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("GoldenPark","Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#");
            cuotasGoldenParkOrdenadas = comparador(cuotasSportium, cuotasGoldenPark);


            //agregar la lista al request
            if (cuotasSportium != null) {

                request.setAttribute("ListaCuotasSportium", cuotasSportium);
            }
            if (cuotasBetfairOrdenadas != null) {

                request.setAttribute("ListaCuotasBetfair", cuotasBetfairOrdenadas);
            }
            if (cuotasJueggingOrdenadas != null) {

                request.setAttribute("ListaCuotasJuegging", cuotasJueggingOrdenadas);
            }
            if (cuotasInterwettenOrdenadas != null) {

                request.setAttribute("ListaCuotasInterwetten", cuotasInterwettenOrdenadas);
            }
            if (cuotasMbetOrdenadas != null) {

                request.setAttribute("ListaCuotasMbet", cuotasMbetOrdenadas );
            }
            if (cuotasMarcaApuestasOrdenadas != null) {

                request.setAttribute("ListaCuotasMarcaApuestas", cuotasMarcaApuestasOrdenadas);
            }
            if (cuotasKirolbetOrdenadas != null) {

                request.setAttribute("ListaCuotasKirolbet", cuotasKirolbetOrdenadas);
            }
          /*  if (cuotasRetabetOrdenadas != null) {

                request.setAttribute("ListaCuotasRetabet", cuotasRetabetOrdenadas);
            }*/
            if (cuotasSuertiaOrdenadas != null) {

                request.setAttribute("ListaCuotasSuertia", cuotasSuertiaOrdenadas);
            }

            if (cuotasSissalOrdenadas != null) {

                request.setAttribute("ListaCuotasSissal", cuotasSissalOrdenadas);
            }
            if (cuotasCasinoBarcelonaOrdenadas != null) {

                request.setAttribute("ListaCuotasCasinoBarcelona", cuotasCasinoBarcelonaOrdenadas);
            }
            if (cuotasCasinoMadridOrdenadas != null) {

                request.setAttribute("ListaCuotasCasinoMadrid", cuotasCasinoMadridOrdenadas);
            }
            if (cuotasGoldenParkOrdenadas != null) {

                request.setAttribute("ListaCuotasGoldenPark", cuotasGoldenParkOrdenadas);
            }

            //enviar request a jsp

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Cuotas> comparador(List<Cuotas> listaSportium , List<Cuotas> listaAOrdenar ){
        List<Cuotas> cuotasOrdenadas = new ArrayList<>();
        for (Cuotas cuotas : listaSportium) {
            String nombreequipo1 = cuotas.getNombreEquipo1();
            String nombreequipo2 = cuotas.getNombreEquipo2();
            for (Cuotas cuotass : listaAOrdenar) {
                if (cuotass.getNombreEquipo1().equals(nombreequipo1) && cuotass.getNombreEquipo2().equals(nombreequipo2)) {
                  cuotasOrdenadas.add(cuotass);
                  listaAOrdenar.remove(cuotass);
                  break;
                }

            }

        }

        return cuotasOrdenadas;
    }

}
