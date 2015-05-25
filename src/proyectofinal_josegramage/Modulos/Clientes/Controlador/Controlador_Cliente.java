/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Controlador;

import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Clases.JDKP_Fondo;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Modulos.Clientes.Clases.SimpleTableModel_cliente;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.autocomplete.AutocompleteJComboBox;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.autocomplete.StringSearchable;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.pager.pagina;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Inicio.Controlador.Controlador_Admin;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Menu_Admin;
import proyectofinal_josegramage.Modulos.Login.Controlador.Controlador_Login;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import proyectofinal_josegramage.Main;
import proyectofinal_josegramage.Utiles.Menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;

/**
 *
 * @author Joso
 */
public class Controlador_Cliente implements ActionListener, KeyListener, MouseListener {

    private JDKP_Fondo fondo = new JDKP_Fondo();

    public enum Accion {

        // Ventana pager
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _COMBOX,
        _PANEL_FILTRAR,
        _TABLA_CLICK,
        _BTN_GUARDAR,
        _BTN_ABRIR,
        _BTN_AGREGAR,
        _BTN_CAMBIAR,
        _BTN_ELIMINAR,
        _BTN_INFO,
        _BTN_MENU,
        _BTN_PERFIL,
        _BTN_PERFIL_EDITAR,
        _BTN_PERFIL_SALIR,
        // Ventana crear
        _TXT_NOMBRE,
        _TXT_APELLIDOS,
        _TXT_DNI,
        _TXT_TELEFONO,
        _TXT_DIRECCION,
        _TXT_EMAIL,
        _TXT_FNACIMIENTO,
        _TXT_LOGIN,
        _TXT_PASSWORD,
        _BTN_CARGAR_IMG,
        _BTN_ACEPTAR,
        _BTN_CANCELAR,
        _BTN_NUEVO,
        _BTN_VOLVER,
        _COMBO_TIPO,
        // Ventana modificar
        _TXT_NOMBRE_M,
        _TXT_APELLIDOS_M,
        _TXT_TELEFONO_M,
        _TXT_DIRECCION_M,
        _TXT_EMAIL_M,
        _TXT_FNACIMIENTO_M,
        _TXT_LOGIN_M,
        _TXT_PASSWORD_M,
        _BTN_ACEPTAR_M,
        _BTN_CANCELAR_M,
        _BTN_VOLVER_M,
        _BTN_CARGAR_IMG_M,

    }

    public Controlador_Cliente(JFrame pager, int i) {

        if (i == 0) {
            Singletons.efPager = (Vtna_cli_Pager) pager;
        }

        if (i == 1) {
            Singletons.efCrear = (Vtna_cli_Crear) pager;
        }

        if (i == 2) {
            Singletons.efModif = (Vtna_cli_Modif) pager;
        }
    }

