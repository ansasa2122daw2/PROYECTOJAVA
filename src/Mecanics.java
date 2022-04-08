import java.sql.*;
import java.util.Scanner;

public class Mecanics {
    String dni_mecanic;
    String nomapell;
    int edat;
    String telefono;
    String adreca;
    String ciutat;
    String pais;
    String email;
    int num_permis_conduccio;
    int punts_permis_conduccio;
    int salari;
    String num_seguretat_social;
    String titulacio;
    int anys_empresa;

    private static final Mecanics mecanic = new Mecanics();
    Connection conexion = (new Conexion()).conexion;

    public Mecanics() {
    }

    public String getDni_mecanic() {
        return dni_mecanic;
    }

    public void setDni_mecanic(String dni_mecanic) {
        this.dni_mecanic = dni_mecanic;
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

    public int getSalari() {
        return salari;
    }

    public void setSalari(int salari) {
        this.salari = salari;
    }

    public String getNum_seguretat_social() {
        return num_seguretat_social;
    }

    public void setNum_seguretat_social(String num_seguretat_social) {
        this.num_seguretat_social = num_seguretat_social;
    }

    public String getTitulacio() {
        return titulacio;
    }

    public void setTitulacio(String titulacio) {
        this.titulacio = titulacio;
    }

    public int getAnys_empresa() {
        return anys_empresa;
    }

    public void setAnys_empresa(int anys_empresa) {
        this.anys_empresa = anys_empresa;
    }

    //TODO: LISTAR
    public void llistar() throws SQLException, ClassNotFoundException{
        Statement sentencia = conexion.createStatement();

        ResultSet resul1 = sentencia.executeQuery("SELECT * FROM mecanics");
        System.out.println("♡ -- ♡ -- LISTAR MECANICS -- ♡ -- ♡");
        while (resul1.next()) {
            System.out.println("DNI " + resul1.getString("dni_mecanic"));
            System.out.println("Nombre y apellidos: " + resul1.getString("nomapell"));
            System.out.println("Edat: " + resul1.getString("edat"));
            System.out.println("Telefono " + resul1.getString("telefono"));
            System.out.println("Adreça: " + resul1.getString("adreca"));
            System.out.println("Ciutat: " + resul1.getString("ciutat"));
            System.out.println("Pais: " + resul1.getString("pais"));
            System.out.println("Email: " + resul1.getString("email"));
            System.out.println("Numero permís conducció: " + resul1.getString("num_permis_conduccio"));
            System.out.println("Punts permís conducció: " + resul1.getString("punts_permis_conduccio"));
            System.out.println("Salari: " + resul1.getString("salari"));
            System.out.println("Numero seguretat social: " + resul1.getString("num_seguretat_social"));
            System.out.println("Titulació: " + resul1.getString("titulacio"));
            System.out.println("Anys empresa: " + resul1.getString("anys_empresa"));
            System.out.println("-----------------------------------------------\n");


        }
    }

    //TODO: AÑADIR
    public void añadir() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        String query = "INSERT INTO MECANICS(dni_mecanic, nomapell, edat, telefono, adreca, ciutat, pais, email, num_permis_conduccio, punts_permis_conduccio, salari, num_seguretat_social, titulacio, anys_empresa)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("♡ -- ♡ -- AÑADIR UN COTXE -- ♡ -- ♡");
        System.out.println("DNI : ");
        mecanic.setDni_mecanic(sc2.nextLine());
        System.out.println("Nom y apellidos: ");
        mecanic.setNomapell(sc2.nextLine());
        System.out.println("Edat: ");
        mecanic.setEdat(sc.nextInt());
        System.out.println("Telefono: ");
        mecanic.setTelefono(sc2.nextLine());
        System.out.println("Adreça: ");
        mecanic.setAdreca(sc2.nextLine());
        System.out.println("Ciutat: ");
        mecanic.setCiutat(sc2.nextLine());
        System.out.println("Pais: ");
        mecanic.setPais(sc2.nextLine());
        System.out.println("Email: ");
        mecanic.setEmail(sc2.nextLine());
        System.out.println("Número permís conducció: ");
        mecanic.setNum_permis_conduccio(sc.nextInt());
        System.out.println("Punts permís conducció: ");
        mecanic.setPunts_permis_conduccio(sc.nextInt());
        System.out.println("Salari: ");
        mecanic.setSalari(sc.nextInt());
        System.out.println("Número seguretat social: ");
        mecanic.setNum_seguretat_social(sc2.nextLine());
        System.out.println("Titulació: ");
        mecanic.setTitulacio(sc3.nextLine());
        System.out.println("Anys empresa: ");
        mecanic.setAnys_empresa(sc.nextInt());

        preparedStmt.setString(1, mecanic.getDni_mecanic());
        preparedStmt.setString(2, mecanic.getNomapell());
        preparedStmt.setInt(3, mecanic.getEdat());
        preparedStmt.setString(4, mecanic.getTelefono());
        preparedStmt.setString(5, mecanic.getAdreca());
        preparedStmt.setString(6, mecanic.getCiutat());
        preparedStmt.setString(7, mecanic.getPais());
        preparedStmt.setString(8, mecanic.getEmail());
        preparedStmt.setInt(9, mecanic.getNum_permis_conduccio());
        preparedStmt.setInt(10, mecanic.getPunts_permis_conduccio());
        preparedStmt.setInt(11, mecanic.getSalari());
        preparedStmt.setString(12, mecanic.getNum_seguretat_social());
        preparedStmt.setString(13, mecanic.getTitulacio());
        preparedStmt.setInt(14, mecanic.getAnys_empresa());
        preparedStmt.executeUpdate();

        System.out.println("♡~ MECANIC AÑADIDO CON ÉXITO ~♡");

    }

