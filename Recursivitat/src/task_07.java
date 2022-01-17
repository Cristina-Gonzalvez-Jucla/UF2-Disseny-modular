import java.util.Scanner;

public class task_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el precio de la venta");
        double precioVenta = scanner.nextDouble();
        calcula_bonificacion(precioVenta);
    }

    public static void calcula_bonificacion (double precioVenta){
        if (precioVenta < 20000){
            double calculoPorcentaje = (precioVenta / 2) * 100;
            double PrecioFinal = (precioVenta + 7000) + calculoPorcentaje;
            System.out.println("EL precio final del producto es de: " + PrecioFinal);
        }else if (precioVenta > 20000 && precioVenta < 50000){
            double calculoPorcentaje = (precioVenta / 3) * 100;
            double PrecioFinal = (precioVenta + 15000) + calculoPorcentaje;
            System.out.println("EL precio final del producto es de: " + PrecioFinal);
        }else {
            double calculoPorcentaje = (precioVenta / 12) * 100;
            double PrecioFinal = (precioVenta + 20000) + calculoPorcentaje;
            System.out.println("EL precio final del producto es de: " + PrecioFinal);
        }
    }
}
