/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ControlesGUI;

import Clases.Asiento;
import Clases.Autobus;
import Clases.Recorrido;
import Vistas.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que representa el Dashboard principal del sistema de reservas de asientos en autobús.
 * Permite navegar entre los diferentes paneles del sistema (Principal, Recorrido, Buses, Reserva).
 * Gestiona la interacción entre los paneles y muestra la información adecuada.
 * 
 * @author Cris
 */
public class Dashboard extends javax.swing.JFrame {

    // Panel principal donde se cambiarán los contenidos
    private PanelPrincipal p1;
    private PanelBuses p2;
    private PanelRecorrido p3;
    private PanelReserva p4;

    /**
     * Constructor de la clase Dashboard.
     * Configura la ventana, inicializa los componentes y establece los estilos.
     */
    public Dashboard() {
        // Configuraciones básicas de la ventana
        setTitle("Sistema de reserva para asientos de autobus");
        setDefaultCloseOperation(Dashboard.EXIT_ON_CLOSE); // Cerrar la ventana al salir
        
        initComponents();
        InitStyles(); // O cualquier otra inicialización de estilo
        setDate();
        initContent();
    }
    
    /**
     * Inicializa los paneles de contenido y los agrega al layout de la ventana.
     * Configura un CardLayout para alternar entre los paneles.
     */
    public void initContent() {
        // Crear instancias de los paneles
        p1 = new PanelPrincipal();
        p2 = new PanelBuses();
        p3 = new PanelRecorrido();
        
        // Creamos p4 (PanelReserva) y la configuramos solo si tenemos un recorrido válido
        p4 = new PanelReserva(); // Inicializamos PanelReserva sin datos en el constructor

        // Intentamos obtener el recorrido de p3 (PanelRecorrido)
        Recorrido recorrido = p3.getRecorrido(); // Suponiendo que tienes el método getRecorrido() en PanelRecorrido
        
        if (recorrido != null) {
            // Si hay un recorrido, usamos el setter para actualizar los datos en PanelReserva
            p4.setDatosRecorrido(recorrido.getOrigen(), recorrido.getDestino(), recorrido.getFecha(), recorrido.getHorarioSalida());
        } else {
            // Si no hay recorrido disponible, configuramos p4 con valores predeterminados o mostramos un mensaje
            p4.setDatosRecorrido("Origen Desconocido", "Destino Desconocido", "Fecha Desconocida", "Horario Desconocido");
        }

        // Crear un CardLayout para el panel Content
        CardLayout cardLayout = new CardLayout();
        Content.setLayout(cardLayout);
        
        // Agregar los paneles al contenedor Content
        Content.add(p1, "Principal");
        Content.add(p2, "Buses");
        Content.add(p3, "Recorrido");
        Content.add(p4, "Reserva");

        // Mostrar el panel "Principal" por defecto
        cardLayout.show(Content, "Principal");
    }
    
    /**
     * Cambia el panel visible en el CardLayout.
     * 
     * @param panelName El nombre del panel que se desea mostrar.
     */
    private void showPanel(String panelName) {
        // Obtener el CardLayout y cambiar al panel correspondiente
        CardLayout cardLayout = (CardLayout) Content.getLayout();
        cardLayout.show(Content, panelName);
    }

