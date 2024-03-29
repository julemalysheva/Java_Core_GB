package lesson2.task02;
/*
Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический
(последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций
 */

/**
 * Класс содержит метод - циклический сдвиг элементов массива на n позиций
 */
public class ArrayShift {

    /**
     * метод, который выполняет циклический сдвиг элементов массива на n позиций
     * @param array исходный массив
     * @param n указывает на количество позиций для циклического сдвига
     */
    public static void shiftElements(int[] array, int n) {
        int length = array.length;

        //Вычисляем действительное смещение, чтобы оно было в пределах длины массива
        int shift = n % length;

        //Создаем временный массив для хранения сдвинутых элементов
        int[] temp = new int[length];

        //Сдвигаем элементы массива во временный массив
        for (int i = 0; i < length; i++) {
            int newIndex = (i - shift + length) % length;
            temp[newIndex] = array[i];
        }

        //Копируем сдвинутые элементы из временного массива обратно в исходный массив
        System.arraycopy(temp, 0, array, 0, length);
    }
}
