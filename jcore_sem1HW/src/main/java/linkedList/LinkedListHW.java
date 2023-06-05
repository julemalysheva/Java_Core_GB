package linkedList;

/**
 * Класс, описывающий работу связанного списка LinkedList
 */
public class LinkedListHW {
    private Node head;
    private Node tail;

    /**
     * Конструктор по умолчанию для создания нового объекта связанного списка
     */
    public LinkedListHW() {
        this.head = null;
        this.tail = null;
    }

    /**
     * метод add, который будет добавлять новый узел в конец списка
     * @param data значение добавляемого узла
     */
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * метод вывода в консоль для связанного списка
     */
    public void printAll(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println(" null");
    }

    /**
     * метод reverse для разворота двухсвязного связного списка - итеративно (меньше ресурсов, чем рекурсивно)
     */
    public void reverse() {
        Node current = this.head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            this.head = temp.prev;
        }
    }

}
