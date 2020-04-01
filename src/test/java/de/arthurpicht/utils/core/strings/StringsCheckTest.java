package de.arthurpicht.utils.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringsCheckTest {

    @Test
    void isOneOfArrays() {

        String[] strings = {"one", "two", "three"};

        Assertions.assertTrue(Strings.isOneOf("two", strings));
        Assertions.assertFalse(Strings.isOneOf("five", strings));
    }

    @Test
    void isOneOfList() {

        List<String> stringList = Arrays.asList("one", "two", "three");

        Assertions.assertTrue(Strings.isOneOf("two", stringList));
        Assertions.assertFalse(Strings.isOneOf("five", stringList));
    }

}
