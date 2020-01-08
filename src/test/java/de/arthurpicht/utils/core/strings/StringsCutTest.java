package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsCutTest {

    @Test
    @DisplayName("Abschneiden von einem Zeichen.")
    void cutEnd1() {

        String string = "Dies ist ein Test.";
        String cutString = Strings.cutEnd(string, 1);

        assertEquals("Dies ist ein Test", cutString);
    }

    @Test
    @DisplayName("Abschneiden von keinem Zeichen.")
    void cutEnd2() {

        String string = "Dies ist ein Test.";
        String cutString = Strings.cutEnd(string, 0);

        assertEquals("Dies ist ein Test.", cutString);
    }

    @Test
    @DisplayName("Abschneiden von mehreren Zeichen.")
    void cutEnd3() {

        String string = "Dies ist ein Test.";
        String cutString = Strings.cutEnd(string, 6);

        assertEquals("Dies ist ein", cutString);
    }

    @Test
    @DisplayName("Abschneiden von allen Zeichen.")
    void cutEnd4() {

        String string = "Dies ist ein Test.";
        String cutString = Strings.cutEnd(string, 18);

        assertEquals("", cutString);
    }

    @Test
    @DisplayName("Versuch mehr als mögliche Zeichen abzuschneiden.")
    void cutEnd5() {

        String string = "Dies ist ein Test.";

        String cutString = null;
        try {
            cutString = Strings.cutEnd(string, 19);
            fail("Ex. erwartet.");
        } catch (IllegalArgumentException e) {
            // DIN
        }
    }

    @Test
    @DisplayName("Versuch eine negative Anzahl von Zeichen abzuschneiden.")
    void cutEnd6() {

        String string = "Dies ist ein Test.";

        String cutString = null;
        try {
            cutString = Strings.cutEnd(string, -1);
            fail("Ex. erwartet.");
        } catch (IllegalArgumentException e) {
            // DIN
        }
    }

}
