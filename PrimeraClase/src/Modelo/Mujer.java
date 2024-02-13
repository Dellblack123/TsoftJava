package Modelo;

public class Mujer implements Descuento{
    private int altura_taco;

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
                " Dia de venta: "+
                " Altura de taco "+altura_taco+
                " Descuento: "+descuento()+
                '}';
    }
    public int getAltura_taco() {
        return altura_taco;
    }

    public void setAltura_taco(int altura_taco) {
        this.altura_taco = altura_taco;
    }


    public Formal getForm() {
        return form;
    }

    public void setForm(Formal form) {
        this.form = form;
    }
}
