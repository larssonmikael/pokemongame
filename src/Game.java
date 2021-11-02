import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    int row;
    int col;
    Location[][] map;
    Scanner input = new Scanner(System.in);
    int pokemonParty;
    boolean trainer;
    boolean chosenPokemon = false;
    Pokemon myPokemon = null;
    File runAway = new File("SFX/He_ran_away.wav");
    File petSound = new File("SFX/Pet_Sound.wav");

    public void init() {
        Location palletTown = new Location("Pallet Town", "This is your hometown. You've lived here all your life. " +
                "\nThere is a sign at the town centerpoint");
        Location routeOne = new Location("Route One", "A route from one town to another. Nothing more, nothing less. " +
                "\nThere used to be a route heading east. However it has remained buried in rubble since the great earthquake in -06");
        Location viridianCity = new Location("Viridian City", "A city built on shattered visions and dreams. " +
                "\nThere is a semi-broken sign on the ground but it looks readable.");
        Location oaksLab = new Location("Prof. Oak's Lab", "\nProfessor Oak works here. He's a close family friend. " +
                "\nHe is standing in the corner by six weird ball-shaped objects");
        Location rivalsPlace = new Location("Rival's place", "\nYour rival lives here. Stay alert!");
        Location roadBlock = new Location("Roadblock", "\n This road is blocked. You were not supposed to reach this area..");

        //        Lägg till ball musik för när man är i vissa rum. Rival's place comes to mind
//      Gå till labbet, hämta en pokemon. Gå till rivalen och slåss

        map = new Location[][]{
                {viridianCity, rivalsPlace},
                {routeOne, roadBlock},
                {palletTown, oaksLab}};
        row = 2;
        col = 0;
        trainer = false;


//
//        int pokemonParty = 0;
//        boolean trainer = true;
//        boolean chosenPokemon = false;
//        Pokemon myPokemon = null;


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
        bulbasaur.stats(83, 17, 14, 90, "Grass", "Bulbasaur");
        bulbasaur.setMove1(vineWhip);
        bulbasaur.setMove2(growl);
        bulbasaur.setMove3(growth);
//        String[] bulbasaurMoves = new String[]{bulbasaur.move1.attackName, bulbasaur.move2.attackName, bulbasaur.move3.attackName};

        oddish.stats(85, 16, 15, 85, "Grass", "Oddish");
        oddish.setMove1(vineWhip);
        oddish.setMove2(tackle);
        oddish.setMove3(growl);
//        String[] oddishMoves = new String[]{oddish.move1.attackName, oddish.move2.attackName, oddish.move3.attackName};

        tentacool.stats(93, 13, 15, 90, "Water", "Tentacool");
        tentacool.setMove1(waterGun);
        tentacool.setMove2(growl);
        tentacool.setMove3(growth);
//        String[] tentacoolMoves = new String[]{tentacool.move1.attackName, tentacool.move2.attackName, tentacool.move3.attackName};

        growlithe.stats(70, 15, 15, 95, "Fire", "Growlithe");
        growlithe.setMove1(ember);
        growlithe.setMove2(tackle);
        growlithe.setMove3(growth);
//        String[] growlitheMoves = new String[]{growlithe.move1.attackName, growlithe.move2.attackName, growlithe.move3.attackName};

        charmander.stats(74, 18, 16, 90, "Fire", "Charmander");
        charmander.setMove1(tackle);
        charmander.setMove2(ember);
        charmander.setMove3(growl);
//        String[] charmanderMoves = new String[]{charmander.move1.attackName, charmander.move2.attackName, charmander.move3.attackName};

        squirtle.stats(80, 17, 16, 90, "Water", "Squirtle");
        squirtle.setMove1(waterGun);
        squirtle.setMove2(tackle);
        squirtle.setMove3(growl);
//        String[] squirtleMoves = new String[]{squirtle.move1.attackName, squirtle.move2.attackName, squirtle.move3.attackName};

        Sign palletSign = new Sign("The colorful Pallet Town was founded in 1991 by Professor Oak.");
        Sign viridianSign = new Sign("Be cautious of the weirdo that lives east of here. Rumor has it he fights anyone who enters his room");
        palletTown.setSign(palletSign);
        viridianCity.setSign(viridianSign);

        Humans rival = new Humans("Rival Douchebag","You got some nerve coming here. You're gonna get it now!", rivalsPlace.getPokemon(), null, true);
        rivalsPlace.setHuman(rival);
        rival.pokemon = rival.getPokemon();


        Humans professorOak = new Humans("Professor Oak", "Ah, there you are! I've been awaiting you. I have a few Pokémon here." +
                " \n Each one of these Pokémon has its own unique moves stats. " +
                "\n You can look at its individual stats by typing 'Check' followed by its name. " +
                "\n Choose one by typing 'Choose' followed by its name!" +
                "\n Choose with care. These creatures tend to stick to their owners.",
                 null, null, false);

        oaksLab.setHuman(professorOak);
        String [] oakPokemonList = new String[]{bulbasaur.getName(), charmander.getName(), squirtle.getName(), growlithe.getName(), oddish.getName(), tentacool.getName()};
        Pokemon [] listOfPokemon = new Pokemon[] {bulbasaur, charmander, squirtle, growlithe, oddish, tentacool};
//        professorOak.setPokemonArray(listOfPokemon);
        professorOak.setPokemonList(oakPokemonList);

        oaksLab.setPokemon(bulbasaur);
        oaksLab.setPokemon2(charmander);
        oaksLab.setPokemon3(squirtle);
        oaksLab.setPokemon4(oddish);
        oaksLab.setPokemon5(growlithe);
        oaksLab.setPokemon6(tentacool);

        // TODO: 2021-10-29 Add pokemon to oaks lab, print its stats on command. Be able to carry one
    }

    //    Gå till oak. Välj en pokemon. Dra iväg till rivals place och slåss.
