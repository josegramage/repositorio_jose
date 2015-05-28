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
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;

/**
 *
 * @author Joso
 */
public class JuegoDAO_bd {

    //crear cliente nuevo
    public static int nuevoJuegoDAO(Connection con) {
        PreparedStatement stmt = null;
        int resultado = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO proyectofinal_josegramage.juegos ("
                    + "Ref, Nombre, Companyia,Fecha_alta, Tipo, Precio, Imagen, Descripcion)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, Singletons.jue.getRef());
            stmt.setString(2, Singletons.jue.getNombre());
            stmt.setString(3, Singletons.jue.getCompanyia());
            stmt.setString(8, Singletons.jue.getFecha_alta().aStringFecha());
            stmt.setString(9, Singletons.jue.getTipo());
            stmt.setFloat(10, Singletons.jue.getPrecio());
            stmt.setString(11, Singletons.jue.getImagen());
            stmt.setString(12, Singletons.jue.getDescripcion());

            resultado = stmt.executeUpdate();

       //     JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo juego!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
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
                _juego.setPrecio(rs.getFloat("Precio"));
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
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }

    public void modificarClienteDAO(Connection con) {
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE proyectofinal_josegramage.juegos SET Ref=?, Nombre=?, Companyia=?, Fecha_alta=?, Tipo=?, Precio?, Imagen?, Descripcion=? WHERE Ref=?");
            stmt.setString(1, Singletons.cli.getNombre());
            stmt.setString(2, Singletons.cli.getApellidos());
            stmt.setString(3, Singletons.cli.getDni());
            stmt.setString(4, Singletons.cli.getTelefono());
            stmt.setString(5, Singletons.cli.getDireccion());
            stmt.setString(6, Singletons.cli.getEmail());
            stmt.setString(7, Singletons.cli.getFnacimiento().aStringFecha());
            stmt.setString(8, Singletons.cli.getFechaalta().aStringFecha());
            stmt.setString(9, Singletons.cli.getLogin());
            stmt.setString(10, Singletons.cli.getPassword());
            stmt.setString(11, Singletons.cli.getEstado());
            stmt.setString(12, Singletons.cli.getTipo());
            stmt.setString(13, Singletons.cli.getAvatar());

            stmt.setString(14, Singletons.cli.getDni());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }

    //Borrar cliente
    public Cliente borrarClienteDAO(Connection con, Cliente cli) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM proyectofinal_josegramage.clientes WHERE Dni=?");
            stmt.setString(1, cli.getDni());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return cli;
    }

    //Buscar por dni al empleado
    public boolean buscarDniDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean buscar = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM proyectofinal_josegramage.clientes WHERE Dni=?");
            stmt.setString(1, Singletons.cli.getDni());
            rs = stmt.executeQuery();
            while (rs.next()) {

                obtenerFilaCliente(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por DNI");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
        }
        return buscar;
    }

    private void obtenerFilaCliente(ResultSet rs) {
        try {

            Singletons.cli.setNombre(rs.getString("Nombre"));
            Singletons.cli.setApellidos(rs.getString("Apellidos"));
            Singletons.cli.setDni(rs.getString("Dni"));
            Singletons.cli.setTelefono(rs.getString("Telefono"));
            Singletons.cli.setDireccion(rs.getString("Direccion"));
            Singletons.cli.setEmail(rs.getString("Email"));
            Singletons.cli.setFnacimiento(Fecha.muestraFecha(rs.getString("Fnacimiento")));
            Singletons.cli.setFechaalta(Fecha.muestraFecha(rs.getString("Fechaalta")));
            Singletons.cli.setLogin(rs.getString("Login"));
            Singletons.cli.setPassword(rs.getString("Password"));
            Singletons.cli.setEstado(rs.getString("Estado"));
            Singletons.cli.setTipo(rs.getString("Tipo"));
            Singletons.cli.setAvatar(rs.getString("Avatar"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }
    }
}
