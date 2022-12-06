package v1.piece;

import v1.Common;
import v1.Board;

import static v1.Common.pieceTeams;

public class Pawn extends Piece {
    private boolean isFirst = true;
    private boolean isAngphasang = false;

    public Pawn(int teamId) {
        super(teamId, PieceId.PAWN.get(), pieceTeams.get(teamId).getPawn());
    }

    public boolean getIsAngphasang() {
        return this.isAngphasang;
    }

    public void setIsFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    private int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (Common.BLACK_ID == this.getTeamId()) {
            if (isFirst) {
                if (moveY - nowY == 2 && moveX == nowX) return true;
                this.isAngphasang = true;
            } else
                this.isAngphasang = false;
            if (moveY - nowY == 2 && moveX == nowX) return false;
            if (jul(moveX - nowX) == 1 && moveY - nowY == 1) {
                if (targetStatus == 2)
                    return true;
                else {
                    Piece piece = board.getPiece(moveX, nowY);

                    if (piece.getTeamId() == PieceId.PAWN.get()) {
                        return this.getIsAngphasang();
                    }
                    return false;
                }
            }
        } else {
            if (isFirst) {
                if (nowY - moveY == 2 && moveX == nowX) return true;
                this.isAngphasang = true;
            } else
                this.isAngphasang = false;
            if (nowY - moveY == 2 && moveX == nowX) return false;
            if (jul(moveX - nowX) == 1 && nowY - moveY == 1) {
                if (targetStatus == 2)
                    return true;
                else {
                    Piece piece = board.getPiece(moveX, nowY);
                    if (piece.getTeamId() == PieceId.PAWN.get()) {
                        return this.getIsAngphasang();
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
