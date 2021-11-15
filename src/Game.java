import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    int row;
    int col;
    Location[][] map;
    Scanner input = new Scanner(System.in);
    boolean trainer;
    boolean chosenPokemon = false;
    boolean battle;
    Pokemon myPokemon;
    Pokemon rivalPokemon;
    Pokemon myPokemonInBattle;
    Pokemon opponentPokemonInBattle;
    File runAway = new File("SFX/He_ran_away.wav");
    File petSound = new File("SFX/Pet_Sound.wav");
    File hey = new File("SFX/Hey.wav");
    Humans rival;
    Humans professorOak = new Humans("Professor Oak", "Ah, there you are! I've been awaiting you. I have a few Pokémon here." +
            "\n Each one of these Pokémon has its own unique moves stats. " +
            "\n You can look at its individual stats by typing 'Check' followed by its name. " +
            "\n Choose one by typing 'Choose' followed by its name!" +
            "\n Choose with care. These creatures tend to stick to their owners.",
            null, null, false);

    Location palletTown = new Location("Pallet Town", "This is your hometown. You've lived here all your life. " +
            "\nThere is a sign at the town centerpoint");
    Location routeOne = new Location("Route One", "A route from one town to another. Nothing more, nothing less. " +
            "\nThere used to be a route heading east. However it has remained buried in rubble since the great earthquake in -06.");
    Location viridianCity = new Location("Viridian City", "A city built on shattered visions and dreams. " +
            "\nThere is a semi-broken sign on the ground but it looks readable.");
    Location oaksLab = new Location("Prof. Oak's Lab", "Professor Oak works here. He's a close family friend. " +
            "\nHe is standing in the back of the lap next to a table with six weird ball-shaped objects on it.");
    Location rivalsPlace = new Location("Rival's place", "\nYour rival lives here. Stay alert!");
    Location roadBlock = new Location("Roadblock", null);


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Location[][] getMap() {
        return map;
    }

    public void setMap(Location[][] map) {
        this.map = map;
    }

    //  Ititializating game
    public void init() {


        map = new Location[][]{
                {viridianCity, rivalsPlace},
                {routeOne, roadBlock},
                {palletTown, oaksLab}};
        row = 2;
        col = 1;


        trainer = false;

        Pokemon oddish = new Pokemon();
        Pokemon growlithe = new Pokemon();
        Pokemon tentacool = new Pokemon();
        Pokemon bulbasaur = new Pokemon();
        Pokemon charmander = new Pokemon();
        Pokemon squirtle = new Pokemon();

        move tackle = new move("Tackle", "Normal", 8, 0, 0);
        move vineWhip = new move("Vine Whip", "Grass", 10, 0, 0);
        move ember = new move("Ember", "Fire", 11, 0, 0);
        move waterGun = new move("Water Gun", "Water", 9, 0, 0);
        move growl = new move("Growl", "Normal", 0, 0, 2);
        move growth = new move("Growth", "Normal", 0, 2, 0);

        bulbasaur.stats(83, 17, 14, 90, "Grass", "Bulbasaur");
        bulbasaur.setMove1(vineWhip);
        bulbasaur.setMove2(growl);
        bulbasaur.setMove3(growth);

        oddish.stats(85, 16, 15, 85, "Grass", "Oddish");
        oddish.setMove1(vineWhip);
        oddish.setMove2(tackle);
        oddish.setMove3(growl);

        tentacool.stats(93, 13, 15, 90, "Water", "Tentacool");
        tentacool.setMove1(waterGun);
        tentacool.setMove2(growl);
        tentacool.setMove3(growth);

        growlithe.stats(70, 15, 15, 95, "Fire", "Growlithe");
        growlithe.setMove1(ember);
        growlithe.setMove2(tackle);
        growlithe.setMove3(growth);

        charmander.stats(74, 18, 16, 90, "Fire", "Charmander");
        charmander.setMove1(tackle);
        charmander.setMove2(ember);
        charmander.setMove3(growl);

        squirtle.stats(80, 17, 16, 90, "Water", "Squirtle");
        squirtle.setMove1(waterGun);
        squirtle.setMove2(tackle);
        squirtle.setMove3(growl);

        Sign palletSign = new Sign("The colorful Pallet Town was founded in 1991 by Professor Oak.");
        Sign viridianSign = new Sign("Be cautious of the nutjob that lives east of here. Rumor has it he fights anyone who enters his house");
        palletTown.setSign(palletSign);
        viridianCity.setSign(viridianSign);

        rival = new Humans("Rival Douchebag", "You got some nerve coming here. You're gonna get it now!", rivalPokemon, null, true);

        rivalsPlace.setHuman(rival);


        String[] oakPokemonList = new String[]{bulbasaur.getName(), charmander.getName(), squirtle.getName(), growlithe.getName(), oddish.getName(), tentacool.getName()};
        professorOak.setPokemonList(oakPokemonList);
        oaksLab.setHuman(professorOak);

        oaksLab.setPokemon(bulbasaur);
        oaksLab.setPokemon2(charmander);
        oaksLab.setPokemon3(squirtle);
        oaksLab.setPokemon4(oddish);
        oaksLab.setPokemon5(growlithe);
        oaksLab.setPokemon6(tentacool);
    }


    public void runGame() {

        boolean running = true;
        System.out.println("\nThis is some kind of Pokémon-based adventure. Take it for what it is." + "\n");
        System.out.println("Type help to see a list of available actions.");
        while (running) {

//          Print location and buddy pokemon if one is chosen
            System.out.println(map[row][col].locationToString());
            if (myPokemon != null) {
                System.out.println(myPokemon.getName() + " is keeping close to you. You feel a bit less alone.");
            }
            String[] commandParts = readInput();
            String action = commandParts[0];

//          The available actions
            if (action.equalsIgnoreCase("Help")) {
                System.out.println("\nYour available commands are: \nHelp (obviously)");
                System.out.println("Go - Which is followed by 'up', 'down', 'left' or 'right'.");
                System.out.println("Read - Followed by whatever readable object is near you - 'Sign', for example");
                System.out.println("Talk - Followed by the name of a person in your close proximity.");
                System.out.println("Quit - Exit the game and do something completely different");
                if (myPokemon != null) {
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
                try {
                    if (commandParts.length == 2) {
                        inPokemonStats(commandParts[1]);
                        checkMyPokemon(commandParts[1]);
                    }
                } catch (NullPointerException e) {
                }
            }

//          Choose a Pokémon and prevent user from switching Pokémon once the choice has been made
            if (action.equalsIgnoreCase("Choose")) {
                if (commandParts.length == 2 && row == 2 && col == 1 && myPokemon == null) {
                    inChoosePokemon(commandParts[1]);
                } else if (commandParts.length == 2 && row == 2 && col == 1) {
                    System.out.println("You're not trying to abandon " + myPokemon.name + " are you?");
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

    private int criticalCheck() {
        int upperInt = 10;
        int lowerInt = 1;
        int criticalHit = 0;
        int criticalRange = (upperInt - lowerInt) + 1;
        int random = (int) (Math.random() * criticalRange) + lowerInt;
        if (random == 1) {
            myPokemon.attackPower = myPokemon.attackPower * 2;
            System.out.println("Critical hit!");
        }
        criticalHit = myPokemon.attackPower;
        return criticalHit;

    }

    private void initializeBattle() {
        getMap();
//        myPokemon = myPokemonInBattle;
//        rivalPokemon = opponentPokemonInBattle;


        boolean superEffective;
        boolean notVeryEffective;
        String attack;


        System.out.println("You've engaged in a battle with " + map[row][col].getHuman().name);
        System.out.println("\n" + "You sent out " + myPokemon.name);
        System.out.println("\n" + map[row][col].getHuman().name + " sent out " + rivalPokemon.name);

        if (myPokemon.speed >= rivalPokemon.speed) {
            System.out.println(myPokemon.name + " is faster and gets to attack first!");
        } else {
            System.out.println(rivalPokemon.name + " is faster and gets to attack first!");
        }

        battle = true;
        while (battle) {
            System.out.println("Your Pokémon: " + myPokemon.name + "\nHP: " + myPokemon.baseHP);
            System.out.println("-----------------------------");
            System.out.println("Opponent Pokémon " + rivalPokemon.name + "\nHP: " + rivalPokemon.baseHP);
            System.out.println("-----------------------------");
            System.out.println("What attacking move will " + myPokemon.name + " use?");
            System.out.println("> " + myPokemon.getMove1().attackName);
            System.out.println("> " + myPokemon.getMove2().attackName);
            System.out.println("> " + myPokemon.getMove3().attackName);

            readBattleInput();

            checkWinner();

        }
    }


    private void checkWinner() {
        if (rivalPokemon.baseHP <= 0) {
            System.out.println("You defeated " + rival.name);
            battle = false;
        }
        if (myPokemon.baseHP <= 0) {
            System.out.println("You lost to " + rival.name);
            battle = false;
        }
    }


//    Type what attack to use

    private void readBattleInput() {
        String attack = input.nextLine();

        if (attack.equalsIgnoreCase(myPokemon.move1.attackName)) {
            System.out.println(myPokemon.name + " used " + myPokemon.move1.attackName);
            if (myPokemon.move1.attackName.equals("Growl")) {
                rivalPokemon.attackPower = rivalPokemon.attackPower - myPokemon.move1.attackNerf;
                System.out.println(rivalPokemon.name + "'s attack power was lowered!");
            }
            if (myPokemon.move1.attackName.equals("Growth")) {
                myPokemon.attackPower = myPokemon.attackPower + myPokemon.move1.attackBoost;
                System.out.println(myPokemon.name + "'s attack power was increased!");
            } else if (myPokemon.move1.damage != 0) {
                criticalCheck();
                int damage = myPokemon.attackPower + myPokemon.move1.damage;
                rivalPokemon.baseHP = rivalPokemon.baseHP - damage;
                System.out.println("It did " + damage + " damage");
            }
        }

        if (attack.equalsIgnoreCase(myPokemon.move2.attackName)) {
            System.out.println(myPokemon.name + " used " + myPokemon.move2.attackName);
            if (myPokemon.move2.attackName.equals("Growl")) {
                rivalPokemon.attackPower = rivalPokemon.attackPower - myPokemon.move2.attackNerf;
                System.out.println(rivalPokemon.name + "'s attack power was lowered!");
            }
            if (myPokemon.move2.attackName.equals("Growth")) {
                myPokemon.attackPower = myPokemon.attackPower + myPokemon.move2.attackBoost;
                System.out.println(myPokemon.name + "'s attack power was increased!");
            } else if (myPokemon.move2.damage != 0) {
                criticalCheck();
                int damage = myPokemon.attackPower + myPokemon.move2.damage;
                rivalPokemon.baseHP = rivalPokemon.baseHP - damage;
                System.out.println("It did " + damage + " damage");
            }
        }
        if (attack.equalsIgnoreCase(myPokemon.move3.attackName)) {
            System.out.println(myPokemon.name + " used " + myPokemon.move3.attackName);
            if (myPokemon.move3.attackName.equals("Growl")) {
                rivalPokemon.attackPower = rivalPokemon.attackPower - myPokemon.move3.attackNerf;
                System.out.println(rivalPokemon.name + "'s attack power was lowered!");
            }
            if (myPokemon.move3.attackName.equals("Growth")) {
                myPokemon.attackPower = myPokemon.attackPower + myPokemon.move3.attackBoost;
                System.out.println(myPokemon.name + "'s attack power was increased!");
            } else if (myPokemon.move3.damage != 0) {
                criticalCheck();
                int damage = myPokemon.attackPower + myPokemon.move3.damage;
                rivalPokemon.baseHP = rivalPokemon.baseHP - damage;
                System.out.println("It did " + damage + " damage");
            }
        }
    }


        private String[] readInput () {
            System.out.println("\n" + "What now?");
            String command = input.nextLine();
            return command.split(" ");
        }

        private void inChoosePokemon (String iChooseYou){
            if (iChooseYou.equalsIgnoreCase("Bulbasaur")) {
                myPokemon = oaksLab.getPokemon();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon5());
                System.out.println("You chose Bulbasaur as your companion! It will react to Buddy.");
            }
            if (iChooseYou.equalsIgnoreCase("Charmander")) {
                myPokemon = oaksLab.getPokemon2();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon6());
                System.out.println("You chose Charmander as your companion! It will react to Buddy.");
            }
            if (iChooseYou.equalsIgnoreCase("Squirtle")) {
                myPokemon = oaksLab.getPokemon3();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon4());
                System.out.println("You chose Squirtle as your companion! It will react to Buddy.");
            }
            if (iChooseYou.equalsIgnoreCase("Oddish")) {
                myPokemon = oaksLab.getPokemon4();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon2());
                System.out.println("You chose Oddish as your companion! It will react to Buddy.");
            }
            if (iChooseYou.equalsIgnoreCase("Growlithe")) {
                myPokemon = oaksLab.getPokemon5();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon3());
                System.out.println("You chose Growlithe as your companion! It will react to Buddy.");
            }
            if (iChooseYou.equalsIgnoreCase("Tentacool")) {
                myPokemon = oaksLab.getPokemon6();
                trainer = true;
                chosenPokemon = true;
                rivalPokemon = (oaksLab.getPokemon());
                System.out.println("You chose Tentacool as your companion! It will react to Buddy.");
            }
        }

        private void readDirection (String direction){
            if (direction.equalsIgnoreCase("up")) {
                row--;
                if (row < 0) {
                    System.out.println("Believe it or not, you've reached the edge of the world");
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
                    System.out.println("Believe it or not, you've reached the edge of the world");
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
                    System.out.println("Believe it or not, you've reached the edge of the world");
                    col--;
                }
                if (row == 1 && col == 1) {
                    col--;
                    System.out.println("The road is blocked");
                }
                if (row == 0 && col == 1 && !trainer) {
                    col--;
                    playSfx(hey);
                    System.out.println("Someone's voice: HEY!! \nDon't go in there without a Pokémon! That dude's a looney!");
                }
                if (row == 0 && col == 1 && trainer) {
                    System.out.println("-" + rivalsPlace.getHuman().message);
                    System.out.println("\nYou've encountered " + rivalsPlace.getHuman().name + "\nTheir Pokémon is " + rivalPokemon.name +
                            "\nYour " + myPokemon.name + " seems eager to battle" + "\nBattle or Run?");
                    switch (input.nextLine().toLowerCase(Locale.ROOT)) {
                        case "battle" -> initializeBattle();
                        case "run" -> {
                            playSfx(runAway);
                            System.out.println("\nYou ran home in tears. Unsettled by your unstable mental state, " + myPokemon.name + " ran after you and consoled you.");
                            row = 2;
                            col = 0;
                        }
                    }
                }
            }
            if (direction.equalsIgnoreCase("left")) {
                col--;
                if (col < 0) {
                    System.out.println("Believe it or not, you've reached the edge of the world");
                    col++;
                }
                if (row == 1 && col == 1) {
                    col++;
                    System.out.println("The road is blocked");
                }
            }
        }

