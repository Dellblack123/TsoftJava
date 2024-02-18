package Coreccion.Modelo;

public class Deportivo extends Calzado{
    int tipoDeporte;
    int tipoMaterial;

    public Deportivo(int numero, String diaVenta, Producto producto,int tipoDeporte, int tipoMaterial) {
        super(numero, diaVenta, producto);
        this.tipoDeporte = tipoDeporte;
        this.tipoMaterial = tipoMaterial;
    }

    public int getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(int tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public int getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(int tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
