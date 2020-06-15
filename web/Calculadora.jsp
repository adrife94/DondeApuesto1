<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>DondeApuesto</title>
    <link href="css/estilos.css" rel="stylesheet" >
</head>
<body>
<div id="contenedorBarraSuperior">

    <div class="topnav">
        <%-- <a href="#Login">Login</a>
         <a href="registro.html">Registrar</a>--%>
        <a href="#home">Estadisticas</a>
        <a href="#CasasApuestas">Casas de Apuestas</a>
        <a href="#Bonos">Bonos</a>
        <a href="Rankings.html">Rankings</a>
      <%--  <a href="#Consejos">Consejos</a>--%>
        <a class="active" href="Calculadora.jsp">Calculadora Surebets</a>
        <a href="Main" >Comparador</a>

        <div id="contenedorLogo">
            <img id="logo" src="imagenes/Dondeapuesto.png" >
        </div>
    </div>
</div>

<form action="Calculadora" method="post">
<table id="tablaCalculadora">
    <thead>
    <tr>
        <th></th>
        <th>Cuotas</th>
        <th>Probabilidad %</th>
        <th>Cantidad a apostar</th>
        <th>Resultado</th>
        <th>Beneficio %</th>

    </tr>
    </thead>

    <tbody>



    <tr>
        <td>Cuota 1</td>
        <td><input type="text" name="cuota1" value="${tabla.cuota1}"></td>
        <td>${tabla.porcentaje1}</td>
        <td>${tabla.importe1}</td>
        <td>${tabla.resultado}</td>
        <td>${tabla.beneficio}</td>

    </tr>

    <tr>
        <td>Cuota 2</td>
        <td><input type="text" name="cuota2" value="${tabla.cuota2}"></td>
        <td>${tabla.porcentaje2}</td>
        <td>${tabla.importe2}</td>
        <td>${tabla.resultado}</td>
        <td>${tabla.beneficio}</td>

    </tr>

    <tr>
        <td>Cuota 3</td>
        <td><input type="text" name="cuota3" value="${tabla.cuota3}"></td>
        <td>${tabla.porcentaje3}</td>
        <td>${tabla.importe3}</td>
        <td>${tabla.resultado}</td>
        <td>${tabla.beneficio}</td>
    </tr>

    <tr>
        <td></td>
        <td>Importe a apostar:</td>
        <td><input type="text" name="cantidad" value="0"></td>
        <td><input type="submit" name="calcularsurebts" value="Calcular"></td>
        <td><input type="reset" name="Limpiar" value="Limpiar"></td>
        <td></td>

    </tr>



    </tbody>

</table>

</form>

</div>

<div class="textoIntroduccion">
<p > La calculadora surebets nos permite introducir las cuotas y el
    importe total para apostar. La calculadora nos mostrará los importes que hay que apostar a cada cuota y el resultado que obtendremos
    si gana cualquiera de las opciones sobre las que hemos apostado. Ademas nos aparecera las probabilidades de la cuota y el beneficio
    en % que obtendriamos apostando lo que nos muestra la tabla.
</p>
</div>

<footer>
    <p>&copy; 2020.Adrian Fernandez Elizaga</p>
</footer>
</body>
</html>
