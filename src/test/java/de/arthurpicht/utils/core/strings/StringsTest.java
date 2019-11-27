package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @Test
    @DisplayName("Token in Mitte")
    void simpleSplit1() {

        String starter = "Dies ist [Token] ein Test.";
        String[] tokens = Strings.splitAtDelimiter(starter, "[Token]");

        if (tokens == null) fail("NULL");
        if (tokens.length != 2) fail();

        assertEquals("Dies ist ", tokens[0]);
        assertEquals(" ein Test.", tokens[1]);
    }

    @Test
    @DisplayName("Token am Anfang")
    void simpleSplit2() {

        String starter = "[Token] Dies ist ein Test.";
        String[] tokens = Strings.splitAtDelimiter(starter, "[Token]");

        if (tokens == null) fail("NULL");
        if (tokens.length != 2) fail();

        assertEquals("", tokens[0]);
        assertEquals(" Dies ist ein Test.", tokens[1]);
    }

    @Test
    @DisplayName("Token am Ende")
    void simpleSplit3() {

        String starter = "Dies ist ein Test. [Token]";
        String[] tokens = Strings.splitAtDelimiter(starter, "[Token]");

        if (tokens == null) fail("NULL");
        if (tokens.length != 2) fail();

        assertEquals("Dies ist ein Test. ", tokens[0]);
        assertEquals("", tokens[1]);
    }

    @Test
    @DisplayName("Kein Delimiter im String")
    void simpleSplit4() {

        String starter = "Dies ist ein Test.";
        try {
            Strings.splitAtDelimiter(starter, "[Token]");
            fail("Exception erwartet.");
        } catch (IllegalArgumentException e) {
            // Do intentionally nothing
        }

    }

    @Test
    @DisplayName("Kein Delimiter als Parameter")
    void multiSplit1() {

        String starter = "Dies ist ein Test.";

        String[] flakeArray = Strings.multiSplit(starter);

        assertNotNull(flakeArray);
        assertEquals(1, flakeArray.length);
        assertEquals(starter, flakeArray[0]);
    }

    @Test
    @DisplayName("Leerer Delimiter als Parameter")
    void multiSplit2() {

        String starter = "Dies ist ein Test.";

        try {
            String[] flakeArray = Strings.multiSplit(starter, "");
            fail("Exception expected.");
        } catch (IllegalArgumentException e) {
            // do intentionally nothing
        }
    }

    @Test
    @DisplayName("Delimiter 'null' als Parameter")
    void multiSplit3() {

        String starter = "Dies ist ein Test.";

        try {
            String[] flakeArray = Strings.multiSplit(starter, "Dies", null, "Test");
            fail("Exception expected.");
        } catch (IllegalArgumentException e) {
            // do intentionally nothing
        }
    }

    @Test
    @DisplayName("Ein Delimiter als Parameter")
    void multiSplit4() {

        String starter = "Dies [d1]ist ein Test.";

        String[] flakeArray = Strings.multiSplit(starter, "[d1]");

        assertEquals(2, flakeArray.length);
        assertEquals("Dies ", flakeArray[0]);
        assertEquals("ist ein Test.", flakeArray[1]);

    }

    @Test
    @DisplayName("Zwei Delimiter als Parameter")
    void multiSplit5() {

        String starter = "Dies [d1]ist[d2] ein Test.";

        String[] flakeArray = Strings.multiSplit(starter, "[d1]", "[d2]");

        assertEquals(3, flakeArray.length);
        assertEquals("Dies ", flakeArray[0]);
        assertEquals("ist", flakeArray[1]);
        assertEquals(" ein Test.", flakeArray[2]);
    }

    @Test
    @DisplayName("Zwei Delimiter als Parameter, einer direkt am Anfang.")
    void multiSplit6() {

        String starter = "[d1]Dies ist[d2] ein Test.";

        String[] flakeArray = Strings.multiSplit(starter, "[d1]", "[d2]");

        assertEquals(3, flakeArray.length);
        assertEquals("", flakeArray[0]);
        assertEquals("Dies ist", flakeArray[1]);
        assertEquals(" ein Test.", flakeArray[2]);
    }

    @Test
    @DisplayName("Zwei Delimiter als Parameter, einer direkt am Ende.")
    void multiSplit7() {

        String starter = "Dies ist[d1] ein Test.[d2]";

        String[] flakeArray = Strings.multiSplit(starter, "[d1]", "[d2]");

        assertEquals(3, flakeArray.length);
        assertEquals("Dies ist", flakeArray[0]);
        assertEquals(" ein Test.", flakeArray[1]);
        assertEquals("", flakeArray[2]);
    }

    @Test
    @DisplayName("Zwei Delimiter als Parameter, Reihenfolge vertauscht.")
    void multiSplit8() {

        String starter = "Dies ist[d1] ein Test.[d2]";

        String[] flakeArray = new String[0];
        try {
            flakeArray = Strings.multiSplit(starter, "[d2]", "[d1]");
            fail("Exception expected.");
        } catch (IllegalArgumentException e) {
            // DIN
        }
    }

    @Test
    @DisplayName("Zwei Delimiter, direkt aufeinander folgend.")
    void mulitSplit9() {

        String starter = "Dies ist[d1][d2]";

        String[] flakeArray = Strings.multiSplit(starter, "[d1]", "[d2]");

        assertEquals(3, flakeArray.length);
        assertEquals("Dies ist", flakeArray[0]);
        assertEquals("", flakeArray[1]);
        assertEquals("", flakeArray[2]);

    }

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