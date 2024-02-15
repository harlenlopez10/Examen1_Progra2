/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_progra2;

/**
 *
 * @author harle
 */
public final class BarcoPesquero extends Barco{
    
    private int pecesCapturados;
    private final TipoPesquero tipoPesquero;

    public BarcoPesquero(String nombre, TipoPesquero tipoPesquero) {
        super(nombre);
        this.tipoPesquero = tipoPesquero;
        this.pecesCapturados = 0;
    }

    @Override
    public void agregarElemento() {
        pecesCapturados++;
    }

    @Override
    public double vaciarCobrar() {
        double total = pecesCapturados * tipoPesquero.price;
        pecesCapturados = 0;
        return total;
    }

    @Override
    public double precioElemento() {
        return tipoPesquero.price;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo: " + tipoPesquero + ", Peces capturados: " + pecesCapturados;
    }
    
}
