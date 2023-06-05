package program;

import linkedList.LinkedListHW;

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

        list.printAll(); //1->2->3->4->5-> null
        list.reverse();
        // Вывод списка после разворота
        list.printAll(); //5->4->3->2->1-> null

    }
}
