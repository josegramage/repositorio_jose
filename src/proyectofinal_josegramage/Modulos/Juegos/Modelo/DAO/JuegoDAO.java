package proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO;

import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JOptionPane;

import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Clases.FileUploader;
import proyectofinal_josegramage.Clases.JavaMail;
import proyectofinal_josegramage.Librerias.Encriptador;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Librerias.Validate;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Clases.DAOgenericoJ;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL.JuegoBLL;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Crear;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Modif;

public class JuegoDAO {

    //Funcion para pedir Ref
    public static String pideRef() {
        String ref = Vtna_jue_Crear.txtRef.getText();
        boolean validar;

        if (Vtna_jue_Crear.txtRef.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La referencia no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.jueCrear.errorRef.setVisible(true);
        } else {
            ref = Vtna_jue_Crear.txtRef.getText();
            validar = Validate.validaNomNum(ref);
            if (validar == false) {
                Vtna_jue_Crear.txtRef.requestFocus();
                Singletons.jueCrear.errorRef.setVisible(true);
            } else {
                Vtna_jue_Crear.txtNombre.requestFocus();
                Singletons.jueCrear.errorRef.setVisible(false);
            }
         }
        return ref;
    }

    //Funcion para pedir Ref  - KEYs
    public static String pideRefKey() {
        String ref = Vtna_jue_Crear.txtRef.getText();
        boolean validar;

        if (ref.isEmpty()) {
            Vtna_jue_Crear.errorRef.setVisible(true);
        } else {
            ref = Vtna_jue_Crear.txtRef.getText();
            validar = Validate.validaNomNum(ref);
            if (validar == false) {
                Vtna_jue_Crear.errorRef.setVisible(true);
            } else {

                Vtna_jue_Crear.errorRef.setVisible(false);
            }
        }
        return ref;
    }

    //Funcion para pedir Nombre para crear
    public static String pideNombre() {
        String nombre = Vtna_jue_Crear.txtNombre.getText();

        if (Vtna_jue_Crear.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorNombre.setVisible(true);
        }

        if (Validate.validaNomNum(nombre) != true) {

            Vtna_jue_Crear.txtNombre.requestFocus();
            Vtna_jue_Crear.errorNombre.setVisible(true);
        } else {
            Vtna_jue_Crear.errorNombre.setVisible(false);
            Vtna_jue_Crear.txtCompanyia.requestFocus();
        }
        return nombre;
    }

    //Funcion para pedir Nombre para crear -KEYs
    public static String pideNombreKey() {
        String nombre = Vtna_jue_Crear.txtNombre.getText();
         if (Vtna_jue_Crear.txtNombre.getText().isEmpty()) {
             Vtna_jue_Crear.errorNombre.setVisible(true);
        }

        if (Validate.validaNomNum(nombre) != true) {
            Vtna_jue_Crear.errorNombre.setVisible(true);
        } else {
            Vtna_jue_Crear.errorNombre.setVisible(false);

        }
        return nombre;
    }

    //Funcion para pedir Nombre para modificar
    public static String pideNombreM() {
        String nombre = Vtna_jue_Modif.txtNombreM.getText();

        if (Vtna_jue_Modif.txtNombreM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorNombreM.setVisible(true);
        }

        if (Validate.validaNomNum(nombre) != true) {
            Vtna_jue_Modif.errorNombreM.setVisible(true);
            Vtna_jue_Modif.txtNombreM.requestFocus();
        } else {
            Vtna_jue_Modif.errorNombreM.setVisible(false);
            Vtna_jue_Modif.txtCompanyiaM.requestFocus();
        }

        return nombre;
    }

    //Funcion para pedir Nombre para modificar  -  Keys
    public static String pideNombreKeyM() {
        String nombre = Vtna_jue_Modif.txtNombreM.getText();

        if (Validate.validaNomNum(nombre) != true) {
            Vtna_jue_Modif.errorNombreM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorNombreM.setVisible(false);
        }
        return nombre;
    }

    //Funcion para pedir Companyia para crear
    public static String pideCompanyia() {
        String companyia = Vtna_jue_Crear.txtCompanyia.getText();

        if (Vtna_jue_Crear.txtCompanyia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La companyia no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
        }

        if (Validate.validaNomNum(companyia) != true) {
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
            Vtna_jue_Crear.txtCompanyia.requestFocus();
        } else {
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
            Vtna_jue_Crear.txtTipo.requestFocus();
        }
        return companyia;
    }

