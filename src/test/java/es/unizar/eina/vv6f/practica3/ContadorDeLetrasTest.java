package es.unizar.eina.vv6f.practica3;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDeLetrasTest {
    @Test
    public void testTrianguloLados_3_3_3_esEquilatero() throws FileNotFoundException {
        File regenta = new File("/src/main/res/regenta.txt");
        File quijote = new File("/src/main/res/quijote.txt");
        File hamlet = new File("/src/main/res/hamlet.txt");
        ContadorDeLetras contador = new ContadorDeLetras(regenta);
        int[] frecuenciasObtenido = contador.frecuencias();
        assertEquals(TipoTriangulo.EQUILATERO,
                tipoObtenido);
    }
    @Test
    public void testTrianguloLados_3_3_2_esIsosceles() {
        Triangulo triangulo = new Triangulo(3, 3, 2);
        TipoTriangulo tipoObtenido = triangulo.tipo();
        assertEquals(TipoTriangulo.ISOSCELES,
                tipoObtenido);
    }
}