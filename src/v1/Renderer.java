package v1;

import v1.piece.Piece;

public class Renderer {
    public void draw(Board board) {
        Piece[][] deployment = board.getDeployment();
        for (Piece[] pieces : deployment) {
            System.out.println();
            for (Piece piece : pieces) {
                System.out.print(piece == null ? ' ' : piece.getMark());
            }
        }
    }
}
