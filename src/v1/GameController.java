package v1;

import v1.player.Player;
import v1.player.Person;
import v1.player.Bot;

public class GameController {
    private Game game;
    private final Player player1;
    private final Player player2;

    public GameController() {
        this.player1 = new Person("Miyeon");
        this.player2 = new Bot("Bixby");
    }

    public void start() {
        this.game = new Game();
        this.player1.handleJoin(this.game);
        this.player2.handleJoin(this.game);
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
