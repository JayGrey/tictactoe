package com.hexlet.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {

        Board board = new Board();
        Player player1 = new Player("Bill", Board.ELEMENT_X);
        Player player2 = new Player("Alice", Board.ELEMENT_O);
        Player currentPlayer = player1;
        int[] currentMove;

        System.out.println("Game start");

        while (true) {

            System.out.print("Player " + currentPlayer.getName() + " move ");
            do {
                currentMove = currentPlayer.move();
            } while (!board.setElement(currentMove[0], currentMove[1], currentPlayer.getElement()));
            System.out.println("(" + (currentMove[0] + 1) + ", " + (currentMove[1] + 1) + ")");

            if (board.checkWinCondition(currentPlayer)) {
                System.out.println("Player " + currentPlayer.getName() + " WIN !");
                break;
            }

            if (board.checkDrawCondition()) {
                System.out.println("DRAW");
                break;
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;

        }

        System.out.println("Game end");

    }
}