//    Får inte gå till route 1 utan pokemon från oak
    public void runGame() {

        boolean running = true;
        System.out.println("\nThis is some kind of Pokémon-based adventure. Take it for what it is." + "\n");
        System.out.println("Type help to see a list of available actions.");
        while (running) {
            System.out.println(map[row][col].locationToString());
            if (myPokemon != null) {
                System.out.println(myPokemon.getName() + " is keeping close to you. You feel a bit less alone.");
            }
            String[] commandParts = readInput();
            String action = commandParts[0];

            if (action.equalsIgnoreCase("Help")) {
                System.out.println("\nYour available commands are: " + "\n" + "Help (obviously)");
                System.out.println("Go - Which is followed by 'up', 'down', 'left' or 'right'.");
                System.out.println("Read - Followed by whatever readable object is near you - 'Sign', for example");
                System.out.println("Talk - Followed by the name of a person in your close proximity.");
                System.out.println("Quit - Exit the game and do something completely different");
                if (myPokemon != null){
                    System.out.println("\nNow that you have a buddy by your side: \nCheck Buddy - Inspect your buddy");
                    System.out.println("Pet Buddy - Shower your buddy with love and affection.");
                }
            }

            if (action.equalsIgnoreCase("Go")) {
                if (commandParts.length == 2) {
                    readDirection(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Read")) {
                if (commandParts.length == 2) {
                    inRead(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Talk")) {
                if (commandParts.length == 2) {
                    inTalk(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Check")) {
                if (commandParts.length == 2 ) {
                    inPokemonStats(commandParts[1]);
                    checkMyPokemon(commandParts[1]);
                }
            }
            if (action.equalsIgnoreCase("Choose")) {
                if (commandParts.length == 2 && row == 2 && col == 1  && myPokemon == null) {
                    inChoosePokemon(commandParts[1]);
                } else if (commandParts.length == 2 && row == 2 && col == 1) {
                    System.out.println("You're not trying to disbandon " + myPokemon.name + " are you?");
                }
            }
            if (action.equalsIgnoreCase("Pet") && myPokemon != null) {
                if (commandParts.length == 2) {
                    inPetBuddy(commandParts[1]);
                } else {
                    System.out.println("Pet what?");
                }
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
    private void inChoosePokemon(String iChooseYou) {
        if (iChooseYou.equalsIgnoreCase("Bulbasaur")) {
            myPokemon = map[row][col].getPokemon();
            trainer = true;
            chosenPokemon = true;
            pokemonParty ++;
            System.out.println("You chose Bulbasaur as your companion!");
        }
        if (iChooseYou.equalsIgnoreCase("Charmander")) {
            myPokemon = map[row][col].getPokemon2();
            trainer = true;
            chosenPokemon = true;
            pokemonParty++;
            System.out.println("You chose Charmander as your companion!");
        }
        if (iChooseYou.equalsIgnoreCase("Squirtle")) {
            myPokemon = map[row][col].getPokemon3();
            trainer = true;
            chosenPokemon = true;
            pokemonParty++;
            System.out.println("You chose Squirtle as your companion!");
        }
        if (iChooseYou.equalsIgnoreCase("Oddish")) {
            myPokemon = map[row][col].getPokemon4();
            trainer = true;
            chosenPokemon = true;
            pokemonParty++;
            System.out.println("You chose Oddish as your companion!");
        }
        if (iChooseYou.equalsIgnoreCase("Growlithe")) {
            myPokemon = map[row][col].getPokemon5();
            trainer = true;
            chosenPokemon = true;
            pokemonParty++;
            System.out.println("You chose Growlithe as your companion!");
        }
        if (iChooseYou.equalsIgnoreCase("Tentacool")) {
            myPokemon = map[row][col].getPokemon6();
            trainer = true;
            chosenPokemon = true;
            pokemonParty++;
            System.out.println("You chose Tentacool as your companion!");
        }
    }
    private void readDirection(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            row--;
            if (row < 0) {
                System.out.println("Stay on the map");
                row++;
            }
            if (row == 1 && col == 1) {
                row++;
                System.out.println("Technically speaking, you could reach the blocked route from here. However, in Prof. Oak's lab, the way in is the only way out.");
            }
        }
        if (direction.equalsIgnoreCase("down")) {
            row++;
            if (row > 2) {
                System.out.println("Stay on the map");
                row--;
            }
            if (row == 1 && col == 1) {
                row--;
                System.out.println("The road is blocked");
            }
        }
        if (direction.equalsIgnoreCase("right")) {
            col++;
            if (col > 1) {
                System.out.println("Stay on the map");
                col--;
            }
            if (row == 1 && col == 1) {
                col--;
                System.out.println("The road is blocked");
            }
            if (row == 0 && col == 1 && !trainer) {
                col--;
                System.out.println("Someone's voice: HEY!! \nDon't go in there without a Pokémon! That dude's a looney!");
            }
            if (row == 0 && col == 1 && trainer) {
                System.out.println("-" + map[0][1].getHuman().message);
                System.out.println("You've encountered " + map[0][1].getHuman().name + "\nBattle (Not yet implemented) or Run?");
                boolean run = false;
                while (!run) {
                    if (input.nextLine().equalsIgnoreCase("Run")) {
                        run = true;
                        playSfx(runAway);
                        System.out.println("You ran home in tears. Unsettled by your unstable mental state, " + myPokemon.name + " ran after you and consoled you.");
                        map[row][col] = map[2][0];
                    } else
                        System.out.println("You gotta choose. It's now or never. " + map[0][1].getHuman().name + " sure isn't going anywhere.");
                }
            }
        }
        if (direction.equalsIgnoreCase("left")) {
            col--;
            if (col < 0) {
                System.out.println("Stay on the map");
                col++;
            }
            if (row == 1 && col == 1) {
                col++;
                System.out.println("The road is blocked");
            }
        }
    }
    private void inPokemonStats(String readStats) {
        if (readStats.equalsIgnoreCase("Bulbasaur")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon().getName());
                System.out.println("Hp:" + map[row][col].getPokemon().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon().move3.attackName);
            } catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab in the south-east part of the world. The professor has all the answers.");
            }
        }
        if (readStats.equalsIgnoreCase("Charmander")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon2().getName());
                System.out.println("Hp:" + map[row][col].getPokemon2().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon2().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon2().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon2().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon2().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon2().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon2().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon2().move3.attackName);
            }
            catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
            }
        }
        if (readStats.equalsIgnoreCase("Squirtle")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon3().getName());
                System.out.println("Hp:" + map[row][col].getPokemon3().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon3().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon3().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon3().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon3().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon3().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon3().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon3().move3.attackName);
            } catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
            }
        }
        if (readStats.equalsIgnoreCase("Oddish")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon4().getName());
                System.out.println("Hp:" + map[row][col].getPokemon4().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon4().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon4().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon4().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon4().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon4().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon4().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon4().move3.attackName);
            } catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
            }
        }
        if (readStats.equalsIgnoreCase("Growlithe")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon5().getName());
                System.out.println("Hp:" + map[row][col].getPokemon5().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon5().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon5().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon5().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon5().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon5().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon5().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon5().move3.attackName);
            } catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
            }
        }
        if (readStats.equalsIgnoreCase("Tentacool")) {
            try {
                System.out.println("\nName:" + map[row][col].getPokemon6().getName());
                System.out.println("Hp:" + map[row][col].getPokemon6().getBaseHP());
                System.out.println("Attackpower:" + map[row][col].getPokemon6().getAttackPower());
                System.out.println("Speed:" + map[row][col].getPokemon6().getSpeed());
                System.out.println("Accuracy:" + map[row][col].getPokemon6().getAccuracy());
                System.out.println("Type:" + map[row][col].getPokemon6().getType());
                System.out.println();
                System.out.println("Move 1: " + map[row][col].getPokemon6().move1.attackName);
                System.out.println("Move 2: " + map[row][col].getPokemon6().move2.attackName);
                System.out.println("Move 3: " + map[row][col].getPokemon6().move3.attackName);
            }
            catch (NullPointerException e) {
                System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
            }
        }
    }
    private void inRead(String readSign) {
        if (readSign.equalsIgnoreCase("Sign")) {
            try {
                String read = map[row][col].getSignMessage();
                System.out.println("\nThe sign reads: \n" + read);
            } catch (NullPointerException e){
                System.out.println("\nThere are clearly no signs here. Am I seeing things?");
            }
        }
    }
    private void inTalk(String talkTo) {
        if (talkTo.equalsIgnoreCase("Oak")) {
            try {
                String oakSays = map[row][col].getHuman().message;
                System.out.println("\n -" + oakSays + "\n");
                    System.out.println(Arrays.deepToString(map[row][col].getHuman().pokemonList));

                // TODO: 2021-10-31 Lägg till listan på pkmn här om man inte har nån pkmn redan
            } catch (NullPointerException e) {
                System.out.println("\nHmm.. the professor must be somewhere else. Where could he be?");
            }
        }
        if (talkTo.equalsIgnoreCase("Rival")) {
            try {
                String rivalSays = map[row][col].getHuman().message;
                System.out.println("\n -" + rivalSays);
            } catch (NullPointerException e) {
                System.out.println("\n" + "The taunting voice of your rival has been so daunting over the years, it's almost as if you can hear it" +
                        " in the air around you.. \nWhich is strange, since he's not even here");
            }
        }
    }
    private void checkMyPokemon(String checkBuddyStats) {
        if (checkBuddyStats.equalsIgnoreCase("Buddy"))  {
            try {
                System.out.println("Name: " + myPokemon.getName());
                System.out.println("Hp: " + myPokemon.getBaseHP());
                System.out.println("Attackpower :" + myPokemon.getAttackPower());
                System.out.println("Speed " + myPokemon.getSpeed());
                System.out.println("Accuracy " +myPokemon.getAccuracy());
                System.out.println("Type: " + myPokemon.getType());
                System.out.println();
                System.out.println("Move 1: " + myPokemon.getMove1().attackName);
                System.out.println("Move 2: " + myPokemon.getMove2().attackName);
                System.out.println("Move 3: " + myPokemon.getMove3().attackName);
            } catch (NullPointerException e) {
                System.out.println("You don't have a buddy.. yet! You should visit Prof. Oak.");
            }
        }
    }
    private void inPetBuddy(String petBuddy) {
        if (petBuddy.equalsIgnoreCase("Buddy")) {
            myPokemon.pet();
            playSfx(petSound);
        }
    }
    private void playSfx(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void startBattle(Pokemon myPokemon, Pokemon pokemon){

        boolean battle = true;
        System.out.println("You've engaged in a battle!");

        while (battle){

        }

    }
}
