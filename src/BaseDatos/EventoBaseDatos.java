package BaseDatos;

import Modelo.Cuotas;

import java.sql.PreparedStatement;

public class EventoBaseDatos {

    private PostgreSqlConexion conexion;

    public EventoBaseDatos(PostgreSqlConexion conexion) {
        this.conexion = conexion;
    }

    public void InsertarCuotasSportium (Cuotas cuota, String equipo1, String equipo2) {


        try {
            String sql = "INSERT INTO " + equipo1 + equipo2 + "( fecha, hora, equipo1, equipo2, fechaHoraObtencion, cuota1, cuotaX, cuota2, porcentajePago, competicion, temporada) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);

            java.util.Date utildate = cuota.getFechaHoraObtencion();
            java.sql.Timestamp fecha_convertida = new java.sql.Timestamp(utildate.getTime());
            //  preparedStatement.setInt(1, cuota.getId());
            preparedStatement.setString(1, cuota.getFecha());
            preparedStatement.setString(2, cuota.getHora());
            preparedStatement.setString(3, cuota.getNombreEquipo1());
            preparedStatement.setString(4, cuota.getNombreEquipo2());
            preparedStatement.setTimestamp(5,fecha_convertida);
            preparedStatement.setDouble(6, cuota.getCuota1F());
            preparedStatement.setDouble(7, cuota.getCuotaXF());
            preparedStatement.setDouble(8, cuota.getCuota2F());
            preparedStatement.setDouble(9, cuota.getPorcentajePagoF());
            preparedStatement.setString(10, cuota.getCompeticion());
            preparedStatement.setString(11, cuota.getTemporada());
            preparedStatement.execute();




        } catch ( Exception e) {

        }
    }

    public void InsertarCuotas (Cuotas cuota, String equipo1, String equipo2) {


        try {
            String sql = "INSERT INTO " + equipo1 + equipo2 + "( equipo1, equipo2, fechaHoraObtencion, cuota1, cuotaX, cuota2, porcentajePago, competicion, temporada) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);

            java.util.Date utildate = cuota.getFechaHoraObtencion();
            java.sql.Timestamp fecha_convertida = new java.sql.Timestamp(utildate.getTime());
          //  preparedStatement.setInt(1, cuota.getId());
            preparedStatement.setString(1, cuota.getNombreEquipo1());
            preparedStatement.setString(2, cuota.getNombreEquipo2());
            preparedStatement.setTimestamp(3,fecha_convertida);
            preparedStatement.setDouble(4, cuota.getCuota1F());
            preparedStatement.setDouble(5, cuota.getCuotaXF());
            preparedStatement.setDouble(6, cuota.getCuota2F());
            preparedStatement.setDouble(7, cuota.getPorcentajePagoF());
            preparedStatement.setString(8, cuota.getCompeticion());
            preparedStatement.setString(9, cuota.getTemporada());
            preparedStatement.execute();




        } catch ( Exception e) {

        }
    }

    public void crearTablaSportium (String equipo1, String equipo2) {


        try {
            String sql = "CREATE TABLE " + equipo1 + equipo2 + " (" +
                    "   id SERIAL NOT NULL," +
                    "   fecha VARCHAR(20) NOT NULL," +
                    "   hora VARCHAR(15) NOT NULL," +
                    "   equipo1 VARCHAR(40)," +
                    "   equipo2 VARCHAR(40)," +
                    "   fechaHoraObtencion TIMESTAMP," +
                    "   cuota1 FLOAT," +
                    "   cuotaX FLOAT," +
                    "   cuota2 FLOAT," +
                    "   porcentajePago FLOAT," +
                    "   competicion VARCHAR(40)," +
                    "   temporada VARCHAR(40), " +
                    "   PRIMARY KEY (equipo1, equipo2, fechaHoraObtencion)" + ");";
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);

            preparedStatement.execute();

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void crearTabla (String equipo1, String equipo2) {


        try {
            String sql = "CREATE TABLE " + equipo1 + equipo2 + " (" +
                    "   id SERIAL NOT NULL," +
                    "   equipo1 VARCHAR(40)," +
                    "   equipo2 VARCHAR(40)," +
                    "   fechaHoraObtencion TIMESTAMP," +
                    "   cuota1 FLOAT," +
                    "   cuotaX FLOAT," +
                    "   cuota2 FLOAT," +
                    "   porcentajePago FLOAT," +
                    "   competicion VARCHAR(40)," +
                    "   temporada VARCHAR(40), " +
                    "   PRIMARY KEY (equipo1, equipo2, fechaHoraObtencion)" + ");";
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);

            preparedStatement.execute();

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void obtenerCuotaEvento (String equipo1, String equipo2) {


        try {
            String sql = "SELECT cuota1, cuotax, cuota2 FROM " + equipo1 + equipo2 + ";";
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);

            preparedStatement.execute();

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
