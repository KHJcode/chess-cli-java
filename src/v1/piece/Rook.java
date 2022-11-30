package v1.piece;

import static v1.Common.pieceTeams;

public class Rook extends Piece {
    public Rook(int id, int teamId) {
        super(id, teamId);
        super.mark = pieceTeams.get(teamId).getRook();
    }
    //(0: 빈 칸, 1: 우리 칸, 2: 상대 칸)
    public int jul(int n) {
        return n < 0 ? n * -1 : n;
    }

    @Override
    public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus, Piece[][] deployment) {
        if (targetStatus==1)
            return false;
        else {
            return (jul(nowX - moveX) > 0 && nowY == moveY)||(jul(nowY - moveY) > 0 && nowX == moveX);
        }
    }
}
