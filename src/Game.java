import java.util.Scanner;

public class Game {
    int row;
    int col;
    Location[][] map;
    Scanner input = new Scanner(System.in);

    public void init() {
        Location palletTown = new Location("Pallet Town", "This is your hometown. You've lived here all your life." + "\n There is a sign at the town centerpoint");
        Location routeOne = new Location("Route One", "A route from one town to another. Nothing more, nothing less.");
        Location viridianCity = new Location("Viridian City", "A city built on shattered visions and dreams." + "\n There is a semi-broken sign on the ground but it looks readable.");
        Location oaksLab = new Location("Prof. Oak's Lab", "\nProfessor Oak works here. He's a close family friend. \n He is standing in the corner by six weird ball-shaped objects");
        Location rivalsPlace = new Location("Rival's place", "\nYour rival lives here. Stay alert!");

        //        Lägg till ball musik för när man är i vissa rum. Rival's place comes to mind

//      Location[][] map;
//      Gå till labbet, hämta en pokemon. Gå till rivalen och slåss

        map = new Location[][]{
                {viridianCity, rivalsPlace},
                {routeOne},
                {palletTown, oaksLab}};
        row = 2;
        col = 0;


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
        move growth = new move("Growth", "Normal", 0, 20, 0);

        // Given the different pokemon their individual movepool
        bulbasaur.stats(83, 17, 13, 90, "Grass");
        bulbasaur.setMove1(vineWhip);
        bulbasaur.setMove2(growl);
        bulbasaur.setMove3(growth);
        String[] bulbasaurMoves = new String[]{bulbasaur.move1.attackName, bulbasaur.move2.attackName, bulbasaur.move3.attackName};

        oddish.stats(85, 16, 15, 85, "Grass");
        oddish.setMove1(vineWhip);
        oddish.setMove2(tackle);
        oddish.setMove3(growl);
        String[] oddishMoves = new String[]{oddish.move1.attackName, oddish.move2.attackName, oddish.move3.attackName};

        tentacool.stats(93, 13, 18, 90, "Water");
        tentacool.setMove1(waterGun);
        tentacool.setMove2(growl);
        tentacool.setMove3(growth);
        String[] tentacoolMoves = new String[]{tentacool.move1.attackName, tentacool.move2.attackName, tentacool.move3.attackName};

        growlithe.stats(70, 15, 15, 95, "Fire");
        growlithe.setMove1(ember);
        growlithe.setMove2(tackle);
        growlithe.setMove3(growth);
        String[] growlitheMoves = new String[]{growlithe.move1.attackName, growlithe.move2.attackName, growlithe.move3.attackName};

        charmander.stats(74, 18, 14, 90, "Fire");
        charmander.setMove1(tackle);
        charmander.setMove2(ember);
        charmander.setMove3(growl);
        String[] charmanderMoves = new String[]{charmander.move1.attackName, charmander.move2.attackName, charmander.move3.attackName};

        squirtle.stats(80, 17, 14, 90, "Water");
        squirtle.setMove1(waterGun);
        squirtle.setMove2(tackle);
        squirtle.setMove3(growl);
        String[] squirtleMoves = new String[]{squirtle.move1.attackName, squirtle.move2.attackName, squirtle.move3.attackName};

        Sign palletSign = new Sign("The colorful Pallet Town was founded in 1991 by Professor Oak.");
        Sign viridianSign = new Sign("Be cautious of the weirdo that lives east of here. Rumor has it he fights anyone who enters his room");
        palletTown.setSign(palletSign);
        viridianCity.setSign(viridianSign);


        Humans rival = new Humans("You got some nerve coming here. You're gonna get it now", 1, rivalsPlace.getPokemon(), true);
        rivalsPlace.setHuman(rival);


        Humans professorOak = new Humans("Ah, there you are! I've been awaiting you. I have a couple of Pokémon here. Choose one!", 6, null, false);
        oaksLab.setHuman(professorOak);

        // TODO: 2021-10-29 Add pokemon to oaks lab, print its stats on command. Be able to carry one 


//          Vad ska vi kunna göra?
//          Gå, läsa, prata,


//        tentacool.pet();
//        System.out.println(tentacool.moves);
//        growlithe.attack();
//        oddish.attack();
//        System.out.println(oddish.type);
//        System.out.println(bulbasaur.move1.type);
//        System.out.println(tentacool.move2.attackName);
//        System.out.println(squirtle.move3.attackName + " deals " + squirtle.move3.damage + " damage." );
//
//
//        System.out.println();
//        System.out.println(Arrays.toString(squirtleMoves));
//        System.out.println(Arrays.toString(charmanderMoves));
//        System.out.println(Arrays.toString(bulbasaurMoves));
//        System.out.println(Arrays.toString(oddishMoves));
//        System.out.println(Arrays.toString(tentacoolMoves));
//        System.out.println(Arrays.toString(growlitheMoves));
    }

