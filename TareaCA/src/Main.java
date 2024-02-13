import Modelo.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Alumno> lista = new ArrayList<>();

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n=0;//Numero de alumnos
        do{
            System.out.println("==Contigo Aprendo==");
            System.out.println("1. Registrar un alumno");
            System.out.println("2. Calcular la peor nota");
            System.out.println("3. Calcular la mejor nota");
            System.out.println("4. Calcular el promedio de notas del alumno");
            System.out.println("5. Evaluar su situación acádemica (Aprobado|Desaprobado)");
            System.out.println("6. Salir");

            n = x.nextInt();
            switch (n){
                case 1: lista.add(opcion1(x));break;
                case 2: opcion2(x);break;
                case 3: opcion3(x);break;
                case 4: opcion4(x);break;
                case 5: opcion5(x);break;
            }

        }while(n!=6);

    }

    public static Alumno opcion1(Scanner x){
        String nom,ape,direc,curso;
        int edad;
        int[] notas = new int[3];
        System.out.println("Registrando Alumno");
        System.out.println("Ingrese nombre del alumno");
        nom=x.next();
        System.out.println("Ingrese apellido del alumno");
        ape=x.next();
        System.out.println("Ingrese direccion del alumno");
        direc=x.next();
        System.out.println("Ingrese edad del alumno");
        edad=x.nextInt();
        System.out.println("Ingrese nota de PC1 del alumno");
        notas[0]=x.nextInt();
        System.out.println("Ingrese nota de PC2 del alumno");
        notas[1]=x.nextInt();
        System.out.println("Ingrese nota de ExFinal del alumno");
        notas[2]=x.nextInt();
        System.out.println("Ingrese nombre del curso");
        curso=x.next();
        return new Alumno(nom,ape,direc,edad,notas,curso);
    }

    public static void opcion2(Scanner x){
        int n=0;
        int peor=9999;
        if(lista.isEmpty()){
            System.out.println("No hay alumnos registrados");
            return;
        }else{
            do {
                for (int i=0;i<lista.size();i++){
                    System.out.println((i+1)+" "+lista.get(i).toString());
                }
                n=x.nextInt();
                if(n-1<lista.size()) {
                    for (int i = 0; i < 3; i++) {
                        if (lista.get(n - 1).getNotas()[i] <= peor) {
                            peor = lista.get(n - 1).getNotas()[i];
                        }
                    }
                    System.out.println("La peor nota es: " + peor);
                }
            }while(n!=lista.size());
        }
    }

    public static void opcion3(Scanner x){
        int n=0;
        int mejor=0;
        if(lista.isEmpty()){
            System.out.println("No hay alumnos registrados");
            return;
        }else{
            do {
                for (int i=0;i<lista.size();i++){
                    System.out.println((i+1)+" "+lista.get(i).toString());
                }
                n=x.nextInt();
                if(n-1<lista.size()) {

                    for (int i = 0; i < 3; i++) {
                        if (lista.get(n - 1).getNotas()[i] >= mejor) {
                            mejor = lista.get(n - 1).getNotas()[i];
                        }
                    }
                    System.out.println("La mejor nota es: " + mejor);
                }
            }while(n!=lista.size());
        }
    }

    public static void opcion4(Scanner x){
        int n=0;
        int prom=0;
        if(lista.isEmpty()){
            System.out.println("No hay alumnos registrados");
            return;
        }else{
            do {
                for (int i=0;i<lista.size();i++){
                    System.out.println((i+1)+" "+lista.get(i).toString());
                }
                n=x.nextInt();
                    if(n-1<lista.size()){
                        System.out.println("El promedio de notas es: "+obtenerProm(lista.get(n-1)));
                    }
            }while(n!=lista.size());
        }
    }

    static double obtenerProm(Alumno alum){
        double prom=0;
        for (int i=0;i<3;i++){
            prom+=alum.getNotas()[i];
        }
        prom=prom/3;
        return prom;
    }

    public static void opcion5(Scanner x){
        int n=0;
        int prom=0;
        if(lista.isEmpty()){
            System.out.println("No hay alumnos registrados");
            return;
        }else{
            do {
                for (int i=0;i<lista.size();i++){
                    System.out.println((i+1)+" "+lista.get(i).toString());
                }
                n=x.nextInt();
                if(n-1<lista.size()){
                    if (obtenerProm(lista.get(n-1))>=12){
                        System.out.println("Aprobado");
                    }else{
                        System.out.println("Desaprobado");
                    }
                }

            }while(n!=lista.size());
        }
    }
}