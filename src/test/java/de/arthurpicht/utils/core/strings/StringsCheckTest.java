package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsCheckTest {

    @Test
    void containsControlCharacterEmpty() {
        String string = "";
        assertFalse(Strings.containsControlCharacter(string));
    }

    @Test
    void containsControlCharacterSimple() {
        String string = "Hello World!     ";
        assertFalse(Strings.containsControlCharacter(string));
    }

    @Test
    void containsControlCharacterNewLine() {
        String string = "Something with\nnew line.";
        assertTrue(Strings.containsControlCharacter(string));
    }

    @Test
    void containsControlCharacterTab() {
        String string = "Something with\ttab.";
        assertTrue(Strings.containsControlCharacter(string));
    }

    @Test
    void isOneOfArrays() {

        String[] strings = {"one", "two", "three"};

        assertTrue(Strings.isOneOf("two", strings));
        assertFalse(Strings.isOneOf("five", strings));
    }

    @Test
    void isOneOfList() {

        List<String> stringList = Arrays.asList("one", "two", "three");

        assertTrue(Strings.isOneOf("two", stringList));
        assertFalse(Strings.isOneOf("five", stringList));
    }

}
