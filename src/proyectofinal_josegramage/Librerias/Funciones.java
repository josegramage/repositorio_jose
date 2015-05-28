package proyectofinal_josegramage.Librerias;

import javax.swing.JOptionPane;

import proyectofinal_josegramage.Clases.Fecha;
import java.util.Random;

public class Funciones {

    // pedir int
    public static int pedirInt(String mensaje) {

        int numInt1 = 0;
        String num1 = "";
        boolean correcto = true;

        do {
            try {
                num1 = JOptionPane.showInputDialog(null, mensaje, "Introduce un num", JOptionPane.QUESTION_MESSAGE);

                if (num1 == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else {
                    numInt1 = Integer.parseInt(num1);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido un numero", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);

        return numInt1;
    }

    // para pedir un float
    public static float pedirFloat(String mensaje) {
        float numFloat1 = 0;
        String num1 = "";
        boolean correcto = true;

        do {
            try {
                num1 = JOptionPane.showInputDialog(null, mensaje, "Introduce un num",
                        JOptionPane.QUESTION_MESSAGE);

                if (num1 == null) {
						
                }
                else {
                    numFloat1 = Integer.parseInt(num1);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido un numero", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);

        return numFloat1;
    }

    // para pedir un char
    public static char pedirChar() {

        String letra = "";
        char letraChar = ' ';
        boolean correcto = true;

        do {
            try {
                letra = JOptionPane.showInputDialog(null, "Escribe una letra", "letra", JOptionPane.QUESTION_MESSAGE);
                if (letra == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacionn", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);// al usuario pulsar cancelar o cerrar la
                    // vtna del showinputdialog, acaba la
                    // ejecución
                } else {
                    letraChar = letra.charAt(0);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);

        return letraChar;
    }

    // pedir String
    public static String pedirString(String mensaje) {

        String s = "";
        boolean correcto = true;

        do {
            try {
                s = JOptionPane.showInputDialog(null, mensaje, "Introduce datos", JOptionPane.QUESTION_MESSAGE);
                correcto = true;
                if (s == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);

                }
                if (s.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error de introduccion de datos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    correcto = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido un dato valido", "Error",
                        JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return s;
    }

	// pedir fecha
    public static Fecha pedirFecha(String mensaje) {
        String fecha = "";
        boolean val = true;
        Fecha f = null;
        int dia = 0, mes = 0, anyo = 0;

        do {
            fecha = Funciones.pedirString("Introduce una fecha");
            val = Validate.validaFecha(fecha);
            f = f.muestraFecha(fecha);
            dia = f.comprobarDia();
            mes = f.comprobarMes();
            anyo = f.comprobarAnyo();

			//if ((val == false)|| (dia== -1) || (mes == -1) || (anyo == -1))
            //JOptionPane.showMessageDialog(null, "No ha introducido una fecha valida", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } while ((val == false) || (dia == -1) || (mes == -1) || (anyo == -1));

        return f;
    }

    // para imprimir un resultado
    public static void resultado(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

       
   
    
    //fnes
    public static String getCadenaAleatoria1(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static String getCadenaAleatoria2(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static String getCadenaAleatoriaTelefono(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if (c >= '0' && c <= '9') {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
    
    public static int getCadenaAleatoriaNumeros(int longitud) {
        int cadenaAleatoria = 0;
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if (c >= '0' && c <= '9') {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static Fecha getFechaAleatoria() {
//by Vicent Albert
        String cad;
        int d = 0, m = 0, y = 0, i = 0;
        Random r = new Random();
        while (i < 3) {
            if (i == 0) {
                d = r.nextInt(28);
                if ((d > 0) && (d < 29)) {
                    i++;
                }
            }
            if (i == 1) {
                m = r.nextInt(12);
                if ((m > 0) && (m < 13)) {
                    i++;
                }
            }
            if (i == 2) {
                y = r.nextInt(1995);
                if ((y > 1950) && (y < 1996)) {
                    i++;
                }
            }
        }
        cad = +d + "-" + m + "-" + y;
        Fecha f = new Fecha(cad, d, m, y);

        return f;
    }

    
    public static String getCadenaAleatoriaDNI() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 8) {
            char c = (char) r.nextInt(255);
            if (c >= '0' && c <= '9') {
                cadenaAleatoria += c;
                i++;
            }
        }
        String dniLetra = "TRWAGMYFPDXBNJZSQVHLCKE";

        return cadenaAleatoria + dniLetra.charAt(Integer.parseInt(cadenaAleatoria) % 23);
    }

}
