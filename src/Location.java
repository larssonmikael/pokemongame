import java.util.stream.Stream;

public class Location {

    private String name;
    private String description;
    private Sign sign;
    private Pokemon pokemon;




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
        try {
            return sign.message;
        } catch (NullPointerException e){
            System.out.println("There are no signs at this place");
        } return "";
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
}
