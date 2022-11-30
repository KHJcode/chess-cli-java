package v1.player;

public class Player {
    private final String nickname;

    Player(String nickname) {
        this.nickname = nickname;
        this.handleJoin();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void handleJoin() {
        System.out.println("Player " + this.nickname + " is joined!");
    }
}
