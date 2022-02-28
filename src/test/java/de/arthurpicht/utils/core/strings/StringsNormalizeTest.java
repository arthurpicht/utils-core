package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringsNormalizeTest {

    @Test
    void simpleTest() {
        String input = "Hello world!";
        String output = Strings.linearize(input);
        assertEquals("Hello world!", output);
    }

    @Test
    void emptyString() {
        String input = "";
        String output = Strings.linearize(input);
        assertEquals("", output);
    }

    @Test
    void justOneSpace() {
        String input = " ";
        String output = Strings.linearize(input);
        assertEquals("", output);
    }

    @Test
    void someSpaces() {
        String input = "     ";
        String output = Strings.linearize(input);
        assertEquals("", output);
    }

    @Test
    void oneLetter() {
        String input = "  d   ";
        String output = Strings.linearize(input);
        assertEquals("d", output);
    }

    @Test
    void lineBreak() {
        String input = "  Here is \n some text. ";
        String output = Strings.linearize(input);
        assertEquals("Here is some text.", output);
    }

    @Test
    void Tab() {
        String input = "  Here is       \t some text. ";
        String output = Strings.linearize(input);
        assertEquals("Here is some text.", output);
    }

    @Test
    void tabWithoutSpace() {
        String input = "  Here is\tsome text. ";
        String output = Strings.linearize(input);
        assertEquals("Here is some text.", output);
    }

    @Test
    void tabWithoutOneSpace() {
        String input = "  Here is\t some text. ";
        String output = Strings.linearize(input);
        assertEquals("Here is some text.", output);
    }
}
