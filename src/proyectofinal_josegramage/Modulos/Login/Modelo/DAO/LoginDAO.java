/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Login.Modelo.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Librerias.Encriptador;
import proyectofinal_josegramage.Librerias.Validate;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Clases.JavaMail;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.DAOgenerico;


/**
 *
 * @author Joso
 */
public class LoginDAO {

    public static void PideUsuario() {
       
        if (Vtna_SignIN.txtUsuario.getText().isEmpty()) {
            Vtna_SignIN.txtUsuario.setForeground(Color.red);
            Vtna_SignIN.txtUsuario.setText("Introduzca usuario");
            Vtna_SignIN.txtUsuario.requestFocus();
            return;
        }

        if (Validate.validaDNI(Vtna_SignIN.txtUsuario.getText()) == false) {
            Vtna_SignIN.txtUsuario.setForeground(Color.red);
            Vtna_SignIN.txtUsuario.setText("Usuario inválido");
            Vtna_SignIN.txtUsuario.requestFocus();
            return;
        }
        Vtna_SignIN.txtPassword.requestFocus();
    }

    public static void PidePassword() {

        if (Vtna_SignIN.txtPassword.getText().isEmpty()) {
            Vtna_SignIN.txtPassword.setForeground(Color.red);
            Vtna_SignIN.txtPassword.setText("Introduzca password");
            Vtna_SignIN.txtPassword.requestFocus();
            return;
        }

        Vtna_SignIN.btnAceptar.requestFocus();
    }

    public static void PideUsuarioOlvidar() {

        if (Vtna_Recuperar.txtDniRecuperar.getText().isEmpty()) {
            Vtna_Recuperar.txtDniRecuperar.setForeground(Color.red);
            Vtna_Recuperar.txtDniRecuperar.setText("Introduzca usuario");
            Vtna_Recuperar.txtDniRecuperar.requestFocus();
            return;
        }

        if (Validate.validaDNI(Vtna_Recuperar.txtDniRecuperar.getText()) == false) {
            Vtna_Recuperar.txtDniRecuperar.setForeground(Color.red);
            Vtna_Recuperar.txtDniRecuperar.setText("Usuario inválido");
            Vtna_Recuperar.txtDniRecuperar.requestFocus();
            return;
        }
        Vtna_Recuperar.txtemailRecuperar.requestFocus();
    }

    public static void PidePasswordOlvidar() {

        if (Vtna_Recuperar.txtemailRecuperar.getText().isEmpty()) {
            Vtna_Recuperar.txtemailRecuperar.setForeground(Color.red);
            Vtna_Recuperar.txtemailRecuperar.setText("Introduzca password");
            Vtna_Recuperar.txtemailRecuperar.requestFocus();
            return;
        }

        Vtna_Recuperar.btnAceptarRecu.requestFocus();
    }

    public boolean loginUsuarioDAO(Connection con, String login, String password) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM proyectofinal_josegramage.clientes WHERE login=? AND password=?");

            stmt.setString(1, login);
            stmt.setString(2, Encriptador.encriptarTokenMD5(password));

            rs = stmt.executeQuery();

