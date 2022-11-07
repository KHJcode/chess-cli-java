package Piece;

public abstract class Piece {
    private final char mark;
    private final boolean white;

    public Piece(char mark, boolean white){
        this.mark = mark;
        this.white = white;
    }

    public char getMark(){
        return this.mark;
    }

    public boolean isWhite(){
        return this.white;
    }

    public abstract boolean isValidMove(int oldRow, int oldCol, int newRow, int newCol);
}