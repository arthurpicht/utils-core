package de.arthurpicht.utils.core.collection;

import de.arthurpicht.utils.core.assertion.MethodPreconditionFailedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListsSublistTest {

    @Test
    void simple() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 1, 3);

        assertEquals(2, sublist.size());
        assertEquals("B", sublist.get(0));
        assertEquals("C", sublist.get(1));
    }

    @Test
    void noSideEffect() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 1, 3);
        sublist.add("X");

        assertEquals(4, list.size());
    }

    @Test
    void oneElementSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 2, 3);

        assertEquals(1, sublist.size());
        assertEquals("C", sublist.get(0));
    }

    @Test
    void firstElementSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 0, 1);

        assertEquals(1, sublist.size());
        assertEquals("A", sublist.get(0));
    }

    @Test
    void lastElementSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 3, 4);

        assertEquals(1, sublist.size());
        assertEquals("D", sublist.get(0));
    }

    @Test
    void fullListAsSubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 0, 4);

        assertEquals(4, sublist.size());
        assertEquals("A", sublist.get(0));
        assertEquals("D", sublist.get(3));
    }

    @Test
    void emptySubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> sublist = Lists.sublist(list, 2, 2);

        assertEquals(0, sublist.size());
    }

    @Test
    void emptySubListFromEmptyList() {
        List<String> list = new ArrayList<>();
        List<String> sublist = Lists.sublist(list, 0, 0);

        assertEquals(0, sublist.size());
    }

    @Test
    void neg_beginIndexLessZero() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        assertThrows(MethodPreconditionFailedException.class, () -> Lists.sublist(list, -1, 1));
    }

    @Test
    void neg_endIndexGreaterThanSize() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        assertThrows(IllegalArgumentException.class, () -> Lists.sublist(list, 0, 5));
    }

    @Test
    void neg_beginIndexGreaterThanEndIndex() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        assertThrows(IllegalArgumentException.class, () -> Lists.sublist(list, 2, 1));
    }

}
