/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorreservas;

public class Validador {

    public static boolean horaValida(int hora) {
        return hora >= 8 && hora <= 17;
    }

    public static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean servicioValido(int servicio) {
        return servicio >= 1 && servicio <= 3;
    }
}