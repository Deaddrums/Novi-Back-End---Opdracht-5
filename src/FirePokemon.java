import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {

    private final String type = "fire";

    private final List<String> attacks = Arrays.asList(
            "inferno",
            "pyroBall",
            "fireLash",
            "flameThrower"
    );

    public FirePokemon(
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

    public void inferno(Pokemon attacker, Pokemon enemy) {
        performFireAttack(attacker, enemy, "inferno");
    }

    public void pyroBall(Pokemon attacker, Pokemon enemy) {
        performFireAttack(attacker, enemy, "pyroBall");
    }

    public void fireLash(Pokemon attacker, Pokemon enemy) {
        performFireAttack(attacker, enemy, "fireLash");
    }

    public void flameThrower(Pokemon attacker, Pokemon enemy) {
        performFireAttack(attacker, enemy, "flameThrower");
    }

    private void performFireAttack(
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

        int damage;

        switch (enemy.getType()) {
            case "grass" -> damage = 20;
            case "water" -> damage = 15;
            case "electric" -> damage = 10;
            default -> damage = 5;
        }

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
}