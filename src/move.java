public class move {
    String attackName;
    String type;
    int damage;
    int defenseNerf;
    int attackNerf;


    public move(String attackName, String type, int damage, int defenseNerf, int attackNerf){
        this.attackName = attackName;
        this.damage = damage;
        this.defenseNerf = defenseNerf;
        this.attackNerf = attackNerf;
        this.type = type;
    }

    move tackle = new move("Tackle", "Normal", 10,0,0);
    move leer = new move("Leer", "Normal", 0,20,0);
    move waterGun = new move("Water Gun", "Water", 20, 0, 0);
    move ember = new move("Ember", "Fire", 20, 0, 0);
    move growl = new move("Growl", "Normal", 0, 0,20);
}
