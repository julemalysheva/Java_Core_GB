package lec_lesson4.example_inner_class;

public class Orange {
    private Juice juice;
    public Orange() {
        this.juice = new Juice();
    }

    public void squeezeJuice() {
        System.out.println("Squeeze juice...");
        juice.flow();
    }
    private class Juice {
        public void flow() {
            System.out.println("Juice dripped...");
        }
    }

    public static void main(String[] args) {
        Orange orange = new Orange();
        orange.squeezeJuice();
    }
    // Такая связь объектов и классов называется композицией. Существуют
    //также ассоциация и агрегация.

}


