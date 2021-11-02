
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testClass {
    Humans mikael = new Humans("Mikael", "That's my name", null, null, true);


    @Test
    public void testIsMikaelTrainer() {
        boolean trainer = mikael.trainer;
        assertTrue(trainer);
    }

    @Test
    public void testDoesMikaelSayThis() {
        Object pokemon = mikael.pokemon;
        assertSame(null, mikael.pokemon);
    }



    // TODO: 2021-10-31 testa att läs skylt där en skylt inte finns
    // TODO: 2021-10-31 testa att gå till roadblocken och bli tillbakastudsad
    // TODO: 2021-10-31 testa att gå utanför kartan och bli tillbakastudsad
    // TODO: 2021-10-31 testa kommandot pet på min pokemon och kolla att hp ökar med 1
    // TODO: 2021-10-31 testa att läsa in stats på din pokemon när du har den
    // TODO: 2021-11-01 nu kan jag bara gå in till rivals place med en pokemon. Testa det
    // TODO: 2021-11-02 kontrollera att rivalens pokemon är bulbasaur när jag väljer tentacool 

}
