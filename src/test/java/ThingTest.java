import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class ThingTest {

    private Thing<Integer> integerThing;
    private Thing<Long> longThing;
    private Thing<Double> doubleThing;

    @Before
    public void create() {
        integerThing = new Thing<>();
        longThing = new Thing<>();
        doubleThing = new Thing<>();
    }

    @Test
    public void constructorWithoutParameterTest() {
        Thing<Integer> thing = new Thing<>();
        assertEquals("[]", thing.toString());
    }

    @Test
    public void constructorWithList() {
        Double[] d = {5.0,-0.5, 5.5};
        List<Double> doubles = new ArrayList<>(Arrays.asList(d));
        Thing<Double> thing = new Thing<>(doubles);
        assertEquals("[5.0, -0.5, 5.5]", thing.toString());
    }

    @Test
    public void add() {
        integerThing.add(5);
        assertEquals("[5]",integerThing.toString());
    }

    @Test
    public void addAll() {
        integerThing.addAll(Arrays.asList(5,5,5,5,5));
        assertEquals("[5, 5, 5, 5, 5]", integerThing.toString());
    }

    @Test
    public void add2() {
        longThing.add(5L);
        assertEquals("[5]", longThing.toString());
    }

    @Test
    public void addAll1() {
        List<Long> longs = new ArrayList<>(Arrays.asList(5L,5L,5L));
        longThing.addAll(longs);
        assertEquals("[5, 5, 5]", longThing.toString());
    }

    @Test
    public void addAll2() {
        List<Double> doubles = new ArrayList<>(Arrays.asList(5.0,5.0,-0.5,5.5));
        doubleThing.addAll(doubles);
        assertEquals("[5.0, 5.0, -0.5, 5.5]", doubleThing.toString());
    }

    @Test
    public void getMin() {
        List<Double> doubles = new ArrayList<>(Arrays.asList(5.0,5.0,-0.5,5.5));
        doubleThing.addAll(doubles);
        assertEquals(-0.5,doubleThing.getMin());
    }

    @Test
    public void getMax() {
        List<Double> doubles = new ArrayList<>(Arrays.asList(5.0,5.0,-0.5,5.5));
        doubleThing.addAll(doubles);
        assertEquals(5.5,doubleThing.getMax());
    }

    @Test
    public void getAverage() {
        List<Double> doubles = new ArrayList<>(Arrays.asList(5.0,5.0,-0.5,10.5));
        doubleThing.addAll(doubles);
        assertEquals(5.0,doubleThing.getAverage());
    }

    @Test(expected = RuntimeException.class)
    public void getMinNull() {
        integerThing.getMin();
    }

    @Test(expected = RuntimeException.class)
    public void getMaxNull() {
        integerThing.getMax();
    }

    @Test(expected = RuntimeException.class)
    public void getAverageNull() {
        integerThing.getAverage();
    }

    @Test
    public void getSize() {
        assertEquals(0,integerThing.size());
    }
}