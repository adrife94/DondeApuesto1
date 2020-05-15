package Modelo;

public class TablaCalculadoraSurebets {
    private double porcentaje1;
    private double porcentaje2;
    private double porcentaje3;
    private double importe1;
    private double importe2;
    private double importe3;
    private double resultado;
    private double beneficio;
    private double cantidad;
    private double cuota1;
    private double cuota2;
    private double cuota3;

    public TablaCalculadoraSurebets(double porcentaje1, double porcentaje2, double importe1, double importe2, double resultado, double beneficio, double cantidad, double cuota1, double cuota2) {
        this.porcentaje1 = porcentaje1;
        this.porcentaje2 = porcentaje2;
        this.importe1 = importe1;
        this.importe2 = importe2;
        this.resultado = resultado;
        this.beneficio = beneficio;
        this.cantidad = cantidad;
        this.cuota1 = cuota1;
        this.cuota2 = cuota2;
    }

    public TablaCalculadoraSurebets(double porcentaje1, double porcentaje2, double porcentaje3, double importe1, double importe2, double importe3, double resultado, double beneficio, double cantidad, double cuota1, double cuota2, double cuota3) {
        this.porcentaje1 = porcentaje1;
        this.porcentaje2 = porcentaje2;
        this.porcentaje3 = porcentaje3;
        this.importe1 = importe1;
        this.importe2 = importe2;
        this.importe3 = importe3;
        this.resultado = resultado;
        this.beneficio = beneficio;
        this.cantidad = cantidad;
        this.cuota1 = cuota1;
        this.cuota2 = cuota2;
        this.cuota3 = cuota3;
    }

    public double getPorcentaje1() {
        return porcentaje1;
    }

    public void setPorcentaje1(double porcentaje1) {
        this.porcentaje1 = porcentaje1;
    }

    public double getPorcentaje2() {
        return porcentaje2;
    }

    public void setPorcentaje2(double porcentaje2) {
        this.porcentaje2 = porcentaje2;
    }

    public double getPorcentaje3() {
        return porcentaje3;
    }

    public void setPorcentaje3(double porcentaje3) {
        this.porcentaje3 = porcentaje3;
    }

    public double getImporte1() {
        return importe1;
    }

    public void setImporte1(double importe1) {
        this.importe1 = importe1;
    }

    public double getImporte2() {
        return importe2;
    }

    public void setImporte2(double importe2) {
        this.importe2 = importe2;
    }

    public double getImporte3() {
        return importe3;
    }

    public void setImporte3(double importe3) {
        this.importe3 = importe3;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCuota1() {
        return cuota1;
    }

    public void setCuota1(double cuota1) {
        this.cuota1 = cuota1;
    }

    public double getCuota2() {
        return cuota2;
    }

    public void setCuota2(double cuota2) {
        this.cuota2 = cuota2;
    }

    public double getCuota3() {
        return cuota3;
    }

    public void setCuota3(double cuota3) {
        this.cuota3 = cuota3;
    }
}