    public void iniciar(int i) {

        if (i == 0) {
            /*
             Singletons.efPager.setLocationRelativeTo(null);
             Singletons.efPager.setTitle("Empleados fijos");
             Singletons.efPager.setResizable(false);
             Container content = Singletons.efPager.getContentPane();
             content.setLayout(new BorderLayout());
             content.add(fondo, BorderLayout.CENTER);
             Singletons.efPager.setSize(850, 550);//método obligatorio
             Singletons.efPager.setLocation(2, 30);

             Singletons.efPager.pager.setOpaque(false);//para que deje mostrar la imagen de fondo
             Singletons.efPager.pager.setVisible(true);
             */
            Singletons.efPager.TABLA.setModel(new SimpleTableModel_cliente());
            ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
            Singletons.efPager.TABLA.setFillsViewportHeight(true);
            Singletons.efPager.TABLA.setRowSorter(Singletons.sorter);

            //         Image icono = Toolkit.getDefaultToolkit().getImage("src/Img/icono.png");
            //         Singletons.efPager.setIconImage(icono);
            pagina.inicializa();
            pagina.initLinkBox();

            ClienteBLL.abrirSilencioso();
            Singletons.efPager.etiFILTRAR.setText(String.valueOf(Singletons.client.size()));

            //          Singletons.efPager.addWindowListener(new WindowAdapter() {
            //              public void windowClosing(WindowEvent e) {
            //                  JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
            //                  System.exit(0);
            //              }
            //          });
            List<String> myWords = new ArrayList<String>();
            for (int x = 0; x <= Singletons.client.size() - 1; x++) {
                myWords.add(Singletons.client.get(x).getNombre());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            Singletons.combo = new AutocompleteJComboBox(searchable);
            Vtna_cli_Pager.panelFiltrar.setLayout(new java.awt.BorderLayout());
            Vtna_cli_Pager.panelFiltrar.add(Singletons.combo);

            Singletons.combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            //       Singletons.efPager.panelLoginPager.setOpaque(false);
            //       Singletons.efPager.etiUsuarioPager.setText(Singletons.cliLog.getLogin());
            //       FileUploader.leer_imag(2);
            Singletons.efPager.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
            Singletons.efPager.ANTERIOR.addActionListener(this);

            Singletons.efPager.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
            Singletons.efPager.SIGUIENTE.addActionListener(this);

            Singletons.efPager.ultimo.setActionCommand("_BTN_ULTIMO");
            Singletons.efPager.ultimo.addActionListener(this);

            Singletons.efPager.primero.setActionCommand("_BTN_PRIMERO");
            Singletons.efPager.primero.addActionListener(this);

            Singletons.efPager.jComboBox1.setActionCommand("_COMBOX");
            Singletons.efPager.jComboBox1.addActionListener(this);

            Singletons.efPager.panelFiltrar.setName("_PANEL_FILTRAR");
            Singletons.efPager.panelFiltrar.setActionCommand("_PANEL_FILTRAR");
            Singletons.efPager.panelFiltrar.addActionListener(this);
            Singletons.efPager.panelFiltrar.addKeyListener(this);

            Singletons.efPager.TABLA.setName("_TABLA_CLICK");
            Singletons.efPager.TABLA.addMouseListener(this);
            Singletons.efPager.TABLA.addKeyListener(this);

            Singletons.efPager.btnGuardar.setActionCommand("_BTN_GUARDAR");
            Singletons.efPager.btnGuardar.addActionListener(this);

            Singletons.efPager.btnAbrir.setActionCommand("_BTN_ABRIR");
            Singletons.efPager.btnAbrir.addActionListener(this);

            Singletons.efPager.btnAgregar.setActionCommand("_BTN_AGREGAR");
            Singletons.efPager.btnAgregar.setName("_BTN_AGREGAR");
            Singletons.efPager.btnAgregar.addActionListener(this);
            Singletons.efPager.btnAgregar.addMouseListener(this);

            Singletons.efPager.btnCambiar.setActionCommand("_BTN_CAMBIAR");
            Singletons.efPager.btnCambiar.setName("_BTN_CAMBIAR");
            Singletons.efPager.btnCambiar.addActionListener(this);
            Singletons.efPager.btnCambiar.addMouseListener(this);

            Singletons.efPager.btnEliminar.setActionCommand("_BTN_ELIMINAR");
            Singletons.efPager.btnEliminar.setName("_BTN_ELIMINAR");
            Singletons.efPager.btnEliminar.addActionListener(this);
            Singletons.efPager.btnEliminar.addMouseListener(this);

            Singletons.efPager.btnInfo.setActionCommand("_BTN_INFO");
            Singletons.efPager.btnInfo.setName("_BTN_INFO");
            Singletons.efPager.btnInfo.addActionListener(this);
            Singletons.efPager.btnInfo.addMouseListener(this);

            Singletons.efPager.btnMenu.setActionCommand("_BTN_MENU");
            Singletons.efPager.btnMenu.setName("_BTN_MENU");
            Singletons.efPager.btnMenu.addActionListener(this);
            Singletons.efPager.btnMenu.addMouseListener(this);

            Singletons.efPager.btnPerfilEditar.setActionCommand("_BTN_PERFIL_EDITAR");
            Singletons.efPager.btnPerfilEditar.setName("_BTN_PERFIL_EDITAR");
            Singletons.efPager.btnPerfilEditar.addActionListener(this);
            Singletons.efPager.btnPerfilEditar.addMouseListener(this);

            Singletons.efPager.btnPerfilSalir.setActionCommand("_BTN_PERFIL_SALIR");
            Singletons.efPager.btnPerfilSalir.setName("_BTN_PERFIL_SALIR");
            Singletons.efPager.btnPerfilSalir.addActionListener(this);
            Singletons.efPager.btnPerfilSalir.addMouseListener(this);

        }

        //     Crear empleado
        if (i == 1) {
            /*
             Singletons.efCrear.setVisible(true);
             Singletons.efCrear.setResizable(false);
             Singletons.efCrear.setLocation(2, 30);
             Singletons.efCrear.setSize(692, 435);

             Singletons.panel = new JPanel_Fondo();
             Singletons.efCrear.setContentPane(Singletons.panel);
             Singletons.efCrear.panelCrear.setOpaque(false);//para que deje mostrar la imagen de fondo
             Singletons.panel.add(Singletons.efCrear.panelCrear);

             Image icono = Toolkit.getDefaultToolkit().getImage("src/Img/icono.png");
             Singletons.efCrear.setIconImage(icono);

             Singletons.efCrear.addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
             JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
             System.exit(0);
             }
             });
             */

            ClienteDAO.ocultarErrores();
            FileUploader.leer_imag_defecto(0);

            Singletons.efCrear.txtNombre.setName("_TXT_NOMBRE");
            Singletons.efCrear.txtNombre.setActionCommand("_TXT_NOMBRE");
            Singletons.efCrear.txtNombre.addActionListener(this);
            Singletons.efCrear.txtNombre.addKeyListener(this);

            Singletons.efCrear.txtApellidos.setName("_TXT_APELLIDOS");
            Singletons.efCrear.txtApellidos.setActionCommand("_TXT_APELLIDOS");
            Singletons.efCrear.txtApellidos.addActionListener(this);
            Singletons.efCrear.txtApellidos.addKeyListener(this);

            Singletons.efCrear.txtDni.setName("_TXT_DNI");
            Singletons.efCrear.txtDni.setActionCommand("_TXT_DNI");
            Singletons.efCrear.txtDni.addActionListener(this);
            Singletons.efCrear.txtDni.addKeyListener(this);

            Singletons.efCrear.txtTelefono.setName("_TXT_TELEFONO");
            Singletons.efCrear.txtTelefono.setActionCommand("_TXT_TELEFONO");
            Singletons.efCrear.txtTelefono.addActionListener(this);
            Singletons.efCrear.txtTelefono.addKeyListener(this);

            Singletons.efCrear.txtDireccion.setName("_TXT_DIRECCION");
            Singletons.efCrear.txtDireccion.setActionCommand("_TXT_DIRECCION");
            Singletons.efCrear.txtDireccion.addActionListener(this);
            Singletons.efCrear.txtDireccion.addKeyListener(this);

            Singletons.efCrear.txtEmail.setName("_TXT_EMAIL");
            Singletons.efCrear.txtEmail.setActionCommand("_TXT_EMAIL");
            Singletons.efCrear.txtEmail.addActionListener(this);
            Singletons.efCrear.txtEmail.addKeyListener(this);

            Singletons.efCrear.btnCargarImg.setActionCommand("_BTN_CARGAR_IMG");
            Singletons.efCrear.btnCargarImg.addActionListener(this);

            Singletons.efCrear.btnAceptar.setActionCommand("_BTN_ACEPTAR");
            Singletons.efCrear.btnAceptar.addActionListener(this);

            Singletons.efCrear.btnCancelar.setActionCommand("_BTN_CANCELAR");
            Singletons.efCrear.btnCancelar.addActionListener(this);

            Singletons.efCrear.btnVolver.setActionCommand("_BTN_VOLVER");
            Singletons.efCrear.btnVolver.addActionListener(this);

            Singletons.efCrear.btnNuevo.setActionCommand("_BTN_NUEVO");
            Singletons.efCrear.btnNuevo.setName("_BTN_NUEVO");
            Singletons.efCrear.btnNuevo.addActionListener(this);
            Singletons.efCrear.btnNuevo.addMouseListener(this);

            Singletons.efCrear.comboTipo.setActionCommand("_COMBO_TIPO");

        }
        //     Modificar empleado
        if (i == 2) {

            if (Singletons.cliLog.getTipo().equals("usuario")) {
            Singletons.efModif.etiTipoM.setVisible(false);
            Singletons.efModif.comboTipoM.setVisible(false);
            }
           ClienteDAO.modificar(); 
        //    ClienteDAO.modificarLogeado();
            ClienteBLL.ocultaErrorM();
                       
            Singletons.efModif.txtNombreM.setName("_TXT_NOMBRE_M");
            Singletons.efModif.txtNombreM.setActionCommand("_TXT_NOMBRE_M");
            Singletons.efModif.txtNombreM.addActionListener(this);
            Singletons.efModif.txtNombreM.addKeyListener(this);

            Singletons.efModif.txtApellidosM.setName("_TXT_APELLIDOS_M");
            Singletons.efModif.txtApellidosM.setActionCommand("_TXT_APELLIDOS_M");
            Singletons.efModif.txtApellidosM.addActionListener(this);
            Singletons.efModif.txtApellidosM.addKeyListener(this);

            Singletons.efModif.txtTelefonoM.setName("_TXT_TELEFONO_M");
            Singletons.efModif.txtTelefonoM.setActionCommand("_TXT_TELEFONO_M");
            Singletons.efModif.txtTelefonoM.addActionListener(this);
            Singletons.efModif.txtTelefonoM.addKeyListener(this);

            Singletons.efModif.txtDireccionM.setName("_TXT_DIRECCION_M");
            Singletons.efModif.txtDireccionM.setActionCommand("_TXT_DIRECCION_M");
            Singletons.efModif.txtDireccionM.addActionListener(this);
            Singletons.efModif.txtDireccionM.addKeyListener(this);

            Singletons.efModif.txtEmailM.setName("_TXT_EMAIL_M");
            Singletons.efModif.txtEmailM.setActionCommand("_TXT_EMAIL_M");
            Singletons.efModif.txtEmailM.addActionListener(this);
            Singletons.efModif.txtEmailM.addKeyListener(this);

            Singletons.efModif.txtLoginM.setName("_TXT_LOGIN_M");
            Singletons.efModif.txtLoginM.setActionCommand("_TXT_LOGIN_M");
            Singletons.efModif.txtLoginM.addActionListener(this);
            Singletons.efModif.txtLoginM.addKeyListener(this);

            Singletons.efModif.txtPasswordM.setName("_TXT_PASSWORD_M");
            Singletons.efModif.txtPasswordM.setActionCommand("_TXT_PASSWORD_M");
            Singletons.efModif.txtPasswordM.addActionListener(this);
            Singletons.efModif.txtPasswordM.addKeyListener(this);

            Singletons.efModif.btnCambiarImgM.setActionCommand("_BTN_CARGAR_IMG_M");
            Singletons.efModif.btnCambiarImgM.addActionListener(this);

            Singletons.efModif.btnAceptarM.setActionCommand("_BTN_ACEPTAR_M");
            Singletons.efModif.btnAceptarM.addActionListener(this);

            Singletons.efModif.btnCancelarM.setActionCommand("_BTN_CANCELAR_M");
            Singletons.efModif.btnCancelarM.addActionListener(this);

            Singletons.efModif.btnVolverM.setActionCommand("_BTN_VOLVER_M");
            Singletons.efModif.btnVolverM.addActionListener(this);
        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) Singletons.combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((SimpleTableModel_cliente) Vtna_cli_Pager.TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            case _BTN_AGREGAR:
                Singletons.efPager.dispose();
                new Controlador_Cliente(new Vtna_cli_Crear(), 1).iniciar(1);
                JPanel panel_crear = new JPanel();
                panel_crear.add(Singletons.efCrear.panelCrear);
                Singletons.ini.internalFrame.setContentPane(panel_crear);
                break;

            case _BTN_CAMBIAR:
                int inicio,
                 selection,
                 selection1;

                int n = ((SimpleTableModel_cliente) Vtna_cli_Pager.TABLA.getModel()).getRowCount();
                if (n != 0) {
                    inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                    selection = Vtna_cli_Pager.TABLA.getSelectedRow();
                    selection1 = inicio + selection;
                    if (Singletons.cli != null) {
                        Singletons.efPager.dispose();
                        new Controlador_Cliente(new Vtna_cli_Modif(), 2).iniciar(2);
                        JPanel panel_modif = new JPanel();
                        panel_modif.add(Singletons.efModif.panelModif);
                        Singletons.ini.internalFrame.setContentPane(panel_modif);
                        ClienteDAO.modificar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                    }
                }
                break;

            case _BTN_ELIMINAR:
                ClienteBLL.btnEliminarPager();
                break;

            case _BTN_INFO:
                if (Singletons.cli != null) {
                    ClienteBLL.InfoPager();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                }
                break;

            case _BTN_MENU:
                Singletons.efPager.dispose();
                new Controlador_Admin(new Vtna_Menu_Admin(), 0).iniciar(0);
                break;

            case _BTN_GUARDAR:
                Main.conf.setGuardar(Menus.menuFormatoGuardar());
                ClienteBLL.guardar();
                break;

            case _BTN_ABRIR:
                ClienteBLL.abrir();
                break;

            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;

            case _BTN_SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;

            case _BTN_PRIMERO:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _COMBOX:
                pagina.itemsPerPage = Integer.parseInt(Singletons.efPager.jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            /*        // MI PERFIL
             case _BTN_PERFIL_EDITAR:

             if (Singletons.conectado == true) {
             ClienteBLL_bd emp = new ClienteBLL_bd();
             emp.listarEmpFijoBLL();
             Singletons.efPager.dispose();

             new Controlador_Cliente(new Vtna_cli_Modif(), 2).iniciar(2);
             ClienteDAO.modificarLogeado();
             }
             break;

             case _BTN_PERFIL_SALIR:
             Singletons.conectado = false;
             Singletons.efPager.dispose();
             Singletons.login.setVisible(true);
             //  new Controlador_Login(new Vtna_SignIN(),0).iniciar(0);
             break;
             */
            // ------- CREAR EMPLEADO -------------------               
            case _TXT_NOMBRE:
                ClienteBLL.pideNombre();
                break;

            case _TXT_APELLIDOS:
                ClienteBLL.pideApellidos();
                break;

            case _TXT_DNI:
                ClienteBLL.pideDni();
                break;

            case _TXT_TELEFONO:
                ClienteBLL.pideTelefono();
                break;

            case _TXT_EMAIL:
                ClienteBLL.pideEmail();
                break;
                
            case _TXT_LOGIN:
                ClienteBLL.pideLogin();
                break;
                
            case _TXT_PASSWORD:
                ClienteBLL.pidePassword();
                break;

            case _BTN_CARGAR_IMG:
                FileUploader.pintar_guardar_img(Singletons.efCrear.etiAvatar, 90, 90, 0);
                break;

            case _BTN_ACEPTAR:
                ClienteBLL.crearCliente();
                break;

            case _BTN_CANCELAR:
                ClienteBLL.limpiar();
                break;

            case _BTN_VOLVER:
                new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                Singletons.efCrear.dispose();
                JPanel panelPager = new JPanel();
                panelPager.add(Singletons.efPager.panelPager);
                Singletons.ini.internalFrame.setContentPane(panelPager);
                break;

            case _COMBO_TIPO:

                break;

            // ------- MODIFICAR EMPLEADO -------------------            
            case _TXT_NOMBRE_M:
                ClienteBLL.pideNombreM();
                break;

            case _TXT_APELLIDOS_M:
                ClienteBLL.pideApellidosM();
                break;

            case _TXT_TELEFONO_M:
                ClienteBLL.pideTelefonoM();
                break;

            case _TXT_DIRECCION_M:
                ClienteBLL.pideDireccionM();
                break;

            case _TXT_EMAIL_M:
                ClienteBLL.pideEmailM();
                break;

            case _BTN_ACEPTAR_M:

                ClienteBLL.ModificarPager();
                //FileUploader.leer_imag(0);
               // Singletons.cliLog.setAvatar(null);
               
                if (Singletons.cliLog.getTipo().equals("admin")) {
                    new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                Singletons.efModif.dispose();
                JPanel panelPagerM = new JPanel();
                panelPagerM.add(Singletons.efPager.panelPager);
                Singletons.ini.internalFrame.setContentPane(panelPagerM);

                ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
                } else if (Singletons.cliLog.getTipo().equals("usuario")) {
                
                }
                
                break;

            case _BTN_CANCELAR_M:

                ClienteBLL.ocultaErrorM();
                break;

            case _TXT_LOGIN_M:
                ClienteBLL.pideLoginM();
                break;

            case _TXT_PASSWORD_M:
                ClienteBLL.pidePasswordM();
                break;

            case _BTN_VOLVER_M:
                new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                Singletons.efModif.dispose();
                JPanel p4 = new JPanel();
                p4.add(Singletons.efPager.panelPager);
                Singletons.ini.internalFrame.setContentPane(p4);
                
             

                break;

            case _BTN_CARGAR_IMG_M:
                FileUploader.pintar_guardar_img(Singletons.efModif.etiAvatarM, 90, 90,1);

                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _PANEL_FILTRAR:
                pagina.currentPageIndex = 1;
                ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).filtrar();
                break;

            // ----------  Crear Empleado  --------------
            case _TXT_NOMBRE:
                ClienteBLL.pideNombreKey();
                break;

            case _TXT_APELLIDOS:
                ClienteBLL.pideApellidosKey();
                break;

            case _TXT_DNI:
                ClienteBLL.pideDniKey();
                break;

            case _TXT_TELEFONO:
                ClienteBLL.pideTelefonoKey();
                break;
                
            case _TXT_DIRECCION:
                ClienteBLL.pideDireccionKey();

            case _TXT_EMAIL:
                ClienteBLL.pideEmailKey();
                break;

            // ------------  Modificar Empleado --------------     
            case _TXT_NOMBRE_M:
                ClienteBLL.pideNombreKeyM();
                break;

            case _TXT_APELLIDOS_M:
                ClienteBLL.pideApellidosKeyM();
                break;

            case _TXT_TELEFONO_M:
                ClienteBLL.pideTelefonoKeyM();
                break;

            case _TXT_EMAIL_M:
                ClienteBLL.pideEmailKeyM();
                break;

            case _TXT_DIRECCION_M:
                ClienteBLL.pideDireccionKeyM();
                break;

            case _TXT_PASSWORD_M:
                ClienteBLL.pidePasswordKeyM();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _PANEL_FILTRAR:
                pagina.currentPageIndex = 1;
                ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).filtrar();
                break;

            // ----------  Crear Empleado  --------------
            case _TXT_NOMBRE:
                ClienteBLL.pideNombreKey();
                break;

            case _TXT_APELLIDOS:
                ClienteBLL.pideApellidosKey();
                break;

            case _TXT_DNI:
                ClienteBLL.pideDniKey();
                break;

            case _TXT_TELEFONO:
                ClienteBLL.pideTelefonoKey();
                break;

            case _TXT_DIRECCION:
                ClienteBLL.pideDireccionKey();
                break;

            case _TXT_EMAIL:
                ClienteBLL.pideEmailKey();
                break;

            // ------------  Modificar Empleado --------------     
            case _TXT_NOMBRE_M:
                ClienteBLL.pideNombreKeyM();
                break;

            case _TXT_APELLIDOS_M:
                ClienteBLL.pideApellidosKeyM();
                break;

            case _TXT_TELEFONO_M:
                ClienteBLL.pideTelefonoKeyM();
                break;

            case _TXT_EMAIL_M:
                ClienteBLL.pideEmailKeyM();
                break;

            case _TXT_DIRECCION_M:
                ClienteBLL.pideDireccionKeyM();
                break;

            case _TXT_PASSWORD_M:
                ClienteBLL.pidePasswordKeyM();
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            case _TABLA_CLICK:
                try {
                    Singletons.cli = new Cliente(Vtna_cli_Pager.TABLA.getValueAt(Vtna_cli_Pager.TABLA.getSelectedRow(), 0).toString());
                    ClienteBLL_bd.buscarDniBLL();
                    //    Singletons.pos = ClienteBLL.buscar(Singletons.emp);
                    //    Singletons.emp = Singletons.efi.get(Singletons.pos);
                } catch (Exception e) {
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            /*       case _BTN_AGREGAR:
             Singletons.efPager.btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar2.png")));
             break;

             case _BTN_CAMBIAR:
             Singletons.efPager.btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cambiar2.png")));
             break;

             case _BTN_ELIMINAR:
             Singletons.efPager.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png")));
             break;

             case _BTN_INFO:
             Singletons.efPager.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/info2.png")));
             break;

             case _BTN_MENU:
             Singletons.efPager.btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu2.png")));
             break;
             */
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            /*            case _BTN_AGREGAR:
             Singletons.efPager.btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar1.png")));
             break;

             case _BTN_CAMBIAR:
             Singletons.efPager.btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cambiar1.png")));
             break;

             case _BTN_ELIMINAR:
             Singletons.efPager.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar1.png")));
             break;

             case _BTN_INFO:
             Singletons.efPager.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/info1.png")));
             break;

             case _BTN_MENU:
             Singletons.efPager.btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu1.png")));
             break;
             */
        }
    }

}
