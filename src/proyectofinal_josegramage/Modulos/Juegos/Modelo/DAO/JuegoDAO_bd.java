/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Juegos.Modelo.DAO;

import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Clases.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;

/**
 *
 * @author Joso
 */
public class JuegoDAO_bd {

    //crear juego nuevo
    public static int nuevoJuegoDAO(Connection con) {
        PreparedStatement stmt = null;
        int resultado = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO proyectofinal_josegramage.juegos ("
                    + "Ref, Nombre, Companyia, Fecha_alta, Tipo, Precio, Imagen, Descripcion)"
                    + "VALUES(?,?,?,?,?,?,?,?)");

            stmt.setString(1, Singletons.jue.getRef());
            stmt.setString(2, Singletons.jue.getNombre());
            stmt.setString(3, Singletons.jue.getCompanyia());
            stmt.setString(4, Singletons.jue.getFecha_alta().aStringFecha());
            stmt.setString(5, Singletons.jue.getTipo());
            stmt.setString(6, Singletons.jue.getPrecio());
            stmt.setString(7, Singletons.jue.getImagen());
            stmt.setString(8, Singletons.jue.getDescripcion());

            resultado = stmt.executeUpdate();

       //     JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo juego!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger -crear juego-");
                }
            }
        }
        return resultado;
    }

    //listar todos los juegos
    public void listarJuegoDAO(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Singletons.jueArray.clear();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM proyectofinal_josegramage.juegos");
            rs = stmt.executeQuery();
            Juego _juego = null;
            while (rs.next()) {
              
                _juego = new Juego();
                _juego.setRef(rs.getString("Ref"));
                _juego.setNombre(rs.getString("Nombre"));
                _juego.setCompanyia(rs.getString("Companyia"));
                _juego.setFecha_alta(Fecha.muestraFecha(rs.getString("Fecha_alta")));
                _juego.setTipo(rs.getString("Tipo"));
                _juego.setPrecio(rs.getString("Precio"));
                _juego.setImagen(rs.getString("Imagen"));
                _juego.setDescripcion(rs.getString("Descripcion"));       

                Singletons.jueArray.add(_juego);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los juegos!");
        } finally {
      
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger -listar juegos-");
                }
            }
        }
    }

    public void modificarJuegoDAO(Connection con) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE proyectofinal_josegramage.juegos SET Ref=?, Nombre=?, Companyia=?, Fecha_alta=?, Tipo=?, Precio=?, Imagen=?, Descripcion=? WHERE Ref=?");
            stmt.setString(1, Singletons.jue.getRef());
            stmt.setString(2, Singletons.jue.getNombre());
            stmt.setString(3, Singletons.jue.getCompanyia());
            stmt.setString(4, Singletons.jue.getFecha_alta().aStringFecha());
            stmt.setString(5, Singletons.jue.getTipo());
            stmt.setString(6, Singletons.jue.getPrecio());
            stmt.setString(7, Singletons.jue.getImagen());
            stmt.setString(8, Singletons.jue.getDescripcion());

            stmt.setString(9, Singletons.jue.getRef());
   
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el juego!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger -modif juego-");
                }
            }
        }
    }

    //Borrar juego
    public Juego borrarJuegoDAO(Connection con, Juego jue) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM proyectofinal_josegramage.juegos WHERE Ref=?");
            stmt.setString(1, jue.getRef());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Juego eliminado con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el juego!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger -borrar juego-");
                }
            }
        }
        return jue;
    }

    //Buscar por ref al juego
    public boolean buscarRefDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean buscar = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM proyectofinal_josegramage.juegos WHERE Ref=?");
            stmt.setString(1, Singletons.jue.getRef());
            rs = stmt.executeQuery();
            while (rs.next()) {

                obtenerFilaJuego(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el juego por su referencia");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger -buscar ref1-");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger -buscar ref2-");
                }
            }
        }
        return buscar;
    }

    private void obtenerFilaJuego(ResultSet rs) {
        try {

            Singletons.jue.setRef(rs.getString("Ref"));
            Singletons.jue.setNombre(rs.getString("Nombre"));
            Singletons.jue.setCompanyia(rs.getString("Companyia"));
            Singletons.jue.setFecha_alta(Fecha.muestraFecha(rs.getString("Fecha_alta")));
            Singletons.jue.setTipo(rs.getString("Tipo"));
            Singletons.jue.setPrecio(rs.getString("Precio"));
            Singletons.jue.setImagen(rs.getString("Imagen"));
            Singletons.jue.setDescripcion(rs.getString("Descripcion"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger -obtener fila-");
        }
    }
}
