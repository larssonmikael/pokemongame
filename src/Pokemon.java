
public class Pokemon {

    int baseHP;
    int attackPower;
    int speed;
    String[] moves;
    int accuracy;
    String type;

    public void stats(int baseHP, int attackPower, int speed, int accuracy, String[] moves, String type){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.moves = moves;
        this.type = type;
    }

    public void attack(String ins){
        attackPower = 1;
        System.out.println("attacked!");
    }
    public int pet() {
            baseHP++;
            System.out.println("You petted the Pokémon. It seems to like you more");
//            System.out.println("You petted the Pokémon. Hmm.. It doesn't seem to care.");
        return baseHP;
    }


}
