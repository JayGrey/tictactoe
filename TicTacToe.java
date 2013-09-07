public class TicTacToe{
    public static void main(String [] args){

        Board board = new Board(new Player("Bill", Board.ELEMENT_X), new Player("Alice", Board.ELEMENT_O));
        
        System.out.println("Game start");

        while(true){

            board.nextMove();

            if ( board.checkWinCondition() ){
                // currentPlayer win
                System.out.println("Player " + board.getCurrentPlayer().getName() + " WIN!");
                break;
            }

            if ( board.checkDrawCondition() ){
                // currentPlayer win
                System.out.println("DRAW");
                break;
            }
        }

        System.out.println("Game end");

    }
}