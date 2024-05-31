package com.excepciones.java.potencia;

public class Potencia {
    public static void main(String[] args) {
        int n = -8;
        //crear un metodo para detectar si n es par o no
        try {
            par(n);
            negativo(n);
            int potencia = n*n;
            System.out.println("la potencia es: " + potencia);
        } catch (ParException p) {
            System.err.println(p.getMessage());

        }catch(NegativeException neg){
            System.err.println(neg.getMessage());;
        }
        
    }

    private static void negativo(int n) throws NegativeException{
         if(n <= 0){
            throw new NegativeException("Numero inavlido", "Numero inavalido");

         }
    }

    private static void par(int n) throws ParException {
        //controlar si el numero ingresadocomo paramentro es poar o no
        if (n % 2 == 0 ) {
            //arroje la excepcio de par
            throw new ParException("Numero Invalido", "el numero es par");
            
        }

    }
}
