package ru.geekbrains.lesson3.task1;

public class Robot extends BaseRobot implements Runner{

    private String name;
    private int maxRun;
    private int maxJump;

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
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
