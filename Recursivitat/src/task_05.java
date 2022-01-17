import java.util.Scanner;

/*
 * Programar un algoritmo recursivo que permita sumar los
 * elementos de una matriz.
 */
public class task_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el nombre de files que vols que tingui la matriu: ");
        int numeroFiles = scanner.nextInt();
        System.out.println("Indica el nombre de columnes que vols que tingui la matriu: ");
        int numeroColumnes = scanner.nextInt();
        int[][] vector = new int[numeroFiles][numeroColumnes];


        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[i].length; j++) {
                System.out.println("indica el valor de la posicio " + i + ", " + j);
                vector[i][j] = scanner.nextInt();
                System.out.println("El valr de la posicio " + i + ", " + j + " es igual a: " + vector[i][j]);
            }
        }
        System.out.println("El valor de la suma dels valors es de: " + sumaElementosMatriz(vector, numeroFiles - 1, numeroColumnes - 1));
    }

    public static int sumaElementosMatriz(int[][] array, int fila, int columna) {
        if (fila == 0 && columna == 0) {
            return array[fila][columna];
        } else {
            if (columna != 0) {

            }
            return array[fila - 1][columna - 1] += sumaElementosMatriz(array, fila - 1, columna - 1);
        }
    }
}
/*
* if (fila == matriu.length){
* return 0; CAS BASE
*
* } else if (fila < matriu.lenght && columna == matriu[fila].lenght) {
* return 0 + sumarElementsMatriu2(matriu, fila + 1, columna); CAS RECURSIU 1
*
* }else {
* return matriu[fila][columna] + sumarElementsMatriu2(matriu, fila, columna+1);  CAS RECURSIU 2
* */
