package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringsOverwriteTest {

    @Test
    public void overwriteRightSimple() {
        String string = "12345";
        String overlay = "**";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("123**", processed);
    }

    @Test
    public void overwriteRightSimple2() {
        String string = "12345";
        String overlay = "*";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("1234*", processed);
    }

    @Test
    public void overwriteRightEmptyOverlay() {
        String string = "12345";
        String overlay = "";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("12345", processed);
    }

    @Test
    public void overwriteRightBothEmpty() {
        String string = "";
        String overlay = "";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("", processed);
    }

    @Test
    public void overwriteRightEqualLength() {
        String string = "123";
        String overlay = "ABC";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("ABC", processed);
    }

    @Test
    public void overwriteRightOverlayWithOverlength() {
        String string = "123";
        String overlay = "ABCD";
        String processed = Strings.overwriteRight(string, overlay);
        assertEquals("ABC", processed);
    }

}