    //    Gå till oak. Välj en pokemon. Dra iväg till rivals place och slåss.
//    Får inte gå till route 1 utan pokemon från oak
    public void runGame() {

        boolean running = true;
        System.out.println("\nThis is some kind of Pokémon-based adventure. Take it for what it is." + "\n");
        System.out.println("Type help to see a list of available actions.");
        while (running) {

            System.out.println(map[row][col].locationToString());
            String[] commandParts = readInput();
            String action = commandParts[0];

            if (action.equalsIgnoreCase("Help")) {
                System.out.println("\n" + "Your available commands are: " + "\n" + "Help (obviously)");
                System.out.println("Go - Which is followed by 'up', 'down', 'left' or 'right'.");
                System.out.println("Read - Followed by whatever readable object is near you - 'Sign', for example");
                System.out.println("Talk - Followed by the name of a person in your close proximity. \n");
            }

            if (action.equalsIgnoreCase("Go")) {
                if (commandParts.length == 2) {
                    readDirection(commandParts[1]);
//                    System.out.println(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Read")) {
                if (commandParts.length == 2) {
                    inRead(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Talk"))
                if (commandParts.length == 2) {
                    inTalk(commandParts[1]);
                }
            if (action.equalsIgnoreCase("quit")) {
                System.out.println("Smell ya later!");
                running = false;
            }
        }
    }
    private String[] readInput() {
        System.out.println("\n" + "What now?");
        String command = input.nextLine();
        return command.split(" ");
    }
    private void readDirection(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            row--;
            if (row < 0) {
                System.out.println("Stay on the map");
                row++;
            }
        }
        if (direction.equalsIgnoreCase("down")) {
            row++;
            if (row > 2) {
                System.out.println("Stay on the map");
                row--;
            }
        }
        if (direction.equalsIgnoreCase("right")) {
            col++;
            if (col > 1) {
                System.out.println("Stay on the map");
                col--;
            }
        }
        if (direction.equalsIgnoreCase("left")) {
            col--;
            if (col < 0) {
                System.out.println("Stay on the map");
                col++;
            }
        }
    }
    private void inRead(String readSign) {
        if (readSign.equalsIgnoreCase("Sign")) {
            try {
                String read = map[row][col].getSign();
                System.out.println("\nThe sign reads: \n" + read + "\n");
            } catch (NullPointerException e){
                System.out.println("There are clearly no signs here. Am i going insane? \n");
            }
        }
    }
    private void inTalk(String talkTo) {
        if (talkTo.equalsIgnoreCase("Oak")) {
            try {
                String oakSays = map[row][col].getHuman().message;
                System.out.println("\n" + oakSays + "\n");
            } catch (NullPointerException e) {
                System.out.println("\nHmm.. the professor must be somewhere else. Where could he be?" + "\n");
            }
        }
        if (talkTo.equalsIgnoreCase("Rival")) {
            try {
                String rivalSays = map[row][col].getHuman().message;
                System.out.println("\n" + rivalSays + "\n");
            } catch (NullPointerException e) {
                System.out.println("\n" + "The taunting voice of your rival has been so daunting over the years, it's almost as if you can hear it in the air around you..");
                System.out.println("Which is strange, since he's not even here \n");
            }
        }
    }
}
