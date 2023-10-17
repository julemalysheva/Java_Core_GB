package hw.program;

import hw.linkedList.LinkedListHW;

/**
 * Основной класс запуска программы с точкой входа main
 */
public class Main {
    public static void main(String[] args) {
        LinkedListHW list = new LinkedListHW();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Создание двухсвязного списка");
        list.printAll(); //1->2->3->4->5-> null
        list.reverse();
        // Вывод списка после разворота
        System.out.println("Разворот двухсвязного списка");
        list.printAll(); //5->4->3->2->1-> null

    }
}
