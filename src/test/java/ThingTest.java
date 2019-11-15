import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ThingTest {

    private Thing thing;

    @Test
    public void getMinArray() {
        thing = new Thing(new int[]{5,-4,555,332,-56,43});
        assertEquals(-56,thing.getMin());
    }

    @Test
    public void getMinListNumbers() {
        thing = new Thing(Arrays.asList(-2,-0.5,55,3.4));
        assertEquals(-2,thing.getMin());
    }

    @Test
    public void getMinFromFile() {
        thing = new Thing("a:/input.txt");
        assertEquals(-45535L,thing.getMin());
    }

    @Test
    public void getMaxArray() {
        thing = new Thing(new int[]{5,-4,555,332,-56,43});
        assertEquals(555,thing.getMax());
    }

    @Test
    public void getMaxListNumbers() {
        thing = new Thing(Arrays.asList(-2,-0.5,55,3.4));
        assertEquals(55,thing.getMax());
    }

    @Test
    public void getMaxFromFile() {
        thing = new Thing("a:/input.txt");
        assertEquals(5675L,thing.getMax());
    }

    @Test
    public void getAvgArray() {
        thing = new Thing(new int[]{5,-5,5,-5,-5,5});
        assertEquals(0.0, thing.getAverage());
    }

    @Test
    public void getAvgList() {
        thing = new Thing(Arrays.asList(-2,-0.5,55,3.4));
        assertEquals(13.975,thing.getAverage());
    }

    @Test
    public void getAvgFile() {
        thing = new Thing("a:/input1.txt");
        assertEquals(5.0,thing.getAverage());
    }

    @Test(expected = RuntimeException.class)
    public void nullArray() {
        int[] arr = null;
        thing = new Thing(arr);
    }

    @Test(expected = RuntimeException.class)
    public void emptyArray() {
        int[] arr = new int[0];
        thing = new Thing(arr);
    }

    @Test(expected = RuntimeException.class)
    public void nullList() {
        List<Integer> list = null;
        thing = new Thing(list);
    }

    @Test(expected = RuntimeException.class)
    public void emptyList() {
        thing = new Thing(new ArrayList<Integer>());
    }
}
