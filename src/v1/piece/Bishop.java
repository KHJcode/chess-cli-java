package v1.piece;

import static v1.Common.pieceTeams;

public class Bishop extends Piece {
    public Bishop(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getBishop();
    }

    @Override
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 2) {
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
