package controlador;

import modelo.*;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<MedioAlojamiento> alojamientos;

    public EmpresaTurismo(ArrayList<MedioAlojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    public ArrayList<MedioAlojamiento> getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(ArrayList<MedioAlojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    public int buscarAlojamiento(String rutCliente){

        for(int i=0; i<alojamientos.size(); i++){
            if (alojamientos.get(i).getDatCliente().getRutCliente().compareToIgnoreCase(rutCliente)==0){
                return i;
            }
        }
        return -1;
    }

    public int buscarCliente(String rutCliente){

        for(int i=0; i<alojamientos.size(); i++){
            if (alojamientos.get(i).getDatCliente().getRutCliente().compareToIgnoreCase(rutCliente)==0){
                //System.out.println("Cliente encontrado:");
                //System.out.println(alojamientos.get(i).toString());;
                return i;
            }
        }
        //System.out.println("Cliente no existe");
        return -1;
    }

    public void ingresarAloCabagna(Cabagna cabagna){//Alojamiento cabaña
        if (buscarAlojamiento(cabagna.getDatCliente().getRutCliente())==-1){
            alojamientos.add(cabagna);
        }
    }

    public void ingresarAloCarpa(Carpa carpa){//Alojamiento carpa
        if (buscarAlojamiento(carpa.getDatCliente().getRutCliente())==-1){
            alojamientos.add(carpa);
        }
    }

    public void ingresarAloHotel(Hotel hotel){//Alojamiento hotel
        if (buscarAlojamiento(hotel.getDatCliente().getRutCliente())==-1){
            alojamientos.add(hotel);
        }
    }

    public void mostrarAlojamientos(){
        System.out.println("===========Medios de Alojamiento===========");
        if (!alojamientos.isEmpty()){
            for (int i=0;i<alojamientos.size();i++){
                System.out.println(alojamientos.get(i).toString());
            }
        }
        System.out.println(alojamientos.size());
    }

    public void totalAdicional(){
        double acum=0;
        for (int i=0;i<alojamientos.size();i++){
            acum += alojamientos.get(i).adicional();
        }
        System.out.println("El total adicional acumulado es: "+acum);
    }

    public void totalDescuento(){
        double acum=0;
        for (int i=0;i<alojamientos.size();i++){
            acum += alojamientos.get(i).bonoDescuento();
        }
        System.out.println("El total bono descuento acumulado es: "+acum);
    }

    public int conteoTipoAlojamiento(int tipo){
        return switch (tipo) {
            case 1 -> cantidadCarpa();
            case 2 -> cantidadCabagna();
            case 3 -> cantidadHotel();
            default -> -1;
        };
    }

    public int cantidadCabagna(){
        int cont = 0;
        for (int i=0;i<alojamientos.size();i++){
            if (alojamientos.get(i) instanceof  Cabagna){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }

    public int cantidadCarpa(){
        int cont = 0;
        for (int i=0;i<alojamientos.size();i++){
            if (alojamientos.get(i) instanceof  Carpa){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }

    public int cantidadHotel(){
        int cont = 0;
        for (int i=0;i<alojamientos.size();i++){
            if (alojamientos.get(i) instanceof  Hotel){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }

}
