import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduiex un nombre per saber si es par");
        float nombre = scanner.nextFloat();
        calcularNombreParell(nombre);
    }

    public static void calcularNombreParell(float n) {
        if ((n % 2) == 0) {
            System.out.println("El nombre es par");
        } else {
            System.out.println("El nombre es impar");
        }
    }
}
