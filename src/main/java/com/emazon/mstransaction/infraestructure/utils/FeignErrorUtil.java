package com.emazon.mstransaction.infraestructure.utils;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeignErrorUtil {
    public static String extractErrorMessage(String content) {
        String errorMessage = "Error al actualizar cantidad de articulo";
        String messagePattern = "\"message\":\"([^\"]+)\"";

        Pattern patternMessage = Pattern.compile(messagePattern);
        Matcher matcherMessage = patternMessage.matcher(content);

        if (matcherMessage.find()) {
            errorMessage = matcherMessage.group(1);
        }

        return errorMessage;
    }
}
