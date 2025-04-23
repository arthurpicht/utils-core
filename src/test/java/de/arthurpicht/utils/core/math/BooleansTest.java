package de.arthurpicht.utils.core.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleansTest {

    @Test
    void countTrue() {
        assertEquals(0, Booleans.countTrue());
        assertEquals(0, Booleans.countTrue(false));
        assertEquals(1, Booleans.countTrue(true));
        assertEquals(1, Booleans.countTrue(true, false));
        assertEquals(0, Booleans.countTrue(false, false));
    }

    @Test
    void countFalse() {
        assertEquals(0, Booleans.countFalse());
        assertEquals(1, Booleans.countFalse(false));
        assertEquals(0, Booleans.countFalse(true));
        assertEquals(1, Booleans.countFalse(true, false));
        assertEquals(2, Booleans.countFalse(false, false));
    }

    @Test
    void isExactlyOneTrue() {
        assertFalse(Booleans.isExactlyOneTrue());
        assertFalse(Booleans.isExactlyOneTrue(false));
        assertTrue(Booleans.isExactlyOneTrue(true));
        assertFalse(Booleans.isExactlyOneTrue(false, false));
        assertFalse(Booleans.isExactlyOneTrue(true, true));
        assertTrue(Booleans.isExactlyOneTrue(true, false, false));
    }

    @Test
    void isExactlyOneFalse() {
        assertFalse(Booleans.isExactlyOneFalse());
        assertTrue(Booleans.isExactlyOneFalse(false));
        assertFalse(Booleans.isExactlyOneFalse(true));
        assertFalse(Booleans.isExactlyOneFalse(false, false));
        assertFalse(Booleans.isExactlyOneFalse(true, true));
        assertFalse(Booleans.isExactlyOneFalse(true, false, false));
        assertTrue(Booleans.isExactlyOneFalse(true, false, true));
    }

    @Test
    void isAllTrue() {
        assertFalse(Booleans.isAllTrue());
        assertFalse(Booleans.isAllTrue(false));
        assertTrue(Booleans.isAllTrue(true));
        assertFalse(Booleans.isAllTrue(false, false));
        assertTrue(Booleans.isAllTrue(true, true));
        assertFalse(Booleans.isAllTrue(true, false, false));
        assertTrue(Booleans.isAllTrue(true, true, true));
    }

    @Test
    void isAllFalse() {
        assertFalse(Booleans.isAllFalse());
        assertFalse(Booleans.isAllFalse(true));
        assertTrue(Booleans.isAllFalse(false));
        assertTrue(Booleans.isAllFalse(false, false));
        assertFalse(Booleans.isAllFalse(true, true));
        assertFalse(Booleans.isAllFalse(true, false, false));
        assertFalse(Booleans.isAllFalse(true, true, true));
    }

}