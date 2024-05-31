import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nParqueadero el Atraco");
            System.out.println("1. Inicializar Pila");
            System.out.println("2. Ingreso");
            System.out.println("3. Retiro");
            System.out.println("4. Buscar Posición");
            System.out.println("5. Mostrar Pila");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: \n");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            switch (opcion) {
                case 1:
                    parqueadero.inicializarPila();
                    System.out.println("Pila inicializada.");
                    break;
                case 2:
                    System.out.print("Ingrese placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese fecha de ingreso (YYYY-MM-DD): ");
                    String fechaIngreso = scanner.nextLine();
                    System.out.print("Ingrese hora de ingreso (HH:MM): ");
                    String horaIngreso = scanner.nextLine();
                    parqueadero.ingresarVehiculo(placa, fechaIngreso, horaIngreso);
                    System.out.println("Vehículo ingresado.");
                    break;
                case 3:
                    System.out.print("Ingrese placa del vehículo a retirar: ");
                    String placaRetiro = scanner.nextLine();
                    System.out.print("Ingrese fecha de salida (YYYY-MM-DD): ");
                    String fechaSalida = scanner.nextLine();
                    System.out.print("Ingrese hora de salida (HH:MM): ");
                    String horaSalida = scanner.nextLine();
                    parqueadero.retirarVehiculo(placaRetiro, fechaSalida, horaSalida);
                    break;
                case 4:
                    System.out.print("Ingrese placa del vehículo a buscar: ");
                    String placaBusqueda = scanner.nextLine();
                    parqueadero.buscarVehiculo(placaBusqueda);
                    break;
                case 5:
                    parqueadero.mostrarPila();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
