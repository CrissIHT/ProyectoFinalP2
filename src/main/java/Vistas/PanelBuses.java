/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Clases.Asiento;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que representa un panel gráfico para gestionar la selección de asientos
 * en los autobuses del sistema.
 * Permite elegir el tipo de autobús, visualizar los asientos disponibles y
 * realizar reservas de asientos.
 */
public class PanelBuses extends javax.swing.JPanel {
    
    /** ComboBox para seleccionar el tipo de autobús (1 piso o 2 pisos). */
    private final JComboBox<String> comboTipoBus;
    
    /** Panel para mostrar los asientos disponibles. */
    private final JPanel panelAsientos;
    
    /** Arreglo de objetos Asiento. */
    private Asiento[] asientos;  
    
    /** Lista de asientos que han sido reservados. */
    private List<Asiento> asientosReservados;  

    /**
     * Constructor que inicializa el panel y configura la interfaz gráfica.
     */
    public PanelBuses() {
        initComponents();
        setLayout(new BorderLayout());
        
        // Inicializar la lista de asientos reservados
        asientosReservados = new ArrayList<>();

        // Panel de selección de tipo de bus
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new FlowLayout());

        String[] tiposDeBus = { "1 Piso (10 Asientos)", "2 Pisos (20 Asientos)" };
        comboTipoBus = new JComboBox<>(tiposDeBus);
        comboTipoBus.addActionListener((ActionEvent e) -> {
            mostrarAsientos();
        });

        panelSeleccion.add(new JLabel("Selecciona tipo de autobús:"));
        panelSeleccion.add(comboTipoBus);

        // Panel para mostrar los asientos
        panelAsientos = new JPanel();
        panelAsientos.setLayout(new BoxLayout(panelAsientos, BoxLayout.Y_AXIS));  // Usamos BoxLayout para filas de asientos

        add(panelSeleccion, BorderLayout.NORTH);
        add(panelAsientos, BorderLayout.CENTER);

        mostrarAsientos();  // Mostrar los asientos al cargar 
    }
    
    /**
     * Obtiene la lista de asientos reservados.
     * 
     * @return Lista de objetos Asiento que representan los asientos reservados.
     */
    public List<Asiento> getAsientosReservados() {
        return asientosReservados;  // Devuelve la lista de objetos Asiento
    }
    
    /**
     * Establece una lista de asientos reservados y actualiza la vista.
     * 
     * @param asientosReservados Lista de objetos Asiento que representan los asientos reservados.
     */
    public void setAsientosReservados(List<Asiento> asientosReservados) {
        this.asientosReservados = asientosReservados;
        mostrarAsientos();  // Refrescar la interfaz para reflejar los cambios
    }

    /**
     * Muestra los asientos disponibles según el tipo de autobús seleccionado (1 piso o 2 pisos).
     */
    private void mostrarAsientos() {
        panelAsientos.removeAll();  // Limpiar los asientos anteriores

        String tipoBus = (String) comboTipoBus.getSelectedItem();
        int numAsientos = tipoBus.contains("1 Piso") ? 10 : 20;
        
        // Crear los objetos Asiento
        asientos = new Asiento[numAsientos];
        for (int i = 0; i < numAsientos; i++) {
            String categoria = (i % 2 == 0) ? "Semi Cama" : "Salón Cama";  // Alternar categorías
            asientos[i] = new Asiento(i + 1, categoria);
        }

        // Dividir los asientos en los dos pisos si es un bus de 2 pisos
        if (tipoBus.contains("2 Pisos")) {
            JPanel primerPiso = new JPanel();
            primerPiso.setLayout(new GridLayout(5, 2));  // 5 filas x 2 columnas
            primerPiso.setBorder(BorderFactory.createTitledBorder("Primer Piso"));
            for (int i = 0; i < 10; i++) {
                agregarAsiento(primerPiso, i);
            }
            panelAsientos.add(primerPiso);

            JPanel segundoPiso = new JPanel();
            segundoPiso.setLayout(new GridLayout(5, 2));  // 5 filas x 2 columnas
            segundoPiso.setBorder(BorderFactory.createTitledBorder("Segundo Piso"));
            for (int i = 10; i < 20; i++) {
                agregarAsiento(segundoPiso, i);
            }
            panelAsientos.add(segundoPiso);
        } else {
            JPanel primerPiso = new JPanel();
            primerPiso.setLayout(new GridLayout(5, 2));  // 5 filas x 2 columnas
            for (int i = 0; i < 10; i++) {
                agregarAsiento(primerPiso, i);
            }
            panelAsientos.add(primerPiso);
        }

        panelAsientos.revalidate();
        panelAsientos.repaint();
    }
    
    /**
     * Agrega un botón de asiento al panel indicado, configurando su comportamiento
     * de acuerdo con la disponibilidad del asiento.
     * 
     * @param panel El panel donde se agregará el asiento.
     * @param index El índice del asiento dentro del arreglo de asientos.
     */
    private void agregarAsiento(JPanel panel, int index) {
        JButton asientoButton = new JButton((index + 1) + "");  // Muestra el número del asiento
        asientoButton.setFont(new Font("Arial", Font.BOLD, 12));  
        asientoButton.setPreferredSize(new Dimension(50, 50)); 

        Asiento asiento = asientos[index];
        if (asiento.isDisponible()) {
            asientoButton.setBackground(Color.GREEN);  // Asiento disponible
        } else {
            asientoButton.setBackground(Color.RED);  // Asiento reservado
        }

        final int i = index;
        asientoButton.addActionListener((ActionEvent e) -> {
            Asiento selectedAsiento = asientos[i];
            
            // Si el asiento está reservado, volver a disponible
            if (!selectedAsiento.isDisponible()) {
                // Marcar como disponible
                selectedAsiento.setDisponible(true);
                asientoButton.setBackground(Color.GREEN);  // Cambiar color a verde
                // Eliminar de la lista de reservados
                asientosReservados.remove(selectedAsiento);
            } else {
                // Si el asiento está disponible, marcarlo como ocupado
                selectedAsiento.setDisponible(false);  // Marcar como ocupado
                asientoButton.setBackground(Color.RED);  // Cambiar color a rojo
                asientosReservados.add(selectedAsiento);  // Agregar a la lista de reservados
            }
            
            // Mostrar detalles del asiento con el precio
            mostrarDetallesAsiento(i);
        });

        panel.add(asientoButton);
    }
    
    /**
     * Muestra los detalles del asiento seleccionado, incluyendo su categoría y precio.
     * 
     * @param index El índice del asiento seleccionado dentro del arreglo de asientos.
     */
    private void mostrarDetallesAsiento(int index) {
        Asiento asiento = asientos[index];
        String detalles = asiento.mostrarDetalles();
        JOptionPane.showMessageDialog(this, detalles, "Detalles del Asiento", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método generado automáticamente para inicializar los componentes gráficos.
     * No se debe modificar este código, ya que es generado por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
