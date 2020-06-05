package Modelo;

import java.util.Date;

public class Cuotas {
    private static int id;
    private Date fechaHoraObtencion;
    private String nombreEquipo1;
    private String nombreEquipo2;
    private String cuota1;
    private String cuotaX;
    private String cuota2;
    private double cuota1F, cuotaXF, cuota2F, porcentajePagoF;
    private String porcentajePago;
    private String fecha, hora;
    private String competicion, temporada;



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

    public Cuotas( String fecha, String hora, String nombreEquipo1, String nombreEquipo2, Date fechaHoraObtencion, double cuota1F, double cuotaXF, double cuota2F, double porcentajePagoF, String competicion, String temporada) {
        this.fecha = fecha;
        this.hora = hora;
        this.fechaHoraObtencion = fechaHoraObtencion;
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1F = cuota1F;
        this.cuotaXF = cuotaXF;
        this.cuota2F = cuota2F;
        this.porcentajePagoF = porcentajePagoF;
        this.competicion = competicion;
        this.temporada = temporada;
    }

    public Cuotas(String nombreEquipo1, String nombreEquipo2, Date fechaHoraObtencion, double cuota1F, double cuotaXF, double cuota2F ,double porcentajePagoF, String competicion, String temporada) {
        this.fechaHoraObtencion = fechaHoraObtencion;
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1F = cuota1F;
        this.cuotaXF = cuotaXF;
        this.cuota2F = cuota2F;
        this.porcentajePagoF = porcentajePagoF;
        this.competicion = competicion;
        this.temporada = temporada;

    }



    public double getPorcentajePagoF() {
        return porcentajePagoF;
    }

    public void setPorcentajePagoF(double porcentajePagoF) {
        this.porcentajePagoF = porcentajePagoF;
    }

    public double getCuota1F() {
        return cuota1F;
    }

    public void setCuota1F(double cuota1F) {
        this.cuota1F = cuota1F;
    }

    public double getCuotaXF() {
        return cuotaXF;
    }

    public void setCuotaXF(double cuotaXF) {
        this.cuotaXF = cuotaXF;
    }

    public double getCuota2F() {
        return cuota2F;
    }

    public void setCuota2F(double cuota2F) {
        this.cuota2F = cuota2F;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cuotas.id = id;
    }

    public Date getFechaHoraObtencion() {
        return fechaHoraObtencion;
    }

    public void setFechaHoraObtencion(Date fechaObtencion) {
        this.fechaHoraObtencion = fechaObtencion;
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
