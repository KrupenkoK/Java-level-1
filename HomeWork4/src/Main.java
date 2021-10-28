import java.util.Random;
import java.util.Scanner;

public class Main {

    //1. Определяем размер массива
    static final int WINCOUNT= 4;
    static final int SIZELINE = 5;

    //2. Создаем двумерный массив
    static char[][] field = new char[SIZELINE][SIZELINE];


    //3. Создаем фишки
    static final char PLAYER = 'X';
    static final char BOT = 'O';
    static final char EMPTY = '.';

    //4. Создаем сканнер для игрока
    static Scanner sc = new Scanner(System.in);

    //5. Создаем генератор заполнителя для бота
    static Random rd= new Random();

    //6. Заполняем массив
    public static void fillingField() {
        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    //7.Выводим поле на консоль
    public static void publishField() {
        System.out.println("- - - - - -");
        for (int i = 0; i < SIZELINE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZELINE; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("- - - - - -");
    }

    //8. Указываем символы
    public static void enterSymbols(int y, int x, char symbol) {
        field[y][x] = symbol;
    }

    //9. Проверяем возможность хода
    public static boolean checkTurns(int y, int x) {
        if (y < 0 || x < 0 || y > SIZELINE - 1 || x > SIZELINE - 1) {
            return false;
        } else {
            return field[y][x] == EMPTY;
        }
    }

    //10. Ход игрока
    public static void playerTurn() {
        int x;
        int y;
        do {
            System.out.println("Укажите вашу фишку по корденате X и Y: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!checkTurns(y, x));
        enterSymbols(y, x, PLAYER);
    }

    //11. Ход машины
    public static void botTurn() {
        int x;
        int y;

        //Блокировка победы машиной
        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {

                //по горизонтали
                if (horizontalChecker(i, j, PLAYER) == WINCOUNT - 1) {
                    writeSymbolOnHorizontal(i, j, BOT);
                }
                //по вертикали
                if (verticalChecker(i, j, PLAYER) == WINCOUNT - 1) {
                    writeSymbolOnVertical(i, j, BOT);
                }
                //по верхней диагонали
                if (diagonallUpChecker(i, j, PLAYER) == WINCOUNT - 1) {
                    writeSymbolOnDiagonallUp(i, j, BOT);
                }
                //по нижней диагонали
                if (diagonalDownChecker(i, j, PLAYER) == WINCOUNT - 1) {
                    writeSymbolOnDiagonallDown(i, j, BOT);
                }

            }
        }


        //Победа машины
        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {

                //по горизонтали
                if (horizontalChecker(i, j, BOT) == WINCOUNT - 1) {
                    writeSymbolOnHorizontal(i, j, BOT);
                }
                //по вертикали
                if (verticalChecker(i, j, BOT) == WINCOUNT - 1) {
                    writeSymbolOnVertical(i, j, BOT);
                }
                //по верхней диагонали
                if (diagonallUpChecker(i, j, BOT) == WINCOUNT - 1) {
                    writeSymbolOnDiagonallUp(i, j, BOT);
                }
                //по нижней диагонали
                if (diagonalDownChecker(i, j, BOT) == WINCOUNT - 1) {
                    writeSymbolOnDiagonallDown(i, j, BOT);
                }
            }
        }


        do {
            x = rd.nextInt(SIZELINE);
            y = rd.nextInt(SIZELINE);
        } while (!checkTurns(y, x));
        enterSymbols(y, x, BOT);
    }

    //Проверка серии побед по горизонтали
    public static int horizontalChecker(int v, int h, char sym) {
        int count = 0;
        for (int i = h; i < WINCOUNT ; i++) {
            if (field[v][i] == sym) {
                count++;
            }
        }
        return count;
    }

    //Проверка серии побед по вертикали
    public static int verticalChecker(int v, int h, char sym) {
        int count = 0;
        for (int i = v; i < WINCOUNT; i++) {
            if (field[i][h] == sym) {
                count++;
            }
        }
        return count;
    }

    //Проверка серии побед по верхней диагонали
    public static int diagonallUpChecker(int v, int h, char sym) {
        int count = 0;
        for (int i = 0; i < WINCOUNT; i++) {
            if (v - i == -1 || h + i >= SIZELINE) {
                break;
            }
            if (field[v - i][h + i] == sym) {
                count++;
            }
        }
        return count;
    }

    //Проверка серии побед по нижней диагонали
    private static int diagonalDownChecker(int v, int h, char sym) {
        int count=0;
        for (int i = 0; i < WINCOUNT; i++) {
            if (v + i >= SIZELINE || h + i >= SIZELINE) {
                break;
            }
            if (field[v + i][h + i] == sym) {
                count++;
            }
        }
        return count;
    }

    //Проверка заполнения линии по горизонтали
    private static boolean writeSymbolOnHorizontal(int v, int h, char sym) {
        for (int i = v; i <= WINCOUNT; i++) {
            if (field[h][i] == EMPTY) {
                field[h][i] = sym;
                return true;
            }
        }
        return false;
    }

    //Проверка заполнения линии по вертикали
    private static boolean writeSymbolOnVertical(int v, int h, char sym) {
        for (int i = h; i <= WINCOUNT; i++) {
            if (field[i][v] == EMPTY) {
                field[i][v] = sym;
                return true;
            }
        }
        return false;
    }

    //Проверка заполнения линии по верхней диагонали
    private static boolean writeSymbolOnDiagonallUp(int v, int h, char sym) {
        for (int i = h; i <= WINCOUNT; i++) {
            if (field[h + i][v - i] == EMPTY) {
                field[h + i][v - i] = sym;
                return true;
            }
        }
        return false;
    }

    //Проверка заполнения линии по нижней диагонали
    private static boolean writeSymbolOnDiagonallDown(int v, int h, char sym) {
        for (int i = h; i <= WINCOUNT; i++) {
            if (field[h + i][v + i] == EMPTY) {
                field[h + i][v + i] = sym;
                return true;
            }
        }
        return false;
    }


    //12. Проверка победы
    private static boolean checkWin(char sym) {

        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {
                //по горизонтали
                if (horizontalChecker(i, j, sym) == WINCOUNT) {
                    return true;
                }
                //по вертикали
                if (verticalChecker(i, j, sym) == WINCOUNT) {
                    return true;
                }
                //по верхней диагонали
                if (diagonallUpChecker(i, j, sym) == WINCOUNT) {
                    return true;
                }
                //по нижней диагонали
                if (diagonalDownChecker(i, j, sym) == WINCOUNT) {
                    return true;
                }
            }
        }
        return false;
    }

    //13. Проверка заполненения поле фишками
    public static boolean fullField() {
        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {
                if (field[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        fillingField();
        publishField();

        while (true) {
            playerTurn();
            publishField();
            if (checkWin(PLAYER)) {
                System.out.println("You WIN!");
                break;
            }
            if (fullField()) {
                System.out.println("DRAW!");
                break;
            }

            botTurn();
            publishField();
            if (checkWin(BOT)) {
                System.out.println("BOTs WIN!");
                break;
            }
            if (fullField()) {
                System.out.println("DRAW!");
                break;
            }
        }

    }

}