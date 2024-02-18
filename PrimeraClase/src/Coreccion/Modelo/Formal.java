package Coreccion.Modelo;

public abstract class Formal extends Calzado{
    String color;

    public Formal(int numero, String diaVenta, Producto producto, String color) {
        super(numero, diaVenta, producto);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void descuento();
}
