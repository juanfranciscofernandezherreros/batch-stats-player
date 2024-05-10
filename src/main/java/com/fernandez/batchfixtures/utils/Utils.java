package com.fernandez.batchfixtures.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String[] obtenerComponentes(String nombreArchivo) {
        String[] componentes = new String[3]; // Array para almacenar los componentes

        // Definir el patrón de expresión regular
        String patron = "FIXTURES_(\\d{14})_(\\w+)_([\\w-]+)";

        // Compilar el patrón
        Pattern pattern = Pattern.compile(patron);

        // Crear un objeto Matcher para buscar coincidencias
        Matcher matcher = pattern.matcher(nombreArchivo);

        // Verificar si hay coincidencias
        if (matcher.find()) {
            // Obtener los componentes separados
            componentes[0] = matcher.group(1); // Fecha
            componentes[1] = matcher.group(2); // País
            componentes[2] = matcher.group(3); // Liga
        } else {
            System.out.println("No se encontraron coincidencias con el patrón en el nombre del archivo.");
        }

        return componentes;
    }
}
