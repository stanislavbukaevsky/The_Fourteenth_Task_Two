package example.Integer;

import org.example.Integer.IntegerList;
import org.example.Integer.IntegerListImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static example.Integer.IntegerListConstantsTests.*;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerListTests {

    private final IntegerList integerList = new IntegerListImpl();

    @Test
    public void getAddIntegerOne() {
        assertEquals(THE_FIRST_NUMBER, integerList.addInteger(THE_FIRST_NUMBER));
        assertEquals(THE_SECOND_NUMBER, integerList.addInteger(THE_SECOND_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.addInteger(TRANSFER_NULL));
    }

    @Test
    public void getAddIntegerTwo() {
        assertEquals(THE_FIRST_NUMBER, integerList.addInteger(THE_FIRST_INDEX, THE_FIRST_NUMBER));
        assertEquals(THE_SECOND_NUMBER, integerList.addInteger(THE_SECOND_INDEX, THE_SECOND_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.addInteger(NEGATIVE_NUMBER, THE_FIRST_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.addInteger(THE_SECOND_INDEX, TRANSFER_NULL));
    }

    @Test
    public void getSetInteger() {
        assertEquals(THE_FIRST_NUMBER, integerList.setInteger(THE_FIRST_INDEX, THE_FIRST_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.setInteger(NEGATIVE_NUMBER, THE_FIRST_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.setInteger(THE_SECOND_INDEX, TRANSFER_NULL));
    }

    @Test
    public void getRemoveIntegerOne() {
        integerList.addInteger(THE_FIRST_NUMBER);
        assertEquals(THE_FIRST_NUMBER, integerList.removeInteger(THE_FIRST_NUMBER));
        integerList.addInteger(THE_SECOND_NUMBER);
        assertEquals(THE_SECOND_NUMBER, integerList.removeInteger(THE_SECOND_NUMBER));
        assertThrows(RuntimeException.class, () -> integerList.removeInteger(TRANSFER_NULL));
        assertThrows(RuntimeException.class, () -> integerList.removeInteger(NEGATIVE_NUMBER));
    }

    @Test
    public void getRemoveIntegerTwo() {
        integerList.addInteger(THE_SECOND_INDEX, THE_SECOND_NUMBER);
        assertEquals(THE_SECOND_NUMBER, integerList.removeInteger(THE_SECOND_INDEX));
        assertThrows(RuntimeException.class, () -> integerList.removeInteger(NEGATIVE_NUMBER));
    }

    @Test
    public void getContainsInteger() {
        assertFalse(integerList.containsInteger(THE_FIRST_NUMBER));
        integerList.addInteger(THE_FIRST_NUMBER);
        assertTrue(integerList.containsInteger(THE_FIRST_NUMBER));
        assertFalse(integerList.containsInteger(THE_SECOND_NUMBER));
        integerList.addInteger(THE_SECOND_NUMBER);
        assertTrue(integerList.containsInteger(THE_SECOND_NUMBER));
    }

    @Test
    public void getIndexOfInteger() {
        assertEquals(NEGATIVE_NUMBER, integerList.indexOfInteger(THE_SECOND_NUMBER));
        integerList.addInteger(THE_FIRST_INDEX, THE_FIRST_NUMBER);
        assertEquals(THE_FIRST_INDEX, integerList.indexOfInteger(THE_FIRST_NUMBER));
    }

    @Test
    public void getLastIndexOfInteger() {
        assertEquals(NEGATIVE_NUMBER, integerList.lastIndexOfInteger(THE_SECOND_NUMBER));
        integerList.addInteger(THE_FIRST_INDEX, THE_FIRST_NUMBER);
        assertEquals(THE_FIRST_INDEX, integerList.lastIndexOfInteger(THE_FIRST_NUMBER));
    }

    @Test
    public void getGetInteger() {
        integerList.addInteger(THE_FIRST_INDEX, THE_FIRST_NUMBER);
        assertEquals(THE_FIRST_NUMBER, integerList.getInteger(THE_FIRST_INDEX));
        integerList.addInteger(THE_SECOND_INDEX, THE_SECOND_NUMBER);
        assertEquals(THE_SECOND_NUMBER, integerList.getInteger(THE_SECOND_INDEX));
        assertThrows(RuntimeException.class, () -> integerList.getInteger(NEGATIVE_NUMBER));
    }

    @Test
    public void getEqualsInteger() {
        IntegerList integerListTwo = new IntegerListImpl();
        integerList.addInteger(THE_FIRST_NUMBER);
        integerListTwo.addInteger(THE_FIRST_NUMBER);
        assertFalse(integerList.equals(integerListTwo));
    }

    @Test
    public void getSizeInteger() {
        integerList.addInteger(THE_FIRST_NUMBER);
        integerList.addInteger(THE_SECOND_NUMBER);
        assertEquals(2, integerList.sizeInteger());
    }

    @Test
    public void getIsEmptyInteger() {
        assertTrue(integerList.isEmptyInteger());
        integerList.addInteger(THE_FIRST_NUMBER);
        assertFalse(integerList.isEmptyInteger());
        integerList.addInteger(THE_SECOND_NUMBER);
        assertFalse(integerList.isEmptyInteger());
    }

    @Test
    public void getClearInteger() {
        integerList.addInteger(THE_FIRST_NUMBER);
        integerList.clearInteger();
        assertTrue(integerList.isEmptyInteger());
        assertEquals(THE_FIRST_INDEX, integerList.sizeInteger());
    }

    @Test
    public void getToArrayInteger() {
        Integer[] expected = Arrays.copyOf(integerList.getList(), integerList.getSize());
        assertArrayEquals(expected, integerList.toArrayInteger());
    }
}
