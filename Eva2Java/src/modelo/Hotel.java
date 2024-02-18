package modelo;

public class Hotel extends Hospederia{
    private boolean conDesayuno;

    public Hotel(Cliente datCliente, int cantNoches, String tipoTemporada, double valNoche, int capacidad, boolean fumador, boolean conDesayuno) {
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

    @Override
    public String toString() {
        return "Medio de Alojamiento de tipo: Hotel{" +
                "conDesayuno=" + conDesayuno +
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
