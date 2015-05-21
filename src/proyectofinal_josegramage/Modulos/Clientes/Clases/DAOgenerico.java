package proyectofinal_josegramage.Modulos.Clientes.Clases;

import javax.swing.JOptionPane;

import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Librerias.Validate;


public class DAOgenerico {

	// Datos personales // Nombre, Apellidos, Dni, Telefono

	public static String pideNombre(String mensaje) {
		String nombre = "";
		boolean val = true;

		do {
			nombre = Funciones.pedirString(mensaje);
			val = Validate.validaNombre(nombre);
			if (val == false)
                        JOptionPane.showMessageDialog(null, "No ha introducido el nombre correctamente", "Información",
			JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);

		return nombre;
	}

	public static String pideApellidos(String mensaje) {
		String apellidos = "";
		boolean val = true;

		do {
			apellidos = Funciones.pedirString(mensaje);
			val = Validate.validaApellido(apellidos);
			if (val == false)
				JOptionPane.showMessageDialog(null, "No ha introducido los apellidos correctamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);

		return apellidos;
	}

	public static String pideDni(String mensaje) {
		String dni = "";
		boolean val = true;

		do {
			dni = Funciones.pedirString(mensaje);
			val = Validate.validaDNI(dni);
			if (val == false)
				JOptionPane.showMessageDialog(null, "No ha introducido el dni correctamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);

		return dni;
	}

	public static String pideTelefono(String mensaje) {
		String telefono = "";
		boolean val = true;

		do {
			telefono = Funciones.pedirString("Telefono del empleado");
			val = Validate.validaNumTelefono(telefono);
			if (val == false)
				JOptionPane.showMessageDialog(null, "No ha introducido el telefono correctamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);

		return telefono;
	}

	// Para pedir fecha

	public static Fecha pedirFecha(String mensaje) {

		String fecha = "";
		boolean val = true;
		int dia = 0, mes = 0, anyo = 0;
		Fecha f = new Fecha(fecha, dia, mes, anyo);

		do {
			fecha = Funciones.pedirString(mensaje);
			val = Validate.validaFecha(fecha);
			f = f.muestraFecha(fecha);
			dia = f.comprobarDia();
			mes = f.comprobarMes();
			anyo = f.comprobarAnyo();

		} while ((val == false) && (dia == -1) && (mes == -1) && (anyo == -1));

		return f;
	}
        
        // pedir fecha para NetBeans (sin JoptionPane)
        
        public static Fecha pedirFechaNB(String mensaje) {

		String fecha = "";
		boolean val = true;
		int dia = 0, mes = 0, anyo = 0;
		Fecha f = new Fecha(fecha, dia, mes, anyo);

		do {
			fecha = mensaje;
			val = Validate.validaFecha(fecha);
			f = f.muestraFecha(fecha);
			dia = f.comprobarDia();
			mes = f.comprobarMes();
			anyo = f.comprobarAnyo();

		} while ((val == false) && (dia == -1) && (mes == -1) && (anyo == -1));

		return f;
	}
        
        
        
       
        
          
            
}
     /*  
        public static DefaultComboBoxModel PlenaComboBox(){
			DefaultComboBoxModel modelo = new DefaultComboBoxModel();
			for(int i=0;i<(AlistEF.efi.size());i++)
				modelo.addElement(AlistEF.efi.get(i).getDNI());
			return modelo;
		}
	jComboBox1.setModel(Funciones.PlenaComboBox());
        
        
        if(emp instanceof EmpleadoHora)
        {
            for(i=0;i<(PalEmpleados.eh.size());i++)
            {
                PalEmpleados.horas=PalEmpleados.eh.get(i);
                modelo.addElement(PalEmpleados.horas.getDNI());
            }
        }
        if(emp instanceof EmpleadoTemporal)
        {
            for(i=0;i<(PalEmpleados.et.size());i++)
            {
                PalEmpleados.temporal=PalEmpleados.et.get(i);
                modelo.addElement(PalEmpleados.temporal.getDNI());
            }
        }

// Para llenar Combo boxs
        public static DefaultComboBoxModel LlenaComboBox(Empleado emp)
    {
        int i=0;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        if(emp instanceof EmpleadoFijo)
        {
            for(i=0;i<(Ppal_Main.efi.size());i++)
            {
                Ppal_Main.fijo=Ppal_Main.efi.get(i);
                modelo.addElement(Ppal_Main.fijo.getDni());
            }
          //mirar chuleta  
        }
        return modelo;


     */
             