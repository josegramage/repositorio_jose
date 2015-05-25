/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL;

import proyectofinal_josegramage.Clases.ConexionBD;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO_bd;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;

/**
 *
 * @author Joso
 */
public class ClienteBLL_bd {

    //crea empleado
    public static int nuevoUsuarioBLL() {
        int resultado = 0;
        Connection _con = null;
        
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
       
        resultado = ClienteDAO_bd.nuevoClienteDAO(_con);

        _conexion_DB.CerrarConexion(_con);
        return resultado;
    }
    
    
    
    //listar empleados
    public static void listarClienteBLL() {
        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        ClienteDAO_bd _clienteDAO = new ClienteDAO_bd();
        try {
            _clienteDAO.listarClienteDAO(_con);//Recuperamos los usuarios       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
        }
        _conexion_DB.CerrarConexion(_con);
    }

    
     // modificar empleado
    public static void modificarClienteBLL() {
    
        Connection _con;
   
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        ClienteDAO_bd _clienteDAO = new ClienteDAO_bd();

        _clienteDAO.modificarClienteDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

     // eliminar empleado
    public static void borrarUsuarioBLL() {
        Connection _con;
        Cliente _clienteborrado = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        ClienteDAO_bd _clienteDAO = new ClienteDAO_bd();
        _clienteborrado = _clienteDAO.borrarClienteDAO(_con, Singletons.cli);
        _conexion_DB.CerrarConexion(_con);
    }

     //buscar por dni al empleado
    public static boolean buscarDniBLL() {
        Connection _con = null;
        boolean buscar;
        
        
    //    EmpleadoFijo _clienteObtenido = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        ClienteDAO_bd _clienteDAO = new ClienteDAO_bd();
                
        buscar = _clienteDAO.buscarDniDAO(_con);
        _conexion_DB.CerrarConexion(_con);
        return buscar;
    }
}
