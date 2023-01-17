package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsContainsWhitespaceTest {

    @Test
    public void simpleNeg() {
        assertFalse(Strings.containsWhitespace("abc"));
    }

    @Test
    public void containsSpace() {
        assertTrue(Strings.containsWhitespace("abc def"));
    }

    @Test
    public void containsSpaceEnd() {
        assertTrue(Strings.containsWhitespace("abc "));
    }

    @Test
    public void containsOnlySpace() {
        assertTrue(Strings.containsWhitespace(" "));
    }

    @Test
    public void containsNewLine() {
        assertTrue(Strings.containsWhitespace("abc\ndef"));
    }

    @Test
    public void containsOnlyNewLine() {
        assertTrue(Strings.containsWhitespace("\n"));
    }

    @Test
    public void emptyString() {
        assertFalse(Strings.containsWhitespace(""));
    }

}
