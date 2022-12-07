package v1.piece;

import v1.Board;

import static v1.Common.jul;
import static v1.Common.pieceTeams;

public class Knight extends Piece {
    public Knight(int teamId) {
        super(teamId, PieceId.KNIGHT.get(), pieceTeams.get(teamId).getKnight());
    }

    @Override
    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 1)
            return false;
        else
            return (jul(moveX - nowX) == 2 && jul(moveY - nowY) == 1) || (jul(moveX - nowX) == 1 && jul(moveY - nowY) == 2);
    }
}
