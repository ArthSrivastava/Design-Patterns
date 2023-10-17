package designpatterns.TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> players;
    private GameBoard gameBoard;

    public void initializeGame() {
        players = new ArrayDeque<>();
        PlayingPiece cross = new PlayingPieceX();
        Player p1 = new Player("P1", cross);

        PlayingPiece circle = new PlayingPieceO();
        Player p2 = new Player("P2", circle);

        players.add(p1);
        players.add(p2);

        gameBoard = new GameBoard(3);
    }

    public String startGame() {
        boolean noWinner = true;
        Scanner sc = new Scanner(System.in);
        while(noWinner) {
            Player currTurn = players.pollFirst();
            gameBoard.printBoard();
            List<GameBoard.Pair> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }
            System.out.println("Player " + currTurn.getName() + ", please enter row and column:");
            String line = sc.nextLine();
            String[] inputs = line.split(",");
            int row = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);
            boolean validPos = gameBoard.addPiece(row, col, currTurn.getPlayingPiece());
            if(!validPos) {
                System.out.println("Incorrect postion chosen, please try again");
                players.offerFirst(currTurn);
                continue;
            }
            players.offer(currTurn);
            boolean winner = checkWinner(row, col, currTurn.getPlayingPiece().getPieceType());
            if(winner) {
                gameBoard.printBoard();
                return "Congratulations " + currTurn.getName() + ". You have won the game!";
            }
        }
        return "Game Tied!";
    }

    private boolean checkWinner(int row, int col, PieceType pieceType) {
        boolean isRow = true;
        boolean isCol = true;
        boolean isD1 = true;
        boolean isD2 = true;

        PlayingPiece[][] board = gameBoard.getBoard();

        //Row
        for(int j = 0; j < gameBoard.getSize(); j++) {
            if(board[row][j] == null || board[row][j].getPieceType() != pieceType) {
               isRow = false;
               break;
            }
        }

        //Col
        for(int i = 0; i < gameBoard.getSize(); i++) {
            if(board[i][col] == null || board[i][col].getPieceType() != pieceType) {
                isCol = false;
                break;
            }
        }

        //D1
        for(int i = 0, j = 0; i < gameBoard.getSize(); i++, j++) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                isD1 = false;
                break;
            }
        }

        for(int i = 0, j = gameBoard.getSize() - 1; i < gameBoard.getSize(); i++, j--) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                isD2 = false;
                break;
            }
        }

        return isRow || isCol || isD1 || isD2;
    }
}
