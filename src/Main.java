import Excepciones.*;
import Monedas.*;


public class Main {
    public static void main(String[] args) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        Moneda m;
        Comprador c;

        // 1 = CocaCola
        c = new Comprador(m = new Moneda1000(), 1);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // 2 = Sprite
        c = new Comprador(m = new Moneda1000(), 2);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // 3 = Fanta
        c = new Comprador(m = new Moneda1000(), 3);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // 4 = Super8
        c = new Comprador(m = new Moneda1000(), 4);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // 5 = Snickers
        c = new Comprador(m = new Moneda1000(), 5);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // Excepcion Moneda Nula.

        c = new Comprador(m = null, 3);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

        // Excepcion Dinero Insuficiente

        c = new Comprador(m = new Moneda100(), 5);
        System.out.println(c.queCompraste() + ", Vuelto: " + c.cuantoVuelto());

    }
}
