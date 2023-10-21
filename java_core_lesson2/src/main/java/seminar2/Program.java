package seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X'; //Фишка игрока - человека
    private static final char DOT_AI = '0'; //Фишка игрока - компьютера
    private static final char DOT_EMPTY = '*'; //Признак пустого поля
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; //Двумерный массив хранит состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    //    private static final int WIN_COUNT = 3; // Кол-во фишек для победы
    private static final int MIN_SIZE = 3; // минимальный размер игрового поля
    private static int winCount; // Кол-во фишек для победы


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
    public static void initialize() {
        do {
            fieldSizeX = inputNum(String.format("Укажите размер игрового поля, число >= %d: ", MIN_SIZE));
            winCount = inputNum(String.format("Укажите количество фишек для победы \n" +
                    "(от %d до %d): ", MIN_SIZE, fieldSizeX));
        }
        while (!checkInitialize(fieldSizeX, winCount));

        fieldSizeY = fieldSizeX; //можно было обойтись одной переменной, но оставила как есть

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Проверка инициализации игрового поля, размер не меньше 3-х,
     * указанное число фишек для выигрыша не должно превышать размера поля
     */
    public static boolean checkInitialize(int size, int countWin) {
        return (size == MIN_SIZE && countWin == MIN_SIZE)
                || (size > MIN_SIZE && countWin <= size && countWin >= MIN_SIZE);
    }

    /**
     * получаем и проверяем число с пользовательского ввода
     *
     * @param strInput строка для отображения пользователю при запросе ввода
     * @return число с пользовательского ввода
     */
    public static int inputNum(String strInput) {
        int numInput = 0;
        boolean chNum = false;

        while (!chNum) {
            System.out.print(strInput);

            if (scanner.hasNextInt()) {
                numInput = scanner.nextInt();
                if (numInput <= 0) {
                    System.out.println("Введите положительное число");
                } else {
                    chNum = true;
                }
            } else {
                System.out.println("Некорректный ввод");
                scanner.nextLine(); // Пропустить некорректный ввод
            }
        }
        scanner.nextLine(); // Пропустить следующую строку ввода?

        return numInput;
    }

    /**
     * Отрисовать текущее состояние игрового поля
     */
    public static void printField() {
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

    /**
     * Обработка хода игрока (человека)
     */
    public static void humanTurn() {
        int x, y;
        do {
//            System.out.printf("Укажите координаты хода X и Y (от 1 до %d)\nчерез пробел: ", fieldSizeX);
//            x = scanner.nextInt() - 1;
//            y = scanner.nextInt() - 1;
            x = inputNum(String.format("Укажите координату хода по оси X (от 1 до %d)\nномер строки: "
                    , fieldSizeX)) - 1;
            y = inputNum(String.format("Укажите координату хода по оси Y (от 1 до %d)\nномер столбца: "
                    , fieldSizeY)) - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода компьютера
     */
    public static void aiTurn() {
        // Проверяем потенциальный победный случай для фишки AI
        if (!findPreWinCondition(DOT_AI, winCount))
            // Если нет - проверяем потенциальный победный случай для человека и блокируем ход
            if (!findPreWinCondition(DOT_HUMAN, winCount))
                // Если нет - проверяем предвыигрышный случай для человека
                if (!findPreWinCondition(DOT_HUMAN, winCount - 1))
                    // Если нет - проверяем предвыигрышный случай для AI
                    if (!findPreWinCondition(DOT_AI, winCount - 1))
                        // аналогично можно продолжить для меньшего ряда - 2
                        if (!findPreWinCondition(DOT_HUMAN, winCount - 2))
                            if (!findPreWinCondition(DOT_AI, winCount - 2))
                            // иначе рандомный ход AI или другая логика
                            {
                                int x, y;
                                do {
                                    x = random.nextInt(fieldSizeX);
                                    y = random.nextInt(fieldSizeY);
                                }
                                while (!isCellEmpty(x, y));
                                field[x][y] = DOT_AI;
                            }
    }

    /**
     * Проверка, что ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка, что координата является валидной, в рамках нашего диапазона значений для игрового поля
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поиск предвыигрышнего случая для указанной фишки игрока
     *
     * @param c   фишка игрока
     * @param win кол-во фишек в ряду последовательно для проверки выигрышной ситуации
     * @return
     */
    public static boolean findPreWinCondition(char c, int win) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                // Проверяем только свободные ячейки
                if (field[i][j] == DOT_EMPTY) {
                    // Помещаем временно проверяемую фишку в ячейку
                    field[i][j] = c;

                    // Проверяем, сложился ли победный случай для ряда win при установке временной фишки
                    if (checkWin(c, win)) {
                        // найден предвыигрышный случай, ставим фишку AI для выигрыша или блокировки хода человека
                        field[i][j] = DOT_AI;
                        return true;
                    }

                    //Удаляем временнйю фишку для след.итерации
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false; // Не найден предвыигрышный случай по ряду win
    }

    /**
     * Проверка состояния игры
     *
     * @param dot    фишка игрока
     * @param winStr победный слоган
     * @return признак продолжения игры (true - завершение игры)
     */
    public static boolean gameCheck(char dot, String winStr) {
        if (checkWin(dot, winCount)) {
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
     *
     * @param c фишка игрока (X или 0)
     * @return
     */
    public static boolean checkWin(char c, int win) {
        return checkHorizontal(c, win) || checkVertical(c, win)
                || checkDiagonal(c, win);
    }

    /**
     * Вспомогательный метод для проверки победных ситуаций по горизонтали
     *
     * @param dot фишка игрока
     * @param win указывает на кол-во подряд идущих фишек
     * @return
     */
    public static boolean checkHorizontal(char dot, int win) {
        for (int i = 0; i < fieldSizeX; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == dot) {
                    count++;
                    if (count == win) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * Вспомогательный метод для проверки победных ситуаций по вертикали
     *
     * @param dot фишка игрока
     * @param win указывает на кол-во подряд идущих фишек
     * @return
     */
    public static boolean checkVertical(char dot, int win) {
        for (int j = 0; j < fieldSizeY; j++) {
            int count = 0;
            for (int i = 0; i < fieldSizeX; i++) {
                if (field[i][j] == dot) {
                    count++;
                    if (count == win) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * Вспомогательный метод для проверки победных ситуаций по диагоналям
     *
     * @param dot фишка игрока
     * @param win кол-во подряд идущих фишек
     * @return
     */
    public static boolean checkDiagonal(char dot, int win) {
        // Проверка диагоналей, начинающихся в левом верхнем углу
        for (int i = 0; i <= fieldSizeX - win; i++) {
            for (int j = 0; j <= fieldSizeY - win; j++) {
                int count = 0;
                for (int k = 0; k < win; k++) {
                    if (field[i + k][j + k] == dot) {
                        count++;
                        if (count == win) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        // Проверка диагоналей, начинающихся в правом верхнем углу
        for (int i = 0; i <= fieldSizeX - win; i++) {
            for (int j = fieldSizeY - 1; j >= win - 1; j--) {
                int count = 0;
                for (int k = 0; k < win; k++) {
                    if (field[i + k][j - k] == dot) {
                        count++;
                        if (count == win) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Проверка на ничью
     *
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
