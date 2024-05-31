package com.excepciones.java.pruebas;

public class NullPointerExceptionTest {
    public static void main(String[] args) {
        //NulPointerExpcption:
        //Variable o objcto no tiene un valor asigmado
        //o tiene asiganado un Null 
        String mensaje = null;

        try {
            mensaje.toUpperCase();
        } catch (NullPointerException e) {
            System.out.println(mensaje);

            // TODO: handle exception
        }
        // convetir el string a mayuscula
        
        

    }
    
}
