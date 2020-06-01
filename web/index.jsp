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

<nav>
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
</nav>


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

  <%
  if(cuotasSportium!= null) {
  for (Cuotas cuota : cuotasSportium) {

  }
  }
  %>
  <c:forEach var="CuotasTempSportium" items="${ListaCuotasSportium}">
  <table id="tablacentral1X2">
    <thead>
    <tr>
      <th>-</th>
    </tr>
    </thead>
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
    <tr>
      <td>
        -
      </td>
    </tr>

    </tbody>
  </table>




    <table class="tablaEquipos">
      <thead>
      <tr>
        <th>-</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>
            ${CuotasTempSportium.nombreEquipo1}
        </td>
      </tr>
      <tr>
        <td>
          X
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSportium.nombreEquipo2}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>



    <table class="tablaHoraFecha">
      <thead>
      <tr>
        <th>-</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>
          -
        </td>
      </tr>

      <tr>
        <td>
            ${CuotasTempSportium.fecha}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSportium.hora}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>

      </tbody>
    </table>



    <table class="tablaCuotas">
      <thead>
      <tr>
        <th>Sportium</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempSportium.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSportium.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSportium.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSportium.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>



  </c:forEach>



  <table class="tablaCuotas">
    <thead>
    <tr>
      <th>Sportium</th>
    </tr>
    </thead>

    <tbody>
    <tr>
      <td>
        ${CuotasTempSportium.cuota1}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempSportium.cuotaX}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempSportium.cuota2}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempSportium.porcentajePago}
      </td>
    </tr>
    <tr>
      <td>
        -
      </td>
    </tr>
    </tbody>
  </table>



  <script>

    $(".tablaCuotas").css("float", "left");

  </script>


  <c:forEach var="CuotasTempBetfair" items="${ListaCuotasBetfair}">

  <table id="tablaCuotaBetfair" class="tablaCuotasBetfair">
    <thead>
    <tr>
      <th>Betfair</th>
    </tr>
    </thead>

    <tbody>
    <tr>
      <td>
        ${CuotasTempBetfair.cuota1}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempBetfair.cuotaX}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempBetfair.cuota2}
      </td>
    </tr>
    <tr>
      <td>
        ${CuotasTempBetfair.porcentajePago}
      </td>
    </tr>
    <tr>
      <td>
        -
      </td>
    </tr>
    </tbody>
  </table>

  </c:forEach>

 <%-- <script>

    $(".tablaCuotasBetfair").css("float", "left");

  </script>--%>



  <c:forEach var="CuotasTempJuegging" items="${ListaCuotasJuegging}">

    <table class="tablaCuotasJuegging">
      <thead>
      <tr>
        <th>Juegging</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempJuegging.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempJuegging.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempJuegging.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempJuegging.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>



  </c:forEach>

  <c:forEach var="CuotasTempInterwetten" items="${ListaCuotasInterwetten}">

    <table class="tablaCuotasInterwetten">
      <thead>
      <tr>
        <th>Interwetten</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempInterwetten.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempInterwetten.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempInterwetten.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempInterwetten.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>

  <c:forEach var="CuotasTempMbet" items="${ListaCuotasMbet}">

    <table class="tablaCuotasMbet">
      <thead>
      <tr>
        <th>Mbet</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempMbet.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMbet.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMbet.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMbet.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>

  <c:forEach var="CuotasTempMarcaApuestas" items="${ListaCuotasMarcaApuestas}">

    <table class="tablaCuotasMarcaApuestas">
      <thead>
      <tr>
        <th>MarcaApuestas</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempMarcaApuestas.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMarcaApuestas.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMarcaApuestas.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempMarcaApuestas.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>

  <c:forEach var="CuotasTempKirolbet" items="${ListaCuotasKirolbet}">

    <table class="tablaCuotasKirolbet">
      <thead>
      <tr>
        <th>Kirolbet</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempKirolbet.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempKirolbet.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempKirolbet.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempKirolbet.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>

  <c:forEach var="CuotasTempRetabet" items="${ListaCuotasRetabet}">

    <table class="tablaCuotasRetabet">
      <thead>
      <tr>
        <th>Retabet</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempRetabet.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempRetabet.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempRetabet.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempRetabet.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>

  <c:forEach var="CuotasTempSuertia" items="${ListaCuotasSuertia}">

    <table class="tablaCuotasSuertia">
      <thead>
      <tr>
        <th>Suertia</th>
      </tr>
      </thead>

      <tbody>
      <tr>
        <td>
            ${CuotasTempSuertia.cuota1}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSuertia.cuotaX}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSuertia.cuota2}
        </td>
      </tr>
      <tr>
        <td>
            ${CuotasTempSuertia.porcentajePago}
        </td>
      </tr>
      <tr>
        <td>
          -
        </td>
      </tr>
      </tbody>
    </table>

  </c:forEach>


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
