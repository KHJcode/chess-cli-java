package v1.player;

import v1.Game;

public class Bot extends Player {
    private Game game;

    public Bot(String nickname) {
        super(nickname);
    }

    @Override
    public void handleJoin(Game game) {
        this.game = game;
    }

    @Override
    public void handleTurn() {
    }
}
