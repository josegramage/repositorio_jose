/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Login.Modelo.BLL;

import java.awt.Color;
import proyectofinal_josegramage.Clases.ConexionBD;
import proyectofinal_josegramage.Clases.JavaMail;
import proyectofinal_josegramage.Librerias.Encriptador;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Librerias.Validate;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Login.Modelo.DAO.LoginDAO;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;

/**
 *
 * @author Joso
 */
public class LoginBLL {

    public static String dni;
    public static String email;

    public static int buscar() {//Buscar
        int aux = -1;

        for (int i = 0; i <= (Singletons.cliArray.size() - 1); i++) {
            if ((Singletons.cliArray.get(i)).equals(Singletons.cli))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
            {
                aux = i;
            }
        }
        return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
    }
    
    public boolean loginUsuarioBLL(String usuario, String password) {

        Connection _con;
        boolean _resul;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _loginDAO = new LoginDAO();

        _resul = _loginDAO.loginUsuarioDAO(_con, usuario, password);

        _conexion_DB.CerrarConexion(_con);

        return _resul;
    }
    
     public static int activarUsuarioBLL(String login) {

        Connection _con;
        int _resul;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _loginDAO = new LoginDAO();

        _resul = _loginDAO.activarUsuarioDAO(_con, login);
         _conexion_DB.CerrarConexion(_con);

        return _resul;
    }
    
    
    public int RecuperarPassword() {

        Connection _con = null;
        int correcto;
        
        String dni = Singletons.recu.txtDniRecuperar.getText();
        String email = Singletons.recu.txtemailRecuperar.getText();
        String password = Encriptador.getCadenaAleatoria(10);
        String passwordEn = Encriptador.encriptarTokenMD5(password);
        String asunto="Recuperacion de contraseña - Mundo Virtual -";
        String mensaje="Tu nueva contraseña es: "+ password + "\n<p> Podrás cambiarla en tu perfil";
      
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _empleadoDAO = new LoginDAO();

        correcto = _empleadoDAO.actualizarPasswordDAO(_con, dni, passwordEn);

        _conexion_DB.CerrarConexion(_con);

        if (correcto == 1) {
    

            JavaMail mail = new JavaMail(email, password, asunto, mensaje);
            String error = mail.send();
            if (error.equals("")) {
                JOptionPane.showMessageDialog(null, "Se ha enviado un email con su nueva contraseña, \n podrá cambiarla en su perfil", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "-TEST CLASE- \n Tu nueva contraseña es: "+ password + "\n Podrás cambiarla en tu perfil");
            } else {
                JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El dni no coresponde a ningun usuario registrado");
        }
       return correcto;
    }
    
    
    
    // -------------------------------------------------------------------------------
    //  PARA EL ALTA DEL CLIENTE
    // -------------------------------------------------------------------------------
    public static void pideNombre() {
        LoginDAO.pideNombre();
    }

    public static void pideNombreKey() {
        LoginDAO.pideNombreKey();
    }

    public static void pideApellidos() {
        LoginDAO.pideApellidos();
    }

    public static void pideApellidosKey() {
        LoginDAO.pideApellidosKey();
    }

    // para que no repita el dni
    public static void pideDni() {
        int pos = 0;
        Cliente e = new Cliente(LoginDAO.pideDni());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            Singletons.alta.errorDni.setVisible(true);
        } else {
            Singletons.alta.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey() {
        int pos = 0;
        Cliente e = new Cliente(LoginDAO.pideDniKey());
        pos = buscar(e);

        if (pos != -1) {
            Singletons.alta.errorDni.setVisible(true);
        } else {
            Singletons.alta.errorDni.setVisible(false);
        }
    }

    public static void pideDniKey2() {
        LoginDAO.pideDniKey();
    }

    public static void pideTelefono() {
        LoginDAO.pideTelefono();
    }

    public static void pideTelefonoKey() {
        LoginDAO.pideTelefonoKey();
    }

    public static void pideEmail() {
        LoginDAO.pideEmail();
    }

    public static void pideEmailKey() {
        LoginDAO.pideEmailKey();
    }

    public static void pideDireccion() {
        LoginDAO.pideDireccion();
    }

    public static void pideDireccionKey() {
        LoginDAO.pideDireccionKey();
    }

    public static void AltaUsuario() {

        LoginDAO.AltaUsuario();
     
       //la fecha de alta se genera automaticamente asi que me sirve de chivato
        if (Singletons.cli.getFechaalta()!= null) {
            Singletons.cli.setPassword(Encriptador.encriptarTokenMD5(Singletons.cli.getPassword()));
            Singletons.cliArray.add(Singletons.cli);
            ClienteBLL_bd.nuevoUsuarioBLL();
        }
    }

    public static void limpiar() {
        LoginDAO.limpiar();
    }

    public static void ocultarErrores() {
        LoginDAO.ocultarErrores();
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
}
