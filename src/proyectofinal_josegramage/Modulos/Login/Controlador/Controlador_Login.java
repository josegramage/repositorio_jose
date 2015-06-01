/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Login.Controlador;

import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Controlador.Controlador_Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Menu.Controlador.Controlador_Menu;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Menu_Admin;
import proyectofinal_josegramage.Modulos.Login.Modelo.BLL.LoginBLL;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyectofinal_josegramage.Utiles.FileUploader;
import proyectofinal_josegramage.Modulos.Inicio.Controlador.Controlador_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_panel_Inicio;
import proyectofinal_josegramage.Modulos.Login.Modelo.DAO.LoginDAO;

/**
 *
 * @author Joso
 */
public class Controlador_Login implements ActionListener, MouseListener, KeyListener {

    public enum Accion {

        // login
        _TXT_LOGIN,
        _TXT_PASSWORD,
        _BTN_ACEPTAR_login,
        _BTN_PASSW_OLVID,
        _BTN_REGISTRO,
        // Ventana crear
        _TXT_NOMBRE,
        _TXT_APELLIDOS,
        _TXT_DNI,
        _TXT_TELEFONO,
        _TXT_DIRECCION,
        _TXT_EMAIL,
        _TXT_FNACIMIENTO,
        _BTN_CARGAR_IMG,
        _BTN_ACEPTAR_alta,
        _BTN_CANCELAR,
        // recuperar password
        _BTN_ACEPTAR_RECU,
    }

    public Controlador_Login(JFrame Login, int i) {

        if (i == 0) {
            Singletons.login = (Vtna_SignIN) Login;
        }

        if (i == 1) {
            Singletons.alta = (Vtna_SignUP) Login;
        }

        if (i == 2) {
            Singletons.recu = (Vtna_Recuperar) Login;
        }
    }

