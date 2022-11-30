package v1.player;

public abstract class Player {
    private final String nickname;

    Player(String nickname) {
        this.nickname = nickname;
        this.handleJoin();
    }

    // 플레이어의 닉네임을 반환
    public String getNickname() {
        return this.nickname;
    }

    // 플레이어가 게임에 입장했을 때 제어
    public void handleJoin() {
        System.out.println("Player " + this.nickname + " is joined!");
    }

    // 플레이어의 차례가 왔을 때 제어
    abstract public void handleTurn();
}
