
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testClass {
//  Test and compare constructors and values
    Pokemon gengar = new Pokemon();
    Pokemon nidorino = new Pokemon();
    Humans mikael = new Humans("Mikael", "That's my name", nidorino, null, true);
    Humans olle = new Humans("Olle", null ,gengar, null, false);
    Sign sign = new Sign("a very real message");
    Location lavender = new Location("Lavender Town", "A hauntingly beautiful town");


    @Test
    public void testLocationDescription() {
        String result = lavender.getDescription();
        assertSame(result, "A hauntingly beautiful town");
    }

    @Test
    public void testSignMessage() {
        String message = sign.getMessage();
        Assertions.assertEquals(message, "a very real message");
    }
    @Test
    public void testIsMikaelTrainer() {
        boolean trainer = mikael.trainer;
        assertTrue(trainer);
    }
    @Test
    public void testDoesMikaelHavePokemon() {
        Object pokemon = mikael.pokemon;
        assertSame(nidorino, pokemon);
    }
    @Test
    public void testComparePokemonList() {
        assertSame(olle.pokemonList, mikael.pokemonList);
    }

    @Test
    public void testCompareTrainer() {
        boolean compare = olle.trainer;
        assertFalse(compare);
    }
    @Test
    public void testComparePokemon() {
        assertNotSame(gengar, mikael.pokemon);
    }
}
