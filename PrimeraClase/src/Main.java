import Modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

static ArrayList<Object> lista = new ArrayList();//Lista de deportivos,formales-hombre,formales-mujer
    static Mujer mun = new Mujer();
    static Hombre hom = new Hombre();



    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        int n = 1;//Entrada
        Scanner x = new Scanner(System.in);

        do{
            System.out.println("Sistema");

            System.out.println("1. Ingresar");
            System.out.println("2. Mostrar sólo los calzados de mujer");
            System.out.println("3. Valor Venta");
            System.out.println("4. Calzados Top");
            System.out.println("5. Total Impuesto Específico");
            System.out.println("6. Total Descuento");
            System.out.println("7. Salir");

            n = x.nextInt();

            switch (n){
                case 1: opcion1(x);break;
                case 2: opcion2(x);break;
                case 3: opcion3(x);break;
                case 4: opcion4(x);break;
                case 5: opcion5(x);break;
                case 6: opcion6(x);break;
            }

        }while(n!=7);

    }

    public static void opcion1(Scanner x){
        int n = 0;
        int elec=0;
        do{
            System.out.println("Sistema");

            System.out.println("1. Calzado Hombre");
            System.out.println("2. Calzado Mujer");
            System.out.println("3. Calzado Deportivo");
            System.out.println("4. Atrás");
            n = x.nextInt();
            if(n>4 || n<=0){System.out.println("Opcion no valida");
            }else{
                Calzado cal = new Calzado();
                Formal form = new Formal();
                cal.setTipo("Formal");
                System.out.println("Seleccione el dia de venta");
                System.out.println("1. Dia de semana");
                System.out.println("2. Fin de semana");
                elec = x.nextInt();
                cal.setDia_venta(elec);
                System.out.println("Talla de calzado");
                cal.setNumero(x.nextInt());
                System.out.println("Tipo de material");
                System.out.println("1. Cuero");
                System.out.println("2. Lona");
                elec=x.nextInt();
                System.out.println("Ingrese stock del calzado");
                cal.setStock(x.nextInt());
                System.out.println("Valor base del producto");
                cal.setValor_base(x.nextDouble());
                cal.setCodigo("CAL-Z"+lista.size()+1);
                if (n==1){
                    form.setCal(cal);
                    Hombre hom = new Hombre();
                    hom.setForm(form);
                    System.out.println("Ingrese color");
                    hom.setColor(x.next());
                    lista.add(hom);
                }else if(n==2){
                    form.setCal(cal);
                    Mujer mun = new Mujer();
                    mun.setForm(form);
                    System.out.println("Ingrese altura taco");
                    mun.setAltura_taco(x.nextInt());
                    lista.add(mun);
                }else if(n==3){
                    Deportivo dep = new Deportivo();
                    dep.setCal(cal);
                    System.out.println("Ingrese tipo de deporte");
                    dep.setTipo_deporte(x.next());
                    lista.add(dep);
                }
                break;
            }
        }while(n!=4);
    }

    static public void opcion2(Scanner x){
        int n = 0;
        do{
            System.out.println("Lista de calzado de mujer");

            for (Object calzado : lista){
                if(calzado instanceof Mujer){
                    System.out.println(calzado.toString());
                }
            }
            System.out.println("1. Atrás");

            n = x.nextInt();
            if(n>1) System.out.println("Opcion no valida");
        }while(n!=1);
    }

    static public void opcion3(Scanner x){
        int n=0;
        int total = lista.size()+1;
        do{
            System.out.println("Valores de calzados");

            for (int i=0; i<lista.size();i++){
                if(lista.get(i) instanceof Mujer){
                    System.out.println((i+1)+". Valor venta:"+((Mujer) lista.get(i)).getForm().getCal().valorVenta()+" Número calzado: "+((Mujer) lista.get(i)).getForm().getCal().getNumero());
                }else if(lista.get(i) instanceof Hombre){
                    System.out.println((i+1)+". Valor venta:"+((Hombre) lista.get(i)).getForm().getCal().valorVenta()+" Número calzado: "+((Hombre) lista.get(i)).getForm().getCal().getNumero());
                }else if(lista.get(i) instanceof Deportivo){
                    System.out.println((i+1)+". Valor venta:"+((Deportivo) lista.get(i)).getCal().valorVenta()+" Número calzado: "+((Deportivo) lista.get(i)).getCal().getNumero());
                }
            }
            System.out.println(total+". Atrás");

            n = x.nextInt();
            if(n>total) System.out.println("Opcion no valida");
        }while(n!=total);
    }


    static public void opcion4(Scanner x){
        int n=0;
        int cant=0;
        do{
            System.out.println("Número de Calzados Top");

            for (Object o : lista) {
                if (o instanceof Mujer && ((Mujer) o).getForm().getCal().valorVenta() > 80000 ){
                    cant++;
                }else if(o instanceof Hombre && ((Hombre) o).getForm().getCal().valorVenta() > 80000 ){
                    cant++;
                }else if(o instanceof Deportivo && ((Deportivo) o).getCal().valorVenta() > 80000){
                    cant++;
                }
            }
            System.out.println("Cantidad: "+cant);
            System.out.println("1. Atrás");

            n = x.nextInt();
            if(n>1) System.out.println("Opcion no valida");
        }while(n!=1);
    }

    static public void opcion5(Scanner x){
        int n=0;
        double cant=0;
        do{
            System.out.println("Total impuesto específico");

            for (Object o : lista) {
                if (o instanceof Mujer) {
                    cant += ((Mujer) o).getForm().getCal().impuestoEspecifico();
                } else if (o instanceof Hombre) {
                    cant += ((Hombre) o).getForm().getCal().impuestoEspecifico();
                } else if (o instanceof Deportivo) {
                    cant += ((Deportivo) o).getCal().impuestoEspecifico();
                }
            }
            System.out.println("Impuesto específico si se vendiera todo: "+cant);
            System.out.println("1. Atrás");

            n = x.nextInt();
            if(n>1) System.out.println("Opcion no valida");
        }while(n!=1);
    }

    static public void opcion6(Scanner x){
        int n=0;
        double cant=0;
        do{
            System.out.println("Descuento total");

            for (Object o : lista) {
                if (o instanceof Mujer) {
                    cant += ((Mujer) o).descuento();
                } else if (o instanceof Hombre) {
                    cant += ((Hombre) o).descuento();
                } else if (o instanceof Deportivo) cant += 0;
            }
            System.out.println("Descuento total en tienda: "+cant);
            System.out.println("1. Atrás");

            n = x.nextInt();
            if(n>1) System.out.println("Opcion no valida");
        }while(n!=1);
    }
}