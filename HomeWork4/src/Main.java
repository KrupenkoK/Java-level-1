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
        System.out.println("-------");
        for (int i = 0; i < SIZELINE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZELINE; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
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
        
        do {
            x = rd.nextInt(SIZELINE);
            y = rd.nextInt(SIZELINE);
        } while (!checkTurns(y, x));
        enterSymbols(y, x, BOT);
    }

    //12. Проверка победы
    private static boolean checkWin(char sym) {

        int countHorizontal = 0;
        int countVertical = 0;
        int coutSmallTopCrossLine = 0;
        int coutSmallBottomCrossLine = 0;
        int coutSmallBottomAnotherCrossLine = 0;
        int coutSmallTopAnotherCrossLine = 0;

        for (int i = 0; i < SIZELINE; i++) {
            for (int j = 0; j < SIZELINE; j++) {

                //Победа по горизонтали
                if (field[i][j] == sym) {
                    countHorizontal++;
                    if (countHorizontal == WINCOUNT) {
                        return true;
                    }
                }

                //Победа по вертикали
                if (field[j][i] == sym) {
                    countVertical++;
                    if (countVertical == WINCOUNT) {
                        return true;
                    }
                }
            }
        }

            // Победа правого верхненго угла
            for (int i = 0; i < SIZELINE; i++) {
                for (int j = 0; j < SIZELINE; j++) {
                    int k = j + i;
                    if (k < SIZELINE) {
                        if (field[i][k] == sym) {
                            coutSmallTopCrossLine++;
                            if (coutSmallTopCrossLine == WINCOUNT) {
                                return true;
                            }
                        }
                    }
                }
            }

            // Победа левого нижнего угла
            for (int i = 1; i < SIZELINE; i++) {
                for (int j = 0; j < SIZELINE; j++) {
                    int k = j + i;
                    if (k < SIZELINE) {
                        if (field[k][i] == sym) {
                            coutSmallBottomCrossLine++;
                            if (coutSmallBottomCrossLine == WINCOUNT) {
                                return true;
                            }
                        }
                    }
                }
            }

            // Победа правого нижнего угла
            for (int i = 0; i < SIZELINE; i++) {
                for (int j = 0; j < SIZELINE; j++) {
                    int k = (SIZELINE - 1) - j;
                    int l = i + j;
                    if (k >= 0 && l < SIZELINE) {
                        if (field[l][k] == sym) {
                            coutSmallBottomAnotherCrossLine++;
                            if (coutSmallBottomAnotherCrossLine == WINCOUNT) {
                                return true;
                            }
                        }
                    }
                }
            }

            // Победа левого верхнего угла
            for (int i = 1; i < SIZELINE; i++) {
                for (int j = 0; j < SIZELINE; j++) {
                    int k = (SIZELINE - 1) - i - j;
                    if (k >= 0) {
                        if (field[j][k] == sym) {
                            coutSmallTopAnotherCrossLine++;
                            if (coutSmallTopAnotherCrossLine == WINCOUNT) {
                                return true;
                            }
                        }
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
