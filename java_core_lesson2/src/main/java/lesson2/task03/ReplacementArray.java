package lesson2.task03;

/*
Написать метод, которому можно передать в качестве аргумента массив,
состоящий строго из единиц и нулей (целые числа типа int). Метод должен заменить
единицы в массиве на нули, а нули на единицы и не содержать ветвлений. Написать как можно больше вариантов метода.
 */

import java.util.Arrays;

public class ReplacementArray {
//    1) С использованием побитового исключающего ИЛИ (XOR):

    public static void flipArray1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }
    }

//    2) С использованием оператора унарного побитового отрицания:

    public static void flipArray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ~arr[i] & 1;
        }
    }

//    3) С использованием условного оператора:

    public static void flipArray3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

//    4) С использованием арифметической формулы:

    public static void flipArray4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i] - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 1, 1, 0, 1, 0, 1};
        System.out.println("Исходный массив:       " + Arrays.toString(array));
        flipArray1(array);
        System.out.println("Замена единиц и нулей: " + Arrays.toString(array));
        flipArray2(array);
        System.out.println("Замена единиц и нулей: " + Arrays.toString(array));
        flipArray3(array);
        System.out.println("Замена единиц и нулей: " + Arrays.toString(array));
        flipArray4(array);
        System.out.println("Замена единиц и нулей: " + Arrays.toString(array));



    }
}
