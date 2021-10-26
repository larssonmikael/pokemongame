import java.security.PublicKey;

public class Pokemon {

    int baseHP;
    int attackPower;
    int level;
    String[] moves;
    int accuracy;
    public void stats(int level, int attackPower, int Hp, int accuracy) {

    }
    public void attack(){
        attackPower = level * 15;
        System.out.println("attacked!");
    }
    public void pet() {
        System.out.println("You petted the Pokémon");
    }

}
