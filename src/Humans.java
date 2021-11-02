public class Humans {

    String name;
    String message;
    Pokemon pokemon;
    Pokemon pokemon2;
    boolean trainer;
    String [] pokemonList;


    public Humans(String name, String message, Pokemon pokemon, String[] pokemonList, boolean trainer){
        this.message = message;
        this.pokemon = pokemon;
        this.trainer = trainer;
        this.pokemonList = pokemonList;

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String[] getPokemonList () {
        return pokemonList;
    }

    public void setPokemonList(String[] pokemonList) {
        this.pokemonList = pokemonList;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }
}
