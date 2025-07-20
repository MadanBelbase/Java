class Player {
    void sports() {
        System.out.println("Player plays sports");
    }
}

class Game extends Player {
    @Override
    void sports() {
        System.out.println("Maddy is a player");
    }
}

public class MethodOverRidingExample {
    public static void main(String[] args) {
        Player play = new Player();
        play.sports();

        Game game = new Game();
        game.sports();

        Player A = new Game();
        A.sports();
    }
}
