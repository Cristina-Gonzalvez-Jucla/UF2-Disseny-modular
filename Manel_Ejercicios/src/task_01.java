import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];
        int nummax = Integer.MIN_VALUE;
        int nummin = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            System.out.println("Indica el valor que quieres asignarle a la posicion: " + i);
            int j = scanner.nextInt();
            valores[i] = j;
            System.out.println("El valor que le has asignado a la posicion " + i + " es de: " + valores[i]);
            if (valores[i] > nummax) {
                nummax = valores[i];
            }
            if (valores[i] < nummin) {
                nummin = valores[i];
            }

        }
        System.out.println(nummax);
        System.out.println(nummin);
    }
}
