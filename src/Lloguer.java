import java.sql.*;
import java.util.Scanner;

public class Lloguer {
    String dni;
    String matricula;
    String dias;
    int preu_per_dias;
    String lloc_devolucio;
    boolean retorn_disposit_ple;
    String tipus_asseguranca;

    private static final Lloguer loguer = new Lloguer();
    Connection conexion = (new Conexion()).conexion;

    public Lloguer() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getPreu_per_dias() {
        return preu_per_dias;
    }

    public void setPreu_per_dias(int preu_per_dias) {
        this.preu_per_dias = preu_per_dias;
    }

    public String getLloc_devolucio() {
        return lloc_devolucio;
    }

    public void setLloc_devolucio(String lloc_devolucio) {
        this.lloc_devolucio = lloc_devolucio;
    }

    public boolean isRetorn_disposit_ple() {
        return retorn_disposit_ple;
    }

    public void setRetorn_disposit_ple(boolean retorn_disposit_ple) {
        this.retorn_disposit_ple = retorn_disposit_ple;
    }

    public String getTipus_asseguranca() {
        return tipus_asseguranca;
    }

    public void setTipus_asseguranca(String tipus_asseguranca) {
        this.tipus_asseguranca = tipus_asseguranca;
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

