/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Inicio.Vista;

/**
 *
 * @author Joso
 */
public class Vtna_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Vtna_Inicio
     */
    public Vtna_Inicio() {
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

        panel_inicio = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        etiInicio = new javax.swing.JLabel();
        etiProductos = new javax.swing.JLabel();
        etiJuegos = new javax.swing.JLabel();
        etiHistoria = new javax.swing.JLabel();
        etiNosotros = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        etiAvatarInicio = new javax.swing.JLabel();
        eti_Entrar_Usuario = new javax.swing.JLabel();
        eti_Reg_Perfil = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        etiLogo = new javax.swing.JLabel();
        etiAdmin = new javax.swing.JLabel();
        internalFrame = new javax.swing.JInternalFrame();
        panel_internal_frame = new javax.swing.JPanel();
        etiFondo_inicio = new javax.swing.JLabel();
        etiFrasesCelebres = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_inicio.setBackground(new java.awt.Color(255, 255, 255));

        etiInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiInicio.setText("Inicio");
        etiInicio.setFocusable(false);
        etiInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        etiProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiProductos.setText("Productos");

        etiJuegos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiJuegos.setText("Juegos");

        etiHistoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiHistoria.setText("Historia");

        etiNosotros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiNosotros.setText("Sobre nosotros");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(etiInicio)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(etiJuegos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(etiProductos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(etiHistoria)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(etiNosotros)
                        .addContainerGap())))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(etiInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(etiJuegos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(etiProductos)
                .addGap(82, 82, 82)
                .addComponent(etiHistoria)
                .addGap(66, 66, 66)
                .addComponent(etiNosotros)
                .addGap(25, 25, 25))
        );

        eti_Entrar_Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        eti_Reg_Perfil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        etiLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/logo_azul.png"))); // NOI18N

        etiAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiAdmin.setText("Menu Admin");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(etiLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(etiAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eti_Entrar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eti_Reg_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(etiAvatarInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addComponent(eti_Entrar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiAdmin)
                            .addComponent(eti_Reg_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addComponent(etiAvatarInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        internalFrame.setVisible(true);
        internalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiFondo_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/fondos/fondo_inicio.jpg"))); // NOI18N
        etiFondo_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiFrasesCelebres.setEditable(false);
        etiFrasesCelebres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etiFrasesCelebres.setBorder(null);
        etiFrasesCelebres.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        etiFrasesCelebres.setEnabled(false);

        javax.swing.GroupLayout panel_internal_frameLayout = new javax.swing.GroupLayout(panel_internal_frame);
        panel_internal_frame.setLayout(panel_internal_frameLayout);
        panel_internal_frameLayout.setHorizontalGroup(
            panel_internal_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiFondo_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_internal_frameLayout.createSequentialGroup()
                .addComponent(etiFrasesCelebres, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_internal_frameLayout.setVerticalGroup(
            panel_internal_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_internal_frameLayout.createSequentialGroup()
                .addComponent(etiFondo_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiFrasesCelebres, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        internalFrame.getContentPane().add(panel_internal_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 730, 500));

        javax.swing.GroupLayout panel_inicioLayout = new javax.swing.GroupLayout(panel_inicio);
        panel_inicio.setLayout(panel_inicioLayout);
        panel_inicioLayout.setHorizontalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(internalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        panel_inicioLayout.setVerticalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(internalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel etiAdmin;
    public static javax.swing.JLabel etiAvatarInicio;
    public static javax.swing.JLabel etiFondo_inicio;
    public static javax.swing.JTextField etiFrasesCelebres;
    public static javax.swing.JLabel etiHistoria;
    public static javax.swing.JLabel etiInicio;
    public static javax.swing.JLabel etiJuegos;
    public static javax.swing.JLabel etiLogo;
    public static javax.swing.JLabel etiNosotros;
    public static javax.swing.JLabel etiProductos;
    public static javax.swing.JLabel eti_Entrar_Usuario;
    public static javax.swing.JLabel eti_Reg_Perfil;
    public static javax.swing.JInternalFrame internalFrame;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JPanel panelLogin;
    public static javax.swing.JPanel panelMenu;
    public static javax.swing.JPanel panel_inicio;
    public static javax.swing.JPanel panel_internal_frame;
    // End of variables declaration//GEN-END:variables
}
