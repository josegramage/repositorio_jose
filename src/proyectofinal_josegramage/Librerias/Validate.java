package proyectofinal_josegramage.Librerias;

import javax.swing.*;

public class Validate {

    // validar Nombre
    public static boolean validaNombre(String nombre) {
        return nombre.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
        //return nombre.matches("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*"); ��� PROBLEMA CON WINDOWS !!!
    }

    // validar Apellidos
    public static boolean validaApellido(String apellidos) {
        return apellidos.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

    // validar Edad
    public static boolean validaEdad(String edad) {
        return edad.matches("^[0-9]{1,2}$");
    }

    // validar Num telf
    public static boolean validaNumTelefono(String numTelf) {
        return numTelf.matches("[0-9]{9}");
    }

    // validar Email
    public static boolean validaEmail(String email) {
        return email
                .matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    // validar Direccion
    public static boolean validaDireccion(String direccion) {
        return direccion.matches("[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?)*");
    }

    // validar Codigo postal
    public static boolean validaCodPostal(String codPostal) {
        return codPostal.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
    }

    // validar nombre con numeros
    public static boolean validaNomNum(String nomnum) {
        return nomnum.matches("^[A-Za-z0-9-\\s]*$");
    }

    // Validar DNI

    public static boolean validaDNI(String DNI) {
        boolean val = true;
        String dni2 = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
        int dni = 0, modulo = 0;
        try {
            for (int i = 0; i < 8; i++) {
                dni2 += DNI.charAt(i);
            }
            char letra = DNI.charAt(8);
            dni = Integer.parseInt(dni2);
            modulo = dni % 23;
            char let = caracteres.charAt(modulo);
            if (let == letra) {
                val = true;
            } else {
                val = false;
            }
        } catch (Exception e) {

            val = false;
        }
        return val;
    }

    // Validar Fecha
    public static boolean validaFecha(String fecha) {
        return fecha.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
    }

    // Validar numeros positivos
    public static boolean validaNumPositivo(String numPositivo) {
        return numPositivo.matches("[0-9]*");
    }

    private static boolean validaFloat(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
/*
 public static void main(String[] args) {

 // Prueba fecha
 String prueba = "";
 boolean val = true;

 do {
 prueba = Funciones.pedirString("Introduce una fecha");
 val = Validate.validaFecha(prueba);
 //val = Validate.validaDNI(prueba);
 if (val == false)
 JOptionPane.showMessageDialog(null, "No ha introducido el nombre correctamente", "Información",
 JOptionPane.INFORMATION_MESSAGE);
 } while (val == false);

 }
 }
 */
