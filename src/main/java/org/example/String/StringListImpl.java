package org.example.String;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.NotFoundException;
import org.example.Exception.NullItemException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public StringListImpl() {
        this.list = new String[DEFAULT_CAPACITY];
    }

    public StringListImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным, либо равным нулю!");
        } else {
            this.list = new String[capacity];
        }
    }

    @Override
    public String addString(String item) {
        if (this.checkingForCompletion()) {
            arrayExtension();
        }
        checkingForNull(item);
        return list[size++] = item;
    }

    @Override
    public void display() {
        for (String element : list) {
            System.out.print(element + ", ");
        }
    }

    @Override
    public String addString(int index, String item) {
        checkingForSize(index);
        checkingForNull(item);
        if (this.checkingForCompletion()) {
            arrayExtension();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public String setString(int index, String item) {
        checkingForSize(index);
        checkingForNull(item);
        list[index] = item;
        return item;
    }

    @Override
    public String removeString(String item) {
        checkingForNull(item);
        int index = indexSearch(item);
        if (index < 0) {
            throw new NotFoundException();
        }
        return removeString(index);
    }

    @Override
    public String removeString(int index) {
        checkingForSize(index);
        String item = list[index];
        size--;
        if (!(index == size)) {
            System.arraycopy(list, index + 1, list, index, size - index);
        }
        return item;
    }

    @Override
    public boolean containsString(String item) {
        return indexOfString(item) != -1;
    }

    @Override
    public int indexOfString(String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOfString(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String getString(int index) {
        checkingForSize(index);
        return list[index];
    }

    @Override
    public boolean equalsString(StringList otherList) {
        return Arrays.equals(this.toArrayString(), otherList.toArrayString());
    }

    @Override
    public int sizeString() {
        return size;
    }

    @Override
    public boolean isEmptyString() {
        return size == 0;
    }

    @Override
    public void clearString() {
        size = 0;
        this.list = new String[size];
    }

    @Override
    public String[] toArrayString() {
        return Arrays.copyOf(list, size);
    }

    private void arrayExtension() {
        int capacityOld = size;
        int capacityNew = capacityOld + 10;
        list = Arrays.copyOf(list, capacityNew);
    }

    private void checkingForSize(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void checkingForNull(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private int indexSearch(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkingForCompletion() {
        return size == list.length;
    }

    @Override
    public String[] getList() {
        return this.list;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
