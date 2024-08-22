package de.arthurpicht.utils.core.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListsConcatTest {

    @Test
    public void concatNull() {
        assertThrows(IllegalArgumentException.class, () -> Lists.concat((List<Object>) null));
    }

    @Test
    public void concatEmpty() {
        List<String> list = Lists.concat();
        assertEquals(0, list.size());
    }

    @Test
    public void concatOne() {
        List<String> input = Arrays.asList("a", "b", "c");
        List<String> concatList = Lists.concat(input);

        assertEquals(input, concatList);
    }

    @Test
    public void concatTwo() {
        List<String> input1 = Arrays.asList("a", "b", "c");
        List<String> input2 = Arrays.asList("x", "y", "z");
        List<String> concatList = Lists.concat(input1, input2);

        List<String> expected = new ArrayList<>(input1);
        expected.addAll(input2);

        assertEquals(expected, concatList);
    }

}
