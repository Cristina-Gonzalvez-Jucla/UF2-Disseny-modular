/*
 *Programar un algoritmo recursivo que permita
 *hacer la división por restas sucesivas.
 */

import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el divident");
        int divident = 0;
        divident = comprobarIntegro(scanner, "Incica el divident");


        System.out.println("Incica el divisor");
        int divisor = 0;
        divisor = comprobarIntegro(scanner, "Incica el divisor");

        System.out.printf("El resultat d'aquesta divisio es de: " + divisioRecursiva(divident, divisor));
    }

    public static int divisioRecursiva(int a, int b) {

        if (a < b) {
            return 0;
        } else {
            return divisioRecursiva(a - b, b) + 1;
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
