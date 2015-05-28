/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL;

import proyectofinal_josegramage.Clases.ConexionBD;
import proyectofinal_josegramage.Librerias.Singletons;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO.JuegoDAO_bd;

/**
 *
 * @author Joso
 */
public class JuegoBLL_bd {

    //crea juegos
    public static int nuevoJuegoBLL() {
        int resultado = 0;
        Connection _con = null;
        
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
       
        resultado = JuegoDAO_bd.nuevoJuegoDAO(_con);

        _conexion_DB.CerrarConexion(_con);
        return resultado;
    }
    
    
    
    //listar juegos
    public static void listarJuegoBLL() {
        
        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        JuegoDAO_bd _juegoDAO = new JuegoDAO_bd();
 
        try {

            _juegoDAO.listarJuegoDAO(_con);//Recuperamos los juegos 
         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger -listar juego BLL-");
        }
        _conexion_DB.CerrarConexion(_con);
    }

    
     // modificar juegos
    public static void modificarJuegoBLL() {
        Connection _con;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        JuegoDAO_bd _juegoDAO = new JuegoDAO_bd();

        _juegoDAO.modificarJuegoDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

     // eliminar juegos
    public static void borrarJuegoBLL() {
        Connection _con;
        Juego _juegoborrado = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        JuegoDAO_bd _juegoDAO = new JuegoDAO_bd();
        _juegoborrado = _juegoDAO.borrarJuegoDAO(_con, Singletons.jue);
        _conexion_DB.CerrarConexion(_con);
    }

     //buscar por ref al juegos
    public static boolean buscarRefBLL() {
        Connection _con = null;
        boolean buscar;
        

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        JuegoDAO_bd _juegoDAO = new JuegoDAO_bd();
                
        buscar = _juegoDAO.buscarRefDAO(_con);
        _conexion_DB.CerrarConexion(_con);
        return buscar;
    }
}
