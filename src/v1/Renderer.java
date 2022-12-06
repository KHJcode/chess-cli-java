package v1;

import v1.piece.Piece;

public class Renderer {
    public void draw(Board board) {
        int rows = 8;
        Piece[][] deployment = board.getDeployment();
        System.out.print("  ");
        for (int i = 1; i < 9; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
        System.out.println("  ┌───┬───┬───┬───┬───┬───┬───┬───┐");
        for (Piece[] pieces : deployment) {
            rows -= 1;
            System.out.print(8 - rows + " ");
            System.out.print("│");
            for (Piece piece : pieces) {
                System.out.print(" " + (piece == null ? ' ' : piece.getMark()) + " ");
                System.out.print("│");
            }
            System.out.println();
            if (rows > 0) {
                System.out.println("  ┝───┼───┼───┼───┼───┼───┼───┼───┥");
            }
        }
        System.out.println("  ┕───┶───┶───┶───┶───┶───┶───┶───┙");
    }
}
