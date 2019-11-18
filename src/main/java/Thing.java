import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Класс для определения минимального, максимального и среднего чисел.
 *
 * @version 0.4
 * @autor Ariona
 */

public class Thing<T extends Number & Comparable<? super T>> {

    private T minElement;

    private T maxElement;

    private double sum;

    private int count;

    private double average = Double.MIN_VALUE;

    public Thing() {

    }

    public Thing(List<T> numbers) {
        this();
        compute(numbers);
    }

    private void compute(T number) {
        computeMin(number);
        computeMax(number);
        computeAverage(number);
    }

    private void compute(List<T> numbers) {
        computeMin(numbers);
        computeMax(numbers);
        computeAverage(numbers);
    }

    private void computeMin(T number) {
        if (minElement == null || minElement.compareTo(number) >= 0) {
            minElement = number;
        }
    }

    private void computeMin(List<T> numbers) {
        T numbersMin;

        if (!numbers.isEmpty()) {
            numbersMin = Collections.min(numbers);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }

        if (minElement == null || minElement.compareTo(numbersMin) >= 0) {
            minElement = numbersMin;
        }
    }

    private void computeMax(T number) {
        if (maxElement == null || minElement.compareTo(number) <= 0) {
            maxElement = number;
        }
    }

    private void computeMax(List<T> numbers) {
        T numbersMax;

        if (!numbers.isEmpty()) {
            numbersMax = Collections.max(numbers);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }

        if (maxElement == null || maxElement.compareTo(numbersMax) <= 0) {
            maxElement = numbersMax;
        }
    }

    private void computeAverage(T number) {
        if (average == Double.MIN_VALUE) {
            count++;
            average = number.doubleValue();
        }

        count++;
        average = (sum + number.doubleValue()) / count;
    }

    private void computeAverage(List<T> numbers) {
        if (!numbers.isEmpty() && average == Double.MIN_VALUE) {
            OptionalDouble optionalDouble = numbers.stream()
                    .mapToDouble(a -> a.doubleValue())
                    .average();
            if (optionalDouble.isPresent()) {
                count = numbers.size();
                sum = numbers.stream().mapToDouble(a -> a.doubleValue()).sum();
                average = optionalDouble.getAsDouble();
            } else {
                throw new RuntimeException();
            }
        } else if (average != Double.MIN_VALUE) {
            sum += numbers.stream().mapToDouble(a -> a.doubleValue()).sum();
            count += numbers.size();
            average = sum / count;
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    public T getMin() {
        if (count == 0) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }

        return minElement;
    }

    public T getMax() {
        if (count == 0) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }

        return maxElement;
    }

    public double getAverage() {
        if (count == 0) {
            throw new RuntimeException("Отсутствуют данные для вычисления");
        }

        return average;
    }

    public void add(T number) {
        count++;
        sum += number.doubleValue();
        compute(number);
    }

    public void addAll(List<T> numbers) {
        if (!numbers.isEmpty()) {
            count += numbers.size();
            compute(numbers);
        }
    }
}
