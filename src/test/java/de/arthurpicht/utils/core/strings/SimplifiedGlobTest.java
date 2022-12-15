package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class SimplifiedGlobTest {

    @Test
    public void exactMatch() {
        Pattern pattern = SimplifiedGlob.compile("abc");
        assertTrue(pattern.matcher("abc").matches());
        assertFalse(pattern.matcher("ab").matches());
        assertFalse(pattern.matcher("abcd").matches());
        assertFalse(pattern.matcher("xabc").matches());
    }

    @Test
    public void trailingAsterisk() {
        Pattern pattern = SimplifiedGlob.compile("abc*");
        assertTrue(pattern.matcher("abc").matches());
        assertTrue(pattern.matcher("abcde").matches());
        assertFalse(pattern.matcher("ab").matches());
    }

    @Test
    public void leadingAsterisk() {
        Pattern pattern = SimplifiedGlob.compile("*abc");
        assertTrue(pattern.matcher("abc").matches());
        assertTrue(pattern.matcher("pre-abc").matches());
        assertFalse(pattern.matcher("ab").matches());
    }

    @Test
    public void midAsterisk() {
        Pattern pattern = SimplifiedGlob.compile("abc*xyz");
        assertTrue(pattern.matcher("abcjxyz").matches());
        assertTrue(pattern.matcher("abc-dummy-xyz").matches());
        assertTrue(pattern.matcher("abcxyz").matches());
        assertFalse(pattern.matcher("Xabcxyz").matches());
        assertFalse(pattern.matcher("abcxyzX").matches());
    }

    @Test
    public void escapedAsterisk() {
        Pattern pattern = SimplifiedGlob.compile("abc\\*xyz");
        assertTrue(pattern.matcher("abc*xyz").matches());
        assertFalse(pattern.matcher("abc123xyz").matches());
    }

    @Test
    public void trailingQuestionMark() {
        Pattern pattern = SimplifiedGlob.compile("abc?");
        assertTrue(pattern.matcher("abcd").matches());
        assertFalse(pattern.matcher("abc").matches());
        assertFalse(pattern.matcher("ab").matches());
        assertFalse(pattern.matcher("abcde").matches());
    }

    @Test
    public void leadingQuestionMark() {
        Pattern pattern = SimplifiedGlob.compile("?abc");
        assertTrue(pattern.matcher("pabc").matches());
        assertFalse(pattern.matcher("abc").matches());
        assertFalse(pattern.matcher("pre-abc").matches());
        assertFalse(pattern.matcher("ab").matches());
        assertFalse(pattern.matcher("pabcd").matches());
    }

    @Test
    public void midQuestionMark() {
        Pattern pattern = SimplifiedGlob.compile("abc?xyz");
        assertTrue(pattern.matcher("abcjxyz").matches());
        assertFalse(pattern.matcher("abc-dummy-xyz").matches());
        assertFalse(pattern.matcher("Xabc-xyz").matches());
        assertFalse(pattern.matcher("abc-xyzX").matches());
    }

    @Test
    public void twoTrailingQuestionMarks() {
        Pattern pattern = SimplifiedGlob.compile("abc??");
        assertTrue(pattern.matcher("abcde").matches());
        assertFalse(pattern.matcher("abcd").matches());
        assertFalse(pattern.matcher("abc").matches());
        assertFalse(pattern.matcher("ab").matches());
        assertFalse(pattern.matcher("abcdef").matches());
    }

    @Test
    public void twoLeadingQuestionMarks() {
        Pattern pattern = SimplifiedGlob.compile("??abc");
        assertTrue(pattern.matcher("ppabc").matches());
        assertFalse(pattern.matcher("abc").matches());
        assertFalse(pattern.matcher("pabc").matches());
        assertFalse(pattern.matcher("pre-abc").matches());
        assertFalse(pattern.matcher("ab").matches());
        assertFalse(pattern.matcher("ppabcd").matches());
    }

    @Test
    public void twoMidQuestionMarks() {
        Pattern pattern = SimplifiedGlob.compile("abc??xyz");
        assertTrue(pattern.matcher("abcjjxyz").matches());
        assertFalse(pattern.matcher("abcjxyz").matches());
        assertFalse(pattern.matcher("abc-dummy-xyz").matches());
        assertFalse(pattern.matcher("Xabc--xyz").matches());
        assertFalse(pattern.matcher("abc--xyzX").matches());
    }

    @Test
    public void excapedMidQuestionMark() {
        Pattern pattern = SimplifiedGlob.compile("abc\\?xyz");
        assertTrue(pattern.matcher("abc?xyz").matches());
        assertFalse(pattern.matcher("abcjxyz").matches());
        assertFalse(pattern.matcher("abc-dummy-xyz").matches());
        assertFalse(pattern.matcher("Xabc--xyz").matches());
        assertFalse(pattern.matcher("abc--xyzX").matches());
    }

    @Test
    public void regexMetaChars() {
        Pattern pattern = SimplifiedGlob.compile("[]{}|");
        assertTrue(pattern.matcher("[]{}|").matches());
        assertFalse(pattern.matcher("abc").matches());
    }

    @Test
    public void combination() {
        Pattern pattern = SimplifiedGlob.compile("?abc*xyz?");
        assertTrue(pattern.matcher("-abc?xyz-").matches());
        assertTrue(pattern.matcher("-abcxyz-").matches());
        assertTrue(pattern.matcher("-abc***xyz-").matches());
        assertFalse(pattern.matcher("abcxyz").matches());
    }

}