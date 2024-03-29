package modelo;

public abstract class Hospederia extends MedioAlojamiento{
    protected int capacidad;
    protected boolean fumador;
    private boolean aumentado=false;

    public Hospederia(Cliente datCliente, int cantNoches, String tipoTemporada, double valNoche, int capacidad, boolean fumador) {
        super(datCliente, cantNoches, tipoTemporada, valNoche);
        this.capacidad = capacidad;
        this.fumador = fumador;

        if(getCapacidad()<=5 && getCapacidad()>0){
            setAumentado(true);
        }
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
    @Override
    public double subTotal() {
        return getCantNoches()*getValNoche();
    }

    public double incrementarValorBase() {
        double incremento=0;
        if (getCapacidad()>5 && !isAumentado()){
            incremento=getValNoche()+getValNoche()*0.18;
            setValNoche(incremento);
            setAumentado(true);
        }
        return 0;
    }
    @Override
    public double adicional() {
        return 0;
    }
    public void recalculo(){
        subTotal();
    }
}
