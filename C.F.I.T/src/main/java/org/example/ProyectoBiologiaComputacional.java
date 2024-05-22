package org.example;
import java.util.ArrayList;
import java.util.List;

public class ProyectoBiologiaComputacional {
    public static void main(String[] args) {
        // Ejemplo de Conteo de Genes
        String secuenciaADN = "ATGAAATAAGCTGAATGAAATAG";
        int cantidadGenes = contarGenes(secuenciaADN);
        System.out.println("Número de genes encontrados: " + cantidadGenes);

        // Ejemplo de Cálculo de Combinaciones Genéticas
        int numGenes = 2;
        int variantesPorGen = 3;
        List<String> combinaciones = calcularCombinaciones(numGenes, variantesPorGen);
        System.out.println("Combinaciones genéticas:");
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    // Función para contar los genes en una secuencia de ADN
    public static int contarGenes(String adn) {
        return contarGenesRecursivo(adn, 0);
    }

    private static int contarGenesRecursivo(String adn, int indiceInicio) {
        int contador = 0;
        int indiceCodonInicio = adn.indexOf("ATG", indiceInicio);
        if (indiceCodonInicio == -1) {
            return 0;
        }
        int indiceCodonFin = encontrarCodonFin(adn, indiceCodonInicio);
        if (indiceCodonFin != -1) {
            contador = 1 + contarGenesRecursivo(adn, indiceCodonFin + 3);
        }
        return contador;
    }

    private static int encontrarCodonFin(String adn, int indiceInicio) {
        int indice = adn.indexOf("TAA", indiceInicio + 3);
        if ((indice - indiceInicio) % 3 == 0) return indice;
        indice = adn.indexOf("TAG", indiceInicio + 3);
        if ((indice - indiceInicio) % 3 == 0) return indice;
        indice = adn.indexOf("TGA", indiceInicio + 3);
        if ((indice - indiceInicio) % 3 == 0) return indice;
        return -1;
    }

    // Función para calcular combinaciones genéticas
    public static List<String> calcularCombinaciones(int numGenes, int variantesPorGen) {
        List<String> combinaciones = new ArrayList<>();
        calcularCombinacionesRecursivo("", numGenes, variantesPorGen, combinaciones);
        return combinaciones;
    }

    private static void calcularCombinacionesRecursivo(String combinacionActual, int genesRestantes, int variantesPorGen, List<String> combinaciones) {
        if (genesRestantes == 0) {
            combinaciones.add(combinacionActual);
            return;
        }
        for (int i = 1; i <= variantesPorGen; i++) {
            String nuevaCombinacion = combinacionActual + i;
            calcularCombinacionesRecursivo(nuevaCombinacion, genesRestantes - 1, variantesPorGen, combinaciones);
        }
    }
}
