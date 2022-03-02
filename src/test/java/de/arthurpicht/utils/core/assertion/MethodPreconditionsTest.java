package de.arthurpicht.utils.core.assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodPreconditionsTest {

    @Test
    void assertArgumentNotNullString() {
        String argument = null;

        MethodArgumentIsNullException e = Assertions.assertThrows(MethodArgumentIsNullException.class,
                () -> MethodPreconditions.assertArgumentNotNull("myName", argument));
        Assertions.assertEquals("Method precondition failed. Method argument [myName] is null.", e.getMessage());
    }

    @Test
    void assertArgumentNotNullArrayOfInt() {
        int[] intArray = null;
        Assertions.assertThrows(MethodArgumentIsNullException.class,
                () -> MethodPreconditions.assertArgumentNotNull("myName", intArray));
    }

    @Test
    void assertArgumentNotNullAndNotEmptyString() {
        String argument = "";

        MethodArgumentIsNullOrEmptyException e = Assertions.assertThrows(MethodArgumentIsNullOrEmptyException.class,
                () -> MethodPreconditions.assertArgumentNotNullAndNotEmpty("myName", argument));
        Assertions.assertEquals("Method precondition failed. Method argument [myName] is null or empty.", e.getMessage());
    }

    @Test
    void assertArgumentNotNullAndNotEmptyArrayOfInt() {
        int[] intArray = new int[] {};
        Assertions.assertThrows(MethodArgumentIsNullOrEmptyException.class,
                () -> MethodPreconditions.assertArgumentNotNullAndNotEmpty("myName", intArray));
    }

}