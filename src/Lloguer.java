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
    public void llistar() throws SQLException, ClassNotFoundException{
        Statement sentencia = conexion.createStatement();

        ResultSet resul1 = sentencia.executeQuery("SELECT * FROM lloguer");
        System.out.println("♡ -- ♡ -- LISTAR LLOGUERS -- ♡ -- ♡");
        //recorremos el resultado para visualizar cada fila, con un bucle while mientras haya registros
        while (resul1.next()) {
            System.out.println("DNI " + resul1.getString("dni"));
            System.out.println("Matricula: " + resul1.getString("matricula"));
            System.out.println("Dias: " + resul1.getString("dias"));
            System.out.println("Preu per dias " + resul1.getString("preu_per_dias"));
            System.out.println("Lloc devolució: " + resul1.getString("lloc_devolucio"));
            System.out.println("Retorn diposit ple: " + resul1.getString("retorn_diposit_ple"));
            System.out.println("Tipus assegurança: " + resul1.getString("tipus_asseguranca"));
            System.out.println("-----------------------------------------------\n");


        }
    }

    // TODO: AÑADIR
    public void añadir() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        String query = "INSERT INTO LLOGUER(dni, matricula, dias, preu_per_dias, lloc_devolucio, retorn_diposit_ple, tipus_asseguranca)" + "VALUES (?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("♡ -- ♡ -- AÑADIR UN LLOGUER -- ♡ -- ♡");
        System.out.println("DNI: ");
        loguer.setDni(sc2.nextLine());
        System.out.println("Matricula: ");
        loguer.setMatricula(sc2.nextLine());
        System.out.println("Dias: ");
        loguer.setDias(sc2.nextLine());
        System.out.println("Preu per dias: ");
        loguer.setPreu_per_dias(sc2.nextInt());
        System.out.println("Lloc devolució: ");
        loguer.setLloc_devolucio(sc3.nextLine());
        System.out.println("Retorn Diposit ple (true/false): ");
        loguer.setRetorn_disposit_ple(sc2.nextBoolean());
        System.out.println("Tipus assegurança: ");
        System.out.println("1. Amb franquicia");
        System.out.println("2. Sense franquicia");
        loguer.setTipus_asseguranca("");
        int opcions=sc.nextInt();
        do{
            switch(opcions){
                case 1:
                    loguer.setTipus_asseguranca("amb_franquicia");
                    break;
                case 2:
                    loguer.setTipus_asseguranca("sense_franquicia");
                    break;
                default:
                    System.out.println(" Prueba de nuevo :( ");
            }
        }while(loguer.getTipus_asseguranca().equals(""));

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
        String query = "DELETE FROM lloguer WHERE dni= ? AND matricula= ?;";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("Introduce la MATRICULA del lloguer que quieres eliminar: ");
        loguer.setMatricula(sc.next());
        System.out.println("Introduce el DNI del lloguer que quieres eliminar: ");
        loguer.setDni(sc.next());
        preparedStmt.setString(1, loguer.getDni());
        preparedStmt.setString(2, loguer.getMatricula());


        preparedStmt.executeUpdate();
        System.out.println("Lloguer eliminado ");

    }

    // TODO: MODIFICAR
    public void modificar() throws ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            Statement sentencia = conexion.createStatement();

            String query = "UPDATE lloguer SET dni = ?, matricula = ?, dias = ?, preu_per_dia = ?, lloc_devolucio = ?, retorn_diposit_ple = ?, tipus_asseguranca = ? WHERE matricula = ? AND dni = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            System.out.println("Introduce la MATRICULA del lloguer al que quieres cambiar: ");
            loguer.setMatricula(sc2.nextLine());
            System.out.println("Introduce el DNI del lloguer al que quieres cambiar: ");
            loguer.setMatricula(sc2.nextLine());
            System.out.println("♡ -- ♡ -- MODIFICAR EL LLOGUER -- ♡ -- ♡");
            System.out.println("Introduce la nueva MATRICULA: ");
            loguer.setMatricula(sc2.nextLine());
            System.out.println("Introduce el nuevo DNI: ");
            loguer.setMatricula(sc2.nextLine());
            System.out.println("Introduce el nuevo DIA de devolución: ");
            loguer.setDias(sc2.nextLine());
            System.out.println("Introduce el nuevo PREU PER DIAS: ");
            loguer.setPreu_per_dias(sc2.nextInt());
            System.out.println("Introduce el nuevo LLOC DE DEVOLUCIÓ: ");
            loguer.setLloc_devolucio(sc3.nextLine());
            System.out.println("Introduce el nuevo RETORN DEL DIPOSIT PLE (true/false): ");
            loguer.setRetorn_disposit_ple(sc2.nextBoolean());
            System.out.println("El nuevo TIPUS D'ASSEGURANÇA: ");
            System.out.println("1. Amb franquicia");
            System.out.println("2. Sense franquicia");
            loguer.setTipus_asseguranca("");
            int opcions=sc.nextInt();
            do{
                switch(opcions){
                    case 1:
                        loguer.setTipus_asseguranca("amb_franquicia");
                        break;
                    case 2:
                        loguer.setTipus_asseguranca("sense_franquicia");
                        break;
                    default:
                        System.out.println(" Prueba de nuevo :( ");
                }
            }while(loguer.getTipus_asseguranca().equals(""));

            preparedStmt.setString(1, loguer.getDni());
            preparedStmt.setString(2, loguer.getMatricula());
            preparedStmt.setString(3, loguer.getDias());
            preparedStmt.setInt(4, loguer.getPreu_per_dias());
            preparedStmt.setString(5, loguer.getLloc_devolucio());
            preparedStmt.setBoolean(6, loguer.isRetorn_disposit_ple());
            preparedStmt.setString(7, loguer.getTipus_asseguranca());

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            System.out.println("LLOGUER MODIFICADO");

        } catch (Exception e) {
            System.err.println("Ha habido una exception!");
            System.err.println(e.getMessage());
        }
    }

    //TODO: MOSTRAR UNO
    public void mostrarLloguer() throws SQLException{
        Statement sentencia = conexion.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la MATRICULA: ");
        loguer.setMatricula(sc.nextLine());

        String sql = "SELECT * FROM lloguer WHERE dni = '"+loguer.getDni()+"' AND matricula = '"+loguer.getMatricula()+"'";

        ResultSet resultado = sentencia.executeQuery(sql);

        System.out.println();
        System.out.println("LLOGUER " + loguer.getMatricula() +": ");
        while(resultado.next()){
            System.out.println("------- ♡ MOSTRAR UN LLOGUER ♡----------");
            System.out.println("DNI " + resultado.getString("dni"));
            System.out.println("Matricula: " + resultado.getString("matricula"));
            System.out.println("Dias: " + resultado.getInt("dias"));
            System.out.println("Preu per dias " + resultado.getString("preu_per_dias"));
            System.out.println("Lloc devolució: " + resultado.getString("lloc_devolucio"));
            System.out.println("Retorn diposit ple: " + resultado.getString("retorn_diposit_ple"));
            System.out.println("Tipus asseguranca: " + resultado.getString("tipus_asseguranca"));
            System.out.println("- ♡ ------- ♡ - ♡ -------- ♡ - ");
        }
        System.out.println();

    }

}