    //Funcion para pedir Companyia para crear   - KEYs
    public static String pideCompanyiaKey() {
        String companyia = Vtna_jue_Crear.txtCompanyia.getText();
        if (Vtna_jue_Crear.txtCompanyia.getText().isEmpty()) {
           Vtna_jue_Crear.errorCompanyia.setVisible(true);
        }

        if (Validate.validaNomNum(companyia) != true) {
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
        } else {
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
        }
        return companyia;
    }

    //Funcion para pedir Companyia para modificar
    public static String pideCompanyiaM() {
        String companyia = Vtna_jue_Modif.txtCompanyiaM.getText();

        if (Vtna_jue_Modif.txtCompanyiaM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La companyia no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorCompanyiaM.setVisible(true);
        }

        if (Validate.validaNomNum(companyia) != true) {
            Vtna_jue_Modif.errorCompanyiaM.setVisible(true);
            Vtna_jue_Modif.txtCompanyiaM.requestFocus();
        } else {
            Vtna_jue_Modif.errorCompanyiaM.setVisible(false);
            Vtna_jue_Modif.txtTipoM.requestFocus();
        }
        return companyia;
    }

    //Funcion para pedir Companyia para modificar  - Keys
    public static String pideCompanyiaKeyM() {
        String companyia = Vtna_jue_Modif.txtCompanyiaM.getText();

        if (Validate.validaNomNum(companyia) != true) {
            Vtna_jue_Modif.errorCompanyiaM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorCompanyiaM.setVisible(false);
           }
        return companyia;
    }

    //Funcion para pedir Tipo para crear
    public static String pideTipo() {
        String tipo = Vtna_jue_Crear.txtTipo.getText();
        if (Vtna_jue_Crear.txtTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo de juego no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorTipo.setVisible(true);
        }

        if (Validate.validaNomNum(tipo) != true) {
            Vtna_jue_Crear.errorTipo.setVisible(true);
            Vtna_jue_Crear.txtTipo.requestFocus();
        } else {
            Vtna_jue_Crear.errorTipo.setVisible(false);
               Vtna_jue_Crear.txtPrecio.requestFocus();
        }
        return tipo;
    }

    //Funcion para pedir TIPO para crear  - KEYs
    public static String pideTipoKey() {
        String tipo = Vtna_jue_Crear.txtTipo.getText();

        if (Validate.validaNomNum(tipo) != true) {
            Vtna_jue_Crear.errorTipo.setVisible(true);
        } else {
            Vtna_jue_Crear.errorTipo.setVisible(false);

        }
        return tipo;
    }

    //Funcion para pedir Tipo para modificar
    public static String pideTipoM() {
        String tipo = Vtna_jue_Modif.txtTipoM.getText();

        if (Vtna_jue_Modif.txtTipoM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorTipoM.setVisible(true);
        }

        if (Validate.validaNomNum(tipo) != true) {
            Vtna_jue_Modif.errorTipoM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorTipoM.setVisible(false);
            }
        return tipo;
    }

    //Funcion para pedir Tipo para modificar  - Keys
    public static String pideTipoKeyM() {

        String tipo = Vtna_jue_Modif.txtTipoM.getText();

        if (Validate.validaNomNum(tipo) != true) {
            Vtna_jue_Modif.errorTipoM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorTipoM.setVisible(false);
        }
        return tipo;
    }

    //para pedir Precio para crear
 /*   public static float pidePrecio() {
        float precio = Float.parseFloat(Vtna_jue_Crear.txtPrecio.getText());
    //    float precio = ((Juego)).setPrecio(Float.parseFloat(value.toString()));
     //   String precio = Vtna_jue_Crear.txtPrecio.getText();

        if (Vtna_jue_Crear.txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El precio no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorPrecio.setVisible(true);
        }

        if (Validate.validaNumPositivo(String.valueOf(precio)) != true) {
            Vtna_jue_Crear.errorPrecio.setVisible(true);
            Vtna_jue_Crear.txtPrecio.requestFocus();
        } else {
            Vtna_jue_Crear.errorPrecio.setVisible(false);
            Vtna_jue_Crear.txtDescripcion.requestFocus();
        }
        return precio;
    }
*/
    /*
    //para pedir Precio para crear - KEYs
    public static float pidePrecioKey() {
       // JOptionPane.showMessageDialog(null,Vtna_jue_Crear.txtPrecio.getText());
        float precio = Float.parseFloat(Vtna_jue_Crear.txtPrecio.getText());
      //  float precio = Vtna_jue_Crear.txtPrecio.getText();
//float precio=0.0f;
        
        if (Validate.validaNumPositivo(Vtna_jue_Crear.txtPrecio.getText()) != true) {
             Vtna_jue_Crear.errorPrecio.setVisible(true);
        } else {
            Vtna_jue_Crear.errorPrecio.setVisible(false);
         }
        return precio;
    }
    */
    
