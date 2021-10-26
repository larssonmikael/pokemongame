public class move {
    String attackName;
    String type;
    int damage;
    int attackBoost;
    int attackNerf;
    String move1;
    String move2;
    String move;



    public void setAttackName(String attackName){
        this.attackName = attackName;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setDefenseNerf(int attackBoost){
        this.attackBoost = attackBoost;
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
    public int getAttackBoost(int attackBoost){
        return this.attackBoost;
    }
    public int getAttackNerf(int attackNerf){
        return this.attackNerf;
    }


    public move(String attackName, String type, int damage, int attackBoost, int attackNerf){
        this.attackName = attackName;
        this.damage = damage;
        this.attackBoost = attackBoost;
        this.attackNerf = attackNerf;
        this.type = type;
    }


//    public String[] setMoves;{
//        this.move = move;
//    }
//    public String getMoves(String move1, String move2){
//        return this.move1 + this.move2;
//    }
}
