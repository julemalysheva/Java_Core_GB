package lesson4.example_local_inner_class;

public class Animal {

    void performBehavior(boolean state) {
        class Brain {
            void sleep() {
                if (state) {
                    System.out.println("Sleeping");
                } else {
                    System.out.println("Not sleeping");
                }
            }
        }
        Brain brain = new Brain();
        brain.sleep();
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.performBehavior(true);
    }
}

/**
 * Например, некоторое животное, у которого устанавливается состояние спит оно или
 * нет. Метод performBehavior() принимает на вход булево значение и определяет, спит
 * ли животное. Мог возникнуть вопрос: зачем? Итоговое решение об архитектуре
 * проекта всегда зависит от структуры, сложности и предназначения программы.
 */