package com.fernandez.batchstatsplayer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String obtenerComponentes(String nombreArchivo) {
        // Definir el patrón de la expresión regular para extraer el ID del partido
        Pattern pattern = Pattern.compile("STATS_PLAYER_(g_[^\\.]+)\\.csv");

        // Crear un objeto Matcher para encontrar el patrón en el nombre del archivo
        Matcher matcher = pattern.matcher(nombreArchivo);

        // Verificar si se encuentra el patrón y extraer el ID del partido si se encuentra
        if (matcher.find()) {
            return matcher.group(1); // Devolver el primer grupo capturado
        } else {
            return null; // Devolver null si no se encuentra el patrón
        }
    }
}
