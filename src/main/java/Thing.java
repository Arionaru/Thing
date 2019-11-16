import java.util.Arrays;
import java.util.List;

/**
 * Класс для определения минимального, максимального и среднего чисел.
 * @autor Ariona
 * @version 0.3
 */



public class Thing<T extends Number> {

    private final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] numbers;
    private int size;

    public Thing() {
        numbers = EMPTY_ELEMENTDATA;
        size = 0;
    }

    public Thing(List<T> numbers) {
        this.numbers = numbers.toArray();
        size = numbers.size();
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = numbers.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        numbers = Arrays.copyOf(numbers, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public T getMin() {
        if (size != 0) {
            Object[] copy = Arrays.copyOf(numbers,size);
            Arrays.sort(copy);
            return (T)copy[0];
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    public T getMax() {
        if (size != 0) {
            Object[] copy = Arrays.copyOf(numbers,size);
            Arrays.sort(copy);
            return (T)copy[size-1];
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    public double getAverage() {
        if (size != 0) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (double) numbers[i];
            }
            return sum / size;
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    private int calculateCapacity(Object[] numbers, int minCapacity) {
        if (numbers == EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(numbers, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - numbers.length > 0)
            grow(minCapacity);
    }

    public void add(T number) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        numbers[size++] = number;
    }

    public void addAll(List<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, numbers, size, numNew);
        size += numNew;
    }


    @Override
    public String toString() {

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(numbers[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public int size() {
        return size;
    }
}
