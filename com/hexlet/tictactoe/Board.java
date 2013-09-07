package com.hexlet.tictactoe;

public class Board {

    public static final int ELEMENT_EMPTY = 0;    // пустое поле
    public static final int ELEMENT_X = 1;    // фигура крестик
    public static final int ELEMENT_O = 2;    // фигура нолик

    private int[][] field;

    private Player[] players;
    private Player currentPlayer;

    public Board(Player player1, Player player2) {
        field = new int[3][3];
        clearBoard();

        if (player1 == null || player2 == null) {
            System.out.println("Error");
            return;
        }

        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        currentPlayer = players[0];
    }

    /**
     * очищает игральную доску заполняя все поля значением ELEMENT_EMPTY
     */
    void clearBoard() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ELEMENT_EMPTY;
            }
        }
    }

    /**
     * Устанавливает значение крестик или нолик  для поля (x,y)
     * x - номер поля по горизонтали (0 .. 2)
     * y - номер поля по вертикали   (0 .. 2)
     * element - одна из возможных фигур (ELEMENT_X, ELEMENT_O)
     * <p/>
     * В случае удачного исполнения возвращает true, иначе false
     */
    public boolean setElement(int x, int y, int element) {
        // Проверяем диапазоны x и y:
        if ((x < 0 || x > 2) || (y < 0 || y > 2)) {
            return false;
        }

        // проверяем element
        if (element != ELEMENT_X && element != ELEMENT_O) {
            return false;
        }

        // Проверяем поле в которое будем записывать фигуру. Оно должно быть пустым.
        if (field[x][y] != ELEMENT_EMPTY) {
            return false;
        }

        field[x][y] = element;

        return true;
    }

    /**
     * Получает значение крестик или нолик  для поля (x,y)
     * x - номер поля по горизонтали (1 .. 3)
     * y - номер поля по вертикали   (1 .. 3)
     * <p/>
     * Возвращает значения ELEMENT_EMPTY ELEMENT_X или ELEMENT_O для поля (x, y). В случае ошибки -1.
     */
    public int getElement(int x, int y) {
        if ((x < 0 || x > 2) || (y < 0 || y > 2)) {
            return -1;
        }

        return field[x][y];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    /**
     * Проверяем соблюдены ли условия выиграша для текущего пользователе,
     * если да возвращает true иначе false
     */
    public boolean checkWinCondition() {

        // проверяем строки
        for (int i = 0; i < field.length; i++) {
            if (getElement(i, 0) == currentPlayer.getElement() &&
                    getElement(i, 1) == currentPlayer.getElement() &&
                    getElement(i, 2) == currentPlayer.getElement()) {
                return true;
            }
        }

        // проверяем столбцы
        for (int i = 0; i < field.length; i++) {
            if (getElement(0, i) == currentPlayer.getElement() &&
                    getElement(1, i) == currentPlayer.getElement() &&
                    getElement(2, i) == currentPlayer.getElement()) {
                return true;
            }
        }

        // проверяем диагонали
        if (getElement(0, 0) == currentPlayer.getElement() &&
                getElement(1, 1) == currentPlayer.getElement() &&
                getElement(2, 2) == currentPlayer.getElement()) {
            return true;
        }

        if (getElement(0, 2) == currentPlayer.getElement() &&
                getElement(1, 1) == currentPlayer.getElement() &&
                getElement(2, 0) == currentPlayer.getElement()) {
            return true;
        }

        return false;
    }

    /**
     * Проверяем соблюдены ли условия ничьи, если да возвращает true иначе
     * false
     */
    public boolean checkDrawCondition() {
        //Если все клетки поля уже заполнены значит ничья

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (getElement(i, j) == ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void nextMove() {
        int[] playerMove;
        do {
            playerMove = currentPlayer.move();
        } while (!setElement(playerMove[0], playerMove[1], currentPlayer.getElement()));

        // Меняем местами игроков
        currentPlayer = currentPlayer == players[0] ? players[1] : players[0];
    }

}