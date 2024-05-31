package com.excepciones.java.potencia;

import java.util.List;

import com.excepciones.java.pruebas.IndexOutOfBoundExceptionn;

import lombok.ToString;

import java.util.ArrayList;
import java.util.InputMismatchException;

@ToString

public class Medico {

    private String nombre;
    private String especialidad;
    
    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public static void main(String[] args) {
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        listaMedicos.add(new Medico("Dra. Martinez", "Pediatra"));
        listaMedicos.add(new Medico("Dra. Marin", "Cardióloga"));
        listaMedicos.add(new Medico("Dr. López", "Cirujano"));

        int posicion = 3;
        try {
            if ( posicion < 0 || posicion >= listaMedicos.size()) {
                throw new InputMismatchException("Posicion fuera de los limites de la lista");   
            }
            Medico medico = listaMedicos.get(posicion);
            System.out.println("El medico en la posicion" + posicion + "es" + medico);

        } catch (InputMismatchException shi) {
            
            System.out.println("What happend men "+ "a position nonexistent, but I"+" offer date default ");
            System.out.println(shi.getMessage());
        }

    }
    

}
