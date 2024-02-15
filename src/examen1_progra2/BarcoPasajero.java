/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_progra2;
import java.util.Scanner;

/**
 *
 * @author harle
 */
final class BarcoPasajero extends Barco {

    private final String[] nombresPasajeros;
    private final double precioBoleto;
    private int contadorPasajeros;

    public BarcoPasajero(String nombre, int capacidadPasajeros, double precioBoleto) {
        super(nombre);
        this.nombresPasajeros = new String[capacidadPasajeros];
        this.precioBoleto = precioBoleto;
        this.contadorPasajeros = 0;
    }

    @Override
    public void agregarElemento() {
        if (contadorPasajeros < nombresPasajeros.length) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del pasajero:");
            String nombrePasajero = scanner.nextLine(); 
            nombresPasajeros[contadorPasajeros++] = nombrePasajero;
        } else {
            System.out.println("No hay espacio para más pasajeros.");
        }
        
    }

    @Override
    public double vaciarCobrar() {
        double total = contadorPasajeros * precioBoleto;
        contadorPasajeros = 0;
        return total;
    }

    @Override
    public double precioElemento() {
        return precioBoleto;
    }

    @Override
    public String toString() {
        StringBuilder pasajeros = new StringBuilder();
        for (int i = 0; i < contadorPasajeros; i++) {
            pasajeros.append(nombresPasajeros[i]);
            if (i < contadorPasajeros - 1) {
                pasajeros.append(", ");
            }
        }
        return super.toString() + " - Cantidad de Pasajeros que compraron boleto: " + contadorPasajeros + " ["
                + pasajeros.toString() + "]";
    }

    public void listarPasajeros() {
        listarPasajerosRecursivo(0);
    }

    private void listarPasajerosRecursivo(int index) {
        if (index < contadorPasajeros) {
            System.out.println(nombresPasajeros[index]);
            listarPasajerosRecursivo(index + 1);
        }
    }
    
}
