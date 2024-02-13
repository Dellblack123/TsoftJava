package Modelo;

public class Formal{

    private int tipo;

    private Calzado cal;

    void Formal(){
        cal = new Calzado();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Calzado getCal() {
        return cal;
    }

    public void setCal(Calzado cal) {
        this.cal = cal;
    }
}
