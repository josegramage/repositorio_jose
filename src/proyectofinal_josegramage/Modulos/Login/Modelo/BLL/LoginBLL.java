/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Login.Modelo.BLL;

import proyectofinal_josegramage.Clases.ConexionBD;
import proyectofinal_josegramage.Clases.JavaMail;
import proyectofinal_josegramage.Librerias.Encriptador;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Librerias.Validate;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import proyectofinal_josegramage.Modulos.Login.Modelo.DAO.LoginDAO;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import java.sql.Connection;
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

    public static void pideUsuario() {
        LoginDAO.PideUsuario();
    }

    public static void pidePassword() {
        LoginDAO.PidePassword();
    }

    public static void UsuarioOlvidar() {
        LoginDAO.PideUsuarioOlvidar();
    }

    public static void PasswordOlvidar() {
        LoginDAO.PidePasswordOlvidar();
    }

    public static void ValidaDatosOlvidar() {
        UsuarioOlvidar();
        PasswordOlvidar();
    }

    public static void recogeDatosRestablecerPass() {

        dni = Vtna_Recuperar.txtDniRecuperar.getText();
        email = Vtna_Recuperar.txtemailRecuperar.getText();
    }

    public static void RecuperarPassword() {

        recogeDatosRestablecerPass();

        if (Validate.validaDNI(dni) != false) {
            Cliente cli = ClienteDAO.pidednivacio(dni);
            Singletons.posEmp = ClienteDAO.BuscarEmpleados(cli);
/*
            if (Singletons.posEmp != -1) {
                cli = Singletons.cliArray.get(Singletons.posEmp);

                cli.setLogin(Funciones.getCadenaAleatoria1(6));
                cli.setPassword(Encriptador.getCadenaAleatoria(10));
                //Singletons.emp.setLogin(Funciones.getCadenaAleatoria1(6));
                //Singletons.emp.setPassword(Encriptador.getCadenaAleatoria(10));

                Singletons.cliArray.set(Singletons.pos, Singletons.cli);
                ClienteBLL_bd.modificarClienteBLL();

                JavaMail mail = new JavaMail(email);

                String error = mail.send(1);
                if (error.equals("")) {
                    JOptionPane.showMessageDialog(null, "Se ha enviado un email con su nuevo nombre de usuario y contraseña," + "\n podrá cambiarlos en su perfil", "Email enviado", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El dni no coresponde a ningun usuario registrado");
            }
*/
        } else {
            JOptionPane.showMessageDialog(null, "no se que saldra");
            return;
        }

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
        Singletons.cli.setPassword(Encriptador.encriptarTokenMD5(Singletons.cli.getPassword()));
        if (Singletons.cli != null) {
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
