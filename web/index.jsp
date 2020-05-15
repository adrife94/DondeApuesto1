<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/estilos.css" rel="stylesheet" >
  </head>
  <body>
    <div id="container">
      <img id="logo" src="imagenes/Dondeapuesto.png" width="300" height="100">
    </div>



    <div class="topnav">
      <a href="#Login">Login</a>
      <a href="registro.html">Registrar</a>
      <a class="active" href="#home">Estadisticas</a>
      <a href="#CasasApuestas">Casas de Apuestas</a>
      <a href="#Bonos">Bonos</a>
      <a href="#Rankings">Rankings</a>
      <a href="#Consejos">Consejos</a>
      <a href="Calculadora.jsp">Calculadora Surebets</a>

    </div>




  <!-- <form action="" method="get">
      <td><input class="botonesCabecera"  type="submit" value="Estadisticas" id="estadistica" name="envio"/></td>
  </form>
  <form action="" method="get">
      <td><input class="botonesCabecera" type="submit" value="Login" id="login" name="envio" /></td>
  </form>
  <form action="formulario_registro.jsp" method="get">
      <td><input class="botonesCabecera" type="submit" value="Registrar" id="registro" name="envio"/></td>
  </form>
  <form action="formulario_registro.jsp" method="get">
      <td><input class="botonesCabecera" type="submit" value="Casas de apuestas" id="CasasApuestas" name="envio"/></td>
  </form>
  <form action="Bonos.html" method="get">
      <td><input class="botonesCabecera" type="submit" value="Bonos" id="Bonos" name="envio"/></td>
  </form>
  <form action="formulario_registro.jsp" method="get">
      <td><input class="botonesCabecera" type="submit" value="Rankings" id="Ranking" name="envio"/></td>
  </form>
  <form action="Consejos.html" method="get">
      <td><input class="botonesCabecera" type="submit" value="Consejos" id="Consejos" name="envio"/></td>
  </form>-->




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


  <table align="center" class="botonesCasas">

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



  <table>
    <thead>
    <tr>
      <th></th>
      <th></th>
      <th>INTERWETTEN</th>
      <th>GOLDENPARK</th>
      <th>SPORTIUM</th>
      <th>SUERTIA</th>
      <th>RETABET</th>
      <th>CASINOBARCELONA</th>
      <th>CASINOMADRID</th>
      <th>BETFAIR</th>
      <th>MBET</th>
      <th>JUEGGING</th>
      <th>KIROLBET</th>
      <th>MARCAAPUESTAS</th>
      <th>SISSAL</th>

      <%--<th>BWIN</th>
      <th>BET365</th>
      <th>MBET</th>
      <th>888SPORT</th>
      <th>LUCKIA</th>--%>

    </tr>
    </thead>

    <tbody>

<c:forEach var="CuotasTemp" items="${ListaCuotas}">

    <tr>
      <td>1</td>
      <td>${CuotasTemp.nombreEquipo1}</td>
      <td>2.9</td>
      <td>3.1</td>
      <td>${CuotasTemp.cuota1}</td>
      <td>2.95</td>
      <td>3.05</td>
      <td>2.890</td>
      <td>2.91</td>
      <td>3</td>
      <td>3.1</td>
      <td>3</td>
      <td>3.05</td>
      <td>3.1</td>
      <td>3.1</td>
    </tr>

    <tr>
      <td>X</td>
      <td>Empate</td>
      <td>2.9</td>
      <td>3.1</td>
      <td>${CuotasTemp.cuotaX}</td>
      <td>2.95</td>
      <td>3.05</td>
      <td>2.890</td>
      <td>2.91</td>
      <td>3</td>
      <td>3.1</td>
      <td>3</td>
      <td>3.05</td>
      <td>3.1</td>
      <td>3.1</td>
    </tr>

    <tr>
      <td>2</td>
      <td>${CuotasTemp.nombreEquipo2}</td>
      <td>2.9</td>
      <td>3.1</td>
      <td>${CuotasTemp.cuota2}</td>
      <td>2.95</td>
      <td>3.05</td>
      <td>2.890</td>
      <td>2.91</td>
      <td>3</td>
      <td>3.1</td>
      <td>3</td>
      <td>3.05</td>
      <td>3.1</td>
      <td>3.1</td>
    </tr>

    <tr>
      <td></td>
      <td>% Pago</td>
      <td>98</td>
      <td>97</td>
      <td>${CuotasTemp.porcentajePago}</td>
      <td>96</td>
      <td>95</td>
      <td>99</td>
      <td>97</td>
      <td>99</td>
      <td>98</td>
      <td>90</td>
      <td>90</td>
      <td>92</td>
    </tr>

</c:forEach>

    </tbody>

  </table>
  <p id="texto introduccion"> DondeApuesto es una pagina web en la que podrás comparar las cuotas de las principales casas de
    apuestas deportivas de España. Si te registras con nosotros podras configurar las casas de apuestas, ademas podras
    recibir notificaciones cuando una cuota suba o baje a la cuota que te interese. Tambien se mostrará un grafico con el historial de la cuota seleccionada. Tambien
    Registrar usuarios, Autocompletar formularios,
  </p>

  <footer>
    <p>&copy; 2020.Adrian Fernandez Elizaga</p>
  </footer>
  </body>
</html>