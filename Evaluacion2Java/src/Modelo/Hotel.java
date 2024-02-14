package Modelo;

public class Hotel extends Hospederia implements Calculos{
    private boolean conDesayuno;

    public Hotel(DatosCliente datCli, int cantNoches, int tipoTemporada, double valorBaseNoche, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datCli, cantNoches, tipoTemporada, valorBaseNoche, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    @Override
    public double subTotal() {
        return getCantNoches()*getValorBaseNoche();
    }

    @Override
    public double adicional() {
        if (isEsFumador() && conDesayuno)
            return 0.3*subTotal();
        return 0;
    }

    @Override
    public double bonoDescuento() {
        if (getTipoTemporada()==2){//MEDIA
            return 0.25*subTotal();
        }else if (getTipoTemporada()==3){//BAJA
            return 0.125*subTotal();
        }
        return 0;
    }

    @Override
    public double valorACancelar() {
        return subTotal()-bonoDescuento()+adicional();
    }

    @Override
    public void incrementarValorBase() {
    }

    @Override
    public String toString() {
        return super.toString()+"Hotel{" +
                "conDesayuno=" + conDesayuno +
                '}';
    }
}
