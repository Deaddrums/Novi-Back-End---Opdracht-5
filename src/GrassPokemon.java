import java.util.Arrays;
import java.util.List;

//In de pokemonGymImpl staat leaveblade ipv leafblade, omdat wij de code niet mogen aanpassen heb ik de foute term aangehouden//

public class GrassPokemon extends Pokemon {

    private final String type = "grass";

    private final List<String> attacks = Arrays.asList(
            "leafStorm",
            "solarBeam",
            "leechSeed",
            "leaveBlade"
    );

    public GrassPokemon(
            String name,
            int level,
            int hp,
            String food,
            String sound
    ) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return type;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public void leafStorm(Pokemon attacker, Pokemon enemy) {
        performGrassAttack(attacker, enemy, "leafStorm");
    }

    public void solarBeam(Pokemon attacker, Pokemon enemy) {
        performGrassAttack(attacker, enemy, "solarBeam");
    }

    public void leaveBlade(Pokemon attacker, Pokemon enemy) {
        performGrassAttack(attacker, enemy, "leaveBlade");
    }

    public void leechSeed(Pokemon attacker, Pokemon enemy) {
        System.out.println(
                attacker.getName()
                        + " attacks "
                        + enemy.getName()
                        + " with leechSeed"
        );

        int stolenHp = calculateGrassDamage(enemy);

        enemy.setHp(enemy.getHp() - stolenHp);
        attacker.setHp(attacker.getHp() + stolenHp);

        System.out.println(
                enemy.getName()
                        + " loses "
                        + stolenHp
                        + " hp"
        );

        System.out.println(
                attacker.getName()
                        + " receives "
                        + stolenHp
                        + " hp"
        );

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private void performGrassAttack(
            Pokemon attacker,
            Pokemon enemy,
            String attackName
    ) {
        System.out.println(
                attacker.getName()
                        + " attacks "
                        + enemy.getName()
                        + " with "
                        + attackName
        );

        int damage = calculateGrassDamage(enemy);
        enemy.setHp(enemy.getHp() - damage);

        System.out.println(
                enemy.getName()
                        + " loses "
                        + damage
                        + " hp"
        );

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private int calculateGrassDamage(Pokemon enemy) {
        return switch (enemy.getType()) {
            case "electric" -> 20;
            case "fire" -> 15;
            case "water" -> 10;
            default -> 5;
        };
    }
}