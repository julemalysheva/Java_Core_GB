package lec_lesson4.example_static_inner_class;

public class Cat {
    private String name, color;
    private int age;

    public Cat() {}
    public Cat(String name, String color, int
                age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    static class Voice {
        private final int volume;
        public Voice(int volume) {
            this.volume = volume;
        }
        public void sayMur() {
            System.out.printf("A cat purrs with volume %d\n", volume);
        }
    }
    //То есть, такое мурчание котика может присутствовать без видимости и понимания,
    //что именно за котик присутствует в данный момент. Также, добавлена возможность
    //установить уровень громкости мурчанья.
    //т.е. мы не видим объект, но слышим.
    public static void main(String[] args) {
        Cat.Voice voice = new Cat.Voice(100);
        voice.sayMur();

        /*
        Не следует путать объекты с
переменными. Если речь идёт о статических переменных — да, статическая
переменная класса существует в единственном экземпляре. Но применительно ко
вложенному классу static означает лишь то, что его объекты не содержат ссылок на
объекты внешнего класса.
         */
        for (int i = 0; i < 4; i++) {
            Cat.Voice voice1 = new Cat.Voice(100 + i);
            voice1.sayMur();
        }
    }

    /*
    Без объекта внешнего класса объект внутреннего просто не мог существовать. Для
статических вложенных классов это не так. Объект статического вложенного класса
может существовать сам по себе. В этом плане статические классы более
независимы, чем нестатические. Довольно важный момент заключается в том, что
при создании такого объекта нужно указывать название внешнего класса
     */
}