     //para pedir Precio para crear
      public static String pidePrecio() {
        String precio = Vtna_jue_Crear.txtPrecio.getText();
   
        if (Vtna_jue_Crear.txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El precio no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.txtPrecio.requestFocus();
            Vtna_jue_Crear.errorPrecio.setVisible(true);
        }

        if (Validate.validaNumPositivo(precio) != true) {
            Vtna_jue_Crear.errorPrecio.setVisible(true);
            Vtna_jue_Crear.txtPrecio.requestFocus();
        } else {
            Vtna_jue_Crear.errorPrecio.setVisible(false);
            Vtna_jue_Crear.txtDescripcion.requestFocus();
        }
        return precio;
      }
        
     public static String pidePrecioKey() {
      
        String precio = Vtna_jue_Crear.txtPrecio.getText();
        
        if (Validate.validaNumPositivo(precio) != true) {
             Vtna_jue_Crear.errorPrecio.setVisible(true);
             Vtna_jue_Crear.txtPrecio.requestFocus();
        } else {
            Vtna_jue_Crear.errorPrecio.setVisible(false);
         }
        return precio;
    }

    //para pedir Precio para modificar
    public static String pidePrecioM() {
        String precio = Vtna_jue_Modif.txtPrecioM.getText();

        if (Vtna_jue_Modif.txtPrecioM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El precio no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorPrecioM.setVisible(true);
        }

         if (Validate.validaNumPositivo(String.valueOf(precio)) != true) {
            Vtna_jue_Modif.errorPrecioM.setVisible(true);
            Vtna_jue_Modif.txtPrecioM.requestFocus();
        } else {
            Vtna_jue_Modif.errorPrecioM.setVisible(false);
            Vtna_jue_Modif.txtDescripcionM.requestFocus();
        }
        return precio;
    }

    //para pedir email para modificar - KEYs
    public static String pidePrecioKeyM() {
        String precio = Vtna_jue_Modif.txtPrecioM.getText();

        if (Validate.validaNumPositivo(String.valueOf(precio)) != true) {
            Vtna_jue_Modif.errorPrecioM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorPrecioM.setVisible(false);  
        }
        return precio;
    }

    //para pedir Descripcion para crear
    public static String pideDescripcion() {
        String direccion = Vtna_jue_Crear.txtDescripcion.getText();
        return direccion;
    }

    //para pedir Descripcion para crear - KEYs
    public static String pideDescripcionKey() {
        String descripcion = Vtna_jue_Crear.txtDescripcion.getText();
        return descripcion;
    }

    //para pedir Descripcion para modificar
    public static String pideDescripcionM() {
        String descripcion = Vtna_jue_Modif.txtDescripcionM.getText();
        return descripcion;
    }

    //para pedir Descripcion para modificar - KEYs
    public static String pideDescripcionKeyM() {
        String descripcion = Vtna_jue_Modif.txtDescripcionM.getText();
        return descripcion;
    }

    public static void CreaJuego() {

        String ref = "", nombre = "", companyia = "", descripcion = "", precio="", tipo = "", imagen = "";
        Fecha fecha_alta = null;

        ref = pideRef();
        nombre = pideNombre();
        companyia = pideCompanyia();
        descripcion = pideDescripcion();  
        precio = pidePrecio();
        tipo = pideTipo();   
        fecha_alta = Fecha.fechaHoy();
                  
        if ((Vtna_jue_Crear.errorNombre.isVisible() == false) && (Vtna_jue_Crear.errorRef.isVisible() == false) && (Vtna_jue_Crear.errorCompanyia.isVisible() == false)
                && (Vtna_jue_Crear.errorTipo.isVisible() == false) && (Vtna_jue_Crear.errorPrecio.isVisible() == false) && (Vtna_jue_Crear.errorDescripcion.isVisible() == false)) {

            Singletons.jue = new Juego(ref, nombre, companyia, fecha_alta, tipo, precio, imagen, descripcion);

            Vtna_jue_Crear.btnOK.setVisible(true);
            Vtna_jue_Crear.etiGuardado.setVisible(true);
            noEditable();
        }
    }

