package io.github.jhoneagle.algorithm.chess;

public class SimpleEvaluator extends Evaluator {

    /**
     * function prefers:
     * not to lose (white king is worth at lot)
     * to win (black not having a king is worth a lot)
     * to have more white pieces (+1) and less black pieces (-1)
      */
    @Override
    public double eval(State p) {
        int[][] board = p.getBoard();
        
        double ret = 0;
        for(int x = 0; x < board.length; ++x) {
            for(int y = 0; y < board[x].length; ++y) {
                if(board[x][y] == State.Empty) continue;
                if(board[x][y] == State.WKing) ret += 1e9;
                if(board[x][y] == State.WQueen) ret += 1;
                if(board[x][y] == State.WRook) ret += 1;
                if(board[x][y] == State.WBishop) ret += 1;
                if(board[x][y] == State.WKnight) ret += 1;
                if(board[x][y] == State.WPawn) ret += 1;
                if(board[x][y] == State.BKing) ret -= 1e9;
                if(board[x][y] == State.BQueen) ret -= 1;
                if(board[x][y] == State.BRook) ret -= 1;
                if(board[x][y] == State.BBishop) ret -= 1;
                if(board[x][y] == State.BKnight) ret -= 1;
                if(board[x][y] == State.BPawn) ret -= 1;
            }
        }
        return ret;
    }
}
