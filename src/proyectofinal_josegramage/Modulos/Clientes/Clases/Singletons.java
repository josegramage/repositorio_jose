/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Modulos.Clientes.Clases;

import proyectofinal_josegramage.Clases.JDKP_Fondo;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.autocomplete.AutocompleteJComboBox;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Config;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Menu_Admin;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignUP;

/**
 *
 * @author Joso
 */
public class Singletons {
    
    //MODULO LOGIN
    public static Vtna_SignIN login;
    public static Vtna_SignUP alta;
    public static Vtna_Recuperar recu;
    public static boolean conectado;

       
    //MODULO MENU
    public static Vtna_Inicio ini;
    public static Vtna_Menu_Admin menu;
    public static Vtna_Config config;
    
    //PAGER
    public static Vtna_cli_Pager efPager;
    public static Vtna_cli_Crear efCrear;
    public static Vtna_cli_Modif efModif;
    
    //MODULO CLIENTE
    public static ArrayList<Cliente> cliArray;
    public static ArrayList<Cliente> cliLogArray;
    public static Cliente cli;
    public static Cliente cliLog= new Cliente();   // cliente logueado
    public static int pos;
    public static int posEmp=-1;
    public static ArrayList<Cliente> client = new ArrayList<Cliente>();
    public static String PATH_auto="";
    public static String ruta_avatar;
    
    //FONDO / PANEL / TABLA / COMBO
    public static JPanel_Fondo panel;
    public static JDKP_Fondo fondo;
    public static AutocompleteJComboBox combo = null;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new SimpleTableModel_cliente());

    
    
}
