package de.arthurpicht.utils.core.array;

import java.util.Arrays;
import java.util.List;

import static de.arthurpicht.utils.core.assertion.MethodPreconditions.assertArgumentNotNull;

@SuppressWarnings("unused")
public class ArrayUtils {

    public static Integer[] wrap(int[] intArray) {
        assertArgumentNotNull("intArray", intArray);
        return Arrays.stream(intArray)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static int[] unwrap(Integer[] intArray) {
        assertArgumentNotNull("intArray", intArray);
        return Arrays.stream(intArray)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static Long[] wrap(long[] longArray) {
        assertArgumentNotNull("longArray", longArray);
        return Arrays.stream(longArray)
                .boxed()
                .toArray(Long[]::new);
    }

    public static long[] unwrap(Long[] longArray) {
        assertArgumentNotNull("longArray", longArray);
        return Arrays.stream(longArray)
                .mapToLong(Long::longValue)
                .toArray();
    }

    public static Double[] wrap(double[] doubleArray) {
        assertArgumentNotNull("doubleArray", doubleArray);
        return Arrays.stream(doubleArray)
                .boxed()
                .toArray(Double[]::new);
    }

    public static double[] unwrap(Double[] doubleArray) {
        assertArgumentNotNull("doubleArray", doubleArray);
        return Arrays.stream(doubleArray)
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    public static Float[] wrap(float[] floatArray) {
        assertArgumentNotNull("floatArray", floatArray);
        final Float[] result = new Float[floatArray.length];
        for (int i = 0; i < floatArray.length; i++) {
            result[i] = floatArray[i];
        }
        return result;
    }

    public static float[] unwrap(Float[] floatArray) {
        assertArgumentNotNull("floatArray", floatArray);
        final float[] result = new float[floatArray.length];
        for (int i = 0; i < floatArray.length; i++) {
            result[i] = floatArray[i];
        }
        return result;
    }

    public static Byte[] wrap(byte[] byteArray) {
        assertArgumentNotNull("byteArray", byteArray);
        final Byte[] result = new Byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            result[i] = byteArray[i];
        }
        return result;
    }

    public static byte[] unwrap(Byte[] byteArray) {
        assertArgumentNotNull("byteArray", byteArray);
        byte[] result = new byte[byteArray.length];
        int i=0;
        for (byte b : byteArray) {
            result[i++] = b;
        }
        return result;
    }

    public static List<Integer> asList(int[] ints) {
        Integer[] wrappedArray = wrap(ints);
        return Arrays.asList(wrappedArray);
    }

    public static List<Long> asList(long[] longs) {
        Long[] wrappedArray = wrap(longs);
        return Arrays.asList(wrappedArray);
    }

    public static List<Double> asList(double[] doubles) {
        Double[] wrappedArray = wrap(doubles);
        return Arrays.asList(wrappedArray);
    }

    public static List<Float> asList(float[] floats) {
        Float[] wrappedArray = wrap(floats);
        return Arrays.asList(wrappedArray);
    }

    public static List<Byte> asList(byte[] bytes) {
        Byte[] wrappedArray = wrap(bytes);
        return Arrays.asList(wrappedArray);
    }

}
