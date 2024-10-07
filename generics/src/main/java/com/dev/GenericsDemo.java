package com.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {
    public static <T extends Comparable> void main(String[] args) {
        String middle = GenericArrayScenario.getMiddle("John", "doe", "is", "here" );
        System.out.println(middle);

        Pair<Integer> minmax = GenericArrayScenario.minmax(20, 50, 60, 80 );
        System.out.println("min : " + minmax.getFirst());
        System.out.println("max : " + minmax.getSecond());

        //Warning - Unchecked cast: 'com. dev. Pair<java. lang. String>' to 'com. dev. Pair<T>'
        Pair<T> minmaxString = (Pair<T>) GenericArrayScenario.minmax("John", "doe", "is", "here" );

        //Error - Generic array creation not allowed
        //Pair<String>[] pairs = new Pair<String>[10];

        ArrayList<Pair<T>> pairs = new ArrayList<>();
        pairs.add(minmaxString);
        System.out.println(pairs.get(0).getFirst());

        String[] strings = GenericArrayScenario.getGenericArray(String.class,"Generic", "Array", "is", "here");
        System.out.println(String.join(" ", strings));
    }
}