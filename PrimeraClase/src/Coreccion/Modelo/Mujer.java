package Coreccion.Modelo;

public class Mujer extends Formal{
    private int alturaTaco;

    public Mujer(int numero, String diaVenta, Producto producto, String color, int alturaTaco) {
        super(numero, diaVenta, producto, color);
        this.alturaTaco = alturaTaco;
    }

    public int getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(int alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    @Override
    public void descuento() {

    }
}
