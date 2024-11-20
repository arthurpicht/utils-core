package de.arthurpicht.utils.core.collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SequencedCollectionMethodCanBeUsed")
public class ListsGetDuplicatesTest {

    @Test
    public void noDuplicates() {
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> duplicates = Lists.getDuplicates(list);

        assertTrue(duplicates.isEmpty());
    }

    @Test
    public void oneDuplicate() {
        List<Integer> list = List.of(1, 2, 3, 4, 3);
        List<Integer> duplicates = Lists.getDuplicates(list);

        assertEquals(1, duplicates.size());
        assertEquals(3, duplicates.get(0));
    }

    @Test
    public void twoDuplicatesOfSameElement() {
        List<Integer> list = List.of(1, 2, 3, 4, 3, 3);
        List<Integer> duplicates = Lists.getDuplicates(list);

        assertEquals(2, duplicates.size());
        assertEquals(3, duplicates.get(0));
        assertEquals(3, duplicates.get(1));
    }

    @Test
    public void duplicatesOfTwoElement() {
        List<Integer> list = List.of(1, 2, 3, 4, 3, 3, 1);
        List<Integer> duplicates = Lists.getDuplicates(list);

        assertEquals(3, duplicates.size());
        assertEquals(3, duplicates.get(0));
        assertEquals(3, duplicates.get(1));
        assertEquals(1, duplicates.get(2));
    }

    @Test
    public void emptyList() {
        List<Integer> list = List.of();
        List<Integer> duplicates = Lists.getDuplicates(list);

        assertTrue(duplicates.isEmpty());
    }

}
