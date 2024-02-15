/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_progra2;

import examen1_progra2.Barco.TipoPesquero;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author harle
 */
public class Muelle {

    private final ArrayList<Barco> listaBarcos;
    public static String nombre;
    public static int capacidadPasajeros;
    public static double precioBoleto;

    public Muelle() {
        this.listaBarcos = new ArrayList<>();
    }

    public void agregarBarco(String tipo) {
        
        if (!esNombreUnico(nombre)) {
            System.out.println("El nombre del barco ya existe. Intente nuevamente.");
            return;
        }
        if (tipo.equalsIgnoreCase("PESQUERO")) {
            System.out.println("Ingrese el tipo de pesquero (PEZ, CAMARON, LANGOSTA):");
            TipoPesquero tipoPesquero = TipoPesquero.valueOf(scanner.nextLine().toUpperCase());
            listaBarcos.add(new BarcoPesquero(nombre, tipoPesquero));
        } else if (tipo.equalsIgnoreCase("PASAJERO")) {
            System.out.println("Ingrese la capacidad de pasajeros:");
            
            System.out.println("Ingrese el precio del boleto:");
            
            listaBarcos.add(new BarcoPasajero(nombre, capacidadPasajeros, precioBoleto));
        } else {
            System.out.println("Tipo de barco no reconocido.");
        }
    }

    public void agregarElemento(String nombre) {
        for (Barco barco : listaBarcos) {
            if (barco.getNombre().equalsIgnoreCase(nombre)) {
                barco.agregarElemento();
                System.out.println("Elemento agregado al barco: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró ningún barco con ese nombre.");
    }

    public double vaciarBarco(String nombre) {
        for (Barco barco : listaBarcos) {
            if (barco.getNombre().equalsIgnoreCase(nombre)) {
                double totalGenerado = barco.vaciarCobrar();
                System.out.println("Total generado por el barco " + nombre + ": $" + totalGenerado);
                System.out.println("Datos del Barco:");
                System.out.println(barco.toString());
                if (barco instanceof BarcoPasajero) {
                    System.out.println("Pasajeros que se bajaron del barco:");
                    ((BarcoPasajero) barco).listarPasajeros();
                }
                return totalGenerado;
            }
        }
        System.out.println("No se encontró ningún barco con ese nombre.");
        return 0.0;
    }

    public void barcosDesde(int year) {
        System.out.println("Barcos desde el año " + year + ":");
        barcosDesdeRecursivo(year, 0);
    }

    private void barcosDesdeRecursivo(int year, int index) {
        if (index < listaBarcos.size()) {
            Barco barco = listaBarcos.get(index);
            int yearBarco = Integer.parseInt(barco.getFechaCirculacion());
            if (yearBarco >= year) {
                System.out.println(barco.getNombre() + " - " + barco.getFechaCirculacion());
            }
            barcosDesdeRecursivo(year, index + 1);
        }
    }

    private boolean esNombreUnico(String nombre) {
        for (Barco barco : listaBarcos) {
            if (barco.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Muelle muelle = new Muelle();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Barco");
            System.out.println("2. Agregar Elemento a Barco");
            System.out.println("3. Vaciar Barco");
            System.out.println("4. Mostrar Barcos desde un Año");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de barco (PESQUERO o PASAJERO):");
                    String tipoBarco = scanner.nextLine();
                    muelle.agregarBarco(tipoBarco);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del barco al que desea agregar un elemento:");
                    String nombreBarcoAgregar = scanner.nextLine();
                    muelle.agregarElemento(nombreBarcoAgregar);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del barco que desea vaciar:");
                    String nombreBarcoVaciar = scanner.nextLine();
                    muelle.vaciarBarco(nombreBarcoVaciar);
                    break;
                case 4:
                    System.out.println("Ingrese el año desde el cual desea mostrar los barcos:");
                    int year = scanner.nextInt();
                    muelle.barcosDesde(year);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
    
}
