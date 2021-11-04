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

    public String[] stats(int baseHP, int attackPower, int speed, int accuracy, String type, String name){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.type = type;
        this.name = name;
        return new String[0];
    }

    public move getMove1 () {
        return this.move1;
    }
    public move getMove2 () {
        return this.move2;
    }
    public move getMove3 () {
        return this.move3;
    }

    public void setMove1 (move move1) {
        this.move1 = move1;
    }
    public void setMove2 (move move2) {
        this.move2 = move2;
    }
    public void setMove3 (move move3) {
        this.move3 = move3;
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

//  Petting the pokemon increases some of its stats to a certain degree
    public int pet() {
        int maxSpeed = 19;
        if (speed <= maxSpeed) {
            baseHP = baseHP + 3;
            speed = speed + 1;
            System.out.println("You petted the Pokémon. It seems healthier.");
            return baseHP + speed;
        } else {
            System.out.println("You petted the Pokémon. Hmm.. It seems unaffected?");
            return baseHP + speed;
        }
    }
}
