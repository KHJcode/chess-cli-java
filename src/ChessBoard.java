public final class ChessBoard {
    private int board[][];
    private final int ROWS;
    private final int COLS;
    public ChessBoard() {
        ROWS = 8;
        COLS = 8;
    }
    public boolean isInRange(int r, int c){
        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }


}