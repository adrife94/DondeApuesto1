package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConexion {
  //  static String bd;
    static String login = "postgres";
    static String password = "1234";
  //  static String url = "jdbc:postgresql://localhost:5432/" + bd;
    // Esta variable va a guardar la conexion
    Connection conn = null;

    public PostgreSqlConexion( String casaApuesta) {
        try {
            //obtenemos el driver para mysql
              Class.forName("org.postgresql.Driver");



            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + casaApuesta, "postgres", "1234");
            //obtenemos una conexion con los parametros especificados anteriormente
            // conn = DriverManager.getConnection(url, "postgres", "1234");
            // Si conn no es nulo, significa que pidimos conectarnos
            if (conn != null) {
                System.out.println("Connecting database [" + conn + "] OK");
            }
        } catch (SQLException e) // Excepcion ocurrida por la conexion
        {
            System.out.println("Excepcion conexion: " + e.getMessage());
        } /*catch (ClassNotFoundException e) // Excepcion ocurrida por no encontrar el driver
      {
         System.out.println("Excepcion driver: " + e.getMessage());
      }*/ catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permite retornar la instancia de la conexion
     */
    public Connection getConnection() {
        return conn;
    }

    // Quitamos de memoria la conexion
    public void disconnect() {
        System.out.println("Closing database: [" + conn + "] OK");
        if (conn != null) {
            try {
                // System.out.println("Desconectado de " + bd + " OK");
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
