package com.emazon.mstransaction.adapters.driven.jpa.mysql.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeignErrorUtil {
    public static String extractErrorMessage(String errorContent) {
        String errorMessage = "Error al actualizar cantidad de articulo";
        String messagePattern = "\"message\":\"([^\"]+)\"";

        Pattern patternMessage = Pattern.compile(messagePattern);
        Matcher matcherMessage = patternMessage.matcher(errorContent);

        if (matcherMessage.find()) {
            errorMessage = matcherMessage.group(1);
        }

        return errorMessage;
    }
}
