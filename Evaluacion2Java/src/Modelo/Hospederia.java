package Modelo;

public class Hospederia extends MedioDeAlojamiento{
    private int capacidad;
    private boolean esFumador;

    public Hospederia(DatosCliente datCli, int cantNoches, int tipoTemporada, double valorBaseNoche, int capacidad, boolean esFumador) {
        super(datCli, cantNoches, tipoTemporada, valorBaseNoche);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    @Override
    public String toString() {
        return super.toString()+"Hospederia{" +
                "capacidad=" + capacidad +
                ", esFumador=" + esFumador +
                '}';
    }
}
