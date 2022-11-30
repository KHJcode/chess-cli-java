package v1.piece;

import v1.Common;
import v1.Board;

import static v1.Common.pieceTeams;

public class Pawn extends Piece {
    private boolean isFirst = true;

    public Pawn(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getPawn();
    }

    private int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (Common.BLACK_ID == this.getTeamId()) {
            if (this.isFirst) {
                isFirst = false;
                if (board.getPiece(nowX, nowY + 1) != null)
                    return false;
                return (0 < jul(moveY - nowY) && jul(moveY - nowY) <= 2) && moveX == nowX;
            } else {
                if (targetStatus == 2) {
                    return jul(moveX - nowX) == 1 && jul(moveY - nowY) == 1;
                } else
                    return jul(moveY - nowY) == 1 && moveX == nowX;
            }
        } else {
            if (this.isFirst) {
                this.isFirst = false;
                if (board.getPiece(nowX, nowY - 1) != null)
                    return false;
                return (0 < jul(moveY - nowY) && jul(moveY - nowY) <= 2) && moveX == nowX;
            } else {

                if (targetStatus == 2) {
                    return jul(moveX - nowX) == 1 && jul(moveY - nowY) == 1;
                } else
                    return jul(moveY - nowY) == 1 && moveX == nowX;
            }
        }
    }
}
