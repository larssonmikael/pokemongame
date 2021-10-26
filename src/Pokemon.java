
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


}