    /**
     * Establece la fecha actual en el label de la ventana.
     */
    public void setDate() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        dateText.setText("Hoy es " + dia + " de " + meses[month-1]+ " de "+ year);
    }

    /**
     * Inicializa los estilos para los componentes de la interfaz gráfica utilizando FlatLaf.
     */
    public void InitStyles() {
        Principal.putClientProperty( "FlatLaf.styleClass", "h3" );
        Buses.putClientProperty( "FlatLaf.styleClass", "h3" );
        Recorrido.putClientProperty( "FlatLaf.styleClass", "h3" );
        Reserva.putClientProperty( "FlatLaf.styleClass", "h3" );
        tituloen.putClientProperty( "FlatLaf.styleClass", "h1" );
        JavaBuses.putClientProperty( "FlatLaf.styleClass", "h1" );
        dateText.putClientProperty( "FlatLaf.styleClass", "h2" );
    }

    /**
     * Este método es llamado automáticamente para inicializar los componentes gráficos.
     * Los componentes son generados por el editor visual, no debe modificarse.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        Principal = new javax.swing.JButton();
        Buses = new javax.swing.JButton();
        Reserva = new javax.swing.JButton();
        Recorrido = new javax.swing.JButton();
        JavaBuses = new javax.swing.JLabel();
        Encabezado = new javax.swing.JPanel();
        tituloen = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(51, 102, 255));

        Principal.setBackground(new java.awt.Color(102, 153, 255));
        Principal.setForeground(new java.awt.Color(255, 255, 255));
        Principal.setText("Principal");
        Principal.setBorder(null);
        Principal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrincipalActionPerformed(evt);
            }
        });

        Buses.setBackground(new java.awt.Color(102, 153, 255));
        Buses.setForeground(new java.awt.Color(255, 255, 255));
        Buses.setText("Buses");
        Buses.setBorder(null);
        Buses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusesActionPerformed(evt);
            }
        });

        Reserva.setBackground(new java.awt.Color(102, 153, 255));
        Reserva.setForeground(new java.awt.Color(255, 255, 255));
        Reserva.setText("Reserva");
        Reserva.setBorder(null);
        Reserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaActionPerformed(evt);
            }
        });

        Recorrido.setBackground(new java.awt.Color(102, 153, 255));
        Recorrido.setForeground(new java.awt.Color(255, 255, 255));
        Recorrido.setText("Recorrido");
        Recorrido.setBorder(null);
        Recorrido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Recorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecorridoActionPerformed(evt);
            }
        });

        JavaBuses.setBackground(new java.awt.Color(102, 153, 255));
        JavaBuses.setForeground(new java.awt.Color(255, 255, 255));
        JavaBuses.setText("JavaBuses");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Reserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(JavaBuses, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addComponent(Buses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Recorrido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(JavaBuses)
                .addGap(75, 75, 75)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Recorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Buses, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Encabezado.setBackground(new java.awt.Color(102, 153, 255));

        tituloen.setForeground(new java.awt.Color(255, 255, 255));
        tituloen.setText("Bienvenido a nuestro sistema de reservas de JavaBuses");

        dateText.setForeground(new java.awt.Color(255, 255, 255));
        dateText.setText("datetext");

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateText)
                    .addComponent(tituloen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(tituloen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateText)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Content.setPreferredSize(new java.awt.Dimension(635, 490));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrincipalActionPerformed
        showPanel("Principal");  // Cambiar al panel Principal
    }//GEN-LAST:event_PrincipalActionPerformed
    /**
     * Acción realizada cuando el botón "Buses" es presionado.
     * Muestra el panel Buses.
     */
    private void BusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusesActionPerformed
        showPanel("Buses");  // Cambiar al panel Buses
    }//GEN-LAST:event_BusesActionPerformed
    /**
     * Acción realizada cuando el botón "Reserva" es presionado.
     * Muestra el panel de Reserva, y verifica si el recorrido y los asientos están disponibles.
     */
    private void ReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaActionPerformed
    Recorrido recorrido = p3.getRecorrido(); // Obtener el recorrido desde PanelRecorrido

        if (recorrido == null) {
            // Si no se ha guardado ningún recorrido, mostrar un mensaje
            JOptionPane.showMessageDialog(this, "No se ha guardado ningún recorrido.");
            return;
        }

        // Obtener los datos del recorrido
        String origen = recorrido.getOrigen();
        String destino = recorrido.getDestino();
        String fecha = recorrido.getFecha();
        String horario = recorrido.getHorarioSalida();

        // Asegúrate de que los valores no sean nulos o vacíos
        if (origen == null || origen.trim().isEmpty() ||
            destino == null || destino.trim().isEmpty() ||
            fecha == null || fecha.trim().isEmpty() ||
            horario == null || horario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Los datos del recorrido no están completos.");
            return;
        }

        // Actualizar el PanelReserva con los datos del recorrido
        p4.setDatosRecorrido(origen, destino, fecha, horario);

        // Obtener los asientos reservados de PanelBuses
        List<Asiento> asientosReservados = p2.getAsientosReservados();  // Declarar como List<Asiento>
        
        // Verificar si hay asientos reservados
        if (asientosReservados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay asientos reservados.");
            return;
        }

        // Pasar los asientos a PanelReserva
        p4.setAsientosReservados(asientosReservados);

        // Llamar a actualizarAsientos para mostrar los asientos reservados
        p4.actualizarAsientos();

        // Mostrar el panel de reserva
        showPanel("Reserva");
    }//GEN-LAST:event_ReservaActionPerformed
    /**
     * Acción realizada cuando el botón "Recorrido" es presionado.
     * Muestra el panel Recorrido.
     */
    private void RecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecorridoActionPerformed
        showPanel("Recorrido"); // Cambiar al panel Recorrido
    }//GEN-LAST:event_RecorridoActionPerformed

    /**
     * Método principal que arranca la aplicación.
     * Configura el estilo y crea una instancia de la clase Dashboard.
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buses;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel JavaBuses;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Principal;
    private javax.swing.JButton Recorrido;
    private javax.swing.JButton Reserva;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dateText;
    private javax.swing.JLabel tituloen;
    // End of variables declaration//GEN-END:variables
}
