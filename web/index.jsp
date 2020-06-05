<%@ page import="Modelo.Cuotas" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <link href="css/estilos.css" rel="stylesheet" >
  <script
          src="https://code.jquery.com/jquery-3.5.1.js"
          integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
          crossorigin="anonymous">

  </script>

  <%
    ArrayList<Cuotas> cuotasSportium= (ArrayList<Cuotas>) request.getAttribute("ListaCuotasSportium");
    ArrayList<Cuotas> cuotasBetfair = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasBetfair");
    ArrayList<Cuotas> cuotasJuegging = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasJuegging");
    ArrayList<Cuotas> cuotasInterwetten = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasInterwetten");
    ArrayList<Cuotas> cuotasMbet = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasMbet");
    ArrayList<Cuotas> cuotasRetabet = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasRetabet");
    ArrayList<Cuotas> cuotasSuertia = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasSuertia");
    ArrayList<Cuotas> cuotasSissal = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasSissal");
    ArrayList<Cuotas> cuotasMarcaApuestas = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasMarcaApuestas");
    ArrayList<Cuotas> cuotasKirolbet = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasKirolbet");
    ArrayList<Cuotas> cuotasCasinoBarcelona = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasCasinoBarcelona");
    ArrayList<Cuotas> cuotasCasinoMadrid = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasCasinoMadrid");
    ArrayList<Cuotas> cuotasGoldenPark = (ArrayList<Cuotas>) request.getAttribute("ListaCuotasGoldenPark");

  %>
  <%--   <script>
      $(document).ready(function () {
        function cambiar_atributo() {
          $(".tablaCuotas").addClass("tablaCuotaBetfair");
          alert("¿Eres mayor de 18 años?");
        }
      });
  cript>
    <%-- <script>

    alert("¿Eres mayor de 18 años?")  Para añadir el cuadro de la evolucion de la cuota mirar JavaScriptPildoras en la clase JQueryReemplazareliminarcontendo

  </script>--%>
</head>
<body>
<div id="contenedorBarraSuperior">





  <div class="topnav">
    <a href="#Login">Login</a>
    <a href="registro.html">Registrar</a>
    <a class="active" href="#home">Estadisticas</a>
    <a href="#CasasApuestas">Casas de Apuestas</a>
    <a href="#Bonos">Bonos</a>
    <a href="#Rankings">Rankings</a>
    <a href="#Consejos">Consejos</a>
    <a href="Calculadora.jsp">Calculadora Surebets</a>

    <div id="contenedorLogo">
      <img id="logo" src="imagenes/Dondeapuesto.png" >
    </div>
  </div>
</div>

<%--<nav>
  <ul class="nav">
    <li><a href= "https://es.wikipedia.org/wiki/Canberra"></a>Comparacion</li>
    <li><a href= "tablaBwin.html">BWIN</a></li>
    <li><a href= "tablaBet365.html">Bet365</a></li>
    <li><a href= "tablaSportium.html">Sportium</a></li>
    <li><a href= "tablaSuertia.html">Suertia</a></li>
    <li><a href= "TablaCuotasCasas/888Sport.jsp">888Sport</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/S%C3%ADdney">Retabet</a></li>
    <li><a href= "tablaCodere.html">Codere</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/Melbourne">CasinoBarcelona</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/S%C3%ADdney">CasinoMadrid</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/Melbourne">Luckia</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/S%C3%ADdney">Interwetten</a></li>
    <li><a href= "https://es.wikipedia.org/wiki/Melbourne">GoldenPark</a></li>

  </ul>
</nav>--%>


<table class="botonesCasas">

  <td><input type="submit" value="LALIGA" id="laliga" name="envio"/>
  <td><input type="submit" value="PREMIER" id="premier" name="envio"/>
  <td><input type="submit" value="BUNDESLIGA" id="bundesliga" name="envio"/>
  <td><input type="submit" value="CALCIO" id="calcio" name="envio"/>
  <td><input type="submit" value="LIGUE1" id="ligue1" name="envio"/>
  <td><input type="submit" value="EREDIVISE" id="eredivise" name="envio"/>
  <td><input type="submit" value="PORTUGAL" id="portugal" name="envio"/>
  <td><input type="submit" value="CHAMPIONS" id="champions" name="envio"/>
  <td><input type="submit" value="EUROPA" id="europa" name="envio"/>
</table>


