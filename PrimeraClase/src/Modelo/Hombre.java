package Modelo;

public class Hombre implements Descuento{
    private String color;
    private Formal form;

    void Hombre(){
        form = new Formal();
    }
    public double descuento(){
        double descuento=0;

        if (color.compareToIgnoreCase("Rojo")==0 || color.compareToIgnoreCase("Verde")==0){
            descuento+=0.25;
        }
        return descuento;
    }


    @Override
    public double valorPagar() {
        if (form.getCal().getStock()>0){
            form.getCal().setStock(form.getCal().getStock()-1);
            return form.getCal().valorVenta()-descuento()+form.getCal().impuestoEspecifico()+form.getCal().impuestoIva()+form.getCal().impuestoMaterial();
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Hombre{" +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Formal getForm() {
        return form;
    }

    public void setForm(Formal form) {
        this.form = form;
    }
}
