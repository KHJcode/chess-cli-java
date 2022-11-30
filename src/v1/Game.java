package v1;

import v1.piece.Piece;

public class Game {
    private int count = 0;
    private final Board board;
    private final Renderer renderer;

    Game() {
        this.board = new Board();
        this.renderer = new Renderer();
        this.handleUpdateBoard();
    }

    public void handleUpdateBoard() {
        this.renderer.draw(this.board);
    }

    public boolean put(int nowX, int nowY, int moveX, int moveY) {
        Piece piece = board.getPiece(nowX, nowY);
        Piece targetPiece = board.getPiece(moveX, moveY);
        boolean targetStatus = piece.getTeamId() != targetPiece.getTeamId();
        boolean canMove = targetPiece.getCanMove(nowX, nowY, moveX, moveY, targetStatus);
        if (canMove) {
            board.movePiece(nowX, nowY, moveX, moveY);
            count += 1;
            this.handleUpdateBoard();
            return true;
        }
        return false;
    }
}
