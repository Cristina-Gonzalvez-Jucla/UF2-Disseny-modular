import java.util.Scanner;

public class task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        rellenar(scanner, numeros);
    }


    public static void rellenar(Scanner scanner, int[] a) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Indica el valor de la posisio " + i);
            int j = scanner.nextInt();
            a[i] = j;
        }
    }

    public static int mostrar(int c) {
        for (int i = 0; i < 10; i++) {
            System.out.println("EL valor de la posicio " + c + " es de: ");

        }
        return 0;
    }
}
