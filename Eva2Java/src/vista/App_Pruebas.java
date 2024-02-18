package vista;

import controlador.EmpresaTurismo;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.Cliente;
import modelo.Hotel;

import java.util.ArrayList;

public class App_Pruebas {
    public static void main(String[] args){
        Cliente cliente = new Cliente("Javier","1");
        Cliente cliente2 = new Cliente("Javier","2");
        Cliente cliente3 = new Cliente("Javier","3");

        Cabagna cabagna = new Cabagna(cliente,3,"Media",250.0,6,true,false);
        Carpa carpa = new Carpa(cliente2,2,"Baja",75.50,3);
        Hotel hotel = new Hotel(cliente3,8,"Alta",550.0,6,true,true);

        EmpresaTurismo turismo = new EmpresaTurismo(new ArrayList<>());

        turismo.ingresarAloCabagna(cabagna);
        turismo.ingresarAloHotel(hotel);
        turismo.ingresarAloCarpa(carpa);
        int opcion=-1;
        do {
            opcion = menu();



        }while (opcion!=9);
    }

    public static int menu(){
        System.out.println("\t\t\tSistema de la empresa de Turismo");
        System.out.println("1. Ingresar Medio de Alojamiento (Carpa | Cabaña | Hotel), solo uno por cliente");
        System.out.println("2. Mostrar Medios de Alojamiento (Datos de objetos almacenados)");
        System.out.println("3. Datos de cliente a elección");
        System.out.println("4. Total adicional (Adicional acumulado de todos los alojamientos)");
        System.out.println("5. Total bono descuento (Descuento acumulado de todos los alojamientos)");
        System.out.println("6. Cantidad de alojamientos a elección");
        System.out.println("7. Valor a cancelar por un cliente X (Solo si el cliente existe)");
        System.out.println("8. Aplicar incremento a valor base (donde corresponda)");
        System.out.println("9. Salir");
        System.out.println("================Selecciona una opción================");
        return Leer.datoInt();
    }

}
