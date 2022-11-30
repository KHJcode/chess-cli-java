package v1.piece;

abstract public class Piece {
    private final int id;
    private final int teamId;
    protected char mark;

    Piece(int id, int teamId) {
        this.id = id;
        this.teamId = teamId;
    }

    public int getTeamId() {
        return this.teamId;
    }

    public int getId() {
        return this.id;
    }

    public char getMark() {
        return this.mark;
    }

    abstract public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus);
}
