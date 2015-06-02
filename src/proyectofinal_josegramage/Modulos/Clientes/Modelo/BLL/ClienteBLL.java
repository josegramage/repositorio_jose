package proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL;

import proyectofinal_josegramage.Utiles.FileUploader;
import proyectofinal_josegramage.Librerias.Encriptador;
import javax.swing.JOptionPane;

import proyectofinal_josegramage.Main;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.SimpleTableModel_cliente;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.pager.pagina;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Utiles.Menus;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import proyectofinal_josegramage.Modulos.Clientes.Controlador.Controlador_Cliente;
import proyectofinal_josegramage.Modulos.Inicio.Controlador.Controlador_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_panel_Inicio;
import proyectofinal_josegramage.Modulos.Login.Modelo.DAO.LoginDAO;
import proyectofinal_josegramage.Modulos.Menu.Controlador.Controlador_Menu;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Menu_Admin;

public class ClienteBLL {

    public static void pideNombre() {
        ClienteDAO.pideNombre();
    }

    public static void pideNombreKey() {
        ClienteDAO.pideNombreKey();
    }

    public static void pideApellidos() {
        ClienteDAO.pideApellidos();
    }

    public static void pideApellidosKey() {
        ClienteDAO.pideApellidosKey();
    }

    // para que no repita el dni
    public static void pideDni() {
        int pos = 0;
        Cliente e = new Cliente(ClienteDAO.pideDni());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            Vtna_cli_Crear.errorDni.setVisible(true);
        } else {
            Vtna_cli_Crear.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey() {
        int pos = 0;
        Cliente e = new Cliente(ClienteDAO.pideDniKey());
        pos = buscar(e);

        if (pos != -1) {
            Vtna_cli_Crear.errorDni.setVisible(true);
        } else {
            Vtna_cli_Crear.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey2() {
        ClienteDAO.pideDniKey();
    }

    public static void pideTelefono() {
        ClienteDAO.pideTelefono();
    }

    public static void pideTelefonoKey() {
        ClienteDAO.pideTelefonoKey();
    }

    public static void pideEmail() {
        ClienteDAO.pideEmail();
    }

    public static void pideEmailKey() {
        ClienteDAO.pideEmailKey();
    }

    public static void pideDireccion() {
        ClienteDAO.pideDireccion();
    }

    public static void pideDireccionKey() {
        ClienteDAO.pideDireccionKey();
    }

    public static void crearCliente() {

        ClienteDAO.CreaCliente();
//la fecha de alta se genera automaticamente asi que me sirve de chivato
        if (Singletons.cli.getFechaalta() != null) {
            Singletons.cliArray.add(Singletons.cli);
            ClienteBLL_bd.nuevoUsuarioBLL();
    //        ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();

            new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
            Singletons.efCrear.dispose();
            JPanel panelPag = new JPanel();
            panelPag.add(Singletons.efPager.panelPager);
            Singletons.ini.internalFrame.setContentPane(panelPag);
        }
    }

    public static void limpiar() {
        ClienteDAO.limpiar();
    }

    public static void editable() {
        ClienteDAO.editable();
    }

    public static void noEditable() {
        ClienteDAO.noEditable();
    }

    public static void ocultarErrores() {
        ClienteDAO.ocultarErrores();
    }

    public static void pideNombreM() {
        ClienteDAO.pideNombreM();
    }

    public static void pideNombreKeyM() {
        ClienteDAO.pideNombreKeyM();
    }

    public static void pideApellidosM() {
        ClienteDAO.pideApellidosM();
    }

    public static void pideApellidosKeyM() {
        ClienteDAO.pideApellidosKeyM();
    }

    public static void pideTelefonoM() {
        ClienteDAO.pideTelefonoM();
    }

    public static void pideTelefonoKeyM() {
        ClienteDAO.pideTelefonoKeyM();
    }

    public static void pideEmailM() {
        ClienteDAO.pideEmailM();
    }

    public static void pideEmailKeyM() {
        ClienteDAO.pideEmailKeyM();
    }

    public static void pideDireccionM() {
        ClienteDAO.pideDireccionM();
    }

    public static void pideDireccionKeyM() {
        ClienteDAO.pideDireccionKeyM();
    }

    public static void pideFnacimientoM() {
        ClienteDAO.pideFnacimientoM();
    }

    public static void pideLogin() {
        ClienteDAO.pideLogin();
    }

    public static void pideLoginKey() {
        ClienteDAO.pideLoginKey();
    }

    public static void pideLoginM() {
        ClienteDAO.pideLoginM();
    }

    public static void pideLoginKeyM() {
        ClienteDAO.pideLoginKeyM();
    }

    public static void pidePassword() {
        ClienteDAO.pidePassword();
    }

    public static void pidePasswordKey() {
        ClienteDAO.pidePasswordKey();
    }

    public static void pidePasswordM() {
        ClienteDAO.pidePasswordM();
    }

    public static void pidePasswordKeyM() {
        ClienteDAO.pidePasswordM_Key();
    }

    public static void ocultaErrorM() {
        ClienteDAO.ocultarErroresModificar();
    }

    public static void modificar() {
        ClienteDAO.modificar();
    }

    //modificar Admin
    public static void ModificarPagerAdmin() {

        if (Vtna_cli_Modif.errorNombreM.isVisible() == false) {
            Singletons.cli.setNombre(ClienteDAO.pideNombreM());
        }
        if (Vtna_cli_Modif.errorApellidosM.isVisible() == false) {
            Singletons.cli.setApellidos(ClienteDAO.pideApellidosM());
        }
        if (Vtna_cli_Modif.errorTelfM.isVisible() == false) {
            Singletons.cli.setTelefono(ClienteDAO.pideTelefonoM());
        }
        if (Vtna_cli_Modif.errorEmailM.isVisible() == false) {
            Singletons.cli.setEmail(ClienteDAO.pideEmailM());
        }
        if (Vtna_cli_Modif.errorFnacimientoM.isVisible() == false) {
            Singletons.cli.setFnacimiento(ClienteDAO.pideFnacimientoM());
        }
        if (Vtna_cli_Modif.errorDireccionM.isVisible() == false) {
            Singletons.cli.setDireccion(ClienteDAO.pideDireccionM());
        }

        Singletons.cli.setLogin(ClienteDAO.pideLoginM());
        Singletons.cli.setPassword(ClienteDAO.pidePasswordM());
        Singletons.cli.setTipo(ClienteDAO.pideTipoM());

        if (Singletons.PATH_auto != null) {
            Singletons.cli.setAvatar(Singletons.PATH_auto);
        }

        if ((Vtna_cli_Modif.errorNombreM.isVisible() == false) && (Vtna_cli_Modif.errorApellidosM.isVisible() == false) && (Vtna_cli_Modif.errorTelfM.isVisible() == false)
                && (Vtna_cli_Modif.errorFnacimientoM.isVisible() == false) && (Singletons.efModif.errorPasswordM.isVisible() == false) && (Vtna_cli_Modif.errorDireccionM.isVisible() == false)) {

            Singletons.cliArray.set(Singletons.pos, Singletons.cli);
            ClienteBLL_bd.modificarClienteBLL();

      //      ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();

            new Controlador_Cliente(new Vtna_cli_Pager(), 0).iniciar(0);
            Singletons.efModif.dispose();
            JPanel panelPagerM = new JPanel();
            panelPagerM.add(Singletons.efPager.panelPager);
            Singletons.ini.internalFrame.setContentPane(panelPagerM);
        }
    }

    public static int buscar(Cliente ef) {//Buscar
        int aux = -1;

        for (int i = 0; i <= (Singletons.cliArray.size() - 1); i++) {
            if ((Singletons.cliArray.get(i)).equals(ef)) {
                aux = i;
            }
        }
        return aux;
    }

    public static void btnEliminarPager() {
        String nombre = "", apellido = "";
        int opc, inicio, selection, selection1;
        int n = ((SimpleTableModel_cliente) Vtna_cli_Pager.TABLA.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selection = Vtna_cli_Pager.TABLA.getSelectedRow();
            selection1 = inicio + selection;
            if (n == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 0);
            } else {
                nombre = (String) Vtna_cli_Pager.TABLA.getModel().getValueAt(selection1, 1);
                apellido = (String) Vtna_cli_Pager.TABLA.getModel().getValueAt(selection1, 2);
                opc = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar a " + nombre + " " + apellido + "?", "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {
                    ((SimpleTableModel_cliente) Vtna_cli_Pager.TABLA.getModel()).removeRow(selection1);
                    ClienteBLL_bd.borrarUsuarioBLL();
             //       ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados", "Error!", 0);
        }
    }

    public static void InfoPager() {
        imprimir(Singletons.cliArray);
    }

    public static void imprimir(ArrayList<? extends Cliente> l) {

        Cliente cli;
        String cad = "";
        Iterator<Cliente> it = (Iterator<Cliente>) l.iterator();
        while (it.hasNext()) {
            cli = it.next();
            cad = Singletons.cli + "\n" + "\n";
        }
        JOptionPane.showMessageDialog(null, cad);
    }

   
    public static void guardar() {//Guardar en el formato elegido por el usuario previamente en configuracion
        if (Singletons.cliArray.size() != 0) {

            if (Main.conf.getGuardar() == "1") {
                proyectofinal_josegramage.Librerias.Json.guardarJSON();//Genera un archivo json con todos los datos del Arraylist de empleados fijos
         
            } else if (Main.conf.getGuardar() == "2") {
                proyectofinal_josegramage.Librerias.Txt.guardarTXTcliente();//Lo mismo que antes pero con un txt
       
            } else if (Main.conf.getGuardar() == "3") {
                proyectofinal_josegramage.Librerias.Xml.guardarXMLcliente();//�dem pero para un xml
      
            }
        } else {
            JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    ////// M O D I F I C A R   M I  P E R F I L  ///////////////
    public static void pideNombreMP() {
        ClienteDAO.pideNombreMP();
    }

    public static void pideNombreKeyMP() {
        ClienteDAO.pideNombreKeyMP();
    }

    public static void pideApellidosMP() {
        ClienteDAO.pideApellidosMP();
    }

    public static void pideApellidosKeyMP() {
        ClienteDAO.pideApellidosKeyMP();
    }

    public static void pideTelefonoMP() {
        ClienteDAO.pideTelefonoMP();
    }

    public static void pideTelefonoKeyMP() {
        ClienteDAO.pideTelefonoKeyMP();
    }

    public static void pideEmailMP() {
        ClienteDAO.pideEmailMP();
    }

    public static void pideEmailKeyMP() {
        ClienteDAO.pideEmailKeyMP();
    }

    public static void pideDireccionMP() {
        ClienteDAO.pideDireccionMP();
    }

    public static void pideDireccionKeyMP() {
        ClienteDAO.pideDireccionKeyMP();
    }

    public static void pideFnacimientoMP() {
        ClienteDAO.pideFnacimientoMP();
    }

    public static void pideLoginMP() {
        ClienteDAO.pideLoginMP();
    }

    public static void pidePasswordMP() {
        ClienteDAO.pidePasswordMP();
    }

    public static void pidePasswordKeyMP() {
        ClienteDAO.pidePasswordMP_Key();
    }

    public static void ocultaErrorMP() {
        ClienteDAO.ocultarErroresModificarMP();
    }

    public static void modificarMP() {
        ClienteDAO.modificarLogeadoMP();
    }

    // Modificar usuario
    public static void ModificarPagerMP() {

        if (Singletons.cliMP.errorNombreM.isVisible() == false) {
            Singletons.cliLog.setNombre(ClienteDAO.pideNombreMP());
        }
        if (Singletons.cliMP.errorApellidosM.isVisible() == false) {
            Singletons.cliLog.setApellidos(ClienteDAO.pideApellidosMP());
        }
        if (Singletons.cliMP.errorTelfM.isVisible() == false) {
            Singletons.cliLog.setTelefono(ClienteDAO.pideTelefonoMP());
        }
        if (Singletons.cliMP.errorEmailM.isVisible() == false) {
            Singletons.cliLog.setEmail(ClienteDAO.pideEmailMP());
        }
        if (Singletons.cliMP.errorFnacimientoM.isVisible() == false) {
            Singletons.cliLog.setFnacimiento(ClienteDAO.pideFnacimientoMP());
        }
        if (Singletons.cliMP.errorDireccionM.isVisible() == false) {
            Singletons.cliLog.setDireccion(ClienteDAO.pideDireccionMP());
        }

        Singletons.cliLog.setLogin(ClienteDAO.pideLoginMP());
        Singletons.cliLog.setPassword(ClienteDAO.pidePasswordMP());
        Singletons.cliLog.setTipo(ClienteDAO.pideTipoMP());

  /*      if (Singletons.cliLog.getAvatar().isEmpty()) {
            Singletons.cliLog.setAvatar(Singletons.PATH_auto);
        }
    */    
        if (Singletons.PATH_auto != null) {
            Singletons.cliLog.setAvatar(Singletons.PATH_auto);
        }

        if ((Singletons.cliMP.errorNombreM.isVisible() == false) && (Singletons.cliMP.errorApellidosM.isVisible() == false) && (Singletons.cliMP.errorTelfM.isVisible() == false)
                && (Singletons.cliMP.errorFnacimientoM.isVisible() == false) && (Singletons.cliMP.errorPasswordM.isVisible() == false) && (Singletons.cliMP.errorDireccionM.isVisible() == false)) {

            Singletons.cliArray.set(Singletons.pos, Singletons.cliLog);
            ClienteBLL_bd.modificarClienteLogeado();
            
            Singletons.ini.eti_Entrar_Usuario.setText(Singletons.cliLog.getLogin());
             if (Singletons.cliLog.getAvatar().isEmpty()) {
                    FileUploader.leer_imag_defecto(2);
                } else {
                    FileUploader.leer_imag(0);
                }

            if (Singletons.cliLog.getTipo().equals("admin")) {
                Singletons.cliMP.dispose();
                new Controlador_Menu(new Vtna_Menu_Admin(), 0).iniciar(0);
                JPanel pmenu = new JPanel();
                pmenu.add(Singletons.menu.panelMenu);
                Singletons.ini.internalFrame.setContentPane(pmenu);

            } else if (Singletons.cliLog.getTipo().equals("usuario")) {
                Singletons.cliMP.dispose();
                new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);
                JPanel panel_Inicio = new JPanel();
                panel_Inicio.add(Singletons.iniPanel.panelInicio);
                Singletons.ini.internalFrame.setContentPane(panel_Inicio);
            }
        }
    }

    public static void EliminarMP() {

        int confirmado = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar tu cuenta?", "Info", JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.OK_OPTION == confirmado) {
            ClienteBLL_bd.borrarUsuarioMiPerfil();

            new Controlador_Inicio(new Vtna_panel_Inicio(), 1).iniciar(1);

            JPanel panel_Inicio2 = new JPanel();
            panel_Inicio2.add(Singletons.iniPanel.panelInicio);
            Singletons.ini.internalFrame.setContentPane(panel_Inicio2);

            Singletons.conectado = false;

            Singletons.ini.eti_Entrar_Usuario.setText("Entrar");
            Singletons.ini.eti_Reg_Perfil.setText("Regístrate");
            FileUploader.leer_imag_defecto(5);
            Singletons.ini.etiAdmin.setVisible(false);
        } else {
        }
    }
}
