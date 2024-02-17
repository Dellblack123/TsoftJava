package Controlador;

import Modelo.MedioAlojamiento;

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
}
