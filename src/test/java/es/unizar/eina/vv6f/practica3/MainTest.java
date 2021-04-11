package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
import java.util.stream.Stream;

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

    @Test
    void prueba1() throws IOException {
        String path1 = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/test/res/salida-prueba1.txt";
        String path2 = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/test/res/yes.txt";

        byte[] num = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba1.txt".getBytes();
        bInput = new ByteArrayInputStream(num);
        File fichero = new File(path2);
        fichero.createNewFile();

        bOutput = new PrintStream(fichero);
        System.setIn(bInput);
        System.setOut(bOutput);

        String[] args = null;
        Main.main(args);

        boolean isTwoEqual = compararArchivos(path1,path2);

        assertTrue(isTwoEqual);
    }
    @Test
    void prueba2() throws IOException {
        String path1 = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/test/res/salida-prueba1.txt";
        String path2 = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/test/res/yes.txt";

        byte[] num = "/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba2.txt".getBytes();
        bInput = new ByteArrayInputStream(num);
        File fichero = new File(path2);
        fichero.createNewFile();

        bOutput = new PrintStream(fichero);
        System.setIn(bInput);
        System.setOut(bOutput);

        String[] args = null;
        Main.main(args);

        boolean isTwoEqual = compararArchivos(path1,path2);

        assertFalse(isTwoEqual);
    }
}