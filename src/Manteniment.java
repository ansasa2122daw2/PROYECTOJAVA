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

    public void setData_inici(String data_inici) {
        this.data_inici = data_inici;
    }

    public Date getData_fi() {
        return data_fi;
    }

    public void setData_fi(int data_fi) {
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
        manteniment.setDni_mecanic(sc.nextLine());
        System.out.println("Matricula: ");
        manteniment.setMatricula(sc.nextLine());
        System.out.println("Data inici: ");
        manteniment.setData_inici(sc.nextLine());
        System.out.println("Data fi: ");
        manteniment.setData_fi(sc.nextInt());

        preparedStmt.setString(1, manteniment.getDni_mecanic());
        preparedStmt.setString(2, manteniment.getMatricula());
        preparedStmt.setDate(3, manteniment.getData_inici());
        preparedStmt.setDate(4, manteniment.getData_fi());
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

    //TODO: MODIFICAR
    public void modificar() throws ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);

            Statement sentencia = conexion.createStatement();

            String query = "UPDATE manteniment SET dni_mecanic = ?, matricula = ?, data_inici = ?, data_fi = ? WHERE dni_mecanic = ? AND matricula = ?;";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            System.out.println("Introduce la DNI del mecanic al que quieres cambiar: ");
            manteniment.setDni_mecanic(sc.nextLine());
            System.out.println("Introduce el nuevo NOM Y APELLIDOS del mecanic: ");
            manteniment.(sc2.nextLine());
            System.out.println("Introduce la nueva EDAT del mecanic: ");
            manteniment.setEdat(sc.nextInt());
            System.out.println("Introduce el nuevo TELEFONO del mecanic: ");
            manteniment.setTelefono(sc2.nextLine());

            preparedStmt.setString(1, manteniment.getDni_mecanic());
            preparedStmt.setString(2, manteniment.getNomapell());
            preparedStmt.setInt(3, manteniment.getEdat());
            preparedStmt.setString(4, manteniment.getTelefono());

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            System.out.println("MECANIC MODIFICADO");

        } catch (Exception e) {
            System.err.println("Ha habido una exception!");
            System.err.println(e.getMessage());
        }
    }

    //TODO: MOSTRAR UN
    public void mostrarCotxe() throws SQLException{
        Statement sentencia = conexion.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la DNI: ");
        mecanic.setDni_mecanic(sc.nextLine());

        String sql = "SELECT * FROM mecanics WHERE dni_mecanic = '"+mecanic.getDni_mecanic()+"'";

        ResultSet resultado = sentencia.executeQuery(sql);

        System.out.println();
        System.out.println("DNI " + mecanic.getDni_mecanic() +": ");
        System.out.println(" ------------------------------------ ");
        while(resultado.next()){
            System.out.println("DNI " + resultado.getString("dni_mecanic"));
            System.out.println("Nombre y apellidos: " + resultado.getString("nomapell"));
            System.out.println("Edat: " + resultado.getString("edat"));
            System.out.println("Telefono " + resultado.getString("telefono"));
            System.out.println("Adreça: " + resultado.getString("adreca"));
            System.out.println("Ciutat: " + resultado.getString("ciutat"));
            System.out.println("Pais: " + resultado.getString("pais"));
            System.out.println("Email: " + resultado.getString("email"));
            System.out.println("Numero permís conducció: " + resultado.getString("num_permis_conduccio"));
            System.out.println("Punts permís conducció: " + resultado.getString("punts_permis_conduccio"));
            System.out.println("Salari: " + resultado.getString("salari"));
            System.out.println("Numero seguretat social: " + resultado.getString("num_seguretat_social"));
            System.out.println("Titulació: " + resultado.getString("titulacio"));
            System.out.println("Anys empresa: " + resultado.getString("anys_empresa"));
            System.out.println("- ♡ ------- ♡ - ♡ -------- ♡ - ");
        }
        System.out.println();
    }
}

