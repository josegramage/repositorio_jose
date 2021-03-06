/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Vista;

/**
 *
 * @author Joso
 */
public class Vtna_cli_Crear extends javax.swing.JFrame {


    public Vtna_cli_Crear() {

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
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtFnacimiento = new com.toedter.calendar.JDateChooser();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        etiNombreError = new javax.swing.JLabel();
        errorNombre = new javax.swing.JButton();
        errorDni = new javax.swing.JButton();
        errorApellidos = new javax.swing.JButton();
        errorTelf = new javax.swing.JButton();
        errorFnacimiento = new javax.swing.JButton();
        etiApellidoError = new javax.swing.JLabel();
        etiDniError = new javax.swing.JLabel();
        etiTelefonoError = new javax.swing.JLabel();
        etiLogin = new javax.swing.JLabel();
        etiEmail = new javax.swing.JLabel();
        etiPassword = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        errorDireccion = new javax.swing.JButton();
        etiDireccionError = new javax.swing.JLabel();
        etiAvatar = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JButton();
        errorLogin = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox();
        etiTipo = new javax.swing.JLabel();
        etiEmail1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        errorEmail = new javax.swing.JButton();
        etiEmailError = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        errorPassword = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        panelCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        panelCrear.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel2.setText("Apellidos:");
        panelCrear.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jLabel3.setText("Dni:");
        panelCrear.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel4.setText("Telefono:");
        panelCrear.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel5.setText("Fecha de nacimiento:");
        panelCrear.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));
        panelCrear.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 129, -1));
        panelCrear.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 129, -1));
        panelCrear.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 129, -1));

        txtFnacimiento.setDateFormatString("dd/MM/yyyy");
        panelCrear.add(txtFnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        btnAceptar.setText("Aceptar");
        panelCrear.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        btnCancelar.setText("Cancelar");
        panelCrear.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        etiNombreError.setForeground(new java.awt.Color(255, 0, 0));
        etiNombreError.setText("Introduce un nombre válido");
        panelCrear.add(etiNombreError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        errorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 22, 20));

        errorDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 22, 20));

        errorApellidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 22, 20));

        errorTelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 22, 20));

        errorFnacimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorFnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 22, 20));

        etiApellidoError.setForeground(new java.awt.Color(255, 0, 0));
        etiApellidoError.setText("Introduce apellidos válidos");
        panelCrear.add(etiApellidoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        etiDniError.setForeground(new java.awt.Color(255, 0, 0));
        etiDniError.setText("Introduce un dni válido");
        panelCrear.add(etiDniError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        etiTelefonoError.setForeground(new java.awt.Color(255, 0, 0));
        etiTelefonoError.setText("Introduce un telefono válido");
        panelCrear.add(etiTelefonoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        etiLogin.setText("Login:");
        panelCrear.add(etiLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        etiEmail.setText("Dirección:");
        panelCrear.add(etiEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        etiPassword.setText("Password:");
        panelCrear.add(etiPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVolver.setText("VOLVER");
        panelCrear.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 180, -1));
        panelCrear.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 110, -1));

        errorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 22, 20));

        etiDireccionError.setForeground(new java.awt.Color(255, 0, 0));
        etiDireccionError.setText("Introduce una dirección válida");
        panelCrear.add(etiDireccionError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        etiAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCrear.add(etiAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 90));

        btnCargarImg.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnCargarImg.setText("Cargar imagen");
        panelCrear.add(btnCargarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        errorLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 22, 20));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Admin" }));
        panelCrear.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        etiTipo.setText("Tipo:");
        panelCrear.add(etiTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        etiEmail1.setText("Email:");
        panelCrear.add(etiEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));
        panelCrear.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 129, -1));

        errorEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 22, 20));

        etiEmailError.setForeground(new java.awt.Color(255, 0, 0));
        etiEmailError.setText("Introduce un email valido");
        panelCrear.add(etiEmailError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));
        panelCrear.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, -1));
        panelCrear.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 130, -1));

        errorPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/error.png"))); // NOI18N
        panelCrear.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 22, 20));
        panelCrear.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAceptar;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnCargarImg;
    public static javax.swing.JButton btnVolver;
    public static javax.swing.JComboBox comboTipo;
    public static javax.swing.JButton errorApellidos;
    public static javax.swing.JButton errorDireccion;
    public static javax.swing.JButton errorDni;
    public static javax.swing.JButton errorEmail;
    public static javax.swing.JButton errorFnacimiento;
    public static javax.swing.JButton errorLogin;
    public static javax.swing.JButton errorNombre;
    public static javax.swing.JButton errorPassword;
    public static javax.swing.JButton errorTelf;
    public static javax.swing.JLabel etiApellidoError;
    public static javax.swing.JLabel etiAvatar;
    public static javax.swing.JLabel etiDireccionError;
    public static javax.swing.JLabel etiDniError;
    private javax.swing.JLabel etiEmail;
    private javax.swing.JLabel etiEmail1;
    public static javax.swing.JLabel etiEmailError;
    public static javax.swing.JLabel etiLogin;
    public static javax.swing.JLabel etiNombreError;
    public static javax.swing.JLabel etiPassword;
    public static javax.swing.JLabel etiTelefonoError;
    public static javax.swing.JLabel etiTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel panelCrear;
    public static javax.swing.JTextField txtApellidos;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtEmail;
    public static com.toedter.calendar.JDateChooser txtFnacimiento;
    public static javax.swing.JTextField txtLogin;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
