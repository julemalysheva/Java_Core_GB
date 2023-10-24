package ru.geekbrains.lesson3.task1;

public class Human extends BaseHuman implements Runner{

    private int maxRun;
    private int maxJump;

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }


    private Human(String name, int age, int maxRun, int maxJump){
        super(name, age);
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void printDisplayInfo() {
        System.out.printf("%s\n", name);
    }

    private static Human create(String name){
        return create(name, 18, 1000, 1);
    }

    public static Human create(String name, int age, int maxRun, int maxJump){
        if (name == null || name.length() < 3)
            throw new RuntimeException("Некорректное имя человека");

        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека");
        }
        return new Human(name, age, maxRun, maxJump);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump){
            System.out.printf("%s перепрыгнул через стену %d см.\n", name, height);
            return true;
        }
        else {
            System.out.printf("%s не смог перепрыгнуть стену высотой %d см. Остался на месте.\n", name, height);
            return false;
        }
    }

    @Override
    public boolean run(int length) {
        if (length <= maxRun){
            System.out.printf("%s успешно пробежал %d метров.\n", name, maxRun);
            return true;
        }
        else {
            System.out.printf("%s не смог пробежать %d метров, остался на месте.\n", name, maxRun);
            return false;
        }
    }
}
