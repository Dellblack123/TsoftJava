package Modelo;

public class Deportivo {
    private String tipo_deporte;

    private Calzado cal;

    void Deportivo(){
        cal = new Calzado();
    }

    public String getTipo_deporte() {
        return tipo_deporte;
    }

    public void setTipo_deporte(String tipo_deporte) {
        this.tipo_deporte = tipo_deporte;
    }

    public Calzado getCal() {
        return cal;
    }

    public void setCal(Calzado cal) {
        this.cal = cal;
    }

}
