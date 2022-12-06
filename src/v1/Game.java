package v1;

import v1.piece.Pawn;
import v1.piece.Piece;
import v1.piece.PieceId;
import v1.piece.Queen;

import static v1.Common.*;

public class Game {
    private int count = 0;
    private final Board board;
    private final Renderer renderer;
    private int checkTeamId = 0;
    private int winnerTeamId = 0;

    Game() {
        this.board = new Board();
        this.renderer = new Renderer();
        this.renderBoard();
    }

    // 보드 인스턴스 반환
    public Board getBoard() {
        return this.board;
    }

    // 체크메이트 팀 반환
    public int getIsCheckmate() {
        return this.winnerTeamId;
    }

    // 왕 위치 반환
    private int[] getKingPosition(int teamId) {
        for (int y = 0; y <= HEIGHT; y++) {
            for (int x = 0; x <= WIDTH; x++) {
                Piece piece = this.board.getPiece(x, y);
                if (piece.getTeamId() == teamId && piece.getId() == PieceId.KING.get()) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 체크 여부 반환
    private boolean getIsCheck(int teamId) {
        int[] targetKingPosition = this.getKingPosition(getOtherTeamId(teamId));
        int targetKingX = targetKingPosition[0];
        int targetKingY = targetKingPosition[1];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Piece piece = this.board.getPiece(x, y);
                if ((x == targetKingX && y == targetKingY) || (piece.getTeamId() != teamId)) {
                    continue;
                }
                boolean canMove = piece.getCanMove(this.board, x, y, targetKingX, targetKingY, 2);
                if (canMove) {
                    return true;
                }
            }
        }
        return false;
    }

    // 체크 이벤트 제어
    private void handleCheck(int teamId) {
        System.out.println("시스템: 체크, " + (getOtherTeamId(teamId) == BLACK_ID ? "블랙 팀은" : "화이트 팀은") + " 대응하세요!");
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
    private void handlePut(int x, int y, int teamId) {
        Piece piece = this.board.getPiece(x, y);
        if (piece.getId() == PieceId.PAWN.get()) {
            ((Pawn) piece).setIsFirst(false);
            boolean isPromotion = this.getIsPromotion(y, piece.getTeamId());
            if (isPromotion) {
                this.handlePromotion(x, y, piece.getTeamId());
            }
        }
        boolean isCheck = this.getIsCheck(teamId);
        if (isCheck) {
            if (teamId == this.checkTeamId) {
                this.winnerTeamId = teamId;
            } else {
                this.checkTeamId = teamId;
                this.handleCheck(teamId);
            }
        } else {
            this.checkTeamId = 0;
        }
        boolean isCheckmate = this.getIsCheck(getOtherTeamId(teamId));
        if (isCheckmate) {
            this.winnerTeamId = getOtherTeamId(teamId);
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
                this.handlePut(moveX, moveY, piece.getTeamId());
                this.renderBoard();
                return true;
            }
        }
        return false;
    }
}
