import java.sql.SQLException;
import java.util.Scanner;

public class main {
    static Clientes cliente = new Clientes();
    static Cotxes cotxe = new Cotxes();
    static Mecanics mecanic = new Mecanics();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1. Opciones para clientes ");
            System.out.println("2. Opciones para coches ");
            System.out.println("3. Opciones para lloguer ");
            System.out.println("4. Opciones para mantenimiento ");
            System.out.println("5. Opciones para mecanicos ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int opcion2 = 0;
                    do {
                        System.out.println("1. Añadir clientes");
                        System.out.println("2. Listar todos los clientes ");
                        System.out.println("3. Eliminar clientes ");
                        System.out.println("4. Modificar clientes (dni) ");
                        System.out.println("5. Listar UN clientes (dni) ");
                        System.out.println("6. Salir ");
                        opcion2 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion2) {
                            case 1:
                                cliente.añadir();
                                break;
                            case 2:
                                cliente.llistar();
                                break;
                            case 3:
                                cliente.eliminar();
                                break;
                            case 4:
                                cliente.modificar();
                                break;
                            case 5:
                                cliente.mostrarCliente();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                                break;
                        }
                    } while (opcion2 != 6);
                    break;
                case 2:
                    int opcion3 = 0;
                    do {
                        System.out.println("1. Añadir coches");
                        System.out.println("2. Listar todos los coches ");
                        System.out.println("3. Eliminar coches ");
                        System.out.println("4. Modificar coche (matricula) ");
                        System.out.println("5. Listar UN coche (matricula) ");
                        System.out.println("6. Salir ");
                        opcion3 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion3){
                            case 1 -> cotxe.añadir();
                            case 2 -> cotxe.llistar();
                            case 3 -> cotxe.eliminar();
                            case 4 -> cotxe.modificar();
                            case 5 -> cotxe.mostrarCotxe();
                            case 6 -> opcion3 = 6;
                            default -> System.out.println("Opción incorrecta");
                        }
                    }while(opcion3!=6);
                    break;
                case 3:
                    int opcion4 = 0;
                    do {
                        System.out.println("1. Añadir lloguer");
                        System.out.println("2. Listar todos los lloguers ");
                        System.out.println("3. Eliminar lloguer ");
                        System.out.println("4. Modificar lloguer (matricula) ");
                        System.out.println("5. Listar UN lloguer (matricula) ");
                        System.out.println("6. Salir ");
                        opcion4 = sc.nextInt();
                        sc.nextLine();
                    }while(opcion4 !=6);
                    break;
                case 4:
                    int opcion5 = 0;
                    do {
                        System.out.println("1. Añadir manteniment");
                        System.out.println("2. Listar todos los manteniments ");
                        System.out.println("3. Eliminar manteniment ");
                        System.out.println("4. Modificar manteniment (matricula) ");
                        System.out.println("5. Listar UN manteniment (matricula) ");
                        System.out.println("6. Salir ");
                        opcion5 = sc.nextInt();
                        sc.nextLine();
                    }while(opcion5 !=6);
                    break;
                case 5:
                    int opcion6 = 0;
                    do {
                        System.out.println("1. Añadir mecanics");
                        System.out.println("2. Listar todos los mecanics ");
                        System.out.println("3. Eliminar mecanics ");
                        System.out.println("4. Modificar mecanics (dni) ");
                        System.out.println("5. Listar UN mecanics (dni) ");
                        System.out.println("6. Salir ");
                        opcion6 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion6){
                            case 1 -> mecanic.añadir();
                            case 2 -> mecanic.llistar();
                            case 3 -> mecanic.eliminar();
                            case 4 -> mecanic.modificar();
                            case 5 -> mecanic.mostrarCotxe();
                            case 6 -> opcion6 = 6;
                            default -> System.out.println("Opción incorrecta");
                        }
                    }while(opcion6 !=6);
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        }
    }
}
