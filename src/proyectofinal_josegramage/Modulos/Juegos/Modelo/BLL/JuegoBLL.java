package proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL;

import proyectofinal_josegramage.Utiles.FileUploader;
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
import javax.swing.JPanel;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Controlador.Controlador_Juegos;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO.JuegoDAO;

public class JuegoBLL {

    public static void pideNombre() {
        JuegoDAO.pideNombre();
    }

    public static void pideNombreKey() {
        JuegoDAO.pideNombreKey();
    }

    public static void pideCompanyia() {
        JuegoDAO.pideCompanyia();
    }

    public static void pideCompanyiaKey() {
        JuegoDAO.pideCompanyiaKey();
    }

    // para que no repita el dni
    public static void pideRef() {
        int pos = 0;
        Juego e = new Juego(JuegoDAO.pideRef());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            Vtna_jue_Crear.errorRef.setVisible(true);
        } else {
            Vtna_jue_Crear.errorRef.setVisible(false);
        }
    }

    public static void pideRefKey() {
        int pos = 0;
        Juego e = new Juego(JuegoDAO.pideRefKey());
        pos = buscar(e);

        if (pos != -1) {
            Vtna_jue_Crear.errorRef.setVisible(true);
        } else {
            Vtna_jue_Crear.errorRef.setVisible(false);
        }
    }

    public static void pideRefKey2() {
        JuegoDAO.pideRefKey();
    }

    public static void pideTipo() {
        JuegoDAO.pideTipo();
    }

    public static void pideTipoKey() {
        JuegoDAO.pideTipoKey();
    }

    public static void pidePrecio() {
        JuegoDAO.pidePrecio();
    }

    public static void pidePrecioKey() {
        JuegoDAO.pidePrecioKey();
    }

    public static void pideDescripcion() {
        JuegoDAO.pideDescripcion();
    }

    public static void pideDescripcionKey() {
        JuegoDAO.pideDescripcionKey();
    }

    public static void crearJuego() {

        JuegoDAO.CreaJuego();

        if (Singletons.jue.getFecha_alta() != null) {
            Singletons.jueArray.add(Singletons.jue);
            JuegoBLL_bd.nuevoJuegoBLL();
            //     ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();
            new Controlador_Juegos(new Vtna_jue_Pager(), 0).iniciar(0);
            Singletons.jueCrear.dispose();
            JPanel panelPager = new JPanel();
            panelPager.add(Singletons.juePager.panelPager);
            Singletons.ini.internalFrame.setContentPane(panelPager);
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

    public static void pideCompanyiaM() {
        JuegoDAO.pideCompanyiaM();
    }

    public static void pideCompanyiaKeyM() {
        JuegoDAO.pideCompanyiaKeyM();
    }

    public static void pideTipoM() {
        JuegoDAO.pideTipoM();
    }

    public static void pideTipoKeyM() {
        JuegoDAO.pideTipoKeyM();
    }

    public static void pidePrecioM() {
        JuegoDAO.pidePrecioM();
    }

    public static void pidePrecioKeyM() {
        JuegoDAO.pidePrecioKeyM();
    }

    public static void pideDescripcionM() {
        JuegoDAO.pideDescripcionM();
    }

    public static void pideDescripcionKeyM() {
        JuegoDAO.pideDescripcionKeyM();
    }

    public static void ocultaErrorM() {
        JuegoDAO.ocultarErroresModificar();
    }

    public static void modificar() {
        JuegoDAO.modificarJuego();
    }

    public static void ModificarPagerJuegos() {

        if (Vtna_jue_Modif.errorNombreM.isVisible() == false) {
            Singletons.jue.setNombre(JuegoDAO.pideNombreM());
        }
        if (Vtna_jue_Modif.errorCompanyiaM.isVisible() == false) {
            Singletons.jue.setCompanyia(JuegoDAO.pideCompanyiaM());
        }
        if (Vtna_jue_Modif.errorTipoM.isVisible() == false) {
            Singletons.jue.setTipo(JuegoDAO.pideTipoM());
        }
        if (Vtna_jue_Modif.errorDescripcionM.isVisible() == false) {
            Singletons.jue.setDescripcion(JuegoDAO.pideDescripcionM());
        }
        if (Vtna_jue_Modif.errorPrecioM.isVisible() == false) {
            Singletons.jue.setPrecio(JuegoDAO.pidePrecioM());
        }

        if (Singletons.jue.getImagen().isEmpty()) {
            Singletons.jue.setImagen(Singletons.PATH_auto_Img);
        }

        if ((Vtna_jue_Modif.errorNombreM.isVisible() == false) && (Vtna_jue_Modif.errorCompanyiaM.isVisible() == false) && (Vtna_jue_Modif.errorTipoM.isVisible() == false)
                && (Vtna_jue_Modif.errorPrecioM.isVisible() == false)) {

            Singletons.jueArray.set(Singletons.posJ, Singletons.jue);
            JuegoBLL_bd.modificarJuegoBLL();
            ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();
        }
    }

    public static int buscar(Juego jue) {//Buscar
        int aux = -1;

        for (int i = 0; i <= (Singletons.jueArray.size() - 1); i++) {
            if ((Singletons.jueArray.get(i)).equals(jue)) {
                aux = i;
            }
        }
        return aux;
    }

    public static void btnEliminarPager() {
        String nombre = "", companyia = "";
        int opc, inicio, selection, selection1;
        int n = ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina_J.currentPageIndex - 1) * pagina_J.itemsPerPageJ;
            selection = Vtna_jue_Pager.TABLA.getSelectedRow();
            selection1 = inicio + selection;
            if (n == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 0);
            } else {
                nombre = (String) Vtna_jue_Pager.TABLA.getModel().getValueAt(selection1, 1);
                companyia = (String) Vtna_jue_Pager.TABLA.getModel().getValueAt(selection1, 2);
                opc = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar a " + nombre + " de " + companyia + "?", "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {
                    ((SimpleTableModel_juegos) Vtna_jue_Pager.TABLA.getModel()).removeRow(selection1);
                    JuegoBLL_bd.borrarJuegoBLL();
                    ((SimpleTableModel_juegos) Singletons.juePager.TABLA.getModel()).cargar();
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
            cad = Singletons.jue + "\n" + "\n";
        }
        JOptionPane.showMessageDialog(null, cad);
    }

    public static void guardar() {//Guardar en el formato elegido por el usuario previamente en configuracion
        if (Singletons.jueArray.size() != 0) {

            if (Main.conf.getGuardar() == "1") {
                proyectofinal_josegramage.Librerias.Json.guardarJSON();//Genera un archivo json con todos los datos del Arraylist de empleados fijos
            } else if (Main.conf.getGuardar() == "2") {
                proyectofinal_josegramage.Librerias.Txt.guardarTXTjuego();//Lo mismo que antes pero con un txt
            } else if (Main.conf.getGuardar() == "3") {
                proyectofinal_josegramage.Librerias.Xml.guardarXMLjuego();//�dem pero para un xml
            }
        } else {
            JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
