package modelo;

public class Cabagna extends Hospederia{
    private boolean chimenea;

    public Cabagna(Cliente datCliente, int cantNoches, String tipoTemporada, double valNoche, int capacidad, boolean fumador, boolean chimenea) {
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

    @Override
    public String toString() {
        return "Medio de Alojamiento de tipo: Cabagna{" +
                "chimenea=" + isChimenea() +
                ", capacidad=" + capacidad +
                ", fumador=" + fumador +
                ", "+datCliente.toString() +
                ", cantNoches=" + cantNoches +
                ", tipoTemporada=" + tipoTemporada +
                ", valor base noche=" + valNoche +
                ", sub-Total: "+subTotal() +
                ", bono descuento: "+bonoDescuento() +
                ", valor adicional: "+adicional() +
                ", valor a cancelar: "+valorCancelar() +
                "}";
    }
}
