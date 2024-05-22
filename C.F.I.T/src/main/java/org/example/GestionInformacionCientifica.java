package org.example;

import java.io.*;
import java.util.*;

public class GestionInformacionCientifica {
    public static void main(String[] args) {
        // Ejercicio 9: Organización de Documentos
        ordenarLineasArchivoAlfabeticamente("archivo.txt");

        // Ejercicio 10: Búsqueda Eficiente en Textos
        buscarPalabraEnArchivo("archivo.txt", "palabra");

        // Ejercicio 11: Gestión de Fechas
        List<String> fechas = new ArrayList<>();
        fechas.add("2024-05-22");
        fechas.add("2023-10-15");
        fechas.add("2025-01-01");
        fechas.add("2023-06-30");
        listarFechasOrdenadas(fechas);
    }

    // Ejercicio 9: Organización de Documentos
    public static void ordenarLineasArchivoAlfabeticamente(String nombreArchivo) {
        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();
            Collections.sort(lineas);
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (String lineaOrdenada : lineas) {
                writer.write(lineaOrdenada);
                writer.newLine();
            }
            writer.close();
            System.out.println("Las líneas del archivo han sido ordenadas alfabéticamente.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 10: Búsqueda Eficiente en Textos
    public static void buscarPalabraEnArchivo(String nombreArchivo, String palabraBuscada) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            boolean palabraEncontrada = false;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabraBuscada)) {
                    palabraEncontrada = true;
                    System.out.println("La palabra '" + palabraBuscada + "' fue encontrada en la línea: " + linea);
                }
            }
            if (!palabraEncontrada) {
                System.out.println("La palabra '" + palabraBuscada + "' no fue encontrada en el archivo.");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 11: Gestión de Fechas
    public static void listarFechasOrdenadas(List<String> fechas) {
        Collections.sort(fechas);
        System.out.println("Fechas ordenadas:");
        for (String fecha : fechas) {
            System.out.println(fecha);
        }
    }
}
