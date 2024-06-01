package com.excepciones.java.potencia;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter


class Vendedor {
    int codigo;
    String nombre;
    double ventas;

    public Vendedor(int codigo, String nombre, double ventas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ventas = ventas;
    }
}

class VendedorDuplicadoException extends Exception {
    public VendedorDuplicadoException(String mensaje) {
        super(mensaje);
    }
}

public class Prueba {
    public static void main(String[] args) {
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean bueno = false;
        listaVendedores.add(new Vendedor(1, 
                                        "Jhosfin Canon", 
                                        5));
        listaVendedores.add(new Vendedor(2, 
                                        "Alejojo Barrera", 
                                        20));
        listaVendedores.add(new Vendedor(3, 
                                        "Dainele Rosas", 
                                        9));
        listaVendedores.add(new Vendedor(4, 
                                        "Rick Sanchez", 
                                        5));
        listaVendedores.add(new Vendedor(5, 
                                        "Julian Negrete", 
                                        20));
        listaVendedores.add(new Vendedor(6, 
                                        "Vannesa Melano", 
                                        9));

        do {
            try {
                System.out.println("Ingrese el código nuevo vendedor:");
                int codigo = scanner.nextInt();
                
                for (Vendedor vendedor : listaVendedores) {
                    if (vendedor.getCodigo() == codigo) {
                        throw new VendedorDuplicadoException("Error: Imposible añadir elementos duplicados");
                    }
                }
                
                scanner.nextLine();
                System.out.println("Ingrese el nombre del vendedor:");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese las ventas del vendedor:");
                double ventas = scanner.nextDouble();

                listaVendedores.add(new Vendedor(codigo, nombre, ventas));
                System.out.println("Has añadido el vendedor con el código: " + codigo);

                bueno = true;

            } catch (InputMismatchException e) {
                System.out.println("Error, solo se pueden ingresar números como código y ventas. Intenta de nuevo.");
                scanner.next();
            } catch (VendedorDuplicadoException e) {
                System.out.println(e.getMessage());
            }
        } while (!bueno);

        scanner.close();

        System.out.println("Lista Actualizada de vendedores:");
        for (Vendedor vendedor : listaVendedores) {
            System.out.println("Codigo del vendedor: " + vendedor.getCodigo() + ", Nombre: " + vendedor.getNombre() + ", Ventas: " + vendedor.getVentas());
        }
    }
}