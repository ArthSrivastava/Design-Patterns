package designpatterns.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initializeGame();
        System.out.println(ticTacToeGame.startGame());
    }
}
