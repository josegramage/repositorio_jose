/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Clases;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JDesktopPane;

/**
 *
 * @author Joso
 */
public class JDKP_Fondo extends JDesktopPane{
    
    URL imagen1 = JDKP_Fondo.class.getResource("/proyectofinal_josegramage/Img/fondos/fondo.jpg");
    Image imagen=Toolkit.getDefaultToolkit().getImage(imagen1);

    @Override
    public void paint(Graphics g)
    {

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),  this);  //la imagen se redimensiona
            setOpaque(false);
            super.paint(g);
    }
    
    
}
