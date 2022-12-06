package v1;

import v1.piece.*;

import static v1.Common.BLACK_ID;
import static v1.Common.WHITE_ID;

public class Board {
    private Piece[][] deployment;

    Board() {
        this.initialize();
    }

    private void initialize() {
        this.deployment = new Piece[8][8];
        setPiece(0, 0, new Rook(BLACK_ID));
        setPiece(1, 0, new Knight(BLACK_ID));
        setPiece(2, 0, new Bishop(BLACK_ID));
        setPiece(3, 0, new King(BLACK_ID));
        setPiece(4, 0, new Queen(BLACK_ID));
        setPiece(5, 0, new Bishop(BLACK_ID));
        setPiece(6, 0, new Knight(BLACK_ID));
        setPiece(7, 0, new Rook(BLACK_ID));
        setPiece(0, 1, new Pawn(BLACK_ID));
        setPiece(1, 1, new Pawn(BLACK_ID));
        setPiece(2, 1, new Pawn(BLACK_ID));
        setPiece(3, 1, new Pawn(BLACK_ID));
        setPiece(4, 1, new Pawn(BLACK_ID));
        setPiece(5, 1, new Pawn(BLACK_ID));
        setPiece(6, 1, new Pawn(BLACK_ID));
        setPiece(7, 1, new Pawn(BLACK_ID));
        setPiece(0, 6, new Pawn(WHITE_ID));
        setPiece(1, 6, new Pawn(WHITE_ID));
        setPiece(2, 6, new Pawn(WHITE_ID));
        setPiece(3, 6, new Pawn(WHITE_ID));
        setPiece(4, 6, new Pawn(WHITE_ID));
        setPiece(5, 6, new Pawn(WHITE_ID));
        setPiece(6, 6, new Pawn(WHITE_ID));
        setPiece(7, 6, new Pawn(WHITE_ID));
        setPiece(0, 7, new Rook(WHITE_ID));
        setPiece(1, 7, new Knight(WHITE_ID));
        setPiece(2, 7, new Bishop(WHITE_ID));
        setPiece(3, 7, new King(WHITE_ID));
        setPiece(4, 7, new Queen(WHITE_ID));
        setPiece(5, 7, new Bishop(WHITE_ID));
        setPiece(6, 7, new Knight(WHITE_ID));
        setPiece(7, 7, new Rook(WHITE_ID));
    }

    public void setPiece(int x, int y, Piece piece) {
        this.deployment[y][x] = piece;
    }

    public Piece getPiece(int x, int y) {
        return deployment[y][x];
    }

    public void movePiece(int nowX, int nowY, int moveX, int moveY) {
        deployment[moveY][moveX] = this.getPiece(nowX, nowY);
        deployment[nowY][nowX] = null;
    }

    public Piece[][] getDeployment() {
        return this.deployment;
    }
}
