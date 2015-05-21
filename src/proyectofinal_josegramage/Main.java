/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage;

import proyectofinal_josegramage.Clases.Config;
import proyectofinal_josegramage.Modulos.Inicio.Controlador.Controlador_Inicio;
import proyectofinal_josegramage.Modulos.Inicio.Vista.Vtna_Inicio;

/**
 *
 * @author Joso
 */
public class Main {

    public static Config conf = null;
    
    
    public static void main(String[] args) {
       
        conf = new Config();
        
          new Controlador_Inicio(new Vtna_Inicio(), 0).iniciar(0);
    }  
}
