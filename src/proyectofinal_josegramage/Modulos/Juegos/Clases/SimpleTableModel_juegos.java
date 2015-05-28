package proyectofinal_josegramage.Modulos.Juegos.Clases;

import proyectofinal_josegramage.Modulos.Juegos.Clases.DAOgenericoJ;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL.JuegoBLL;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.BLL.JuegoBLL_bd;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.pager.pagina_J;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import proyectofinal_josegramage.Librerias.Singletons;

public class SimpleTableModel_juegos extends AbstractTableModel {

    public static ArrayList<Juego> datos = new ArrayList<Juego>();
    public static ArrayList<Juego> datosaux = new ArrayList<Juego>();
    String[] columnas = {"Ref", "Nombre", "Companyia", "Precio", "Tipo", "Fecha de alta"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        Juego fila = (Juego) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getRef();
                break;

            case 1:
                dev = fila.getNombre();
                break;

            case 2:
                dev = fila.getCompanyia();
                break;

            case 3:
                dev = fila.getPrecio();
                break;

            case 4:
                dev = fila.getTipo();
                break;

            case 5:
                dev = fila.getFecha_alta();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Juego fila = (Juego) datos.get(row);

        switch (col) {
            case 0:
                fila.setRef(value.toString());
                break;

            case 1:
                fila.setNombre(value.toString());
                break;

            case 2:
                fila.setCompanyia(value.toString());
                break;

            case 3:
                ((Juego) fila).setPrecio(Float.parseFloat(value.toString()));
                break;

            case 4:
                fila.setTipo(value.toString());
                break;

            case 5:
                fila.setFecha_alta(DAOgenericoJ.pedirFecha(value.toString()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Juego usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        JuegoBLL_bd.listarJuegoBLL();
        for (int i = 0; i <= Singletons.jueArray.size() - 1; i++) {
            addRow(Singletons.jueArray.get(i));
            datosaux.add(Singletons.jueArray.get(i));
        }
        try {
            Thread.sleep(1); //1 milliseconds
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void filtrar() {
        datos.clear();
        int cont = 0;

        String nombre = (String) ((JComboBox) Singletons.combo).getSelectedItem();
        if (nombre != null) {
            for (int i = 0; i < datosaux.size(); i++) {
                if (datosaux.get(i).getNombre().toLowerCase().startsWith(nombre.toLowerCase())) {
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            Vtna_jue_Pager.etiFILTRAR.setText(String.valueOf(cont));
            System.out.println("nombre seleccionado: " + nombre);
            //JOptionPane.showMessageDialog(null, cont);
            pagina_J.initLinkBox();
        }
    }

    public Juego buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Juego u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }

    //para pintar ImageIcon
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}
