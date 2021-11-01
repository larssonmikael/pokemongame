import java.util.stream.Stream;

public class Location {

    private String name;
    private String description;
    private Sign sign;
    private Humans human;
    private Pokemon pokemon;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private Pokemon pokemon5;
    private Pokemon pokemon6;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public String locationToString() {
        String location = "\nYou are in " + getName() + ". ";
        location = location + getDescription();
        return location;
    }
    public String statsToString() {
        String stats = "\n Hp:" + getPokemon().getBaseHP();
        stats = stats + "\n Attack:" + getPokemon().getAttackPower();
        stats = stats + "\n Accuracy:" + getPokemon().getAccuracy();
        stats = stats + "\n Speed:" + getPokemon().getSpeed();
        stats = stats + "\n Type:" + getPokemon().getType();
        return stats;
    }
    public String signToString(){
            return sign.message;
    }
    public String talkToString() {
        try {
            return human.message;
        } catch (NullPointerException e){
            System.out.println("However much you talk when you're alone, nobody will answer but you" + "\n" + "- The Dalai Lama");
        }
        return "";
    }



    public String getSignMessage() {
        return sign.message;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
    public Pokemon getPokemon2() {return pokemon2;}
    public Pokemon getPokemon3() {
        return pokemon3;
    }
    public Pokemon getPokemon4() {return pokemon4;}
    public Pokemon getPokemon5() {
        return pokemon5;
    }
    public Pokemon getPokemon6() {return pokemon6;}

    public void setPokemon (Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public void setPokemon2 (Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }
    public void setPokemon3 (Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }
    public void setPokemon4 (Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }
    public void setPokemon5 (Pokemon pokemon5) {
        this.pokemon5 = pokemon5;
    }
    public void setPokemon6 (Pokemon pokemon6) {
        this.pokemon6 = pokemon6;
    }


    public void setHuman(Humans human) {
        this.human = human;
    }

    public Humans getHuman() {
        return human;
    }


}
