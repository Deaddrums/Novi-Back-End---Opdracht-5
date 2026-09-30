import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {

    private final String type = "water";

    private final List<String> attacks = Arrays.asList(
            "surf",
            "hydroPump",
            "hydroCanon",
            "rainDance"
    );

    public WaterPokemon(
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

    public void surf(Pokemon attacker, Pokemon enemy) {
        performWaterAttack(attacker, enemy, "surf");
    }

    public void hydroPump(Pokemon attacker, Pokemon enemy) {
        performWaterAttack(attacker, enemy, "hydroPump");
    }

    public void hydroCanon(Pokemon attacker, Pokemon enemy) {
        performWaterAttack(attacker, enemy, "hydroCanon");
    }

    public void rainDance(Pokemon attacker, Pokemon enemy) {
        System.out.println(
                attacker.getName()
                        + " attacks "
                        + enemy.getName()
                        + " with rainDance"
        );

        if (enemy.getType().equals("electric")) {
            System.out.println(
                    "rainDance has no effect on "
                            + enemy.getName()
            );
        } else if (enemy.getType().equals("grass")) {
            int boost = 10;
            enemy.setHp(enemy.getHp() + boost);

            System.out.println(
                    enemy.getName()
                            + " receives a "
                            + boost
                            + " hp boost"
            );
        } else {
            performWaterDamage(enemy);
        }

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private void performWaterAttack(
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

        performWaterDamage(enemy);

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private void performWaterDamage(Pokemon enemy) {
        int damage;

        switch (enemy.getType()) {
            case "fire" -> damage = 20;
            case "electric" -> damage = 15;
            case "grass" -> damage = 10;
            default -> damage = 5;
        }

        enemy.setHp(enemy.getHp() - damage);

        System.out.println(
                enemy.getName()
                        + " loses "
                        + damage
                        + " hp"
        );
    }
}