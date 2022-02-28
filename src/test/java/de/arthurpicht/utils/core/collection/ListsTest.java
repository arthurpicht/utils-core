package de.arthurpicht.utils.core.collection;

import de.arthurpicht.utils.core.assertion.MethodPreconditionFailedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

//    @Test
//    void lastElementSubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 3);
//
//        assertEquals(1, sublist.size());
//        assertEquals("D", sublist.get(0));
//    }
//
//    @Test
//    void fullListAsSubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 0);
//
//        assertEquals(4, sublist.size());
//        assertEquals("A", sublist.get(0));
//        assertEquals("D", sublist.get(3));
//    }
//
//    @Test
//    void emptySubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 4);
//
//        assertEquals(0, sublist.size());
//    }
//
//    @Test
//    void emptySubListFromEmptyListEnd() {
//        List<String> list = new ArrayList<>();
//        List<String> sublist = Lists.sublist(list, 0);
//
//        assertEquals(0, sublist.size());
//    }
//
//    @Test
//    void neg_beginIndexLessZeroListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//
//        assertThrows(MethodPreconditionFailedException.class, () -> Lists.sublist(list, -1));
//    }
//
//    @Test
//    void neg_beginIndexGreaterThanEndIndexListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//
//        assertThrows(IllegalArgumentException.class, () -> Lists.sublist(list, 5));
//    }
//
//    @Test
//    void simpleSubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 1);
//
//        assertEquals(3, sublist.size());
//        assertEquals("B", sublist.get(0));
//        assertEquals("C", sublist.get(1));
//        assertEquals("D", sublist.get(2));
//    }
//
//    @Test
//    void lastElementSubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 3);
//
//        assertEquals(1, sublist.size());
//        assertEquals("D", sublist.get(0));
//    }
//
//    @Test
//    void fullListAsSubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 0);
//
//        assertEquals(4, sublist.size());
//        assertEquals("A", sublist.get(0));
//        assertEquals("D", sublist.get(3));
//    }
//
//    @Test
//    void emptySubListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//        List<String> sublist = Lists.sublist(list, 4);
//
//        assertEquals(0, sublist.size());
//    }
//
//    @Test
//    void emptySubListFromEmptyListEnd() {
//        List<String> list = new ArrayList<>();
//        List<String> sublist = Lists.sublist(list, 0);
//
//        assertEquals(0, sublist.size());
//    }
//
//    @Test
//    void neg_beginIndexLessZeroListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//
//        assertThrows(MethodPreconditionFailedException.class, () -> Lists.sublist(list, -1));
//    }
//
//    @Test
//    void neg_beginIndexGreaterThanEndIndexListEnd() {
//        List<String> list = Arrays.asList("A", "B", "C", "D");
//
//        assertThrows(IllegalArgumentException.class, () -> Lists.sublist(list, 5));
//    }

}
