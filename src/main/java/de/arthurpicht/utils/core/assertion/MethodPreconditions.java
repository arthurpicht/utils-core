package de.arthurpicht.utils.core.assertion;

import java.util.Collection;
import java.util.Map;

public class MethodPreconditions {

    public static void assertArgumentNotNull(String name, Object value) {
        if (value == null) throw new MethodArgumentIsNullException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, String value) {
        if (value == null || value.equals("")) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, Object[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, char[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, int[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, double[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, float[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, byte[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, short[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, long[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, boolean[] value) {
        if (value == null || value.length == 0) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, Collection<?> value) {
        if (value == null || value.isEmpty()) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentNotNullAndNotEmpty(String name, Map<?, ?> value) {
        if (value == null || value.isEmpty()) throw new MethodArgumentIsNullOrEmptyException(name);
    }

    public static void assertArgumentEndsWith(String name, String value, String endsWith) {
        assertArgumentNotNull(name, "name");
        assertArgumentNotNull(value, "value");
        assertArgumentNotNull(endsWith, "endsWith");
        if (!value.endsWith(endsWith))
            throw new MethodPreconditionFailedException("Method argument [" + name + "] not ending with '" + endsWith + "'");
    }

    public static void assertArgumentInRange(String name, int value, int min, int max) {
        if (value < min || value > max) throw new MethodPreconditionFailedException("Method argument [" + name + "]" +
                " out of bounds [" + min + " .. " + max + "]: " + value);
    }

    public static void assertArgumentIsEqualToOrGreaterThanZero(String name, int value) {
        if (value < 0)
            throw new MethodPreconditionFailedException("Method argument [" + name + "] is less than zero: " + value);
    }

    public static void assertArgumentIsGreaterThanZero(String name, int value) {
        if (value <= 0)
            throw new MethodPreconditionFailedException("Method argument [" + name + "] is equal to or less than zero: "
                    + value);
    }

}
