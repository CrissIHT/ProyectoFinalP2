/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Clase que representa un asiento en un autobús, con atributos como número, categoría, 
 * disponibilidad y precio.
 * 
 * Esta clase se utiliza para gestionar la información de los asientos en el autobús, 
 * permitiendo determinar si están disponibles, su precio según la categoría y mostrar 
 * los detalles del asiento.
 * 
 * @author Cris
 */
public class Asiento {
    
    // Atributos del asiento
    private int numero;
    private String categoria;
    private boolean disponible;
    private double precio;  // Atributo para el precio del asiento

    /**
     * Constructor que inicializa un asiento con el número y la categoría especificados.
     * Además, establece la disponibilidad como verdadera por defecto y asigna el precio
     * según la categoría del asiento.
     * 
     * @param numero El número del asiento.
     * @param categoria La categoría del asiento (e.g., "Semi Cama", "Salón Cama").
     */
    public Asiento(int numero, String categoria) {
        this.numero = numero;
        this.categoria = categoria;
        this.disponible = true;  // Los asientos están disponibles por defecto
        // Establecer el precio según la categoría
        if (categoria.equals("Semi Cama")) {
            this.precio = 5000.0;
        } else if (categoria.equals("Salón Cama")) {
            this.precio = 9000.0;
        }
    }

    // Métodos Getter

    /**
     * Obtiene el número del asiento.
     * 
     * @return El número del asiento.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene la categoría del asiento (e.g., "Semi Cama", "Salón Cama").
     * 
     * @return La categoría del asiento.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Verifica si el asiento está disponible para la reserva.
     * 
     * @return true si el asiento está disponible, false si está reservado.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del asiento.
     * 
     * @param disponible true si el asiento se marca como disponible, false si está reservado.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el precio del asiento según su categoría.
     * 
     * @return El precio del asiento.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Muestra los detalles del asiento, incluyendo su número, categoría, precio y su estado 
     * de disponibilidad (si está disponible o reservado).
     * 
     * @return Una cadena que describe el asiento y su disponibilidad.
     */
    public String mostrarDetalles() {
        return "Asiento " + numero + " - " + categoria + "\nPrecio: " + precio + "\n" + (disponible ? "Disponible" : "Reservado");
    }
}