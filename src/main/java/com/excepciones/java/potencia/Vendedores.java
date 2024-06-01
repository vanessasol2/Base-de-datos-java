package com.excepciones.java.potencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class Vendedores {
    private static Vendedores vendedores;
    String nombre;
    String codigo;

    
    public Vendedores(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }


    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        
        List<Vendedores>listaVendedores = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese codigo");
            String codigo = in.nextLine();
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
        System.out.println("Lista de vendedores: ");
        for(Vendedores vendedores :  listaVendedores){
            System.out.println(vendedores);
        }
    }


    @SuppressWarnings("unused")
    private static boolean agregarVendedor(List<Vendedores> listaVendedores, Vendedores vendedores2) {
        if (existeCodigo(listaVendedores, vendedores.getCodigo())){
            throw new UnsupportedOperationException("Unimplemented method 'existeCodigo'");
        }
        listaVendedores.add(vendedores);
        return true;
        
    }

    public static boolean existeCodigo(List<Vendedores> listaVendedores, String codigo) {
       for(Vendedores vendedores : listaVendedores){
        if (vendedores.getCodigo().equals(codigo)) {
            return true;
        }
       }
        
        return false;
        
    }

}
