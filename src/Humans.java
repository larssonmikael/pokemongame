public class Humans {

    String message;
    int pokemonParty;
    Pokemon pokemon;
    Pokemon pokemon2;
    boolean trainer;
    String [] pokemonList;

    public Humans(String message, int pokemonParty, Pokemon pokemon, String[] pokemonList, boolean trainer){
        this.message = message;
        this.pokemonParty = pokemonParty;
        this.pokemon = pokemon;
        this.trainer = trainer;
        this.pokemonList = pokemonList;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getPokemonParty() {
        return pokemonParty;
    }

    public void setPokemonParty(int pokemonParty) {
        this.pokemonParty = pokemonParty;
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

}
