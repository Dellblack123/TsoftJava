package Modelo;

public class Alumno {
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private int[] notas;
    private String curso;

    public Alumno(String nombre, String apellido, String direccion, int edad, int[] notas, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.notas = notas;
        this.curso = curso;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Alumno{" +
                "nombre=" + nombre +
                ", apellido=" + apellido +
                ", direccion=" + direccion +
                ", edad=" + edad +
                ", notas=" + java.util.Arrays.toString(notas) +
                ", curso=" + curso +
                '}';
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getApellido() {
        return apellido;
    }

    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }

    public java.lang.String getDireccion() {
        return direccion;
    }

    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public java.lang.String getCurso() {
        return curso;
    }

    public void setCurso(java.lang.String curso) {
        this.curso = curso;
    }
}
