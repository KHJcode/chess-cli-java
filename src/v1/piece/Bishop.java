package v1.piece;

import v1.Board;

import static v1.Common.pieceTeams;

public class Bishop extends Piece {
    public Bishop(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getBishop();
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus==1) {
            return false;
        }
        if (nowX < moveX && nowY < moveY) {
            return moveX - nowX == moveY - nowY;
        } else if (nowX < moveX && nowY > moveY) {
            return moveX - nowX == nowY - moveY;
        } else if (nowX > moveX == nowY < moveY) {
            return nowX - moveX == moveY - nowY;
        } else {
            return nowX - moveX == nowY - moveY;
        }
    }
}
