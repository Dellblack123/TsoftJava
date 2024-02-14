import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.DatosCliente;
import Modelo.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Object> lista;
    static ArrayList<Carpa> lCarpa;
    static ArrayList<Hotel> lHotel;
    static ArrayList<Cabagna> lCabagna;
    //DATOS
    static String nombre;
    static String rut;
    static int cantNoches;
    static int tipoTemporada;
    static double valorBaseNoche;
    static int capacidad;
    static boolean esFumador;
    static boolean tieneChimenea;
    static int cantidadPersonas;
    static boolean conDesayuno;

    public static void limpiarDatos(){
        nombre="";
        rut="";
        cantNoches=0;
        tipoTemporada=0;
        valorBaseNoche=0;
        capacidad=0;
        esFumador=false;
        tieneChimenea=false;
        cantidadPersonas=0;
        conDesayuno=false;
    }

    public static void main(String[] args) {
        int n=0;
        Scanner x = new Scanner(System.in);
        lista = new ArrayList<>();
        do{
            System.out.println("Sistema de alojamiento");
            System.out.println("1. Ingresar Monto de Alojamiento");
            System.out.println("2. Mostrar medios de alojamiento");
            System.out.println("3. Datos de un cliente");
            System.out.println("4. Total adicional");
            System.out.println("5. Total bono descuento");
            System.out.println("6. Cantidad medios de alojamiento");
            System.out.println("7. Valor a cancelar por un cliente");
            System.out.println("8. Aplicar incremento del valor base");
            System.out.println("9. Salir");

            n= x.nextInt();

            switch (n){
                case 1: opcion1(x);break;
                case 2: opcion2(x);break;
                case 3: opcion3(x);break;
                case 4: opcion4(x);break;
                case 5: opcion5(x);break;
                case 6: opcion6(x);break;
                case 7: opcion7(x);break;
                case 8: opcion8(x);break;
            }

        }while(n!=9);
    }

    private static void opcion8(Scanner x) {
        int n=0;
        int cant=0;
        if (lista.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        };
        do {
             cant=0;
            for(int i=0; i<lista.size();i++){
                if (lista.get(i) instanceof Cabagna){
                    cant++;
                }
            }
            if (cant==0){
                System.out.println("No hay cabaña registrada");
                return;
            }else{
                System.out.println("Elija la cabaña para aplicar valor incremento");
                for(int i=0; i<lista.size();i++){
                    if (lista.get(i) instanceof Cabagna && !((Cabagna) lista.get(i)).isAumentado()){
                        System.out.println((i+1)+". "+((Cabagna) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
                    }
                }
                n = x.nextInt();
                if (lista.get(n-1) instanceof Cabagna){
                    ((Cabagna) lista.get(n-1)).incrementarValorBase();
                }else{
                    System.out.println("Opcion no valida");
                }
                break;
            }
        }while(n-1!=lista.size());
    }

    private static void opcion7(Scanner x) {
        int n=0;
        if (lista.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        };
        do {
            System.out.println("Seleccione al Cliente");
            for(int i=0; i<lista.size();i++){
                if (lista.get(i) instanceof Carpa){
                    System.out.println((i+1)+". "+((Carpa) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
                }else if (lista.get(i) instanceof Hotel){
                    System.out.println((i+1)+". "+((Hotel) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
                }else if (lista.get(i) instanceof Cabagna){
                    System.out.println((i+1)+". "+((Cabagna) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
                }
            }
            System.out.println((lista.size()+1)+". Atrás");
            n=x.nextInt();
            if(n-1>=lista.size() || n<=0){
                System.out.println("Opcion no valida");
            }else if (lista.get(n-1) instanceof Carpa){
                System.out.println(((Carpa) lista.get(n-1)).valorACancelar());
            }else if (lista.get(n-1) instanceof Hotel){
                System.out.println(((Hotel) lista.get(n-1)).valorACancelar());
            }else if (lista.get(n-1) instanceof Cabagna){
                System.out.println(((Cabagna) lista.get(n-1)).valorACancelar());
            }
        }while(n-1!=lista.size());

    }

    private static void opcion6(Scanner x) {
        System.out.println("Cantidad de medio de alojamiento: "+lista.size());
    }

    private static void opcion5(Scanner x) {
        double acum=0;
        for(int i=0; i<lista.size();i++){
            if (lista.get(i) instanceof Carpa){
                acum+=((Carpa) lista.get(i)).bonoDescuento();
            }else if (lista.get(i) instanceof Hotel){
                acum+=((Hotel) lista.get(i)).bonoDescuento();
            }else if (lista.get(i) instanceof Cabagna){
                acum+=((Cabagna) lista.get(i)).bonoDescuento();
            }
        }
        System.out.println("Total bono descuento: "+acum);
    }

    private static void opcion4(Scanner x) {
        double acum=0;
        for(int i=0; i<lista.size();i++){
            if (lista.get(i) instanceof Carpa){
                acum+=((Carpa) lista.get(i)).adicional();
            }else if (lista.get(i) instanceof Hotel){
                acum+=((Hotel) lista.get(i)).adicional();
            }else if (lista.get(i) instanceof Cabagna){
                acum+=((Cabagna) lista.get(i)).adicional();
            }
            System.out.println("Total adicional: "+acum);
        }
    }

    private static void opcion3(Scanner x) {
        for(int i=0; i<lista.size();i++){
            if (lista.get(i) instanceof Carpa){
                System.out.println((i+1)+". "+((Carpa) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
            }else if (lista.get(i) instanceof Hotel){
                System.out.println((i+1)+". "+((Hotel) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
            }else if (lista.get(i) instanceof Cabagna){
                System.out.println((i+1)+". "+((Cabagna) lista.get(i)).getDatCli().toString() + lista.get(i).toString());
            }
        }
    }

    private static void opcion2(Scanner x) {
        for(int i=0; i<lista.size();i++){
            System.out.println((i+1)+". "+lista.get(i).toString());
        }
    }

    private static void opcion1(Scanner x) {
        int n=0;
        DatosCliente cli = null;
        Carpa carp = null;
        Cabagna cab = null;
        Hotel hot = null;
        do {
            System.out.println("Seleccione el tipo de alojamiento");
            System.out.println("1. Carpa");
            System.out.println("2. Cabaña");
            System.out.println("3. Hotel");
            System.out.println("4. Atrás");
            n=x.nextInt();
            limpiarDatos();

            if(n>4 || n<=0){
                System.out.println("Opcion no valida");
            }else if(n==4){break;}else {
                System.out.println("Ingrese nombre de cliente");
                nombre = x.next();
                System.out.println("Ingrese rut de cliente");
                rut = x.next();
                System.out.println("Cantidad de noches:");
                cantNoches = x.nextInt();
                System.out.println("Tipo de temporada");
                System.out.println("1. Alta");
                System.out.println("2. Media");
                System.out.println("3. Baja");
                tipoTemporada=x.nextInt();
                System.out.println("Valor base de noche");
                valorBaseNoche = x.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("Ingrese cantidad de personas");
                        cantidadPersonas = x.nextInt();
                        cli = new DatosCliente(nombre,rut);
                        carp = new Carpa(cli,cantNoches,tipoTemporada,valorBaseNoche,cantidadPersonas);
                        lista.add(carp);
                        break;
                    case 2:
                        System.out.println("Capacidad");
                        capacidad = x.nextInt();
                        System.out.println("Es fumador");
                        esFumador = x.nextBoolean();
                        System.out.println("Tiene Chimenea");
                        tieneChimenea = x.nextBoolean();
                        cli = new DatosCliente(nombre,rut);
                        cab = new Cabagna(cli,cantNoches,tipoTemporada,valorBaseNoche,capacidad,esFumador,tieneChimenea);
                        lista.add(cab);
                        break;
                    case 3:
                        System.out.println("Capacidad");
                        capacidad = x.nextInt();
                        System.out.println("Es fumador");
                        esFumador = x.nextBoolean();
                        System.out.println("Incluye desayuno");
                        conDesayuno = x.nextBoolean();
                        cli = new DatosCliente(nombre,rut);
                        hot = new Hotel(cli,cantNoches,tipoTemporada,valorBaseNoche,capacidad,esFumador,conDesayuno);
                        lista.add(hot);
                        break;
                }
            }
        }while(n!=4);
    }
}