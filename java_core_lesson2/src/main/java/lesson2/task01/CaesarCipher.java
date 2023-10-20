package lesson2.task01;

/*
 * Написать метод «Шифр Цезаря», с булевым параметром зашифрования и
 * расшифрования и числовым ключом;
 */

/**
 * Класс описывает метод для шифрования и дешифрования текста
 * с использованием шифра Цезаря.
 */
public class CaesarCipher {
    /**
     * метод принимает текст, числовой ключ, а также флаг encrypt для указания, следует ли выполнять шифрование
     * или расшифрование. Внутри метода используется цикл, который проходит по каждому символу текста и применяет
     * сдвиг в алфавите на основе ключа. Зашифрованный или расшифрованный текст сохраняется в StringBuilder и
     * возвращается в виде строки.
     * @param text текст
     * @param key числовой ключ
     * @param encrypt флаг шифрования, расшифрования
     * @return зашифрованный или расшифрованный текст
     */
    public static String caesarCipher(String text, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder(); //для хранения зашифрованного или расшифрованного текста

        //Проходимся по каждому символу текста
        for (char c: text.toCharArray()) {
            //Проверяем, является ли символ буквой
            if (Character.isLetter(c)) {
                //Определяем смещение в алфавите с использованием ключа
                int offset = (Character.isUpperCase(c)) ? 'A' : 'a';
                //Определяем смещение в верхнем или нижнем регистре
                int shifted = (c - offset + (encrypt ? key : -key) + 26) % 26;
                //Производим сдвиг по ключу и учитываем возможность отрицательного сдвига

                result.append((char) (shifted + offset));
                //Добавляем символ в результирующий текст
            } else {
                result.append(c);
                // Если символ не является буквой, добавляем его без изменений
            }
        }
        return result.toString();
    }
}
