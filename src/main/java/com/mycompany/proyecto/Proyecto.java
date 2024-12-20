/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyecto;

import ControlesGUI.Dashboard;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

/**
 * Clase principal de la aplicación Proyecto.
 * Esta clase contiene el método principal que configura el tema visual de la aplicación 
 * y lanza la interfaz de usuario (JFrame) para el sistema de reserva de asientos de autobús.
 * 
 * @author Cris
 */
public class Proyecto {

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * Establece el tema visual de la aplicación utilizando FlatLaf, 
     * y luego muestra la ventana principal del sistema de reservas de autobús.
     * 
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String args[]) {
        // Configuración del Look and Feel antes de mostrar el JFrame
        FlatMaterialLighterIJTheme.setup();
        
        // Ahora crear y mostrar el JFrame en el hilo correcto
        java.awt.EventQueue.invokeLater(() -> {
            // Crear una nueva instancia del Dashboard (ventana principal)
            new Dashboard().setVisible(true);
        });
    }
}