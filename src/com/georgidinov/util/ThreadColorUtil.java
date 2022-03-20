package com.georgidinov.util;

public final class ThreadColorUtil {

    private ThreadColorUtil() {
    }

    public static void printInColor(String message, ThreadColor color) {
        System.out.println(colorMessage(message, color));
    }

    public static String colorMessage(String message, ThreadColor color) {
        return color.getColor() + message + ThreadColor.ANSI_RESET.getColor();
    }

}