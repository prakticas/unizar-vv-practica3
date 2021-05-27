package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static InputStream antesIn;
    static PrintStream antesOut;
    ByteArrayInputStream bInput ;
    PrintStream bOutput;
    boolean compararArchivos(String f1,String f2) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(f1));
        BufferedReader reader2 = new BufferedReader(new FileReader(f2));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        while (line1 != null || line2 != null){
            if(line1 == null || line2 == null){
                areEqual = false;
                break;
            }else if(!line1.equalsIgnoreCase(line2)) {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
        reader1.close();
        reader2.close();
        return areEqual;
    }
    @BeforeAll
    static void preparacion(){
        antesIn= System.in;
        antesOut = System.out;

    }

    @AfterAll
    static void procesoFinal(){
        System.setIn(antesIn);
        System.setOut(antesOut);
    }

    private final String path1 = "src/test/res/salida-prueba1.txt";
    private final String path2 = "src/test/res/yes.txt";

    @BeforeEach
    void setUp() throws FileNotFoundException {
        File fichero = new File(path2);

        bOutput = new PrintStream(fichero);
        System.setOut(bOutput);

    }

    @Test
    void prueba1() throws IOException {
        bInput = new ByteArrayInputStream("src/main/res/prueba1.txt".getBytes());
        System.setIn(bInput);

        Main.main(null);

        boolean isTwoEqual = compararArchivos(path1,path2);

        assertTrue(isTwoEqual);
    }
    @Test
    void prueba2() throws IOException {
        /* No entiendo el objetivo de este caso de prueba. Si se trata de comprobar la salida con un fichero
        que no existe, enconces tendíais que comprobar que la salida es por pantalla es:
            Nombre de un fichero de texto: /home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba2.txt
            El fichero '/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba2.txt' no existe.

        no simplemente la salida por pantalla sea distinta a la de prueba-1.txt
         */

        byte[] num = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba2.txt".getBytes();
        bInput = new ByteArrayInputStream(num);
        System.setIn(bInput);
        Main.main(null);

        boolean isTwoEqual = compararArchivos(path1,path2);

        assertFalse(isTwoEqual);
    }


}