/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Clase que representa un autobús con un identificador, número de plazas y número de pisos.
 * 
 * Esta clase se utiliza para gestionar los detalles de los autobuses, como su ID, la cantidad
 * de plazas disponibles y el número de pisos que tiene.
 * 
 * @author Cris
 */
public class Autobus {
    
    // Atributos del autobús
    private int id;
    private int numPlazas;
    private int numPisos;

    /**
     * Constructor que inicializa un autobús con los valores proporcionados.
     * 
     * @param id El identificador único del autobús.
     * @param numPlazas El número de plazas que tiene el autobús.
     * @param numPisos El número de pisos del autobús.
     */
    public Autobus(int id, int numPlazas, int numPisos) {
        this.id = id;
        this.numPlazas = numPlazas;
        this.numPisos = numPisos;
    }

    // Getters

    /**
     * Obtiene el identificador del autobús.
     * 
     * @return El ID del autobús.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el número de plazas del autobús.
     * 
     * @return El número de plazas disponibles en el autobús.
     */
    public int getNumPlazas() {
        return numPlazas;
    }

    /**
     * Obtiene el número de pisos del autobús.
     * 
     * @return El número de pisos del autobús.
     */
    public int getNumPisos() {
        return numPisos;
    }

    /**
     * Devuelve una representación en formato String del autobús con su ID, número de plazas y pisos.
     * 
     * @return Una cadena de texto que describe el autobús.
     */
    @Override
    public String toString() {
        return "Autobus " + id + " - " + numPlazas + " plazas - " + numPisos + " piso(s)";
    }
}