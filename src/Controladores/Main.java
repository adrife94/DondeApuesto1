package Controladores;

import BaseDatos.Sportium;
import Modelo.Cuotas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        List<Cuotas> cuotas;

        Sportium sportiumLaLiga = new Sportium();

        try {
           /* System.setProperty("javax.net.ssl.keyStore", "C://Program Files//Apache Software Foundation//Tomcat 9.0//cert//keys");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");*/
            cuotas = Sportium.parseadorSportium("Sportium","LaLiga", "https://sports.sportium.es/es/t/45915/Bundesliga");

            //agregar la lista al request

            if (cuotas != null) {

                request.setAttribute("ListaCuotas", cuotas);
            }

            //enviar request a jsp

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
