package ru.gb.jcore.sample;

//скомпилировали наше приложение
//PS  D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core>
//  cd D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core\src\main
//PS D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core\src\main>
// javac -sourcepath ./java -d out java/ru/gb/jcore/sample/Main.java

//выполняем запуск байт-кода на исполнение
//D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core\src\main>
//        java -classpath ./out ru.gb.jcore.sample.Main
// указывая флаг classpath и папку где лежат эти файлы, а далее путь к точке
// запуска относительно папки out

//для генерации документации команда:
//PS D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core\src\main>
// javadoc -d docs -sourcepath ./java -cp ./out -subpackages ru
// директория, где создаем, потом путь к исходникм, путь к байт-коду и указываем в нем субпакет

/*
Докер файл для образа
FROM bellsoft/liberica-openjdk-alpine:16.0.1
LABEL authors="JuleMalysheva"
COPY ./java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/gb/jcore/sample/Main.java
CMD java -classpath ./out ru.gb.jcore.sample.Main

команда для сборки
 D:\JavaProjects\IdeaProjects\Java_Core_GB\java_core\src\main> docker build . -t samplejavapp:v1

запуск контейнера из нашего образа с последующим удалением контейнера после отработки
docker run --rm samplejavapp:v1

 */

import ru.gb.jcore.regular.Decorator;
import ru.gb.jcore.regular.OtherClass;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */
public class Main {

    /**
     * Точка входа в программу. С неё всегда всё начинается.
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        int result = OtherClass.add(2, 4);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 4);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 4);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 4);
        System.out.println(Decorator.decorate(result));
    }
}
