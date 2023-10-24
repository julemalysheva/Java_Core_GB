package ru.geekbrains.lesson3.task1;

public abstract class BaseHuman {

    protected String name;

    protected int age;

    public String getName(){
        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека");
        }
        this.age = age;
    }

    protected BaseHuman(String name){
        this(name, 18);
    }

    protected BaseHuman(String name, int age) throws RuntimeException{
        this.name = name;
        this.age = age;
        /*if (name == null || name.length() < 3){
            this.name = "<human>";
        }
        else {
            this.name = name;
        }
        if (age < 18){
            this.age = 18;
        }
        else {
            this.age = age;
        }*/

    }


    public abstract void printDisplayInfo();

}
