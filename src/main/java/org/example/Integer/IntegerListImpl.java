package org.example.Integer;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.NotFoundException;
import org.example.Exception.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public IntegerListImpl() {
        this.list = new Integer[DEFAULT_CAPACITY];
    }

    public IntegerListImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным, либо равным нулю!");
        } else {
            this.list = new Integer[capacity];
        }
    }

    @Override
    public Integer addInteger(Integer item) {
        if (this.checkingForCompletionInteger()) {
            grow();
        }
        checkingForNullInteger(item);
        return list[size++] = item;
    }

    @Override
    public void display() {
        for (Integer element : list) {
            System.out.print(element + ", ");
        }
    }

    @Override
    public Integer addInteger(int index, Integer item) {
        checkingForSizeInteger(index);
        checkingForNullInteger(item);
        if (this.checkingForCompletionInteger()) {
            grow();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer setInteger(int index, Integer item) {
        checkingForSizeInteger(index);
        checkingForNullInteger(item);
        list[index] = item;
        return item;
    }

    @Override
    public Integer removeInteger(Integer item) {
        checkingForNullInteger(item);
        int index = indexSearchInteger(item);
        if (index < 0) {
            throw new NotFoundException();
        }
        return removeInteger(index);
    }

    @Override
    public Integer removeInteger(int index) {
        checkingForSizeInteger(index);
        Integer item = list[index];
        size--;
        if (!(index == size)) {
            System.arraycopy(list, index + 1, list, index, size - index);
        }
        return item;
    }

    @Override
    public boolean containsInteger(Integer item) {
        Integer[] listNew = toArrayInteger();
        sortInsertion(listNew);
        return binarySearch(listNew, item);
    }

    @Override
    public Integer indexOfInteger(Integer item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOfInteger(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer getInteger(int index) {
        checkingForSizeInteger(index);
        return list[index];
    }

    @Override
    public boolean equalsInteger(IntegerList otherList) {
        return Arrays.equals(this.toArrayInteger(), otherList.toArrayInteger());
    }

    @Override
    public Integer sizeInteger() {
        return size;
    }

    @Override
    public boolean isEmptyInteger() {
        return size == 0;
    }

    @Override
    public void clearInteger() {
        size = 0;
        this.list = new Integer[size];
    }

    @Override
    public Integer[] toArrayInteger() {
        return Arrays.copyOf(list, size);
    }

    private void grow() {
        int capacityOld = size;
        int capacityNew = capacityOld + DEFAULT_CAPACITY / 2;
        list = Arrays.copyOf(list, capacityNew);
    }

    private void checkingForSizeInteger(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void checkingForNullInteger(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private Integer indexSearchInteger(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkingForCompletionInteger() {
        return size == list.length;
    }

    @Override
    public Integer[] getList() {
        return this.list;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Integer[] generateRandomArray(int size) {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 1;
        }
        return arr;
    }

    private void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    public void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    @Override
    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Override
    public void printingAnArray(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private Integer partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    @Override
    public void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}
