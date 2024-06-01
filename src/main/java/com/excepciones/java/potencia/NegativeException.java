package com.excepciones.java.potencia;

public class NegativeException extends Exception{

    String mensaje;

    public NegativeException(String message,String mensaje) {
        super(message);
        this.mensaje = mensaje;
    }
     

}

/*
            if(codigo.equals(in)){
                break;
            }
            System.out.println("ingrese el numero del vendedor");
            String nombre = in.nextLine();

            if(existeCodigo(listaVendedores,codigo)){
                System.out.println("imposible añadir elementos duplicados");
            }else{
                Vendedores vendedores = new Vendedores(nombre, codigo);
                listaVendedores.add(vendedores);
                System.out.println("se agrego vendedor");
            }
        }
 */