/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Controlador;

import proyectofinal_josegramage.Utiles.FileUploader;
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
import proyectofinal_josegramage.Modulos.Menu.Controlador.Controlador_Menu;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Menu_Admin;
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
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_MiPerfil;
import proyectofinal_josegramage.Modulos.Inicio.Controlador.Controlador_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_panel_Inicio;
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
        // Ventana modificar Mi Perfil
        _TXT_NOMBRE_MP,
        _TXT_APELLIDOS_MP,
        _TXT_TELEFONO_MP,
        _TXT_DIRECCION_MP,
        _TXT_EMAIL_MP,
        _TXT_FNACIMIENTO_MP,
        _TXT_LOGIN_MP,
        _TXT_PASSWORD_MP,
        _BTN_ACEPTAR_MP,
        _BTN_SALIR_MP,
        _BTN_VOLVER_MP,
        _BTN_CARGAR_IMG_MP,
        _BTN_ELIMINAR_MP,
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

        if (i == 3) {
            Singletons.cliMP = (Vtna_cli_MiPerfil) pager;
        }

    }

    public void iniciar(int i) {

        if (i == 0) {

            Singletons.efPager.TABLA.setModel(new SimpleTableModel_cliente());
            ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
            Singletons.efPager.TABLA.setFillsViewportHeight(true);
            Singletons.efPager.TABLA.setRowSorter(Singletons.sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            Singletons.efPager.etiFILTRAR.setText(String.valueOf(Singletons.client.size()));

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

            Singletons.efCrear.txtLogin.setName("_TXT_LOGIN");
            Singletons.efCrear.txtLogin.setActionCommand("_TXT_LOGIN");
            Singletons.efCrear.txtLogin.addActionListener(this);
            Singletons.efCrear.txtLogin.addKeyListener(this);

            Singletons.efCrear.txtPassword.setName("_TXT_PASSWORD");
            Singletons.efCrear.txtPassword.setActionCommand("_TXT_PASSWORD");
            Singletons.efCrear.txtPassword.addActionListener(this);
            Singletons.efCrear.txtPassword.addKeyListener(this);

            Singletons.efCrear.btnCargarImg.setActionCommand("_BTN_CARGAR_IMG");
            Singletons.efCrear.btnCargarImg.addActionListener(this);

            Singletons.efCrear.btnAceptar.setActionCommand("_BTN_ACEPTAR");
            Singletons.efCrear.btnAceptar.addActionListener(this);

            Singletons.efCrear.btnCancelar.setActionCommand("_BTN_CANCELAR");
            Singletons.efCrear.btnCancelar.addActionListener(this);

            Singletons.efCrear.btnVolver.setActionCommand("_BTN_VOLVER");
            Singletons.efCrear.btnVolver.addActionListener(this);

            Singletons.efCrear.comboTipo.setActionCommand("_COMBO_TIPO");

        }
        //     Modificar empleado PAGER
        if (i == 2) {

            if (Singletons.cliLog.getTipo().equals("usuario")) {
                Singletons.efModif.etiTipoM.setVisible(false);
                Singletons.efModif.comboTipoM.setVisible(false);

            }

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

            Singletons.efModif.btnVolverM.setActionCommand("_BTN_VOLVER_M");
            Singletons.efModif.btnVolverM.addActionListener(this);
        }

        //     Modificar empleado MI PERFIL
        if (i == 3) {

            if (Singletons.cliLog.getTipo().equals("usuario")) {
                Singletons.cliMP.etiTipoM.setVisible(false);
                Singletons.cliMP.comboTipoMP.setVisible(false);
            }

            ClienteBLL.ocultaErrorMP();
            Singletons.cliMP.errorPasswordM.setVisible(true);

            Singletons.cliMP.txtNombreMP.setName("_TXT_NOMBRE_MP");
            Singletons.cliMP.txtNombreMP.setActionCommand("_TXT_NOMBRE_MP");
            Singletons.cliMP.txtNombreMP.addActionListener(this);
            Singletons.cliMP.txtNombreMP.addKeyListener(this);

            Singletons.cliMP.txtApellidosMP.setName("_TXT_APELLIDOS_MP");
            Singletons.cliMP.txtApellidosMP.setActionCommand("_TXT_APELLIDOS_MP");
            Singletons.cliMP.txtApellidosMP.addActionListener(this);
            Singletons.cliMP.txtApellidosMP.addKeyListener(this);

            Singletons.cliMP.txtTelefonoMP.setName("_TXT_TELEFONO_MP");
            Singletons.cliMP.txtTelefonoMP.setActionCommand("_TXT_TELEFONO_MP");
            Singletons.cliMP.txtTelefonoMP.addActionListener(this);
            Singletons.cliMP.txtTelefonoMP.addKeyListener(this);

            Singletons.cliMP.txtDireccionMP.setName("_TXT_DIRECCION_MP");
            Singletons.cliMP.txtDireccionMP.setActionCommand("_TXT_DIRECCION_MP");
            Singletons.cliMP.txtDireccionMP.addActionListener(this);
            Singletons.cliMP.txtDireccionMP.addKeyListener(this);

            Singletons.cliMP.txtEmailMP.setName("_TXT_EMAIL_MP");
            Singletons.cliMP.txtEmailMP.setActionCommand("_TXT_EMAIL_MP");
            Singletons.cliMP.txtEmailMP.addActionListener(this);
            Singletons.cliMP.txtEmailMP.addKeyListener(this);

            Singletons.cliMP.txtLoginMP.setName("_TXT_LOGIN_MP");
            Singletons.cliMP.txtLoginMP.setActionCommand("_TXT_LOGIN_MP");
            Singletons.cliMP.txtLoginMP.addActionListener(this);
            Singletons.cliMP.txtLoginMP.addKeyListener(this);

            Singletons.cliMP.txtPasswordMP.setName("_TXT_PASSWORD_MP");
            Singletons.cliMP.txtPasswordMP.setActionCommand("_TXT_PASSWORD_MP");
            Singletons.cliMP.txtPasswordMP.addActionListener(this);
            Singletons.cliMP.txtPasswordMP.addKeyListener(this);

            Singletons.cliMP.btnCambiarImgM.setActionCommand("_BTN_CARGAR_IMG_MP");
            Singletons.cliMP.btnCambiarImgM.addActionListener(this);

            Singletons.cliMP.btnAceptarM.setActionCommand("_BTN_ACEPTAR_MP");
            Singletons.cliMP.btnAceptarM.addActionListener(this);

            Singletons.cliMP.btnSalir_MP.setActionCommand("_BTN_SALIR_MP");
            Singletons.cliMP.btnSalir_MP.addActionListener(this);

            Singletons.cliMP.btnEliminar_MP.setActionCommand("_BTN_ELIMINAR_MP");
            Singletons.cliMP.btnEliminar_MP.addActionListener(this);

            Singletons.cliMP.btnVolverM.setActionCommand("_BTN_VOLVER_MP");
            Singletons.cliMP.btnVolverM.addActionListener(this);
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

                if (Singletons.cliLog.getDni().equals(Singletons.cli.getDni())) {
                    JOptionPane.showMessageDialog(null, "Cambia tus datos en Mi Perfil");

                } else {

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

                            if (Singletons.cli.getAvatar().isEmpty()) {
                                FileUploader.leer_imag_defecto(3);
                            } else {
                                FileUploader.leer_imag(2);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                        }
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
                new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
                Singletons.efPager.dispose();
                JPanel p4 = new JPanel();
                p4.add(Singletons.menu.panelMenu);
                Singletons.ini.internalFrame.setContentPane(p4);
                break;

            case _BTN_GUARDAR:
                Main.conf.setGuardar(Menus.menuFormatoGuardar());
                ClienteBLL.guardar();
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

            // ------- CREAR CLIENTE -------------------               
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

            // ------- MODIFICAR CLIENTE PAGER -------------------            
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
                ClienteBLL.ModificarPagerAdmin();
                break;

            case _TXT_LOGIN_M:
                ClienteBLL.pideLoginM();
                break;

            case _TXT_PASSWORD_M:
                ClienteBLL.pidePasswordM();
                break;

            case _BTN_VOLVER_M:
                if (Singletons.cliLog.getTipo().equals("admin")) {
                    new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                    Singletons.efModif.dispose();
                    JPanel pVolver = new JPanel();
                    pVolver.add(Singletons.efPager.panelPager);
                    Singletons.ini.internalFrame.setContentPane(pVolver);

                } else if (Singletons.cliLog.getTipo().equals("usuario")) {
                    Singletons.efModif.dispose();
                    new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);
                    JPanel panel_Inicio = new JPanel();
                    panel_Inicio.add(Singletons.iniPanel.panelInicio);
                    Singletons.ini.internalFrame.setContentPane(panel_Inicio);
                }
                break;

            case _BTN_CARGAR_IMG_M:
                FileUploader.pintar_guardar_img(Singletons.efModif.etiAvatarM, 90, 90, 1);
                break;

            // ------- MODIFICAR CLIENTE MI PERFIL-------------------            
            case _TXT_NOMBRE_MP:
                ClienteBLL.pideNombreMP();
                break;

            case _TXT_APELLIDOS_MP:
                ClienteBLL.pideApellidosMP();
                break;

            case _TXT_TELEFONO_MP:
                ClienteBLL.pideTelefonoMP();
                break;

            case _TXT_DIRECCION_MP:
                ClienteBLL.pideDireccionMP();
                break;

            case _TXT_EMAIL_MP:
                ClienteBLL.pideEmailMP();
                break;

            case _BTN_ACEPTAR_MP:
                ClienteBLL.ModificarPagerMP();
                break;

            case _TXT_LOGIN_MP:
                ClienteBLL.pideLoginMP();
                break;

            case _TXT_PASSWORD_MP:
                ClienteBLL.pidePasswordMP();
                break;

            case _BTN_VOLVER_MP:

                if (Singletons.cliLog.getTipo().equals("admin")) {
                    new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
                    Singletons.cliMP.dispose();
                    JPanel pVolver = new JPanel();
                    pVolver.add(Singletons.efPager.panelPager);
                    Singletons.ini.internalFrame.setContentPane(pVolver);

                } else if (Singletons.cliLog.getTipo().equals("usuario")) {
                    Singletons.cliMP.dispose();
                    new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);
                    JPanel panel_Inicio = new JPanel();
                    panel_Inicio.add(Singletons.iniPanel.panelInicio);
                    Singletons.ini.internalFrame.setContentPane(panel_Inicio);
                }
                break;

            case _BTN_CARGAR_IMG_MP:
                FileUploader.pintar_guardar_img(Singletons.efModif.etiAvatarM, 90, 90, 2);

                break;

            case _BTN_SALIR_MP:

                Singletons.conectado = false;

                Singletons.ini.eti_Entrar_Usuario.setText("Entrar");
                Singletons.ini.eti_Reg_Perfil.setText("Regístrate");
                FileUploader.leer_imag_defecto(5);
                Singletons.ini.etiAdmin.setVisible(false);

                new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);

                JPanel panel_Inicio = new JPanel();
                panel_Inicio.add(Singletons.iniPanel.panelInicio);
                Singletons.ini.internalFrame.setContentPane(panel_Inicio);

                break;

            case _BTN_ELIMINAR_MP:
                ClienteBLL.EliminarMP();

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

            // ----------  Crear CLIENTE  --------------
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

            case _TXT_LOGIN:
                ClienteBLL.pideLoginKey();
                break;

            case _TXT_PASSWORD:
                ClienteBLL.pidePasswordKey();
                break;

            // ------------  Modificar cliente --------------     
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

            case _TXT_LOGIN_M:
                ClienteBLL.pideLoginKeyM();
                break;

            case _TXT_PASSWORD_M:
                ClienteBLL.pidePasswordKeyM();
                break;

            // ------------  Modificar cliente MI PERFIL--------------     
            case _TXT_NOMBRE_MP:
                ClienteBLL.pideNombreKeyMP();
                break;

            case _TXT_APELLIDOS_MP:
                ClienteBLL.pideApellidosKeyMP();
                break;

            case _TXT_TELEFONO_MP:
                ClienteBLL.pideTelefonoKeyMP();
                break;

            case _TXT_EMAIL_MP:
                ClienteBLL.pideEmailKeyMP();
                break;

            case _TXT_DIRECCION_MP:
                ClienteBLL.pideDireccionKeyMP();
                break;

            case _TXT_PASSWORD_MP:
                ClienteBLL.pidePasswordKeyMP();
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

            // ----------  Crear cliente  --------------
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

            case _TXT_LOGIN:
                ClienteBLL.pideLoginKey();
                break;

            case _TXT_PASSWORD:
                ClienteBLL.pidePasswordKey();
                break;

            // ------------  Modificar cliente --------------     
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

            case _TXT_LOGIN_M:
                ClienteBLL.pideLoginKeyM();
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