    public void iniciar(int i) {

        if (i == 0) {   //  vtna_login

            Singletons.login.etiUsuarioError.setVisible(false);
            Singletons.login.etiPasswordError.setVisible(false);

            Singletons.login.txtUsuario.requestFocus();

            Singletons.login.btnAceptar.setActionCommand("_BTN_ACEPTAR_login");
            Singletons.login.btnAceptar.setName("_BTN_ACEPTAR_login");
            Singletons.login.btnAceptar.addActionListener(this);
            Singletons.login.btnAceptar.addMouseListener(this);

            Singletons.login.txtUsuario.setName("_TXT_LOGIN");
            Singletons.login.txtUsuario.addMouseListener(this);
            Singletons.login.txtUsuario.addKeyListener(this);

            Singletons.login.txtPassword.setName("_TXT_PASSWORD");
            Singletons.login.txtPassword.addKeyListener(this);
            Singletons.login.txtPassword.addMouseListener(this);

            Singletons.login.etiRegistro.setName("_BTN_REGISTRO");
            Singletons.login.etiRegistro.addMouseListener(this);
            Singletons.login.etiRegistro.setForeground(Color.black);

            Singletons.login.etiPassword.setName("_BTN_PASSW_OLVID");
            Singletons.login.etiPassword.addMouseListener(this);
            Singletons.login.etiPassword.setForeground(Color.black);

        }

        //     vtna alta cliente
        if (i == 1) {

            LoginDAO.ocultarErrores();

            Singletons.alta.txtNombreL.setName("_TXT_NOMBRE");
            Singletons.alta.txtNombreL.setActionCommand("_TXT_NOMBRE");
            Singletons.alta.txtNombreL.addActionListener(this);
            Singletons.alta.txtNombreL.addKeyListener(this);

            Singletons.alta.txtApellidosL.setName("_TXT_APELLIDOS");
            Singletons.alta.txtApellidosL.setActionCommand("_TXT_APELLIDOS");
            Singletons.alta.txtApellidosL.addActionListener(this);
            Singletons.alta.txtApellidosL.addKeyListener(this);

            Singletons.alta.txtDniL.setName("_TXT_DNI");
            Singletons.alta.txtDniL.setActionCommand("_TXT_DNI");
            Singletons.alta.txtDniL.addActionListener(this);
            Singletons.alta.txtDniL.addKeyListener(this);

            Singletons.alta.txtTelefonoL.setName("_TXT_TELEFONO");
            Singletons.alta.txtTelefonoL.setActionCommand("_TXT_TELEFONO");
            Singletons.alta.txtTelefonoL.addActionListener(this);
            Singletons.alta.txtTelefonoL.addKeyListener(this);

            Singletons.alta.txtEmailL.setName("_TXT_EMAIL");
            Singletons.alta.txtEmailL.setActionCommand("_TXT_EMAIL");
            Singletons.alta.txtEmailL.addActionListener(this);
            Singletons.alta.txtEmailL.addKeyListener(this);

            Singletons.alta.txtDireccionL.setName("_TXT_DIRECCION");
            Singletons.alta.txtDireccionL.setActionCommand("_TXT_DIRECCION");
            Singletons.alta.txtDireccionL.addActionListener(this);
            Singletons.alta.txtDireccionL.addKeyListener(this);

            Singletons.alta.btnAceptar.setActionCommand("_BTN_ACEPTAR_alta");
            Singletons.alta.btnAceptar.addActionListener(this);

            Singletons.alta.btnCancelar.setActionCommand("_BTN_CANCELAR");
            Singletons.alta.btnCancelar.addActionListener(this);

        }

        if (i == 2) {   //  vtna olvidar password

            Singletons.recu.btnAceptarRecu.setActionCommand("_BTN_ACEPTAR_RECU");
            Singletons.recu.btnAceptarRecu.setName("_BTN_ACEPTAR_RECU");
            Singletons.recu.btnAceptarRecu.addActionListener(this);
            Singletons.recu.btnAceptarRecu.addMouseListener(this);

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {

            // ----------- Login ------------------------  
            case _BTN_ACEPTAR_login:

                String usuario = Vtna_SignIN.txtUsuario.getText();
                String password = Vtna_SignIN.txtPassword.getText();
                boolean login;
                
                LoginBLL _login = new LoginBLL();

                login = _login.loginUsuarioBLL(usuario, password);
                
                LoginBLL.activarUsuarioBLL(usuario);
                
                if (login == true) {
                    Singletons.conectado = true;

                    Singletons.ini.eti_Entrar_Usuario.setText(Singletons.cliLog.getLogin());
                    Singletons.ini.eti_Reg_Perfil.setText("Mi perfil");

                    if (Singletons.cliLog.getAvatar().isEmpty()) {
                        FileUploader.leer_imag_defecto(2);
                    } else {
                        FileUploader.leer_imag(0);
                    }

                    if (Singletons.cliLog.getTipo().equals("admin")) {
                        Singletons.ini.etiAdmin.setVisible(true);
                        Singletons.login.dispose();

                        new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
                        JPanel p4 = new JPanel();
                        p4.add(Singletons.menu.panelMenu);
                        Singletons.ini.internalFrame.setContentPane(p4);

                    } else if (Singletons.cliLog.getTipo().equals("usuario")) {

                        Singletons.login.dispose();
                        new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);
                        JPanel panel_Inicio = new JPanel();
                        panel_Inicio.add(Singletons.iniPanel.panelInicio);
                        Singletons.ini.internalFrame.setContentPane(panel_Inicio);

                    }

                } else {
                    Vtna_SignIN.etiUsuarioError.setVisible(true);
                    Vtna_SignIN.etiPasswordError.setVisible(true);

                    return;
                }
                break;

            // ------------ alta cliente --------------
            case _TXT_NOMBRE:
                LoginBLL.pideNombre();
                break;

            case _TXT_APELLIDOS:
                LoginBLL.pideApellidos();
                break;

            case _TXT_DNI:
                LoginBLL.pideDni();
                break;

            case _TXT_TELEFONO:
                LoginBLL.pideTelefono();
                break;

            case _TXT_EMAIL:
                LoginBLL.pideEmail();
                break;

            case _TXT_DIRECCION:
                LoginBLL.pideDireccion();
                break;

            case _BTN_ACEPTAR_alta:
                LoginBLL.AltaUsuario();
                
                if (Singletons.cli.getFechaalta()!= null) {
                Singletons.alta.dispose();
                new Controlador_Login(new Vtna_SignIN(), 0).iniciar(0);
                JPanel p4 = new JPanel();
                p4.add(Singletons.login.panelLogin);
                Singletons.ini.internalFrame.setContentPane(p4);
                }
                break;

            case _BTN_CANCELAR:
                LoginBLL.limpiar();
                break;

            // ------------ Recuperar contraseña --------------
            case _BTN_ACEPTAR_RECU:

                LoginBLL _loginRecu = new LoginBLL();
                _loginRecu.RecuperarPassword();

                Singletons.conectado = true;

                Singletons.recu.dispose();
                new Controlador_Login(new Vtna_SignIN(), 0).iniciar(0);
                JPanel panLog = new JPanel();
                panLog.add(Singletons.login.panelLogin);
                Singletons.ini.internalFrame.setContentPane(panLog);
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_REGISTRO:
                new Controlador_Login(new Vtna_SignUP(), 1).iniciar(1);

                JPanel regis = new JPanel();
                regis.add(Singletons.alta.panelCrear);
                Singletons.ini.internalFrame.setContentPane(regis);
                Singletons.login.dispose();
                break;

            case _BTN_PASSW_OLVID:
                new Controlador_Login(new Vtna_Recuperar(), 2).iniciar(2);

                JPanel recu = new JPanel();
                recu.add(Singletons.recu.panelRecuperar);
                Singletons.ini.internalFrame.setContentPane(recu);
                Singletons.login.dispose();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_REGISTRO:
                new Controlador_Login(new Vtna_SignUP(), 1).iniciar(1);

                JPanel regis = new JPanel();
                regis.add(Singletons.alta.panelCrear);
                Singletons.ini.internalFrame.setContentPane(regis);
                Singletons.login.dispose();
                break;

            case _BTN_PASSW_OLVID:
                new Controlador_Login(new Vtna_Recuperar(), 2).iniciar(2);

                JPanel recu = new JPanel();
                recu.add(Singletons.recu.panelRecuperar);
                Singletons.ini.internalFrame.setContentPane(recu);
                Singletons.login.dispose();
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {
            case _BTN_ACEPTAR_login:
                Singletons.login.btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/entrar1.jpg")));
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _BTN_ACEPTAR_login:
                Singletons.login.btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/entrar2.jpg")));
                break;

            case _BTN_REGISTRO:
                Singletons.login.etiRegistro.setForeground(Color.blue);
                break;

            case _BTN_PASSW_OLVID:
                Singletons.login.etiPassword.setForeground(Color.blue);
                break;

        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_ACEPTAR_login:
                Singletons.login.btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal_josegramage/Img/iconos/entrar1.jpg")));
                break;

            case _BTN_REGISTRO:
                Singletons.login.etiRegistro.setForeground(Color.black);
                break;

            case _BTN_PASSW_OLVID:
                Singletons.login.etiPassword.setForeground(Color.black);
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {
            case _TXT_NOMBRE:
                LoginBLL.pideNombreKey();
                break;

            case _TXT_APELLIDOS:
                LoginBLL.pideApellidosKey();
                break;

            case _TXT_DNI:
                LoginBLL.pideDniKey();
                break;

            case _TXT_TELEFONO:
                LoginBLL.pideTelefonoKey();
                break;

            case _TXT_DIRECCION:
                LoginBLL.pideDireccionKey();
                break;

            case _TXT_EMAIL:
                LoginBLL.pideEmailKey();
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {
            case _TXT_NOMBRE:
                LoginBLL.pideNombreKey();
                break;

            case _TXT_APELLIDOS:
                LoginBLL.pideApellidosKey();
                break;

            case _TXT_DNI:
                LoginBLL.pideDniKey();
                break;

            case _TXT_TELEFONO:
                LoginBLL.pideTelefonoKey();
                break;

            case _TXT_DIRECCION:
                LoginBLL.pideDireccionKey();
                break;

            case _TXT_EMAIL:
                LoginBLL.pideEmailKey();
                break;
        }
    }
}
