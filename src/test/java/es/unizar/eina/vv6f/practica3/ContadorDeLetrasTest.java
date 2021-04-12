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
}