package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDeLetrasTest {
    ContadorDeLetras contadorDeLetras = null;
    @Test
    public void prueba1() throws FileNotFoundException {
        contadorDeLetras = new ContadorDeLetras(new File("src/main/res/prueba1.txt"));
        int[] ficheroObtenido = contadorDeLetras.frecuencias();
        int [] resultado=new int[27];
        resultado[0]=5;resultado[2]=2;resultado[26]=2;

        assertArrayEquals(ficheroObtenido,resultado);
    }
    @Test
    public void prueba2() throws FileNotFoundException {
        contadorDeLetras = new ContadorDeLetras(new File("src/main/res/prueba1.txt"));
        int[] ficheroObtenido = contadorDeLetras.frecuencias();
        ficheroObtenido = contadorDeLetras.frecuencias();
        int [] resultado=new int[27];
        resultado[0]=5;resultado[2]=2;resultado[26]=2;

        assertArrayEquals(ficheroObtenido,resultado);
    }
    @Test
    public void prueba3() throws FileNotFoundException {
        assertThrows(NullPointerException.class, () -> {
            contadorDeLetras = new ContadorDeLetras(null);
            contadorDeLetras.frecuencias();
        });
    }
    @Test
    public void prueba4() throws FileNotFoundException {
        assertThrows(FileNotFoundException.class, () -> {
            contadorDeLetras = new ContadorDeLetras(new File("src/main/res/prueba4.txt"));
             contadorDeLetras.frecuencias();
        });
    }

    @Test
    public void testRegenta() throws FileNotFoundException {
        ContadorDeLetras contador = new ContadorDeLetras(new File("src/main/res/regenta.txt"));
        final int[] FRECUENCIAS_REGENTA = new int[] { 195175,
                26862, 53217, 68273, 178917, 8620, 15404, 13913, 87589, 6505,
                61, 84711, 37053, 88950, 129829, 34482, 17977, 90627, 102937,
                54752, 58427, 15717, 19, 1240, 13826, 5632, 3534 };;
        assertArrayEquals(FRECUENCIAS_REGENTA, contador.frecuencias());
    }
}