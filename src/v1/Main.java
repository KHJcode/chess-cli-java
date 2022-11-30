package v1;

import v1.player.Person;
import v1.player.Bot;
import v1.player.Player;

public class Main {
    public static void main(String[] args) {
        Player person = new Person("Danhee");
        Player bot = new Bot("Siri");
        GameController gameController = new GameController();
        gameController.start(person, bot);
    }
}
