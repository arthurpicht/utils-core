package de.arthurpicht.utils.core.strings;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsFillUpTest {

    @Test
    void fillUpRight1() {
        String string = "a";
        String stringFilledUp = Strings.fillUpAfter(string, ' ', 5);
        assertEquals("a    ", stringFilledUp);
    }

    @Test
    @DisplayName("length of string equals spec. length")
    void fillUpRightEdge1() {
        String string = "12345";
        String stringFilledUp = Strings.fillUpAfter(string, ' ', 5);
        assertEquals(string, stringFilledUp);
    }

    @Test
    @DisplayName("length of string longer than spec. length")
    void fillUpRightLonger() {
        String string = "123456";
        String stringFilledUp = Strings.fillUpAfter(string, ' ', 5);
        assertEquals(string, stringFilledUp);
    }


}