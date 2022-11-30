package v1.piece;

import static v1.Common.pieceTeams;

public class Knight extends Piece {
    public Knight(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getKnight();
    }

    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 2)
            return false;
        if ((jul(moveX - nowX) == 2 && jul(moveY - nowY) == 1) || (jul(moveX - nowX) == 1 && jul(moveY - nowY) == 2))
            return true;
    }
}
