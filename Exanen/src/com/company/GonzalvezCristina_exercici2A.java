package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GonzalvezCristina_exercici2A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int x = 0;

        list.add(220);
        list.add(1184);
        list.add(2620);
        list.add(5020);
        list.add(6232);
        list.add(10744);
        list.add(12285);
        list.add(17296);
        list.add(63020);
        list.add(66928);
        list.add(67095);
        list.add(69615);
        list.add(79750);

        System.out.println("Nombre aleatori: " + nombreAleatori(list));
        long numAleatori = nombreAleatori(list);

        x = comprobarRangNumeros(scanner, "Dades erroneas ");


        if (calculSumaNombresDivisibles(numAleatori, 1, 0) == calculSumaNombresDivisibles(x, 1, 0)){
            System.out.println("son nombres lligats");
        } else{
            System.out.println("No son nombres lligats");
        }
    }

    public static int nombreAleatori(List<Integer> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static int comprobarRangNumeros(Scanner scan, String mensajeError) {

        System.out.println("Introdueix un nombre enter entre el 200 i el 100.000 ");
        int numero = comprobarIntegro(scan, mensajeError);

        while (numero < 200 || numero > 100000) {
            System.out.print(mensajeError);
            System.out.println("El numero ha de ser entre 200 i 100.000 ");
            numero = comprobarIntegro(scan, mensajeError);
        }
        return numero;
    }

    public static int comprobarIntegro(Scanner scan, String mensajeError) {
        while (!scan.hasNextInt()) {
            System.out.print(mensajeError);
            System.out.println("El numero ha de ser un enter");
            scan.next();
        }
        return scan.nextInt();
    }

    public static int calculSumaNombresDivisibles(long numero, int i, int total) {
        if (i == numero) {
            return total;
        }

        if (numero % i == 0) {
            total += i;
        }
        return calculSumaNombresDivisibles(numero, i + 1, total);
    }
}


