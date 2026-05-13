import Productos.Super8;

public enum Catalogo {



    CocaCola(1, 100),
    Fanta(2, 200),
    Sprite(3, 300),
    Super8(4, 400),
    Snickers(5, 500);

    private final int ID;
    private final int Precio;

    //Constructor que define la ID y Precio de cada producto

    Catalogo(int ID, int Precio) {
        this.ID = ID;
        this.Precio = Precio;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getID() {
        return ID;
    }
}