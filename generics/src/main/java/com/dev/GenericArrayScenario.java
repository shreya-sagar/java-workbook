package com.dev;

import java.lang.reflect.Array;

public class GenericArrayScenario {

    /**
     * Returns the middle element of a variable-length argument list (varargs).
     * <p>
     * This method is generic, meaning it can accept any type of object. The type parameter <T>
     * is inferred at runtime based on the type of elements passed in.
     * <p>
     * **Heap Pollution Warning:** Since this method uses varargs with a generic type,
     * it can lead to potential heap pollution. The varargs argument (`T... a`) is treated as
     * an array of objects, and due to type erasure, the generic type information is not retained
     * at runtime. As a result, mixing different types within the varargs array can cause
     * heap pollution, where the actual type of the array elements differs from the expected type.
     *
     * @param <T> the type of the elements in the varargs
     * @param a the varargs array of elements of type T
     * @return the middle element of the varargs
     */
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length/2];
    }

    /**
     * Finds the minimum element in an array of Comparable elements.
     * <p>
     * This method uses generics with a bound, meaning the type parameter <T> is constrained
     * to types that implement the {@link Comparable} interface. This allows the method to compare
     * elements within the array to find the smallest value.
     * <p>
     * **Heap Pollution Avoidance:** This method avoids heap pollution by taking a strongly typed
     * array as input (`T[] a`) rather than using varargs. Since arrays are not created using
     * varargs and the type is explicitly passed as `T[]`, it ensures type safety at both
     * compile-time and runtime, preventing the risk of heap pollution.
     *
     * The type bound <T extends Comparable<T>> ensures that the array elements can be compared
     * using the {@code compareTo} method.
     *
     * @param <T> the type of the elements in the array, which must implement Comparable<T>
     * @param a the array of elements of type T
     * @return the minimum element in the array, or null if the array is empty or null
     */
    public static <T extends Comparable<T>> T min(T[] a) {
        if(a == null || a.length == 0) return null;
        T min = a[0];

        for(int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
        }
        return min;
    }

    /**
     * Finds the maximum element in an array of elements that implement both {@link Comparable} and {@link Cloneable}.
     * <p>
     * When using raw types, the type is treated as {@code Object} or the first bound of a generic type.
     * In this case, the type parameter <T> is bounded by both {@link Comparable} and {@link Cloneable}.
     * The JVM erases the generic type information at runtime and treats 'T' as the first bound
     * (i.e., {@link Comparable}), meaning that type conversion will cast 'T' to {@link Comparable} at runtime.
     *
     * @param <T> the type of the elements in the array, which must implement both {@link Comparable<T>} and {@link Cloneable}
     * @param a the array of elements of type T
     * @return the maximum element in the array, or null if the array is empty or null
     */
    public static <T extends Comparable<T> & Cloneable> T max(T[] a) {
        if(a == null || a.length == 0) return null;
        T max = a[0];

        for(int i = 1; i < a.length; i++) {
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return max;
    }

    /**
     * Finds the minimum and maximum elements from a variable-length argument list (varargs) of Comparable elements
     * and returns them as a {@code Pair<T>}.
     * <p>
     * The type parameter <T> is constrained by {@link Comparable}, ensuring elements can be compared.
     * The result is a {@code Pair<T>}, where the first element is the minimum and the second is the maximum.
     * <p>
     * **Heap Pollution Warning:** Using varargs with generics may cause heap pollution due to type erasure.
     * Ensure all elements passed are of the same type.
     *
     * @param <T> the type of the elements, which must implement Comparable<T>
     * @param a the varargs list of elements of type T
     * @return a {@code Pair<T>} containing the minimum and maximum elements, or null if the list is empty
     */
    @SafeVarargs
    public static <T extends Comparable<T>> Pair<T> minmax(T... a) {
        if(a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];

        for(int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getGenericArray(Class<T> clazz, T... a) {
        T[] genericArray = (T[]) Array.newInstance(clazz, a.length);
        System.arraycopy(a, 0, genericArray, 0, a.length);
        return genericArray;
    }
}
