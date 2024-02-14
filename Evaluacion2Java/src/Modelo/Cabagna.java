package Modelo;

public class Cabagna extends Hospederia implements Calculos{
    private boolean tieneChimenea;
    private boolean aumentado=false;

    public Cabagna(DatosCliente datCli, int cantNoches, int tipoTemporada, double valorBaseNoche, int capacidad, boolean esFumador, boolean tieneChimenea) {
        super(datCli, cantNoches, tipoTemporada, valorBaseNoche, capacidad, esFumador);
        this.tieneChimenea = tieneChimenea;
    }

    public boolean isAumentado() {
        return aumentado;
    }

    public void setAumentado(boolean aumentado) {
        this.aumentado = aumentado;
    }

    public boolean isTieneChimenea() {
        return tieneChimenea;
    }

    public void setTieneChimenea(boolean tieneChimenea) {
        this.tieneChimenea = tieneChimenea;
    }

    @Override
    public double subTotal() {
        return getCantNoches()*getValorBaseNoche();
    }

    @Override
    public double adicional() {
        return 0;
    }

    @Override
    public double bonoDescuento() {
        if (getTipoTemporada()==1){//MEDIA
            return 0.25*subTotal();
        }else if (getTipoTemporada()==2){//BAJA
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
        if (getCapacidad()>5 && !aumentado){
            setValorBaseNoche(getValorBaseNoche()+getValorBaseNoche()*0.18);
            aumentado=true;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Cabagna{" +
                "tieneChimenea=" + tieneChimenea +
                '}';
    }
}
