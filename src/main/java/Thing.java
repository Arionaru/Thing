/**
 * Класс для определения минимального, максимального и среднего чисел.
 * @autor Ariona
 * @version 0.2
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class Thing {

    public int getMin(int[] array) {
        if (array != null && array.length != 0) {
            Arrays.sort(array);
            return array[0];
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    public Number getMin(List<? extends Number> numbers) {
        if (numbers != null && numbers.size() != 0){
            sortListNumbers(numbers);
            return numbers.get(0);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    private void sortListNumbers(List<? extends Number> numbers) {
        Collections.sort(numbers,new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                Double d1 = (o1 == null) ? Double.POSITIVE_INFINITY : o1.doubleValue();
                Double d2 = (o2 == null) ? Double.POSITIVE_INFINITY : o2.doubleValue();
                return  d1.compareTo(d2);
            }
        });
    }

    /**
     * @param fileName - содержит путь к файлу, числа в котором представлены в одну строку через пробел
     */
    public Number getMin(String fileName) {
        List numbers = getListFromFile(fileName);
        return getMin(numbers);
    }

    private List<? extends Number> getListFromFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("Неверный формат данных");
        }

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден!");
        }

        List numbersFromFile = new ArrayList<>();
        String[] strings;
        try {
            strings = reader.readLine().split(" ");

            NumberFormat format = NumberFormat.getInstance();
            for (int i = 0; i < strings.length; i++) {
                try {
                    numbersFromFile.add(format.parse(strings[i]));
                } catch (NumberFormatException | ParseException e) {
                    throw new RuntimeException("Неверный формат данных");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла!");
        }
        return numbersFromFile;
    }

    public int getMax(int[] array) {
        if (array != null && array.length != 0) {
            Arrays.sort(array);
            return array[array.length-1];
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    public Number getMax(List<? extends Number> numbers) {
        if (numbers != null && numbers.size() != 0){
            sortListNumbers(numbers);
            return numbers.get(numbers.size()-1);
        } else {
            throw new RuntimeException("Неверный формат данных");
        }
    }

    /**
     * @param fileName - содержит путь к файлу, числа в котором представлены в одну строку через пробел
     */
    public Number getMax(String fileName) {
        List numbersFromFile = getListFromFile(fileName);
        return getMax(numbersFromFile);
    }

    public double getAverage(int[] array) {
        if (array != null && array.length != 0) {
            OptionalDouble average = Arrays.stream(array).average();
            if (average.isPresent()) {
                return average.getAsDouble();
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException("Неверный формат данных");
        }

    }

    public double getAverage(List<? extends Number> numbers) {
        if (numbers != null && numbers.size() != 0){
            double sum = 0;

            for (Number number : numbers) {
                sum += number.doubleValue();
            }

            return sum / numbers.size();
        } else {
            throw new RuntimeException("Неверный формат данных");
        }

    }

    /**
     * @param fileName - содержит путь к файлу, числа в котором представлены в одну строку через пробел
     */
    public double getAverage(String fileName) {
        List numbers = getListFromFile(fileName);
        return getAverage(numbers);
    }
}
