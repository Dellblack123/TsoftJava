package Modelo;

public class Formal{

    private Calzado cal;

    void Formal(){
        cal = new Calzado();
    }

    public Calzado getCal() {
        return cal;
    }

    public void setCal(Calzado cal) {
        this.cal = cal;
    }
}
