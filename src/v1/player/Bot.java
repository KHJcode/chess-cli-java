package v1.player;

import java.util.Random;

import v1.piece.Piece;
import v1.Game;

public class Bot extends Player {
    public Bot(String nickname) {
        super(nickname);
    }

    private Game game;
    Piece[][] deployment;

    @Override
    public void handleJoin(Game game, int teamId) {
        this.game = game;
        this.deployment = this.game.getBoard().getDeployment();
    }

    public void handleTurn() {
        int arr[] = {0,};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (10 <= deployment[i][j].getId() && deployment[i][j].getId() <= 19) {
                    arr[count++] = deployment[i][j].getId();
                }
            }
        }
        Random random = new Random();
        int done = 0;
        while (true) {
            if (done == 1) break;
            int p = random.nextInt(count - 1);
            int pre_x = 0;
            int pre_y = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (deployment[i][j].getId() == arr[p]) {
                        pre_x = i;
                        pre_y = j;
                    }
                }
            }
            if (arr[p] == 1 || arr[p] == 8) {
                int x = 0;
                int y = 0;
                int dir = random.nextInt(2);//가로 세로
                int xx = random.nextInt(7);//이동할 양
                int mi = random.nextInt(2);//음수 양수
                if (mi == 1) xx = x * -1;
                if (dir == 0) {
                    x = pre_x + xx;
                    y = pre_y;
                } else {
                    x = pre_x;
                    y = pre_y + xx;
                }

                while (true) {
                    if (this.game.put(pre_x, pre_y, x, y)) {
                        done = 1;
                        break;
                    }
                    dir = random.nextInt(2);//가로 세로
                    xx = random.nextInt(7);//이동할 양
                    mi = random.nextInt(2);//음수 양수
                    if (mi == 1) xx = x * -1;
                    if (dir == 0) {
                        x = pre_x + xx;
                        y = pre_y;
                    } else {
                        x = pre_x;
                        y = pre_y + xx;
                    }

                }
            } else if (arr[p] == 2 || arr[p] == 7) {
                int cnt = 0;
                while (true) {
                    int dir = random.nextInt(4);//동서남북
                    int x = 0;
                    int y = 0;
                    if (dir == 0) {
                        x = pre_x + 2;
                        y = pre_y + 1;
                    } else if (dir == 1) {
                        x = pre_x + 2;
                        y = pre_y - 1;
                    } else if (dir == 2) {
                        x = pre_x - 2;
                        y = pre_y - 1;
                    } else {
                        x = pre_x - 2;
                        y = pre_y + 1;
                    }
                    cnt++;
                    if (this.game.put(pre_x, pre_y, x, y) || cnt == 5) {
                        if (cnt != 5) done = 1;
                        break;
                    }
                }
            } else if (arr[p] == 3 || arr[p] == 6) {
                int cnt = 0;
                while (true) {
                    int dir = random.nextInt(4);//동서남북
                    int length = random.nextInt(8);
                    int x = 0;
                    int y = 0;
                    if (dir == 0) {
                        x = pre_x + length;
                        y = pre_y + length;
                    } else if (dir == 1) {
                        x = pre_x + length;
                        y = pre_y - length;
                    } else if (dir == 2) {
                        x = pre_x - length;
                        y = pre_y - length;
                    } else {
                        x = pre_x - length;
                        y = pre_y + length;
                    }
                    cnt++;
                    if (this.game.put(pre_x, pre_y, x, y) || cnt == 10) {
                        if (cnt != 10) done = 1;
                        break;
                    }
                }
            } else if (arr[p] == 4) {
                while (true) {
                    int dir = random.nextInt(4);//동서남북
                    int length = random.nextInt(8);
                    int x = 0;
                    int y = 0;
                    if (dir == 0) {
                        x = pre_x;
                        y = pre_y + length;
                    } else if (dir == 1) {
                        x = pre_x + length;
                        y = pre_y + length;
                    } else if (dir == 2) {
                        x = pre_x + length;
                        y = pre_y;
                    } else if (dir == 3) {
                        x = pre_x + length;
                        y = pre_y - length;
                    } else if (dir == 4) {
                        x = pre_x;
                        y = pre_y - length;
                    } else if (dir == 5) {
                        x = pre_x - length;
                        y = pre_y - length;
                    } else if (dir == 6) {
                        x = pre_x - length;
                        y = pre_y;
                    } else {
                        x = pre_x - length;
                        y = pre_y + length;
                    }
                    if (this.game.put(pre_x, pre_y, x, y)) {
                        done = 1;
                        break;
                    }

                }
            } else if (arr[p] == 5) {
                while (true) {
                    int dir = random.nextInt(8);//동서남북
                    int length = 1;
                    int x = 0;
                    int y = 0;
                    if (dir == 0) {
                        x = pre_x;
                        y = pre_y + length;
                    } else if (dir == 1) {
                        x = pre_x + length;
                        y = pre_y + length;
                    } else if (dir == 2) {
                        x = pre_x + length;
                        y = pre_y;
                    } else if (dir == 3) {
                        x = pre_x + length;
                        y = pre_y - length;
                    } else if (dir == 4) {
                        x = pre_x;
                        y = pre_y - length;
                    } else if (dir == 5) {
                        x = pre_x - length;
                        y = pre_y - length;
                    } else if (dir == 6) {
                        x = pre_x - length;
                        y = pre_y;
                    } else {
                        x = pre_x - length;
                        y = pre_y + length;
                    }
                    if (this.game.put(pre_x, pre_y, x, y)) {
                        done = 1;
                        break;
                    }

                }
            } else {
                while (true) {
                    int dir = random.nextInt(4);
                    int x = 0;
                    int y = 0;
                    if (dir == 0) {
                        x = pre_x - 1;
                        y = pre_y + 2;
                    } else if (dir == 1) {
                        x = pre_x;
                        y = pre_y + 2;
                    } else if (dir == 2) {
                        x = pre_x + 1;
                        y = pre_y + 2;
                    } else {
                        x = pre_x;
                        y = pre_y + 1;
                    }
                    if (this.game.put(pre_x, pre_y, x, y)) {
                        done = 1;
                        break;
                    }
                }
            }
        }
    }
}
