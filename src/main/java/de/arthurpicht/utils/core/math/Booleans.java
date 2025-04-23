package de.arthurpicht.utils.core.math;

public class Booleans {

    /**
     * Counts the number of passed values that are true.
     */
    public static int countTrue(boolean... value) {
        int countTrue = 0;
        for (boolean b : value) {
            if (b) countTrue++;
        }
        return countTrue;
    }

    /**
     * Counts the number of passed values that are false.
     */
    public static int countFalse(boolean... value) {
        int countFalse = 0;
        for (boolean b : value) {
            if (!b) countFalse++;
        }
        return countFalse;
    }

    /**
     * Returns true, if exactly one of the specified parameters is true.
     */
    public static boolean isExactlyOneTrue(boolean... values) {
        int count = 0;
        for (boolean value : values) {
            if (value) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }

    /**
     * Returns true, if exactly one of the specified parameters is false.
     */
    public static boolean isExactlyOneFalse(boolean... values) {
        int count = 0;
        for (boolean value : values) {
            if (!value) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }

    /**
     * Returns true, if all specified parameters are true. If no parameter is specified, false will be returned.
     */
    public static boolean isAllTrue(boolean... values) {
        if (values.length == 0) return false;
        for (boolean value : values) {
            if (!value) return false;
        }
        return true;
    }

    /**
     * Returns true, if all specified parameters are false. If no parameter is specified, false will be returned.
     */
    public static boolean isAllFalse(boolean... values) {
        if (values.length == 0) return false;
        for (boolean value : values) {
            if (value) return false;
        }
        return true;
    }

}
