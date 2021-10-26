import java.net.PortUnreachableException;

public class Main {
    public static void main(String[] args) {

        Pokemon oddish = new Pokemon();
        Pokemon growlithe = new Pokemon();
        Pokemon tentacool = new Pokemon();
        Pokemon bulbasaur = new Pokemon();
        Pokemon charmander = new Pokemon();
        Pokemon squirtle = new Pokemon();

        move tackle = new move("Tackle", "Normal", 10, 0, 0);
        move leer = new move("Leer", "Normal", 0, 20, 0);
        move waterGun = new move("Water Gun", "Water", 20, 0, 0);
        move ember = new move("Ember", "Fire", 20, 0, 0);
        move growl = new move("Growl", "Normal", 0, 0, 20);
        move vineWhip = new move("Vine Whip", "Grass", 20, 0, 0);

        bulbasaur.stats(83, 17, 13, 90, "Grass");
        bulbasaur.setMove1(vineWhip);
        bulbasaur.setMove2(growl);

        oddish.stats(85, 16, 15, 85, "Grass");
        oddish.setMove1(vineWhip);
        oddish.setMove2(tackle);

        tentacool.stats(93, 13, 18, 90, "Water");
        tentacool.getMove1(waterGun);
        tentacool.getMove2(growl);

        growlithe.stats(68, 15, 15, 95, "Fire");
        growlithe.getMove1(ember);
        growlithe.getMove2(tackle);

        charmander.stats(74, 18, 14, 90, "Fire");
        charmander.setMove1(tackle);
        charmander.setMove2(ember);
        charmander.setMove3(growl);

        squirtle.stats(80, 17, 14, 90, "Water");
        squirtle.setMove1(waterGun);
        squirtle.setMove2(tackle);
        squirtle.setMove3(growl);

        tentacool.pet();
//        System.out.println(tentacool.moves);
//        growlithe.attack();
//        oddish.attack();
        System.out.println(oddish.speed);
        System.out.println(bulbasaur.move1.attackName);

    }
}
