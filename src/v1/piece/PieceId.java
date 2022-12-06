package v1.piece;

public enum PieceId {
    ROOK(1),
    KNIGHT(2),
    BISHOP(3),
    KING(4),
    QUEEN(5),
    PAWN(6);

    private final int value;

    PieceId(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
