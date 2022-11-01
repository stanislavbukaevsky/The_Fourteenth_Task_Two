package org.example.String;

public interface StringList {
    String addString(String item);

    void display();

    String addString(int index, String item);

    String setString(int index, String item);

    String removeString(String item);

    String removeString(int index);

    boolean containsString(String item);

    int indexOfString(String item);

    int lastIndexOfString(String item);

    String getString(int index);

    boolean equalsString(StringList otherList);

    int sizeString();

    boolean isEmptyString();

    void clearString();

    String[] toArrayString();

    String[] getList();

    int getSize();
}
