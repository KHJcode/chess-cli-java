package v1;

import v1.player.Player;
import v1.player.Person;
import v1.player.Bot;

import static v1.Common.BLACK_ID;
import static v1.Common.WHITE_ID;

public class GameController {
    private Game game;
    private final Player player1;
    private final Player player2;

    public GameController() {
        this.player1 = new Person("Miyeon");
        this.player2 = new Person("Bixby");
    }

    public void start() {
        this.game = new Game();
        this.player1.handleJoin(this.game, WHITE_ID);
        this.player2.handleJoin(this.game, BLACK_ID);
        while (true) {
            if (this.game.getIsCheckmate() == 0) {
                this.player1.handleTurn();
            } else {
                break;
            }
            if (this.game.getIsCheckmate() == 0) {
                this.player2.handleTurn();
            } else {
                break;
            }
        }
        System.out.println("승리");
    }
}
