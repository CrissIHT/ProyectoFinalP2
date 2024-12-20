/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Clases.Asiento;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que representa el panel de reservas, donde los usuarios pueden
 * ver los asientos disponibles, reservarlos, y realizar el pago por los asientos reservados.
 * 
 * Esta clase gestiona la visualización de la información de los asientos reservados,
 * actualiza los botones de los asientos en función de si están disponibles o no,
 * y procesa el pago al finalizar la reserva.
 * 
 * @author Cris
 */
public class PanelReserva extends javax.swing.JPanel {

    // Variables de instancia para almacenar información del recorrido
    private String origen, destino, fecha, horario;

    // Lista de asientos reservados y mapa de botones de asientos
    private List<Asiento> asientosReservados;
    private HashMap<Integer, JButton> botonesAsientos;

    // Componentes de la interfaz gráfica
    private JLabel labelRecorrido, labelOrigen, labelDestino, labelFecha, labelHorario;
    private JTextArea areaAsientos;
    
    // Variable para almacenar el total a pagar
    private double total;

    /**
     * Constructor que inicializa los componentes y configura la interfaz.
     * Inicializa las listas y etiquetas con valores predeterminados.
     */
    public PanelReserva() {
        initComponents();
        initUnitComponents();

        // Inicializamos la lista de asientos sin verificar null
        this.asientosReservados = new ArrayList<>();

        // Inicializamos las etiquetas con valores predeterminados
        labelRecorrido.setText("Recorrido: No disponible");
        labelOrigen.setText("Origen: No disponible");
        labelDestino.setText("Destino: No disponible");
        labelFecha.setText("Fecha: No disponible");
        labelHorario.setText("Horario: No disponible");

        // Actualizamos la interfaz con la información inicial
        actualizarAsientosReservados();
        actualizarTotal();
    }

    /**
     * Actualiza la visualización de los asientos reservados, deshabilitándolos
     * y cambiando su texto a "Reservado" en los botones correspondientes.
     */
    public void actualizarAsientos() {
        for (Asiento asiento : asientosReservados) {
            // Encontrar el botón correspondiente al asiento y deshabilitarlo
            JButton botonAsiento = obtenerBotonAsiento(asiento);
            botonAsiento.setEnabled(false); // Deshabilitar asientos ya reservados
            botonAsiento.setText("Reservado");
        }
    }

    /**
     * Establece los datos del recorrido (origen, destino, fecha y horario)
     * y actualiza las etiquetas correspondientes en la interfaz.
     * 
     * @param origen El lugar de origen del recorrido.
     * @param destino El lugar de destino del recorrido.
     * @param fecha La fecha del recorrido.
     * @param horario El horario del recorrido.
     */
    public void setDatosRecorrido(String origen, String destino, String fecha, String horario) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horario = horario;

        // Actualizar etiquetas con los valores proporcionados
        labelOrigen.setText("Origen: " + origen);
        labelDestino.setText("Destino: " + destino);
        labelFecha.setText("Fecha: " + fecha);
        labelHorario.setText("Horario: " + horario);

