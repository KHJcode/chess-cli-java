package v1;

import v1.player.Player;
import v1.player.Person;
import v1.player.Bot;

public class GameController {
    private Game game;
    private Player player1, player2;

    public GameController() {
        this.player1 = new Person("Miyeon");
        this.player2 = new Bot("Bixby");
    }

    public void start() {
        this.game = new Game();
        this.player1.handleJoin(this.game);
        this.player2.handleJoin(this.game);
        while (!this.game.getIsCheckmate()) {
            this.player1.handleTurn();
            this.player2.handleTurn();
        }
        System.out.println("승리");
    }

    public void restart() {
        Player fakePlayer = this.player1;
        this.player1 = this.player2;
        this.player2 = fakePlayer;
        this.start();
    }

    public void end() {
        this.game = null;
    }
}
