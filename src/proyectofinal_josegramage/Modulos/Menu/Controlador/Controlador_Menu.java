/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Menu.Controlador;

import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Controlador.Controlador_Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Config;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Menu_Admin;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Joso
 */
public class Controlador_Menu implements ActionListener, MouseListener {

    public enum Accion {

        // menu
        _BTN_CLIENTES,
        _BTN_CONFIG,
        _BTN_PRODUCTOS,
        _BTN_JUEGOS,
        _BTN_ESTADISTICA,
        // configuracion
        _BTN_VOLVER,
        _moneda_euro,
        _moneda_dolar,
        _moneda_libra,
        _moneda_yen,
        _fecha1,
        _fecha2,
        _fecha3,
        _fecha4,
        _fecha5,
        _fecha6,
        _apariencia1,
        _apariencia2,
        _apariencia3,

    }

    public Controlador_Menu(JFrame menu, int i) {

        if (i == 0) {
            Singletons.menu = (Vtna_Menu_Admin) menu;
        }

        if (i == 1) {
            Singletons.config = (Vtna_Config) menu;
        }

        if (i == 2) {
            Singletons.efPager = (Vtna_cli_Pager) menu;
            new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
        }

        if (i == 3) {

        }

        if (i == 4) {
      //     Singletons.login = (Vtna_SignIN) menu;
            //     new Controlador_Login(new Vtna_SignIN(),0).iniciar(0);
        }

    }

    public void iniciar(int i) {

        if (i == 0) {   //  vtna_menu

            Singletons.menu.btnClientesA.setActionCommand("_BTN_CLIENTES");
            Singletons.menu.btnClientesA.setName("_BTN_CLIENTES");
            Singletons.menu.btnClientesA.addActionListener(this);
            Singletons.menu.btnClientesA.addMouseListener(this);

            Singletons.menu.btnProductosA.setActionCommand("_BTN_PRODUCTOS");
            Singletons.menu.btnProductosA.setName("_BTN_PRODUCTOS");
            Singletons.menu.btnProductosA.addActionListener(this);
            Singletons.menu.btnProductosA.addMouseListener(this);

            Singletons.menu.btnJuegosA.setActionCommand("_BTN_JUEGOS");
            Singletons.menu.btnJuegosA.setName("_BTN_JUEGOS");
            Singletons.menu.btnJuegosA.addActionListener(this);
            Singletons.menu.btnJuegosA.addMouseListener(this);

            Singletons.menu.btnEstadA.setActionCommand("_BTN_ESTADISTICA");
            Singletons.menu.btnEstadA.setName("_BTN_ESTADISTICA");
            Singletons.menu.btnEstadA.addActionListener(this);
            Singletons.menu.btnEstadA.addMouseListener(this);

            Singletons.menu.btnConfigA.setActionCommand("_BTN_CONFIG");
            Singletons.menu.btnConfigA.setName("_BTN_CONFIG");
            Singletons.menu.btnConfigA.addActionListener(this);
            Singletons.menu.btnConfigA.addMouseListener(this);

        }

        if (i == 1) {     // Ventana configuracion

            Singletons.panel = new JPanel_Fondo();
            Singletons.config.setContentPane(Singletons.panel);
            Singletons.config.panelConfig.setOpaque(false);//para que deje mostrar la imagen de fondo
            Singletons.panel.add(Singletons.config.panelConfig);

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
            case _BTN_CLIENTES:
                new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                Singletons.menu.dispose();
                JPanel p4 = new JPanel();
                p4.add(Singletons.efPager.panelPager);
                Singletons.ini.internalFrame.setContentPane(p4);
                break;

            case _BTN_CONFIG:
                new Controlador_Menu(new Vtna_Config(), 1).iniciar(1);
                Singletons.menu.dispose();
                JPanel pConfig = new JPanel();
                pConfig.add(Singletons.config.panelConfig);
                Singletons.ini.internalFrame.setContentPane(pConfig);
                break;

            case _BTN_JUEGOS:
                JOptionPane.showMessageDialog(null, "En construcción");
                break;

            case _BTN_PRODUCTOS:
                JOptionPane.showMessageDialog(null, "En construcción");
                break;

            case _BTN_ESTADISTICA:
                JOptionPane.showMessageDialog(null, "En construcción");
                break;

            // ----------- Configuracion ----------------            
            case _BTN_VOLVER:
                new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
                Singletons.config.dispose();
                break;

            case _moneda_euro:
                Main.conf.setMoneda('€');
                break;

            case _moneda_dolar:
                Main.conf.setMoneda('$');
                break;

            case _moneda_libra:
                Main.conf.setMoneda('£');
                break;

            case _moneda_yen:
                Main.conf.setMoneda('¥');
                break;

            case _apariencia1:
                //         Ppal_Main.conf.setApariencia("0");
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _apariencia2:
                //       Ppal_Main.conf.setApariencia("1");  

                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _apariencia3:
                //      Ppal_Main.conf.setApariencia("2"); 

                try {
                    UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
                    for (UIManager.LookAndFeelInfo laf : lafs) {
                        if ("Nimbus".equals(laf.getName())) {
                            UIManager.setLookAndFeel(laf.getClassName());
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _fecha1:
                Main.conf.setFormatoFecha("1");
                break;

            case _fecha2:
                Main.conf.setFormatoFecha("2");
                break;

            case _fecha3:
                Main.conf.setFormatoFecha("3");
                break;

            case _fecha4:
                Main.conf.setFormatoFecha("4");
                break;

            case _fecha5:
                Main.conf.setFormatoFecha("5");
                break;

            case _fecha6:
                Main.conf.setFormatoFecha("6");
                break;

            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _BTN_CONFIG:
                //         Singletons.menu.btnConfigA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config1.png")));
                break;

            case _BTN_CLIENTES:
                //           Singletons.menu.btnClientesA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/empfijo1.png")));
                break;

        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _BTN_CONFIG:
                //              Singletons.menu.btnConfigA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config2.png")));
                break;

            case _BTN_CLIENTES:
                //              Singletons.menu.btnClientesA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/empfijo2.png")));
                break;

        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CONFIG:
                //           Singletons.menu.btnConfigA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config1.png")));
                break;

            case _BTN_CLIENTES:
                //           Singletons.menu.btnClientesA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/empfijo1.png")));
                break;

        }
    }

}
