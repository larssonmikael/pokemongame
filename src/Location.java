import java.util.stream.Stream;

public class Location {

    private String name;
    private String description;
    private Sign sign;
    private Pokemon pokemon;
    private Humans human;


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
        String location = "You are in " + getName() + ". ";
        location = location + getDescription();
        return location;
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

    public String getSign() {
        return sign.message;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setHuman(Humans human) {
        this.human = human;
    }

    public Humans getHuman() {
        return human;
    }
}
