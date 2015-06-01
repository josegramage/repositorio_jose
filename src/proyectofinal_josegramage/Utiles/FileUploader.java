/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Utiles;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import proyectofinal_josegramage.Librerias.Funciones;
import proyectofinal_josegramage.Librerias.Singletons;
import proyectofinal_josegramage.Modulos.Clientes.Modelo.DAO.ClienteDAO;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joso
 */
public class FileUploader {

    //  CARGAR - MOSTRAR AVATAR
    public static void lista_blanca(JFileChooser buscador) {
        buscador.setAcceptAllFileFilterUsed(false);
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (*.jpg, *.gif, *.png)", "jpg", "gif", "png"));
    }

    public static void pintar_guardar_img(JLabel etiAvatar, int ancho, int alto, int i) {
        String ruta;
        File imagen;
        BufferedImage image;
        String extension = "";
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            ruta = imagen.getAbsolutePath();
            if (ruta.length() > 500) {
                JOptionPane.showMessageDialog(null, "La ruta de la imagen debe "
                        + "tener como máximo 500 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                if (i == 0) {
                    ImageIcon icon = new ImageIcon(ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.efCrear.etiAvatar.setIcon(newIcon); //pintamos la imagen en jlabel1
                } else if (i == 1) {
                    ImageIcon icon = new ImageIcon(ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.efModif.etiAvatarM.setIcon(newIcon); //pintamos la imagen en jlabel1
                } else if (i == 2) {
                    ImageIcon icon = new ImageIcon(ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.cliMP.etiAvatarM.setIcon(newIcon); //pintamos la imagen en jlabel1
                }
                try {
                    //guardamos la imagen
                    image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                    extension = fileChooser.getSelectedFile().toURL().toString().substring(
                            fileChooser.getSelectedFile().toURL().toString().length() - 3);
                    String cad = Funciones.getCadenaAleatoria1(10);

                    Singletons.PATH_auto = new java.io.File("") + "src/proyectofinal_josegramage/Img/avatar_cliente/" + cad + "." + extension;
                    File f = new File(Singletons.PATH_auto);

                    ImageIO.write(image, extension, f);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error upload imagen", "Error al cargar imagen1", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else { //avatar per defecte
            ruta = "src/proyectofinal_josegramage/Img/icono_defecto.jpg";

            if (i == 0) {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.efCrear.etiAvatar.setIcon(newIcon); //pintamos la imagen_default 

            } else if (i == 1) {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.efModif.etiAvatarM.setIcon(newIcon);
            }
            else if (i == 2) {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.cliMP.etiAvatarM.setIcon(newIcon);
            }
            try {
                //guardamos la imagen
                Singletons.PATH_auto = new java.io.File("") + "src/proyectofinal_josegramage/Img/icono_defecto.jpg";
                File f = new File(Singletons.PATH_auto);
                image = ImageIO.read(f);
                ImageIO.write(image, "jpg", f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //----------- MOSTRAR AVATAR
    public static void leer_imag(int i) {
        Singletons.ruta_avatar = Singletons.cliLog.getAvatar();
        try {

            if (i == 0) {    // para el login

                ImageIcon icon = new ImageIcon(Singletons.cliLog.getAvatar());

                Image img = icon.getImage();

                Image newimg = img.getScaledInstance(55, 55, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newIcon = new ImageIcon(newimg);

                Singletons.ini.etiAvatarInicio.setIcon(newIcon);

            } else if (i == 1) {       // para modificar
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(Singletons.cliLog.getAvatar());
                //       ImageIcon icon = new ImageIcon(Singletons.ruta_avatar);
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.cliMP.etiAvatarM.setIcon(newIcon);

            } else if (i == 2) {       // para modificar
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(Singletons.cli.getAvatar());
                //       ImageIcon icon = new ImageIcon(Singletons.ruta_avatar);
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.efModif.etiAvatarM.setIcon(newIcon);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error upload imagen", "Error leer imagen", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void leer_imag_defecto(int i) {

        String ruta = "src/proyectofinal_josegramage/Img/icono_defecto.jpg";
        String ruta2="";

        if (i == 0) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.efCrear.etiAvatar.setIcon(newIcon); //pintamos la imagen_default en jlabel1

        } else if (i == 2) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(55, 55, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.ini.etiAvatarInicio.setIcon(newIcon);

        } else if (i == 3) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.efModif.etiAvatarM.setIcon(newIcon);

        } else if (i == 4) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.cliMP.etiAvatarM.setIcon(newIcon);
            
        } else if (i == 5) {
            ImageIcon icon = new ImageIcon(ruta2);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(55, 55, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.ini.etiAvatarInicio.setIcon(newIcon);
    }
    }

    //////////////// J U E G O S /////////////////////////////777
    public static void guardar_img_J(JLabel etiAvatar, int ancho, int alto, int i) {
        String ruta;
        File imagen;
        BufferedImage image;
        String extension = "";
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            ruta = imagen.getAbsolutePath();
            if (ruta.length() > 500) {
                JOptionPane.showMessageDialog(null, "La ruta de la imagen debe "
                        + "tener como máximo 500 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                if (i == 0) {
                    ImageIcon icon = new ImageIcon(ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.jueCrear.etiAvatar.setIcon(newIcon); //pintamos la imagen en jlabel1
                } else if (i == 1) {
                    ImageIcon icon = new ImageIcon(ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.jueModif.etiAvatarM.setIcon(newIcon); //pintamos la imagen en jlabel1
                }
                try {
                    //guardamos la imagen
                    image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                    extension = fileChooser.getSelectedFile().toURL().toString().substring(
                            fileChooser.getSelectedFile().toURL().toString().length() - 3);
                    String cad = Funciones.getCadenaAleatoria1(10);

                    Singletons.PATH_auto_Img = new java.io.File("") + "src/proyectofinal_josegramage/Img/imagen_juegos/" + cad + "." + extension;
                    File f = new File(Singletons.PATH_auto_Img);

                    ImageIO.write(image, extension, f);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error upload imagen", "Error al cargar imagen1", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else { //avatar per defecte
            ruta = "src/proyectofinal_josegramage/Img/img_defecto.jpg";

            if (i == 0) {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.jueCrear.etiAvatar.setIcon(newIcon);  

            } else if (i == 1) {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.jueModif.etiAvatarM.setIcon(newIcon);
            }
            try {
                //guardamos la imagen
                Singletons.PATH_auto_Img = new java.io.File("") + "src/proyectofinal_josegramage/Img/img_defecto.jpg";
                File f = new File(Singletons.PATH_auto_Img);
                image = ImageIO.read(f);
                ImageIO.write(image, "jpg", f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void leer_img_juego(int i) {
        Singletons.ruta_imagen = Singletons.jue.getImagen();
        try {
            if (i == 0) {
                // para modificar
                ImageIcon icon = new ImageIcon(Singletons.jue.getImagen());
                Image img = icon.getImage();

                Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.jueModif.etiAvatarM.setIcon(newIcon);
            }
            if (i == 1) {
                // pager
                ImageIcon icon = new ImageIcon(Singletons.jue.getImagen());
                Image img = icon.getImage();

                Image newimg = img.getScaledInstance(111, 111, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.juePager.imgPager.setIcon(newIcon);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error upload imagen", "Error leer imagen", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void leer_img_defecto_J(int i) {

        String ruta = "src/proyectofinal_josegramage/Img/img_defecto.jpg";

        if (i == 0) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.jueCrear.etiAvatar.setIcon(newIcon); //pintamos la imagen_default en jlabel1
        }
        if (i == 1) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.jueModif.etiAvatarM.setIcon(newIcon); //pintamos la imagen_default en jlabel1
        }
        if (i == 2) {
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(111, 111, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Singletons.juePager.imgPager.setIcon(newIcon); //pintamos la imagen_default en jlabel1
        }
    }
}
