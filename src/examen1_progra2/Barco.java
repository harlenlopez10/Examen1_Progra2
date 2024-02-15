/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_progra2;
import java.util.Calendar;
        
    
/**
 *
 * @author harle
 */
public class Barco {

    enum TipoPesquero {
        PEZ(10.0),
        CAMARON(15.0),
        LANGOSTA(20.0);

        public final double price;

        TipoPesquero(double price) {
            this.price = price;
        }
    }
    private final String nombre;
    private Calendar fechaCirculacion = Calendar.getInstance();

    public Barco(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaCirculacion() {
        return fechaCirculacion;
    }

    public void agregarElemento() {
        // Método abstracto, se implementará en las clases hijas
    }

    public double vaciarCobrar() {
        // Método abstracto, se implementará en las clases hijas
        return 0.0;
    }

    public double precioElemento() {
        // Método abstracto, se implementará en las clases hijas
        return 0.0;
    }

    @Override
    public String toString() {
        return nombre;
    }

    private String obtenerFechaActual() {
        
        return "Fecha Actual";
    }
}