//  Print stats and moves for each Pokémon in the lab
        private void inPokemonStats (String readStats){
            if (readStats.equalsIgnoreCase("Bulbasaur")) {
                try {
                    System.out.println("\nName:" + map[row][col].getPokemon().getName());
                    System.out.println("Hp:" + map[row][col].getPokemon().getBaseHP());
                    System.out.println("Attackpower:" + map[row][col].getPokemon().getAttackPower());
                    System.out.println("Speed:" + map[row][col].getPokemon().getSpeed());
                    System.out.println("Accuracy:" + map[row][col].getPokemon().getAccuracy());
                    System.out.println("Type:" + map[row][col].getPokemon().getType());
                    System.out.println();
                    System.out.println("Move 1: " + map[row][col].getPokemon().getMove1().attackName);
                    System.out.println("Move 2: " + map[row][col].getPokemon().getMove2().attackName);
                    System.out.println("Move 3: " + map[row][col].getPokemon().getMove3().attackName);
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
                    System.out.println("Move 1: " + map[row][col].getPokemon2().getMove1().attackName);
                    System.out.println("Move 2: " + map[row][col].getPokemon2().getMove2().attackName);
                    System.out.println("Move 3: " + map[row][col].getPokemon2().getMove3().attackName);
                } catch (NullPointerException e) {
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
                } catch (NullPointerException e) {
                    System.out.println("You can only check out Pokémon at Prof. Oak's lab. The professor has all the answers");
                }
            }
        }

        private void inRead (String readSign){
            if (readSign.equalsIgnoreCase("Sign")) {
                try {
                    String read = map[row][col].getSignMessage();
                    System.out.println("\nThe sign reads: \n" + read);
                } catch (NullPointerException e) {
                    System.out.println("\nThere are clearly no signs here. Am I seeing things?");
                }
            }
        }

        private void inTalk (String talkTo){
            if (talkTo.equalsIgnoreCase("Oak")) {
                if (map[row][col].getHuman() == professorOak) {
                    String oakSays = professorOak.message;
                    System.out.println("\n -" + oakSays + "\n");
                    System.out.println(Arrays.deepToString(professorOak.pokemonList));
                } else {
                    System.out.println("\nHmm.. the professor must be somewhere else. Where could he be?");
                }
            }
            if (talkTo.equalsIgnoreCase("Rival")) {
                if (map[row][col].getHuman() == rival) {
                    String rivalSays = rival.message;
                    System.out.println("\n -" + rivalSays);
                } else {
                    System.out.println("\nThe taunting voice of your rival has been so daunting over the years, it's almost as if you can hear it " +
                            "in the air around you.. \nWhich is strange, since he's not even here. Am i losing it?");
                }
            }
            if (talkTo.equalsIgnoreCase("Myself")) {
                System.out.println("Thoughts are the shadows of our feelings - always darker, emptier and simpler.");
            }
        }

//  Print stats and moves for your buddy
        private void checkMyPokemon (String checkBuddyStats){
            if (checkBuddyStats.equalsIgnoreCase("Buddy")) {
                try {
                    System.out.println("Name: " + myPokemon.getName());
                    System.out.println("Hp: " + myPokemon.getBaseHP());
                    System.out.println("Attackpower :" + myPokemon.getAttackPower());
                    System.out.println("Speed " + myPokemon.getSpeed());
                    System.out.println("Accuracy " + myPokemon.getAccuracy());
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

//  Calls the pet method which increases some of the buddy Pokémon's stats
        private void inPetBuddy (String petBuddy){
            if (petBuddy.equalsIgnoreCase("Buddy")) {
                myPokemon.pet();
                playSfx(petSound);
            }
        }

        private void playSfx (File sound){
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(sound));
                clip.start();
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
