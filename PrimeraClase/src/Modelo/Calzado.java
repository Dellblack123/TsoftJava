package Modelo;

public class Calzado extends Producto implements Calculos {
    private String tipo="";
    private int dia_venta=0;//SEMANA o FIN DE SEMANA
    private int numero=0;//Talla calzado
    private int tipo_material=0;


    @Override
    public double valorVenta() {
        double valor = getValor_base();
        if(dia_venta==0){//Semana
            return valor+valor*0.15;
        }else if(true){//Fin de semana
            return valor+valor*0.24;
        }else{
            return 0;
        }
    }

    @Override
    public double impuestoIva() {
        return valorVenta()*0.19;
    }

    @Override
    public double impuestoEspecifico() {//Deportivo no paga
        if(tipo.compareToIgnoreCase("Formal")==0){
        return getValor_base()*0.074;
        }
        return 0;
    }

    @Override
    public double impuestoMaterial() {
        double valor = getValor_base();
        if (tipo_material==0){//Cuero
            return valor*0.15;
        }else if(tipo_material==1){//Lona
            return valor*0.06;
        }else{
            return 0;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDia_venta() {
        return dia_venta;
    }

    public void setDia_venta(int dia_venta) {
        this.dia_venta = dia_venta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(int tipo_material) {
        this.tipo_material = tipo_material;
    }
}
