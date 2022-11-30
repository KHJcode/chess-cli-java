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

    public boolean isEnd() {
        Piece[][] deployment = this.getDeployment();
        for (int i = 0; i < deployment.length; i++) {
            for (int j = 0; j < deployment[i].length; j++) {

            }
        }
        return false;
    }

    public Board getBoard() {
        return this.board;
    }

    public Piece[][] getDeployment() {
        return this.board.getDeployment();
    }

    public void handleUpdateBoard() {
        this.renderer.draw(this.board);
    }

    public boolean put(int nowX, int nowY, int moveX, int moveY) {
        Piece piece = board.getPiece(nowX, nowY);
        if (piece != null) {
            Piece targetPiece = board.getPiece(moveX, moveY);
            int targetStatus = targetPiece == null ? 0 : (piece.getTeamId() == targetPiece.getTeamId() ? 1 : 2);
            boolean canMove = piece.getCanMove(this.board, nowX, nowY, moveX, moveY, targetStatus);
            if (canMove) {
                board.movePiece(nowX, nowY, moveX, moveY);
                count += 1;
                this.handleUpdateBoard();
                return true;
            }
        }
        return false;
    }
}
