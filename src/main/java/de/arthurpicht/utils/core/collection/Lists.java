package de.arthurpicht.utils.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.arthurpicht.utils.core.assertion.MethodPreconditions.assertArgumentIsEqualToOrGreaterThanZero;
import static de.arthurpicht.utils.core.assertion.MethodPreconditions.assertArgumentNotNull;

public class Lists {

    /**
     * Returns a new ArrayList instance, initialized with specified elements.
     *
     * @param elements elements to initialize ArrayList with
     * @param <E> type of containing elements
     * @return the specified ArrayList
     */
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... elements) {
        assertArgumentNotNull("elements", elements);
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Returns a newly creates list as a sublist of specified list. The sublist begins at the specified beginIndex
     * and extends to the element at index endIndex - 1. Thus, the length of the substring is endIndex - beginIndex.
     * The mimic of that method is the same as String.substring();
     *
     * Motivation: List.sublist creates a view. That means, that changes on that sublist are reflected on the base list.
     * This behaviour is not the case with the method specified here.
     *
     * @param list list to create sublist from
     * @param beginIndex the beginning index, inclusive
     * @param endIndex the ending index, exclusive
     * @param <E> type of list elements
     * @return the specified substring
     */
    public static <E> List<E> sublist(List<E> list, int beginIndex, int endIndex) {
        assertArgumentNotNull("list", list);
        assertArgumentIsEqualToOrGreaterThanZero("beginIndex", beginIndex);
        assertArgumentIsEqualToOrGreaterThanZero("endIndex", endIndex);
        if (beginIndex > endIndex) throw new IllegalArgumentException(
                "Index argument out of bounds: [beginIndex] is greater than [endIndex].");
        if (endIndex > list.size()) throw new IllegalArgumentException(
                "Argument [endIndex] out of bounds: greater than length of string.");

        List<E> subList = new ArrayList<>();
        for (int i = beginIndex; i < endIndex; i++) {
            subList.add(list.get(i));
        }
        return subList;
    }

    /**
     * Returns a newly creates list as a sublist of specified list. The sublist begins at the specified beginIndex
     * and extends to the end of the list. The mimic of that method is the same as String.substring();
     *
     * @param list list to create sublist from
     * @param beginIndex the beginning index, inclusive
     * @param <E> type of list elements
     * @return the specified substring
     */
    public static <E> List<E> sublist(List<E> list, int beginIndex) {
        assertArgumentNotNull("list", list);
        assertArgumentIsEqualToOrGreaterThanZero("beginIndex", beginIndex);
        if (beginIndex > list.size()) throw new IllegalArgumentException(
                "Index argument out of bounds: [beginIndex] is greater than length of string.");

        return sublist(list, beginIndex, list.size());
    }

    /**
     * Returns a newly creates list as a sublist of specified list. The sublist begins at the fist element
     * and extends to the element at index endIndex - 1. The mimic of that method is the same as String.substring();
     *
     * @param list list to create sublist from
     * @param endIndex the ending index, exclusive
     * @param <E> type of list elements
     * @return the specified substring
     */
    public static <E> List<E> sublistBegin(List<E> list, int endIndex) {
        assertArgumentNotNull("list", list);
        assertArgumentIsEqualToOrGreaterThanZero("endIndex", endIndex);

        return sublist(list, 0, endIndex);
    }

}
