package proyectofinal_josegramage.Utiles;

import javax.swing.JOptionPane;


public class Menus {

	// MENU (botones)
	public static int menu(String[] tipo, String titulo) {
		int op = 0;
		op = JOptionPane.showOptionDialog(null, "Elija una opcion", titulo, 0, JOptionPane.QUESTION_MESSAGE, null,
				tipo, tipo[0]);
		return op;
	}
	
	public static String genericMenu(Object vMenu[], String s){
		//Menu de opciones con combo-box
		String op = "";
		Object seleccion = JOptionPane.showInputDialog(
				   null,s,"Menu",JOptionPane.QUESTION_MESSAGE,
				   null,vMenu,"vMenu[0]");					 
			if(seleccion==null)			
				op = (String)"Salir";			
			else
				op = (String)seleccion;
		return op;
	}
	
	public static String genericMenu2(Object o, String s){
		//Menu de opciones con combo-box
		String op = "";
		Object seleccion = JOptionPane.showInputDialog(
				   null,s);					 
			if(seleccion==null)			
				op = (String)"Salir";			
			else
				op = (String)seleccion;
		return op;
	}
	

	public static int menuCboxInt(Object vMenu[], String s){
		int resp;
		//String[] tipo = {"Gesti�n de Clientes","Gesti�n de Socios","Gesti�n de Productos","Venta","Info. Cuenta","Configuraci�n","Salir"};
		resp = JOptionPane.showOptionDialog(null,
				null,null,0,JOptionPane.QUESTION_MESSAGE,null,null,vMenu[0]);
		return resp;
	}
	
	// Menu (combobox)
	public static String menuCbox(String[] opciones, String titulo, String mensaje) {
		String operacion = "";

		Object seleccion = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, null,
				opciones, opciones[0]);

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else
			operacion = seleccion.toString();

		return operacion;
	}
	

	// continuar con S/N
	public static char continuarSN() {
		char seguir = 's';
		String s;
		boolean correcto = true;
		do {
			do {
				try {
					s = JOptionPane.showInputDialog(null, "Deseas continuar (S/N)", "Continuar?",
							JOptionPane.QUESTION_MESSAGE);
					seguir = s.charAt(0);
					seguir = Character.toUpperCase(seguir);
					correcto = true;

				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(null, "Error al introducir datos", "Error", JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} while (correcto == false);
			if ((seguir != 'S') && (seguir != 'N'))
				JOptionPane.showMessageDialog(null, "No has introducido S o N", "Error", JOptionPane.ERROR_MESSAGE);
		} while ((seguir != 'S') && (seguir != 'N'));

		return seguir;
	}
	
	
	// MENU APARIENCIA
	
	public static int menuApariencia() {
		int resp;
		int theme=0;
		String[] tipo = { "Metal", "GTK", "CDE", "Nimbus", "Volver" };
		do {
			resp = JOptionPane.showOptionDialog(null, "Seleccione la apariencia:", "MENUS DE CONFIGURACION", 0,
					JOptionPane.QUESTION_MESSAGE, null, tipo, tipo[0]);
			switch (resp) {
			case 0:
				Apariencia.apariencia(theme=0);
				break;
			case 1:
				Apariencia.apariencia(theme=1);
				break;
			case 2:
				Apariencia.apariencia(theme=2);
				break;
			case 3:
				Apariencia.apariencia(theme=3);
				break;
			case 4:
				break;
			}
		} while (resp < 4);
		return resp;
	}
	

	// Menu formato moneda (euro, libra, dolar, yen)

	public static char menuFormatoMoneda() {
		char s = ' ';
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione que moneda desea:", "Selector de opciones",
				JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
				new Object[] { "Euro", "Libra", "Dolar", "Yen" }, "Euro");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);

		} else if (seleccion == "Euro") {
			s = 'E';
		} else if (seleccion == "Libra") {
			s = 'L';
		} else if (seleccion == "Dolar") {
			s = '$';
		} else if (seleccion == "Yen") {
			s = 'Y';
		}
		return s;

	}

	// Menu formato decimales (1,2,3)

	  public static String menuFormatoDecimales() {
		String s = "";
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione cuantos decimales desea:",
				"Selector de opciones", JOptionPane.QUESTION_MESSAGE, null, 
				new Object[] { "1 decimal", "2 decimales", "3 decimales" }, "1 decimal");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicación", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (seleccion == "1 decimal") {
			s = "1";
		} else if (seleccion == "2 decimales") {
			s = "2";
		} else if (seleccion == "3 decimales") {
			s = "3";
		}
		return s;
	}

	// Menu formato fechas
	
	public static String menuFormatoFecha() {
		String s = "";
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione el formato de fecha que desea:",
				"Selector de opciones", JOptionPane.QUESTION_MESSAGE, null, 
				new Object[] { "dd/mm/yyyy", "mm/dd/yyyy", "dd-mm-yyyy", "mm-dd-yyyy","dd.mm.yyyy", "mm.dd.yyyy"   }, "dd/mm/yyyy");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacionn", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (seleccion == "dd/mm/yyyy") {
			s = "1";
		} else if (seleccion == "mm/dd/yyyy") {
			s = "2";
		} else if (seleccion == "dd-mm-yyyy") {
			s = "3";
		} else if (seleccion == "mm-dd-yyyy") {
			s = "4";
		} else if (seleccion == "dd.mm.yyyy") {
			s = "5";
		} else if (seleccion == "mm.dd.yyyy") {
			s = "6";
		}
		return s;
	}
	
	
	
	public static int GuardarSalirSiNo(int i){
		String s="";
		int resp2;
		if(i==0)
		s=s+"Aviso";

			String[] tipo3={"Si","No"};
			resp2 = JOptionPane.showOptionDialog(null,
			"¿Guardar antes de salir?",s,0,
			JOptionPane.QUESTION_MESSAGE,null,tipo3,tipo3[0]);
			return resp2;
		}
	
	
		
		public static String menuFormatoGuardar(){
			String s="";
			Object seleccion = JOptionPane.showInputDialog(
					   null,
					   "Seleccione con que tipo de fichero desea trabajar:",
					   "Selector de opciones",
					   JOptionPane.QUESTION_MESSAGE,
					   null,  // null para icono defecto
					   new Object[] { "JSON", "TXT", "XML"},
					   "JSON");
			
			if(seleccion==null){
		
			}else if (seleccion=="JSON"){
				s="1";
			}
			else if (seleccion=="TXT"){
				s="2";
			}
			else if (seleccion=="XML"){
				s="3";
			}
			return s;
		}	
}