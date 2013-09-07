package com.hexlet.tictactoe;

import java.util.Random;

public class Player {

    private String name;
    private int element;

    private java.util.Random generator;

    public Player(String name, int element) {
        this.name = name;
        generator = new Random();

        if (element != Board.ELEMENT_X && element != Board.ELEMENT_O) {
            this.element = -1;
            return;
        }

        this.element = element;
    }

    public String getName() {
        return name;
    }

    public int getElement() {
        return element;
    }

    public int[] move() {
        // Ожидаем ввода от пользователя
        int x = generator.nextInt(3);
        int y = generator.nextInt(3);
        return new int[]{x, y};
    }
}
