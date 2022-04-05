import java.sql.*;
import java.util.Scanner;

public class Clientes {
    String dni;
    String nomapell;
    int edat;
    String telefono;
    String adreca;
    String ciutat;
    String pais;
    String email;
    int num_permis_conduccio;
    int punts_permis_conduccio;
    private static final Clientes cliente = new Clientes();
    Connection conexion = (new Conexion()).conexion;

    public Clientes() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomapell() {
        return nomapell;
    }

    public void setNomapell(String nomapell) {
        this.nomapell = nomapell;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_permis_conduccio() {
        return num_permis_conduccio;
    }

    public void setNum_permis_conduccio(int num_permis_conduccio) {
        this.num_permis_conduccio = num_permis_conduccio;
    }

    public int getPunts_permis_conduccio() {
        return punts_permis_conduccio;
    }

    public void setPunts_permis_conduccio(int punts_permis_conduccio) {
        this.punts_permis_conduccio = punts_permis_conduccio;
    }

    //MÉTODOS
    //TODO: LISTAR TODOS
    public void llistar() throws SQLException, ClassNotFoundException {
        Statement sentencia = conexion.createStatement();

        ResultSet resul1 = sentencia.executeQuery("SELECT * FROM clientes");
        System.out.println("♡ -- ♡ -- LISTAR CLIENTES -- ♡ -- ♡");
        //recorremos el resultado para visualizar cada fila, con un bucle while mientras haya registros
        while (resul1.next()) {
            System.out.println("DNI " + resul1.getString("dni"));
            System.out.println("Nombre y apellidos: " + resul1.getString("nomapell"));
            System.out.println("Edat: " + resul1.getInt("edat"));
            System.out.println("Telefono " + resul1.getString("telefono"));
            System.out.println("Adreça: " + resul1.getString("adreca"));
            System.out.println("Ciutat: " + resul1.getString("ciutat"));
            System.out.println("Pais: " + resul1.getString("pais"));
            System.out.println("Email: " + resul1.getString("email"));
            System.out.println("Numero permis conduccio: " + resul1.getInt("num_permis_conduccio"));
            System.out.println("Punts permis conduccio: " + resul1.getInt("punts_permis_conduccio"));
            System.out.println("-----------------------------------------------\n");


        }
    }
    //TODO: AÑADIR UNO
    public void añadir() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        /*INSERTAR FILAS EN LA TABLA*/
        String query = "INSERT INTO CLIENTES(dni, nomapell, edat, telefono, adreca, ciutat, pais, email, num_permis_conduccio, punts_permis_conduccio)" + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("♡ -- ♡ -- AÑADIR UN CLIENTE -- ♡ -- ♡");
        System.out.println("DNI: ");
        cliente.setDni(sc.next());
        System.out.println("Nombre y apellidos: ");
        cliente.setNomapell(sc2.nextLine());
        System.out.println("Edat: ");
        cliente.setEdat(sc.nextInt());
        System.out.println("Telefono: ");
        cliente.setTelefono(sc.next());
        System.out.println("Adreça: ");
        cliente.setAdreca(sc2.nextLine());
        System.out.println("Ciutat: ");
        cliente.setCiutat(sc2.nextLine());
        System.out.println("Pais: ");
        cliente.setPais(sc2.nextLine());
        System.out.println("Email: ");
        cliente.setEmail(sc2.next());
        System.out.println("Numero permis conduccio: ");
        cliente.setNum_permis_conduccio(sc.nextInt());
        System.out.println("Punts permis conduccio: ");
        cliente.setPunts_permis_conduccio(sc.nextInt());

        preparedStmt.setString(1, cliente.getDni());
        preparedStmt.setString(2, cliente.getNomapell());
        preparedStmt.setInt(3, cliente.getEdat());
        preparedStmt.setString(4, cliente.getTelefono());
        preparedStmt.setString(5, cliente.getAdreca());
        preparedStmt.setString(6, cliente.getCiutat());
        preparedStmt.setString(7, cliente.getPais());
        preparedStmt.setString(8, cliente.getEmail());
        preparedStmt.setInt(9, cliente.getNum_permis_conduccio());
        preparedStmt.setInt(10, cliente.getPunts_permis_conduccio());
        preparedStmt.executeUpdate();

        System.out.println("♡~ CLIENTE AÑADIDO CON ÉXITO ~♡");

    }

