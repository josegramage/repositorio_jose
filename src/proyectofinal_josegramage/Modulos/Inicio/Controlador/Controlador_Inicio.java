/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Inicio.Controlador;

import java.awt.Color;
import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Controlador.Controlador_Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Config;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Menu_Admin;
import proyectofinal_josegramage.Modulos.Login.Controlador.Controlador_Login;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import proyectofinal_josegramage.Main;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;

/**
 *
 * @author Joso
 */
public class Controlador_Inicio implements ActionListener, MouseListener {

    public enum Accion {

        // panel Menu
        _INICIO,
        _PRODUCTOS,
        _JUEGOS,
        _HISTORIA,
        _NOSOTROS,
        // panel Login
        _BTN_ENTRAR_USUARIO,
        _BTN_REG_PERFIL,

    }

    public Controlador_Inicio(JFrame inicio, int i) {

        if (i == 0) {
            Singletons.ini = (Vtna_Inicio) inicio;
        }

        if (i == 1) {
            Singletons.config = (Vtna_Config) inicio;
        }

        if (i == 2) {
            Singletons.efPager = (Vtna_cli_Pager) inicio;
            new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
        }

        if (i == 3) {

        }

        if (i == 4) {
            new Controlador_Login(new Vtna_SignIN(), 0).iniciar(0);
        }

    }

    public void iniciar(int i) {

        if (i == 0) {   //  vtna_menu

            Singletons.panel = new JPanel_Fondo();
            Singletons.ini.setVisible(true);
            Singletons.ini.setResizable(false);
            Singletons.ini.setTitle("Mundo Virtual");
            Singletons.ini.setLocationRelativeTo(null);
            //       Singletons.ini.setLocation(2, 30);
            //     Singletons.ini.setSize(692, 435);

            Singletons.ini.setContentPane(Singletons.panel);
            Singletons.ini.panel_inicio.setOpaque(false);//para que deje mostrar la imagen de fondo
            Singletons.ini.add(Singletons.ini.panel_inicio);

            Singletons.ini.panelMenu.setOpaque(false);//para que deje mostrar la imagen de fondo
            //    Singletons.ini.add(Singletons.ini.panelMenu);
            Singletons.ini.panelLogin.setOpaque(false);//para que deje mostrar la imagen de fondo
            //     Singletons.ini.add(Singletons.ini.panelLogin);

            ((BasicInternalFrameUI) Singletons.ini.internalFrame.getUI()).setNorthPane(null);

            Image icono = Toolkit.getDefaultToolkit().getImage("src/Img/icono.png");
            Singletons.ini.setIconImage(icono);

            Singletons.ini.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });

            if (Singletons.conectado == true) {
                Singletons.ini.eti_Entrar_Usuario.setText(Singletons.cliLog.getLogin());
                Singletons.ini.eti_Reg_Perfil.setText("Mi perfil");
                FileUploader.leer_imag(0);

            } else {
                Singletons.ini.eti_Entrar_Usuario.setText("Entrar");
                Singletons.ini.eti_Reg_Perfil.setText("Regístrate");
            }

            Singletons.ini.etiInicio.setName("_INICIO");
            Singletons.ini.etiInicio.addMouseListener(this);
            Singletons.ini.etiInicio.setForeground(Color.black);

            Singletons.ini.etiProductos.setName("_PRODUCTOS");
            Singletons.ini.etiProductos.addMouseListener(this);
            Singletons.ini.etiProductos.setForeground(Color.black);

            Singletons.ini.etiJuegos.setName("_JUEGOS");
            Singletons.ini.etiJuegos.addMouseListener(this);
            Singletons.ini.etiJuegos.setForeground(Color.black);

            Singletons.ini.etiHistoria.setName("_HISTORIA");
            Singletons.ini.etiHistoria.addMouseListener(this);
            Singletons.ini.etiHistoria.setForeground(Color.black);

            Singletons.ini.etiNosotros.setName("_NOSOTROS");
            Singletons.ini.etiNosotros.addMouseListener(this);
            Singletons.ini.etiNosotros.setForeground(Color.black);

            Singletons.ini.eti_Entrar_Usuario.setName("_BTN_ENTRAR_USUARIO");
            Singletons.ini.eti_Entrar_Usuario.addMouseListener(this);
            Singletons.ini.eti_Entrar_Usuario.setForeground(Color.black);

