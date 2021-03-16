package es.unizar.eina.vv6f.practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * Programa Java que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
 * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista de
 * las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
 * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
 * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
 * 
 * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto de
 * apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves, diéresis y
 * cedillas), se consideran como ocurrencias de la letra correspondiente sin diacríticos.
 */
public class Main {

    private static final String FORMATO_SALIDA_FRECUENCIAS = "%c: %7d%n";

    /**
     * Método que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
     * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista
     * de las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
     * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
     * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
     *
     * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto
     * de apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves,
     * diéresis y cedillas), se consideran como ocurrencias de la letra correspondiente sin
     * diacríticos.
     *
     * @param args
     *            no utilizado.
     */
    public static void main(String[] args) {
        // TODO
        System.out.print("Introduzca el nombre de un fichero de texto: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        String texto="";
        try {
            BufferedReader br = new BufferedReader(isr);
            texto = br.readLine();
            System.out.println(texto);
            File fichero = new File(texto);
            ContadorDeLetras cl= new ContadorDeLetras(fichero);
            int [] frec = cl.frecuencias();
            int i=0;
            char act='A';
            while(i<14){
                System.out.println();
                act += i;
                System.out.println(act + ":\t" + frec[i]);
                i++;
            }
            System.out.println("Ñ" + ":\t" + frec[i]);
            i++;
            while(i<27){
                System.out.println();
                act += i;
                System.out.println(act + ":\t" + frec[i]);
                i++;
            }

        }
        catch(FileNotFoundException fne){
            System.out.println("El fichero '" + texto + "' no existe.");
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        catch(NullPointerException npe){
            System.out.println(npe);
        }

    }
}
