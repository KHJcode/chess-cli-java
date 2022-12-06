package v1;

import v1.piece.Piece;
import v1.piece.PieceId;
import v1.piece.Queen;

import static v1.Common.BLACK_ID;
import static v1.Common.WHITE_ID;

public class Game {
    private int count = 0;
    private final Board board;
    private final Renderer renderer;

    Game() {
        this.board = new Board();
        this.renderer = new Renderer();
        this.renderBoard();
    }

    // 보드 인스턴스 반환
    public Board getBoard() {
        return this.board;
    }

    public Piece[][] getDeployment() {
        return this.board.getDeployment();
    }

    public boolean getIsCheckmate() {
        return false;
    }

    // 체크 여부 반환
    private boolean getIsCheck() {
        return false;
    }

    // 체크 이벤트 제어
    private void handleCheck() {
        System.out.println("시스템: 체크!");
    }

    // 프로모션 여부 반환
    private boolean getIsPromotion(int y, int teamId) {
        return (teamId == BLACK_ID && y == 7) || (teamId == WHITE_ID && y == 0);
    }

    // 프로모션 이벤트 제어
    private void handlePromotion(int x, int y, int teamId) {
        this.board.setPiece(x, y, new Queen(teamId));
    }

    // 착수 이벤트 제어
    private void handlePut(int x, int y) {
        boolean isCheck = this.getIsCheck();
        if (isCheck) {
            this.handleCheck();
        } else {
            Piece piece = this.board.getPiece(x, y);
            if (piece.getId() == PieceId.PAWN.get()) {
                boolean isPromotion = this.getIsPromotion(y, piece.getTeamId());
                if (isPromotion) {
                    this.handlePromotion(x, y, piece.getTeamId());
                }
            }
        }
    }

    // 보드 렌더링
    public void renderBoard() {
        this.renderer.draw(this.board);
    }

    // 착수
    public boolean put(int nowX, int nowY, int moveX, int moveY) {
        Piece piece = board.getPiece(nowX, nowY);
        if (piece != null) {
            Piece targetPiece = board.getPiece(moveX, moveY);
            int targetStatus = targetPiece == null ? 0 : (piece.getTeamId() == targetPiece.getTeamId() ? 1 : 2);
            boolean canMove = piece.getCanMove(this.board, nowX, nowY, moveX, moveY, targetStatus);
            if (canMove) {
                board.movePiece(nowX, nowY, moveX, moveY);
                count += 1;
                this.handlePut(moveX, moveY);
                this.renderBoard();
                return true;
            }
        }
        return false;
    }
}
