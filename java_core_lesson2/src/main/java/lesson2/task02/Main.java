package lesson2.task02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3 ,4, 5};
        int n = 4;

        System.out.println("Исходный массив: " + Arrays.toString(array));

        ArrayShift.shiftElements(array, n);

        System.out.println("Сдвинутый массив: " + Arrays.toString(array));

    }
}
