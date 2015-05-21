/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal_josegramage.Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

/**
 *
 * @author dai
 */

public class JPanel_Fondo extends JPanel{

    URL imagen1 = JPanel_Fondo.class.getResource("/proyectofinal_josegramage/Img/fondos/fondo.jpg");
    Image imagen=Toolkit.getDefaultToolkit().getImage(imagen1);
    public void paint(Graphics g)
    {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
    }
}
