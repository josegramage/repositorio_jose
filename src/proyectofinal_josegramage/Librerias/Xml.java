package proyectofinal_josegramage.Librerias;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;


public class Xml {
	private static final String ENCODING = "UTF-8";

	public static void guardarXMLempfijo() {
		String PATH;

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			// Annotations.configureAliases(xstream, Actividades.class);
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Singletons.cliArray, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();

				JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static ArrayList<Cliente> abrirXMLempfijo() {
		String PATH;

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Actividades.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				Singletons.cliArray = (ArrayList<Cliente>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo XML abierto con exito", "Archivo XML",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (HeadlessException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return Singletons.cliArray;
	}

	public static void guardarXMLocultoEmpFijo() {
		String PATH = null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Cliente.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Singletons.cliArray, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.xml";

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (Exception e1) {
		}
	}

	public static ArrayList<Cliente> abrirXMLocultoEmpFijo() {
		String PATH = null;
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Cliente.class);

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.xml";
			Singletons.cliArray = (ArrayList<Cliente>) xstream.fromXML(new FileReader(PATH));

		} catch (Exception e1) {

		}
		return Singletons.cliArray;
	}

	}