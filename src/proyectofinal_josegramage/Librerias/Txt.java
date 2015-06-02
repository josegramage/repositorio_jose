package proyectofinal_josegramage.Librerias;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;


public class Txt {

	public static void guardarTXTcliente() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(Singletons.cliArray);
				o.close();
				JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
        
        public static void guardarTXTjuego() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(Singletons.jueArray);
				o.close();
				JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static ArrayList<Cliente> abrirTXTempfijo() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				f = new File(PATH);

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				Singletons.cliArray = (ArrayList<Cliente>) oi.readObject();
				oi.close();
				JOptionPane.showMessageDialog(null, "Archivo TXT abierto con exito", "Archivo TXT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return Singletons.cliArray;
	}

	public static void guardarTXTocultoEmpFijo() {
		String PATH = null;
		try {
			File f;
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.txt";

			f = new File(PATH);

			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(fo);
			o.writeObject(Singletons.cliArray);
			o.close();
		} catch (Exception e) {
		}
	}

	public static ArrayList<Cliente> abrirTXTocultoEmpFijo() {
		String PATH = null;
		try {
			File f;
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.txt";

			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Singletons.cliArray = (ArrayList<Cliente>) oi.readObject();
			oi.close();

		} catch (Exception e) {

		}
		return Singletons.cliArray;
	}

	
}