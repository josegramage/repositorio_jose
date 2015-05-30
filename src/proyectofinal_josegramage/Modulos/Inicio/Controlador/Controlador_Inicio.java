/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Inicio.Controlador;

import java.awt.Color;
import proyectofinal_josegramage.Utiles.FileUploader;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import proyectofinal_josegramage.Librerias.FrasesCelebres;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_MiPerfil;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_panel_Inicio;
import proyectofinal_josegramage.Modulos.Juegos.Controlador.Controlador_Juegos;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Crear;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;
import proyectofinal_josegramage.Modulos.Menu.Controlador.Controlador_Menu;

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
            Singletons.iniPanel = (Vtna_panel_Inicio) inicio;
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

            Singletons.ini.setContentPane(Singletons.panel);
            Singletons.ini.panel_inicio.setOpaque(false);//para que deje mostrar la imagen de fondo
            Singletons.ini.add(Singletons.ini.panel_inicio);

            Singletons.ini.panelMenu.setOpaque(false);//para que deje mostrar la imagen de fondo
            //    Singletons.ini.add(Singletons.ini.panelMenu);
            Singletons.ini.panelLogin.setOpaque(false);//para que deje mostrar la imagen de fondo
            //     Singletons.ini.add(Singletons.ini.panelLogin);

            ((BasicInternalFrameUI) Singletons.ini.internalFrame.getUI()).setNorthPane(null);
            
            Singletons.ini.etiAdmin.setVisible(false);
            FrasesCelebres.ponerFrases();
            
            Image icono = Toolkit.getDefaultToolkit().getImage("src/proyectofinal_josegramage/Img/icono_bajo.jpg");
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

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            // ----------- Menu ------------------------  
            case _INICIO:

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

                    new Controlador_Cliente(new Vtna_cli_MiPerfil(), 3).iniciar(3);

                    JPanel panel_modifMP = new JPanel();
                    panel_modifMP.add(Singletons.cliMP.panelModif_MP);
                    Singletons.ini.internalFrame.setContentPane(panel_modifMP);
                    ClienteDAO.modificarLogeadoMP();

                    if (Singletons.cliLog.getAvatar().isEmpty()) {
                        FileUploader.leer_imag_defecto(4);
                    } else {
                        FileUploader.leer_imag(1);
                    }
                    
                } else {
                    new Controlador_Login(new Vtna_SignUP(), 1).iniciar(1);
                    JPanel p4 = new JPanel();
                    p4.add(Singletons.alta.panelCrear);
                    Singletons.ini.internalFrame.setContentPane(p4);
                }
                break;
                
                
            case _INICIO:
                new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);

                JPanel panel_Inicio = new JPanel();
                panel_Inicio.add(Singletons.iniPanel.panelInicio);
                Singletons.ini.internalFrame.setContentPane(panel_Inicio);
          
                break;

            case _PRODUCTOS:
                JOptionPane.showMessageDialog(null, "En construcción");
                break;

            case _JUEGOS:
                new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
               
                JPanel pJuegos = new JPanel();
                pJuegos.add(Singletons.juePager.panelPager);
                Singletons.ini.internalFrame.setContentPane(pJuegos);            
          /*      
                if (Singletons.conectado = false){
                      JOptionPane.showMessageDialog(null,"conectado false");
                      Singletons.juePager.btnAgregar.setVisible(false);
                      Singletons.juePager.btnCambiar.setVisible(false);
                      Singletons.juePager.btnEliminar.setVisible(false);
                      Singletons.juePager.btnMenu.setVisible(false);
                      Singletons.juePager.btnInfo.setVisible(false);
                      
                  }else {    
                      if (Singletons.cliLog.getTipo().equals("usuario")){
                      JOptionPane.showMessageDialog(null,"usuario");
                      Singletons.juePager.btnAgregar.setVisible(false);
                      Singletons.juePager.btnCambiar.setVisible(false);
                      Singletons.juePager.btnEliminar.setVisible(false);
                      Singletons.juePager.btnMenu.setVisible(false);
                      Singletons.juePager.btnInfo.setVisible(false);           
            }            
                }
                  */
                  
                break;

            case _HISTORIA:
                JOptionPane.showMessageDialog(null, "En construcción");
                break;

            case _NOSOTROS:
          JOptionPane.showMessageDialog(null, "En construcción");
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {
           
        }       
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
