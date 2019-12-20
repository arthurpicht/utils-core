package de.arthurpicht.utils.core.collection;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetsIntersectionTest {

    @Test
    void intersectionOne() {

        Set<String> a = Sets.newHashSet("A", "B", "C");
        Set<String> b = Sets.newHashSet("C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(1, intersection.size());
        assertEquals("C", Sets.getSomeElement(intersection));
    }

    @Test
    void intersectionMulti() {

        Set<String> a = Sets.newHashSet("A", "B", "C", "D");
        Set<String> b = Sets.newHashSet("C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(2, intersection.size());
        assertTrue(intersection.contains("C"));
        assertTrue(intersection.contains("D"));
    }

    @Test
    void intersectionNone() {

        Set<String> a = Sets.newHashSet("A", "B");
        Set<String> b = Sets.newHashSet("C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(0, intersection.size());
    }

    @Test
    void intersectionDouble() {

        Set<String> a = Sets.newHashSet("A", "B", "B");
        Set<String> b = Sets.newHashSet("B", "C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(1, intersection.size());
        assertTrue(intersection.contains("B"));
    }

    @Test
    void containsNoNull() {

        Set<String> a = Sets.newHashSet("A", "B", "B");
        Set<String> b = Sets.newHashSet("B", "C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(1, intersection.size());
        assertTrue(intersection.contains("B"));
        assertFalse(intersection.contains(null));
    }


    @Test
    void intersectionContainsNull() {

        Set<String> a = Sets.newHashSet("A", null, "B", "B");
        Set<String> b = Sets.newHashSet("B", "C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(1, intersection.size());
        assertTrue(intersection.contains("B"));
    }

    @Test
    void intersectionContainsNull2() {

        Set<String> a = Sets.newHashSet("A", null, "B", "B");
        Set<String> b = Sets.newHashSet("B", "C", "D", null, "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertEquals(2, intersection.size());
        assertTrue(intersection.contains("B"));
        assertTrue(intersection.contains(null));
    }

    @Test
    void intersectionEmpty() {

        Set<String> a = Sets.newHashSet();
        Set<String> b = Sets.newHashSet("B", "C", "D", "E");

        Set<String> intersection = Sets.intersection(a, b);

        assertTrue(intersection.isEmpty());
    }
}