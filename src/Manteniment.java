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

    //TODO: AÑADIR
    public void añadir() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        String query = "INSERT INTO manteniment(dni_mecanic, matricula, data_inici, data_fi)" + "VALUES (?,?,?,?);";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("♡ -- ♡ -- AÑADIR UN MANTENIMENT -- ♡ -- ♡");
        System.out.println("DNI: ");
        manteniment.getDni_mecanic(sc.nextLine());
        System.out.println("Matricula: ");
        manteniment.setMatricula(sc.nextLine());
        System.out.println("Dias: ");
        manteniment.setDias(sc.nextLine());
        System.out.println("Preu per dias: ");
        manteniment.setPreu_per_dias(sc.nextInt());

        preparedStmt.setString(1, loguer.getDni());
        preparedStmt.setString(2, loguer.getMatricula());
        preparedStmt.setString(3, loguer.getDias());
        preparedStmt.setInt(4, loguer.getPreu_per_dias());
        preparedStmt.setString(5, loguer.getLloc_devolucio());
        preparedStmt.setBoolean(6, loguer.isRetorn_disposit_ple());
        preparedStmt.setString(7, loguer.getTipus_asseguranca());
        preparedStmt.executeUpdate();

        System.out.println("♡~ COTXE AÑADIDO CON ÉXITO ~♡");

    }


    //TODO: ELIMINAR UNO
    public void eliminar() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        //hacemos la consulta
        String query = "DELETE FROM manteniment WHERE dni_mecanic= ? AND matricula= ?;";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("Introduce el DNI del mecanic que quieres eliminar: ");
        manteniment.setDni_mecanic(sc.next());
        System.out.println("Introduce la MATRICULA del coche que quieres eliminar: ");
        manteniment.setMatricula(sc.next());
        preparedStmt.setString(1, manteniment.getDni_mecanic());
        preparedStmt.setString(2, manteniment.getMatricula());


        preparedStmt.executeUpdate();
        System.out.println("Manteniment eliminado ");

    }
}

