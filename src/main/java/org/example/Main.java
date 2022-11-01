package org.example;

import org.example.Integer.IntegerList;
import org.example.Integer.IntegerListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerListImpl integerList = new IntegerListImpl();

        integerList.addInteger(1);
        integerList.addInteger(2);
        integerList.addInteger(3);
        integerList.addInteger(4);
        integerList.addInteger(5);
        integerList.addInteger(5, 6);
        integerList.addInteger(6, 7);
        integerList.addInteger(7, 8);

        integerList.display();
        System.out.println();
        Integer[] arr = integerList.generateRandomArray(10);
        integerList.printingAnArray(arr);

        measuringTheSortingMethod();

    }

    private static void measuringTheSortingMethod() {
        IntegerList integerList = new IntegerListImpl();

        Integer[] arr = integerList.generateRandomArray(50000);
        Integer[] arrOne = Arrays.copyOf(arr, arr.length);
        Integer[] arrTwo = Arrays.copyOf(arr, arr.length);
        Integer[] arrThree = Arrays.copyOf(arr, arr.length);
        Integer[] arrFour = Arrays.copyOf(arr, arr.length);
        Integer[] arrFive = Arrays.copyOf(arr, arr.length);

        long start;
        start = System.currentTimeMillis();
        integerList.sortBubble(arrOne);
        long sortBubble = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки пузырьком: " + sortBubble);
        start = System.currentTimeMillis();
        integerList.sortSelection(arrTwo);
        long sortSelection = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки выбором: " + sortSelection);
        start = System.currentTimeMillis();
        integerList.sortInsertion(arrThree);
        long sortInsertion = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки вставкой: " + sortInsertion);
        start = System.currentTimeMillis();
        integerList.quickSort(arrFour, 0, arrFour.length - 1);
        long sortQuick = System.currentTimeMillis() - start;
        System.out.println("Время, быстрой сортировки: " + sortQuick);
        start = System.currentTimeMillis();
        integerList.mergeSort(arrFive);
        long sortMerge = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки слиянием: " + sortMerge);
    }
}