    public static void modificarJuego() {
   
            if (Singletons.jue.getImagen().isEmpty()) {
                FileUploader.leer_img_defecto_J(1);
            } else {
                FileUploader.leer_img_juego(0);
            }   

        Vtna_jue_Modif.txtNombreM.setText((Singletons.jue).getNombre());
        Vtna_jue_Modif.txtCompanyiaM.setText((Singletons.jue).getCompanyia());
        Vtna_jue_Modif.txtTipoM.setText((Singletons.jue).getTipo());
        Vtna_jue_Modif.txtPrecioM.setText(String.valueOf((Singletons.jue).getPrecio()));
        Vtna_jue_Modif.txtDescripcionM.setText((Singletons.jue).getDescripcion());   
    }

  
    public static void limpiar() {

        Vtna_jue_Crear.txtRef.setText("");
        Vtna_jue_Crear.txtNombre.setText("");
        Vtna_jue_Crear.txtCompanyia.setText("");
        Vtna_jue_Crear.txtTipo.setText("");
        Vtna_jue_Crear.txtPrecio.setText("");
        Vtna_jue_Crear.btnOK.setVisible(false);
        Vtna_jue_Crear.etiGuardado.setVisible(false);
        Vtna_jue_Crear.errorNombre.setVisible(false);
        Vtna_jue_Crear.errorCompanyia.setVisible(false);
        Vtna_jue_Crear.errorRef.setVisible(false);
        Vtna_jue_Crear.errorTipo.setVisible(false);
        Vtna_jue_Crear.errorPrecio.setVisible(false);
        Vtna_jue_Crear.errorDescripcion.setVisible(false);
    }

    public static void ocultarErroresModificar() {

        Vtna_jue_Modif.errorNombreM.setVisible(false);
        Vtna_jue_Modif.errorCompanyiaM.setVisible(false);
        Vtna_jue_Modif.errorTipoM.setVisible(false);
        Vtna_jue_Modif.errorDescripcionM.setVisible(false);
        Vtna_jue_Modif.errorPrecioM.setVisible(false);
        Vtna_jue_Modif.btnOKM.setVisible(false);
        Vtna_jue_Modif.etiGuardadoM.setVisible(false);
    }

    public static void ocultarErrores() {

        Vtna_jue_Crear.errorNombre.setVisible(false);
        Vtna_jue_Crear.errorCompanyia.setVisible(false);
        Vtna_jue_Crear.errorRef.setVisible(false);
        Vtna_jue_Crear.errorTipo.setVisible(false);
        Vtna_jue_Crear.errorPrecio.setVisible(false);
        Vtna_jue_Crear.errorDescripcion.setVisible(false);
        Vtna_jue_Crear.btnOK.setVisible(false);
        Vtna_jue_Crear.etiGuardado.setVisible(false);
    }

    public static void editable() {

        Vtna_jue_Crear.txtNombre.setEditable(true);
        Vtna_jue_Crear.txtCompanyia.setEditable(true);
        Vtna_jue_Crear.txtRef.setEditable(true);
        Vtna_jue_Crear.txtTipo.setEditable(true);
        Vtna_jue_Crear.txtPrecio.setEditable(true);
        Vtna_jue_Crear.btnCancelar.setEnabled(true);
        Vtna_jue_Crear.btnAceptar.setEnabled(true);
    }

    public static void noEditable() {

        Vtna_jue_Crear.txtNombre.setEditable(false);
        Vtna_jue_Crear.txtCompanyia.setEditable(false);
        Vtna_jue_Crear.txtRef.setEditable(false);
        Vtna_jue_Crear.txtTipo.setEditable(false);
        Vtna_jue_Crear.txtPrecio.setEditable(false);
        Vtna_jue_Crear.btnCancelar.setEnabled(false);
        Vtna_jue_Crear.btnAceptar.setEnabled(false);
        }

    public static void noEditableM() {

        Vtna_jue_Modif.txtNombreM.setEditable(false);
        Vtna_jue_Modif.txtCompanyiaM.setEditable(false);
        Vtna_jue_Modif.txtTipoM.setEditable(false);
        Vtna_jue_Modif.txtPrecioM.setEditable(false);
        Vtna_jue_Modif.btnCancelarM.setEnabled(false);
        Vtna_jue_Modif.btnAceptarM.setEnabled(false);
    }

    public static Juego pideRefvacio(String refmatch) {
        Singletons.jue = null;
        String ref;

        do {
            ref = refmatch;
        } while (Validate.validaDireccion(ref) == false);

        Singletons.jue = new Juego(ref);

        return Singletons.jue;
    }

    public static int BuscarJuegos(Juego jue) {//Buscar
        int aux = -1;
        for (int i = 0; i <= (Singletons.jueArray.size() - 1); i++) {
            if ((Singletons.jueArray.get(i)).equals(jue))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
            {
                aux = i;
            }
        }
        return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
    }
}
