package Modelo;

public class Carpa extends MedioAlojamiento{
    private int cantPersonas;

    public Carpa(Cliente datCliente, int cantNoches, int tipoTemporada, double valNoche, int cantPersonas) {
        super(datCliente, cantNoches, tipoTemporada, valNoche);
        this.cantPersonas = cantPersonas;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }


    @Override
    public double valorCancelar() {
        return subTotal()-bonoDescuento()+adicional();
    }

    @Override
    public double adicional() {
        return 0;
    }
}
