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
        String dni = Vtna_jue_Crear.txtRef.getText();
        boolean validar;

        if (Vtna_jue_Crear.txtRef.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La referencia no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);

        } else {
            dni = Vtna_jue_Crear.txtRef.getText();
            validar = Validate.validaDireccion(dni);
            if (validar == false) {
                Vtna_jue_Crear.txtRef.requestFocus();
            } else {

                Vtna_jue_Crear.txtNombre.requestFocus();
            }
        }
        return dni;
    }

    //Funcion para pedir Ref  - KEYs
    public static String pideRefKey() {
        String dni = Vtna_jue_Crear.txtRef.getText();
        boolean validar;

        if (dni.isEmpty()) {
            //     Vtna_jue_Crear.etiDniError.setVisible(true);
            Vtna_jue_Crear.errorRef.setVisible(true);
        } else {
            dni = Vtna_jue_Crear.txtRef.getText();
            validar = Validate.validaDireccion(dni);
            if (validar == false) {
                Vtna_jue_Crear.errorRef.setVisible(true);
            } else {

                Vtna_jue_Crear.errorRef.setVisible(false);
            }
        }
        return dni;
    }

    //Funcion para pedir Nombre para crear
    public static String pideNombre() {
        String nombre = Vtna_jue_Crear.txtNombre.getText();

        if (Vtna_jue_Crear.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorNombre.setVisible(true);
        }

        if (Validate.validaDireccion(nombre) != true) {

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

        if (Validate.validaDireccion(nombre) != true) {
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

        if (Validate.validaNombre(nombre) != true) {
            Vtna_jue_Modif.etiNombreErrorM.setVisible(true);
            Vtna_jue_Modif.errorNombreM.setVisible(true);
            Vtna_jue_Modif.txtNombreM.requestFocus();
        } else {
            Vtna_jue_Modif.etiNombreErrorM.setVisible(false);
            Vtna_jue_Modif.errorNombreM.setVisible(false);
            Vtna_jue_Modif.txtApellidosM.requestFocus();
        }

        return nombre;
    }

    //Funcion para pedir Nombre para modificar  -  Keys
    public static String pideNombreKeyM() {
        String nombre = Vtna_jue_Modif.txtNombreM.getText();

        if (Validate.validaNombre(nombre) != true) {
            Vtna_jue_Modif.etiNombreErrorM.setVisible(true);
            Vtna_jue_Modif.errorNombreM.setVisible(true);
        } else {
            Vtna_jue_Modif.etiNombreErrorM.setVisible(false);
            Vtna_jue_Modif.errorNombreM.setVisible(false);
        }

        return nombre;
    }

    //Funcion para pedir Companyia para crear
    public static String pideCompanyia() {
        String apellidos = Vtna_jue_Crear.txtCompanyia.getText();

        if (Vtna_jue_Crear.txtCompanyia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La companyia no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
        }

        if (Validate.validaDireccion(apellidos) != true) {
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
            Vtna_jue_Crear.txtCompanyia.requestFocus();
        } else {
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
            Vtna_jue_Crear.txtTipo.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Companyia para crear   - KEYs
    public static String pideCompanyiaKey() {
        String apellidos = Vtna_jue_Crear.txtCompanyia.getText();

        if (Validate.validaDireccion(apellidos) != true) {
            Vtna_jue_Crear.errorCompanyia.setVisible(true);
        } else {
            Vtna_jue_Crear.errorCompanyia.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para modificar
    public static String pideApellidosM() {
        String apellidos = Vtna_jue_Modif.txtApellidosM.getText();

        if (Vtna_jue_Modif.txtApellidosM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorApellidosM.setVisible(true);
        }

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_jue_Modif.etiApellidoErrorM.setVisible(true);
            Vtna_jue_Modif.errorApellidosM.setVisible(true);
            Vtna_jue_Modif.txtApellidosM.requestFocus();
        } else {
            Vtna_jue_Modif.errorApellidosM.setVisible(false);
            Vtna_jue_Modif.etiApellidoErrorM.setVisible(false);
            Vtna_jue_Modif.txtTelefonoM.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para modificar  - Keys
    public static String pideApellidosKeyM() {
        String apellidos = Vtna_jue_Modif.txtApellidosM.getText();

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_jue_Modif.etiApellidoErrorM.setVisible(true);
            Vtna_jue_Modif.errorApellidosM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorApellidosM.setVisible(false);
            Vtna_jue_Modif.etiApellidoErrorM.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir Tipo para crear
    public static String pideTipo() {
        String telefono = Vtna_jue_Crear.txtTipo.getText();
        if (Vtna_jue_Crear.txtTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorTipo.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_jue_Crear.errorTipo.setVisible(true);
            Vtna_jue_Crear.txtTipo.requestFocus();
        } else {
            Vtna_jue_Crear.errorTipo.setVisible(false);
               Vtna_jue_Crear.txtPrecio.requestFocus();
        }
        return telefono;
    }

    //Funcion para pedir telefono para crear  - KEYs
    public static String pideTipoKey() {
        String telefono = Vtna_jue_Crear.txtTipo.getText();

        if (Validate.validaNombre(telefono) != true) {
            Vtna_jue_Crear.errorTipo.setVisible(true);
        } else {
            Vtna_jue_Crear.errorTipo.setVisible(false);

        }
        return telefono;
    }

    //Funcion para pedir telefono para modificar
    public static String pideTelefonoM() {
        String telefono = Vtna_jue_Modif.txtTelefonoM.getText();

        if (Vtna_jue_Modif.txtTelefonoM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorTelfM.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_jue_Modif.etiTelefonoErrorM.setVisible(true);
            Vtna_jue_Modif.errorTelfM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorTelfM.setVisible(false);
            Vtna_jue_Modif.etiTelefonoErrorM.setVisible(false);
        }
        return telefono;
    }

    //Funcion para pedir telefono para modificar  - Keys
    public static String pideTelefonoKeyM() {

        String telefono = Vtna_jue_Modif.txtTelefonoM.getText();

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_jue_Modif.etiTelefonoErrorM.setVisible(true);
            Vtna_jue_Modif.errorTelfM.setVisible(true);
            Vtna_jue_Modif.txtTelefonoM.requestFocus();
        } else {
            Vtna_jue_Modif.errorTelfM.setVisible(false);
            Vtna_jue_Modif.etiTelefonoErrorM.setVisible(false);
            Vtna_jue_Modif.txtDireccionM.requestFocus();
        }
        return telefono;
    }

    //para pedir Precio para crear
    public static float pidePrecio() {
        float precio = Float.parseFloat(Vtna_jue_Crear.txtPrecio.getText());
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

    //para pedir Precio para crear - KEYs
    public static String pidePrecioKey() {
        String precio = Vtna_jue_Crear.txtPrecio.getText();

        if (Validate.validaNumPositivo(precio) != true) {
             Vtna_jue_Crear.errorPrecio.setVisible(true);
        } else {
            Vtna_jue_Crear.errorPrecio.setVisible(false);
         }
        return precio;
    }

    //para pedir email para modificar
    public static String pideEmailM() {
        String email = Vtna_jue_Modif.txtEmailM.getText();

        if (Vtna_jue_Modif.txtEmailM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El email no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorEmailM.setVisible(true);
        }

        if (Validate.validaEmail(email) != true) {
            Vtna_jue_Modif.etiEmailErrorM.setVisible(true);
            Vtna_jue_Modif.errorEmailM.setVisible(true);
            Vtna_jue_Modif.txtEmailM.requestFocus();
        } else {
            Vtna_jue_Modif.errorEmailM.setVisible(false);
            Vtna_jue_Modif.etiEmailErrorM.setVisible(false);
            Vtna_jue_Modif.txtFnacimientoM.requestFocus();
        }
        return email;
    }

    //para pedir email para modificar - KEYs
    public static String pideEmailKeyM() {
        String email = Vtna_jue_Modif.txtEmailM.getText();

        if (Validate.validaEmail(email) != true) {
            Vtna_jue_Modif.etiEmailErrorM.setVisible(true);
            Vtna_jue_Modif.errorEmailM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorEmailM.setVisible(false);
            Vtna_jue_Modif.etiEmailErrorM.setVisible(false);
        }
        return email;
    }

    //para pedir Descripcion para crear
    public static String pideDescripcion() {
        String direccion = Vtna_jue_Crear.txtDescripcion.getText();

        if (Vtna_jue_Crear.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Crear.errorDescripcion.setVisible(true);
        }

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_jue_Crear.errorDescripcion.setVisible(true);
            Vtna_jue_Crear.txtDescripcion.requestFocus();
        } else {
            Vtna_jue_Crear.errorDescripcion.setVisible(false);
            Vtna_jue_Crear.btnAceptar.requestFocus();
        }
        return direccion;
    }

    //para pedir Descripcion para crear - KEYs
    public static String pideDescripcionKey() {
        String direccion = Vtna_jue_Crear.txtPrecio.getText();

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_jue_Crear.errorDescripcion.setVisible(true);
        } else {
            Vtna_jue_Crear.errorDescripcion.setVisible(false);
        }
        return direccion;
    }

    //para pedir direccion para modificar
    public static String pideDireccionM() {
        String direccion = Vtna_jue_Modif.txtDireccionM.getText();

        if (Vtna_jue_Modif.txtDireccionM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_jue_Modif.errorDireccionM.setVisible(true);
        }

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_jue_Modif.etiDireccionErrorM.setVisible(true);
            Vtna_jue_Modif.errorDireccionM.setVisible(true);
            Vtna_jue_Modif.txtDireccionM.requestFocus();
        } else {
            Vtna_jue_Modif.errorDireccionM.setVisible(false);
            Vtna_jue_Modif.etiDireccionErrorM.setVisible(false);
            Vtna_jue_Modif.txtEmailM.requestFocus();
        }
        return direccion;
    }

    //para pedir direccion para modificar - KEYs
    public static String pideDireccionKeyM() {
        String direccion = Vtna_jue_Modif.txtDireccionM.getText();

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_jue_Modif.etiDireccionErrorM.setVisible(true);
            Vtna_jue_Modif.errorDireccionM.setVisible(true);
        } else {
            Vtna_jue_Modif.errorDireccionM.setVisible(false);
            Vtna_jue_Modif.etiDireccionErrorM.setVisible(false);
        }
        return direccion;
    }

  

    public static void CreaJuego() {

        String ref = "", nombre = "", companyia = "", descripcion = "", tipo = "", imagen = "";
        float precio = 0.0f;
        Fecha fecha_alta = null;

        ref = pideRef();
        nombre = pideNombre();
        companyia = pideCompanyia();
        descripcion = pideDescripcion();  
        precio = pidePrecio();
        tipo = pideTipo();   
        fecha_alta = Fecha.fechaHoy();
        imagen = Singletons.ruta_imagen;
  
        
        if ((Vtna_jue_Crear.errorNombre.isVisible() == false) && (Vtna_jue_Crear.errorRef.isVisible() == false) && (Vtna_jue_Crear.errorCompanyia.isVisible() == false)
                && (Vtna_jue_Crear.errorTipo.isVisible() == false) && (Vtna_jue_Crear.errorPrecio.isVisible() == false) && (Vtna_jue_Crear.errorDescripcion.isVisible() == false)) {

            Singletons.jue = new Juego(ref, nombre, companyia, descripcion, fecha_alta, tipo, precio, imagen);

            Vtna_jue_Crear.btnOK.setVisible(true);
            Vtna_jue_Crear.etiGuardado.setVisible(true);
            noEditable();
        }
    }

    public static void modificar() {

        if (Singletons.cliLog.getTipo().equals("admin")) {
            if (Singletons.cli.getAvatar().isEmpty()) {
                FileUploader.leer_imag_defecto(3);
            } else {
                FileUploader.leer_imag(1);
            }
        }

        Vtna_jue_Modif.txtNombreM.setText((Singletons.cli).getNombre());
        Vtna_jue_Modif.txtApellidosM.setText((Singletons.cli).getApellidos());
        Vtna_jue_Modif.txtTelefonoM.setText((Singletons.cli).getTelefono());
        Vtna_jue_Modif.txtDireccionM.setText((Singletons.cli).getDireccion());
        Vtna_jue_Modif.txtEmailM.setText((Singletons.cli).getEmail());
        ((JTextFieldDateEditor) Vtna_jue_Modif.txtFnacimientoM.getDateEditor()).setText((Singletons.cli).getFnacimiento().aStringFecha());
        Vtna_jue_Modif.txtLoginM.setText((Singletons.cli).getLogin());
        //  Vtna_ef_Cambiar.txtPasswordM.setText((Singletons.emp).getPassword());
    }

    public static void modificarLogeado() {

        if (Singletons.cliLog.getTipo().equals("admin")) {
            if (Singletons.cli.getAvatar().isEmpty()) {
                FileUploader.leer_imag_defecto(3);
            } else {
                FileUploader.leer_imag(1);
            }
        }

        Vtna_jue_Modif.txtNombreM.setText((Singletons.cliLog).getNombre());
        Vtna_jue_Modif.txtApellidosM.setText((Singletons.cliLog).getApellidos());
        Vtna_jue_Modif.txtTelefonoM.setText((Singletons.cliLog).getTelefono());
        Vtna_jue_Modif.txtDireccionM.setText((Singletons.cliLog).getDireccion());
        Vtna_jue_Modif.txtEmailM.setText((Singletons.cliLog).getEmail());
        ((JTextFieldDateEditor) Vtna_jue_Modif.txtFnacimientoM.getDateEditor()).setText((Singletons.cliLog).getFnacimiento().aStringFecha());
        Vtna_jue_Modif.txtLoginM.setText((Singletons.cliLog).getLogin());
        //  Vtna_ef_Cambiar.txtPasswordM.setText((Singletons.emp).getPassword());
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
        Vtna_jue_Crear.etiPrecioError.setVisible(false);

    }

    public static void ocultarErroresModificar() {

        Vtna_jue_Modif.errorNombreM.setVisible(false);
        Vtna_jue_Modif.etiNombreErrorM.setVisible(false);

        Vtna_jue_Modif.errorApellidosM.setVisible(false);
        Vtna_jue_Modif.etiApellidoErrorM.setVisible(false);

        Vtna_jue_Modif.errorTelfM.setVisible(false);
        Vtna_jue_Modif.etiTelefonoErrorM.setVisible(false);

        Vtna_jue_Modif.errorEmailM.setVisible(false);
        Vtna_jue_Modif.etiEmailErrorM.setVisible(false);

        Vtna_jue_Modif.errorDireccionM.setVisible(false);
        Vtna_jue_Modif.etiDireccionErrorM.setVisible(false);

        Vtna_jue_Modif.errorFnacimientoM.setVisible(false);

        Vtna_jue_Modif.btnOKM.setVisible(false);
        Vtna_jue_Modif.etiGuardadoM.setVisible(false);
        Vtna_jue_Modif.errorPasswordM.setVisible(false);

    }

    public static void ocultarErrores() {

        Vtna_jue_Crear.errorNombre.setVisible(false);
        Vtna_jue_Crear.errorCompanyia.setVisible(false);
        Vtna_jue_Crear.errorRef.setVisible(false);
        Vtna_jue_Crear.errorTipo.setVisible(false);
        Vtna_jue_Crear.errorPrecio.setVisible(false);
        Vtna_jue_Crear.errorDescripcion.setVisible(false);
        Vtna_jue_Crear.etiPrecioError.setVisible(false);
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
        Vtna_jue_Modif.txtApellidosM.setEditable(false);
        Vtna_jue_Modif.txtTelefonoM.setEditable(false);
        Vtna_jue_Modif.txtEmailM.setEditable(false);
        Vtna_jue_Modif.txtDireccionM.setEditable(false);
        Vtna_jue_Modif.txtLoginM.setEditable(false);
        Vtna_jue_Modif.txtPasswordM.setEditable(false);
        Vtna_jue_Modif.btnCancelarM.setEnabled(false);
        Vtna_jue_Modif.btnAceptarM.setEnabled(false);
        ((JTextFieldDateEditor) Vtna_jue_Modif.txtFnacimientoM.getDateEditor()).setEditable(false);
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

    public static int BuscarEmpleados(Juego cli) {//Buscar
        int aux = -1;

        for (int i = 0; i <= (Singletons.cliArray.size() - 1); i++) {
            if ((Singletons.cliArray.get(i)).equals(cli))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
            {
                aux = i;
            }
        }
        return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
    }
}
