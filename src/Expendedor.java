import Excepciones.*;
import Monedas.*;
import Productos.*;

public class Expendedor {

    /** Depositos genéricos para cada tipo de producto
      */
    private Deposito<Producto> depCoca;
    private Deposito<Producto> depFnt;
    private Deposito<Producto> depSprt;
    private Deposito<Producto> depSup8;
    private Deposito<Producto> depSnick;

    //Deposito genérico para las monedas de vuelto
    private Deposito<Moneda> monedaVuelto;

    /**
      * Constructor que llena los depósitos
      * @param numProductos cantidad inicial de cada producto.
      */
    public Expendedor(int numProductos) {
        this.depCoca = new Deposito<>();
        this.depFnt = new Deposito<>();
        this.depSprt = new Deposito<>();
        this.depSup8 = new Deposito<>();
        this.depSnick = new Deposito<>();
        this.monedaVuelto = new Deposito<>();

        /** LLenado de los depósitos con numeros de serie únicos.
          */
        for (int i = 0; i < numProductos; i++) {
            depCoca.addElemento(new CocaCola(100 + i));
            depFnt.addElemento(new Fanta(200 + i));
            depSprt.addElemento(new Sprite(300 + i));
            depSup8.addElemento(new Super8(400 + i));
            depSnick.addElemento(new Snickers(500 + i));
        }
    }


    /** Metodo para comprar un producto del expendedor. Se verifica si la moneda es válida,
     * si hay stock disponible del producto seleccionado y si el valor de la moneda es suficiente
     * para la compra. Si todo es correcto, se devuelve el producto comprado y se da el vuelto.
     *
     * @param m La moneda utilizada para realizar la compra.
     * @param cual El número del producto que se desea comprar:
     *             1: CocaCola, 2: Fanta, 3: Sprite, 4: Super8, 5: Snickers
     * @return El producto comprado si el pago es válido y hay stock disponible.
     * @throws PagoIncorrectoException Si la moneda ingresada es nula.
     * @throws NoHayProductoException Si no hay más unidades del producto seleccionado.
     * @throws PagoInsuficienteException Si el valor de la moneda no es suficiente para la compra.
     */

    public Producto comprarProducto(Moneda m, int cual) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        try {
            if (m == null) {
                throw new PagoIncorrectoException("Moneda nula: no se puede realizar el pago");
            } else {
                int valor = m.getValor();
                Producto productoSeleccionado = null;
                int precio = 0;
                switch (cual) {
                    case 1:
                        productoSeleccionado = depCoca.getElemento();
                        precio = Catalogo.CocaCola.getPrecio();
                        break;
                    case 2:
                        productoSeleccionado = depFnt.getElemento();
                        precio = Catalogo.Fanta.getPrecio();
                        break;
                    case 3:
                        productoSeleccionado = depSprt.getElemento();
                        precio = Catalogo.Sprite.getPrecio();
                        break;
                    case 4:
                        productoSeleccionado = depSup8.getElemento();
                        precio = Catalogo.Super8.getPrecio();
                        break;
                    case 5:
                        productoSeleccionado = depSnick.getElemento();
                        precio = Catalogo.Snickers.getPrecio();
                        break;
                }
                if (valor >= precio) {
                    if (productoSeleccionado != null) {
                        int vuelto = valor - precio;
                        while (vuelto / 100 > 0) {
                            monedaVuelto.addElemento(new Moneda100());
                            vuelto -= 100;
                        }
                        return productoSeleccionado;
                    } else {
                        while (valor / 100 > 0) {
                            monedaVuelto.addElemento(new Moneda100());
                            valor -= 100;
                        }
                        throw new NoHayProductoException("No hay producto");
                    }
                } else {
                    while (valor / 100 > 0) {
                        monedaVuelto.addElemento(new Moneda100());
                        valor -= 100;
                    }
                    throw new PagoInsuficienteException("No hay dinero suficiente");
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * Metodo para obtener el vuelto del expendedor.
     *
     * @return El vuelto en forma de monedas, si las hay.
     */
    public Moneda getVuelto(){
        return monedaVuelto.getVuelto();
    }
}