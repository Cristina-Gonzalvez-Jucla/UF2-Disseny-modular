import java.text.DecimalFormat;
import java.util.Scanner;

public class task_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indica el nombre d'articles que vol comprar");
        int numeroArticles = comprobarIntegro(scan, "Indica el nombre d'articles que vol comprar");

        String[] nomArticle = new String[numeroArticles];
        float[] preuArticles = new float[numeroArticles];

        for (int i = 0; i < numeroArticles; i++) {
            System.out.print("Indica el nom del producte: ");
            String nomProducte = comprobarCaracter(scan, "Indica el nom del producte: ");
            nomArticle[i] = nomProducte;

            System.out.println("Indica el preu del producte: ");
            float preuProducte = comprobarFloat(scan, "Indica el preu del producte: ");
            preuArticles[i] = preuProducte;
        }

        generarTicket(nomArticle, preuArticles);
    }

    public static void generarTicket(String[] noms, float[] preus) {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("-----------------------------------------");
        System.out.println("|\t\t\t\tTICKET\t\t\t\t\t|");
        System.out.println("|---------------------------------------|");
        System.out.println("|\t"
                + noms.length +
                " ARTICLES\t\t\t\t\t\t\t|");
        System.out.println("|---------------------------------------|");

        for (int i = 0; i < noms.length; i++) {
            System.out.println("|\t"
                    + noms[i] +
                    "\t\t\t\t"
                    + preus[i] +
                    "\t\t\t|");
        }

        System.out.println("|---------------------------------------|");
        System.out.println("|\t\t\t"
                + calcularPreuTotal(preus) +
                "€\t"
                + df.format(calcularIVA(calcularPreuTotal(preus))) +
                "€ (IVA)\t\t|");
        System.out.println("-----------------------------------------");
    }

    public static int comprobarIntegro(Scanner scan, String mensajeError) {
        while (!scan.hasNextInt()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }

        return scan.nextInt();

    }

    public static String comprobarCaracter(Scanner scan, String mensajeError) {
        while (scan.hasNextInt()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }

        return scan.next();

    }

    public static float comprobarFloat(Scanner scan, String mensajeError) {
        while (!scan.hasNextFloat()) {
            System.out.println("Dades erroneas ");
            System.out.println(mensajeError);
            scan.next();
        }

        return scan.nextFloat();

    }

    public static float calcularPreuTotal(float[] preusArticle) {
        float suma = 0;
        for (int i = 0; i < preusArticle.length; i++) {
            suma += preusArticle[i];
        }

        return suma;
    }

    public static float calcularIVA(float preuACalcular) {
        return preuACalcular + (preuACalcular * 0.21f);
    }
}
