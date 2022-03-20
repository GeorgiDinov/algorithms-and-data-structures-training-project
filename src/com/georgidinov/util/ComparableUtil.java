package com.georgidinov.util;

public final class ComparableUtil {

    private ComparableUtil() {
    }

    public static ComparableUtil getInstance() {
        return ComparableUtilHelper.INSTANCE;
    }

    public <T extends Comparable<T>> boolean isEqual(T left, T right) {
        return left.compareTo(right) == 0;
    }

    public <T extends Comparable<T>> boolean isBefore(T left, T right) {
        return left.compareTo(right) < 0;
    }

    public <T extends Comparable<T>> boolean isAfter(T left, T right) {
        return left.compareTo(right) > 0;
    }

    //== private static inner helper class for the singleton design pattern ==
    private static class ComparableUtilHelper {
        private static final ComparableUtil INSTANCE = new ComparableUtil();
    }

}