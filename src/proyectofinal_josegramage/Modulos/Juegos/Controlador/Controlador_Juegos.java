/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Juegos.Controlador;

import proyectofinal_josegramage.Clases.FileUploader;
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
            Singletons.juePager.TABLA.setRowSorter(Singletons.sorter);

            pagina_J.inicializa();
            pagina_J.initLinkBox();

            Singletons.juePager.etiFILTRAR.setText(String.valueOf(Singletons.jueg.size()));

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

        //     Crear juegos
        if (i == 1) {
           

            JuegoDAO.ocultarErrores();
            FileUploader.leer_imag_defecto(0);

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
            Singletons.jueCrear.txtDescripcion.setActionCommand("_TXT_DESCRIPCION");
            Singletons.jueCrear.txtDescripcion.addActionListener(this);
            Singletons.jueCrear.txtDescripcion.addKeyListener(this);

            Singletons.jueCrear.txtPrecio.setName("_TXT_PRECIO");
            Singletons.jueCrear.txtPrecio.setActionCommand("_TXT_PRECIO");
            Singletons.jueCrear.txtPrecio.addActionListener(this);
            Singletons.jueCrear.txtPrecio.addKeyListener(this);

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

            Singletons.jueModif.txtTipoM.setName("_TXT_TELEFONO_M");
            Singletons.jueModif.txtTipoM.setActionCommand("_TXT_TELEFONO_M");
            Singletons.jueModif.txtTipoM.addActionListener(this);
            Singletons.jueModif.txtTipoM.addKeyListener(this);

            Singletons.jueModif.txtDescripcionM.setName("_TXT_DIRECCION_M");
            Singletons.jueModif.txtDescripcionM.setActionCommand("_TXT_DIRECCION_M");
            Singletons.jueModif.txtDescripcionM.addActionListener(this);
            Singletons.jueModif.txtDescripcionM.addKeyListener(this);

            Singletons.jueModif.txtPrecioM.setName("_TXT_EMAIL_M");
            Singletons.jueModif.txtPrecioM.setActionCommand("_TXT_EMAIL_M");
            Singletons.jueModif.txtPrecioM.addActionListener(this);
            Singletons.jueModif.txtPrecioM.addKeyListener(this);

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
        System.out.println("word selected: " + ((JComboBox) Singletons.combo_J).getSelectedItem());
        pagina_J.currentPageIndex = 1;
        ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            case _BTN_AGREGAR:
                Singletons.efPager.dispose();
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
                        panel_modif.add(Singletons.efModif.panelModif);
                        Singletons.ini.internalFrame.setContentPane(panel_modif);
                        JuegoDAO.modificarJuego();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.QUESTION_MESSAGE);
                }
                break;

            case _BTN_MENU:
        //        Singletons.efPager.dispose();
        //        new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
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
                FileUploader.pintar_guardar_img(Singletons.efCrear.etiAvatar, 90, 90, 0);
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

            
            // ------- MODIFICAR EMPLEADO -------------------            
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

                JuegoBLL.ModificarPager();
                //FileUploader.leer_imag(0);
               // Singletons.cliLog.setAvatar(null);
               
          
                new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
                Singletons.jueModif.dispose();
                JPanel panelPagerM = new JPanel();
                panelPagerM.add(Singletons.juePager.panelPager);
                Singletons.ini.internalFrame.setContentPane(panelPagerM);

                ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();
               

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
                new Controlador_Juegos(new Vtna_cli_Pager(), 0).iniciar(0);
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
