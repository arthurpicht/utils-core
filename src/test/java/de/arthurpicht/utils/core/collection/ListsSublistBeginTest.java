package de.arthurpicht.utils.core.collection;

import de.arthurpicht.utils.core.assertion.MethodPreconditionFailedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListsSublistBeginTest {

    @Test
    void simple() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublistBegin(list, 2);

        assertEquals(2, sublist.size());
        assertEquals("A", sublist.get(0));
        assertEquals("B", sublist.get(1));
    }

    @Test
    void firstElementSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublistBegin(list, 1);

        assertEquals(1, sublist.size());
        assertEquals("A", sublist.get(0));
    }

    @Test
    void fullListAsSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublistBegin(list, 4);

        assertEquals(4, sublist.size());
        assertEquals("A", sublist.get(0));
        assertEquals("D", sublist.get(3));
    }

    @Test
    void emptySubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublistBegin(list, 0);

        assertEquals(0, sublist.size());
    }

    @Test
    void emptySubListFromEmptyList() {
        List<String> list = new ArrayList<>();
        List<String> sublist = Lists.sublistBegin(list, 0);

        assertEquals(0, sublist.size());
    }

    @Test
    void neg_endIndexGreaterThanSize() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        assertThrows(IllegalArgumentException.class, () -> Lists.sublistBegin(list, 5));
    }

    @Test
    void neg_EndIndexLessThanZero() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        assertThrows(IllegalArgumentException.class, () -> Lists.sublistBegin(list, -1));
    }

}
