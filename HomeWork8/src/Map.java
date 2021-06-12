import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    public static final int EMPTY = 0;
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;



    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLen;
    int mode;
    int cellHeight;
    int cellWidth;
    int cellX;
    int cellY;

    boolean isInitialized = false;


    public Map() {
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    void update(MouseEvent e) {
        cellX = e.getX() / cellWidth;
        cellY = e.getY() / cellHeight;
        System.out.println("x: " + cellX + " y: " + cellY);
        if (mode == MODE_H_V_A) {
            checkingWinner();
        }
        repaint();
    }

    //Ход игрока
    public void playerTurn() {
        int x;
        int y;
        do {
            x = cellX;
            y = cellY;
        } while (!checkTurns(y, x));
        enterSymbols(x, y, PLAYER_1);
        System.out.println(PLAYER_1 + " сhose cordinate " + x + " " + y);
    }


    void checkingWinner() {
        playerTurn();
        if (checkWin(PLAYER_1)) {
            System.out.println("You win!");
        } else if (fullField());
            botTurn();
            if (checkWin(PLAYER_2)) {
                System.out.println("Bot win!");
            } else if (fullField());


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
        cross(g);
        circle(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLength;
        field = new int[fieldSizeY][fieldSizeX];
        this.mode = mode;
        isInitialized = true;

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY;
            }
        }
        repaint();
    }

    void render(Graphics g) {
        if (!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x,0,x,panelHeight);
        }
    }


    //рисуем крестики
    void cross(Graphics g) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == PLAYER_1) {
                    g.setColor(Color.BLUE);
                    g.drawLine((i * cellWidth) + 10, (j * cellHeight) + 10, (i + 1) * cellWidth - 10, (j + 1) * cellHeight - 10);
                    g.drawLine((i + 1) * cellWidth - 10, (j * cellHeight) + 10, (i * cellWidth) + 10, (j + 1) * cellHeight - 10);
                }
            }
        }
    }

    //рисуем нолики
    void circle(Graphics g) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == PLAYER_2) {
                    g.setColor(Color.RED);
                    g.drawOval((i * cellWidth) + 10, (j * cellHeight) + 10, cellWidth - 20, cellHeight - 20);
                }
            }
        }
    }

    //Проверка поля на заполнения
    private boolean fullField() {
        for (int i=0; i<fieldSizeY; i++) {
            for (int j=0; j<fieldSizeX; j++) {
                if (field[i][j] == EMPTY) return false;
            }
        }
        System.out.println("Draw!");
        return true;
    }


    // Проверяем возможность хода
    boolean checkTurns(int y, int x) {
        if (x<0 || x >=fieldSizeX || y<0 || y>=fieldSizeY) return false;
        else if (!(field[y][x]==EMPTY)) return false;

        return true;
    }

    //Выбираем клетку
    void enterSymbols(int y, int x, int player) {
        field[y][x] = player;
    }


    // Создаем генератор заполнителя для бота
    static Random rd = new Random();

    // Ход машины
    private void botTurn () {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v<fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h+winLen<=fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, PLAYER_1) == winLen - 1) {
                        if (MoveAiLineHorisont(v, h, PLAYER_2)) return;
                    }

                    if (v - winLen > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, PLAYER_1) == winLen - 1) {
                            if (MoveAiDiaUp(v, h, PLAYER_2)) return;
                        }
                    }
                    if (v + winLen <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, PLAYER_1) == winLen - 1) {
                            if (MoveAiDiaDown(v, h, PLAYER_2)) return;
                        }
                    }
                }
                if (v+winLen<=fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v,h,PLAYER_1) ==winLen-1) {
                        if(MoveAiLineVertical(v,h,PLAYER_2)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v<fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h+winLen<=fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v,h,PLAYER_2) == winLen-1) {
                        if (MoveAiLineHorisont(v,h,PLAYER_2)) return;
                    }

                    if (v-winLen>-2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, PLAYER_2) == winLen-1) {
                            if (MoveAiDiaUp(v,h,PLAYER_2)) return;
                        }
                    }
                    if (v+winLen<=fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, PLAYER_2) == winLen-1) {
                            if (MoveAiDiaDown(v,h,PLAYER_2)) return;
                        }
                    }

                }
                if (v+winLen<=fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v,h,PLAYER_2) ==winLen-1) {
                        if(MoveAiLineVertical(v,h,PLAYER_2)) return;
                    }
                }
            }
        }

        //случайный ход
        do {
            y = rd.nextInt(fieldSizeY);
            x = rd.nextInt(fieldSizeX);
        } while (!checkMove(y,x));
        enterSymbols(x, y, PLAYER_2);
        System.out.println(PLAYER_2 + " chose x: " + x + " Y: " + y);
    }

    //ход компьютера по горизонтале
    private boolean MoveAiLineHorisont(int v, int h, int player) {
        for (int j = h; j < winLen; j++) {
            if ((field[v][j] == EMPTY)) {
                field[v][j] = player;
                return true;
            }
        }
        return false;
    }
    //ход компьютера по вертикале
    private boolean MoveAiLineVertical(int v, int h, int player) {
        for (int i = v; i<winLen; i++) {
            if ((field[i][h] == EMPTY)) {
                field[i][h] = player;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вверх

    private boolean MoveAiDiaUp(int v, int h, int player) {
        for (int i = 0, j = 0; j < winLen; i--, j++) {
            if ((field[v+i][h+j] == EMPTY)) {
                field[v+i][h+j] = player;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вниз

    private boolean MoveAiDiaDown(int v, int h, int player) {

        for (int i = 0; i < winLen; i++) {
            if ((field[i+v][i+h] == EMPTY)) {
                field[i+v][i+h] = player;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения выбранного для хода игроком
    private boolean checkMove(int y, int x) {
        if (x<0 || x >=fieldSizeX || y<0 || y>=fieldSizeY) return false;
        else if (!(field[y][x]==EMPTY)) return false;

        return true;
    }

    //проверка победы
    private boolean checkWin(int player) {
        for (int v = 0; v<fieldSizeY; v++){
            for (int h= 0; h<fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h + winLen <= fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, player) >= winLen) return true;

                    if (v - winLen > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, player) >= winLen) return true;
                    }
                    if (v + winLen <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, player) >= winLen) return true;
                    }
                }
                if (v + winLen <= fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v, h, player) >= winLen) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонале вверх

    private int checkDiaUp(int v, int h, int player) {
        int count=0;
        for (int i = 0, j = 0; j < winLen; i--, j++) {
            if ((field[v+i][h+j] == player)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по диагонале вниз

    private int checkDiaDown(int v, int h, int player) {
        int count=0;
        for (int i = 0; i < winLen; i++) {
            if ((field[i+v][i+h] == player)) count++;
        }
        return count;
    }

    private int checkLineHorisont(int v, int h, int player) {
        int count=0;
        for (int j = h; j < winLen + h; j++) {
            if ((field[v][j] == player)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по вертикале
    private int checkLineVertical(int v, int h, int player) {
        int count=0;
        for (int i = v; i< winLen + v; i++) {
            if ((field[i][h] == player)) count++;
        }
        return count;
    }


}
