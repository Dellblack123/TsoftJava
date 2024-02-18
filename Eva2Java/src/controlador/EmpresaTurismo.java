package controlador;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.Hotel;
import modelo.MedioAlojamiento;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<MedioAlojamiento> empresa;

    public EmpresaTurismo(ArrayList<MedioAlojamiento> empresa) {
        this.empresa = empresa;
    }

    public ArrayList<MedioAlojamiento> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<MedioAlojamiento> empresa) {
        this.empresa = empresa;
    }

    public int buscarAlojamiento(String rutCliente){

        for(int i=0; i<empresa.size(); i++){
            if (empresa.get(i).getDatCliente().getRutCliente().compareToIgnoreCase(rutCliente)==0){
                return i;
            }
        }
        return -1;
    }

    public void buscarCliente(String rutCliente){

        for(int i=0; i<empresa.size(); i++){
            if (empresa.get(i).getDatCliente().getRutCliente().compareToIgnoreCase(rutCliente)==0){
                System.out.println("Cliente encontrado:");
                System.out.println(empresa.get(i).toString());;
                return;
            }
        }
        System.out.println("Cliente no existe");
    }

    public void ingresarAloCabagna(Cabagna cabagna){//Alojamiento cabaña
        if (buscarAlojamiento(cabagna.getDatCliente().getRutCliente())==-1){
            empresa.add(cabagna);
        }
    }

    public void ingresarAloCarpa(Carpa carpa){//Alojamiento carpa
        if (buscarAlojamiento(carpa.getDatCliente().getRutCliente())==-1){
            empresa.add(carpa);
        }
    }

    public void ingresarAloHotel(Hotel hotel){//Alojamiento hotel
        if (buscarAlojamiento(hotel.getDatCliente().getRutCliente())==-1){
            empresa.add(hotel);
        }
    }

    public void mostrarAlojamientos(){
        System.out.println("===========Medios de Alojamiento===========");
        for (int i=0;i<empresa.size();i++){
            System.out.println(empresa.get(i).toString());
        }
    }

    public void totalAdicional(){
        double acum=0;
        for (int i=0;i<empresa.size();i++){
            acum += empresa.get(i).adicional();
        }
        System.out.println("El total adicional acumulado es: "+acum);
    }

    public void totalDescuento(){
        double acum=0;
        for (int i=0;i<empresa.size();i++){
            acum += empresa.get(i).bonoDescuento();
        }
        System.out.println("El total bono descuento acumulado es: "+acum);
    }

    public double cantidadCabagna(){
        int cont = 0;
        for (int i=0;i<empresa.size();i++){
            if (empresa.get(i) instanceof  Cabagna){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }

    public double cantidadCarpa(){
        int cont = 0;
        for (int i=0;i<empresa.size();i++){
            if (empresa.get(i) instanceof  Carpa){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }

    public double cantidadHotel(){
        int cont = 0;
        for (int i=0;i<empresa.size();i++){
            if (empresa.get(i) instanceof  Hotel){
                cont++;
            }
        }
        System.out.println(cont);
        return cont;
    }
}
