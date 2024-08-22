package de.arthurpicht.utils.core.collection;

import de.arthurpicht.utils.core.assertion.MethodPreconditions;

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
     * Concatenates elements of specified lists to a new list of type ArrayList.
     *
     * @param lists lists to be concatenated
     * @return concatenated list
     * @param <T> type parameter for lists
     * @throws IllegalArgumentException if specified parameter is null
     */
    @SafeVarargs
    public static <T> ArrayList<T> concat(List<T>... lists) {
        MethodPreconditions.assertArgumentNotNull("lists", lists);
        if (lists.length == 0) return new ArrayList<>();

        int capacity = 0;
        for (List<T> list : lists) {
            if (list == null) throw new IllegalArgumentException("null specified as parameter.");
            capacity += list.size();
        }

        ArrayList<T> concatList = new ArrayList<>(capacity);

        for (List<T> list : lists) {
            concatList.addAll(list);
        }
        return concatList;
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

    /**
     * Returns the first element of specified non-empty list.
     *
     * @param list list to obtain first element from
     * @param <E> type of list elements
     * @return the first element
     * @throws IllegalArgumentException if list is empty
     */
    public static <E> E getFirstElement(List<E> list) {
        MethodPreconditions.assertArgumentNotNull("list", list);
        if (list.size() == 0) throw new IllegalArgumentException("Specified list is empty.");
        return list.get(0);
    }

    /**
     * Returns the last element of specified non-empty list.
     *
     * @param list list to obtain last element from
     * @param <E> type of list elements
     * @return the last element
     * @throws IllegalArgumentException if list is empty
     */
    public static <E> E getLastElement(List<E> list) {
        MethodPreconditions.assertArgumentNotNull("list", list);
        if (list.size() == 0) throw new IllegalArgumentException("Specified list is empty.");
        return list.get(list.size() - 1);
    }


}
