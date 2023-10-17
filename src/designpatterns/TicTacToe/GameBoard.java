package designpatterns.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private PlayingPiece[][] board;
    private int size;

     class Pair {
        private int row;
        private int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public GameBoard(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(board[row][column] != null) {
            System.out.println("Position already occupied!");
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCells = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    freeCells.add(new Pair(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + " ");
                } else {
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
