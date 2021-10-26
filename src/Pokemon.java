
public class Pokemon {

    int baseHP;
    int attackPower;
    int speed;
//    String move1;
//    String move2;
    int accuracy;
    String type;

//Defense?

    public void stats(int baseHP, int attackPower, int speed, int accuracy, String type){
        this.baseHP = baseHP;
        this.attackPower = attackPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.type = type;
    }

    String[] moves = new String[2];



    public void attack(String ins){
        attackPower = 1;
        System.out.println("attacked!");
    }
    public int pet() {
            baseHP++;
            System.out.println("You petted the Pokémon. It seems a little healthier.");
//            System.out.println("You petted the Pokémon. Hmm.. It doesn't seem to care.");
        return baseHP;
    }


}