            Singletons.ini.eti_Reg_Perfil.setName("_BTN_REG_PERFIL");
            Singletons.ini.eti_Reg_Perfil.addMouseListener(this);
            Singletons.ini.eti_Reg_Perfil.setForeground(Color.black);

        }

        if (i == 1) {     // Ventana configuracion

            Singletons.config.setVisible(true);
            Singletons.config.setResizable(false);
            Singletons.config.setLocation(2, 30);
            Singletons.config.setSize(692, 435);

            Singletons.panel = new JPanel_Fondo();
            Singletons.config.setContentPane(Singletons.panel);
            Singletons.config.panelConfig.setOpaque(false);//para que deje mostrar la imagen de fondo
            Singletons.panel.add(Singletons.config.panelConfig);

            Image icono = Toolkit.getDefaultToolkit().getImage("src/Img/icono.png");
            Singletons.config.setIconImage(icono);

            Singletons.config.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });
            Singletons.config.btnVolverC.setActionCommand("_BTN_VOLVER");
            Singletons.config.btnVolverC.addActionListener(this);

            Singletons.config.euro.setActionCommand("_moneda_euro");
            Singletons.config.euro.addActionListener(this);

            Singletons.config.dolar.setActionCommand("_moneda_dolar");
            Singletons.config.dolar.addActionListener(this);

            Singletons.config.libra.setActionCommand("_moneda_libra");
            Singletons.config.libra.addActionListener(this);

            Singletons.config.yen.setActionCommand("_moneda_yen");
            Singletons.config.yen.addActionListener(this);

            Singletons.config.apariencia1.setActionCommand("_apariencia1");
            Singletons.config.apariencia1.addActionListener(this);

            Singletons.config.apariencia2.setActionCommand("_apariencia2");
            Singletons.config.apariencia2.addActionListener(this);

            Singletons.config.apariencia3.setActionCommand("_apariencia3");
            Singletons.config.apariencia3.addActionListener(this);

            Singletons.config.fecha1.setActionCommand("_fecha1");
            Singletons.config.fecha1.addActionListener(this);

            Singletons.config.fecha2.setActionCommand("_fecha2");
            Singletons.config.fecha2.addActionListener(this);

            Singletons.config.fecha3.setActionCommand("_fecha3");
            Singletons.config.fecha3.addActionListener(this);

            Singletons.config.fecha4.setActionCommand("_fecha4");
            Singletons.config.fecha4.addActionListener(this);

            Singletons.config.fecha5.setActionCommand("_fecha5");
            Singletons.config.fecha5.addActionListener(this);

            Singletons.config.fecha6.setActionCommand("_fecha6");
            Singletons.config.fecha6.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            // ----------- Menu ------------------------  
            case _INICIO:
                new Controlador_Inicio(new Vtna_cli_Pager(), 2).iniciar(0);
                Singletons.efPager.setVisible(true);
                Singletons.menu.dispose();
                break;

            case _PRODUCTOS:

                break;

            case _JUEGOS:

                break;

            case _HISTORIA:

                break;

            case _NOSOTROS:

                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_ENTRAR_USUARIO:

                if (Singletons.conectado == true) {

                } else {
                    new Controlador_Login(new Vtna_SignIN(), 0).iniciar(0);

                    JPanel p4 = new JPanel();
                    p4.add(Singletons.login.panelLogin);
                    Singletons.ini.internalFrame.setContentPane(p4);
                }
                break;

            case _BTN_REG_PERFIL:

                if (Singletons.conectado == true) {

                    ClienteBLL_bd cli = new ClienteBLL_bd();
                    cli.listarClienteBLL();

                    new Controlador_Cliente(new Vtna_cli_Modif(), 2).iniciar(2);

                    JPanel panel_modif = new JPanel();
                    panel_modif.add(Singletons.efModif.panelModif);
                    Singletons.ini.internalFrame.setContentPane(panel_modif);
                    ClienteDAO.modificarLogeado();

                } else {
                    new Controlador_Login(new Vtna_SignUP(), 1).iniciar(1);

                    JPanel p4 = new JPanel();
                    p4.add(Singletons.alta.panelCrear);
                    Singletons.ini.internalFrame.setContentPane(p4);
                }
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {
            /*
             case _BTN_CONFIG:
             Singletons.menu.btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config1.png")));
             break;

             case _BTN_EMPFIJO:
             Singletons.menu.btnEmpFijo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/empfijo1.png")));
             break;

             case _BTN_REGISTRO:
             break;
             */
        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _INICIO:
                Singletons.ini.etiInicio.setForeground(Color.blue);
                break;

            case _PRODUCTOS:
                Singletons.ini.etiProductos.setForeground(Color.blue);
                break;

            case _JUEGOS:
                Singletons.ini.etiJuegos.setForeground(Color.blue);
                break;

            case _HISTORIA:
                Singletons.ini.etiHistoria.setForeground(Color.blue);
                break;

            case _NOSOTROS:
                Singletons.ini.etiNosotros.setForeground(Color.blue);
                break;

            case _BTN_ENTRAR_USUARIO:
                Singletons.ini.eti_Entrar_Usuario.setForeground(Color.blue);
                break;

            case _BTN_REG_PERFIL:
                Singletons.ini.eti_Reg_Perfil.setForeground(Color.blue);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            case _INICIO:
                Singletons.ini.etiInicio.setForeground(Color.black);
                break;

            case _PRODUCTOS:
                Singletons.ini.etiProductos.setForeground(Color.black);
                break;

            case _JUEGOS:
                Singletons.ini.etiJuegos.setForeground(Color.black);
                break;

            case _HISTORIA:
                Singletons.ini.etiHistoria.setForeground(Color.black);
                break;

            case _NOSOTROS:
                Singletons.ini.etiNosotros.setForeground(Color.black);
                break;

            case _BTN_ENTRAR_USUARIO:
                Singletons.ini.eti_Entrar_Usuario.setForeground(Color.black);
                break;

            case _BTN_REG_PERFIL:
                Singletons.ini.eti_Reg_Perfil.setForeground(Color.black);
                break;
        }
    }

}
