package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringsLimitTest {

    @Test
    void limit1() {
        String string = "This is a test.";
        assertEquals(string, Strings.limit(string, 50));
    }

    @Test
    void limit2() {
        String string = "This is a test.";
        assertEquals(string, Strings.limit(string, 15));
    }

    @Test
    void limit3() {
        String string = "This is a test.";
        String expected = "This is a test";
        assertEquals(expected, Strings.limit(string, 14));
    }

}
