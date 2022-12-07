package v1.piece;

import v1.Common;
import v1.Board;

import static v1.Common.pieceTeams;

public class Pawn extends Piece {
    private boolean isFirst = true;
    private int isAngphasang = 0;

    public Pawn(int teamId) {
        super(teamId, PieceId.PAWN.get(), pieceTeams.get(teamId).getPawn());
    }

    public int getIsAngphasang() {
        return this.isAngphasang;
    }

    public void setIsFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    private int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    private void setNull(Board board, int x, int y) {
        board.setPiece(x, y, null);
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (Common.BLACK_ID == this.getTeamId()) {
            if (isFirst) {//7 4  6 5
                if (moveY - nowY == 2 && moveX == nowX) return true;
                this.isAngphasang = 2;
            } else
                this.isAngphasang = this.isAngphasang - 1;
            if (moveY - nowY == 2 && moveX == nowX) return false;
            if (moveY - nowY == 1 && moveX == nowX) return true;
            if (jul(moveX - nowX) == 1 && moveY - nowY == 1) {
                if (targetStatus == 2)
                    return true;
                else {
                    Piece piece = board.getPiece(moveX, nowY);

                    if (piece.getTeamId() != PieceId.PAWN.get()) {

                        this.setNull(board, moveX, nowY);
                        return true;

                    }
                    return false;
                }
            }
        } else {
            if (isFirst) {
                if (nowY - moveY == 2 && moveX == nowX) return true;
                this.isAngphasang = 2;
            } else
                this.isAngphasang--;
            if (nowY - moveY == 2 && moveX == nowX) return false;
            if (nowY - moveY == 1 && moveX == nowX) return true;
            if (jul(moveX - nowX) == 1 && nowY - moveY == 1) {
                if (targetStatus == 2)
                    return true;
                else {
                    Piece piece = board.getPiece(moveX, nowY);
                    if (piece.getTeamId() != PieceId.PAWN.get()) {
                        this.setNull(board, moveX, nowY);
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
