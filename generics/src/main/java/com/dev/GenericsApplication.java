package com.dev;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.IntFunction;

public class GenericsApplication {
    public static <T extends Comparable> void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String middle = GenericUtils.getMiddle("John", "doe", "is", "here" );
        System.out.println(middle);

        Pair<Integer> minmax = GenericUtils.minmax(20, 50, 60, 80 );
        System.out.println("min : " + minmax.getFirst());
        System.out.println("max : " + minmax.getSecond());

        //Warning - Unchecked cast: 'com. dev. Pair<java. lang. String>' to 'com. dev. Pair<T>'
        Pair<T> minmaxString = (Pair<T>) GenericUtils.minmax("John", "doe", "is", "here" );

        //Error - Generic array creation not allowed
        //Pair<String>[] pairs = new Pair<String>[10];

        ArrayList<Pair<T>> pairs = new ArrayList<>();
        pairs.add(minmaxString);
        System.out.println(pairs.get(0).getFirst());


        //Integer[] minmax2 = GenericArrayScenario.minmax(Integer[]::new, 20, 50, 60, 80 ); // Error Ambiguous method call
        // Solution 1 to resolve ambiguous method call
        Integer[] minmax2 = GenericUtils.<Integer>minmax(Integer[]::new, 20, 50, 60, 80 );
        System.out.println("minmax2 min : " + minmax.getFirst());
        System.out.println("minmax2 max : " + minmax.getSecond());

        // Solution 2 to resolve ambiguous method call
        String[] minmax3 = GenericUtils.minmax((IntFunction<String[]>) String[]::new,  "Generic", "Array", "is", "here");
        System.out.println("minmax3 min : " + minmax.getFirst());
        System.out.println("minmax3 max : " + minmax.getSecond());

        String[] strings = GenericUtils.getGenericArray(String.class,"Generic", "Array", "is", "here");
        System.out.println(String.join(" ", strings));

        Pair<Integer> integerPair = GenericUtils.makePair(() -> 17);
        System.out.println("Integer Pair: " + integerPair);

        Pair<StringBuilder> stringBuilderPairUsingClass = GenericUtils.makePair(StringBuilder.class);
        System.out.println("StringBuilderPairUsingClass: " + stringBuilderPairUsingClass);

        Pair<String> stringPair = new Pair<>();
        stringPair.setFirst("first");
        stringPair.setSecond("value");
        System.out.println(stringPair.equals("value"));
    }
}

class PairException<T> {
}