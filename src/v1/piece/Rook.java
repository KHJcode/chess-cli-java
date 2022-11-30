package v1.piece;

import static v1.Common.pieceTeams;

public class Rook extends Piece {
    public Rook(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getRook();
    }

    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, boolean targetStatus) {
        if (!targetStatus)
            return false;
        else {
            return jul(nowX - moveX) > 0 && nowY == moveY;
        }
    }
}
