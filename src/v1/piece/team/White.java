package v1.piece.team;

public class White extends PieceTeam {
    @Override
    public char getBishop() {
        return '♗';
    }

    @Override
    public char getKing() {
        return '♔';
    }

    @Override
    public char getQueen() {
        return '♕';
    }

    @Override
    public char getRook() {
        return '♖';
    }

    @Override
    public char getKnight() {
        return '♘';
    }

    @Override
    public char getPawn() {
        return '♙';
    }
}
