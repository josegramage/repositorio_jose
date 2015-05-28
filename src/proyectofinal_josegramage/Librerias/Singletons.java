/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Librerias;

import proyectofinal_josegramage.Clases.JDKP_Fondo;
import proyectofinal_josegramage.Clases.JPanel_Fondo;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.autocomplete.AutocompleteJComboBox;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Pager;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Crear;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_Modif;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Config;
import proyectofinal_josegramage.Modulos.Menu.Vista.Vtna_Menu_Admin;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_SignIN;
import proyectofinal_josegramage.Modulos.Login.Vista.Vtna_Recuperar;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.SimpleTableModel_cliente;
import proyectofinal_josegramage.Modulos.Clientes.Vista.Vtna_cli_MiPerfil;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_panel_Inicio;
import proyectofinal_josegramage.Modulos.Juegos.Clases.Juego;
import proyectofinal_josegramage.Modulos.Juegos.Modelo.autocomplete.AutocompleteJComboBox_J;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Crear;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Modif;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;
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
    public static Vtna_panel_Inicio iniPanel;
    public static Vtna_Menu_Admin menu;
    public static Vtna_Config config;
    
    //PAGER CLIENTE
    public static Vtna_cli_Pager efPager;
    public static Vtna_cli_Crear efCrear;
    public static Vtna_cli_Modif efModif;
    public static Vtna_cli_MiPerfil cliMP;
    
    //MODULO CLIENTE
    public static ArrayList<Cliente> cliArray;
    public static ArrayList<Cliente> cliLogArray;
    public static Cliente cli= new Cliente();
    public static Cliente cliLog= new Cliente();   // cliente logueado
    public static int pos;
    public static int posEmp=-1;
    public static ArrayList<Cliente> client = new ArrayList<Cliente>();
    public static String PATH_auto="";
    public static String ruta_avatar;
    
    //MODULO JUEGOS
    public static ArrayList<Juego> jueArray;
    public static Juego jue;
    public static int posJ;
    public static int posJue=-1;
    public static ArrayList<Juego> jueg = new ArrayList<Juego>();
    public static String PATH_auto_Img="";
    public static String ruta_imagen;
    
    //PAGER JUEGOS
    public static Vtna_jue_Pager juePager;
    public static Vtna_jue_Crear jueCrear;
    public static Vtna_jue_Modif jueModif;
    
    
    //FONDO / PANEL / TABLA / COMBO
    public static JPanel_Fondo panel;
    public static JDKP_Fondo fondo;
    public static AutocompleteJComboBox combo = null;
    public static AutocompleteJComboBox_J combo_J = null;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new SimpleTableModel_cliente());

    
    
}
