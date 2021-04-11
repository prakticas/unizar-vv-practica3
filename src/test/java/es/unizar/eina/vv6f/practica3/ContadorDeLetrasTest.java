package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDeLetrasTest {
    ContadorDeLetras contadorDeLetras = null;
    @Test
    public void prueba1() throws FileNotFoundException {
        contadorDeLetras = new ContadorDeLetras(new File("/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba1.txt"));
        int[] ficheroObtenido = contadorDeLetras.frecuencias();
        int [] resultado=new int[27];
        resultado[0]=5;resultado[2]=2;resultado[26]=2;

        assertArrayEquals(ficheroObtenido,resultado);
    }
    @Test
    public void prueba2() throws FileNotFoundException {
        contadorDeLetras = new ContadorDeLetras(new File("/home/ibon/Documents/ibon/3/verific_valid/p3/unizar-vv-practica3/src/main/res/prueba1.txt"));
        int[] ficheroObtenido = contadorDeLetras.frecuencias();
        ficheroObtenido = contadorDeLetras.frecuencias();
        int [] resultado=new int[27];
        resultado[0]=5;resultado[2]=2;resultado[26]=2;

        assertArrayEquals(ficheroObtenido,resultado);
    }
}