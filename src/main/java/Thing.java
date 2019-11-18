import java.util.*;

/**
 * Класс для определения минимального, максимального и среднего чисел.
 * @autor Ariona
 * @version 0.4
 */

public class Thing<T extends Number & Comparable<? super T>> {

    private List<T> list;

    private T minElement;

    private T maxElement;

    private double average;

    public Thing() {
        list = new ArrayList<>();
    }

    public Thing(List<T> numbers) {
        this();
        list.addAll(numbers);
        compute();
    }

    private void compute() {
        minElement = computeMin();
        maxElement = computeMax();
        average = computeAverage();
    }

    private T computeMin() {
        if (list.size() != 0) {
            return Collections.min(list);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    private T computeMax() {
        if (list.size() != 0) {
            return Collections.max(list);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    private double computeAverage() {
        if (list.size() != 0) {
            OptionalDouble optionalDouble = list.stream()
                                                .mapToDouble(a -> a.doubleValue())
                                                .average();
            if (optionalDouble.isPresent()) {
                return optionalDouble.getAsDouble();
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    @Override
    public String toString() {
        int iMax = size() - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(list.get(i));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public void add(T t) {
        list.add(t);
        compute();
    }

    public void addAll(Collection<? extends T> c) {
        list.addAll(c);
        compute();
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public T getMin() {
        if (list.isEmpty()) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }
        return minElement;
    }

    public T getMax() {
        if (list.isEmpty()) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }
        return maxElement;
    }

    public double getAverage() {
        if (list.isEmpty()) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }
        return average;
    }
}
