/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorreservas;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = Menu.leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    Operaciones.agendar(scanner);
                    break;

                case 2:
                    Operaciones.listar();
                    break;

                case 3:
                    Operaciones.cancelar(scanner);
                    break;

                case 4:
                    Operaciones.reporte();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }
}