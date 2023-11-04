package lesson5;

import java.io.File;

/**
 * Класс описывает метод по заданию:
 * 2. Доработайте класс Tree и метод print который мы разработали на семинаре.
 * Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.
 */
public class TreePrint {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        print(rootDirectory, "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "    ";
        } else {
            System.out.print("├─");
            indent += "│   ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                int subDirTotal = 0;
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        subDirTotal++;
                    }
                }

                int subDirCounter = 0;
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        subDirCounter++;
                        print(files[i], indent, subDirCounter == subDirTotal);
                    } else {
                        print(files[i], indent, i == files.length - 1);
                    }
                }
            }
        }
    }
}
