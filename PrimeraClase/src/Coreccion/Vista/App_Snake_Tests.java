package Coreccion.Vista;


import Coreccion.Modelo.Mujer;
import Coreccion.Modelo.Producto;
import Coreccion.Modelo.Hombre;

public class App_Snake_Tests {
    public static void main(String[] args){
        Producto prod = new Producto("CZ-0001",29,2300);
        Hombre hom = new Hombre(48,"Semana",prod,"Rojo");
        Mujer mun = new Mujer(48,"Semana",prod,"Rojo",12);


    }
}
