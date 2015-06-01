package proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO;

import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JOptionPane;

import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Utiles.FileUploader;
import proyectofinal_josegramage.Librerias.Encriptador;
import proyectofinal_josegramage.Librerias.Validate;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.DAOgenerico;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;

public class ClienteDAO {

    //Funcion para pedir Nombre para crear
    public static String pideNombre() {
        String nombre = Vtna_cli_Crear.txtNombre.getText();

        if (Vtna_cli_Crear.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorNombre.setVisible(true);
        }

        if (Validate.validaNombre(nombre) != true) {
            Vtna_cli_Crear.etiNombreError.setVisible(true);
            Vtna_cli_Crear.errorNombre.setVisible(true);
            Vtna_cli_Crear.txtNombre.requestFocus();

        } else {
            Vtna_cli_Crear.etiNombreError.setVisible(false);
            Vtna_cli_Crear.errorNombre.setVisible(false);
            Vtna_cli_Crear.txtApellidos.requestFocus();
        }
        return nombre;
    }

    //Funcion para pedir Nombre para crear -KEYs
    public static String pideNombreKey() {
        String nombre = Vtna_cli_Crear.txtNombre.getText();

        if (Validate.validaNombre(nombre) != true) {
            Vtna_cli_Crear.etiNombreError.setVisible(true);
            Vtna_cli_Crear.errorNombre.setVisible(true);
        } else {
            Vtna_cli_Crear.etiNombreError.setVisible(false);
            Vtna_cli_Crear.errorNombre.setVisible(false);
        }
        return nombre;
    }

    //Funcion para pedir Nombre para modificar
    public static String pideNombreM() {
        String nombre = Vtna_cli_Modif.txtNombreM.getText();

        if (Vtna_cli_Modif.txtNombreM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorNombreM.setVisible(true);
        }

        if (Validate.validaNombre(nombre) != true) {
            Vtna_cli_Modif.etiNombreErrorM.setVisible(true);
            Vtna_cli_Modif.errorNombreM.setVisible(true);
            Vtna_cli_Modif.txtNombreM.requestFocus();
        } else {
            Vtna_cli_Modif.etiNombreErrorM.setVisible(false);
            Vtna_cli_Modif.errorNombreM.setVisible(false);
            Vtna_cli_Modif.txtApellidosM.requestFocus();
        }
        return nombre;
    }

    //Funcion para pedir Nombre para modificar  -  Keys
    public static String pideNombreKeyM() {
        String nombre = Vtna_cli_Modif.txtNombreM.getText();

        if (Validate.validaNombre(nombre) != true) {
            Vtna_cli_Modif.etiNombreErrorM.setVisible(true);
            Vtna_cli_Modif.errorNombreM.setVisible(true);
        } else {
            Vtna_cli_Modif.etiNombreErrorM.setVisible(false);
            Vtna_cli_Modif.errorNombreM.setVisible(false);
        }
        return nombre;
    }

