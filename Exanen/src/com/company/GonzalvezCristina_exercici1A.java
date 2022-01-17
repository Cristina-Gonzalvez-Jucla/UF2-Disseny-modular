package com.company;

import java.util.Scanner;

/**
 * Modula el següent codi.
 * -->Crea un mètode per llegir
 * -->Crea un mètode per comprobar si el valor llegit és enter o no
 */
public class GonzalvezCristina_exercici1A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String RESET = "\u001B[0m";

        int valor = 0;

        System.out.println("Benvingut/da al detector de senars.");
        llegirEnter(scanner);
    }

    public static int llegirEnter(Scanner scanner) {
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String RESET = "\u001B[0m";
        do {
            System.out.print("Escriu un enter: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Dades erroneas, has d'introduir un enter: ");
                scanner.next();
            }
        } while (!scanner.hasNextInt());

        int nombre = scanner.nextInt();
        parellSenar(nombre);

        return 0;
    }

    public static void parellSenar(int nombre) {
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String RESET = "\u001B[0m";
        if (nombre % 2 != 0) {
            System.out.println(GREEN + "El número és senar" + RESET);
        } else {
            System.out.println(RED + "El número és parell" + RESET);
        }
    }
}