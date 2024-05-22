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

    public static void main(String[] args) {
        // Ejemplo de Sumatoria de Números Naturales
        int n = 5;
        int suma = calcularSumatoria(n);
        System.out.println("Sumatoria de los números naturales hasta " + n + ": " + suma);

        // Ejemplo de Listado de Números en un Rango
        int a = 3;
        int b = 7;
        List<Integer> numerosEnRango = listarNumerosEnRango(a, b);
        System.out.println("Números en el rango [" + a + ", " + b + "]: " + numerosEnRango);
    }
}
