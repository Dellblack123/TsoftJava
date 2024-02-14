package Modelo;

public class MedioDeAlojamiento {

    private DatosCliente datCli;
    private int cantNoches;
    private int tipoTemporada;
    private double valorBaseNoche;

    public MedioDeAlojamiento(DatosCliente datCli, int cantNoches, int tipoTemporada, double valorBaseNoche) {
        this.datCli = datCli;
        this.cantNoches = cantNoches;
        this.tipoTemporada = tipoTemporada;
        this.valorBaseNoche = valorBaseNoche;
    }

    public DatosCliente getDatCli() {
        return datCli;
    }

    public void setDatCli(DatosCliente datCli) {
        this.datCli = datCli;
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

    public double getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(double valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    @Override
    public String toString() {
        return "MedioDeAlojamiento{" +
                "cantNoches=" + cantNoches +
                ", tipoTemporada=" + tipoTemporada +
                ", valorBaseNoche=" + valorBaseNoche +
                '}';
    }
}