<div id="contenedorTablacentral">


    <div id="PrimeraColumna">
      <%
      if(cuotasSportium!= null) {
        for (int i = 0; i <= cuotasSportium.size()-1; i++) {

    %>
  <table id="tablacentral1X2">
    <%
      if(i==0) {
    %>
    <thead>
    <tr>

      <th>-</th>

    </tr>
    </thead>
    <%
      }
    %>
    <tbody>
    <tr>
      <td>
        1
      </td>
    </tr>
    <tr>
      <td>
        X
      </td>
    </tr>
    <tr>
      <td>
        2
      </td>
    </tr>
    <tr>
      <td>
        %
      </td>
    </tr>


    </tbody>
  </table>
      <%
          }
        }
      %>
    </div>


   <div id="SegundaColumnaEquipos">
     <%
       if(cuotasSportium!= null) {
         for (int i = 0; i <= cuotasSportium.size()-1; i++) {

     %>
    <table class="tablaEquipos">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>

        <th>Equipos</th>

      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasSportium.get(i).getNombreEquipo1()%>
        </td>
      </tr>
      <tr>
        <td>
          X
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSportium.get(i).getNombreEquipo2()%>
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>

      </tbody>
    </table>
     <%
       }
       }
     %>

    </div>
    <div id="TerceraColumnaDate">
      <%
        if(cuotasSportium!= null) {
          for (int i = 0; i <= cuotasSportium.size()-1; i++) {

      %>

    <table class="tablaHoraFecha">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>

        <th>Fecha</th>

      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          -
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSportium.get(i).getFecha()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSportium.get(i).getHora()%>
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>

      </tbody>
    </table>
      <%
          }
        }
      %>
    </div>



    <div id="CuartaColumnaCuotas">
      <%
        if(cuotasSportium!= null) {
          for (int i = 0; i <= cuotasSportium.size()-1; i++) {

      %>
  <table class="tablaCuotas">
    <%
      if(i==0) {
    %>
    <thead>
    <tr>

      <th>Sportium</th>

    </tr>
    </thead>
    <%
      }
    %>
    <tbody>
    <tr>
      <td>
        <%=cuotasSportium.get(i).getCuota1()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasSportium.get(i).getCuotaX()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasSportium.get(i).getCuota2()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasSportium.get(i).getPorcentajePago()%>
      </td>
    </tr>

    </tbody>
  </table>
      <%
          }
        }
      %>

    </div>


<div id="CuotasBetfair">
  <%
    if(cuotasBetfair!= null) {
      for (int i = 0; i <= cuotasSportium.size()-1; i++) {

  %>
  <table id="tablaCuotaBetfair" class="tablaCuotasBetfair">
    <%
      if(i==0) {
    %>
    <thead>
    <tr>
      <th>Betfair</th>
    </tr>
    </thead>
    <%
      }
    %>

    <tbody>
    <tr>
      <td>
        <%=cuotasBetfair.get(i).getCuota1()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasBetfair.get(i).getCuotaX()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasBetfair.get(i).getCuota2()%>
      </td>
    </tr>
    <tr>
      <td>
        <%=cuotasBetfair.get(i).getPorcentajePago()%>
      </td>
    </tr>

    </tbody>
  </table>
  <%
      }
    }
  %>

</div>
<div id="CuotasJuegging">
  <%
    if(cuotasJuegging!= null) {
      for (int i = 0; i <= cuotasSportium.size()-1; i++) {

  %>

    <table class="tablaCuotasJuegging">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Juegging</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasJuegging.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasJuegging.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasJuegging.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasJuegging.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

  <%
      }
    }
  %>

</div>

<div id="CuotasInterwetten">
  <%
    if(cuotasInterwetten!= null) {
      for (int i = 0; i <= cuotasInterwetten.size()-1; i++) {

  %>
    <table class="tablaCuotasInterwetten">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Interwetten</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasInterwetten.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasInterwetten.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasInterwetten.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasInterwetten.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

  <%
      }
    }
  %>

</div>


<div id="CuotasMbet">

  <%
    if(cuotasMbet!= null) {
      for (int i = 0; i <= cuotasMbet.size()-1; i++) {

  %>

    <table class="tablaCuotasMbet">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Mbet</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
    <%=cuotasMbet.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
    <%=cuotasMbet.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
    <%=cuotasMbet.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
    <%=cuotasMbet.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

    <%
      }
      }
    %>
</div>


<div id="CuotasMarcaApuestas">

  <%
    if(cuotasMarcaApuestas!= null) {
      for (int i = 0; i <= cuotasMarcaApuestas.size()-1; i++) {

  %>

    <table class="tablaCuotasMarcaApuestas">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>MarcaApuestas</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasMarcaApuestas.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasMarcaApuestas.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasMarcaApuestas.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasMarcaApuestas.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

  <%
      }
    }
  %>
</div>


<div id="CuotasKirolbet">

  <%
    if(cuotasKirolbet!= null) {
      for (int i = 0; i <= cuotasKirolbet.size()-1; i++) {

  %>

    <table class="tablaCuotasKirolbet">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Kirolbet</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasKirolbet.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasKirolbet.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasKirolbet.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasKirolbet.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>


  <%
      }
    }
  %>
