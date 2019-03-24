package io.github.jhoneagle.algorithm.chess;

public class Chess {
    private Player white;
    private Player black;
    private State board;
    private boolean whiteTurn;

    public Chess(Player white, Player black) {
        this(white, black, new State());
    }

    public Chess(Player white, Player black, State board) {
        this.white = white;
        this.black = black;
        this.board = board;
        this.whiteTurn = true;
    }

    public void chancePlayerSides() {
        Player temp = this.white;
        this.white = this.black;
        this.black = temp;
    }

    public String run() {
        board.setStartingPosition();

        this.white.setColor(0);
        this.black.setColor(1);

        while(board.getWinner() == 0) {
            if (this.whiteTurn) {
                this.board = this.white.makeAMove(this.board);
            } else {
                this.board = this.black.makeAMove(this.board);
            }

            this.whiteTurn = !this.whiteTurn;
        }

        if (board.getWinner() < 0) {
            return "Black is the winner!";
        } else {
            return "White is the winner!";
        }
    }
}
