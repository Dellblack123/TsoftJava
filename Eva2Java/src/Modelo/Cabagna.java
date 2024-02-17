package Modelo;

public class Cabagna extends Hospederia{
    private boolean chimenea;

    public Cabagna(Cliente datCliente, int cantNoches, int tipoTemporada, double valNoche, int capacidad, boolean fumador, boolean chimenea) {
        super(datCliente, cantNoches, tipoTemporada, valNoche, capacidad, fumador);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }



    @Override
    public double adicional() {
        return 0;
    }

    @Override
    public double valorCancelar() {
        return subTotal()-bonoDescuento()+adicional();
    }
}
