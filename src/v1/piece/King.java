package v1.piece;

import static v1.Common.pieceTeams;

public class King extends Piece {
    public King(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getKing();
    }

    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 2) {
            return false;
        } else {
            if (nowX < moveX && nowY < moveY) {
                return moveX - nowX == moveY - nowY;
            } else if (nowX < moveX && nowY > moveY) {
                return moveX - nowX == nowY - moveY;
            } else if (nowX > moveX == nowY < moveY) {
                return nowX - moveX == moveY - nowY;
            } else if (nowX > moveX && nowY > moveY) {
                return nowX - moveX == nowY - moveY;
            } else {
                return jul(nowX - moveX) > 0 && nowY == moveY;
            }
        }
    }
}
