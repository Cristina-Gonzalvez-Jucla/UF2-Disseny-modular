/*
 * Ejercicio 5
 * Realizar dos métodos, uno que haga la conversión de Celcius a Fahrenheit y el otro
 * de Fahrenheit a Celcius; teniendo en cuenta que la fórmula de la conversión es la siguiente:
 * Fahrenheit = (9,0 / 5) * Celcius + 32
 * Celcius = (5,0 / 9) * (Fahrenheit - 32)
 * */

import java.util.Scanner;

public class task_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menuEscollit = 0;

        System.out.println("--------------------------------------------");
        System.out.println("|  Benvingut al Conversor de Temperatures  |");
        System.out.println("--------------------------------------------");

        while (menuEscollit > 4 || menuEscollit < 1) {
            System.out.println("|      Introdueix un numero del 1 al 4     |");
            System.out.println("--------------------------------------------");
            System.out.println("|          1.Tria l'opcio desitjada        |");
            System.out.println("|   2. Convversio de Celcius a Fahrenheit  |\n" +
                    "|   3.Conversio de Fahrenheit a Celcius    |\n" +
                    "|               4. Sortir                  |");
            System.out.println("--------------------------------------------");
            menuEscollit = comprobarIntegro(scan, "|      Introdueix un numero del 1 al 4     |\n--------------------------------------------\n" +
                    "|          1.Tria l'opcio desitjada        |\n|   2. Convversio de Celcius a Fahrenheit  |\n|   3.Conversio de Fahrenheit a Celcius    |\n" +
                    "|               4. Sortir                  | \n|               4. Sortir                  |");

        }

        switch (menuEscollit) {
            case 1:
                float temperaturaCelcius = 0;
                System.out.println("Indica la temperatura en Graus Celcius per saber la conversio a Fahrenheit");
                menuEscollit = comprobarIntegro(scan, "Indica la temperatura en Graus Celcius per saber " +
                        "la conversio a Fahrenheit");
                System.out.println(scan);
                break;
            case 2:
                float temperaturaFahrenheit;
                System.out.println("Menu 2");
                break;
            case 3:
                break;


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

    public static Float conversioCerlcius(Scanner scan, float temperaturaC) {
        float tempC = 0;
        System.out.println((9.0 / 5 * tempC) + 32);
        System.out.println(temperaturaC);
        return scan.nextFloat();
    }

}


