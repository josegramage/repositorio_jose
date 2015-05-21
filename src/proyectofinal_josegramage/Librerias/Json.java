package proyectofinal_josegramage.Librerias;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;





public class Json {  
    
	
	
	public static void guardarJSON() {
        String PATH;

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("EmpleadoFijo", Cliente.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".json")) {
                    PATH = PATH + ".json";
                }

                Gson gson = new Gson();
                String json = gson.toJson(Singletons.cliArray);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                JOptionPane.showMessageDialog(null,
                        "Archivo JSON guardado con exito", "Archivo JSON",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (/*HeadlessException | IOException */ Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el JSON",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Cliente> abrirJSON() {
        String PATH;
        Cliente a;

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("EmpleadoFijo", Cliente.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                Singletons.cliArray.clear();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();

                for (JsonElement elemento : lista) {
                    a = json.fromJson(elemento, Cliente.class);
                    Singletons.cliArray.add(a);
                }

                JOptionPane.showMessageDialog(null,
                        "Archivo JSON abierto con exito", "Archivo JSON",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el JSON",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return Singletons.cliArray;
    }
 
    
    public static void guardarJSONocultoEmpFijo() {//Guarda Json de empleadosfijos de forma silenciosa
    	String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("EmpleadoFijo", Cliente.class);


	                PATH = new java.io.File(".").getCanonicalPath()+"/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.json";
	           
	              
	                Gson gson = new Gson();
		            String json1 = gson.toJson(Singletons.cliArray);
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json1.toString());
	                fileXml.close();
	               
   
	          
        } catch (Exception e) {
        }	
    }
    
    public static ArrayList<Cliente> abrir_jsonOcultoEF(){//Abre json de empleados fijos de forma silenciosa
    	String PATH = null;
    	Cliente e1=new Cliente("");
    	
        try {
        	
            PATH = new java.io.File(".").getCanonicalPath()+"/src/framework/Modulos/GestionEmpleados/GestionEF/Modelo/Archivos/EmpFijo.json";
            
	                Singletons.cliArray.clear();
	               
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                 
	                
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	              
	            	Gson Json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            		e1 = Json.fromJson(elemento, Cliente.class);
	            		Singletons.cliArray.add(e1);
	            	}
        } catch (Exception e) {

        }
        return Singletons.cliArray;
    }
}