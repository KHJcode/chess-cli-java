package v1.piece;

import v1.Board;

import static v1.Common.jul;
import static v1.Common.pieceTeams;

public class King extends Piece {
    public King(int teamId) {
        super(teamId, PieceId.KING.get(), pieceTeams.get(teamId).getKing());
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
