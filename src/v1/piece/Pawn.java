package v1.piece;

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
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus, Piece[][] deployment) {
        if (this.getTeamId() == 1) {
            if (isFirst) {
                isFirst = false;
                return (0 < moveX - nowX && moveX - nowX <= 2) && moveY == nowY;
            } else {
                if (targetStatus==1) {
                    return jul(moveX - nowX) == 1 && jul(moveY - nowY) == 1;
                } else
                    return ((moveX - nowX == 1) && moveY == nowY);
            }
        } else {
            if (isFirst) {
                isFirst = false;
                return (-2 <= moveX - nowX && moveX - nowX < 0) && moveY == nowY;
            } else {

                if (targetStatus==1) {
                    return jul(moveX - nowX) == 1 && jul(moveY - nowY) == 1;
                }
                else
                    return ((moveX - nowX == -1) && moveY == nowY);
            }
        }
    }
}
