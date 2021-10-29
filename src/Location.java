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
    public Sign getSign() {
        return sign;
    }
    public void setSign(Sign inSign){
        sign = inSign;
    }
    public String getMessage(){
        return sign.toString();
    }



}
