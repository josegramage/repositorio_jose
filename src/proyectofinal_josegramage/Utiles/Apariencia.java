package proyectofinal_josegramage.Utiles;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Apariencia {

	 public static void apariencia(int ap) {
                                 
	        try {
	            switch (ap) {
	                case 0:// Metal
                            JOptionPane.showMessageDialog(null,"apariencia");
                             try {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    } catch (Exception e) {
                    }
	                    break;

	                case 1:// GTK - WINDOWS
	                     try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (Exception e) {
                    }

                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                    break;

	                case 2:// CDE/Motif
	                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	                    break;

	                case 3:// Nimbus
					    try {
                        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (Exception e) {
                    }
	                    break;

	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
	            JOptionPane.showMessageDialog(null,
	                    "No pudo cargarse la apariencia deseada\n" + e.getMessage(), "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}