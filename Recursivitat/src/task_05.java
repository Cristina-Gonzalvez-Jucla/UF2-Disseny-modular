import java.util.Scanner;

/*
 * Programar un algoritmo recursivo que permita sumar los
 * elementos de una matriz.
 */
public class task_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create a matrix where the user will introduce the numbers of the matrix
        System.out.println("Introdueix el nombre de files de la matriu");
        int n = sc.nextInt();
        System.out.println("Introdueix el nombre de columnes de la matriu");
        int m = sc.nextInt();
        int[][] matriu = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Introdueix el numero de la posicio " + i + " " + j);
                matriu[i][j] = sc.nextInt();
            }
        }
        System.out.println(suma(matriu, n , m));

    }

    public static int suma(int[][] matriu, int n, int m) {
        if (n == 0 && m == 0) {
            return matriu[n][m];
        } else {
            return matriu[n][m] + suma(matriu, n - 1, m - 1);
        }
    }

}

