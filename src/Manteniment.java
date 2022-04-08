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
}

