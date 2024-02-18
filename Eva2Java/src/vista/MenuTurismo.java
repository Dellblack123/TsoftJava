package vista;

import controlador.EmpresaTurismo;
import modelo.*;

import java.util.ArrayList;

public class MenuTurismo {
    public static void main(String[] args){

        int opcion;
        String rutCliente;

        Cliente cliente = new Cliente("Javier","1");
        Cliente cliente2 = new Cliente("Carlos","2");
        Cliente cliente3 = new Cliente("Rosa","3");

        Cabagna cabagna = new Cabagna(cliente,3,"Media",250.0,6,true,false);
        Carpa carpa = new Carpa(cliente2,2,"Baja",75.50,3);
        Hotel hotel = new Hotel(cliente3,8,"Alta",550.0,7,true,true);

        EmpresaTurismo empresa = new EmpresaTurismo(new ArrayList<>());
        empresa.ingresarAloCabagna(cabagna);
        empresa.ingresarAloCarpa(carpa);
        empresa.ingresarAloHotel(hotel);
        do {
            opcion = menu();

            switch (opcion){
                case 1:
                    rutCliente = pedirRut();

                    if (empresa.buscarCliente(rutCliente)==-1){
                        System.out.println("Ingrese nombre del cliente");String nombre=Leer.dato();

                        String tipoTemporada;

                        do {
                            System.out.println("Ingrese el tipo de temporada (Alta | Media | Baja)");
                            tipoTemporada = Leer.dato();
                        }while (tipoTemporada.compareToIgnoreCase("Alta") !=0 &&
                                tipoTemporada.compareToIgnoreCase("Media") !=0 &&
                                tipoTemporada.compareToIgnoreCase("Baja") !=0);

                        System.out.println("¿Cantidad de noches?");int cantNoches = Leer.datoInt();
                        System.out.println("¿Valor base por noche?");double valNoche = Leer.datoDouble();

                        int seleccion;
                        do {
                            System.out.println("Seleccione el tipo de alojamiento:\n1)Carpa\n2)Cabaña\n3)Hotel");
                            seleccion=Leer.datoInt();
                        }while(seleccion<1 || seleccion>3);

                        if (seleccion==1){
                            System.out.println("¿Cantidad de personas?");int cantPers=Leer.datoInt();
                            empresa.ingresarAloCarpa(new Carpa(new Cliente(nombre,rutCliente),cantNoches,tipoTemporada,valNoche,cantPers));
                            System.out.println("Alojamiento tipo 'Carpa' agregado exitosamente");
                        }else{
                            System.out.println("¿Capacidad?");int capa = Leer.datoInt();

                            String resp;
                            do {
                                System.out.println("¿Alguno es fumador? (Si | No)");resp = Leer.dato();
                            }while (resp.compareToIgnoreCase("Si")!=0 && resp.compareToIgnoreCase("No")!=0);
                            boolean fuma= resp.compareToIgnoreCase("Si") == 0;
                            if (seleccion==2){
                                String resp2;
                                do {
                                    System.out.println("¿Desea chimenea? (Si | No)");resp2 = Leer.dato();
                                }while (resp2.compareToIgnoreCase("Si")!=0 && resp2.compareToIgnoreCase("No")!=0);
                                boolean chime= resp2.compareToIgnoreCase("Si") == 0;
                                empresa.ingresarAloCabagna(new Cabagna(new Cliente(nombre,rutCliente),cantNoches,tipoTemporada,valNoche,capa,fuma,chime));
                            }else{
                                String resp2;
                                do {
                                    System.out.println("¿Desea desayuno? (Si | No)");resp2 = Leer.dato();
                                }while (resp2.compareToIgnoreCase("Si")!=0 && resp2.compareToIgnoreCase("No")!=0);
                                boolean desayuno= resp2.compareToIgnoreCase("Si") == 0;
                                empresa.ingresarAloHotel(new Hotel(new Cliente(nombre,rutCliente),cantNoches,tipoTemporada,valNoche,capa,fuma,desayuno));
                            }
                        }
                    }else{
                        System.out.println("El cliente con numero de rut: "+rutCliente+" ya se encuentra asociado");
                    }
                    break;
                case 2: empresa.mostrarAlojamientos();break;
                case 3:
                    System.out.println("------------Ingrese el rut del cliente a buscar------------");
                    int indice = empresa.buscarCliente(Leer.dato());
                    if(indice!=-1) {
                        System.out.println(empresa.getAlojamientos().get(indice).toString());
                    }else{
                        System.out.println("El cliente no existe");
                    }
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 4: empresa.totalAdicional();break;
                case 5: empresa.totalDescuento();break;
                case 6:
                    System.out.print("------------Ingrese el tipo de alojamiento------------");
                    System.out.println("\n1)Carpa\n2)Cabaña\n3)Hotel");
                    int seleccion = Leer.datoInt();
                    System.out.println("La cantidad de alojamientos de tipo "+((seleccion==1)?"Carpa":(seleccion==2)?"Cabaña":"Hotel")+" es: "+empresa.conteoTipoAlojamiento(seleccion));
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 7:
                    System.out.println("------------Ingrese el rut de un cliente------------");
                    int pos = empresa.buscarCliente(Leer.dato());
                    if(pos!=-1) {
                        System.out.println("El valor a cancelar para "+empresa.getAlojamientos().get(pos).getDatCliente().getNombre()+" es de: "+empresa.getAlojamientos().get(pos).valorCancelar());
                    }else{
                        System.out.println("El cliente no existe");
                    }
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 8:
                    System.out.println("Lista de alojamiento que requieren incremento valor base");
                    for (int i=0;i<empresa.getAlojamientos().size();i++){
                        if (empresa.getAlojamientos().get(i) instanceof Hospederia && !((Hospederia) empresa.getAlojamientos().get(i)).isAumentado()){
                            //((Hospederia) alojamientos.get(i)).incrementarValorBase();
                            System.out.println("-"+empresa.getAlojamientos().get(i).toString());
                        }
                    }
                    String resp;
                    do {
                        System.out.println("¿Desea incrementar el valor base? (Si | No)");resp = Leer.dato();
                    }while (resp.compareToIgnoreCase("Si")!=0 && resp.compareToIgnoreCase("No")!=0);
                    if (resp.compareToIgnoreCase("No")!=0){
                        for (int i=0;i<empresa.getAlojamientos().size();i++){
                            if (empresa.getAlojamientos().get(i) instanceof Hospederia){
                                ((Hospederia) empresa.getAlojamientos().get(i)).recalculo();
                                ((Hospederia) empresa.getAlojamientos().get(i)).incrementarValorBase();
                            }
                        }
                    }
                    break;
            }

        }while (opcion!=9);
    }

    public static String pedirRut(){
        System.out.println("Ingrese el rut del cliente");
        return Leer.dato();
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
