package com.dev;

import java.util.ArrayList;

public class GenericsDemo {
    public static <T extends Comparable> void main(String[] args) {
        String middle = ArrayAlg.getMiddle("John", "doe", "is", "here" );
        System.out.println(middle);

        Pair<Integer> minmax = ArrayAlg.minmax(20, 50, 60, 80 );
        System.out.println("min : " + minmax.getFirst());
        System.out.println("max : " + minmax.getSecond());

        //Warning - Unchecked cast: 'com. dev. Pair<java. lang. String>' to 'com. dev. Pair<T>'
        Pair<T> minmaxString = (Pair<T>) ArrayAlg.minmax("John", "doe", "is", "here" );

        //Error - Generic array creation not allowed
        //Pair<String>[] pairs = new Pair<String>[10];

        ArrayList<Pair<T>> pairs = new ArrayList<>();
        pairs.add(minmaxString);
        System.out.println(pairs.get(0).getFirst());

    }
}