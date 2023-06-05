package de.arthurpicht.utils.core.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    public void unwrap() {
        Byte[] bytes = {(byte) 1, (byte) 2, (byte) 3};
        byte[] bytesUnwrapped = ArrayUtils.unwrap(bytes);

        assertEquals(3, bytesUnwrapped.length);
        assertEquals(1, bytesUnwrapped[0]);
        assertEquals(2, bytesUnwrapped[1]);
        assertEquals(3, bytesUnwrapped[2]);
    }

}