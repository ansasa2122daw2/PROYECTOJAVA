import java.sql.*;
import java.util.Scanner;

public class Cotxes {
    String matricula;
    int num_bastidor;
    String marca;
    String model;
    String color;
    int num_plazas;
    int num_portes;
    int grandaria_maleter;
    String tipus_combustible;

    private static final Cotxes cotxe = new Cotxes();
    Connection conexion = (new Conexion()).conexion;

    public Cotxes() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNum_bastidor() {
        return num_bastidor;
    }

    public void setNum_bastidor(int num_bastidor) {
        this.num_bastidor = num_bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum_plazas() {
        return num_plazas;
    }

    public void setNum_plazas(int num_plazas) {
        this.num_plazas = num_plazas;
    }

    public int getNum_portes() {
        return num_portes;
    }

    public void setNum_portes(int num_portes) {
        this.num_portes = num_portes;
    }

    public int getGrandaria_maleter() {
        return grandaria_maleter;
    }

    public void setGrandaria_maleter(int grandaria_maleter) {
        this.grandaria_maleter = grandaria_maleter;
    }

    public String getTipus_combustible() {
        return tipus_combustible;
    }

    public void setTipus_combustible(String tipus_combustible) {
        this.tipus_combustible = tipus_combustible;
    }

    //TODO: LISTAR
    public void llistar() throws SQLException, ClassNotFoundException{
        Statement sentencia = conexion.createStatement();

        ResultSet resul1 = sentencia.executeQuery("SELECT * FROM cotxes");
        System.out.println("♡ -- ♡ -- LISTAR COCHES -- ♡ -- ♡");
        //recorremos el resultado para visualizar cada fila, con un bucle while mientras haya registros
        while (resul1.next()) {
            System.out.println("Matricula " + resul1.getString("matricula"));
            System.out.println("Numero bastidor: " + resul1.getString("num_bastidor"));
            System.out.println("Marca: " + resul1.getString("marca"));
            System.out.println("Modelo " + resul1.getString("model"));
            System.out.println("Color: " + resul1.getString("color"));
            System.out.println("Numero plazas: " + resul1.getString("num_plazas"));
            System.out.println("Numero portes: " + resul1.getString("num_portes"));
            System.out.println("Grandaria maleter: " + resul1.getString("grandaria_maleter"));
            System.out.println("Tipus combustible: " + resul1.getString("tipus_combustible"));
            System.out.println("-----------------------------------------------\n");


        }
    }

    //TODO: AÑADIR
    public void añadir() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        String query = "INSERT INTO COTXES(matricula, num_bastidor, marca, model, color, num_plazas, num_portes, grandaria_maleter, tipus_combustible)" + "VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("♡ -- ♡ -- AÑADIR UN COTXE -- ♡ -- ♡");
        System.out.println("Matricula: ");
        cotxe.setMatricula(sc2.nextLine());
        System.out.println("Numero bastidor: ");
        cotxe.setNum_bastidor(sc.nextInt());
        System.out.println("Marca: ");
        cotxe.setMarca(sc2.nextLine());
        System.out.println("Model: ");
        cotxe.setModel(sc2.nextLine());
        System.out.println("Color: ");
        cotxe.setColor(sc2.nextLine());
        System.out.println("Numero plazas: ");
        cotxe.setNum_plazas(sc.nextInt());
        System.out.println("Numero portes: ");
        cotxe.setNum_portes(sc.nextInt());
        System.out.println("Grandaria maleter: ");
        cotxe.setGrandaria_maleter(sc.nextInt());
        System.out.println("Tipus combustible: ");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Electric");
        cotxe.setTipus_combustible("");
        int opcions=sc.nextInt();
        do{
            switch(opcions){
                case 1:
                    cotxe.setTipus_combustible("gasolina");
                    break;
                case 2:
                    cotxe.setTipus_combustible("diesel");
                    break;
                case 3:
                    cotxe.setTipus_combustible("electric");
                    break;
                default:
                    System.out.println(" Prueba de nuevo :( ");
            }
        }while(cotxe.getTipus_combustible().equals(""));

        preparedStmt.setString(1, cotxe.getMatricula());
        preparedStmt.setInt(2, cotxe.getNum_bastidor());
        preparedStmt.setString(3, cotxe.getMarca());
        preparedStmt.setString(4, cotxe.getModel());
        preparedStmt.setString(5, cotxe.getColor());
        preparedStmt.setInt(6, cotxe.getNum_plazas());
        preparedStmt.setInt(7, cotxe.getNum_portes());
        preparedStmt.setInt(8, cotxe.getGrandaria_maleter());
        preparedStmt.setString(9, cotxe.getTipus_combustible());
        preparedStmt.executeUpdate();

        System.out.println("♡~ COTXE AÑADIDO CON ÉXITO ~♡");

    }

