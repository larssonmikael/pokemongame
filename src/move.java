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

    public String getAttackName(String attackName){
        return this.attackName;
    }
    public void setAttackName(String attackName){
        this.attackName = attackName;
    }

    public String getType(String type){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    public int getDamage(int damage){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getAttackBoost(int attackBoost){
        return this.attackBoost;
    }
    public void setAttackBoost(int attackBoost){
        this.attackBoost = attackBoost;
    }

    public int getAttackNerf(int attackNerf){
        return this.attackNerf;
    }
    public void setAttackNerf(int attackNerf){
        this.attackNerf = attackNerf;
    }

}