    //TODO: ELIMINAR UNO
    public void eliminar() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        //hacemos la consulta
        String query = "DELETE FROM clientes WHERE dni= ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("Introduce el DNI del cliente que quieres eliminar: ");
        cliente.setDni(sc.next());
        preparedStmt.setString(1, cliente.getDni());

        preparedStmt.executeUpdate();
        System.out.println("Cliente eliminado ");

    }

    //TODO: MODIFICAR
    public void modificar() throws ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            Statement sentencia = conexion.createStatement();

            String query = "UPDATE clientes SET nomapell = ?, edat = ?, telefono = ?, adreca = ?, ciutat = ?, pais = ?, email = ?, num_permis_conduccio = ?, punts_permis_conduccio = ? WHERE dni = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            System.out.println("Introduce el dni del cliente al que quieres cambiar: ");
            cliente.setDni(sc2.nextLine());
            System.out.println("Introduce el nuevo NOMBRE del cliente: ");
            cliente.setNomapell(sc2.nextLine());
            System.out.println("Introduce la nueva EDAD del cliente: ");
            cliente.setEdat(sc.nextInt());
            System.out.println("Introduce el nuevo TELEFONO del cliente: ");
            cliente.setTelefono(sc2.nextLine());
            System.out.println("Introduce la nueva ADREÇA del cliente: ");
            cliente.setAdreca(sc2.nextLine());
            System.out.println("Introduce la nueva CIUTAT del cliente: ");
            cliente.setCiutat(sc2.nextLine());
            System.out.println("Introduce el nuevo PAIS del cliente: ");
            cliente.setPais(sc2.nextLine());
            System.out.println("Introduce el nuevo EMAIL del cliente: ");
            cliente.setEmail(sc3.nextLine());
            System.out.println("Introduce el nuevo NUMERO DE PERMIS DE CONDUCCIÓ del cliente: ");
            cliente.setNum_permis_conduccio(sc.nextInt());
            System.out.println("Introduce el nuevo PUNT DE PERMIS DE CONDUCCIÓ del cliente: ");
            cliente.setPunts_permis_conduccio(sc.nextInt());

            preparedStmt.setString(1, cliente.getNomapell());
            preparedStmt.setInt(2, cliente.getEdat());
            preparedStmt.setString(3, cliente.getTelefono());
            preparedStmt.setString(4, cliente.getAdreca());
            preparedStmt.setString(5, cliente.getCiutat());
            preparedStmt.setString(6, cliente.getPais());
            preparedStmt.setString(7, cliente.getEmail());
            preparedStmt.setInt(8, cliente.getNum_permis_conduccio());
            preparedStmt.setInt(9, cliente.getPunts_permis_conduccio());
            preparedStmt.setString(10, cliente.getDni());

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            System.out.println("CLIENTE MODIFICADO");

        } catch (Exception e) {
            System.err.println("Ha habido una exception!");
            System.err.println(e.getMessage());
        }
    }

    //TODO: MOSTRAR UN CLIENTE
    public void mostrarCliente() throws SQLException{
        Statement sentencia = conexion.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI: ");
        cliente.setDni(sc.nextLine());

        String sql = "SELECT * FROM clientes WHERE dni = '"+cliente.getDni()+"'";

        ResultSet resultado = sentencia.executeQuery(sql);

        System.out.println();
        System.out.println("CLIENTE " + cliente.getDni() +": ");
        while(resultado.next()){
            System.out.println("------- ♡ MOSTRAR UN CLIENTE ♡----------");
            System.out.println(resultado.getString("dni"));
            System.out.println(resultado.getString("nomapell"));
            System.out.println(resultado.getInt("edat"));
            System.out.println(resultado.getString("telefono"));
            System.out.println(resultado.getString("adreca"));
            System.out.println(resultado.getString("ciutat"));
            System.out.println(resultado.getString("pais"));
            System.out.println(resultado.getString("email"));
            System.out.println(resultado.getInt("num_permis_conduccio"));
            System.out.println(resultado.getInt("punts_permis_conduccio"));

            System.out.println("- ♡ ------- ♡ - ♡ -------- ♡ - ");
        }
        System.out.println();

    }

}
