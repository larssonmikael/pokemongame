
public class Pokemon {

    int baseHP;
    int attackPower;
    int level;
    String[] moves;
    int accuracy;

    public void stats(int baseHP, int attackPower, int level, int accuracy, String[] moves){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.level = level;
        this.accuracy = accuracy;
        this.moves = moves;
    }


    public void attack(){
        attackPower = level * 15;
        System.out.println("attacked!");
    }
    public void pet() {
        System.out.println("You petted the Pokémon");
    }

}