    //TODO: ELIMINAR UNO
    public void eliminar() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        //hacemos la consulta
        String query = "DELETE FROM mecanics WHERE dni_mecanic= ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("Introduce el DNI del mecanic que quieres eliminar: ");
        mecanic.setDni_mecanic(sc.next());
        preparedStmt.setString(1, mecanic.getDni_mecanic());

        preparedStmt.executeUpdate();
        System.out.println("Mecanic eliminado ");

    }

    //TODO: MODIFICAR
    public void modificar() throws ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            Statement sentencia = conexion.createStatement();

            String query = "UPDATE mecanics SET nomapell = ?, edat = ?, telefono = ?, adreca = ?, ciutat = ?, pais = ?, email = ?, num_permis_conduccio = ?, punts_permis_conduccio = ?, salari = ?, num_seguretat_social = ?, titulacio = ?, anys_empresa = ? WHERE dni_mecanic = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            System.out.println("Introduce la DNI del mecanic al que quieres cambiar: ");
            mecanic.setDni_mecanic(sc.nextLine());
            System.out.println("Introduce el nuevo NOM Y APELLIDOS del mecanic: ");
            mecanic.setNomapell(sc2.nextLine());
            System.out.println("Introduce la nueva EDAT del mecanic: ");
            mecanic.setEdat(sc.nextInt());
            System.out.println("Introduce el nuevo TELEFONO del mecanic: ");
            mecanic.setTelefono(sc2.nextLine());
            System.out.println("Introduce la nueva ADREÇA del mecanic: ");
            mecanic.setAdreca(sc2.nextLine());
            System.out.println("Introduce la nueva CIUTAT del mecanic: ");
            mecanic.setCiutat(sc2.nextLine());
            System.out.println("Introduce el nuevo PAIS del mecanic: ");
            mecanic.setPais(sc2.nextLine());
            System.out.println("Introduce el nuevo EMAIL del mecanic: ");
            mecanic.setEmail(sc2.nextLine());
            System.out.println("Introduce el nuevo NUMERO PERMIS CONDUCCIO del mecanic: ");
            mecanic.setNum_permis_conduccio(sc.nextInt());
            System.out.println("Introduce el nuevo PUNTS PERMIS CONDUCCIO del mecanic: ");
            mecanic.setPunts_permis_conduccio(sc.nextInt());
            System.out.println("Introduce el nou SALARI del mecanic: ");
            mecanic.setSalari(sc.nextInt());
            System.out.println("Introduce el nuevo NUMERO SEGURETAT SOCIAL del mecanic: ");
            mecanic.setNum_seguretat_social(sc2.nextLine());
            System.out.println("Introduce la nueva TITULACIÓ del mecanic: ");
            mecanic.setTitulacio(sc.nextLine());
            System.out.println("Introduce ANYS EMPRESA del mecanic: ");
            mecanic.setAnys_empresa(sc.nextInt());

            preparedStmt.setString(1, mecanic.getDni_mecanic());
            preparedStmt.setString(2, mecanic.getNomapell());
            preparedStmt.setInt(3, mecanic.getEdat());
            preparedStmt.setString(4, mecanic.getTelefono());
            preparedStmt.setString(5, mecanic.getAdreca());
            preparedStmt.setString(6, mecanic.getCiutat());
            preparedStmt.setString(7, mecanic.getPais());
            preparedStmt.setString(8, mecanic.getEmail());
            preparedStmt.setInt(9, mecanic.getNum_permis_conduccio());
            preparedStmt.setInt(5, mecanic.getPunts_permis_conduccio());
            preparedStmt.setInt(6, mecanic.getSalari());
            preparedStmt.setString(7, mecanic.getNum_seguretat_social());
            preparedStmt.setString(8, mecanic.getTitulacio());
            preparedStmt.setInt(9, mecanic.getAnys_empresa());

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
