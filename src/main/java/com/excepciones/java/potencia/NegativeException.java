package com.excepciones.java.potencia;

public class NegativeException extends Exception{

    String mensaje;

    public NegativeException(String message,String mensaje) {
        super(message);
        this.mensaje = mensaje;
    }
     

}
