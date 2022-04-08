import java.sql.*;
import java.util.Scanner;


public class Manteniment {
    String dni_mecanic;
    String matricula;
    Date data_inici;
    Date data_fi;

    private static final Manteniment manteniment = new Manteniment();
    Connection conexion = (new Conexion()).conexion;

    public Manteniment() {
    }

    public String getDni_mecanic() {
        return dni_mecanic;
    }

    public void setDni_mecanic(String dni_mecanic) {
        this.dni_mecanic = dni_mecanic;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getData_inici() {
        return data_inici;
    }

    public void setData_inici(Date data_inici) {
        this.data_inici = data_inici;
    }

    public Date getData_fi() {
        return data_fi;
    }

    public void setData_fi(Date data_fi) {
        this.data_fi = data_fi;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    //METODOS
    //TODO: LISTAR
    public void llistar() throws SQLException, ClassNotFoundException{
        Statement sentencia = conexion.createStatement();

        ResultSet resul1 = sentencia.executeQuery("SELECT * FROM manteniment");
        System.out.println("♡ -- ♡ -- LISTAR MANTENIMENTS -- ♡ -- ♡");
        while (resul1.next()) {
            System.out.println("DNI " + resul1.getString("dni_mecanic"));
            System.out.println("Matricula: " + resul1.getString("matricula"));
            System.out.println("Data inici: " + resul1.getString("data_inici"));
            System.out.println("Data fi: " + resul1.getString("data_fi"));
            System.out.println("-----------------------------------------------\n");


        }
    }
}

