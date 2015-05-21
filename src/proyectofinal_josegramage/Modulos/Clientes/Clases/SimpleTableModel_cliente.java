package proyectofinal_josegramage.Modulos.Clientes.Clases;
import proyectofinal_josegramage.Modulos.Clientes.Clases.DAOgenerico;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL_bd;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.pager.pagina;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;



public class SimpleTableModel_cliente extends AbstractTableModel {
    public static ArrayList<Cliente> datos = new ArrayList<Cliente>();
    public static ArrayList<Cliente> datosaux = new ArrayList<Cliente>();
    String [] columnas = {"DNI", "Nombre", "Apellidos", "Teléfono", "Fecha de nacimiento"};

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
        Cliente fila = (Cliente) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getNombre();
                break;

            case 2:
                dev = fila.getApellidos();
                break;

            case 3:
                dev = fila.getTelefono();
                break;
                
            case 4:
                dev = fila.getFnacimiento();
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
        Cliente fila = (Cliente) datos.get(row);

        switch (col) {
            case 0:
                fila.setDni(value.toString());
                break;

            case 1:
                fila.setNombre(value.toString());
                break;

            case 2:
                fila.setApellidos(value.toString());
                break;
            
            case 3:
                fila.setTelefono(value.toString());
                break;
                        
            case 4:      
                fila.setFnacimiento(DAOgenerico.pedirFecha(value.toString()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Cliente usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        ClienteBLL_bd.listarClienteBLL();
        for (int i=0; i<= Singletons.cliArray.size() -1; i++){
            addRow(Singletons.cliArray.get(i));
            datosaux.add(Singletons.cliArray.get(i));
        }
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    
    
    public void filtrar() {
        datos.clear();
        int cont=0;
        
        String nombre= (String) ((JComboBox)Singletons.combo).getSelectedItem();
        if (nombre!=null){
        for(int i=0;i<datosaux.size();i++) {
            if(datosaux.get(i).getNombre().toLowerCase().startsWith(nombre.toLowerCase())){
                addRow(datosaux.get(i));
                cont++;
            }
        }
        Vtna_cli_Pager.etiFILTRAR.setText(String.valueOf(cont));
        System.out.println("nombre seleccionado: "+ nombre);
        //JOptionPane.showMessageDialog(null, cont);
        pagina.initLinkBox();
    }
    }
    
    
    public Cliente buscar(String u) {
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
    

    public int buscaUsuario(Cliente u) {
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
