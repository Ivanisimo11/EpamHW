package com.company;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 5, 7, 9, 0, 5, 4, 6};
        IntStream intStream = Arrays.stream(ints);
        System.out.println(Arrays.toString(multElements(intStream, 2).toArray()));
    }

    private static OptionalDouble average(IntStream intStream) {
        return intStream.average();
    }

    private static OptionalInt min(IntStream intStream) {
        return intStream.min();
    }

    private static int countZeroElements(IntStream intStream) {
        int counter = 0;
        for (PrimitiveIterator.OfInt it = intStream.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            if (i == 0) {
                counter++;
            }
        }
        return counter;
    }

    private static int countBiggerZeroElements(IntStream intStream) {
        int counter = 0;
        for (PrimitiveIterator.OfInt it = intStream.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            if (i > 0) {
                counter++;
            }
        }
        return counter;
    }

    private static Stream multElements(IntStream intStream, int x) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (PrimitiveIterator.OfInt it = intStream.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            arrayList.add(i * x);
        }
        return arrayList.stream();
    }
}
