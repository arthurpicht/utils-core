package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringsGetFirstLineTest {

    @Test
    void getFirstLine_empty() {
        Assertions.assertEquals("", Strings.getFirstLine(""));
    }

    @Test
    void getFirstLine_simple() {
        Assertions.assertEquals("test", Strings.getFirstLine("test"));
    }

    @Test
    void getFirstLine_twoLines() {
        Assertions.assertEquals("test", Strings.getFirstLine("test\nsecondLine"));
    }

    @Test
    void getFirstLine_threeLines() {
        Assertions.assertEquals("test", Strings.getFirstLine("test\nsecondLine\nthirdLine"));
    }

    @Test
    void getFirstLine_oneLineWithNextLineCC() {
        Assertions.assertEquals("test", Strings.getFirstLine("test\n"));
    }



}
