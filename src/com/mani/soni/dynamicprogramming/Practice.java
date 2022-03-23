package com.mani.soni.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {
//        sort2DArrayExample();
//        doubleColonExample();
//        intToIntegerConversion();
//        convertArrayToList();
//        reverseArray();
//        generateIntegerInRange();
        binarySearch();
    }

    public static void binarySearch() {
        int[] arr = {1, 10, 20};
        System.out.println(Arrays.binarySearch(arr, 20));
    }

    public static void intToIntegerConversion() {
        int[] arr = {1, 2, 3, 4};

        // :: double colon is method reference operator in Java
        // Syntax <Class name>::<method name>
        Integer[] intArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

    public static void doubleColonExample() {
        /**
         * When and how to use double colon operator?
         *
         * Method reference or double colon operator can be used to refer:
         *
         * a static method,
         * an instance method, or
         * a constructor.
         * 1. Static Method:
         * (ClassName::methodName)
         *
         * 2. Instance Method:
         * (objectOfClass::methodName)
         * System.out::println
         *
         * 3. Class Constructor
         * eg:- ArrayList::new
         * Integer::new
         *
         */
        // Get the stream
        Stream<String> stream
                = Stream.of("Geeks", "For",
                "Geeks", "A",
                "Computer",
                "Portal");
        stream.forEach( System.out::println);
        // Alternatively we can use this lambda expression.
       // stream.forEach(s -> System.out.println(s));
    }

    public static void sort2DArrayExample() {
        int[][] arr = {{1, 0}, {5, 7}, {1, 2}, {2, 5}, {8, 0}};

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]  +" , "+ arr[i][1] );
        }
    }

    public static void convertArrayToList() {
        int[] arr = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        Collectors.toSet()
    }

    public static void reverseArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Collections.reverse(Arrays.asList(arr));

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ ", ");
        }
        System.out.println();
    }

    public static void generateIntegerInRange() {
        int[] target = IntStream.rangeClosed(1, 10).toArray();
        System.out.println(Arrays.toString(target));
    }
}