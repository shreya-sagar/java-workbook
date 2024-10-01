package com.dev;

public class GenericsDemo {
    public static <T extends Comparable> void main(String[] args) {
        String middle = ArrayAlg.getMiddle("John", "doe", "is", "here" );
        System.out.println(middle);

        Pair<Integer> minmax = ArrayAlg.minmax(20, 50, 60, 80 );
        System.out.println("min : " + minmax.getFirst());
        System.out.println("max : " + minmax.getSecond());

        Pair<T> minmaxString = (Pair<T>) ArrayAlg.minmax("John", "doe", "is", "here" );

    }
}