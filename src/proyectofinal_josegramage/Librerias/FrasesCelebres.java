/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_josegramage.Librerias;

/**
 *
 * @author Joso
 */
public class FrasesCelebres {

    public static void ponerFrases() {

        int i = new Double(Math.random() * 8).intValue();
        String frase = Frases(i);

        Singletons.ini.etiFrasesCelebres.setText(frase);
    }

    public static String Frases(int i) {

        String frase = "";

        if (i == 0) {
            frase = "'La única verdad es la realidad'. Aristóteles";

        } else if (i == 1) {
            frase = "'Antes la imagen servía para transformar el mundo; ahora la imagen virtual es el mundo'. Philippe Quéau";

        } else if (i == 2) {
            frase = "'La realidad objetiva acaba de evaporarse'. Werner Karl Heisenberg";

        } else if (i == 3) {
            frase = "'Todo lo que una persona puede imaginar, otros pueden hacerlo realidad'. Julio Verne";

        } else if (i == 4) {
            frase = "'Todo lo que llamamos real está compuesto por cosas que no puede considerarse como reales'. Niels Bohr";

        } else if (i == 5) {
            frase = "'Si los sueños no se hicieran realidad la naturaleza no nos haría tenerlos'. John Updike";

        } else if (i == 6) {
            frase = "'¿Qué es real? ¿Cómo defines lo real?'. Morfeo (Matrix)";

        } else if (i == 7) {
            frase = "'Odio la realidad, pero es en el único sitio donde se puede comer un buen filete'. Woody Allen";

        } else if (i == 8) {
            frase = "'La realidad es aquello que, cuando uno deja de creer en ello, no desaparece'. Philip Dick";

        } else if (i == 9) {
            frase = "'La realidad es relativa, depende de con qué lente la mirés'. Sylvia Plath";

        } else if (i == 10) {
            frase = "'La realidad no es otra cosa que la capacidad que tienen de engañarse nuestros sentidos'. Albert Einstein";

        } else if (i == 11) {
            frase = "'Todo depende de cómo vemos las cosas y no de como son en realidad'.Carl Jung";
        }
        return frase;
    }
}
