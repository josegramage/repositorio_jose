package proyectofinal_josegramage.Clases;

import java.util.ArrayList;


import proyectofinal_josegramage.Modulos.Clientes.Modelo.BLL.ClienteBLL;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Singletons;
import proyectofinal_josegramage.Utiles.Apariencia;
import javax.swing.JOptionPane;
import proyectofinal_josegramage.Modulos.Clientes.Clases.Cliente;


public class Config {

    private char moneda;
    private String decimales;
    private String formatoFecha;
    public String guardar;
    private static int apariencia;

    public Config() {

        this.moneda = '€';
        this.decimales = "2";
        this.formatoFecha = "1";
        this.guardar = "2";
        apariencia = 0;
                   
       Singletons.cliArray = new ArrayList<Cliente>();
           }
   
    
    public String toString() {
        return "moneda=" + moneda + ", decimales=" + decimales + ", formatoFecha=" + formatoFecha;
    }

    public char getMoneda() {
        return moneda;
    }

    public void setMoneda(char moneda) {
        this.moneda = moneda;
    }

    public String getDecimales() {
        return decimales;
    }

    public void setDecimales(String decimales) {
        this.decimales = decimales;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

   public int getApariencia() {
		return apariencia;
	}
	
	public void setApariencia(int apariencia) {
            this.apariencia=apariencia;
	        Apariencia.apariencia(apariencia);
        }

        
    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }
}
