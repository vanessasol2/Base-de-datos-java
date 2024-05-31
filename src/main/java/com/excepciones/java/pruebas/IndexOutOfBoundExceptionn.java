package com.excepciones.java.pruebas;
import java.util.List;
import java.util.ArrayList;

public class IndexOutOfBoundExceptionn {
    public static void main(String[] args) {
        
        //toda variable o inicializacion de objeto debe ir antes del try

       
        //Crear lista de NoMBRES
        List<String> ListaNombres = List.of(

        "Andrea1",
        "Andrea2",
        "Andrea3"
        );
        try {
            System.out.println(ListaNombres.get(10));

        } catch ( IndexOutOfBoundsException e) {

            // no es solo la presentacion adecuada del mensaje
            System.out.println("What happend men "+ "a position nonexistent, but I"+" offer date default ");
            System.out.println(ListaNombres.get(0));
        }finally{
            System.out.println("Programa finalizado");
        }

        //Imprimir un elemento de la lista
        
    
    }

}
