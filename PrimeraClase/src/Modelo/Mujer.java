package Modelo;

public class Mujer implements Descuento{
    private int numero;//Medida calzado
    private int altura_taco;
    private int dia_venta;
    private String color;

    private Formal form;

    void Mujer(){
        form = new Formal();
        form.setCal(new Calzado());
    }


    public double descuento(){
        double descuento=0;
        if(altura_taco>10){
            descuento+=0.2;
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
        return "Mujer{" +
                " Dia de venta: "+dia_venta+
                " Altura de taco "+altura_taco+
                " Descuento: "+descuento()+
                '}';
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAltura_taco() {
        return altura_taco;
    }

    public void setAltura_taco(int altura_taco) {
        this.altura_taco = altura_taco;
    }

    public int getDia_venta() {
        return dia_venta;
    }

    public void setDia_venta(int dia_venta) {
        this.dia_venta = dia_venta;
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
