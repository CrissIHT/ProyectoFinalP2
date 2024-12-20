/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import javax.swing.*;
import Clases.Recorrido;

/**
 * PanelRecorrido es un componente de interfaz gráfica de usuario (GUI) que permite al usuario seleccionar un origen, un destino, 
 * una fecha de salida y un horario para un viaje. El panel también ofrece una funcionalidad para guardar los datos en un objeto 
 * Recorrido y mostrar un mensaje de confirmación.
 * 
 * @author Cris
 */
public final class PanelRecorrido extends javax.swing.JPanel {

    private Recorrido recorrido;  // Instancia de la clase Recorrido para almacenar los datos del recorrido seleccionado.

    /**
     * Constructor del panel de recorrido. Inicializa los componentes del panel y aplica estilos personalizados.
     */
    public PanelRecorrido() {
        initComponents();
        initCustomComponents();  // Inicializa los componentes personalizados después de la configuración del panel.
        InitStyles();  // Aplica estilos personalizados a los elementos del panel.
    }

    /**
     * Método para aplicar estilos personalizados a los componentes del panel.
     */
    public void InitStyles(){
        jLabel1.putClientProperty("FlatLaf.styleClass", "h1");
        jLabel2.putClientProperty("FlatLaf.styleClass", "h3");
        jLabel3.putClientProperty("FlatLaf.styleClass", "h3");
        jLabel4.putClientProperty("FlatLaf.styleClass", "h3");
        jLabel5.putClientProperty("FlatLaf.styleClass", "h3");
        jLabel6.putClientProperty("FlatLaf.styleClass", "h3");
    }

    /**
     * Este método es generado automáticamente por el editor de formularios de Java. No modificar este código manualmente.
     * Inicializa todos los componentes del formulario.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Origen = new javax.swing.JComboBox<>();
        Destino = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        HorarioSalida = new javax.swing.JComboBox<>();
        Guardar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(635, 490));

        jLabel1.setText("Selecciona tu origen y destino");

        jLabel2.setText("Selecciona las ciudades de origen y destino, luego la fecha y el horario de salida");

        jLabel3.setText("Origen:");

        jLabel4.setText("Destino:");

        Origen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenActionPerformed(evt);
            }
        });

        Destino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Fecha de salida:");

        Fecha.setText("25/12/2024");
        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });

        jLabel6.setText("Horario de salida:");

        HorarioSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel6))
                                .addGap(108, 108, 108)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addComponent(HorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(Guardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(Guardar)
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrigenActionPerformed

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // Obtener los valores seleccionados o ingresados
        String origen = (String) Origen.getSelectedItem(); // Obtener el origen seleccionado
        String destino = (String) Destino.getSelectedItem(); // Obtener el destino seleccionado
        String fecha = Fecha.getText(); // Obtener la fecha de salida
        String horario = (String) HorarioSalida.getSelectedItem(); // Obtener el horario seleccionado

    // Crear un objeto Recorrido con los datos obtenidos
    recorrido = new Recorrido(origen, destino, fecha, horario);

    // Mostrar la información de recorrido (esto es opcional, solo para verificar que se guardó correctamente)
    System.out.println(recorrido);
    JOptionPane optionPane = new JOptionPane("Información guardada con éxito", JOptionPane.INFORMATION_MESSAGE);
    JDialog dialog = optionPane.createDialog(this, "Éxito");
    dialog.setLocation(450, 325); // Ajusta estas coordenadas según donde quieras que aparezca el mensaje

    dialog.setVisible(true);
    }//GEN-LAST:event_GuardarActionPerformed
    
    /**
     * Getter para obtener el objeto Recorrido con los datos seleccionados por el usuario.
     *
     * @return El objeto Recorrido con los datos del recorrido.
     */
    public Recorrido getRecorrido() {
        return recorrido;
    }

    /**
     * Inicializa los componentes personalizados del panel, como las opciones de origen,
     * destino y horarios de salida.
     */
    private void initCustomComponents() {
        // Inicializa las opciones de origen y destino
        Origen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cauquenes", "Concepción", "Chillán", "Coelemu", "Quirihue", "Los Angeles", "Talca", "Santiago" }));
        Destino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cauquenes", "Concepción", "Chillán", "Coelemu", "Quirihue", "Los Angeles", "Talca", "Santiago" }));

        // Agregar un ActionListener al JComboBox de Origen para actualizar los destinos
        Origen.addActionListener(e -> actualizarDestinos());

        // Generar los horarios disponibles y asignarlos al JComboBox HorarioSalida
        String[] horarios = new String[7];
        for (int i = 0; i < 7; i++) {
            int hora = 7 + (i * 2);  // Horas: 7, 9, 11, 13, 15, 17, 19
            String ampm = (hora < 12) ? "AM" : "PM"; // AM o PM
            int displayHora = (hora > 12) ? hora - 12 : hora;  // Ajuste para formato de 12 horas

            horarios[i] = String.format("%02d:00 %s", displayHora, ampm);  // Formatear la hora
        }
        // Asignar los horarios generados al JComboBox de HorarioSalida
        HorarioSalida.setModel(new javax.swing.DefaultComboBoxModel<>(horarios));
    }

    /**
     * Actualiza las opciones del destino según el origen seleccionado.
     * Excluye el origen de la lista de destinos.
     */
    private void actualizarDestinos() {
        String origen = (String) Origen.getSelectedItem();
        DefaultComboBoxModel<String> destinoModel = new DefaultComboBoxModel<>();

        String[] ciudades = {"Cauquenes", "Concepción", "Chillán", "Coelemu", "Quirihue", "Los Angeles", "Talca", "Santiago"};
        for (String destino : ciudades) {
            if (!destino.equals(origen)) {
                destinoModel.addElement(destino);
            }
        }
        Destino.setModel(destinoModel);
    }

    /**
     * Método principal para ejecutar la aplicación con el panel de recorrido.
     * Muestra una ventana con el panel de recorrido.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel de Recorrido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(635, 490);
        frame.add(new PanelRecorrido());
        frame.setVisible(true);
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Destino;
    private javax.swing.JTextField Fecha;
    private javax.swing.JButton Guardar;
    private javax.swing.JComboBox<String> HorarioSalida;
    private javax.swing.JComboBox<String> Origen;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
