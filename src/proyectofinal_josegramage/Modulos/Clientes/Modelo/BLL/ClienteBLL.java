package proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL;

import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Librerias.Encriptador;
import javax.swing.JOptionPane;

import proyectofinal_josegramage.Main;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.SimpleTableModel_cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.pager.pagina;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Utiles.Menus;
import java.util.ArrayList;
import java.util.Iterator;

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

        if (Singletons.cli != null) {
            Singletons.cliArray.add(Singletons.cli);
            ClienteBLL_bd.nuevoUsuarioBLL();
            ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
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
    
    public static void pideLoginM() {
        ClienteDAO.pideLoginM();
    }
    
    public static void pidePassword(){
        ClienteDAO.pidePassword();
    }
    
    public static void pidePasswordM(){
        ClienteDAO.pidePasswordM();
    }
    
    public static void pidePasswordKeyM(){
        ClienteDAO.pidePasswordM_Key();
    }

    public static void ocultaErrorM() {
        ClienteDAO.ocultarErroresModificar();
    }

    public static void modificar() {
        ClienteDAO.modificar();
    }

    public static void ModificarPager() {

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

        
      //      FileUploader.leer_imag(1);
            Singletons.cli.setAvatar(Singletons.PATH_auto);
        

        if ((Vtna_cli_Modif.errorNombreM.isVisible() == false) && (Vtna_cli_Modif.errorApellidosM.isVisible() == false) && (Vtna_cli_Modif.errorTelfM.isVisible() == false)
                && (Vtna_cli_Modif.errorFnacimientoM.isVisible() == false) && (Singletons.efModif.errorPasswordM.isVisible() == false) && (Vtna_cli_Modif.errorDireccionM.isVisible() == false)) {

            Singletons.cliArray.set(Singletons.pos, Singletons.cli);
            ClienteBLL_bd.modificarClienteBLL();
            ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();

            Vtna_cli_Modif.btnOKM.setVisible(true);
            Vtna_cli_Modif.etiGuardadoM.setVisible(true);
            ClienteDAO.noEditableM();

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
                    ((SimpleTableModel_cliente) Singletons.efPager.TABLA.getModel()).cargar();
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

    public static void abrir() {//Abrir en el formato elegido por el usuario previamente en configuracion

        if (Main.conf.getGuardar() == "1") {
            Singletons.cliArray = proyectofinal_josegramage.Librerias.Json.abrirJSON();
            abrirSilencioso();
        } else if (Main.conf.getGuardar() == "2") {
            Singletons.cliArray = proyectofinal_josegramage.Librerias.Txt.abrirTXTempfijo();
            abrirSilencioso();
        } else if (Main.conf.getGuardar() == "3") {
            Singletons.cliArray = proyectofinal_josegramage.Librerias.Xml.abrirXMLempfijo();
            abrirSilencioso();
        }
    }

    public static void guardar() {//Guardar en el formato elegido por el usuario previamente en configuracion
        if (Singletons.cliArray.size() != 0) {

            if (Main.conf.getGuardar() == "1") {
                proyectofinal_josegramage.Librerias.Json.guardarJSON();//Genera un archivo json con todos los datos del Arraylist de empleados fijos
                guardarSilencioso();
            } else if (Main.conf.getGuardar() == "2") {
                proyectofinal_josegramage.Librerias.Txt.guardarTXTempfijo();//Lo mismo que antes pero con un txt
                guardarSilencioso();
            } else if (Main.conf.getGuardar() == "3") {
                proyectofinal_josegramage.Librerias.Xml.guardarXMLempfijo();//�dem pero para un xml
                guardarSilencioso();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void guardarSilencioso() {
        proyectofinal_josegramage.Librerias.Json.guardarJSONocultoEmpFijo();
        proyectofinal_josegramage.Librerias.Txt.guardarTXTocultoEmpFijo();
        proyectofinal_josegramage.Librerias.Xml.guardarXMLocultoEmpFijo();
    }

    public static void abrirSilencioso() {

        //ArraylistEmpFijo.efi=framework.Librerias.Json.abrir_jsonOcultoEF();
        Singletons.cliArray = proyectofinal_josegramage.Librerias.Txt.abrirTXTocultoEmpFijo();
        Singletons.cliArray = proyectofinal_josegramage.Librerias.Xml.abrirXMLocultoEmpFijo();
    }

    public static void GuardarAntesSalir() {
        int op2 = 0;
        do {
            op2 = Menus.GuardarSalirSiNo(0);
            switch (op2) {
                case 0:
                    Main.conf.setGuardar(Menus.menuFormatoGuardar());
                    guardar();
                    guardarSilencioso();
                    break;
                case 1:
                    break;
            }
        } while (op2 < 1);
    }
}
