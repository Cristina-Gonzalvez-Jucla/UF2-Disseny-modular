

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombre = 28;

        if(calculatePerfectResult(nombre, 1, 0) == nombre) {
            System.out.println("ES PERFECTO");
        }else{
            System.out.println("NO ES PERFECTO");
        }
    }

    public static int calculatePerfectResult(int num, int i, int total) {
        if(i == num) {
            return total;
        }

        if(num % i == 0) {
            total += i;
        }

        return calculatePerfectResult(num, i + 1, total);
    }

}

