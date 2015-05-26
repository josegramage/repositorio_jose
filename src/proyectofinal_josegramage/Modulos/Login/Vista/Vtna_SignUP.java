/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Login.Vista;

import proyectofinal_josegramage.Modulos.Clientes.Vista.*;

/**
 *
 * @author Joso
 */
public class Vtna_SignUP extends javax.swing.JFrame {


    public Vtna_SignUP() {

        initComponents();
      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCrear = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreL = new javax.swing.JTextField();
        txtApellidosL = new javax.swing.JTextField();
        txtDniL = new javax.swing.JTextField();
        txtTelefonoL = new javax.swing.JTextField();
        txtFnacimiento = new com.toedter.calendar.JDateChooser();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        etiNombreError = new javax.swing.JLabel();
        errorNombre = new javax.swing.JButton();
        errorDni = new javax.swing.JButton();
        errorApellidos = new javax.swing.JButton();
        errorTelf = new javax.swing.JButton();
        errorDireccion = new javax.swing.JButton();
        etiApellidoError = new javax.swing.JLabel();
        etiDniError = new javax.swing.JLabel();
        etiDireccionError = new javax.swing.JLabel();
        etiEmail = new javax.swing.JLabel();
        txtEmailL = new javax.swing.JTextField();
        errorEmail = new javax.swing.JButton();
        etiEmailError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccionL = new javax.swing.JTextField();
        errorFnacimiento = new javax.swing.JButton();
        etiTelefonoError = new javax.swing.JLabel();

        panelCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        panelCrear.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel2.setText("Apellidos:");
        panelCrear.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel3.setText("Dni:");
        panelCrear.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel4.setText("Telefono:");
        panelCrear.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel5.setText("Fecha de nacimiento:");
        panelCrear.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));
        panelCrear.add(txtNombreL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 129, -1));
        panelCrear.add(txtApellidosL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 129, -1));
        panelCrear.add(txtDniL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 129, -1));
        panelCrear.add(txtTelefonoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 129, -1));

        txtFnacimiento.setDateFormatString("dd/MM/yyyy");
        panelCrear.add(txtFnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 250, -1, -1));

        btnAceptar.setText("Aceptar");
        panelCrear.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        btnCancelar.setText("Cancelar");
        panelCrear.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        etiNombreError.setForeground(new java.awt.Color(255, 0, 0));
        etiNombreError.setText("Introduce un nombre válido");
        panelCrear.add(etiNombreError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        errorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 22, 20));

        errorDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 22, 20));

        errorApellidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 22, 20));

        errorTelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 22, 20));

        errorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 22, 20));

        etiApellidoError.setForeground(new java.awt.Color(255, 0, 0));
        etiApellidoError.setText("Introduce apellidos válidos");
        panelCrear.add(etiApellidoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        etiDniError.setForeground(new java.awt.Color(255, 0, 0));
        etiDniError.setText("Introduce un dni válido");
        panelCrear.add(etiDniError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        etiDireccionError.setForeground(new java.awt.Color(255, 0, 0));
        etiDireccionError.setText("Introduce una dirección válida");
        panelCrear.add(etiDireccionError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        etiEmail.setText("Email:");
        panelCrear.add(etiEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));
        panelCrear.add(txtEmailL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 129, -1));

        errorEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 22, 20));

        etiEmailError.setForeground(new java.awt.Color(255, 0, 0));
        etiEmailError.setText("Introduce un email válido");
        panelCrear.add(etiEmailError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jLabel7.setText("Direccion:");
        panelCrear.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        panelCrear.add(txtDireccionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 130, -1));

        errorFnacimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorFnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 22, 20));

        etiTelefonoError.setForeground(new java.awt.Color(255, 0, 0));
        etiTelefonoError.setText("Introduce un teléfono válido");
        panelCrear.add(etiTelefonoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAceptar;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton errorApellidos;
    public static javax.swing.JButton errorDireccion;
    public static javax.swing.JButton errorDni;
    public static javax.swing.JButton errorEmail;
    public static javax.swing.JButton errorFnacimiento;
    public static javax.swing.JButton errorNombre;
    public static javax.swing.JButton errorTelf;
    public static javax.swing.JLabel etiApellidoError;
    public static javax.swing.JLabel etiDireccionError;
    public static javax.swing.JLabel etiDniError;
    private javax.swing.JLabel etiEmail;
    public static javax.swing.JLabel etiEmailError;
    public static javax.swing.JLabel etiNombreError;
    public static javax.swing.JLabel etiTelefonoError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel panelCrear;
    public static javax.swing.JTextField txtApellidosL;
    public static javax.swing.JTextField txtDireccionL;
    public static javax.swing.JTextField txtDniL;
    public static javax.swing.JTextField txtEmailL;
    public static com.toedter.calendar.JDateChooser txtFnacimiento;
    public static javax.swing.JTextField txtNombreL;
    public static javax.swing.JTextField txtTelefonoL;
    // End of variables declaration//GEN-END:variables
}
