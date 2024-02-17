package Modelo;

public abstract class Hospederia extends MedioAlojamiento{
    protected int capacidad;
    protected boolean fumador;
    private boolean aumentado=false;

    public Hospederia(Cliente datCliente, int cantNoches, int tipoTemporada, double valNoche, int capacidad, boolean fumador) {
        super(datCliente, cantNoches, tipoTemporada, valNoche);
        incrementarValorBase();
        this.capacidad = capacidad;
        this.fumador = fumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public boolean isAumentado() {
        return aumentado;
    }

    public void setAumentado(boolean aumentado) {
        this.aumentado = aumentado;
    }

    public void incrementarValorBase() {
        if (getCapacidad()>5 && !isAumentado()){
            setValNoche(getValNoche()+getValNoche()*0.18);
            setAumentado(true);
        }
    }
    @Override
    public double adicional() {
        return 0;
    }
}
