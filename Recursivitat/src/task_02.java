/*
 * Programar un algoritmo recursivo que permita sumar los dígitos
 * de un número.Ejemplo: Entrada:123 Resultado:6
 * */

import java.util.Scanner;

public class task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre: ");
        int nombre = 0;
        nombre = comprobarIntegro(scanner, "Introdueix un nombre: ");

        System.out.println("La suma de tots els digits es de: " + suma(nombre));
    }

    private static int suma(int a) {
        if (a == 0) {
            return 0;
        } else {
            return suma(a / 10) + a % 10;
        }
    }

    public static int comprobarIntegro(Scanner scan, String mensajeError) {
        while (!scan.hasNextInt()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }
        return scan.nextInt();
    }


}
