package v1.player;

import v1.Game;
import v1.piece.Piece;

import java.io.Console;
import java.util.Scanner;

public class Person extends Player {
    private Game game;

    public Person(String nickname) {
        super(nickname);
    }

    // 범위 내의 숫자를 입력 받고 반환
    public int inputNumberWithinRange(String mode, char axis, int min, int max) {
        Scanner input = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println(mode + " " + axis + " (" + min + " ~ " + max + ") :");
            number = input.nextInt();
            if (number >= min && number <= max) {
                break;
            }
            System.out.println("시스템: 범위 내의 숫자를 입력해주세요!");
        }
        return number;
    }

    @Override
    public void handleJoin(Game game) {
        this.game = game;
    }

    @Override
    public void handleTurn() {
        boolean result = false;
        while (!result) {
            int currentX = this.inputNumberWithinRange("선택", 'X', 1, 8) - 1;
            int currentY = this.inputNumberWithinRange("선택", 'Y', 1, 8) - 1;
            if (this.game.getBoard().getPiece(currentX, currentY) == null) {
                System.out.println("시스템: 선택하신 칸은 현재 비어있습니다!");
            } else {
                int targetX = this.inputNumberWithinRange("이동", 'X', 1, 8) - 1;
                int targetY = this.inputNumberWithinRange("이동", 'Y', 1, 8) - 1;
                result = this.game.put(currentX, currentY, targetX, targetY);
                if (!result) {
                    System.out.println("시스템: 규칙에 따라 착수할 수 없습니다!");
                }
            }
        }
    }
}
