import java.net.PortUnreachableException;

public class Main {
    public static void main(String[] args) {

        Pokemon oddish = new Pokemon();
        Pokemon growlithe = new Pokemon();
        Pokemon tentacool = new Pokemon();
        Pokemon bulbasaur = new Pokemon();
        Pokemon charmander = new Pokemon();
        Pokemon squirtle = new Pokemon();

        bulbasaur.stats(83,  17, 13, 90, bulbasaur.moves, "Grass");
        oddish.stats(85, 16, 15, 85, oddish.moves, "Electric");
        tentacool.stats(93, 13, 18, 90, tentacool.moves, "Water");
        growlithe.stats(68, 15, 15, 95, growlithe.moves, "Fire");
        charmander.stats(74, 18, 14, 90, charmander.moves, "Fire");
        squirtle.stats(80, 17, 14, 90, squirtle.moves, "Water");

        tentacool.pet();
        System.out.println(tentacool.moves);
//        growlithe.attack();
//        oddish.attack();
        System.out.println(oddish.speed);

    }
}
