package v1.piece;

import v1.Board;

import static v1.Common.pieceTeams;

public class Queen extends Piece {
    public Queen(int id, int team) {
        super(id, team);
        super.mark = pieceTeams.get(team).getQueen();
    }

    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 1) {
            return false;
        } else {
            return jul(nowX - moveX) >= 0 && jul(nowY - moveY) > 0 && !((nowY - moveY) == 0 && (nowX - moveX) == (0));
        }
    }
}
