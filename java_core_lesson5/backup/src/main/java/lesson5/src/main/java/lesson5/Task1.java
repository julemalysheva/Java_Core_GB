package lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {


    private static final int CHAR_BOUND_L = 65; // Номер начального символа
    private static final int CHAR_BOUND_H = 90; // Номер конечного символа

    private static final String TO_SEARCH = "GeekBrains";

    private static Random random = new Random();


    /**
     1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */
    public static void main(String[] args) throws IOException {
        //System.out.println(generateSymbols(50));
        writeFileContents("sample01.txt", 90, 5);
        writeFileContents("sample02.txt", 50);

        concatenate("sample02.txt", "sample01.txt", "sampleOut.txt");
        System.out.println(searchInFile("sampleOut.txt", TO_SEARCH));

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++){
            fileNames[i] = "file_" + i + ".txt";
            writeFileContents(fileNames[i], 90, 2);
            System.out.printf("Файл %s создан.\n", fileNames[i]);
        }

        List<String> lstResult = searchMatch(new File("."), TO_SEARCH);
        for (String fileName : lstResult){
            System.out.printf("Файл %s содержит искомое слово '%s'\n", fileName, TO_SEARCH);
        }
    }

    /**
     * Метод генерации некоторой последовательности символов
     * @param amount кол-во символов
     * @return
     */
    private static String generateSymbols(int amount){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < amount; i++){
            stringBuffer.append((char)random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }
        return stringBuffer.toString();
    }

    /**
     * Записать последовательность символов в файл
     * @param fileName
     * @param lenght
     */
    private static void writeFileContents(String fileName, int lenght){
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(generateSymbols(lenght).getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void writeFileContents(String fileName, int lenght, int words){
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            for (int i = 0; i < words; i++){
                if (random.nextInt(2) == 0) // 33%
                {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                }
                else {
                    fileOutputStream.write(generateSymbols(lenght).getBytes());
                }
            }
            fileOutputStream.write(generateSymbols(lenght).getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void concatenate(String fileName1, String fileName2, String fileOut){
        // На запись
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){
            int c;
            // На чтение 1
            try(FileInputStream filterInputStream = new FileInputStream(fileName1)){
                while ((c = filterInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            // На чтение 2
            try(FileInputStream filterInputStream = new FileInputStream(fileName2)){
                while ((c = filterInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    static boolean searchInFile(String fileName, String search) {
        // GeekBrains
        // GeeekBrains;
        try (FileInputStream filterInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int c;
            int counter = 0;
            while ((c = filterInputStream.read()) != -1) {
                if (c == searchData[counter]){
                    counter++;
                }
                else{
                    counter = 0;
                    if (c == searchData[counter]){
                        counter++;
                        continue;
                    }
                }
                if (counter == searchData.length){
                    return true;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    static List<String> searchMatch(File dir, String search) throws IOException{
        List<String> list = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files == null)
            return list;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                continue;
            if (searchInFile(files[i].getCanonicalPath(), search)){
                list.add(files[i].getName());
            }
        }
        return list;
    }

}
