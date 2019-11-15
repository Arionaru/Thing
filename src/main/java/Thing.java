/**
 * Класс для определения минимального, максимального и среднего чисел.
 * @autor Ariona
 * @version 0.1
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class Thing {

    private int[] array;

    private List<? extends Number> numbers;


    public Thing(int[] array) {

        if (array != null && array.length != 0) {
            this.array = array;
        } else {
            throw new RuntimeException("Неверный аргумент конструктора");
        }
    }

    public Thing(List<? extends Number> numbers) {

        if (numbers != null && numbers.size() != 0){
            this.numbers = numbers;
        } else {
            throw new RuntimeException("Неверный аргумент конструктора");
        }

    }
    /**
     * @param fileName - содержит путь к файлу, числа в котором представлены в одну строку через пробел
     */
    public Thing(String fileName) {

        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("Неверный аргумент конструктора");
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

            for (int i = 0; i < strings.length; i++) {
                try {
                    numbersFromFile.add(NumberFormat.getInstance().parse(strings[i]));
                } catch (NumberFormatException | ParseException e) {
                    throw new RuntimeException("Неверный формат данных");
                }
            }

            numbers = numbersFromFile;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла!");
        }
    }

    public Number getMin() {

        if (array != null) {
            return getMinArray();
        }

        return getMinListNumbers();
    }

    private int getMinArray() {
        Arrays.sort(array);
        return array[0];
    }

    private Number getMinListNumbers() {
        sortListNumbers();
        return numbers.get(0);
    }

    private void sortListNumbers() {
        Collections.sort(numbers,new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                Double d1 = (o1 == null) ? Double.POSITIVE_INFINITY : o1.doubleValue();
                Double d2 = (o2 == null) ? Double.POSITIVE_INFINITY : o2.doubleValue();
                return  d1.compareTo(d2);
            }
        });
    }

    public Number getMax() {

        if (array != null) {
            return getMaxArray();
        }

        return getMaxListNumbers();
    }

    private Number getMaxListNumbers() {
        sortListNumbers();
        return numbers.get(numbers.size()-1);
    }

    private Number getMaxArray() {
        Arrays.sort(array);
        return array[array.length-1];
    }

    public Number getAverage() {

        if (array != null) {
            return getAvgArray();
        }

        return getAvgListNumbers();
    }

    private double getAvgListNumbers() {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.size();
    }

    private double getAvgArray() {
        double sum = 0;

        for (int j = 0; j < array.length; j++) {
            sum += array[j];
        }

        return sum / array.length;
    }
}
