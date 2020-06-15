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

        String parametro = request.getParameter("envio");

        if (parametro == null) {
            parametro = "listar";
        }

        switch (parametro) {
            case "listar":
                obtenerCuotasLaLiga(request,response);
                break;
            case "LALIGA":
                try {
                    obtenerCuotasLaLiga(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "BUNDESLIGA":
                try {
                    obtenerCuotasBundesliga(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "PREMIER":
                try {
                    obtenerCuotasPremier(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "CALCIO":
                try {
                    obtenerCuotasCalcio(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "PORTUGAL":
                try {
                    obtenerCuotasPortugal(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                obtenerCuotasLaLiga(request, response);
        }

    }

    private void obtenerCuotasBundesliga(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium = null, cuotasBetfair = null, cuotasCasinoBarcelona = null, cuotasCasinoMadrid = null, cuotasJuegging = null, cuotasGoldenPark = null, cuotasInterwetten = null, cuotasKirolbet = null, cuotasMarcaApuestas = null, cuotasMbet = null, cuotasRetabet = null, cuotasSissal = null,  cuotasSuertia = null;
        List<Cuotas> cuotasBetfairOrdenadas = null, cuotasSissalOrdenadas = null, cuotasSuertiaOrdenadas = null, cuotasKirolbetOrdenadas = null, cuotasRetabetOrdenadas = null, cuotasJueggingOrdenadas = null, cuotasCasinoBarcelonaOrdenadas = null, cuotasCasinoMadridOrdenadas = null, cuotasGoldenParkOrdenadas = null, cuotasInterwettenOrdenadas = null, cuotasMarcaApuestasOrdenadas = null, cuotasMbetOrdenadas = null;
        List<Cuotas> listaMejor = null;


           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/



            Date date = new Date();
            try {
            cuotasSportium = Sportium.parseadorSportium("sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga", date);
                listaMejor = cuotasSportium;
            } catch (Exception e) {
                System.out.println("Falla Sportium");
            }
            try {
            cuotasBetfair = Betfair.parseadorBetfair("betfair","Bundesliga", "https://www.betfair.es/sport/football?id=59&competitionEventId=605621&action=loadCompetition&modules=multipickavbId@1006&selectedTabType=COMPETITION", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);
            listaMejor = mejoresCuotas(cuotasSportium, cuotasBetfairOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {

            cuotasJuegging = Juegging.parseador ("juegging","Bundesliga", "https://apuestas.juegging.es/esp/Sport/Competicion/351", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);
            listaMejor = mejoresCuotas(listaMejor, cuotasJueggingOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);
            listaMejor = mejoresCuotas(listaMejor, cuotasInterwettenOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaapuestas","Bundesliga", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);
            listaMejor = mejoresCuotas(listaMejor, cuotasMarcaApuestasOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasMbet = Mbet.parseadorMbet("mbet","Bundesliga", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasMbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Bundesliga", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasKirolbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


           /* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*/

            cuotasSissal = Sissal.parseador ("sissal","Bundesliga", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);
            listaMejor = mejoresCuotas(listaMejor, cuotasSissalOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);
            listaMejor = mejoresCuotas(listaMejor, cuotasSuertiaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoBarcelonaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {


            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Bundesliga", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoMadridOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }


            /*cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
            cuotasGoldenParkOrdenadas = comparador(cuotasSportium, cuotasGoldenPark);
            listaMejor = mejoresCuotas(listaMejor, cuotasGoldenParkOrdenadas);*/

            for (Cuotas cuotas: listaMejor) {
                double cuota1 = cuotas.getCuota1F();
                double cuotaX = cuotas.getCuotaXF();
                double cuota2 = cuotas.getCuota2F();

                double porcenatje1 = (1/cuota1);
                double porcentajex = (1/cuotaX);
                double porcentaje2 = (1/cuota2);

                double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                double resultado = (100 /porcentajefinal * 100) - 100;

                double beneficio = (resultado/100) * 100;

                String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                cuotas.setPorcentajePagoF(porcentajefonalredondeadodouble);
            }


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
          /*  if (cuotasGoldenParkOrdenadas != null) {

                request.setAttribute("ListaCuotasGoldenPark", cuotasGoldenParkOrdenadas);
            }*/
            if (listaMejor != null) {

                request.setAttribute("ListaMejor", listaMejor);
            }

            //enviar request a jsp
            try {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
            } catch (Exception e) {

            }


    }

    private void obtenerCuotasLaLiga(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium = null, cuotasBetfair = null, cuotasCasinoBarcelona = null, cuotasCasinoMadrid = null, cuotasJuegging = null, cuotasGoldenPark = null, cuotasInterwetten = null, cuotasKirolbet = null, cuotasMarcaApuestas = null, cuotasMbet = null, cuotasRetabet = null, cuotasSissal = null,  cuotasSuertia = null;
        List<Cuotas> cuotasBetfairOrdenadas = null, cuotasSissalOrdenadas = null, cuotasSuertiaOrdenadas = null, cuotasKirolbetOrdenadas = null, cuotasRetabetOrdenadas = null, cuotasJueggingOrdenadas = null, cuotasCasinoBarcelonaOrdenadas = null, cuotasCasinoMadridOrdenadas = null, cuotasGoldenParkOrdenadas = null, cuotasInterwettenOrdenadas = null, cuotasMarcaApuestasOrdenadas = null, cuotasMbetOrdenadas = null;
        List<Cuotas> listaMejor = null;

           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/



            Date date = new Date();
            try {
                cuotasSportium = Sportium.parseadorSportium("sportium", "LaLiga", "https://sports.sportium.es/es/t/45211/La-Liga", date);
                listaMejor = cuotasSportium;
            } catch (Exception e) {
                System.out.println("Falla Sportium");
            }
            try {
            cuotasBetfair = Betfair.parseadorBetfair("betfair","LaLiga", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);
            listaMejor = mejoresCuotas(cuotasSportium, cuotasBetfairOrdenadas);
            } catch (Exception e) {
            System.out.println("Falla Betfair");
            }
            try {
            cuotasJuegging = Juegging.parseador ("juegging","LaLiga", "https://apuestas.juegging.es/esp/Sport/Competicion/1", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);
            listaMejor = mejoresCuotas(listaMejor, cuotasJueggingOrdenadas);
            } catch (Exception e) {
                System.out.println("Falla Juegging");
            }
            try {
            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","LaLiga", "https://www.interwetten.es/es/sport/leaguelist?leagueIds=1030", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);
            listaMejor = mejoresCuotas(listaMejor, cuotasInterwettenOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Interwetten");
        }
            try {
            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaapuestas","LaLiga", "https://deportes.marcaapuestas.es/es/t/19160/LaLiga-Santander", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);
            listaMejor = mejoresCuotas(listaMejor, cuotasMarcaApuestasOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla MarcaApuesta");
        }
try {
            cuotasMbet = Mbet.parseadorMbet("mbet","LaLiga", "https://www.marathonbet.es/es/popular/Football/Spain/Primera+Division+-+8736", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasMbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Mbet");
        }
try {

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","LaLiga", "https://apuestas.kirolbet.es/esp/Sport/Competicion/1", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasKirolbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Kirolbet");
        }

           /* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*/
           try {

            cuotasSissal = Sissal.parseador ("sissal","LaLiga", "https://apuestas.sisal.es/es/competicion/306-primera-division", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);
            listaMejor = mejoresCuotas(listaMejor, cuotasSissalOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Sissal");
        }

           try {
            cuotasSuertia =  Suertia.parseadorSuertia("suertia","LaLiga", "https://apuestas.suertia.es/competicion/306-primera-division", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);
            listaMejor = mejoresCuotas(listaMejor, cuotasSuertiaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Suertia");
        }
            try {
            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","LaLiga", "https://apuestas.casinobarcelona.es/competicion/306-primera-division", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoBarcelonaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla CasinoBarcelona");
        }
            try {
            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","LaLiga", "https://apuestas.casinogranmadridonline.es/es/futbol/espana/306-primera-division", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoMadridOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla CasinoMadrid");
    }

            /*cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","LaLiga", "https://apuestas.goldenpark.es/es/competicion/306-primera-division", date);
            cuotasGoldenParkOrdenadas = comparador(cuotasSportium, cuotasGoldenPark);
            listaMejor = mejoresCuotas(listaMejor, cuotasGoldenParkOrdenadas);
*/
            for (Cuotas cuotas: listaMejor) {
                double cuota1 = cuotas.getCuota1F();
                double cuotaX = cuotas.getCuotaXF();
                double cuota2 = cuotas.getCuota2F();

                double porcenatje1 = (1/cuota1);
                double porcentajex = (1/cuotaX);
                double porcentaje2 = (1/cuota2);

                double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
                double resultado = (100 /porcentajefinal * 100) - 100;

                double beneficio = (resultado/100) * 100;

                String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
                double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

                cuotas.setPorcentajePagoF(porcentajefonalredondeadodouble);
            }


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
           /* if (cuotasGoldenParkOrdenadas != null) {

                request.setAttribute("ListaCuotasGoldenPark", cuotasGoldenParkOrdenadas);
            }*/
            if (listaMejor != null) {

                request.setAttribute("ListaMejor", listaMejor);
            }

            //enviar request a jsp
            try {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void obtenerCuotasPremier(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium = null, cuotasBetfair = null, cuotasCasinoBarcelona = null, cuotasCasinoMadrid = null, cuotasJuegging = null, cuotasGoldenPark = null, cuotasInterwetten = null, cuotasKirolbet = null, cuotasMarcaApuestas = null, cuotasMbet = null, cuotasRetabet = null, cuotasSissal = null,  cuotasSuertia = null;
        List<Cuotas> cuotasBetfairOrdenadas = null, cuotasSissalOrdenadas = null, cuotasSuertiaOrdenadas = null, cuotasKirolbetOrdenadas = null, cuotasRetabetOrdenadas = null, cuotasJueggingOrdenadas = null, cuotasCasinoBarcelonaOrdenadas = null, cuotasCasinoMadridOrdenadas = null, cuotasGoldenParkOrdenadas = null, cuotasInterwettenOrdenadas = null, cuotasMarcaApuestasOrdenadas = null, cuotasMbetOrdenadas = null;
        List<Cuotas> listaMejor = null;


           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/



            Date date = new Date();
            try {
            cuotasSportium = Sportium.parseadorSportium("sportium","Premier", "https://sports.sportium.es/es/t/40527/Premier-League", date);
        listaMejor = cuotasSportium;
    } catch (Exception e) {
        System.out.println("Falla Sportium");
    }
try {
            cuotasBetfair = Betfair.parseadorBetfair("betfair","Premier", "https://www.betfair.es/sport/football/premier-league-inglesa/10932509", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);
        listaMejor = mejoresCuotas(listaMejor, cuotasBetfairOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Betfair");
    }
            try {

            cuotasJuegging = Juegging.parseador ("juegging","Premier", "https://apuestas.juegging.es/esp/Sport/Competicion/341", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);
        listaMejor = mejoresCuotas(listaMejor, cuotasJueggingOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Juegging");
    }
            try {

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Premier", "https://www.interwetten.es/es/sport/leaguelist?leagueIds=1021", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);
        listaMejor = mejoresCuotas(listaMejor, cuotasInterwettenOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Interwetten");
    }
            try {

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaapuestas","Premier", "https://deportes.marcaapuestas.es/es/t/19157/Inglaterra-Premier-League", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);
        listaMejor = mejoresCuotas(listaMejor, cuotasMarcaApuestasOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla MarcaApuestas");
    }
            try {

            cuotasMbet = Mbet.parseadorMbet("mbet","Premier", "https://www.marathonbet.es/es/popular/Football/England/Premier+League+-+21520", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);
        listaMejor = mejoresCuotas(listaMejor, cuotasMbetOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Mbet");
    }
            try {

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Premier", "https://apuestas.kirolbet.es/esp/Sport/Competicion/341", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);
        listaMejor = mejoresCuotas(listaMejor, cuotasKirolbetOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Kirolbet");
    }
            try {

           /* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*/

            cuotasSissal = Sissal.parseador ("sissal","Premier", "https://apuestas.sisal.es/es/competicion/94-premier-league", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);
        listaMejor = mejoresCuotas(listaMejor, cuotasSissalOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Sissal");
    }
            try {

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Premier", "https://apuestas.suertia.es/competicion/94-premier-league", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);
        listaMejor = mejoresCuotas(listaMejor, cuotasSuertiaOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla Suertia");
    }
            try {

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Premier", "https://apuestas.casinobarcelona.es/competicion/94-premier-league", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);
        listaMejor = mejoresCuotas(listaMejor, cuotasCasinoBarcelonaOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla CasinoBarcelona");
    }
            try {

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Premier", "https://apuestas.casinogranmadridonline.es/es/futbol/inglaterra/94-premier-league", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);
        listaMejor = mejoresCuotas(listaMejor, cuotasCasinoMadridOrdenadas);
    } catch (Exception e) {
        System.out.println("Falla CasinoMadrid");
    }


            /*cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Premier", "https://apuestas.goldenpark.es/es/competicion/94-premier-league", date);
            cuotasGoldenParkOrdenadas = comparador(cuotasSportium, cuotasGoldenPark);*/
        for (Cuotas cuotas: listaMejor) {
            double cuota1 = cuotas.getCuota1F();
            double cuotaX = cuotas.getCuotaXF();
            double cuota2 = cuotas.getCuota2F();

            double porcenatje1 = (1/cuota1);
            double porcentajex = (1/cuotaX);
            double porcentaje2 = (1/cuota2);

            double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
            double resultado = (100 /porcentajefinal * 100) - 100;

            double beneficio = (resultado/100) * 100;

            String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
            double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

            cuotas.setPorcentajePagoF(porcentajefonalredondeadodouble);
        }


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
           /* if (cuotasGoldenParkOrdenadas != null) {

                request.setAttribute("ListaCuotasGoldenPark", cuotasGoldenParkOrdenadas);
            }*/

            //enviar request a jsp
        if (listaMejor != null) {

            request.setAttribute("ListaMejor", listaMejor);
        }
        try  {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtenerCuotasCalcio(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium = null, cuotasBetfair = null, cuotasCasinoBarcelona = null, cuotasCasinoMadrid = null, cuotasJuegging = null, cuotasGoldenPark = null, cuotasInterwetten = null, cuotasKirolbet = null, cuotasMarcaApuestas = null, cuotasMbet = null, cuotasRetabet = null, cuotasSissal = null, cuotasSuertia = null;
        List<Cuotas> cuotasBetfairOrdenadas = null, cuotasSissalOrdenadas = null, cuotasSuertiaOrdenadas = null, cuotasKirolbetOrdenadas = null, cuotasRetabetOrdenadas = null, cuotasJueggingOrdenadas = null, cuotasCasinoBarcelonaOrdenadas = null, cuotasCasinoMadridOrdenadas = null, cuotasGoldenParkOrdenadas = null, cuotasInterwettenOrdenadas = null, cuotasMarcaApuestasOrdenadas = null, cuotasMbetOrdenadas = null;
        List<Cuotas> listaMejor = null;


           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/


        Date date = new Date();
        try {
            cuotasSportium = Sportium.parseadorSportium("sportium", "Calcio", "https://sports.sportium.es/es/t/44571/Serie-A", date);
            listaMejor = cuotasSportium;
        } catch (Exception e) {
            System.out.println("Falla Sportium");
        }

        try {
            cuotasBetfair = Betfair.parseadorBetfair("betfair", "Calcio", "https://www.betfair.es/sport/football/serie-a-italiana/81", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);
            listaMejor = mejoresCuotas(cuotasSportium, cuotasBetfairOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Betfair");
        }
        try {
            cuotasJuegging = Juegging.parseador("juegging", "Calcio", "https://apuestas.juegging.es/esp/Sport/Competicion/352", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);
            listaMejor = mejoresCuotas(listaMejor, cuotasJueggingOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Juegging");
        }
        try {
            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten", "Calcio", "https://www.interwetten.es/es/sport/leaguelist?leagueIds=1029", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);
            listaMejor = mejoresCuotas(listaMejor, cuotasInterwettenOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Interwetten");
        }
        try {
            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaapuestas", "Calcio", "https://deportes.marcaapuestas.es/es/t/19159/Serie-A", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);
            listaMejor = mejoresCuotas(listaMejor, cuotasMarcaApuestasOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla MarcaApuestas");
        }
        try {
            cuotasMbet = Mbet.parseadorMbet("mbet", "Calcio", "https://www.marathonbet.es/es/popular/Football/Italy/Serie+A+-+22434", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasMbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Mbet");
        }
        try {
            cuotasKirolbet = Kirolbet.parseador("kirolbet", "Calcio", "https://apuestas.kirolbet.es/esp/Sport/Competicion/352", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);
            listaMejor = mejoresCuotas(listaMejor, cuotasKirolbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Kirolbet");
        }


           /* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*/
        try {
            cuotasSissal = Sissal.parseador("sissal", "Calcio", "https://apuestas.sisal.es/es/competicion/305-serie-a", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);
            listaMejor = mejoresCuotas(listaMejor, cuotasKirolbetOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Kirolbet");
        }
        try {
            cuotasSuertia = Suertia.parseadorSuertia("suertia", "Calcio", "https://apuestas.suertia.es/competicion/305-serie-a", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);
            listaMejor = mejoresCuotas(listaMejor, cuotasSuertiaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla Suertia");
        }
        try {
            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona", "Calcio", "https://apuestas.casinobarcelona.es/competicion/305-serie-a", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoBarcelonaOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla CasinoBarcelona");
        }
        try {
            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid", "Calcio", "https://apuestas.casinogranmadridonline.es/es/futbol/italia/305-serie-a", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);
            listaMejor = mejoresCuotas(listaMejor, cuotasCasinoMadridOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla CasinoMadrid");
        }
       /* try {
            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark", "Calcio", "https://apuestas.goldenpark.es/es/competicion/305-serie-a", date);
            cuotasGoldenParkOrdenadas = comparador(cuotasSportium, cuotasGoldenPark);
            listaMejor = mejoresCuotas(listaMejor, cuotasGoldenParkOrdenadas);
        } catch (Exception e) {
            System.out.println("Falla GoldenPark");
        }*/

        for (Cuotas cuotas: listaMejor) {
            double cuota1 = cuotas.getCuota1F();
            double cuotaX = cuotas.getCuotaXF();
            double cuota2 = cuotas.getCuota2F();

            double porcenatje1 = (1/cuota1);
            double porcentajex = (1/cuotaX);
            double porcentaje2 = (1/cuota2);

            double porcentajefinal = (porcenatje1 + porcentajex + porcentaje2) * 100;
            double resultado = (100 /porcentajefinal * 100) - 100;

            double beneficio = (resultado/100) * 100;

            String porcentajefinalredondeado = String.format("%.2f", beneficio).replace(",", ".");
            double porcentajefonalredondeadodouble = Double.parseDouble(porcentajefinalredondeado);

            cuotas.setPorcentajePagoF(porcentajefonalredondeadodouble);
        }

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

            request.setAttribute("ListaCuotasMbet", cuotasMbetOrdenadas);
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
      /*  if (cuotasGoldenParkOrdenadas != null) {

            request.setAttribute("ListaCuotasGoldenPark", cuotasGoldenParkOrdenadas);
        }*/
        if (listaMejor != null) {

            request.setAttribute("ListaMejor", listaMejor);
        }

        //enviar request a jsp
        try {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* private void obtenerCuotasLaLigaLigue1(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           *//* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*//*



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("sportium","Ligue1", "https://sports.sportium.es/es/t/45211/La-Liga", date);

            cuotasBetfair = Betfair.parseadorBetfair("betfair","Ligue1", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("juegging","Ligue1", "https://apuestas.juegging.es/esp/Sport/Competicion/1", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Ligue1", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaApuestas","Ligue1", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("mbet","Ligue1", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Ligue1", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

           *//* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*//*

            cuotasSissal = Sissal.parseador ("sissal","Ligue1", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Ligue1", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Ligue1", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Ligue1", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Ligue1", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
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
          *//*  if (cuotasRetabetOrdenadas != null) {

                request.setAttribute("ListaCuotasRetabet", cuotasRetabetOrdenadas);
            }*//*
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
    }*/

  /*  private void obtenerCuotasEredivise(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           *//* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*//*



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("sportium","Eredivise", "https://sports.sportium.es/es/t/45211/La-Liga", date);

            cuotasBetfair = Betfair.parseadorBetfair("betfair","Eredivise", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("juegging","Eredivise", "https://apuestas.juegging.es/esp/Sport/Competicion/1", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Eredivise", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaApuestas","Eredivise", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("mbet","Eredivise", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Eredivise", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

           *//* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*//*

            cuotasSissal = Sissal.parseador ("sissal","Eredivise", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Eredivise", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Eredivise", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Eredivise", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Eredivise", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
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
          *//*  if (cuotasRetabetOrdenadas != null) {

                request.setAttribute("ListaCuotasRetabet", cuotasRetabetOrdenadas);
            }*//*
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
    }*/

    private void obtenerCuotasPortugal(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("sportium","Portugal", "https://sports.sportium.es/es/t/44979/Primeira-Liga", date);

            cuotasBetfair = Betfair.parseadorBetfair("betfair","Portugal", "https://www.betfair.es/sport/football/primeira-liga-portuguesa/99", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("juegging","Portugal", "https://apuestas.juegging.es/esp/Sport/Competicion/521", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Portugal", "https://www.interwetten.es/es/sport/leaguelist?leagueIds=10598", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaapuestas","Portugal", "https://deportes.marcaapuestas.es/es/t/19211/Portugal-Primeira-Liga", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("mbet","Portugal", "https://www.marathonbet.es/es/popular/Football/Portugal/Primeira+Liga+-+43058", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Portugal", "https://apuestas.kirolbet.es/esp/Sport/Competicion/521", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

           /* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*/

            cuotasSissal = Sissal.parseador ("sissal","Portugal", "https://apuestas.sisal.es/es/competicion/154-primeira-liga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Portugal", "https://apuestas.suertia.es/competicion/154-primeira-liga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Portugal", "https://apuestas.casinobarcelona.es/competicion/154-primeira-liga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Portugal", "https://apuestas.casinogranmadridonline.es/es/futbol/portugal/154-primeira-liga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Portugal", "https://apuestas.goldenpark.es/es/competicion/154-primeira-liga", date);
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

   /* private void obtenerCuotasChampions(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           *//* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*//*



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("sportium","Champions", "https://sports.sportium.es/es/t/45211/La-Liga", date);

            cuotasBetfair = Betfair.parseadorBetfair("betfair","Champions", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("juegging","Champions", "https://apuestas.juegging.es/esp/Sport/Competicion/1", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","Champions", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaApuestas","Champions", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("mbet","Champions", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","Champions", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

           *//* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*//*

            cuotasSissal = Sissal.parseador ("sissal","Champions", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","Champions", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","Champions", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","Champions", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","Champions", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
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
          *//*  if (cuotasRetabetOrdenadas != null) {

                request.setAttribute("ListaCuotasRetabet", cuotasRetabetOrdenadas);
            }*//*
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

    private void obtenerCuotasEuropaLeague(HttpServletRequest request, HttpServletResponse response) {

        //  obtener la lista de productos del modelo

        List<Cuotas> cuotasSportium, cuotasBetfair, cuotasCasinoBarcelona, cuotasCasinoMadrid, cuotasJuegging, cuotasGoldenPark, cuotasInterwetten, cuotasKirolbet, cuotasMarcaApuestas, cuotasMbet, cuotasRetabet, cuotasSissal,  cuotasSuertia;
        List<Cuotas> cuotasBetfairOrdenadas, cuotasSissalOrdenadas, cuotasSuertiaOrdenadas, cuotasKirolbetOrdenadas, cuotasRetabetOrdenadas, cuotasJueggingOrdenadas, cuotasCasinoBarcelonaOrdenadas, cuotasCasinoMadridOrdenadas, cuotasGoldenParkOrdenadas, cuotasInterwettenOrdenadas, cuotasMarcaApuestasOrdenadas, cuotasMbetOrdenadas;


        try {
           *//* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*//*



            Date date = new Date();
            cuotasSportium = Sportium.parseadorSportium("sportium","EuropaLeague", "https://sports.sportium.es/es/t/45211/La-Liga", date);

            cuotasBetfair = Betfair.parseadorBetfair("betfair","EuropaLeague", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117", date);
            cuotasBetfairOrdenadas = comparador(cuotasSportium, cuotasBetfair);

            cuotasJuegging = Juegging.parseador ("juegging","EuropaLeague", "https://apuestas.juegging.es/esp/Sport/Competicion/1", date);
            cuotasJueggingOrdenadas = comparador(cuotasSportium, cuotasJuegging);

            cuotasInterwetten = Interwetten.parseadorInterwetten("interwetten","EuropaLeague", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
            cuotasInterwettenOrdenadas = comparador(cuotasSportium, cuotasInterwetten);

            cuotasMarcaApuestas = MarcaApuestas.parseadorMarca("marcaApuestas","EuropaLeague", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV", date);
            cuotasMarcaApuestasOrdenadas = comparador(cuotasSportium, cuotasMarcaApuestas);

            cuotasMbet = Mbet.parseadorMbet("mbet","EuropaLeague", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
            cuotasMbetOrdenadas = comparador(cuotasSportium, cuotasMbet);

            cuotasKirolbet = Kirolbet.parseador ("kirolbet","EuropaLeague", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
            cuotasKirolbetOrdenadas = comparador(cuotasSportium, cuotasKirolbet);

           *//* cuotasRetabet = Retabet.parseador ("retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
            cuotasRetabetOrdenadas = comparador(cuotasSportium, cuotasRetabet);*//*

            cuotasSissal = Sissal.parseador ("sissal","EuropaLeague", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
            cuotasSissalOrdenadas = comparador(cuotasSportium, cuotasSissal);

            cuotasSuertia =  Suertia.parseadorSuertia("suertia","EuropaLeague", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
            cuotasSuertiaOrdenadas = comparador(cuotasSportium, cuotasSuertia);

            cuotasCasinoBarcelona = CasinoBarcelona.parseadorBarcelona("casinobarcelona","EuropaLeague", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
            cuotasCasinoBarcelonaOrdenadas = comparador(cuotasSportium, cuotasCasinoBarcelona);

            cuotasCasinoMadrid = CasinoMadrid.parseadorMadrid("casinomadrid","EuropaLeague", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
            cuotasCasinoMadridOrdenadas = comparador(cuotasSportium, cuotasCasinoMadrid);

            cuotasGoldenPark = GoldenPark.parseadorGolden("goldenpark","EuropaLeague", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
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
          *//*  if (cuotasRetabetOrdenadas != null) {

                request.setAttribute("ListaCuotasRetabet", cuotasRetabetOrdenadas);
            }*//*
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
    }*/


    private List<Cuotas> comparador(List<Cuotas> listaSportium , List<Cuotas> listaAOrdenar ){
        List<Cuotas> cuotasOrdenadas = new ArrayList<>();
        //    List<Cuotas> mejoresCuotas = new ArrayList<>();
        for (Cuotas cuotas : listaSportium) {
            String nombreequipo1 = cuotas.getNombreEquipo1();
            String nombreequipo2 = cuotas.getNombreEquipo2();
          /*  double cuota1 = Double.parseDouble(cuotas.getCuota1());
            double cuotaX = Double.parseDouble(cuotas.getCuotaX());
            double cuota2 = Double.parseDouble(cuotas.getCuota2());*/
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

    private List<Cuotas> mejoresCuotas(List<Cuotas> listaSportium , List<Cuotas> listaAComparar ){
        List<Cuotas> mejoresCuotas = new ArrayList<>();
        for (int i = 0; i <= listaSportium.size() -1; i++) {

            double cuota1a = listaSportium.get(i).getCuota1F();
            double cuotaXa = listaSportium.get(i).getCuotaXF();
            double cuota2a = listaSportium.get(i).getCuota2F();
            double mejorCuota1;
            double mejorCuotaX;
            double mejorCuota2;
            try {
                double cuota1 = Double.parseDouble(listaAComparar.get(i).getCuota1());
                double cuotaX = Double.parseDouble(listaAComparar.get(i).getCuotaX());
                double cuota2 = Double.parseDouble(listaAComparar.get(i).getCuota2());




            if (cuota1a < cuota1) {
             mejorCuota1 = cuota1;
            }   else {
                mejorCuota1 = cuota1a;
            }

            if (cuotaXa < cuotaX) {
                mejorCuotaX = cuotaX;
            }   else {
                mejorCuotaX = cuotaXa;
            }

            if (cuota2a < cuota2) {
                mejorCuota2 = cuota2;
            }   else {
                mejorCuota2 = cuota2a;
            }

            } catch (Exception e) {
                mejorCuota1 = cuota1a;
                mejorCuotaX = cuotaXa;
                mejorCuota2 = cuota2a;
            }

            mejoresCuotas.add(new Cuotas(mejorCuota1, mejorCuotaX, mejorCuota2));

        }

        return mejoresCuotas;
    }

}
