package modelo;

public class Carpa extends MedioAlojamiento{
    private int cantPersonas;

    public Carpa(Cliente datCliente, int cantNoches, String tipoTemporada, double valNoche, int cantPersonas) {
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

    @Override
    public double subTotal() {
        return getCantNoches()*getValNoche();
    }

    @Override
    public String toString() {
        return "Medio de Alojamiento de tipo: Carpa{" +
                "cantPersonas=" + cantPersonas +
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
