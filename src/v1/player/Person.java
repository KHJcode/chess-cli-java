package v1.player;

import java.util.Scanner;

public class Person extends Player {
    public Person(String nickname) {
        super(nickname);
    }

    // 범위 내의 숫자를 입력 받고 반환
    public int inputNumberWithinRange(char axis, int min, int max) {
        Scanner input = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("입력 " + axis + " (" + min + " ~ " + max + ") :");
            number = input.nextInt();
            if (number >= min && number <= max) {
                break;
            }
            System.out.println("시스템: 범위 내의 숫자를 입력해주세요!");
        }
        return number;
    }

    @Override
    public void handleTurn() {
        int x, y;
        x = this.inputNumberWithinRange('X', 1, 8);
        y = this.inputNumberWithinRange('Y', 1, 8);
    }
}
