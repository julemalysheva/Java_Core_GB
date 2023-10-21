package seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X'; //Фишка игрока - человека
    private static final char DOT_AI = '0'; //Фишка игрока - компьютера
    private static final char DOT_EMPTY = '*'; //Признак пустого поля
    private  static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; //Двумерный массив хранит состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static final int WIN_COUNT = 3; // Кол-во фишек для победы


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) { //внутр.цикл соответствует одной игре
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация начального состояния игры
     */
    public static void initialize(){
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    // Отрисовать текущее состояние игрового поля
    public static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Обработка хода игрока (человека)
    public static void humanTurn() {
        int x, y;
        do {
            System.out.printf("Укажите координаты хода X и Y (от 1 до %d)\nчерез пробел: ", fieldSizeX);
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода компьютера
     */
    public static void aiTurn(){
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка что ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка, что координата является валидной, в рамках нашего диапазона значений для игрового поля
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param winStr победный слоган
     * @return признак продолжения игры (true - завершение игры)
     */
    public static boolean gameCheck(char dot, String winStr) {
        if (checkWin(dot)) {
            System.out.println(winStr);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Продолжим игру
    }

    /**
     * Проверка победы
     * @param c фишка игрока (X или 0)
     * @return
     */
    public static boolean checkWin(char c) {
        // Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    /**
     * Вспомогательный метод для проверки выигрыша при размере поля выше 3*3
     * @param x координата
     * @param y координата
     * @param dot фишка игрока
     * @param win указывает на кол-во подряд идущих фишек
     * @return
     */
    public static boolean check1(int x, int y, char dot, int win) {
        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    public static boolean checkDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }

}
