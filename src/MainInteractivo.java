import java.util.Scanner;
import Excepciones.*;
import Monedas.*;

public class MainInteractivo {
    public static void main(String[] args) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        {

            boolean run = true;
            while (run) {

                Moneda m;
                Comprador c;

                System.out.println("Bienvenid@ a la Maquina Expendedora!");
                System.out.println("Ingrese Moneda");
                Scanner scanner = new Scanner(System.in);
                int valor = scanner.nextInt();

                if (valor == 1000) {
                    m = new Moneda1000();
                } else if (valor == 500) {
                    m = new Moneda500();
                } else if  (valor == 100) {
                    m = new Moneda100();
                } else {
                    System.out.println("Moneda no valida");
                    continue;
                }
                System.out.println("");
                System.out.println("Seleccione un producto:");
                System.out.println("1 = CocaCola");
                System.out.println("2 = Fanta");
                System.out.println("3 = Sprite");
                System.out.println("4 = Super8");
                System.out.println("5 = Snickers");
                System.out.print("Ingrese el número de su elección o ingrese 0 para salir: ");
                System.out.println("");

                int opcion = scanner.nextInt();
                if (opcion == 0) {
                    System.out.println("Gracias por comprar con nosotros!");
                    run = false;
                } else {
                    c = new Comprador(m, opcion);

                    System.out.println("Compraste: " + c.queCompraste());
                    System.out.println("Tu vuelto es: " + c.cuantoVuelto());
                    System.out.println("");
                }
            }
        }
    }
}