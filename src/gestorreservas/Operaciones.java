package gestorreservas;

import java.util.Scanner;

public class Operaciones {

    private static final int CUPO_MAXIMO = 10;

    private static String[] clientes = new String[CUPO_MAXIMO];
    private static int[] horas = new int[CUPO_MAXIMO];
    private static int[] servicios = new int[CUPO_MAXIMO];

    private static int contador = 0;

    public static void agendar(Scanner scanner) {
        if (contador >= CUPO_MAXIMO) {
            System.out.println("No hay cupos disponibles para más reservas.");
            return;
        }

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        if (!Validador.nombreValido(nombre)) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Hora de la reserva (8 a 17): ");
        int hora = leerEntero(scanner);

        if (!Validador.horaValida(hora)) {
            System.out.println("Hora inválida. Solo se permiten horas entre 8 y 17.");
            return;
        }

        if (horaOcupada(hora)) {
            System.out.println("Esa hora ya está ocupada. Elige otra.");
            return;
        }

        mostrarServicios();

        System.out.print("Elige el servicio: ");
        int servicio = leerEntero(scanner);

        if (!Validador.servicioValido(servicio)) {
            System.out.println("Servicio inválido. Debe ser 1, 2 o 3.");
            return;
        }

        clientes[contador] = nombre.trim();
        horas[contador] = hora;
        servicios[contador] = servicio;

        contador++;

        System.out.println("Reserva agendada correctamente.");
    }

    public static void listar() {
        if (contador == 0) {
            System.out.println("Aún no hay reservas registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE RESERVAS =====");

        for (int i = 0; i < contador; i++) {
            System.out.println("Reserva #" + (i + 1));
            System.out.println("Cliente: " + clientes[i]);
            System.out.println("Hora: " + horas[i] + ":00");
            System.out.println("Servicio: " + nombreServicio(servicios[i]));
            System.out.println("-----------------------------");
        }
    }

    public static void cancelar(Scanner scanner) {
        if (contador == 0) {
            System.out.println("No hay reservas para cancelar.");
            return;
        }

        listar();

        System.out.print("Ingresa el número de la reserva a cancelar: ");
        int numeroReserva = leerEntero(scanner);

        if (numeroReserva < 1 || numeroReserva > contador) {
            System.out.println("Número de reserva inválido.");
            return;
        }

        int indice = numeroReserva - 1;

        for (int i = indice; i < contador - 1; i++) {
            clientes[i] = clientes[i + 1];
            horas[i] = horas[i + 1];
            servicios[i] = servicios[i + 1];
        }

        clientes[contador - 1] = null;
        horas[contador - 1] = 0;
        servicios[contador - 1] = 0;

        contador--;

        System.out.println("Reserva cancelada correctamente.");
    }

    public static void reporte() {
        int totalFacturado = 0;

        for (int i = 0; i < contador; i++) {
            totalFacturado += precioServicio(servicios[i]);
        }

        System.out.println("\n===== REPORTE DEL DÍA =====");
        System.out.println("Total de citas agendadas: " + contador);
        System.out.println("Total facturado: $" + totalFacturado);
    }

    private static boolean horaOcupada(int hora) {
        for (int i = 0; i < contador; i++) {
            if (horas[i] == hora) {
                return true;
            }
        }

        return false;
    }

    private static void mostrarServicios() {
        System.out.println("\nServicios disponibles:");
        System.out.println("1. Corte de cabello - $25000");
        System.out.println("2. Tinte - $60000");
        System.out.println("3. Manicure - $30000");
    }

    private static String nombreServicio(int servicio) {
        switch (servicio) {
            case 1:
                return "Corte de cabello";
            case 2:
                return "Tinte";
            case 3:
                return "Manicure";
            default:
                return "Servicio desconocido";
        }
    }

    private static int precioServicio(int servicio) {
        switch (servicio) {
            case 1:
                return 25000;
            case 2:
                return 60000;
            case 3:
                return 30000;
            default:
                return 0;
        }
    }

    private static int leerEntero(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}