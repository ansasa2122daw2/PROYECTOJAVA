import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {

        String miDriver="com.mysql.cj.jdbc.Driver";
        String miUrl = "jdbc:mysql://localhost/bdproyecto";
        Connection conexion;

        public Conexion() {
            try {
                Class.forName(miDriver);
                conexion = DriverManager.getConnection(miUrl, "root","root");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}

