package Modelo;

public abstract class MedioAlojamiento extends Object{
    protected Cliente datCliente;//Datos del cliente
    protected int cantNoches;//Cantidad de noches
    protected int tipoTemporada;//Alta -0, Media - 1, Baja - 2
    protected double valNoche;//Valor base por noche

    public MedioAlojamiento(Cliente datCliente, int cantNoches, int tipoTemporada, double valNoche) {
        this.datCliente = datCliente;
        this.cantNoches = cantNoches;
        this.tipoTemporada = tipoTemporada;
        this.valNoche = valNoche;
    }

    public Cliente getDatCliente() {
        return datCliente;
    }

    public void setDatCliente(Cliente datCliente) {
        this.datCliente = datCliente;
    }

    public int getCantNoches() {
        return cantNoches;
    }

    public void setCantNoches(int cantNoches) {
        this.cantNoches = cantNoches;
    }

    public int getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(int tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public double getValNoche() {
        return valNoche;
    }

    public void setValNoche(double valNoche) {
        this.valNoche = valNoche;
    }

    public double subTotal() {
        return getCantNoches()*getValNoche();
    }

    public double bonoDescuento(){return (getTipoTemporada()==2)?subTotal()*0.25:(getTipoTemporada()==1)?subTotal()*0.125:0;}

    public abstract double valorCancelar();

    public abstract double adicional();
}
