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

    /*
        targetStatus = (0: 빈 칸, 1: 우리 칸, 2: 상대 칸)
     */
    abstract public boolean getCanMove(int nowX, int nowY, int moveX, int moveY, int targetStatus, Piece[][] deployment);
}
