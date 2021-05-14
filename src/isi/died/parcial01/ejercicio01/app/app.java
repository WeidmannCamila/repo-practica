package isi.died.parcial01.ejercicio01.app;

import isi.died.parcial01.ejercicio01.modelo.Empleado;

import java.util.ArrayList;

public class app {

    public static void main(String[] args) {

        ArrayList<Empleado> listE = new ArrayList<Empleado>();


        for(int i=0; i < listE.size() ; i++)
        System.out.println("Sueldos " + listE.get(i).getSueldo());
        


    }

}
