package lesson4.example_exception;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestStream implements Closeable {
    TestStream() throws IOException {
        System.out.println("constructor OK");
//         throw new IOException();
    }
    int read() throws FileNotFoundException {
        new FileInputStream("file.txt");
        System.out.println("read OK");
        return 1;
    }

    public void close() throws IOException {
        System.out.println("close OK");
        throw new IOException();
    }

    public static void main(String[] args) {
        /*
        В данном коде не нужно закрывать поток явно, это будет сделано автоматически в
следствие реализации интерфейса. Если ломается метод read(), то try-с-ресурсами
всё равно корректно закроет поток. При сломанном методе закрытия и сломанном
методе чтения одновременно, JVM запишет наверх основное исключение, но и
выведет «подавленное» исключение, вторичное в стектрейс. Рекомендуется по
возможности всегда использовать try-с-ресурсами.
         */
        try (TestStream stream = new TestStream()) {
            int a = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

//        //Метод закрытия будет пытаться выполниться от ссылки на null.
//        // Недопустимо
//        TestStream stream = null;
//        try {
//            stream = new TestStream();
//            int a = stream.read();
////            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (stream != null) {
//                try {
//                    stream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
////                    throw new RuntimeException(e);
//                }
//            }
//        }

    }
}


