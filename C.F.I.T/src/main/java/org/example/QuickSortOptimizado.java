package org.example;
import java.util.*;

public class QuickSortOptimizado {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6, 8, 3};
        System.out.println("Array antes de ordenar: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Array después de ordenar: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(array, inicio, fin);
            quickSort(array, inicio, indicePivote - 1);
            quickSort(array, indicePivote + 1, fin);
        }
    }

    public static int particion(int[] array, int inicio, int fin) {
        int pivote = array[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (array[j] < pivote) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, fin);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
