package de.arthurpicht.utils.core.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class Lists {

    /**
     * Returns a new ArrayList instance, initialized with specified elements.
     *
     * @param elements
     * @param <E>
     * @return
     */
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }


}
