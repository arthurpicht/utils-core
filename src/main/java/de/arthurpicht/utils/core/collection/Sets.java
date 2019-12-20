package de.arthurpicht.utils.core.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    /**
     * Returns a new HashSet instance, initialized with specified elements.
     *
     * @param elements elements to be initialized
     * @param <E> element type
     * @return Instance of hashSet initialized with specified elements
     */
    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    /**
     * Returns some single element of specified set.
     * Specified set must not be empty or null. If so, IllegalArgumentException is thrown
     *
     * @param set set
     * @param <E> element type
     * @return some element of specified set
     * @throws IllegalArgumentException if specified set is null or empty
     */
    public static <E> E getSomeElement(Set<E> set) {
        if (set == null || set.isEmpty()) throw new IllegalArgumentException("Specified set must not be null or empty.");
        return set.iterator().next();
    }

    /**
     * Returns the intersection of two sets. Elements of specified sets must implement equals() and
     * hashCode() methods.
     *
     * @param a a set to be intersected
     * @param b an other set to be intersected
     * @param <E> element type
     * @return set containing intersection elements
     */
    public static <E> Set<E> intersection(final Set<? extends E> a, final Set<? extends E> b) {

        final Set<E> intersection = new HashSet<>();

        for (E e : a) {
            if (b.contains(e)) intersection.add(e);
        }

        return intersection;
    }



}
