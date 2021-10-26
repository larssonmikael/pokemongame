public class move {
    String attackName;
    String type;
    int damage;
    int defenseNerf;
    int attackNerf;

    public void setAttackName(String attackName){
        this.attackName = attackName;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setDefenseNerf(int defenseNerf){
        this.defenseNerf = defenseNerf;
    }
    public void setAttackNerf(int attackNerf){
        this.attackNerf = attackNerf;
    }
    public String getAttackName(String attackName){
        return this.attackName;
    }
    public String getType(String type){
        return this.type;
    }
    public int getDamage(int damage){
        return this.damage;
    }
    public int getDefenseNerf(int defenseNerf){
        return this.defenseNerf;
    }
    public int getAttackNerf(int attackNerf){
        return this.attackNerf;
    }


    public move(String attackName, String type, int damage, int defenseNerf, int attackNerf){
        this.attackName = attackName;
        this.damage = damage;
        this.defenseNerf = defenseNerf;
        this.attackNerf = attackNerf;
        this.type = type;
    }


    public String [] moves;
    {
        move tackle = new move("Tackle", "Normal", 10, 0, 0);
        move leer = new move("Leer", "Normal", 0, 20, 0);
        move waterGun = new move("Water Gun", "Water", 20, 0, 0);
        move ember = new move("Ember", "Fire", 20, 0, 0);
        move growl = new move("Growl", "Normal", 0, 0, 20);
        move vineWhip = new move("Vine Whip", "Grass", 20, 0, 0);


//        public String[] setMoves () {
//            this.move = move;
//        }
//        public static String[] getMoves () {
//            return moveList;
//    }

    }
}
