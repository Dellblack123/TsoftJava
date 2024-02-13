package Modelo;

public class Deportivo {

    private int numero;//Medida calzado
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
