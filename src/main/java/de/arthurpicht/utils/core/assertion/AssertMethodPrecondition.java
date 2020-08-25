package de.arthurpicht.utils.core.assertion;

public class AssertMethodPrecondition {

    public static void parameterNotNull(String name, String value) {
        if (value == null) throw new MethodPreconditionFailedException("Parameter [" + name + "] is null.");
    }

    public static void parameterNotNull(String name, Object value) {
        if (value == null) throw new MethodPreconditionFailedException("Parameter [" + name + "] is null.");
    }

    public static void parameterNotNull(String name, String[] value) {
        if (value == null) throw new MethodPreconditionFailedException("Parameter [" + name + "] is null.");
    }

    public static void parameterNotNull(String name, char[] value) {
        if (value == null) throw new MethodPreconditionFailedException("Parameter [" + name + "] is null.");
    }

    public static void parameterEndsWith(String name, String value, String endsWith) {
        parameterNotNull(name, "name");
        parameterNotNull(value, "value");
        parameterNotNull(endsWith, "endsWith");
        if (!value.endsWith(endsWith))
            throw new MethodPreconditionFailedException("Parameter [" + name + "] not ending with '" + endsWith + "'");
    }

    /**
     * @deprecated use {@link #parameterEndsWith(String, String, String)} instead
     * @param name
     * @param value
     * @param endsWith
     */
    @Deprecated
    public static void methodParamEndsWith(String name, String value, String endsWith) {
        parameterEndsWith(name, value, endsWith);
    }

    public static void parameterNotNullAndNotEmpty(String name, String value) {
        parameterNotNull(name, value);
        if (value.equals("")) throw new MethodPreconditionFailedException("Parameter [" + name + "] is empty.");
    }

    /**
     * @deprecated use {@link #parameterNotNullAndNotEmpty(String, String)} instead.
     * @param name
     * @param value
     */
    @Deprecated
    public static void methodParamNotNullAndNotEmpty(String name, String value) {
        parameterNotNullAndNotEmpty(name, value);
    }

    public static void parameterNotNullAndNotEmpty(String name, char[] value) {
        if (value == null || value.length == 0) throw new MethodPreconditionFailedException("Parameter [" + name + "] is empty.");
    }

    /**
     * @deprecated use {@link #parameterNotNullAndNotEmpty(String, char[])} instead.
     * @param name
     * @param value
     */
    @Deprecated
    public static void methodParamNotNullAndNotEmpty(String name, char[] value) {
        parameterNotNullAndNotEmpty(name, value);
    }

    public static void parameterInRange(String name, int value, int min, int max) {
        if (value < min || value > max) throw new MethodPreconditionFailedException("Parameter [" + name + "] out of bounds [" + min + " .. " + max + "]: " + value);
    }

    /**
     * @deprecated use {@link #parameterInRange(String, int, int, int)} instead.
     * @param name
     * @param value
     * @param min
     * @param max
     */
    @Deprecated
    public static void methodParamInRange(String name, int value, int min, int max) {
        parameterInRange(name, value, min, max);
    }

}
