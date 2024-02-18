package Coreccion.Modelo;

public class Calzado {
    int numero;
    String diaVenta;
    Producto producto;

    public Calzado(int numero, String diaVenta, Producto producto) {
        this.numero = numero;
        this.diaVenta = diaVenta;
        this.producto = producto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDiaVenta() {
        return diaVenta;
    }

    public void setDiaVenta(String diaVenta) {
        this.diaVenta = diaVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
