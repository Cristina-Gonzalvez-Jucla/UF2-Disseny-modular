import java.util.Scanner;

/*
 * Programar un algoritmo recursivo que permita multiplicar los
 * elementos de un vector
 */
public class task_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la quantitat de numeros que vols introduir");
        int n = sc.nextInt();
        int[] matriu = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introdueix el numero " + (i+1));
            matriu[i] = sc.nextInt();
        }

        int resultat = multiplicacio(matriu, 0);
        System.out.println("El resultat de la suma es: " + resultat);
    }

    public static int multiplicacio(int[] vector, int i) {
        if (i == 0) {
            return vector[0];
        } else {
            return vector[i] * multiplicacio(vector, i - 1);
        }
    }
}
