
public class Pokemon {

    int baseHP;
    int attackPower;
    int speed;
    move move1;
    move move2;
    move move3;
    int accuracy;
    String type;

//Defense?

    // Konstruktor för stats. Unika för varje Pokemon
    public void stats(int baseHP, int attackPower, int speed, int accuracy, String type){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.type = type;
    }

    //Getters och setters för attacker

    public void setMove1 (move move1) {
        this.move1 = move1;
    }
    public void setMove2 (move move2) {
        this.move2 = move2;
    }
    public void setMove3 (move move3) {
        this.move3 = move3;
    }

    public move getMove1 (move move1) {
        return this.move1;
    }
    public move getMove2 (move move2) {
        return this.move2;
    }
    public move getMove3 (move move2) {
        return this.move3;
    }



//    public void attack(String ins){
//        attackPower = 1;
//        System.out.println("attacked!");
//    }
    public int pet() {
            baseHP++;
            System.out.println("You petted the Pokémon. It seems a little healthier.");
//            System.out.println("You petted the Pokémon. Hmm.. It doesn't seem to care.");
        return baseHP;
    }

    public void init(){
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
    }



}
