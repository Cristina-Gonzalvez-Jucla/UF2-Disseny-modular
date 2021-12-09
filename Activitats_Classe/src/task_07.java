import java.util.Scanner;

public class task_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indica el pes de la maleta: ");
        System.out.println("Indica l'alçada de la maleta: ");
        float alçada = scan.nextFloat();

        System.out.println("Indica l'allargada de la maleta: ");
        float allargada = scan.nextFloat();

        System.out.println("Indica la profunditat de la maleta: ");
        float profunditat = scan.nextFloat();

    }

    public static int comprobarIntegro(Scanner scan, String mensajeError) {
        while (!scan.hasNextInt()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }

        return scan.nextInt();
    }

    public void checkingCabinBag(float weight, float height, float width, float depth) {
        final float MAX_WEIGHT = 10.0f; //kg
        final float MAX_HEIGHT = 55.0f; //cm
        final float MAX_WIDTH = 40.0f; //cm
        final float MAX_DEPTH = 20.0f; //cm
        boolean isCabinBag = weight <= MAX_WEIGHT && height <= MAX_HEIGHT && width <= MAX_WIDTH && depth <= MAX_DEPTH;
        if (isCabinBag) {
            System.out.println("Ok, it is a cabin bag.");
        } else {
            System.out.println("Sorry, it is not a cabin bag.");
            System.out.println("It is necessary to check it.");
        }
    }
}
