package hw.linkedList;

/**
 * Класс, описывающий узел Node для работы со связным списком
 */
public class Node {
    /**
     * @value значение текущего узла
     * @prev ссылка на предыдущий узел
     * @next ссылка на следующий узел
     */
    protected int value;
    protected Node prev;
    protected Node next;

    /**
     * Констуктор узла Node
     * @param data значение создаваемого узла
     */
    public Node(int data) {
        this.value = data;
        this.prev = null;
        this.next = null;
    }
}