</div>


<div id="CuotasRetabet">

  <%
    if(cuotasRetabet!= null) {
      for (int i = 0; i <= cuotasRetabet.size()-1; i++) {

  %>

    <table class="tablaCuotasRetabet">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Retabet</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasRetabet.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasRetabet.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasRetabet.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasRetabet.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

  <%
      }
    }
  %>
</div>


<div id="CuotasSuertia">


  <%
    if(cuotasSuertia!= null) {
      for (int i = 0; i <= cuotasSuertia.size()-1; i++) {

  %>

    <table class="tablaCuotasSuertia">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>Suertia</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasSuertia.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSuertia.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSuertia.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasSuertia.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

  <%
      }
    }
  %>
</div>

    <div id="CuotasSissal">


        <%
            if(cuotasSissal!= null) {
                for (int i = 0; i <= cuotasSissal.size()-1; i++) {

        %>

        <table class="tablaCuotasSissal">
            <%
                if(i==0) {
            %>
            <thead>
            <tr>
                <th>Sissal</th>
            </tr>
            </thead>
            <%
                }
            %>
            <tbody>
            <tr>
                <td>
                    <%=cuotasSissal.get(i).getCuota1()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasSissal.get(i).getCuotaX()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasSissal.get(i).getCuota2()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasSissal.get(i).getPorcentajePago()%>
                </td>
            </tr>

            </tbody>
        </table>

        <%
                }
            }
        %>
    </div>

    <div id="CuotasCasinoBarcelona">


        <%
            if(cuotasCasinoBarcelona!= null) {
                for (int i = 0; i <= cuotasCasinoBarcelona.size()-1; i++) {

        %>

        <table class="tablaCuotasCasinoBarcelona">
            <%
                if(i==0) {
            %>
            <thead>
            <tr>
                <th>CasinoBarcelona</th>
            </tr>
            </thead>
            <%
                }
            %>
            <tbody>
            <tr>
                <td>
                    <%=cuotasCasinoBarcelona.get(i).getCuota1()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoBarcelona.get(i).getCuotaX()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoBarcelona.get(i).getCuota2()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoBarcelona.get(i).getPorcentajePago()%>
                </td>
            </tr>

            </tbody>
        </table>

        <%
                }
            }
        %>
    </div>

    <div id="CuotasCasinoMadrid">


        <%
            if(cuotasCasinoMadrid!= null) {
                for (int i = 0; i <= cuotasCasinoMadrid.size()-1; i++) {

        %>

        <table class="tablaCuotasCasinoMadrid">
            <%
                if(i==0) {
            %>
            <thead>
            <tr>
                <th>CasinoMadrid</th>
            </tr>
            </thead>
            <%
                }
            %>
            <tbody>
            <tr>
                <td>
                    <%=cuotasCasinoMadrid.get(i).getCuota1()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoMadrid.get(i).getCuotaX()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoMadrid.get(i).getCuota2()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%=cuotasCasinoMadrid.get(i).getPorcentajePago()%>
                </td>
            </tr>

            </tbody>
        </table>

        <%
                }
            }
        %>
    </div>

  <div id="CuotasGoldenPark">


    <%
      if(cuotasGoldenPark!= null) {
        for (int i = 0; i <= cuotasGoldenPark.size()-1; i++) {

    %>

    <table class="tablaCuotasGoldenPark">
      <%
        if(i==0) {
      %>
      <thead>
      <tr>
        <th>GoldenPark</th>
      </tr>
      </thead>
      <%
        }
      %>
      <tbody>
      <tr>
        <td>
          <%=cuotasGoldenPark.get(i).getCuota1()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasGoldenPark.get(i).getCuotaX()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasGoldenPark.get(i).getCuota2()%>
        </td>
      </tr>
      <tr>
        <td>
          <%=cuotasGoldenPark.get(i).getPorcentajePago()%>
        </td>
      </tr>

      </tbody>
    </table>

    <%
        }
      }
    %>
  </div>


</div>
<p id="texto introduccion"> DondeApuesto es una pagina web en la que podrás comparar las cuotas de las principales casas de
  apuestas deportivas de España. Si te registras con nosotros podras configurar las casas de apuestas, ademas podras
  recibir notificaciones cuando una cuota suba o baje a la cuota que te interese. Tambien se mostrará un grafico con el historial de la cuota seleccionada. Tambien
  Registrar usuarios, Autocompletar formularios,
</p>

<footer>
  <p>&copy; 2020.Adrian Fernandez Elizaga</p>
</footer>
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="/__/firebase/7.14.4/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="/__/firebase/7.14.4/firebase-analytics.js"></script>

<!-- Initialize Firebase -->
<script src="/__/firebase/init.js"></script>

</body>
</html>
