package Controladores;

import Modelo.TablaCalculadoraSurebets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Calculadora", urlPatterns = "/Calculadora")
public class Calculadora extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cuota1 = request.getParameter("cuota1");
        String cuota2 = request.getParameter("cuota2");
        String cuota3 = request.getParameter("cuota3");
        String cantidad = request.getParameter("cantidad");

        if (!cuota1.equals("0") && !cuota2.equals("0") && !cuota3.equals("0") && !cantidad.equals("0")) {
            double cuota1double = Double.parseDouble(cuota1);
            double cuota2double = Double.parseDouble(cuota2);
            double cuota3double = Double.parseDouble(cuota3);
            double cantidaddouble = Double.parseDouble(cantidad);

            TablaCalculadoraSurebets tablaCalculadoraSurebets = calculaProbabilidad3Cuotas(cuota1double, cuota2double, cuota3double, cantidaddouble);

            request.setAttribute("tabla", tablaCalculadoraSurebets);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Calculadora.jsp");
            requestDispatcher.forward(request,response);


        }
        if ((!cuota1.equals("0") && !cuota2.equals("0")) || (!cuota1.equals("0") && !cuota3.equals("0")) || (!cuota2.equals("0") && !cuota3.equals("0"))) {
            double cuota1double = Double.parseDouble(cuota1);
            double cuota2double = Double.parseDouble(cuota2);
            double cantidaddouble = Double.parseDouble(cantidad);

            ArrayList<Double> listaTabla = calculaProbabilidad2Cuotas(cuota1double, cuota2double, cantidaddouble);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private TablaCalculadoraSurebets calculaProbabilidad3Cuotas(double cuota1, double cuota2, double cuota3, double cantidad) {

        double porcentaje1 = (1/cuota1) * 100;
        String porcentaje1String = String.format("%.2f", porcentaje1).replace(",", ".");
        double porcentaje1recortado = Double.parseDouble(porcentaje1String);
        double porcentaje2 = (1/cuota2) * 100;
        String porcentaje2String = String.format("%.2f", porcentaje2).replace(",", ".");
        double porcentaje2recortado = Double.parseDouble(porcentaje2String);
        double porcentaje3 = (1/cuota3) * 100;
        String porcentaje3String = String.format("%.2f", porcentaje3).replace(",", ".");
        double porcentaje3recortado = Double.parseDouble(porcentaje3String);

        double porcentajefinal = (porcentaje1 + porcentaje2 + porcentaje3) * 100;

        double importe1 = ((100 * porcentaje1) / porcentajefinal) * 100;
        String importe1String = String.format("%.2f", importe1).replace(",", ".");
        double importe1recortado = Double.parseDouble(importe1String);
        double importe2 = ((100 * porcentaje2) / porcentajefinal) * 100;
        String importe2String = String.format("%.2f", importe2).replace(",", ".");
        double importe2recortado = Double.parseDouble(importe2String);
        double importe3 = ((100 * porcentaje3) / porcentajefinal) * 100;
        String importe3String = String.format("%.2f", importe3).replace(",", ".");
        double importe3recortado = Double.parseDouble(importe3String);

        double resultado = (cantidad/porcentajefinal * 100) - cantidad;
        String resultadoString = String.format("%.2f", resultado).replace(",", ".");
        double resultadorecortado = Double.parseDouble(resultadoString);

        double beneficio = ((resultado/cantidad) * 100) - 100;
        String beneficioString = String.format("%.2f", beneficio).replace(",", ".");
        double beneficiorecortado = Double.parseDouble(beneficioString);
        TablaCalculadoraSurebets tablaCalculadoraSurebets = new TablaCalculadoraSurebets(porcentaje1recortado, porcentaje2recortado, porcentaje3recortado, importe1recortado, importe2recortado, importe3recortado, resultadorecortado, beneficiorecortado, cantidad, cuota1, cuota2, cuota3);

        return tablaCalculadoraSurebets;
    }

    private ArrayList<Double> calculaProbabilidad2Cuotas(double cuota1, double cuota2, double cantidad) {
        ArrayList<Double> lista = new ArrayList<>();
        double porcentaje1 = (1/cuota1);
        lista.add(porcentaje1);
        double porcentaje2 = (1/cuota2);
        lista.add(porcentaje2);

        double porcentajefinal = (porcentaje1 + porcentaje2) * 100;
        lista.add(porcentajefinal);

        double importe1 = (100 * porcentaje1) / porcentajefinal;
        lista.add(importe1);
        double importe2 = (100 * porcentaje2) / porcentajefinal;
        lista.add(importe2);

        double resultado = cantidad/porcentajefinal * 100;
        lista.add(resultado);

        double beneficio;

        return lista;
    }

}