    //TODO: ELIMINAR UNO
    public void eliminar() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Statement sentencia = conexion.createStatement();

        //hacemos la consulta
        String query = "DELETE FROM cotxes WHERE matricula= ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        System.out.println("Introduce la MATRICULA del cotxe que quieres eliminar: ");
        cotxe.setMatricula(sc.next());
        preparedStmt.setString(1, cotxe.getMatricula());

        preparedStmt.executeUpdate();
        System.out.println("Cotxe eliminado ");

    }

    //TODO: MODIFICAR
    public void modificar() throws ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            Statement sentencia = conexion.createStatement();

            String query = "UPDATE cotxes SET num_bastidor = ?, marca = ?, model = ?, color = ?, num_plazas = ?, num_portes = ?, grandaria_maleter = ?, tipus_combustible = ? WHERE matricula = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            System.out.println("Introduce la MATRICULA del cotxe al que quieres cambiar: ");
            cotxe.setMatricula(sc2.nextLine());
            System.out.println("Introduce el nuevo NUMERO DE BASTIDOR del cotxe: ");
            cotxe.setNum_bastidor(sc.nextInt());
            System.out.println("Introduce la nueva MARCA del cotxe: ");
            cotxe.setMarca(sc2.nextLine());
            System.out.println("Introduce el nuevo MODELO del cotxe: ");
            cotxe.setModel(sc3.nextLine());
            System.out.println("Introduce la nueva COLOR del cotxe: ");
            cotxe.setColor(sc2.nextLine());
            System.out.println("Introduce el nuevo NUMERO DE PLAZAS del cotxe: ");
            cotxe.setNum_plazas(sc.nextInt());
            System.out.println("Introduce el nuevo NUMERO DE PORTES del cotxe: ");
            cotxe.setNum_portes(sc.nextInt());
            System.out.println("Introduce la nueva GRANDARIA DE MALETER del cotxe: ");
            cotxe.setGrandaria_maleter(sc3.nextInt());
            System.out.println("Introduce el nuevo TIPUS DE COMBUSTIBLE del cotxe: ");
            System.out.println("1. Gasolina");
            System.out.println("2. Diesel");
            System.out.println("3. Electric");
            cotxe.setTipus_combustible("");
            int opcions=sc.nextInt();
            do{
                switch(opcions){
                    case 1:
                        cotxe.setTipus_combustible("gasolina");
                        break;
                    case 2:
                        cotxe.setTipus_combustible("diesel");
                        break;
                    case 3:
                        cotxe.setTipus_combustible("electric");
                        break;
                    default:
                        System.out.println(" Prueba de nuevo :( ");
                }
            }while(cotxe.getTipus_combustible().equals(""));

            preparedStmt.setInt(1, cotxe.getNum_bastidor());
            preparedStmt.setString(2, cotxe.getMarca());
            preparedStmt.setString(3, cotxe.getModel());
            preparedStmt.setString(4, cotxe.getColor());
            preparedStmt.setInt(5, cotxe.getNum_plazas());
            preparedStmt.setInt(6, cotxe.getNum_portes());
            preparedStmt.setInt(7, cotxe.getGrandaria_maleter());
            preparedStmt.setString(8, cotxe.getTipus_combustible());
            preparedStmt.setString(9, cotxe.getMatricula());

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            System.out.println("COTXE MODIFICADO");

        } catch (Exception e) {
            System.err.println("Ha habido una exception!");
            System.err.println(e.getMessage());
        }
    }

    //TODO: MOSTRAR UN
    public void mostrarCotxe() throws SQLException{
        Statement sentencia = conexion.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la MATRICULA: ");
        cotxe.setMatricula(sc.nextLine());

        String sql = "SELECT * FROM clientes WHERE dni = '"+cotxe.getMatricula()+"'";

        ResultSet resultado = sentencia.executeQuery(sql);

        System.out.println();
        System.out.println("COTXE " + cotxe.getMatricula() +": ");
        while(resultado.next()){
            System.out.println("------- ♡ MOSTRAR UN COTXE ♡----------");
            System.out.println("Matricula " + resultado.getString("matricula"));
            System.out.println("Numero bastidor: " + resultado.getString("num_bastidor"));
            System.out.println("Marca: " + resultado.getInt("marca"));
            System.out.println("Modelo " + resultado.getString("model"));
            System.out.println("Color: " + resultado.getString("color"));
            System.out.println("Numero plazas: " + resultado.getString("num_plazas"));
            System.out.println("Numero portes: " + resultado.getString("num_portes"));
            System.out.println("Grandaria maleter: " + resultado.getString("grandaria_maleter"));
            System.out.println("Tipus combustible: " + resultado.getInt("tipus_combustible"));

            System.out.println("- ♡ ------- ♡ - ♡ -------- ♡ - ");
        }
        System.out.println();

    }
}
