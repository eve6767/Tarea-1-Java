import java.util.ArrayList;
import Monedas.*;
import Excepciones.*;
import Productos.*;

/**
  * Deposito genérico para almacenar cualquier tipo de objeto T.
  * @param <T> Tipo de objeto(Producto, Moneda, etc).
  */

public class Deposito<T> {
    private ArrayList<T> almacen;

    public Deposito(){
        this.almacen = new ArrayList<T>();
    }
    public void addElemento(T item){
        this.almacen.add(item);
    }

    public Producto getElemento() {
        if (!almacen.isEmpty()) {
            return (Producto) almacen.remove(0);
        } else {
            return null;
        }
    }

    public Moneda100 getVuelto() {
        if (!almacen.isEmpty()) {
            return (Moneda100) almacen.remove(0);
        } else {
            return null;
        }
    }
}