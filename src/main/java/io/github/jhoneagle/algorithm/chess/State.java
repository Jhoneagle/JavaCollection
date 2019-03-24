package io.github.jhoneagle.algorithm.chess;

import java.util.Vector;

public class State {
    private int[][] board;
    public static final int sizeX = 8, sizeY = 8;
    private boolean whiteToMove;
    private double cachedResult;
    private int winner = 0; // white = +1, black = -1

    public static final int Empty = 0;
    public static final int WKing = 1;
    public static final int WQueen = 2;
    public static final int WRook = 3;
    public static final int WBishop = 4;
    public static final int WKnight = 5;
    public static final int WPawn = 6;
    public static final int BKing = 7;
    public static final int BQueen = 8;
    public static final int BRook = 9;
    public static final int BBishop = 10;
    public static final int BKnight = 11;
    public static final int BPawn = 12;
    
    public static final int KnightX [] = {-2,-2,-1,-1,1,1,2,2};
    public static final int KnightY [] = {1,-1,2,-2,2,-2,1,-1};
    public static final int BishopX [][] = {{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{-1,-2,-3,-4,-5,-6,-7}};
    public static final int BishopY [][] = {{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7}};
    public static final int RookX [][] = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7}};
    public static final int RookY [][] = {{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
    public static final int KingX [] = {1,1,1,0,0,-1,-1,-1};
    public static final int KingY [] = {1,0,-1,1,-1,1,0,-1};
    public static final int QueenX [][] = {{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{-1,-2,-3,-4,-5,-6,-7}, {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7}};
    public static final int QueenY [][] = {{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7}, {1,2,3,4,5,6,7},{-1,-2,-3,-4,-5,-6,-7},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};

    public State() {
        this.board = new int[sizeY][sizeX];
        this.whiteToMove = true;
        this.cachedResult = Double.NaN;
    }

    public void setStartingPosition() {
        for(int x = 0; x < sizeY; x++) {
            this.board[x][1] = WPawn;
            this.board[x][sizeX - 2] = BPawn;
            if(x == 0 || x == (sizeY - 1)) {
                this.board[x][0] = WRook;
                this.board[x][sizeX - 1] = BRook;
            } else if(x == 1 || x == (sizeY - 2)) {
                this.board[x][0] = WKnight;
                this.board[x][sizeX - 1] = BKnight;
            } else if(sizeY == 8 && (x == 2 || (x == sizeY - 3))) {
                this.board[x][0] = WBishop;
                this.board[x][sizeX - 1] = BBishop;
            } else if((sizeY == 8 && x == 3) || (sizeY == 6 && x == 2)) {
                this.board[x][0] = WQueen;
                this.board[x][sizeX - 1] = BQueen;
            } else if(x == (sizeY / 2)) {
                this.board[x][0] = WKing;
                this.board[x][sizeX - 1] = BKing;
            }
        }
    }

    public double getCachedResult() {
        return cachedResult;
    }

    public void setCachedResult(double cachedResult) {
        this.cachedResult = cachedResult;
    }

    public int getWinner() {
        return winner;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public char[][] printBoard() {
        char[][] printed = new char[sizeY][sizeX];
        for(int y = sizeX - 1; y >= 0; y--) {
            for(int x = 0; x < sizeY; x++) {
                int v = this.board[x][y];
                if(v == Empty) printed[x][y] = '.';
                if(v == WKing) printed[x][y] = 'k';
                if(v == WQueen) printed[x][y] = 'q';
                if(v == WRook) printed[x][y] = 'r';
                if(v == WBishop) printed[x][y] = 'b';
                if(v == WKnight) printed[x][y] = 'n';
                if(v == WPawn) printed[x][y] = 'p';
                if(v == BKing) printed[x][y] = 'K';
                if(v == BQueen) printed[x][y] = 'Q';
                if(v == BRook) printed[x][y] = 'R';
                if(v == BBishop) printed[x][y] = 'B';
                if(v == BKnight) printed[x][y] = 'N';
                if(v == BPawn) printed[x][y] = 'P';
            }
            System.out.println();
        }
        return printed;
    }

    public static boolean isWhitePiece(int pval) {
        if(pval == 0) return false;
        if(pval < 7) return true;

        return false;
    }

    public static boolean isBlackPiece(int pval) {
        if(pval == 0) return false;
        if(pval > 6) return true;

        return false;
    }

    public static boolean isInsideBoard(int x, int y) {
        if(x < 0 || x >= sizeY) return false;
        if(y < 0 || y >= sizeX) return false;

        return true;
    }

    public boolean squaresContainSameColoredPieces(int x, int y, int x2, int y2) {
        if(isWhitePiece(this.board[x][y]) && isWhitePiece(this.board[x2][y2])) return true;
        if(isBlackPiece(this.board[x][y]) && isBlackPiece(this.board[x2][y2])) return true;

        return false;
    }

    private int checkWin(int x, int y) {
        // this is a piece just about to be captured.
        // if white king, black wins, and vice versa
        if (this.board[x][y] == WKing) return -1;
        if (this.board[x][y] == BKing) return +1;
        return 0;
    }

    public Vector<State> getNextPositions() {
        Vector<State> ret = new Vector<State>();



        return ret;
    }

    public void cloneEssentialsFrom(State p) {
        int[][] board = p.getBoard();

        for(int i = 0; i < this.board.length; ++i) {
            for(int j = 0; j < this.board[i].length; ++j) {
                this.board[i][j] = board[i][j];
            }
        }
        this.whiteToMove = !p.whiteToMove;
    }

    public State mirror() {
        State p = new State();
        for (int i = 0; i < this.board.length; ++i) {
            for (int j = 0; j < this.board[i].length; ++j) {
                int piece = this.board[i][5 - j];
                if (piece != 0)
                    p.board[i][j] = (piece >= 7 ? -6 : 6) + piece;
            }
        }
        p.whiteToMove = !this.whiteToMove;
        return p;
    }
}
