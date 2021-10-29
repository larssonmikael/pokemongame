public class Humans {

    String message;
    int pokemonParty;
    Pokemon pokemon;
    boolean trainer;

    public Humans(String message, int pokemonParty, Pokemon pokemon, boolean trainer){
        this.message = message;
        this.pokemonParty = pokemonParty;
        this.pokemon = pokemon;
        this.trainer = trainer;
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
}
