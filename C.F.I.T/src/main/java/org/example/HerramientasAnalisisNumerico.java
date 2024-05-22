package org.example;

import java.util.ArrayList;
import java.util.List;

public class HerramientasAnalisisNumerico {
    // Función recursiva para calcular la suma de números naturales hasta n
    public static int calcularSumatoria(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calcularSumatoria(n - 1);
    }

    // Función recursiva para listar números en un rango [a, b]
    public static List<Integer> listarNumerosEnRango(int a, int b) {
        List<Integer> numeros = new ArrayList<>();
        listarNumerosEnRangoRecursivo(a, b, numeros);
        return numeros;
    }

    private static void listarNumerosEnRangoRecursivo(int a, int b, List<Integer> numeros) {
        if (a == b) {
            numeros.add(a);
            return;
        }
        numeros.add(a);
        listarNumerosEnRangoRecursivo(a + 1, b, numeros);
    }

    // Función recursiva para calcular la potencia base^exponente
    public static int calcularPotencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * calcularPotencia(base, exponente - 1);
    }

    // Función recursiva para encontrar el máximo en una lista de números
    public static int encontrarMaximo(List<Integer> numeros) {
        return encontrarMaximoRecursivo(numeros, 0);
    }

    private static int encontrarMaximoRecursivo(List<Integer> numeros, int indice) {
        if (indice == numeros.size() - 1) {
            return numeros.get(indice);
        }
        int maximoRestante = encontrarMaximoRecursivo(numeros, indice + 1);
        return Math.max(numeros.get(indice), maximoRestante);
    }

    public static void main(String[] args) {
        // Ejemplos de uso de las funciones
        // Sumatoria de Números Naturales
        int n = 5;
        int suma = calcularSumatoria(n);
        System.out.println("Sumatoria de los números naturales hasta " + n + ": " + suma);

        // Listado de Números en un Rango
        int a = 3;
        int b = 7;
        List<Integer> numerosEnRango = listarNumerosEnRango(a, b);
        System.out.println("Números en el rango [" + a + ", " + b + "]: " + numerosEnRango);

        // Cálculo de Potencias
        int base = 2;
        int exponente = 3;
        int potencia = calcularPotencia(base, exponente);
        System.out.println("Potencia de " + base + " elevado a " + exponente + ": " + potencia);

        // Encuentro del Valor Máximo
        List<Integer> numeros = List.of(4, 7, 2, 9, 5);
        int maximo = encontrarMaximo(numeros);
        System.out.println("Máximo en la lista: " + maximo);
    }
}
