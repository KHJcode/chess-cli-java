package v1.piece;

import v1.Board;

import static v1.Common.pieceTeams;

public class King extends Piece {
    public King(int teamId) {
        super(teamId, PieceId.KING.get(), pieceTeams.get(teamId).getKing());
    }

    public boolean getCanMove(Board board, int nowX, int nowY, int moveX, int moveY, int targetStatus) {
        if (targetStatus == 1) {
            return false;
        } else {
            if (nowX < moveX && nowY < moveY) {
                int i = nowX + 1;
                int j = nowY + 1;
                while (i < moveX && j < moveY) {
                    if (board.getPiece(i, j) != null)
                        return false;
                    i++;
                    j++;
                }
                return true;
            } else if (nowX < moveX && nowY > moveY) {
                int i = nowX + 1;
                int j = nowY - 1;
                while (i < moveX && j > moveY) {
                    if (board.getPiece(i, j) != null)
                        return false;
                    i++;
                    j--;
                }
                return true;
            } else if (nowX > moveX && nowY < moveY) {
                int i = nowX - 1;
                int j = nowY + 1;
                while (i > moveX && j < moveY) {

                    if (board.getPiece(i, j) != null)
                        return false;
                    i--;
                    j++;
                }
                return true;
            } else if (nowX > moveX && nowY > moveY) {

                int i = nowX - 1;
                int j = nowY - 1;
                while (i > moveX && j > moveY) {

                    if (board.getPiece(i, j) != null)
                        return false;
                    i--;
                    j--;
                }
                return true;
            } else if (nowX != moveX) {
                if (nowX < moveX) {
                    for (int i = nowX + 1; i < moveX; i++) {
                        if (board.getPiece(i, moveY) != null)
                            return false;

                    }
                } else {
                    for (int i = moveX + 1; i < nowX; i++) {
                        if (board.getPiece(i, moveY) != null)
                            return false;

                    }
                }
            } else {
                if (nowY < moveY) {
                    for (int i = nowY + 1; i < moveY; i++) {
                        if (board.getPiece(moveX, i) != null)
                            return false;

                    }
                } else {
                    for (int i = moveY + 1; i < nowY; i++) {
                        if (board.getPiece(moveX, i) != null)
                            return false;

                    }
                }
            }

        }
        return true;
    }
}
