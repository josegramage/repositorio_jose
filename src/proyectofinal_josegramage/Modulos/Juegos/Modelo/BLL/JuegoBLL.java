package proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL;

import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Librerias.Encriptador;
import javax.swing.JOptionPane;

import proyectofinal_josegramage.Main;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Clases.SimpleTableModel_juegos;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO.JuegoDAO;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.pager.pagina_J;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Crear;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Modif;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;
import proyectofinal_josegramage.Utiles.Menus;
import java.util.ArrayList;
import java.util.Iterator;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO.JuegoDAO;

public class JuegoBLL {

    public static void pideNombre() {
        JuegoDAO.pideNombre();
    }

    public static void pideNombreKey() {
        JuegoDAO.pideNombreKey();
    }

    public static void pideApellidos() {
        JuegoDAO.pideApellidos();
    }

    public static void pideApellidosKey() {
        JuegoDAO.pideApellidosKey();
    }

    // para que no repita el dni
    public static void pideDni() {
        int pos = 0;
        Juego e = new Juego(JuegoDAO.pideDni());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            Vtna_jue_Crear.errorDni.setVisible(true);
        } else {
            Vtna_jue_Crear.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey() {
        int pos = 0;
        Juego e = new Juego(JuegoDAO.pideDniKey());
        pos = buscar(e);

        if (pos != -1) {
            Vtna_jue_Crear.errorDni.setVisible(true);
        } else {
            Vtna_jue_Crear.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey2() {
        JuegoDAO.pideDniKey();
    }

    public static void pideTelefono() {
        JuegoDAO.pideTelefono();
    }

    public static void pideTelefonoKey() {
        JuegoDAO.pideTelefonoKey();
    }

    public static void pideEmail() {
        JuegoDAO.pideEmail();
    }

    public static void pideEmailKey() {
        JuegoDAO.pideEmailKey();
    }

    public static void pideDireccion() {
        JuegoDAO.pideDireccion();
    }

    public static void pideDireccionKey() {
        JuegoDAO.pideDireccionKey();
    }

    public static void crearCliente() {

        JuegoDAO.CreaCliente();

        if (Singletons.cli != null) {
            Singletons.cliArray.add(Singletons.cli);
            JuegoBLL_bd.nuevoUsuarioBLL();
            ((SimpleTableModel_juegos) Singletons.efPager.TABLA.getModel()).cargar();
        }
    }

   
    public static void limpiar() {
        JuegoDAO.limpiar();
    }

    public static void editable() {
        JuegoDAO.editable();
    }

    public static void noEditable() {
        JuegoDAO.noEditable();
    }

    public static void ocultarErrores() {
        JuegoDAO.ocultarErrores();
    }

    public static void pideNombreM() {
        JuegoDAO.pideNombreM();
    }

    public static void pideNombreKeyM() {
        JuegoDAO.pideNombreKeyM();
    }

    public static void pideApellidosM() {
        JuegoDAO.pideApellidosM();
    }

    public static void pideApellidosKeyM() {
        JuegoDAO.pideApellidosKeyM();
    }

    public static void pideTelefonoM() {
        JuegoDAO.pideTelefonoM();
    }

    public static void pideTelefonoKeyM() {
        JuegoDAO.pideTelefonoKeyM();
    }

    public static void pideEmailM() {
        JuegoDAO.pideEmailM();
    }

    public static void pideEmailKeyM() {
        JuegoDAO.pideEmailKeyM();
    }

    public static void pideDireccionM() {
        JuegoDAO.pideDireccionM();
    }
    
    public static void pideDireccionKeyM() {
        JuegoDAO.pideDireccionKeyM();
    }

    public static void pideFnacimientoM() {
        JuegoDAO.pideFnacimientoM();
    }
    
    public static void pideLogin() {
        JuegoDAO.pideLogin();
    }
    
    public static void pideLoginM() {
        JuegoDAO.pideLoginM();
    }
    
    public static void pidePassword(){
        JuegoDAO.pidePassword();
    }
    
    public static void pidePasswordM(){
        JuegoDAO.pidePasswordM();
    }
    
    public static void pidePasswordKeyM(){
        JuegoDAO.pidePasswordM_Key();
    }

    public static void ocultaErrorM() {
        JuegoDAO.ocultarErroresModificar();
    }

    public static void modificar() {
        JuegoDAO.modificar();
    }

    public static void ModificarPager() {

        if (Vtna_jue_Modif.errorNombreM.isVisible() == false) {
            Singletons.cli.setNombre(JuegoDAO.pideNombreM());
        }
        if (Vtna_jue_Modif.errorApellidosM.isVisible() == false) {
            Singletons.cli.setApellidos(JuegoDAO.pideApellidosM());
        }
        if (Vtna_jue_Modif.errorTelfM.isVisible() == false) {
            Singletons.cli.setTelefono(JuegoDAO.pideTelefonoM());
        }
        if (Vtna_jue_Modif.errorEmailM.isVisible() == false) {
            Singletons.cli.setEmail(JuegoDAO.pideEmailM());
        }
        if (Vtna_jue_Modif.errorFnacimientoM.isVisible() == false) {
            Singletons.cli.setFnacimiento(JuegoDAO.pideFnacimientoM());
        }
        if (Vtna_jue_Modif.errorDireccionM.isVisible() == false) {
            Singletons.cli.setDireccion(JuegoDAO.pideDireccionM());
        }

        Singletons.cli.setLogin(JuegoDAO.pideLoginM());
        Singletons.cli.setPassword(JuegoDAO.pidePasswordM());
        Singletons.cli.setTipo(JuegoDAO.pideTipoM());

        if (Singletons.PATH_auto != null) {
            Singletons.cli.setAvatar(Singletons.PATH_auto);
        }
        
      //      FileUploader.leer_imag(1);
   //         Singletons.cli.setAvatar(Singletons.PATH_auto);
        

        if ((Vtna_jue_Modif.errorNombreM.isVisible() == false) && (Vtna_jue_Modif.errorApellidosM.isVisible() == false) && (Vtna_jue_Modif.errorTelfM.isVisible() == false)
                && (Vtna_jue_Modif.errorFnacimientoM.isVisible() == false) && (Singletons.efModif.errorPasswordM.isVisible() == false) && (Vtna_jue_Modif.errorDireccionM.isVisible() == false)) {

            Singletons.cliArray.set(Singletons.pos, Singletons.cli);
            JuegoBLL_bd.modificarClienteBLL();
            ((SimpleTableModel_juegos) Singletons.efPager.TABLA.getModel()).cargar();

            Vtna_jue_Modif.btnOKM.setVisible(true);
            Vtna_jue_Modif.etiGuardadoM.setVisible(true);
            JuegoDAO.noEditableM();

        }
    }

    public static int buscar(Juego ef) {//Buscar
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
        int n = ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina_J.currentPageIndex - 1) * pagina_J.itemsPerPage;
            selection = Vtna_jue_Pager.TABLA.getSelectedRow();
            selection1 = inicio + selection;
            if (n == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 0);
            } else {
                nombre = (String) Vtna_jue_Pager.TABLA.getModel().getValueAt(selection1, 1);
                apellido = (String) Vtna_jue_Pager.TABLA.getModel().getValueAt(selection1, 2);
                opc = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar a " + nombre + " " + apellido + "?", "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {
                    ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).removeRow(selection1);
                    JuegoBLL_bd.borrarUsuarioBLL();
                    ((SimpleTableModel_juegos) Singletons.efPager.TABLA.getModel()).cargar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados", "Error!", 0);
        }
    }

    
    public static void InfoPager() {
        imprimir(Singletons.jueArray);
    }

    public static void imprimir(ArrayList<? extends Juego> l) {

        Juego jue;
        String cad = "";
        Iterator<Juego> it = (Iterator<Juego>) l.iterator();
        while (it.hasNext()) {
            jue = it.next();
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
