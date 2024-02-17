package Modelo;

public class Hotel extends Hospederia{
    private boolean conDesayuno;

    public Hotel(Cliente datCliente, int cantNoches, int tipoTemporada, double valNoche, int capacidad, boolean fumador, boolean conDesayuno) {
        super(datCliente, cantNoches, tipoTemporada, valNoche, capacidad, fumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    @Override
    public double adicional() {
        return (isFumador() && isConDesayuno())?subTotal()*0.3:0;
    }

    @Override
    public double valorCancelar() {
        return subTotal()-bonoDescuento()+adicional();
    }
}
