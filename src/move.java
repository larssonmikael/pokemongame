public class move {

    String attackName;
    String type;
    int damage;
    int attackBoost;
    int attackNerf;

    public move(String attackName, String type, int damage, int attackBoost, int attackNerf){
        this.attackName = attackName;
        this.damage = damage;
        this.attackBoost = attackBoost;
        this.attackNerf = attackNerf;
        this.type = type;
    }
}
