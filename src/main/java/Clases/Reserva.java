/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 * Clase que representa una reserva de asientos para un servicio de autobús.
 * Permite agregar asientos seleccionados, calcular el precio total de la reserva
 * y mostrar un resumen de la reserva.
 * 
 * @author Cris
 */
public class Reserva {
    
    // Lista de asientos seleccionados para la reserva.
    private ArrayList<Asiento> asientosSeleccionados;
    
    // Precio total de la reserva.
    private double precioTotal;

    /**
     * Constructor de la clase Reserva.
     * Inicializa la lista de asientos seleccionados y establece el precio total en 0.
     */
    public Reserva() {
        this.asientosSeleccionados = new ArrayList<>();
        this.precioTotal = 0;
    }

    /**
     * Agrega un asiento a la reserva y actualiza el precio total.
     * 
     * @param asiento El asiento que se agregará a la reserva.
     */
    public void agregarAsiento(Asiento asiento) {
        asientosSeleccionados.add(asiento);
        // Precios para cada categoría de asiento: 5000 CLP para semi cama y 8000 CLP para salón cama
        precioTotal += (asiento.getCategoria().equals("salón cama")) ? 8000 : 5000;
    }

    /**
     * Calcula el precio total de la reserva.
     * 
     * @return El precio total de la reserva en CLP.
     */
    public double calcularPrecio() {
        return precioTotal;
    }

    /**
     * Muestra un resumen de la reserva, incluyendo los asientos seleccionados
     * y el precio total.
     */
    public void mostrarResumenReserva() {
        System.out.println("Resumen de la reserva:");
        for (Asiento asiento : asientosSeleccionados) {
            System.out.println("Asiento: " + asiento.getNumero() + " - " + asiento.getCategoria());
        }
        System.out.println("Precio Total: $" + precioTotal);
    }
}