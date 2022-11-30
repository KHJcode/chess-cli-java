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
        int id = 0;
        setPiece(0, 0, new Rook(++id, BLACK_ID));
        setPiece(0, 1, new Knight(++id, BLACK_ID));
        setPiece(0, 2, new Bishop(++id, BLACK_ID));
        setPiece(0, 3, new King(++id, BLACK_ID));
        setPiece(0, 4, new Queen(++id, BLACK_ID));
        setPiece(0, 5, new Bishop(++id, BLACK_ID));
        setPiece(0, 6, new Knight(++id, BLACK_ID));
        setPiece(0, 7, new Rook(++id, BLACK_ID));
        setPiece(1, 0, new Pawn(++id, BLACK_ID));
        setPiece(1, 1, new Pawn(++id, BLACK_ID));
        setPiece(1, 2, new Pawn(++id, BLACK_ID));
        setPiece(1, 3, new Pawn(++id, BLACK_ID));
        setPiece(1, 4, new Pawn(++id, BLACK_ID));
        setPiece(1, 5, new Pawn(++id, BLACK_ID));
        setPiece(1, 6, new Pawn(++id, BLACK_ID));
        setPiece(1, 7, new Pawn(++id, BLACK_ID));
        setPiece(6, 0, new Pawn(++id, WHITE_ID));
        setPiece(6, 1, new Pawn(++id, WHITE_ID));
        setPiece(6, 2, new Pawn(++id, WHITE_ID));
        setPiece(6, 3, new Pawn(++id, WHITE_ID));
        setPiece(6, 4, new Pawn(++id, WHITE_ID));
        setPiece(6, 5, new Pawn(++id, WHITE_ID));
        setPiece(6, 6, new Pawn(++id, WHITE_ID));
        setPiece(6, 7, new Pawn(++id, WHITE_ID));
        setPiece(7, 0, new Rook(++id, WHITE_ID));
        setPiece(7, 1, new Knight(++id, WHITE_ID));
        setPiece(7, 2, new Bishop(++id, WHITE_ID));
        setPiece(7, 3, new King(++id, WHITE_ID));
        setPiece(7, 4, new Queen(++id, WHITE_ID));
        setPiece(7, 5, new Bishop(++id, WHITE_ID));
        setPiece(7, 6, new Knight(++id, WHITE_ID));
        setPiece(7, 7, new Rook(++id, WHITE_ID));
    }

    private void setPiece(int x, int y, Piece piece) {
        this.deployment[x][y] = piece;
    }

    public Piece getPiece(int x, int y) {
        return deployment[x][y];
    }

    public void movePiece(int nowX, int nowY, int moveX, int moveY) {
        deployment[moveX][moveY] = deployment[nowX][nowY];
        deployment[nowX][nowY] = null;
    }

    public Piece[][] getDeployment() {
        return this.deployment;
    }
}
