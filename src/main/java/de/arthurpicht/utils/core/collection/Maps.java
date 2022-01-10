package de.arthurpicht.utils.core.collection;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Maps {

    /**
     * Returns an immutable map for all elements in specified map. If specified map guarantees iteration order, the
     * returned map will also do.
     *
     * @param sourceMap map whose elements will be contained in returned map
     * @param <K> the type of keys maintained by map
     * @param <V> the type of values maintained by map
     * @return immutable map
     */
    public static <K,V> Map<K,V> immutableMap(Map<K, V> sourceMap) {
        // see https://stackoverflow.com/questions/22636575/unmodifiablemap-java-collections-vs-immutablemap-google
        return Collections.unmodifiableMap(new LinkedHashMap<>(sourceMap));
    }

}
