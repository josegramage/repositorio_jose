/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO;

import com.mysql.jdbc.CallableStatement;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Clases.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;

/**
 *
 * @author Joso
 */
public class ClienteDAO_bd {

    //crear cliente nuevo
    public static int nuevoClienteDAO(Connection con) {
        PreparedStatement stmt = null;
        int resultado = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO proyectofinal_josegramage.clientes ("
                    + "Nombre, Apellidos, Dni, Telefono, Direccion, Email, Fnacimiento, Fechaalta,"
                    + "Login, Password, Estado, Tipo, Avatar)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

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

            resultado = stmt.executeUpdate();

       //     JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
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

    //listar todos los clientes
    public void listarClienteDAO(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Singletons.cliArray.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM proyectofinal_josegramage.clientes");
            rs = stmt.executeQuery();
            Cliente _cliente = null;
            while (rs.next()) {
                _cliente = new Cliente();
                _cliente.setNombre(rs.getString("Nombre"));
                _cliente.setApellidos(rs.getString("Apellidos"));
                _cliente.setDni(rs.getString("Dni"));
                _cliente.setTelefono(rs.getString("Telefono"));
                _cliente.setDireccion(rs.getString("Direccion"));
                _cliente.setEmail(rs.getString("Email"));
                _cliente.setFnacimiento(Fecha.muestraFecha(rs.getString("Fnacimiento")));
                _cliente.setFechaalta(Fecha.muestraFecha(rs.getString("Fechaalta")));
                _cliente.setLogin(rs.getString("Login"));
                _cliente.setPassword(rs.getString("Password"));
                _cliente.setEstado(rs.getString("Estado"));
                _cliente.setTipo(rs.getString("Tipo"));
                _cliente.setAvatar(rs.getString("Avatar"));

                Singletons.cliArray.add(_cliente);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
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

            stmt = con.prepareStatement("UPDATE proyectofinal_josegramage.clientes SET Nombre=?, Apellidos=?, Dni=?, Telefono=?, Direccion=?, Email=?, Fnacimiento=?, Fechaalta=?, Login=?, Password=?, Estado=?, Tipo=?, Avatar=? WHERE Dni=?");
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
    
    public void modificarClienteLogeado(Connection con) {
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE proyectofinal_josegramage.clientes SET Nombre=?, Apellidos=?, Dni=?, Telefono=?, Direccion=?, Email=?, Fnacimiento=?, Fechaalta=?, Login=?, Password=?, Estado=?, Tipo=?, Avatar=? WHERE Dni=?");
            stmt.setString(1, Singletons.cliLog.getNombre());
            stmt.setString(2, Singletons.cliLog.getApellidos());
            stmt.setString(3, Singletons.cliLog.getDni());
            stmt.setString(4, Singletons.cliLog.getTelefono());
            stmt.setString(5, Singletons.cliLog.getDireccion());
            stmt.setString(6, Singletons.cliLog.getEmail());
            stmt.setString(7, Singletons.cliLog.getFnacimiento().aStringFecha());
            stmt.setString(8, Singletons.cliLog.getFechaalta().aStringFecha());
            stmt.setString(9, Singletons.cliLog.getLogin());
            stmt.setString(10, Singletons.cliLog.getPassword());
            stmt.setString(11, Singletons.cliLog.getEstado());
            stmt.setString(12, Singletons.cliLog.getTipo());
            stmt.setString(13, Singletons.cliLog.getAvatar());

            stmt.setString(14, Singletons.cliLog.getDni());
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
            JOptionPane.showMessageDialog(null, "Cuenta eliminada con éxito");
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
    
    
    
     public void clienteMenorMayorDAO(Connection con) {

        com.mysql.jdbc.CallableStatement cstmt = null;
        String cadena = "";

        try {
            cstmt = (com.mysql.jdbc.CallableStatement) con.prepareCall("{call mayor_menor_cliente(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            cadena = cadena + "Cliente joven: " + cstmt.getInt(1) + " años" + "\n";
            cadena = cadena + "Cliente mayor: " + cstmt.getInt(2) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Cliente joven/mayor", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }

    public void EdadMediaDAO(Connection con) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) con.prepareCall("{call media_edad_clientes(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Edad media: " + (int) cstmt.getDouble(1) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Edad media", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }
    
    
    
    
    
    
    
}
