package de.arthurpicht.utils.core.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListsTest {

    @Test
    void simpleSubListEnd() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 1);

        assertEquals(3, sublist.size());
        assertEquals("B", sublist.get(0));
        assertEquals("C", sublist.get(1));
        assertEquals("D", sublist.get(2));
    }

}
