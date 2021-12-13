import java.util.Scanner;

/*
 * Programar un algoritmo recursivo que muestre el número menor
 * de un vector.
 * */
public class task_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la quantitat de numeros que vols introduir");
        int n = sc.nextInt();
        int[] matriu = new int[n];
    }

    public static int min(int[] v, int n) {
        if (n == 1) {
            return v[0];
        } else {
            if (v[n - 1] < v[n - 2]) {
                return min(v, n - 1);
            } else {
                return min(v, n - 2);
            }
        }
    }


}