        // Mostrar el recorrido en la etiqueta correspondiente
        labelRecorrido.setText("Recorrido: " + origen + " a " + destino);
    }

    /**
     * Obtiene el botón correspondiente a un asiento dado su número.
     * 
     * @param asiento El asiento cuyo botón se desea obtener.
     * @return El botón correspondiente al asiento.
     */
    private JButton obtenerBotonAsiento(Asiento asiento) {
        // Obtener el botón desde el mapa de botones de asientos
        return botonesAsientos.get(asiento.getNumero());
    }

    /**
     * Agrega un asiento reservado a la lista de asientos reservados si está disponible.
     * Actualiza el total a pagar y la visualización de los asientos reservados.
     * 
     * @param asiento El asiento que se desea reservar.
     */
    public void agregarAsientoReservado(Asiento asiento) {
        if (asiento.isDisponible()) {
            // Verificar si el asiento tiene un precio válido
            if (asiento.getPrecio() <= 0) {
                JOptionPane.showMessageDialog(this, "Este asiento no tiene un precio válido.");
                return;
            }

            // Agregar el asiento a la lista de asientos reservados
            asientosReservados.add(asiento);
            asiento.setDisponible(false);  // Marcar como reservado

            // Actualizar el total y los asientos reservados
            actualizarTotal();
            actualizarAsientosReservados();

            // Actualizar el botón correspondiente
            JButton botonAsiento = botonesAsientos.get(asiento.getNumero());
            if (botonAsiento != null) {
                botonAsiento.setEnabled(false);  // Deshabilitar el botón
                botonAsiento.setText("Reservado");  // Cambiar el texto del botón
            }
        } else {
            JOptionPane.showMessageDialog(this, "Este asiento ya está ocupado.");
        }
    }

    /**
     * Actualiza el total a pagar sumando los precios de los asientos reservados.
     * Actualiza el label correspondiente con el nuevo total.
     */
    private void actualizarTotal() {
        total = 0.0;

        if (asientosReservados != null && !asientosReservados.isEmpty()) {
            // Sumar los precios de los asientos reservados
            for (Asiento asiento : asientosReservados) {
                total += asiento.getPrecio();
            }
        }

        // Actualizar el label del total a pagar con el nuevo valor
    }

    /**
     * Actualiza la visualización de los asientos reservados en un JTextArea.
     */
    private void actualizarAsientosReservados() {
        StringBuilder detalles = new StringBuilder("Asientos Reservados:\n");
        for (Asiento asiento : asientosReservados) {
            detalles.append("Asiento " + asiento.getNumero() + " - " + asiento.getCategoria() + " - $" + asiento.getPrecio() + "\n");
        }
        areaAsientos.setText(detalles.toString());
    }

    /**
     * Establece los asientos reservados desde una lista proporcionada y actualiza la visualización.
     * 
     * @param asientosReservados Lista de asientos reservados a mostrar.
     */
    public void setAsientosReservados(List<Asiento> asientosReservados) {
        StringBuilder detalles = new StringBuilder("Asientos Reservados:\n");
        for (Asiento asiento : asientosReservados) {
            detalles.append("Asiento " + asiento.getNumero() + " - " + asiento.getCategoria() + " - $" + asiento.getPrecio() + "\n");
        }
        areaAsientos.setText(detalles.toString());
    }

    /**
     * Procesa el pago y limpia la reserva. Los asientos se liberan y la información se actualiza.
     */
    private void procesarPago() {
        // Mostrar mensaje de pago exitoso
        JOptionPane.showMessageDialog(this, "Pago realizado con éxito.", "Confirmación de Pago", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar la reserva y liberar los asientos
        liberarAsientos();
        asientosReservados.clear();

        // Actualizar el total y los asientos reservados
        actualizarTotal();
        actualizarAsientosReservados();
    }

    /**
     * Libera los asientos reservados, cambiando su estado a disponible y habilitando
     * nuevamente los botones correspondientes. También actualiza la interfaz.
     */
    private void liberarAsientos() {
        for (Asiento asiento : asientosReservados) {
            // Volver a marcar los asientos como disponibles
            asiento.setDisponible(true);

            // Actualizar el botón correspondiente
            JButton botonAsiento = obtenerBotonAsiento(asiento);
            if (botonAsiento != null) {
                botonAsiento.setEnabled(true);  // Habilitar el botón
                botonAsiento.setText("Disponible");  // Cambiar el texto a "Disponible"
            }
        }

        // Limpiar la lista de asientos reservados
        asientosReservados.clear();
        
        // Actualizar el total y la interfaz
        actualizarTotal();  // Recalcular el total (debe ser 0.0 después de liberar)
        actualizarAsientosReservados();  // Actualizar la lista de asientos reservados en la interfaz
    }

    /**
     * Inicializa los componentes de la interfaz gráfica.
     */
    private void initUnitComponents() {
        setLayout(new BorderLayout());

        // Inicializar mapa de botones
        botonesAsientos = new HashMap<>();

        // Panel superior con información de recorrido y horario
        JPanel panelInformacion = new JPanel();
        panelInformacion.setLayout(new GridLayout(2, 1));  // Dos filas (recorrido y horario)

        labelRecorrido = new JLabel("Recorrido: ");
        labelRecorrido.setFont(new Font("Arial", Font.BOLD, 14));
        labelHorario = new JLabel("Horario: ");
        labelHorario.setFont(new Font("Arial", Font.BOLD, 14));
        labelOrigen = new JLabel("Origen: ");
        labelDestino = new JLabel("Destino: ");
        labelFecha = new JLabel("Fecha: ");
        
        labelRecorrido.setFont(new Font("Arial", Font.PLAIN, 12));
        labelOrigen.setFont(new Font("Arial", Font.PLAIN, 12));
        labelDestino.setFont(new Font("Arial", Font.PLAIN, 12));
        labelFecha.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInformacion.add(labelRecorrido);
        panelInformacion.add(labelHorario);

        add(panelInformacion, BorderLayout.NORTH);

        // Panel central con la lista de asientos y total
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(5, 2));

        areaAsientos = new JTextArea(10, 20);
        areaAsientos.setEditable(false);  // No se puede editar el texto
        areaAsientos.setFont(new Font("Arial", Font.PLAIN, 12));

        JScrollPane scrollAsientos = new JScrollPane(areaAsientos);

        panelCentro.add(scrollAsientos);

        add(panelCentro, BorderLayout.CENTER);

        // Panel inferior con el botón de pagar
        JButton btnPagar = new JButton("Pagar");
        btnPagar.setFont(new Font("Arial", Font.BOLD, 14));
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPago();  // Procesar el pago cuando el usuario haga clic en Pagar
            }
        });

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new FlowLayout());
        panelSur.add(btnPagar);

        add(panelSur, BorderLayout.SOUTH);
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}