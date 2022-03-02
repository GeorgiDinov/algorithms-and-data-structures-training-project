package com.georgidinov.util;


/**
 * Holds constants that can color the console output.
 * Note to use reset after particular coloring, because it will color the entire output of the current thread afterwards.
 */
public enum ThreadColor {

    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m");


    private final String color;

    ThreadColor(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }

}