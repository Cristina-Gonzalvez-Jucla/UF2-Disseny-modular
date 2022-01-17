import java.util.Scanner;

/*
 * Programar un algoritmo recursivo que muestre el número menor
 * de un vector.
 * */
public class task_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica quants nombres vols introduir");
        int llargadaVector = scanner.nextInt();
        int[] vector = new int[llargadaVector];
        int nummin = Integer.MAX_VALUE;

        for (int i = 0; i < llargadaVector; i++) {
            System.out.println("Indica el valor de la posicio " + i);
            vector[i] = scanner.nextInt();
            System.out.println("El valor de la posicio " + i + " es igual a: " + vector[i]);
        }
        System.out.println("El nombre menor del vector es de: " + nombreMenor(new int[]{(vector[llargadaVector])}, llargadaVector, nummin));
    }

    public static int nombreMenor(int[] array, int posicio, int menor) {
        if (array[posicio] < menor) {
            menor = array[posicio];
        }
        if (posicio + 1 < array.length) {
            return nombreMenor(array, posicio + 1, menor);
        }
        return menor;
    }
}

/*
*
* */


