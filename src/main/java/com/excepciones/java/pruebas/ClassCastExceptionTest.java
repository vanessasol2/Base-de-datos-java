package com.excepciones.java.pruebas;

import lombok.ToString;

@ToString

class Animal{
    private String especie;
    //Constructor
    public Animal(String especie) {
        this.especie = especie;
    }
    
}

public class ClassCastExceptionTest {
    public static void main(String[] args) {
        //Crear Objecto snimsl 
        Animal i = new Animal("Tiranosaurio rex");
        

        try {
            Perro j =(Perro) i;
            System.out.println(j);
        } catch (ClassCastException e) {
            System.out.println("error de tipos de dato" + e.getMessage());
        }
    }

}
@ToString
class Perro extends Animal{
    
    String nombre;

    public Perro(String especie, String nombre) {
        super(especie);
        
    }

}