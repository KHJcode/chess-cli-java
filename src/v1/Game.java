package v1;

import v1.piece.Piece;
import v1.player.Player;

public class Game {
    private int count = 0;
    private final Player whitePlayer, blackPlayer;
    private final Board board;
    private final Renderer renderer;

    Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = new Board();
        this.renderer = new Renderer();
    }

    public int put(int nowX, int nowY, int moveX, int moveY) {
        Piece piece = board.getPiece(nowX, nowY);
        Piece targetPiece = board.getPiece(moveX, moveY);
        int targetStatus = piece.getTeamId() == targetPiece.getTeamId() ? 0 : 1;
        boolean canMove = targetPiece.getCanMove(nowX, nowY, moveX, moveY, targetStatus);
        if (canMove) {
            board.movePiece(nowX, nowY, moveX, moveY);
            count += 1;
            renderer.draw(this.board);
            return 0;
        }
        return -1;
    }
}
