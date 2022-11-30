package v1;

import v1.player.Player;

public class GameController {
    private Game game;
    private Player player1, player2;

    public void start(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = new Game(this.player1, this.player2);
    }

    public void restart() {
        Player fakePlayer = this.player1;
        this.player1 = this.player2;
        this.player2 = fakePlayer;
        this.game = new Game(this.player2, this.player1);
    }

    public void end() {
        this.game = null;
    }
}
