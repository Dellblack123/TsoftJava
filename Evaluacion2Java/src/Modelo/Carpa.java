package Modelo;

public class Carpa extends MedioDeAlojamiento implements Calculos{
    private int cantidadPersonas;

    public Carpa(DatosCliente datCli, int cantNoches, int tipoTemporada, double valorBaseNoche, int cantidadPersonas) {
        super(datCli, cantNoches, tipoTemporada, valorBaseNoche);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
    }

    @Override
    public String toString() {
        return super.toString()+"Carpa{" +
                "cantidadPersonas=" + cantidadPersonas +
                '}';
    }
}
