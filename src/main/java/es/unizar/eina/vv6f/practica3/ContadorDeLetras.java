package es.unizar.eina.vv6f.practica3;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Clase para el análisis de la frecuencia de aparición de letras del alfabeto español en un
 * fichero de texto. Los objetos de esta clase se construyen utilizando como argumento un objeto de
 * la clase File que representa el fichero de texto que se quiere analizar. La primera invocación al
 * método frecuencias() analiza el contenido del fichero de texto y, si se ha podido procesar,
 * devuelve un vector de siempre 27 componentes de tipo entero. Las primeras 26 componentes
 * almacenan el número de apariciones de las 26 letras del alfabeto inglés. La última componente,
 * almacena el número de apariciones de la letra Ñ.
 *
 * No se distingue entre mayúsculas y minúsculas. En español, la letra Ñ es una letra distinta a la
 * N. El resto de apariciones de letras voladas y caracteres con diacríticos (acentos agudos,
 * graves, diéresis, cedillas), se consideran como ocurrencias de la letra correspondiente sin
 * diacríticos.
 *
 */
public class ContadorDeLetras {
    private File fichero;
    private int[] frecuencias = null;
    final int numLetras =  'Z'-'A'+2;
    final String minusculas = "abcdefghijklmnopqrstuvwxyz" ;
    final String Mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String Aacentuada= "ÀÁÂÃÄÅ";
    final String Eacentuada= "ÈÉÊË";
    final String Iacentuada= "ÌÍÎÏ";
    final String Oacentuada= "ÒÓÔÕÖ";
    final String Uacentuada= "ÙÚÛÜ";
    final String aacentuada= "áàâãäå";
    final String eacentuada= "éèêë";
    final String iacentuada= "íìîï";
    final String oacentuada= "óòôõö";
    final String uacentuada= "úùûü";
    final String avoladas= "ª";
    final String ovoladas= "º";
    final String enye= "ñÑ";
    final String cedilla= "çÇ";





    /**
     * Construye un ContadorDeLetras para frecuencias la frecuencia en las que aparecen las letras
     * del fichero «fichero».
     * @param fichero
     *            fichero de texto cuyo contenido será analizado.
     */
    public ContadorDeLetras(File fichero)  {
        this.fichero = fichero;
    }

    /**
     * Si no ha sido analizado ya, analiza el contenido del fichero de texto asociado a este
     * objeto en el constructor. Devuelve un vector de 27 componentes con las frecuencias
     * absolutas de aparición de cada letra del alfabeto español en el fichero.
     *
     * @return vector de 27 componentes de tipo entero. Las primeras 26 componentes almacenan el
     *         número de apariciones de las 26 letras del alfabeto inglés: la componente indexada
     *         por 0 almacena el número de apariciones de la letra A, la componente indexada por 1,
     *         el de la letra B y así sucesivamente. La última componente, almacena el número de
     *         apariciones de la letra Ñ.
     * @throws FileNotFoundException
     *             si el fichero de texto que se especificó al construir este objeto no existe o no
     *             puede abrirse.
     */
    public int[] frecuencias() throws FileNotFoundException {
        if (frecuencias == null) {
            frecuencias = new int[numLetras];
            Scanner sc = new Scanner(fichero);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                for (int x=0;x<line.length();x++){
                    Character car = line.charAt(x);
                    char c = car.charValue();
                    System.out.println("Tenemos el caracter: "+c+ " "+(int) car);
                    if(Mayusculas.indexOf(c)>=0){
                        System.out.println("letra matuscula "+(int) c);
                        frecuencias[(int) (c - 'A')]++;
                    }
                    else if(minusculas.indexOf(c)>=0){
                        System.out.println("letra minuscula despues de toLowerCase "+(int) c);
                        frecuencias[(int) (c - 'a')]++;
                    }
                    //a acentuadas minus
                    else if(aacentuada.indexOf(c)>=0){//a
                        System.out.println("a minuscula acentuada");
                        frecuencias[0]++;
                    }
                    else if(eacentuada.indexOf(c)>=0) {
                        frecuencias[(int) ('e' - 'a')]++;
                        System.out.println("e minuscula acentuada");
                    }
                    else if(iacentuada.indexOf(c)>=0){
                        frecuencias[(int)('i' - 'a')]++;
                        System.out.println("i minuscula acentuada");
                    }
                    else if(oacentuada.indexOf(c)>=0){
                        frecuencias[(int)('o' - 'a')]++;
                        System.out.println("o minuscula acentuada");
                    }
                    else if(uacentuada.indexOf(c)>=0){
                        frecuencias[(int)('u' - 'a')]++;
                        System.out.println("u minuscula acentuada");
                    }
                    else if(Aacentuada.indexOf(c)>=0){
                        frecuencias[(int)('a' - 'a')]++;
                        System.out.println("A mayuscula acentuada");
                    }
                    else if(Eacentuada.indexOf(c)>=0){
                        frecuencias[(int)('e' - 'a')]++;
                        System.out.println("E mayuscula acentuada");
                    }
                    else if(Iacentuada.indexOf(c)>=0) {
                        frecuencias[(int)('i' - 'a')]++;
                        System.out.println("I mayuscula acentuada");
                    }
                    else if(Oacentuada.indexOf(c)>=0){
                        frecuencias[(int)('o' - 'a')]++;
                        System.out.println("O mayuscula acentuada");
                    }
                    else if(Uacentuada.indexOf(c)>=0){
                        frecuencias[(int)('u' - 'a')]++;
                        System.out.println("U mayuscula acentuada");
                    }
                    else if (avoladas.indexOf(c)>=0){
                        frecuencias[0]++;
                        System.out.println("A volada");
                    }
                    else if (ovoladas.indexOf(c)>=0) {
                        frecuencias[(int)('o' - 'a')]++;
                        System.out.println("O volada");
                    }
                    else if(enye.indexOf(c)>=0) {
                        frecuencias[26]++; // la ñ es la última componente
                        System.out.println("ñ ");
                    }
                    else if (cedilla.indexOf(c)>=0) {
                        frecuencias[(int) ('c' - 'a')]++;
                        System.out.println("Cedilla");
                    }
                }
            }
            sc.close();
        }
        return frecuencias;
    }
}
