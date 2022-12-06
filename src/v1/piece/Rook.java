package v1.piece;

import v1.Board;

import static v1.Common.pieceTeams;

public class Rook extends Piece {
    public Rook(int teamId) {
        super(teamId, PieceId.ROOK.get(), pieceTeams.get(teamId).getRook());
    }

    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 1)
            return false;
        else {
            if (nowX != moveX && nowY == moveY) {
                if (nowX < moveX) {
                    for (int i = nowX + 1; i < moveX; i++) {
                        if (board.getPiece(i, moveY) != null)
                            return false;

                    }
                } else {
                    for (int i = moveX + 1; i < nowX; i++) {
                        if (board.getPiece(i, moveY) != null)
                            return false;

                    }
                }
            } else {
                if (nowY < moveY) {
                    for (int i = nowY + 1; i < moveY; i++) {
                        if (board.getPiece(moveX, i) != null)
                            return false;

                    }
                } else {
                    for (int i = moveY + 1; i < nowY; i++) {
                        if (board.getPiece(moveX, i) != null)
                            return false;

                    }
                }
            }
            return (jul(nowX - moveX) > 0 && nowY == moveY) || (jul(nowY - moveY) > 0 && nowX == moveX);
        }
    }
}
