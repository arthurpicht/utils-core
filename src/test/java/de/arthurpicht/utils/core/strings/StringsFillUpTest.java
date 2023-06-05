package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsFillUpTest {

    @Test
    void fillUpRight1() {
        String string = "a";
        String stringFilledUp = Strings.fillUpRight(string, ' ', 5);
        assertEquals("a    ", stringFilledUp);
    }

    @Test
    @DisplayName("length of string equals spec. length")
    void fillUpRightEdge1() {
        String string = "12345";
        String stringFilledUp = Strings.fillUpRight(string, ' ', 5);
        assertEquals(string, stringFilledUp);
    }

    @Test
    @DisplayName("length of string longer than spec. length")
    void fillUpRightLonger() {
        String string = "123456";
        String stringFilledUp = Strings.fillUpRight(string, ' ', 5);
        assertEquals(string, stringFilledUp);
    }

    @Test
    public void fillUpLeft() {
        String string = "123";
        String processed = Strings.fillUpLeft(string, ' ', 5);
        assertEquals("  123", processed);
    }

    @Test
    public void fillUpLeftLengthOK() {
        String string = "123";
        String processed = Strings.fillUpLeft(string, ' ', 3);
        assertEquals("123", processed);
    }

    @Test
    public void fillUpLeftNoActionNeeded() {
        String string = "12345";
        String processed = Strings.fillUpLeft(string, ' ', 5);
        assertEquals("12345", processed);
    }

    public void fillUpLeftAndRight() {
        String string = "123";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 5);
        assertEquals(" 123 ", processed);
    }

    @Test
    public void fillUpLeftAndRightMore() {
        String string = "1234";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 7);
        assertEquals(" 1234  ", processed);
    }

    @Test
    public void fillUpLeftAndRightMoreEqual() {
        String string = "1234";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 8);
        assertEquals("  1234  ", processed);
    }

    @Test
    public void fillUpLeftAndRightNoAction() {
        String string = "1234";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 4);
        assertEquals("1234", processed);
    }

    @Test
    public void fillUpLeftAndRightEmptyString() {
        String string = "";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 4);
        assertEquals("    ", processed);
    }

    @Test
    public void fillUpLeftAndRightNoActionTooLong() {
        String string = "1234";
        String processed = Strings.fillUpLeftAndRight(string, ' ', 3);
        assertEquals("1234", processed);
    }


}