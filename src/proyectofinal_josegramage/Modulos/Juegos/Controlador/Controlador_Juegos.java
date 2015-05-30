/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Juegos.Controlador;

import proyectofinal_josegramage.Utiles.FileUploader;
import proyectofinal_josegramage.Clases.JDKP_Fondo;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL.JuegoBLL;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL.JuegoBLL_bd;
import proyectofinal_josegramage.Modulos.Juegos.Clases.SimpleTableModel_juegos;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO.JuegoDAO;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.autocomplete.AutocompleteJComboBox_J;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.autocomplete.StringSearchable_J;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.pager.pagina_J;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Crear;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Modif;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyectofinal_josegramage.Modulos.Clientes.Controlador.Controlador_Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;

/**
 *
 * @author Joso
 */
public class Controlador_Juegos implements ActionListener, KeyListener, MouseListener {

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
        _TXT_COMPANYIA,
        _TXT_REF,
        _TXT_TIPO,
        _TXT_PRECIO,
        _TXT_DESCRIPCION,
        _BTN_CARGAR_IMG,
        _BTN_ACEPTAR,
        _BTN_CANCELAR,
        _BTN_NUEVO,
        _BTN_VOLVER,
        _COMBO_TIPO,
        // Ventana modificar
        _TXT_NOMBRE_M,
        _TXT_COMPANYIA_M,
        _TXT_TIPO_M,
        _TXT_PRECIO_M,
        _TXT_DESCRIPCION_M,
        _BTN_ACEPTAR_M,
        _BTN_CANCELAR_M,
        _BTN_VOLVER_M,
        _BTN_CARGAR_IMG_M,

    }

    public Controlador_Juegos(JFrame pager_J, int i) {

        if (i == 0) {
            Singletons.juePager = (Vtna_jue_Pager) pager_J;
        }

        if (i == 1) {
            Singletons.jueCrear = (Vtna_jue_Crear) pager_J;
        }

        if (i == 2) {
            Singletons.jueModif = (Vtna_jue_Modif) pager_J;
        }
    }

    public void iniciar(int i) {

        if (i == 0) {

            Singletons.juePager.TABLA.setModel(new SimpleTableModel_juegos());
            ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();
            Singletons.juePager.TABLA.setFillsViewportHeight(true);
            Singletons.juePager.TABLA.setRowSorter(Singletons.sorter_J);

            pagina_J.inicializa();
            pagina_J.initLinkBox();

            Singletons.juePager.etiFILTRAR.setText(String.valueOf(Singletons.jueg.size()));

            List<String> myWords = new ArrayList<String>();
            for (int x = 0; x <= Singletons.jueg.size() - 1; x++) {
                myWords.add(Singletons.jueg.get(x).getNombre());
            }

            StringSearchable_J searchable = new StringSearchable_J(myWords);
            Singletons.combo_J = new AutocompleteJComboBox_J(searchable);
            Vtna_jue_Pager.panelFiltrar.setLayout(new java.awt.BorderLayout());
            Vtna_jue_Pager.panelFiltrar.add(Singletons.combo_J);

            Singletons.combo_J.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            if (Singletons.conectado == true) {
                if (Singletons.cliLog.getTipo().equals("usuario")) {
                    Singletons.juePager.btnAgregar.setVisible(false);
                    Singletons.juePager.btnCambiar.setVisible(false);
                    Singletons.juePager.btnEliminar.setVisible(false);
                    Singletons.juePager.btnMenu.setVisible(false);
                    Singletons.juePager.btnInfo.setVisible(false);
                } 

                } else {
                    Singletons.juePager.btnAgregar.setVisible(false);
                    Singletons.juePager.btnCambiar.setVisible(false);
                    Singletons.juePager.btnEliminar.setVisible(false);
                    Singletons.juePager.btnMenu.setVisible(false);
                    Singletons.juePager.btnInfo.setVisible(false);
            }

                Singletons.juePager.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
                Singletons.juePager.ANTERIOR.addActionListener(this);

                Singletons.juePager.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
                Singletons.juePager.SIGUIENTE.addActionListener(this);

                Singletons.juePager.ultimo.setActionCommand("_BTN_ULTIMO");
                Singletons.juePager.ultimo.addActionListener(this);

                Singletons.juePager.primero.setActionCommand("_BTN_PRIMERO");
                Singletons.juePager.primero.addActionListener(this);

                Singletons.juePager.jComboBox1.setActionCommand("_COMBOX");
                Singletons.juePager.jComboBox1.addActionListener(this);

                Singletons.juePager.panelFiltrar.setName("_PANEL_FILTRAR");
                Singletons.juePager.panelFiltrar.setActionCommand("_PANEL_FILTRAR");
                Singletons.juePager.panelFiltrar.addActionListener(this);
                Singletons.juePager.panelFiltrar.addKeyListener(this);

                Singletons.juePager.TABLA.setName("_TABLA_CLICK");
                Singletons.juePager.TABLA.addMouseListener(this);
                Singletons.juePager.TABLA.addKeyListener(this);

                Singletons.juePager.btnGuardar.setActionCommand("_BTN_GUARDAR");
                Singletons.juePager.btnGuardar.addActionListener(this);

                Singletons.juePager.btnAbrir.setActionCommand("_BTN_ABRIR");
                Singletons.juePager.btnAbrir.addActionListener(this);

                Singletons.juePager.btnAgregar.setActionCommand("_BTN_AGREGAR");
                Singletons.juePager.btnAgregar.setName("_BTN_AGREGAR");
                Singletons.juePager.btnAgregar.addActionListener(this);
                Singletons.juePager.btnAgregar.addMouseListener(this);

                Singletons.juePager.btnCambiar.setActionCommand("_BTN_CAMBIAR");
                Singletons.juePager.btnCambiar.setName("_BTN_CAMBIAR");
                Singletons.juePager.btnCambiar.addActionListener(this);
                Singletons.juePager.btnCambiar.addMouseListener(this);

                Singletons.juePager.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                Singletons.juePager.btnEliminar.setName("_BTN_ELIMINAR");
                Singletons.juePager.btnEliminar.addActionListener(this);
                Singletons.juePager.btnEliminar.addMouseListener(this);

                Singletons.juePager.btnInfo.setActionCommand("_BTN_INFO");
                Singletons.juePager.btnInfo.setName("_BTN_INFO");
                Singletons.juePager.btnInfo.addActionListener(this);
                Singletons.juePager.btnInfo.addMouseListener(this);

                Singletons.juePager.btnMenu.setActionCommand("_BTN_MENU");
                Singletons.juePager.btnMenu.setName("_BTN_MENU");
                Singletons.juePager.btnMenu.addActionListener(this);
                Singletons.juePager.btnMenu.addMouseListener(this);

                Singletons.juePager.btnPerfilEditar.setActionCommand("_BTN_PERFIL_EDITAR");
                Singletons.juePager.btnPerfilEditar.setName("_BTN_PERFIL_EDITAR");
                Singletons.juePager.btnPerfilEditar.addActionListener(this);
                Singletons.juePager.btnPerfilEditar.addMouseListener(this);

                Singletons.juePager.btnPerfilSalir.setActionCommand("_BTN_PERFIL_SALIR");
                Singletons.juePager.btnPerfilSalir.setName("_BTN_PERFIL_SALIR");
                Singletons.juePager.btnPerfilSalir.addActionListener(this);
                Singletons.juePager.btnPerfilSalir.addMouseListener(this);
            }

            //     Crear juegos
            if (i == 1) {

                JuegoDAO.ocultarErrores();
                FileUploader.leer_img_defecto_J(0);

                Singletons.jueCrear.txtNombre.setName("_TXT_NOMBRE");
                Singletons.jueCrear.txtNombre.setActionCommand("_TXT_NOMBRE");
                Singletons.jueCrear.txtNombre.addActionListener(this);
                Singletons.jueCrear.txtNombre.addKeyListener(this);

                Singletons.jueCrear.txtCompanyia.setName("_TXT_COMPANYIA");
                Singletons.jueCrear.txtCompanyia.setActionCommand("_TXT_COMPANYIA");
                Singletons.jueCrear.txtCompanyia.addActionListener(this);
                Singletons.jueCrear.txtCompanyia.addKeyListener(this);

                Singletons.jueCrear.txtRef.setName("_TXT_REF");
                Singletons.jueCrear.txtRef.setActionCommand("_TXT_REF");
                Singletons.jueCrear.txtRef.addActionListener(this);
                Singletons.jueCrear.txtRef.addKeyListener(this);

                Singletons.jueCrear.txtTipo.setName("_TXT_TIPO");
                Singletons.jueCrear.txtTipo.setActionCommand("_TXT_TIPO");
                Singletons.jueCrear.txtTipo.addActionListener(this);
                Singletons.jueCrear.txtTipo.addKeyListener(this);

                Singletons.jueCrear.txtDescripcion.setName("_TXT_DESCRIPCION");
                Singletons.jueCrear.txtDescripcion.addKeyListener(this);

                Singletons.jueCrear.txtPrecio.setName("_TXT_PRECIO");
                Singletons.jueCrear.txtPrecio.setActionCommand("_TXT_PRECIO");
                Singletons.jueCrear.txtPrecio.addActionListener(this);
                Singletons.jueCrear.txtPrecio.addKeyListener(this);

                Singletons.jueCrear.btnCargarImg.setActionCommand("_BTN_CARGAR_IMG");
                Singletons.jueCrear.btnCargarImg.addActionListener(this);

                Singletons.jueCrear.btnAceptar.setActionCommand("_BTN_ACEPTAR");
                Singletons.jueCrear.btnAceptar.addActionListener(this);

                Singletons.jueCrear.btnCancelar.setActionCommand("_BTN_CANCELAR");
                Singletons.jueCrear.btnCancelar.addActionListener(this);

                Singletons.jueCrear.btnVolver.setActionCommand("_BTN_VOLVER");
                Singletons.jueCrear.btnVolver.addActionListener(this);

                Singletons.jueCrear.btnNuevo.setActionCommand("_BTN_NUEVO");
                Singletons.jueCrear.btnNuevo.setName("_BTN_NUEVO");
                Singletons.jueCrear.btnNuevo.addActionListener(this);
                Singletons.jueCrear.btnNuevo.addMouseListener(this);

            }
            //     Modificar empleado
            if (i == 2) {

                JuegoDAO.modificarJuego();
                JuegoBLL.ocultaErrorM();

                Singletons.jueModif.txtNombreM.setName("_TXT_NOMBRE_M");
                Singletons.jueModif.txtNombreM.setActionCommand("_TXT_NOMBRE_M");
                Singletons.jueModif.txtNombreM.addActionListener(this);
                Singletons.jueModif.txtNombreM.addKeyListener(this);

                Singletons.jueModif.txtCompanyiaM.setName("_TXT_COMPANYIA_M");
                Singletons.jueModif.txtCompanyiaM.setActionCommand("_TXT_COMPANYIA_M");
                Singletons.jueModif.txtCompanyiaM.addActionListener(this);
                Singletons.jueModif.txtCompanyiaM.addKeyListener(this);

                Singletons.jueModif.txtTipoM.setName("_TXT_TIPO_M");
                Singletons.jueModif.txtTipoM.setActionCommand("_TXT_TIPO_M");
                Singletons.jueModif.txtTipoM.addActionListener(this);
                Singletons.jueModif.txtTipoM.addKeyListener(this);

                Singletons.jueModif.txtDescripcionM.setName("_TXT_DIRECCION_M");
                Singletons.jueModif.txtDescripcionM.addKeyListener(this);

                Singletons.jueModif.txtPrecioM.setName("_TXT_PRECIO_M");
                Singletons.jueModif.txtPrecioM.setActionCommand("_TXT_PRECIO_M");
                Singletons.jueModif.txtPrecioM.addActionListener(this);
                Singletons.jueModif.txtPrecioM.addKeyListener(this);

                Singletons.jueModif.btnCambiarImgM.setActionCommand("_BTN_CARGAR_IMG_M");
                Singletons.jueModif.btnCambiarImgM.addActionListener(this);

                Singletons.jueModif.btnAceptarM.setActionCommand("_BTN_ACEPTAR_M");
                Singletons.jueModif.btnAceptarM.addActionListener(this);

                Singletons.jueModif.btnCancelarM.setActionCommand("_BTN_CANCELAR_M");
                Singletons.jueModif.btnCancelarM.addActionListener(this);

                Singletons.jueModif.btnVolverM.setActionCommand("_BTN_VOLVER_M");
                Singletons.jueModif.btnVolverM.addActionListener(this);
            }
        }

    

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) Singletons.combo_J).getSelectedItem());
        pagina_J.currentPageIndex = 1;
        ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            case _BTN_AGREGAR:
                Singletons.juePager.dispose();
                new Controlador_Juegos(new Vtna_jue_Crear(), 1).iniciar(1);
                JPanel panel_crear = new JPanel();
                panel_crear.add(Singletons.jueCrear.panelCrear);
                Singletons.ini.internalFrame.setContentPane(panel_crear);
                break;

            case _BTN_CAMBIAR:
                int inicio,
                 selection,
                 selection1;

                int n = ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).getRowCount();
                if (n != 0) {
                    inicio = (pagina_J.currentPageIndex - 1) * pagina_J.itemsPerPage;
                    selection = Vtna_jue_Pager.TABLA.getSelectedRow();
                    selection1 = inicio + selection;
                    if (Singletons.jue != null) {
                        Singletons.juePager.dispose();
                        new Controlador_Juegos(new Vtna_jue_Modif(), 2).iniciar(2);
                        JPanel panel_modif = new JPanel();
                        panel_modif.add(Singletons.jueModif.panelModif);
                        Singletons.ini.internalFrame.setContentPane(panel_modif);
                        JuegoDAO.modificarJuego();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                    }
                }
                break;

            case _BTN_ELIMINAR:
                JuegoBLL.btnEliminarPager();
                break;

            case _BTN_INFO:
                if (Singletons.jue != null) {
                    JuegoBLL.InfoPager();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                }
                break;

            case _BTN_MENU:
              new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
                Singletons.juePager.dispose();
                JPanel p4 = new JPanel();
                p4.add(Singletons.menu.panelMenu);
                Singletons.ini.internalFrame.setContentPane(p4);
                break;

            case _BTN_GUARDAR:
                Main.conf.setGuardar(Menus.menuFormatoGuardar());
                JuegoBLL.guardar();
                break;

            case _BTN_ABRIR:
                //          JuegoBLL.abrir();
                break;

            case _BTN_ANTERIOR:
                pagina_J.currentPageIndex -= 1;
                pagina_J.initLinkBox();
                break;

            case _BTN_SIGUIENTE:
                pagina_J.currentPageIndex += 1;
                pagina_J.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina_J.currentPageIndex = pagina_J.maxPageIndex;
                pagina_J.initLinkBox();
                break;

            case _BTN_PRIMERO:
                pagina_J.currentPageIndex = 1;
                pagina_J.initLinkBox();
                break;

            case _COMBOX:
                pagina_J.itemsPerPage = Integer.parseInt(Singletons.juePager.jComboBox1.getSelectedItem().toString());
                pagina_J.currentPageIndex = 1;
                pagina_J.initLinkBox();
                break;

            // ------- CREAR EMPLEADO -------------------               
            case _TXT_NOMBRE:
                JuegoBLL.pideNombre();
                break;

            case _TXT_COMPANYIA:
                JuegoBLL.pideCompanyia();
                break;

            case _TXT_REF:
                JuegoBLL.pideRef();
                break;

            case _TXT_TIPO:
                JuegoBLL.pideTipo();
                break;

            case _TXT_PRECIO:
                JuegoBLL.pidePrecio();
                break;

            case _TXT_DESCRIPCION:
                JuegoBLL.pideDescripcion();
                break;

            case _BTN_CARGAR_IMG:
                FileUploader.guardar_img_J(Singletons.jueCrear.etiAvatar, 90, 90, 0);
                break;

            case _BTN_ACEPTAR:
                JuegoBLL.crearJuego();
                break;

            case _BTN_CANCELAR:
                JuegoBLL.limpiar();
                break;

            case _BTN_VOLVER:
                new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
                Singletons.jueCrear.dispose();
                JPanel panelPager = new JPanel();
                panelPager.add(Singletons.juePager.panelPager);
                Singletons.ini.internalFrame.setContentPane(panelPager);
                break;

            // ------- MODIFICAR JUEGO -------------------            
            case _TXT_NOMBRE_M:
                JuegoBLL.pideNombreM();
                break;

            case _TXT_COMPANYIA_M:
                JuegoBLL.pideCompanyiaM();
                break;

            case _TXT_TIPO_M:
                JuegoBLL.pideTipoM();
                break;

            case _TXT_DESCRIPCION_M:
                JuegoBLL.pideDescripcionM();
                break;

            case _TXT_PRECIO_M:
                JuegoBLL.pidePrecioM();
                break;

            case _BTN_ACEPTAR_M:
                JuegoBLL.ModificarPagerJuegos();

                new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
                Singletons.jueModif.dispose();
                JPanel panelPagerM = new JPanel();
                panelPagerM.add(Singletons.juePager.panelPager);
                Singletons.ini.internalFrame.setContentPane(panelPagerM);

                ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();

            case _BTN_CANCELAR_M:
                JuegoBLL.ocultaErrorM();
                break;

            case _BTN_VOLVER_M:
                new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
                Singletons.jueModif.dispose();
                JPanel pModif = new JPanel();
                pModif.add(Singletons.juePager.panelPager);
                Singletons.ini.internalFrame.setContentPane(pModif);
                break;

            case _BTN_CARGAR_IMG_M:
                FileUploader.guardar_img_J(Singletons.jueModif.etiAvatarM, 90, 90, 1);
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
                pagina_J.currentPageIndex = 1;
                ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).filtrar();
                break;

            // ----------  Crear Empleado  --------------
            case _TXT_NOMBRE:
                JuegoBLL.pideNombreKey();
                break;

            case _TXT_COMPANYIA:
                JuegoBLL.pideCompanyiaKey();
                break;

            case _TXT_REF:
                JuegoBLL.pideRefKey();
                break;

            case _TXT_TIPO:
                JuegoBLL.pideTipoKey();
                break;

            case _TXT_DESCRIPCION:
                JuegoBLL.pideDescripcionKey();
                break;

            case _TXT_PRECIO:
                JuegoBLL.pidePrecioKey();
                break;

            // ------------  Modificar Empleado --------------     
            case _TXT_NOMBRE_M:
                JuegoBLL.pideNombreKeyM();
                break;

            case _TXT_COMPANYIA_M:
                JuegoBLL.pideCompanyiaKeyM();
                break;

            case _TXT_TIPO_M:
                JuegoBLL.pideTipoKeyM();
                break;

            case _TXT_DESCRIPCION_M:
                JuegoBLL.pideDescripcionKeyM();
                break;

            case _TXT_PRECIO_M:
                JuegoBLL.pidePrecioKeyM();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _PANEL_FILTRAR:
                pagina_J.currentPageIndex = 1;
                ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).filtrar();
                break;

            // ----------  Crear Empleado  --------------
            case _TXT_NOMBRE:
                JuegoBLL.pideNombreKey();
                break;

            case _TXT_COMPANYIA:
                JuegoBLL.pideCompanyiaKey();
                break;

            case _TXT_REF:
                JuegoBLL.pideRefKey();
                break;

            case _TXT_TIPO:
                JuegoBLL.pideTipoKey();
                break;

            case _TXT_DESCRIPCION:
                JuegoBLL.pideDescripcionKey();
                break;

            case _TXT_PRECIO:
                JuegoBLL.pidePrecioKey();
                break;

            // ------------  Modificar Empleado --------------     
            case _TXT_NOMBRE_M:
                JuegoBLL.pideNombreKeyM();
                break;

            case _TXT_COMPANYIA_M:
                JuegoBLL.pideCompanyiaKeyM();
                break;

            case _TXT_TIPO_M:
                JuegoBLL.pideTipoKeyM();
                break;

            case _TXT_DESCRIPCION_M:
                JuegoBLL.pideDescripcionKeyM();
                break;

            case _TXT_PRECIO_M:
                JuegoBLL.pidePrecioKeyM();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            case _TABLA_CLICK:
                try {
                    Singletons.jue = new Juego(Vtna_jue_Pager.TABLA.getValueAt(Vtna_jue_Pager.TABLA.getSelectedRow(), 0).toString());
                    JuegoBLL_bd.buscarRefBLL();

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
