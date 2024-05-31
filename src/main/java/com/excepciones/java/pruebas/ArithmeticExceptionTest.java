package com.excepciones.java.pruebas;

public class ArithmeticExceptionTest{
    public static void main(String[] args) {

        
        int divisor  = 0;
        int dividendo = 8; 
        int resultado = 15;

        try {
            //flujo principal del caso de uso
            resultado = dividendo / divisor;
            System.out.println(resultado);
        } catch (   ArithmeticException e) {
            //fluujo alterno
            System.out.println("Divison por cero");
        } finally{
            System.out.println("graias por nada");
        }
        //imprimir resultados
        
    }
}
