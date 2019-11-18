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
    public void defaultConstructor() {
        integerThing = new Thing<>();
    }

    @Test
    public void constructorWithList() {
        Double[] d = {5.0,-0.5, 5.5};
        List<Double> doubles = new ArrayList<>(Arrays.asList(d));
        Thing<Double> thing = new Thing<>(doubles);
    }

    @Test
    public void add() {
        integerThing.add(5);
        assertEquals(new Integer(5),integerThing.getMin());
    }

    @Test
    public void add2() {
        longThing.add(5L);
        assertEquals(new Long(5), longThing.getMax());
    }

    @Test
    public void addAll() {
        integerThing.addAll(Arrays.asList(5,5,5,5,5));
        assertEquals(5.0, integerThing.getAverage());
    }

    @Test
    public void addAll1() {
        List<Long> longs = new ArrayList<>(Arrays.asList(5L,5L,5L));
        longThing.addAll(longs);
        assertEquals(new Long(5), longThing.getMax());
    }

    @Test
    public void addAll2() {
        List<Double> doubles = new ArrayList<>(Arrays.asList(5.0,5.0,-0.5,5.5));
        doubleThing.addAll(doubles);
        assertEquals(-0.5, doubleThing.getMin());
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

    @Test
    public void doubleAdd() {
        List<Integer> first = new ArrayList<>(Arrays.asList(5,5,5,5));
        List<Integer> second = new ArrayList<>(Arrays.asList(-5,-5,-5,-5));
        integerThing.addAll(first);
        integerThing.addAll(second);
        assertEquals(new Integer(-5), integerThing.getMin());
        assertEquals(new Integer(5), integerThing.getMax());
        assertEquals(0.0,integerThing.getAverage());

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

}