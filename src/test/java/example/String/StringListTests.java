package example.String;

import org.example.String.StringList;
import org.example.String.StringListImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static example.String.StringListConstantsTests.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringListTests {

    private final StringList stringList = new StringListImpl();

    @Test
    public void getAddStringOne() {
        assertEquals(THE_FIRST_LINE, stringList.addString(THE_FIRST_LINE));
        assertEquals(THE_SECOND_LINE, stringList.addString(THE_SECOND_LINE));
        assertThrows(RuntimeException.class, () -> stringList.addString(TRANSFER_NULL));
    }

    @Test
    public void getAddStringTwo() {
        assertEquals(THE_FIRST_LINE, stringList.addString(THE_FIRST_INDEX, THE_FIRST_LINE));
        assertEquals(THE_SECOND_LINE, stringList.addString(THE_SECOND_INDEX, THE_SECOND_LINE));
        assertThrows(RuntimeException.class, () -> stringList.addString(NEGATIVE_NUMBER, THE_FIRST_LINE));
        assertThrows(RuntimeException.class, () -> stringList.addString(THE_SECOND_INDEX, TRANSFER_NULL));
    }

    @Test
    public void getSetString() {
        assertEquals(THE_FIRST_LINE, stringList.setString(THE_FIRST_INDEX, THE_FIRST_LINE));
        assertThrows(RuntimeException.class, () -> stringList.setString(NEGATIVE_NUMBER, THE_FIRST_LINE));
        assertThrows(RuntimeException.class, () -> stringList.setString(THE_SECOND_INDEX, TRANSFER_NULL));
    }

    @Test
    public void getRemoveStringOne() {
        stringList.addString(THE_FIRST_LINE);
        assertEquals(THE_FIRST_LINE, stringList.removeString(THE_FIRST_LINE));
        stringList.addString(THE_SECOND_LINE);
        assertEquals(THE_SECOND_LINE, stringList.removeString(THE_SECOND_LINE));
        assertThrows(RuntimeException.class, () -> stringList.removeString(TRANSFER_NULL));
        assertThrows(RuntimeException.class, () -> stringList.removeString(NEGATIVE_NUMBER));
    }

    @Test
    public void getRemoveStringTwo() {
        stringList.addString(THE_FIRST_INDEX, THE_FIRST_LINE);
        assertEquals(THE_FIRST_LINE, stringList.removeString(THE_FIRST_INDEX));
        assertThrows(RuntimeException.class, () -> stringList.removeString(NEGATIVE_NUMBER));
    }

    @Test
    public void getContainsString() {
        assertFalse(stringList.containsString(THE_FIRST_LINE));
        stringList.addString(THE_FIRST_LINE);
        assertTrue(stringList.containsString(THE_FIRST_LINE));
        assertFalse(stringList.containsString(THE_SECOND_LINE));
        stringList.addString(THE_SECOND_LINE);
        assertTrue(stringList.containsString(THE_SECOND_LINE));
    }

    @Test
    public void getIndexOfString() {
        assertEquals(NEGATIVE_NUMBER, stringList.indexOfString(THE_SECOND_LINE));
        stringList.addString(THE_FIRST_INDEX, THE_FIRST_LINE);
        assertEquals(THE_FIRST_INDEX, stringList.indexOfString(THE_FIRST_LINE));
    }

    @Test
    public void getLastIndexOfString() {
        assertEquals(NEGATIVE_NUMBER, stringList.lastIndexOfString(THE_SECOND_LINE));
        stringList.addString(THE_FIRST_INDEX, THE_FIRST_LINE);
        assertEquals(THE_FIRST_INDEX, stringList.lastIndexOfString(THE_FIRST_LINE));
    }

    @Test
    public void getGetString() {
        stringList.addString(THE_FIRST_INDEX, THE_FIRST_LINE);
        assertEquals(THE_FIRST_LINE, stringList.getString(THE_FIRST_INDEX));
        stringList.addString(THE_SECOND_INDEX, THE_SECOND_LINE);
        assertEquals(THE_SECOND_LINE, stringList.getString(THE_SECOND_INDEX));
        assertThrows(RuntimeException.class, () -> stringList.getString(NEGATIVE_NUMBER));
    }

    @Test
    public void getEqualsString() {
        StringList stringListTwo = new StringListImpl();
        stringList.addString(THE_FIRST_LINE);
        stringListTwo.addString(THE_FIRST_LINE);
        assertFalse(stringList.equals(stringListTwo));
    }

    @Test
    public void getSizeString() {
        stringList.addString(THE_FIRST_LINE);
        stringList.addString(THE_SECOND_LINE);
        assertEquals(2, stringList.sizeString());
    }

    @Test
    public void getIsEmptyString() {
        assertTrue(stringList.isEmptyString());
        stringList.addString(THE_FIRST_LINE);
        assertFalse(stringList.isEmptyString());
        stringList.addString(THE_SECOND_LINE);
        assertFalse(stringList.isEmptyString());
    }

    @Test
    public void getClearString() {
        stringList.addString(THE_FIRST_LINE);
        stringList.clearString();
        assertTrue(stringList.isEmptyString());
        assertEquals(THE_FIRST_INDEX, stringList.sizeString());
    }

    @Test
    public void getToArrayString() {
        String[] expected = Arrays.copyOf(stringList.getList(), stringList.getSize());
        assertArrayEquals(expected, stringList.toArrayString());
    }
}
