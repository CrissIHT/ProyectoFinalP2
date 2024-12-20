/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Clase que representa un recorrido de transporte, con información sobre el origen, destino, 
 * fecha y horario de salida.
 * 
 * Esta clase se utiliza para almacenar y gestionar los detalles de un recorrido específico.
 * 
 * @author Cris
 */
public class Recorrido {
    
    // Atributos del recorrido
    private String origen;
    private String destino;
    private String fecha;
    private String horarioSalida;

    /**
     * Constructor que inicializa un recorrido con los valores proporcionados.
     * 
     * @param origen El lugar de origen del recorrido.
     * @param destino El lugar de destino del recorrido.
     * @param fecha La fecha en la que se realiza el recorrido.
     * @param horarioSalida El horario de salida del recorrido.
     */
    public Recorrido(String origen, String destino, String fecha, String horarioSalida) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
    }

    // Getters y Setters

    /**
     * Obtiene el lugar de origen del recorrido.
     * 
     * @return El origen del recorrido.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece el lugar de origen del recorrido.
     * 
     * @param origen El nuevo lugar de origen.
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el lugar de destino del recorrido.
     * 
     * @return El destino del recorrido.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el lugar de destino del recorrido.
     * 
     * @param destino El nuevo lugar de destino.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la fecha del recorrido.
     * 
     * @return La fecha en la que se realiza el recorrido.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del recorrido.
     * 
     * @param fecha La nueva fecha del recorrido.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el horario de salida del recorrido.
     * 
     * @return El horario de salida del recorrido.
     */
    public String getHorarioSalida() {
        return horarioSalida;
    }

    /**
     * Establece el horario de salida del recorrido.
     * 
     * @param horarioSalida El nuevo horario de salida del recorrido.
     */
    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    /**
     * Devuelve una representación en formato String de los detalles del recorrido.
     * 
     * @return Una cadena de texto con el origen, destino, fecha y horario de salida.
     */
    @Override
    public String toString() {
        return "Recorrido [origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", horarioSalida=" + horarioSalida + "]";
    }
}
