package de.arthurpicht.utils.core.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapsTest {

    @Test
    void immutableMapUnsupportedException() {
        Map<String, String> sourceMap = new HashMap<>();
        sourceMap.put("a", "valueOfA");
        sourceMap.put("b", "valueOfB");

        Map<String, String> immutableMap = Maps.immutableMap(sourceMap);

        //noinspection ConstantConditions
        assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("c", "valueOfC"));
    }

    @Test
    void immutableChangeSource() {
        Map<String, String> sourceMap = new HashMap<>();
        sourceMap.put("a", "valueOfA");
        sourceMap.put("b", "valueOfB");

        Map<String, String> immutableMap = Maps.immutableMap(sourceMap);

        sourceMap.put("c", "valueOfC");

        assertEquals(2, immutableMap.size());
        assertFalse(immutableMap.containsKey("c"));
    }

    @Test
    void iterationOrder() {
        Map<String, String> sourceMap = new LinkedHashMap<>();
        sourceMap.put("b", "valueOfB");
        sourceMap.put("00adslfjladf90ß9", "valueOf00adslfjladf90ß9");
        sourceMap.put("a", "valueOfA");
        sourceMap.put("ÖJLKJODIFJÖDLKJEONLDKJFLDKJJÖLFKDJFDKJFEOI", "valueOfÖJLKJODIFJÖDLKJEONLDKJFLDKJJÖLFKDJFDKJFEOI");
        sourceMap.put("0", "valueOf0");
        sourceMap.put("test1", "valueOfTest1");
        sourceMap.put("test2", "valueOfTest2");
        sourceMap.put("test0", "valueOfTest0");

        Map<String, String> immutableMap = Maps.immutableMap(sourceMap);
        Set<String> keySet = immutableMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        assertEquals("b", keyList.get(0));
        assertEquals("00adslfjladf90ß9", keyList.get(1));
        assertEquals("a", keyList.get(2));
        assertEquals("ÖJLKJODIFJÖDLKJEONLDKJFLDKJJÖLFKDJFDKJFEOI", keyList.get(3));
        assertEquals("0", keyList.get(4));
        assertEquals("test1", keyList.get(5));
        assertEquals("test2", keyList.get(6));
        assertEquals("test0", keyList.get(7));
    }

}