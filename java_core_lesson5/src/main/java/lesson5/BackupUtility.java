package lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Класс описывает метод по заданию:
 * 1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
 */
public class BackupUtility {

    public static void main(String[] args) {
        String sourceDirectoryPath = "."; // Текущая директория
        String backupDirectoryPath = "./backup"; // Директория для резервных копий

        try {
            File backupDir = new File(backupDirectoryPath);
            //Вызываем метод резервного копирования
            backupDirectory(new File(sourceDirectoryPath), backupDir);
            System.out.println("Резервные копии созданы успешно.");
            //Выводим в консоль дерево созданной резервной папки
            TreePrint.print(backupDir, "", true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании резервных копий: " + e.getMessage());
        }
    }

    public static void backupDirectory(File sourceDirectory, File backupDirectory) throws IOException {

        //работает, но задваивает некоторые папки, но файлы по одному экземпляру
        File[] files = sourceDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Рекурсивно создаем резервные копии поддиректорий
                    File newBackupDirectory = new File(backupDirectory, file.getName());
                    newBackupDirectory.mkdir();
                    backupDirectory(file, newBackupDirectory);
                } else {
                    // Создаем поддиректории в резервной папке, если не существуют
                    File parentDirectory = new File(backupDirectory, file.getParent());
                    if (!parentDirectory.exists()) {
                        parentDirectory.mkdirs();
                    }

                    // Копируем файл в резервную директорию
                    Files.copy(file.toPath(), new File(parentDirectory, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }

    }

}
