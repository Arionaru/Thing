import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class ThingTest {

    Thing thing;

    @Before
    public void create() {
        thing = new Thing();
    }

    @Test
    public void getMin() {
        assertEquals(-56,thing.getMin(new int[]{5,-4,555,332,-56,43}));
    }

    @Test
    public void getMin1() {
        assertEquals(-2,thing.getMin(Arrays.asList(-2,-0.5,55,3.4)));
    }

    @Test
    public void getMin2() {
        assertEquals(-45535L,thing.getMin("a:/input.txt"));
    }

    @Test
    public void getMax() {
        assertEquals(555, thing.getMax(new int[]{5,-4,555,332,-56,43}));
    }

    @Test
    public void getMax1() {
        assertEquals(55,thing.getMax(Arrays.asList(-2,-0.5,55,3.4)));
    }

    @Test
    public void getMax2() {
        assertEquals(5675L, thing.getMax("a:/input.txt"));
    }

    @Test
    public void getAverage() {
        assertEquals(0.0, thing.getAverage(new int[]{5,-5,5,-5,-5,5}));
    }

    @Test
    public void getAverage1() {
        assertEquals(10.0, thing.getAverage(Arrays.asList(10, 0.5, 19.5)));
    }

    @Test
    public void getAverage2() {
        assertEquals(5.0, thing.getAverage("a:/input1.txt"));
    }

    @Test(expected = RuntimeException.class)
    public void nullArray() {
        int[] arr = null;
        thing.getAverage(arr);
    }

    @Test(expected = RuntimeException.class)
    public void emptyArray() {
        int[] arr = new int[0];
        thing.getMin(arr);
    }

    @Test(expected = RuntimeException.class)
    public void nullList() {
        List<Integer> list = null;
        thing.getMax(list);
    }

    @Test(expected = RuntimeException.class)
    public void emptyList() {
        thing.getMax(new ArrayList<>());
    }
}
