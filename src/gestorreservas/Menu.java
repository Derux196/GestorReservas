/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorreservas;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        System.out.println("\n===== GESTOR DE RESERVAS =====");
        System.out.println("1. Agendar reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Cancelar reserva");
        System.out.println("4. Ver reporte del día");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}