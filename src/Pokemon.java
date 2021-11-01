
public class Pokemon {

    int baseHP;
    int attackPower;
    int speed;
    move move1;
    move move2;
    move move3;
    int accuracy;
    String type;
    String name;
    int[] stats;

    // Konstruktor för stats. Unika för varje Pokemon
    public String[] stats(int baseHP, int attackPower, int speed, int accuracy, String type, String name){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.type = type;
        this.name = name;
        return new String[0];
    }
    public int [] getStats(int baseHP, int attackPower, int speed, int accuracy){
        return stats(getBaseHP(), getAttackPower(), getSpeed(), getAccuracy());
    }

    private int[] stats(int baseHP, int attackPower, int speed, int accuracy) {
        return stats;
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


    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int pet() {
            baseHP++;
            System.out.println("You petted the Pokémon. It seems a little healthier.");
//            System.out.println("You petted the Pokémon. Hmm.. It doesn't seem to care.");
        return baseHP;
    }

}
