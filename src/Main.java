public class Main {
    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon();
        Pokemon growlithe = new Pokemon();
        Pokemon tentacool = new Pokemon();

        pikachu.stats(85, 16, 15, 85, pikachu.moves);
        tentacool.stats(93, 13, 18, 90, tentacool.moves);
        growlithe.stats(68, 93, 15, 95, growlithe.moves);

        tentacool.pet();
        growlithe.attack();
        pikachu.attack();

    }
}
