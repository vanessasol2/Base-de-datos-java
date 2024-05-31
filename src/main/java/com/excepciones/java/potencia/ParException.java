package com.excepciones.java.potencia;

public class ParException extends Exception{

    private String mensaje;

    public ParException(String message, String mensaje) {
        super(message);
        this.mensaje = mensaje;
    }

  
 
    
}
