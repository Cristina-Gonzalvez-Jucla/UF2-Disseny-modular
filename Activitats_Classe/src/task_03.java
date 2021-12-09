/*
 * Un peograma nuevo que:
 *   - Tenga control de errores numerico
 *   - Devuelva la info que el valor introducido es par o no*/

import java.util.Scanner;

public class task_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nombre = 0;
        System.out.println("Indica un nombre");
        nombre = comprobarIntegro(scan, "Indica un nombre");
    }

    public static int comprobarIntegro(Scanner scan, String mensajeError) {
        while (!scan.hasNextInt()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }

        return scan.nextInt();

    }
    public static int NumeroPar(int nombre) {

        if (nombre % 2 == 0)
            System.out.println("Entered number is even");
        else
            System.out.println("Entered number is odd");
        return nombre;
    }
}

