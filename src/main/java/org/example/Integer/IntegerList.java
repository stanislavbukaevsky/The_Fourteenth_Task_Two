package org.example.Integer;

public interface IntegerList {
    Integer addInteger(Integer item);

    void display();

    Integer addInteger(int index, Integer item);

    Integer setInteger(int index, Integer item);

    Integer removeInteger(Integer item);

    Integer removeInteger(int index);

    boolean containsInteger(Integer item);

    Integer indexOfInteger(Integer item);

    Integer lastIndexOfInteger(Integer item);

    Integer getInteger(int index);

    boolean equalsInteger(IntegerList otherList);

    Integer sizeInteger();

    boolean isEmptyInteger();

    void clearInteger();

    Integer[] toArrayInteger();

    Integer[] getList();

    int getSize();

    Integer[] generateRandomArray(int size);

    void sortBubble(Integer[] arr);

    void sortSelection(Integer[] arr);

    void sortInsertion(Integer[] arr);

    void printingAnArray(Integer[] arr);

    void quickSort(Integer[] arr, int begin, int end);

    void mergeSort(Integer[] arr);
}