            while (rs.next()) {

                Singletons.cliLog.setNombre(rs.getString("Nombre"));
                Singletons.cliLog.setApellidos(rs.getString("Apellidos"));
                Singletons.cliLog.setDni(rs.getString("Dni"));
                Singletons.cliLog.setTelefono(rs.getString("Telefono"));
                Singletons.cliLog.setDireccion (rs.getString("Direccion"));
                Singletons.cliLog.setEmail(rs.getString("Email"));
                Singletons.cliLog.setFnacimiento(Fecha.muestraFecha(rs.getString("Fnacimiento")));
                Singletons.cliLog.setFechaalta(Fecha.muestraFecha(rs.getString("Fechaalta")));
                Singletons.cliLog.setLogin(rs.getString("Login"));
                Singletons.cliLog.setPassword(rs.getString("Password"));           
                Singletons.cliLog.setEstado(rs.getInt("Estado"));
                Singletons.cliLog.setTipo(rs.getString("Tipo"));
                Singletons.cliLog.setAvatar(rs.getString("Avatar"));

                resultado = true;
                Singletons.conectado = true;
                
        //        Singletons.cliLog.setTipo("1");
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger1");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger2");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger3");
                }
            }
        }
        return resultado;
    }

    // -------------------------------------------------------------------------------
    //  PARA EL ALTA DEL CLIENTE
    // -------------------------------------------------------------------------------
    
    //Funcion para pedir Nombre para crear
    public static String pideNombre() {
        String nombre = Singletons.alta.txtNombreL.getText();

        if (Singletons.alta.txtNombreL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorNombre.setVisible(true);
        }

        if (Validate.validaNombre(nombre) != true) {
            Singletons.alta.etiNombreError.setVisible(true);
            Singletons.alta.errorNombre.setVisible(true);
            Singletons.alta.txtNombreL.requestFocus();

        } else {
            Singletons.alta.etiNombreError.setVisible(false);
            Singletons.alta.errorNombre.setVisible(false);
            Singletons.alta.txtApellidosL.requestFocus();
        }
        return nombre;
    }

    //Funcion para pedir Nombre para crear -KEYs
    public static String pideNombreKey() {
        String nombre = Singletons.alta.txtNombreL.getText();

        if (Validate.validaNombre(nombre) != true) {
            Singletons.alta.etiNombreError.setVisible(true);
            Singletons.alta.errorNombre.setVisible(true);
        } else {
            Singletons.alta.etiNombreError.setVisible(false);
            Singletons.alta.errorNombre.setVisible(false);

        }
        return nombre;
    }

    //Funcion para pedir Apellidos para crear
    public static String pideApellidos() {
        String apellidos = Singletons.alta.txtApellidosL.getText();

        if (Singletons.alta.txtApellidosL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorApellidos.setVisible(true);
        }

        if (Validate.validaApellido(apellidos) != true) {
            Singletons.alta.etiApellidoError.setVisible(true);
            Singletons.alta.errorApellidos.setVisible(true);
            Singletons.alta.txtApellidosL.requestFocus();
        } else {
            Singletons.alta.errorApellidos.setVisible(false);
            Singletons.alta.etiApellidoError.setVisible(false);
            Singletons.alta.txtDniL.requestFocus();
        }
        return apellidos;
    }

    //Funcion para pedir Apellidos para crear   - KEYs
    public static String pideApellidosKey() {
        String apellidos = Singletons.alta.txtApellidosL.getText();

        if (Validate.validaApellido(apellidos) != true) {
            Singletons.alta.etiApellidoError.setVisible(true);
            Singletons.alta.errorApellidos.setVisible(true);
        } else {
            Singletons.alta.errorApellidos.setVisible(false);
            Singletons.alta.etiApellidoError.setVisible(false);
        }
        return apellidos;
    }

    //Funcion para pedir Dni
    public static String pideDni() {
        String dni = Singletons.alta.txtDniL.getText();
        boolean validar;

        if (Singletons.alta.txtDniL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DNI no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorDni.setVisible(true);
            Singletons.alta.etiDniError.setVisible(true);
        } else {
            dni = Singletons.alta.txtDniL.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                Singletons.alta.txtDniL.requestFocus();
                Singletons.alta.etiDniError.setVisible(true);
                Singletons.alta.errorDni.setVisible(true);
            } else {
                Singletons.alta.etiDniError.setVisible(false);
                Singletons.alta.errorDni.setVisible(false);
                Singletons.alta.txtTelefonoL.requestFocus();
            }
        }
        return dni;
    }

    //Funcion para pedir Dni  - KEYs
    public static String pideDniKey() {
        String dni = Singletons.alta.txtDniL.getText();
        boolean validar;

        if (dni.isEmpty()) {
            //     Vtna_cli_Crear.etiDniError.setVisible(true);
            Singletons.alta.errorDni.setVisible(true);
        } else {
            dni = Singletons.alta.txtDniL.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                Singletons.alta.etiDniError.setVisible(true);
                Singletons.alta.errorDni.setVisible(true);
            } else {
                Singletons.alta.etiDniError.setVisible(false);
                Singletons.alta.errorDni.setVisible(false);
            }
        }
        return dni;
    }

    //Funcion para pedir telefono para crear
    public static String pideTelefono() {
        String telefono = Singletons.alta.txtTelefonoL.getText();
        if (Singletons.alta.txtTelefonoL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorTelf.setVisible(true);
        }

        if (Validate.validaNumTelefono(telefono) != true) {
            Singletons.alta.etiTelefonoError.setVisible(true);
            Singletons.alta.errorTelf.setVisible(true);
            Singletons.alta.txtTelefonoL.requestFocus();
        } else {
            Singletons.alta.errorTelf.setVisible(false);
            Singletons.alta.etiTelefonoError.setVisible(false);
            Singletons.alta.txtDireccionL.requestFocus();
        }
        return telefono;
    }

    //Funcion para pedir telefono para crear  - KEYs
    public static String pideTelefonoKey() {
        String telefono = Singletons.alta.txtTelefonoL.getText();

        if (Validate.validaNumTelefono(telefono) != true) {
            Singletons.alta.etiTelefonoError.setVisible(true);
            Singletons.alta.errorTelf.setVisible(true);
        } else {
            Singletons.alta.errorTelf.setVisible(false);
            Singletons.alta.etiTelefonoError.setVisible(false);
        }
        return telefono;
    }

    //para pedir email para crear
    public static String pideEmail() {
        String email = Singletons.alta.txtEmailL.getText();

        if (Singletons.alta.txtEmailL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El email no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorEmail.setVisible(true);
        }

        if (Validate.validaEmail(email) != true) {
            Singletons.alta.errorEmail.setVisible(true);
            Singletons.alta.errorEmail.setVisible(true);
            Singletons.alta.txtEmailL.requestFocus();
        } else {
            Singletons.alta.errorEmail.setVisible(false);
            Singletons.alta.errorEmail.setVisible(false);
            Singletons.alta.txtFnacimiento.requestFocus();
        }
        return email;
    }

    //para pedir email para crear - KEYs
    public static String pideEmailKey() {
        String email = Singletons.alta.txtEmailL.getText();

        if (Validate.validaEmail(email) != true) {
            Singletons.alta.etiEmailError.setVisible(true);
            Singletons.alta.errorEmail.setVisible(true);
        } else {
            Singletons.alta.errorEmail.setVisible(false);
            Singletons.alta.etiEmailError.setVisible(false);
        }
        return email;
    }

    //para pedir direccion para crear
    public static String pideDireccion() {
        String direccion = Singletons.alta.txtDireccionL.getText();

        if (Singletons.alta.txtDireccionL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La direccion no puede estar en blanco", "Error", JOptionPane.INFORMATION_MESSAGE);
            Singletons.alta.errorDireccion.setVisible(true);
        }

        if (Validate.validaDireccion(direccion) != true) {
            Singletons.alta.etiDireccionError.setVisible(true);
            Singletons.alta.errorDireccion.setVisible(true);
            Singletons.alta.txtDireccionL.requestFocus();
        } else {
            Singletons.alta.errorDireccion.setVisible(false);
            Singletons.alta.etiDireccionError.setVisible(false);
            Singletons.alta.txtEmailL.requestFocus();
        }
        return direccion;
    }

    //para pedir direccion para crear - KEYs
    public static String pideDireccionKey() {
        String direccion = Singletons.alta.txtDireccionL.getText();

        if (Validate.validaEmail(direccion) != true) {
            Singletons.alta.etiDireccionError.setVisible(true);
            Singletons.alta.errorDireccion.setVisible(true);
        } else {
            Singletons.alta.errorDireccion.setVisible(false);
            Singletons.alta.etiDireccionError.setVisible(false);
        }
        return direccion;
    }

    //fecha nacimiento
    public static Fecha pideFnacimiento() {
        String fecha1 = "";
        int Edad = 0;
        Fecha Fnacimiento = null;

        if (Singletons.alta.txtFnacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha de nacimiento");
        } else {
            fecha1 = ((JTextFieldDateEditor) Singletons.alta.txtFnacimiento.getDateEditor()).getText();

            Fnacimiento = (DAOgenerico.pedirFechaNB(fecha1));

            //calcular y rellenar la edad
            Edad = Fnacimiento.restaFechas();
            //    Vtna_cli_Crear.txtEdad.setText(Integer.toString(Edad));

            if (Edad <= 18) {
                JOptionPane.showMessageDialog(null, "Debe ser mayor de edad");
                Singletons.alta.errorFnacimiento.setVisible(true);
            } else {
                Singletons.alta.errorFnacimiento.setVisible(false);
            }
        }

        return Fnacimiento;
    }

    
    public static void AltaUsuario() {

        String nombre = "", apellidos = "", dni = "", telefono = "", email = "", direccion = "", login = "", password = "", tipo = "tipo", avatar = "";
        int estado = 0;
        Fecha Fnacimiento = null;

        nombre = pideNombre();
        apellidos = pideApellidos();
        dni = pideDni();
        telefono = pideTelefono();
        direccion = pideDireccion();
        Fnacimiento = pideFnacimiento();
        Fecha Fechaalta = Fecha.fechaHoy();
        email = pideEmail();
        login = Funciones.getCadenaAleatoria1(6);
        password = Encriptador.getCadenaAleatoria(10);

        if ((Singletons.alta.errorNombre.isVisible() == false) && (Singletons.alta.errorDni.isVisible() == false) && (Singletons.alta.errorApellidos.isVisible() == false)
                && (Singletons.alta.errorTelf.isVisible() == false) && (Singletons.alta.errorFnacimiento.isVisible() == false)) {

            Singletons.cli = new Cliente(nombre, apellidos, dni, telefono, direccion, email, Fnacimiento, Fechaalta, login, password, estado, tipo, avatar);

            JavaMail mail = new JavaMail(email);

            //enviamos el mensaje
            String error = mail.send(0);
            if (error.equals("")) {
                JOptionPane.showMessageDialog(null, "Se ha enviado un email con su nombre de usuario y contraseña," + "\n podrá cambiarlos en su perfil", "Email enviado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
            }   
        }
    }

    public static void limpiar() {

        Singletons.alta.txtDniL.setText("");
        Singletons.alta.txtNombreL.setText("");
        Singletons.alta.txtApellidosL.setText("");
        Singletons.alta.txtTelefonoL.setText("");
        Singletons.alta.txtDireccionL.setText("");
        Singletons.alta.txtFnacimiento.setDate(null);
        Singletons.alta.errorNombre.setVisible(false);
        Singletons.alta.errorApellidos.setVisible(false);
        Singletons.alta.errorDni.setVisible(false);
        Singletons.alta.errorTelf.setVisible(false);
        Singletons.alta.errorFnacimiento.setVisible(false);
        Singletons.alta.errorDireccion.setVisible(false);
        Singletons.alta.errorLogin.setVisible(false);
        Singletons.alta.etiNombreError.setVisible(false);
        Singletons.alta.etiApellidoError.setVisible(false);
        Singletons.alta.etiDniError.setVisible(false);
        Singletons.alta.etiTelefonoError.setVisible(false);
        Singletons.alta.etiDireccionError.setVisible(false);
        Singletons.alta.txtLoginL.setText("");
    
    }

    public static void ocultarErrores() {

        Singletons.alta.errorNombre.setVisible(false);
        Singletons.alta.etiNombreError.setVisible(false);

        Singletons.alta.errorApellidos.setVisible(false);
        Singletons.alta.etiApellidoError.setVisible(false);

        Singletons.alta.errorDni.setVisible(false);
        Singletons.alta.etiDniError.setVisible(false);

        Singletons.alta.errorTelf.setVisible(false);
        Singletons.alta.etiTelefonoError.setVisible(false);
        
        Singletons.alta.errorEmail.setVisible(false);
        Singletons.alta.etiEmailError.setVisible(false);

        Singletons.alta.errorDireccion.setVisible(false);
        Singletons.alta.etiDireccionError.setVisible(false);

        Singletons.alta.errorFnacimiento.setVisible(false);

        Singletons.alta.errorLogin.setVisible(false);

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

    public static int BuscarEmpleados(Cliente cli) {//Buscar
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
