import java.net.PortUnreachableException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Location palletTown = new Location("Pallet Town", "This is your hometown. You've lived here all your life.");
        Location routeOne = new Location("Route One", "A route from one town to another. Nothing more, nothing less");
        Location viridianCity = new Location("Viridian City", "A city full of shattered hopes and dreams");

        Pokemon oddish = new Pokemon();
        Pokemon growlithe = new Pokemon();
        Pokemon tentacool = new Pokemon();
        Pokemon bulbasaur = new Pokemon();
        Pokemon charmander = new Pokemon();
        Pokemon squirtle = new Pokemon();

        move tackle = new move("Tackle", "Normal", 10, 0, 0);
        move vineWhip = new move("Vine Whip", "Grass", 20, 0, 0);
        move ember = new move("Ember", "Fire", 20, 0, 0);
        move waterGun = new move("Water Gun", "Water", 20, 0, 0);
        move growl = new move("Growl", "Normal", 0, 0, 20);
        move growth = new move("Growth", "Normal", 0, 20,0);

        // Given the different pokemon their individual movepool
        bulbasaur.stats(83, 17, 13, 90, "Grass");
        bulbasaur.setMove1(vineWhip);
        bulbasaur.setMove2(growl);
        bulbasaur.setMove3(growth);
        String[] bulbasaurMoves = new String[] {bulbasaur.move1.attackName, bulbasaur.move2.attackName, bulbasaur.move3.attackName};

        oddish.stats(85, 16, 15, 85, "Grass");
        oddish.setMove1(vineWhip);
        oddish.setMove2(tackle);
        oddish.setMove3(growl);
        String[] oddishMoves = new String[] {oddish.move1.attackName, oddish.move2.attackName, oddish.move3.attackName};

        tentacool.stats(93, 13, 18, 90, "Water");
        tentacool.setMove1(waterGun);
        tentacool.setMove2(growl);
        tentacool.setMove3(growth);
        String[] tentacoolMoves = new String[] {tentacool.move1.attackName, tentacool.move2.attackName, tentacool.move3.attackName};

        growlithe.stats(70, 15, 15, 95, "Fire");
        growlithe.setMove1(ember);
        growlithe.setMove2(tackle);
        growlithe.setMove3(growth);
        String[] growlitheMoves = new String[] {growlithe.move1.attackName, growlithe.move2.attackName, growlithe.move3.attackName};

        charmander.stats(74, 18, 14, 90, "Fire");
        charmander.setMove1(tackle);
        charmander.setMove2(ember);
        charmander.setMove3(growl);
        String[] charmanderMoves = new String[] {charmander.move1.attackName, charmander.move2.attackName, charmander.move3.attackName};

        squirtle.stats(80, 17, 14, 90, "Water");
        squirtle.setMove1(waterGun);
        squirtle.setMove2(tackle);
        squirtle.setMove3(growl);
        String[] squirtleMoves = new String[] {squirtle.move1.attackName, squirtle.move2.attackName, squirtle.move3.attackName};



        tentacool.pet();
//        System.out.println(tentacool.moves);
//        growlithe.attack();
//        oddish.attack();
        System.out.println(oddish.speed);
        System.out.println(bulbasaur.move1.type);
        System.out.println(tentacool.move2.attackName);
        System.out.println(squirtle.move3.attackName + " deals " + squirtle.move3.damage + " damage." );


        System.out.println();
        System.out.println(Arrays.toString(squirtleMoves));
        System.out.println(Arrays.toString(charmanderMoves));
        System.out.println(Arrays.toString(bulbasaurMoves));
        System.out.println(Arrays.toString(oddishMoves));
        System.out.println(Arrays.toString(tentacoolMoves));
        System.out.println(Arrays.toString(growlitheMoves));

    }
}
