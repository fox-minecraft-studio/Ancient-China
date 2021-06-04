package com.foxstudio.orientmyth.util;

import java.util.Locale;

/**
 * @author cyciling
 */
public class StringUntil {
    public static String toLowerCamelCase(String s) {
        StringBuilder result = new StringBuilder();
        String underline = "_";
        String[] camels = s.split("_");
        if ("".equals(s) || s.isEmpty()) {
            return "";
        } else if (!s.contains(underline)) {
            return s.toLowerCase(Locale.ROOT);
        }
        for (String camel :  camels) {
            if (camel.isEmpty()) {
                continue;
            }
            if (result.length() == 0) {
                result.append(camel.toLowerCase());
            } else {
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        } return result.toString();
    }
}
