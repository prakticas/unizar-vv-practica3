package es.unizar.eina.vv6f.practica3;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDeLetrasTest {
    @Test
    public void prueba1() throws FileNotFoundException {
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba1.txt"));
        int[] ficheroObtenido = contadorDeLetras.frecuencias();
        int [] resultado=new int[27];
        r[0]=5;r[2]=2;r['ñ'-'a']=2;

        assertArrayEquals(ficheroObtenido,r);
    }
}