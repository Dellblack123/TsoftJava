package modelo;

public abstract class MedioAlojamiento extends Object{

    protected Cliente datCliente;//Datos del cliente
    protected int cantNoches;//Cantidad de noches
    protected String tipoTemporada;//Alta -0, Media - 1, Baja - 2
    protected double valNoche;//Valor base por noche

    public MedioAlojamiento(Cliente datCliente, int cantNoches, String tipoTemporada, double valNoche) {
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

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public double getValNoche() {
        return valNoche;
    }

    public void setValNoche(double valNoche) {
        this.valNoche = valNoche;
    }

    public abstract double subTotal();

    public double bonoDescuento(){return (getTipoTemporada().compareToIgnoreCase("Baja")==0)?subTotal()*0.25:(getTipoTemporada().compareToIgnoreCase("Media")==0)?subTotal()*0.125:0;}

    public abstract double valorCancelar();

    public abstract double adicional();
}
