package Modelo;

public class Cuotas {
    private String nombreEquipo1;
    private String nombreEquipo2;
    private String cuota1;
    private String cuotaX;
    private String cuota2;
    private String porcentajePago;
    private String fecha, hora;



    public Cuotas(String nombreEquipo1, String nombreEquipo2, String cuota1, String cuotaX, String cuota2, String porcentajePago, String fecha, String hora) {
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1 = cuota1;
        this.cuotaX = cuotaX;
        this.cuota2 = cuota2;
        this.porcentajePago = porcentajePago;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cuotas(String nombreEquipo1, String nombreEquipo2, String cuota1, String cuotaX, String cuota2, String porcentajePago) {
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1 = cuota1;
        this.cuotaX = cuotaX;
        this.cuota2 = cuota2;
        this.porcentajePago = porcentajePago;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public void setNombreEquipos(String nombreEquipos) {
        this.nombreEquipo1 = nombreEquipos;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public void setNombreEquipo2(String nombreEquipo2) {
        this.nombreEquipo1 = nombreEquipo2;
    }

    public String getCuota1() {
        return cuota1;
    }

    public void setCuota1(String cuota1) {
        this.cuota1 = cuota1;
    }

    public String getCuotaX() {
        return cuotaX;
    }

    public void setCuotaX(String cuotaX) {
        this.cuotaX = cuotaX;
    }

    public String getCuota2() {
        return cuota2;
    }

    public void setCuota2(String cuota2) {
        this.cuota2 = cuota2;
    }

    public String getPorcentajePago() {
        return porcentajePago;
    }

    public void setPorcentajePago(String porcentajePago) {
        this.porcentajePago = porcentajePago;
    }

    public void setNombreEquipo1(String nombreEquipo1) {
        this.nombreEquipo1 = nombreEquipo1;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
