package org.joker.template.generate.util;

public class NameCaseUtil {

    private static final char SEPARATOR = '_';

    public static String underscorecaseToLowercamelcase(String str) {
        if (str == null) {
            throw new RuntimeException("underscore case to lowercamel case: str is NULL");
        }
        StringBuilder sb = new StringBuilder(str.length());
        boolean needUpperCase = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == SEPARATOR) {
                needUpperCase = true;
            } else if (needUpperCase) {
                sb.append(Character.toUpperCase(c));
                needUpperCase = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static String underscorecaseToUppercamelcase(String str) {
        if (null == str) {
            throw new RuntimeException("underscore case to uppercame case: str is NULL");
        }
        str = underscorecaseToLowercamelcase(str);
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String camelcaseToUnderscorecase(String str) {
        if (null == str) {
            throw new RuntimeException("camel case to underscore case: str is NULL");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    sb.append(SEPARATOR);
                }
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

}
