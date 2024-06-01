package com.excepciones.java.potencia;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class punto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medico> listaMedicos = new ArrayList<>();

        // Creación de la lista de objetos Médico (sin lectura de datos)
        listaMedicos.add(new Medico("Ana López", "Pediatría"));
        listaMedicos.add(new Medico("Carlos Muñoz", "Traumatología"));
        listaMedicos.add(new Medico("Ana López", "Pediatría"));
        listaMedicos.add(new Medico("Carlos Muñoz", "Traumatología"));

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("Ingrese la posición del médico que desea consultar: ");
                int posicion = scanner.nextInt();

                if (posicion < 0 || posicion >= listaMedicos.size()) {
                    throw new IndexOutOfBoundsException("La posición ingresada no es válida");
                }

                Medico medico = listaMedicos.get(posicion);
                System.out.println("Nombre: " + medico.getNombre());
                System.out.println("Especialidad: " + medico.getEspecialidad());

                continuar = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next(); // Limpiar el buffer de entrada
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}

    
class Medico {

    private String nombre;
    private String especialidad;

    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

