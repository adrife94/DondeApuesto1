<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>DondeApuesto</title>
    <link href="css/estilos.css" rel="stylesheet" >
</head>
<body>
<div id="container">
    <img id="logo" src="imagenes/Dondeapuesto.png" width="300" height="100">
</div>



<div class="topnav">
    <a href="#Login">Login</a>
    <a href="#Registrar">Registrar</a>
    <a class="active" href="#home">Estadisticas</a>
    <a href="#CasasApuestas">Casas de Apuestas</a>
    <a href="#Bonos">Bonos</a>
    <a href="#Rankings">Rankings</a>
    <a href="#Consejos">Consejos</a>
    <a href="calculadoraSurebets.html">Calculadora Surebets</a>

</div>

<form action="Calculadora" method="post">
<table>
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
        <td><input type="text" name="cuota1" value="0"></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.porcentaje1}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.importe1}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.resultado}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.beneficio}"/></td>

    </tr>

    <tr>
        <td>Cuota 2</td>
        <td><input type="text" name="cuota2" value="0"></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.porcentaje2}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.importe2}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.resultado}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.beneficio}"/></td>

    </tr>

    <tr>
        <td>Cuota 3</td>
        <td><input type="text" name="cuota3" value="0"></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.porcentaje3}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.importe3}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.resultado}"/></td>
        <td><input maxlength="11" size="24" type="text" name="seccion" value="${tabla.beneficio}"/></td>
    </tr>

    <tr>
        <td></td>
        <td>Introduce importe a apostar</td>
        <td><input type="text" name="cantidad" value="0"></td>
        <td><input type="submit" name="calcularsurebts" value="Calcular"></td>
        <td><input type="reset" name="Limpiar" value="Limpiar"></td>
        <td></td>

    </tr>



    </tbody>

</table>

</form>
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
