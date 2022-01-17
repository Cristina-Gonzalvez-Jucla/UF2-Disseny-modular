import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcioMenu = 0;

        do {
            System.out.println("Indica el primer nombre");
            float primerNombre = scanner.nextFloat();
            System.out.println("Indica el segon nombre");
            float segonNombre = scanner.nextFloat();

            System.out.println("Menú");
            System.out.println("1.Suma");
            System.out.println("2.Resta");
            System.out.println("3.Producte");
            System.out.println("4.Divisio");
            System.out.println("5.Exponencial");
            System.out.println("6.Sortir");


            System.out.println("Indica el nuemero de l'operacio que vols triar");
            opcioMenu = scanner.nextInt();

            switch (opcioMenu) {
                case 1:
                    suma(primerNombre, segonNombre);
                    break;
                case 2:
                    resta(primerNombre, segonNombre);
                    break;
                case 3:
                    multiplicacio(primerNombre, segonNombre);
                    break;
                case 4:
                    divisio(primerNombre, segonNombre);
                    break;
                case 5:
                    exponencial(primerNombre, segonNombre);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }

        } while (opcioMenu != 6);

    }
        public static void suma ( float x, float y){
            float resultat = x + y;
            System.out.println("El resultat de la suma de " + x + " " + y + " es de: " + resultat);
        }

        public static void resta ( float x, float y){
            float resultat = x - y;
            System.out.println("El resultat de la resta de " + x + " " + y + " es de: " + resultat);
        }

        public static void multiplicacio ( float x, float y){
            float resultat = x * y;
            System.out.println("El resultat de la multiplicacio de " + x + " " + y + " es de: " + resultat);
        }

        public static void divisio ( float x, float y){
            float resultat = x / y;
            System.out.println("El resultat de la divisio de " + x + " " + y + " es de: " + resultat);
        }

        public static void exponencial ( float x, float y){
            double resultat = Math.pow(x, y);
            System.out.println("El resultat de la divisio de " + x + " " + y + " es de: " + resultat);
        }

        public static void controlFloat(Scanner scanner, int x){
        while(!scanner.hasNextFloat()){
            System.out.println("");
            }
    }
}