    //Funcion para pedir Apellidos para crear
    public static String pideApellidos() {
        String apellidos = Vtna_cli_Crear.txtApellidos.getText();

        if (Vtna_cli_Crear.txtApellidos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorApellidos.setVisible(true);
        }

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_cli_Crear.etiApellidoError.setVisible(true);
            Vtna_cli_Crear.errorApellidos.setVisible(true);
            Vtna_cli_Crear.txtApellidos.requestFocus();
        } else {
            Vtna_cli_Crear.errorApellidos.setVisible(false);
            Vtna_cli_Crear.etiApellidoError.setVisible(false);
            Vtna_cli_Crear.txtDni.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para crear   - KEYs
    public static String pideApellidosKey() {
        String apellidos = Vtna_cli_Crear.txtApellidos.getText();

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_cli_Crear.etiApellidoError.setVisible(true);
            Vtna_cli_Crear.errorApellidos.setVisible(true);
        } else {
            Vtna_cli_Crear.errorApellidos.setVisible(false);
            Vtna_cli_Crear.etiApellidoError.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para modificar
    public static String pideApellidosM() {
        String apellidos = Vtna_cli_Modif.txtApellidosM.getText();

        if (Vtna_cli_Modif.txtApellidosM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorApellidosM.setVisible(true);
        }

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_cli_Modif.etiApellidoErrorM.setVisible(true);
            Vtna_cli_Modif.errorApellidosM.setVisible(true);
            Vtna_cli_Modif.txtApellidosM.requestFocus();
        } else {
            Vtna_cli_Modif.errorApellidosM.setVisible(false);
            Vtna_cli_Modif.etiApellidoErrorM.setVisible(false);
            Vtna_cli_Modif.txtTelefonoM.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para modificar  - Keys
    public static String pideApellidosKeyM() {
        String apellidos = Vtna_cli_Modif.txtApellidosM.getText();

        if (Validate.validaApellido(apellidos) != true) {
            Vtna_cli_Modif.etiApellidoErrorM.setVisible(true);
            Vtna_cli_Modif.errorApellidosM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorApellidosM.setVisible(false);
            Vtna_cli_Modif.etiApellidoErrorM.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir Dni
    public static String pideDni() {
        String dni = Vtna_cli_Crear.txtDni.getText();
        boolean validar;

        if (Vtna_cli_Crear.txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DNI no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorDni.setVisible(true);
            Vtna_cli_Crear.etiDniError.setVisible(true);
        } else {
            dni = Vtna_cli_Crear.txtDni.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                Vtna_cli_Crear.txtDni.requestFocus();
                Vtna_cli_Crear.etiDniError.setVisible(true);
                Vtna_cli_Crear.errorDni.setVisible(true);
            } else {
                Vtna_cli_Crear.etiDniError.setVisible(false);
                Vtna_cli_Crear.errorDni.setVisible(false);
                Vtna_cli_Crear.txtTelefono.requestFocus();
            }
        }
        return dni;
    }

    //Funcion para pedir Dni  - KEYs
    public static String pideDniKey() {
        String dni = Vtna_cli_Crear.txtDni.getText();
        boolean validar;

        if (dni.isEmpty()) {
            Vtna_cli_Crear.errorDni.setVisible(true);
        } else {
            dni = Vtna_cli_Crear.txtDni.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                Vtna_cli_Crear.etiDniError.setVisible(true);
                Vtna_cli_Crear.errorDni.setVisible(true);
            } else {
                Vtna_cli_Crear.etiDniError.setVisible(false);
                Vtna_cli_Crear.errorDni.setVisible(false);
            }
        }
        return dni;
    }

    //Funcion para pedir telefono para crear
    public static String pideTelefono() {
        String telefono = Vtna_cli_Crear.txtTelefono.getText();
        if (Vtna_cli_Crear.txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorTelf.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_cli_Crear.etiTelefonoError.setVisible(true);
            Vtna_cli_Crear.errorTelf.setVisible(true);
            Vtna_cli_Crear.txtTelefono.requestFocus();
        } else {
            Vtna_cli_Crear.errorTelf.setVisible(false);
            Vtna_cli_Crear.etiTelefonoError.setVisible(false);
            Vtna_cli_Crear.txtDireccion.requestFocus();
        }
        return telefono;
    }

    //Funcion para pedir telefono para crear  - KEYs
    public static String pideTelefonoKey() {
        String telefono = Vtna_cli_Crear.txtTelefono.getText();

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_cli_Crear.etiTelefonoError.setVisible(true);
            Vtna_cli_Crear.errorTelf.setVisible(true);
        } else {
            Vtna_cli_Crear.errorTelf.setVisible(false);
            Vtna_cli_Crear.etiTelefonoError.setVisible(false);
        }
        return telefono;
    }

    //Funcion para pedir telefono para modificar
    public static String pideTelefonoM() {
        String telefono = Vtna_cli_Modif.txtTelefonoM.getText();

        if (Vtna_cli_Modif.txtTelefonoM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorTelfM.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_cli_Modif.etiTelefonoErrorM.setVisible(true);
            Vtna_cli_Modif.errorTelfM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorTelfM.setVisible(false);
            Vtna_cli_Modif.etiTelefonoErrorM.setVisible(false);
        }
        return telefono;
    }

    //Funcion para pedir telefono para modificar  - Keys
    public static String pideTelefonoKeyM() {

        String telefono = Vtna_cli_Modif.txtTelefonoM.getText();

        if (Validate.validaNumTelefono(telefono) != true) {
            Vtna_cli_Modif.etiTelefonoErrorM.setVisible(true);
            Vtna_cli_Modif.errorTelfM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorTelfM.setVisible(false);
            Vtna_cli_Modif.etiTelefonoErrorM.setVisible(false);
        }
        return telefono;
    }

    //para pedir email para crear
    public static String pideEmail() {
        String email = Vtna_cli_Crear.txtEmail.getText();

        if (Vtna_cli_Crear.txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El email no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorEmail.setVisible(true);
        }

        if (Validate.validaEmail(email) != true) {
            Vtna_cli_Crear.etiEmailError.setVisible(true);
            Vtna_cli_Crear.errorEmail.setVisible(true);
            Vtna_cli_Crear.txtEmail.requestFocus();
        } else {
            Vtna_cli_Crear.errorEmail.setVisible(false);
            Vtna_cli_Crear.etiEmailError.setVisible(false);
            Vtna_cli_Crear.txtFnacimiento.requestFocus();
        }
        return email;
    }

    //para pedir email para crear - KEYs
    public static String pideEmailKey() {
        String email = Vtna_cli_Crear.txtEmail.getText();

        if (Validate.validaEmail(email) != true) {
            Vtna_cli_Crear.etiEmailError.setVisible(true);
            Vtna_cli_Crear.errorEmail.setVisible(true);
        } else {
            Vtna_cli_Crear.errorEmail.setVisible(false);
            Vtna_cli_Crear.etiEmailError.setVisible(false);
        }
        return email;
    }

    //para pedir email para modificar
    public static String pideEmailM() {
        String email = Vtna_cli_Modif.txtEmailM.getText();

        if (Vtna_cli_Modif.txtEmailM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El email no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorEmailM.setVisible(true);
        }

        if (Validate.validaEmail(email) != true) {
            Vtna_cli_Modif.etiEmailErrorM.setVisible(true);
            Vtna_cli_Modif.errorEmailM.setVisible(true);
            Vtna_cli_Modif.txtEmailM.requestFocus();
        } else {
            Vtna_cli_Modif.errorEmailM.setVisible(false);
            Vtna_cli_Modif.etiEmailErrorM.setVisible(false);
            Vtna_cli_Modif.txtFnacimientoM.requestFocus();
        }
        return email;
    }

    //para pedir email para modificar - KEYs
    public static String pideEmailKeyM() {
        String email = Vtna_cli_Modif.txtEmailM.getText();

        if (Validate.validaEmail(email) != true) {
            Vtna_cli_Modif.etiEmailErrorM.setVisible(true);
            Vtna_cli_Modif.errorEmailM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorEmailM.setVisible(false);
            Vtna_cli_Modif.etiEmailErrorM.setVisible(false);
        }
        return email;
    }

    //para pedir direccion para crear
    public static String pideDireccion() {
        String direccion = Vtna_cli_Crear.txtDireccion.getText();

        if (Vtna_cli_Crear.txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.etiDireccionError.setVisible(true);
            Vtna_cli_Crear.errorDireccion.setVisible(true);
            Vtna_cli_Crear.txtDireccion.requestFocus();
        } else {
            Vtna_cli_Crear.errorDireccion.setVisible(false);
            Vtna_cli_Crear.etiDireccionError.setVisible(false);
            Vtna_cli_Crear.txtEmail.requestFocus();
        }
        return direccion;
    }

    //para pedir direccion para crear - KEYs
    public static String pideDireccionKey() {
        String direccion = Vtna_cli_Crear.txtDireccion.getText();

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_cli_Crear.etiDireccionError.setVisible(true);
            Vtna_cli_Crear.errorDireccion.setVisible(true);
        } else {
            Vtna_cli_Crear.errorDireccion.setVisible(false);
            Vtna_cli_Crear.etiDireccionError.setVisible(false);
        }
        return direccion;
    }

    //para pedir direccion para modificar
    public static String pideDireccionM() {
        String direccion = Vtna_cli_Modif.txtDireccionM.getText();

        if (Vtna_cli_Modif.txtDireccionM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorDireccionM.setVisible(true);
            Vtna_cli_Modif.etiDireccionErrorM.setVisible(true);
            Vtna_cli_Modif.txtDireccionM.requestFocus();
        } else {
            Vtna_cli_Modif.errorDireccionM.setVisible(false);
            Vtna_cli_Modif.etiDireccionErrorM.setVisible(false);
            Vtna_cli_Modif.txtEmailM.requestFocus();
        }
        return direccion;
    }

    //para pedir direccion para modificar - KEYs
    public static String pideDireccionKeyM() {
        String direccion = Vtna_cli_Modif.txtDireccionM.getText();

        if (Validate.validaDireccion(direccion) != true) {
            Vtna_cli_Modif.etiDireccionErrorM.setVisible(true);
            Vtna_cli_Modif.errorDireccionM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorDireccionM.setVisible(false);
            Vtna_cli_Modif.etiDireccionErrorM.setVisible(false);
        }
        return direccion;
    }

    //fecha nacimiento
    public static Fecha pideFnacimiento() {
        String fecha1 = "";
        int Edad = 0;
        Fecha Fnacimiento = null;

        if (Vtna_cli_Crear.txtFnacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha de nacimiento");
            Vtna_cli_Crear.errorFnacimiento.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) Vtna_cli_Crear.txtFnacimiento.getDateEditor()).getText();

            Fnacimiento = (DAOgenerico.pedirFechaNB(fecha1));

            //calcular y rellenar la edad
            Edad = Fnacimiento.restaFechas();

            if (Edad <= 18) {
                JOptionPane.showMessageDialog(null, "Debe ser mayor de edad");
                Vtna_cli_Crear.errorFnacimiento.setVisible(true);
            } else {
                Vtna_cli_Crear.errorFnacimiento.setVisible(false);
            }
        }
        return Fnacimiento;
    }

    //fecha nacimiento para modificar
    public static Fecha pideFnacimientoM() {
        String fecha1 = "";
        int Edad = 0;
        Fecha FnacimientoM = null;

        if (Vtna_cli_Modif.txtFnacimientoM.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha de nacimiento");
            Vtna_cli_Modif.errorFnacimientoM.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) Vtna_cli_Modif.txtFnacimientoM.getDateEditor()).getText();
        }

        FnacimientoM = (DAOgenerico.pedirFechaNB(fecha1));

        //calcular y rellenar la edad
        Edad = FnacimientoM.restaFechas();

        if (Edad <= 18) {
            JOptionPane.showMessageDialog(null, "Debe ser mayor de edad");
            Vtna_cli_Modif.errorFnacimientoM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorFnacimientoM.setVisible(false);
        }
        return FnacimientoM;
    }

    //Funcion para pedir Login
    public static String pideLogin() {
        String login = Vtna_cli_Crear.txtLogin.getText();
        int pos = 0;

        if (Vtna_cli_Crear.txtLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El login no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorLogin.setVisible(true);
        } else {
            Cliente e = new Cliente(login);
            login = Vtna_cli_Crear.txtLogin.getText();
            pos = ClienteBLL.buscar(e);

            if (pos != -1) {
                Vtna_cli_Crear.txtLogin.requestFocus();
                JOptionPane.showMessageDialog(null, "Usuario repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
                Vtna_cli_Crear.errorLogin.setVisible(true);
            } else {
                Vtna_cli_Crear.errorLogin.setVisible(false);
                Vtna_cli_Crear.txtPassword.requestFocus();
            }
        }
        return login;
    }

    public static String pideLoginKey() {
        String login = Vtna_cli_Crear.txtLogin.getText();

        if (Vtna_cli_Crear.txtLogin.getText().isEmpty()) {
            Vtna_cli_Crear.errorLogin.setVisible(true);
        } else {
            Vtna_cli_Crear.errorLogin.setVisible(false);
        }
        return login;
    }

    public static String pideLoginM() {

        String loginM = Vtna_cli_Modif.txtLoginM.getText();
        if (Vtna_cli_Modif.txtLoginM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El login no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.txtLoginM.requestFocus();
            Vtna_cli_Modif.errorLoginM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorLoginM.setVisible(false);
            Vtna_cli_Modif.txtPasswordM.requestFocus();
        }
        return loginM;
    }

    public static String pideLoginKeyM() {

        String loginM = Vtna_cli_Modif.txtLoginM.getText();
        if (Vtna_cli_Modif.txtLoginM.getText().isEmpty()) {
            Vtna_cli_Modif.errorLoginM.setVisible(true);
        } else {
            Vtna_cli_Modif.errorLoginM.setVisible(false);
        }
        return loginM;
    }

    // Funcion para pedir Password
    public static String pidePassword() {
        String password = Vtna_cli_Crear.txtPassword.getText();
        if (Vtna_cli_Crear.txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El Password no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Crear.errorPassword.setVisible(true);
        } else {
            password = Encriptador.encriptarTokenMD5(password);
            Vtna_cli_Crear.errorPassword.setVisible(false);
            Vtna_cli_Crear.btnAceptar.requestFocus();
        }
        return password;
    }

    // Funcion para pedir Password  - Key
    public static String pidePasswordKey() {
        String password = Vtna_cli_Crear.txtPassword.getText();
        if (Vtna_cli_Crear.txtPassword.getText().isEmpty()) {
            Vtna_cli_Crear.errorPassword.setVisible(true);
        } else {
            password = Encriptador.encriptarTokenMD5(password);
            Vtna_cli_Crear.errorPassword.setVisible(false);
        }
        return password;
    }

    public static String pidePasswordM() {
        String passwordM = Vtna_cli_Modif.txtPasswordM.getText();

        if (Vtna_cli_Modif.txtPasswordM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El password no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Vtna_cli_Modif.errorPasswordM.setVisible(true);
        } else {
            passwordM = Encriptador.encriptarTokenMD5(passwordM);
            Vtna_cli_Modif.errorPasswordM.setVisible(false);
        }
        return passwordM;
    }

    public static String pidePasswordM_Key() {
        String passwordM = Vtna_cli_Modif.txtPasswordM.getText();

        if (Vtna_cli_Modif.txtPasswordM.getText().isEmpty()) {
            Vtna_cli_Modif.errorPasswordM.setVisible(true);
        } else {
            passwordM = Encriptador.encriptarTokenMD5(passwordM);
            Vtna_cli_Modif.errorPasswordM.setVisible(false);
        }
        return passwordM;
    }

    public static String pideTipo() {

        String tipo = "";

        if (Singletons.efCrear.comboTipo.getSelectedItem() == "Usuario") {
            tipo = "usuario";
        } else if (Singletons.efCrear.comboTipo.getSelectedItem() == "Admin") {
            tipo = "admin";
        }
        return tipo;
    }

    public static String pideTipoM() {

        String tipo = "";

        if (Singletons.efModif.comboTipoM.getSelectedItem() == "Usuario") {
            tipo = "usuario";
        } else if (Singletons.efModif.comboTipoM.getSelectedItem() == "Admin") {
            tipo = "admin";
        }
        return tipo;
    }

    public static void CreaCliente() {

        String nombre = "", apellidos = "", dni = "", telefono = "", email = "", direccion = "", login = "", password = "", tipo = "", avatar = "";
        String estado = "inactivado";
        Fecha Fnacimiento = null;

        nombre = pideNombre();
        apellidos = pideApellidos();
        dni = pideDni();
        telefono = pideTelefono();
        direccion = pideDireccion();
        email = pideEmail();
        Fnacimiento = pideFnacimiento();

        login = pideLogin();
        password = pidePassword();
        tipo = pideTipo();

        avatar= Singletons.PATH_auto;
        
        if ((Vtna_cli_Crear.errorNombre.isVisible() == false) && (Vtna_cli_Crear.errorDni.isVisible() == false) && (Vtna_cli_Crear.errorApellidos.isVisible() == false)
            && (Vtna_cli_Crear.errorTelf.isVisible() == false) && (Vtna_cli_Crear.errorDireccion.isVisible() == false) && (Vtna_cli_Crear.errorEmail.isVisible() == false) && (Vtna_cli_Crear.errorFnacimiento.isVisible() == false)) {
            Fecha Fechaalta = Fecha.fechaHoy();
            Singletons.cli = new Cliente(nombre, apellidos, dni, telefono, direccion, email, Fnacimiento, Fechaalta, login, password, estado, tipo, avatar);
        }
    }

    public static void modificar() {

        FileUploader.leer_imag(2);

        Vtna_cli_Modif.txtNombreM.setText((Singletons.cli).getNombre());
        Vtna_cli_Modif.txtApellidosM.setText((Singletons.cli).getApellidos());
        Vtna_cli_Modif.txtTelefonoM.setText((Singletons.cli).getTelefono());
        Vtna_cli_Modif.txtDireccionM.setText((Singletons.cli).getDireccion());
        Vtna_cli_Modif.txtEmailM.setText((Singletons.cli).getEmail());
        ((JTextFieldDateEditor) Vtna_cli_Modif.txtFnacimientoM.getDateEditor()).setText((Singletons.cli).getFnacimiento().aStringFecha());
        Vtna_cli_Modif.txtLoginM.setText((Singletons.cli).getLogin());
    }

    public static void modificarLogeado() {

        FileUploader.leer_imag(1);

        Vtna_cli_Modif.txtNombreM.setText((Singletons.cliLog).getNombre());
        Vtna_cli_Modif.txtApellidosM.setText((Singletons.cliLog).getApellidos());
        Vtna_cli_Modif.txtTelefonoM.setText((Singletons.cliLog).getTelefono());
        Vtna_cli_Modif.txtDireccionM.setText((Singletons.cliLog).getDireccion());
        Vtna_cli_Modif.txtEmailM.setText((Singletons.cliLog).getEmail());
        ((JTextFieldDateEditor) Vtna_cli_Modif.txtFnacimientoM.getDateEditor()).setText((Singletons.cliLog).getFnacimiento().aStringFecha());
        Vtna_cli_Modif.txtLoginM.setText((Singletons.cliLog).getLogin());
    }

    public static void limpiar() {

        Vtna_cli_Crear.txtDni.setText("");
        Vtna_cli_Crear.txtNombre.setText("");
        Vtna_cli_Crear.txtApellidos.setText("");
        Vtna_cli_Crear.txtTelefono.setText("");
        Vtna_cli_Crear.txtDireccion.setText("");
        Vtna_cli_Crear.txtFnacimiento.setDate(null);
        Vtna_cli_Crear.txtEmail.setText("");
        Vtna_cli_Crear.errorNombre.setVisible(false);
        Vtna_cli_Crear.errorApellidos.setVisible(false);
        Vtna_cli_Crear.errorDni.setVisible(false);
        Vtna_cli_Crear.errorTelf.setVisible(false);
        Vtna_cli_Crear.errorEmail.setVisible(false);
        Vtna_cli_Crear.etiEmailError.setVisible(false);
        Vtna_cli_Crear.errorFnacimiento.setVisible(false);
        Vtna_cli_Crear.errorDireccion.setVisible(false);
        Vtna_cli_Crear.errorLogin.setVisible(false);
        Vtna_cli_Crear.etiNombreError.setVisible(false);
        Vtna_cli_Crear.etiApellidoError.setVisible(false);
        Vtna_cli_Crear.etiDniError.setVisible(false);
        Vtna_cli_Crear.etiTelefonoError.setVisible(false);
        Vtna_cli_Crear.etiDireccionError.setVisible(false);
        Vtna_cli_Crear.txtLogin.setText("");
        Vtna_cli_Crear.txtPassword.setText("");

    }

    public static void ocultarErroresModificar() {

        Vtna_cli_Modif.errorNombreM.setVisible(false);
        Vtna_cli_Modif.etiNombreErrorM.setVisible(false);

        Vtna_cli_Modif.errorApellidosM.setVisible(false);
        Vtna_cli_Modif.etiApellidoErrorM.setVisible(false);

        Vtna_cli_Modif.errorTelfM.setVisible(false);
        Vtna_cli_Modif.etiTelefonoErrorM.setVisible(false);

        Vtna_cli_Modif.errorEmailM.setVisible(false);
        Vtna_cli_Modif.etiEmailErrorM.setVisible(false);

        Vtna_cli_Modif.errorDireccionM.setVisible(false);
        Vtna_cli_Modif.etiDireccionErrorM.setVisible(false);

        Vtna_cli_Modif.errorFnacimientoM.setVisible(false);
        Vtna_cli_Modif.errorLoginM.setVisible(false);
        Vtna_cli_Modif.errorPasswordM.setVisible(false);

    }

    public static void ocultarErrores() {

        Vtna_cli_Crear.errorNombre.setVisible(false);
        Vtna_cli_Crear.etiNombreError.setVisible(false);

        Vtna_cli_Crear.errorApellidos.setVisible(false);
        Vtna_cli_Crear.etiApellidoError.setVisible(false);

        Vtna_cli_Crear.errorDni.setVisible(false);
        Vtna_cli_Crear.etiDniError.setVisible(false);

        Vtna_cli_Crear.errorTelf.setVisible(false);
        Vtna_cli_Crear.etiTelefonoError.setVisible(false);

        Vtna_cli_Crear.errorEmail.setVisible(false);
        Vtna_cli_Crear.etiEmailError.setVisible(false);

        Vtna_cli_Crear.errorDireccion.setVisible(false);
        Vtna_cli_Crear.etiDireccionError.setVisible(false);

        Vtna_cli_Crear.errorFnacimiento.setVisible(false);

        Vtna_cli_Crear.errorLogin.setVisible(false);

    }

    public static void editable() {

        Vtna_cli_Crear.txtNombre.setEditable(true);
        Vtna_cli_Crear.txtApellidos.setEditable(true);
        Vtna_cli_Crear.txtDni.setEditable(true);
        Vtna_cli_Crear.txtTelefono.setEditable(true);
        Vtna_cli_Crear.txtDireccion.setEditable(true);
        Vtna_cli_Crear.txtEmail.setEditable(true);
        Vtna_cli_Crear.txtLogin.setEditable(true);
        Vtna_cli_Crear.txtPassword.setEditable(true);
        Vtna_cli_Crear.btnCancelar.setEnabled(true);
        Vtna_cli_Crear.btnAceptar.setEnabled(true);
    }

    public static void noEditable() {

        Vtna_cli_Crear.txtNombre.setEditable(false);
        Vtna_cli_Crear.txtApellidos.setEditable(false);
        Vtna_cli_Crear.txtDni.setEditable(false);
        Vtna_cli_Crear.txtTelefono.setEditable(false);
        Vtna_cli_Crear.txtDireccion.setEditable(false);
        Vtna_cli_Crear.txtLogin.setEditable(false);
        Vtna_cli_Crear.txtPassword.setEditable(false);
        Vtna_cli_Crear.btnCancelar.setEnabled(false);
        Vtna_cli_Crear.btnAceptar.setEnabled(false);
        ((JTextFieldDateEditor) Vtna_cli_Crear.txtFnacimiento.getDateEditor()).setEditable(false);
    }

    public static void noEditableM() {

        Vtna_cli_Modif.txtNombreM.setEditable(false);
        Vtna_cli_Modif.txtApellidosM.setEditable(false);
        Vtna_cli_Modif.txtTelefonoM.setEditable(false);
        Vtna_cli_Modif.txtEmailM.setEditable(false);
        Vtna_cli_Modif.txtDireccionM.setEditable(false);
        Vtna_cli_Modif.txtLoginM.setEditable(false);
        Vtna_cli_Modif.txtPasswordM.setEditable(false);
        Vtna_cli_Modif.btnAceptarM.setEnabled(false);
        ((JTextFieldDateEditor) Vtna_cli_Modif.txtFnacimientoM.getDateEditor()).setEditable(false);
    }

    public static Cliente pidednivacio(String dnimatch) {
        Singletons.cli = null;
        String dni;

        do {
            dni = dnimatch;
        } while (Validate.validaDNI(dni) == false);

        Singletons.cli = new Cliente(dni);

        return Singletons.cli;
    }

    ////// M O D I F I C A R   M I  P E R F I L  ///////////////
    //Funcion para pedir Nombre para modificar
    public static String pideNombreMP() {
        String nombre = Singletons.cliMP.txtNombreMP.getText();

        if (Singletons.cliMP.txtNombreMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.txtNombreMP.setVisible(true);
        }

        if (Validate.validaNombre(nombre) != true) {
            Singletons.cliMP.etiNombreErrorM.setVisible(true);
            Singletons.cliMP.errorNombreM.setVisible(true);
            Singletons.cliMP.txtNombreMP.requestFocus();
        } else {
            Singletons.cliMP.etiNombreErrorM.setVisible(false);
            Singletons.cliMP.errorNombreM.setVisible(false);
            Singletons.cliMP.txtApellidosMP.requestFocus();
        }

        return nombre;
    }

    //Funcion para pedir Nombre para modificar  -  Keys
    public static String pideNombreKeyMP() {
        String nombre = Singletons.cliMP.txtNombreMP.getText();

        if (Validate.validaNombre(nombre) != true) {
            Singletons.cliMP.etiNombreErrorM.setVisible(true);
            Singletons.cliMP.errorNombreM.setVisible(true);
        } else {
            Singletons.cliMP.etiNombreErrorM.setVisible(false);
            Singletons.cliMP.errorNombreM.setVisible(false);
        }

        return nombre;
    }

    //Funcion para pedir Apellidos para modificar
    public static String pideApellidosMP() {
        String apellidos = Singletons.cliMP.txtApellidosMP.getText();

        if (Singletons.cliMP.txtApellidosMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.errorApellidosM.setVisible(true);
        }

        if (Validate.validaApellido(apellidos) != true) {
            Singletons.cliMP.etiApellidoErrorM.setVisible(true);
            Singletons.cliMP.errorApellidosM.setVisible(true);
            Singletons.cliMP.txtApellidosMP.requestFocus();
        } else {
            Singletons.cliMP.errorApellidosM.setVisible(false);
            Singletons.cliMP.etiApellidoErrorM.setVisible(false);
            Singletons.cliMP.txtTelefonoMP.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para modificar  - Keys
    public static String pideApellidosKeyMP() {
        String apellidos = Singletons.cliMP.txtApellidosMP.getText();

        if (Validate.validaApellido(apellidos) != true) {
            Singletons.cliMP.etiApellidoErrorM.setVisible(true);
            Singletons.cliMP.errorApellidosM.setVisible(true);
        } else {
            Singletons.cliMP.errorApellidosM.setVisible(false);
            Singletons.cliMP.etiApellidoErrorM.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir telefono para modificar
    public static String pideTelefonoMP() {
        String telefono = Singletons.cliMP.txtTelefonoMP.getText();

        if (Singletons.cliMP.txtTelefonoMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.errorTelfM.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Singletons.cliMP.etiTelefonoErrorM.setVisible(true);
            Singletons.cliMP.errorTelfM.setVisible(true);
        } else {
            Singletons.cliMP.errorTelfM.setVisible(false);
            Singletons.cliMP.etiTelefonoErrorM.setVisible(false);
        }
        return telefono;
    }

    //Funcion para pedir telefono para modificar  - Keys
    public static String pideTelefonoKeyMP() {

        String telefono = Singletons.cliMP.txtTelefonoMP.getText();

        if (Validate.validaNumTelefono(telefono) != true) {
            Singletons.cliMP.etiTelefonoErrorM.setVisible(true);
            Singletons.cliMP.errorTelfM.setVisible(true);
            Singletons.cliMP.txtTelefonoMP.requestFocus();
        } else {
            Singletons.cliMP.errorTelfM.setVisible(false);
            Singletons.cliMP.etiTelefonoErrorM.setVisible(false);
            Singletons.cliMP.txtDireccionMP.requestFocus();
        }
        return telefono;
    }

    //para pedir email para modificar
    public static String pideEmailMP() {
        String email = Singletons.cliMP.txtEmailMP.getText();

        if (Singletons.cliMP.txtEmailMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El email no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.errorEmailM.setVisible(true);
        }

        if (Validate.validaEmail(email) != true) {
            Singletons.cliMP.etiEmailErrorM.setVisible(true);
            Singletons.cliMP.errorEmailM.setVisible(true);
            Singletons.cliMP.txtEmailMP.requestFocus();
        } else {
            Singletons.cliMP.errorEmailM.setVisible(false);
            Singletons.cliMP.etiEmailErrorM.setVisible(false);
            Singletons.cliMP.txtFnacimientoMP.requestFocus();
        }
        return email;
    }

    //para pedir email para modificar - KEYs
    public static String pideEmailKeyMP() {
        String email = Singletons.cliMP.txtEmailMP.getText();

        if (Validate.validaEmail(email) != true) {
            Singletons.cliMP.etiEmailErrorM.setVisible(true);
            Singletons.cliMP.errorEmailM.setVisible(true);
        } else {
            Singletons.cliMP.errorEmailM.setVisible(false);
            Singletons.cliMP.etiEmailErrorM.setVisible(false);
        }
        return email;
    }

    //para pedir direccion para modificar
    public static String pideDireccionMP() {
        String direccion = Singletons.cliMP.txtDireccionMP.getText();

        if (Singletons.cliMP.txtDireccionMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.errorDireccionM.setVisible(true);
        }

        if (Validate.validaDireccion(direccion) != true) {
            Singletons.cliMP.etiDireccionErrorM.setVisible(true);
            Singletons.cliMP.errorDireccionM.setVisible(true);
            Singletons.cliMP.txtDireccionMP.requestFocus();
        } else {
            Singletons.cliMP.errorDireccionM.setVisible(false);
            Singletons.cliMP.etiDireccionErrorM.setVisible(false);
            Singletons.cliMP.txtEmailMP.requestFocus();
        }
        return direccion;
    }

    //para pedir direccion para modificar - KEYs
    public static String pideDireccionKeyMP() {
        String direccion = Singletons.cliMP.txtDireccionMP.getText();

        if (Validate.validaDireccion(direccion) != true) {
            Singletons.cliMP.etiDireccionErrorM.setVisible(true);
            Singletons.cliMP.errorDireccionM.setVisible(true);
        } else {
            Singletons.cliMP.errorDireccionM.setVisible(false);
            Singletons.cliMP.etiDireccionErrorM.setVisible(false);
        }
        return direccion;
    }

    //fecha nacimiento para modificar
    public static Fecha pideFnacimientoMP() {
        String fecha1 = "";
        int Edad = 0;
        Fecha FnacimientoM = null;

        if (Singletons.cliMP.txtFnacimientoMP.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha de nacimiento");
        } else {
            fecha1 = ((JTextFieldDateEditor) Singletons.cliMP.txtFnacimientoMP.getDateEditor()).getText();
        }

        FnacimientoM = (DAOgenerico.pedirFechaNB(fecha1));

        Edad = FnacimientoM.restaFechas();

        if (Edad <= 16) {
            JOptionPane.showMessageDialog(null, "La edad debe ser igual o superior a 16 años");
            Singletons.cliMP.errorFnacimientoM.setVisible(true);
        } else {
            Singletons.cliMP.errorFnacimientoM.setVisible(false);
        }

        return FnacimientoM;
    }

    public static String pideLoginMP() {
        String loginM = Singletons.cliMP.txtLoginMP.getText();
        return loginM;
    }

    public static String pidePasswordMP() {
        String passwordM = Singletons.cliMP.txtPasswordMP.getText();

        if (Singletons.cliMP.txtPasswordMP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El password no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.cliMP.errorPasswordM.setVisible(true);
        } else {
            passwordM = Encriptador.encriptarTokenMD5(passwordM);
            Singletons.cliMP.errorPasswordM.setVisible(false);
        }
        return passwordM;
    }

    public static String pidePasswordMP_Key() {
        String passwordM = Singletons.cliMP.txtPasswordMP.getText();

        if (Singletons.cliMP.txtPasswordMP.getText().isEmpty()) {
            Singletons.cliMP.errorPasswordM.setVisible(true);
        } else {
            Singletons.cliMP.errorPasswordM.setVisible(false);
        }
        return passwordM;
    }

    public static String pideTipoMP() {

        String tipo = "";

        if (Singletons.cliMP.comboTipoMP.getSelectedItem() == "Usuario") {
            tipo = "usuario";
        } else if (Singletons.cliMP.comboTipoMP.getSelectedItem() == "Admin") {
            tipo = "admin";
        }
        return tipo;
    }

    public static void modificarLogeadoMP() {

        Singletons.cliMP.txtNombreMP.setText((Singletons.cliLog).getNombre());
        Singletons.cliMP.txtApellidosMP.setText((Singletons.cliLog).getApellidos());
        Singletons.cliMP.txtTelefonoMP.setText((Singletons.cliLog).getTelefono());
        Singletons.cliMP.txtDireccionMP.setText((Singletons.cliLog).getDireccion());
        Singletons.cliMP.txtEmailMP.setText((Singletons.cliLog).getEmail());
        ((JTextFieldDateEditor) Singletons.cliMP.txtFnacimientoMP.getDateEditor()).setText((Singletons.cliLog).getFnacimiento().aStringFecha());
        Singletons.cliMP.txtLoginMP.setText((Singletons.cliLog).getLogin());
    }

    public static void ocultarErroresModificarMP() {

        Singletons.cliMP.errorNombreM.setVisible(false);
        Singletons.cliMP.etiNombreErrorM.setVisible(false);

        Singletons.cliMP.errorApellidosM.setVisible(false);
        Singletons.cliMP.etiApellidoErrorM.setVisible(false);

        Singletons.cliMP.errorTelfM.setVisible(false);
        Singletons.cliMP.etiTelefonoErrorM.setVisible(false);

        Singletons.cliMP.errorEmailM.setVisible(false);
        Singletons.cliMP.etiEmailErrorM.setVisible(false);

        Singletons.cliMP.errorDireccionM.setVisible(false);
        Singletons.cliMP.etiDireccionErrorM.setVisible(false);

        Singletons.cliMP.errorFnacimientoM.setVisible(false);

        Singletons.cliMP.btnOKM.setVisible(false);
        Singletons.cliMP.etiGuardadoM.setVisible(false);
        Singletons.cliMP.errorPasswordM.setVisible(false);

    }
}
