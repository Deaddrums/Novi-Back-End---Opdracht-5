import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {

    private final String type = "electric";

    private final List<String> attacks = Arrays.asList(
            "thunderPunch",
            "electroBall",
            "thunder",
            "voltTackle"
    );

    public ElectricPokemon(
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

    public void thunderPunch(Pokemon attacker, Pokemon enemy) {
        performElectricAttack(attacker, enemy, "thunderPunch");
    }

    public void electroBall(Pokemon attacker, Pokemon enemy) {
        performElectricAttack(attacker, enemy, "electroBall");
    }

    public void voltTackle(Pokemon attacker, Pokemon enemy) {
        performElectricAttack(attacker, enemy, "voltTackle");
    }

    public void thunder(Pokemon attacker, Pokemon enemy) {
        System.out.println(
                attacker.getName()
                        + " attacks "
                        + enemy.getName()
                        + " with thunder"
        );

        if (enemy.getType().equals("electric")) {
            int boost = 10;
            enemy.setHp(enemy.getHp() + boost);

            System.out.println(
                    enemy.getName()
                            + " receives a "
                            + boost
                            + " hp boost"
            );
        } else {
            performElectricDamage(enemy);
        }

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private void performElectricAttack(
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

        performElectricDamage(enemy);

        System.out.println(
                enemy.getName()
                        + " has "
                        + enemy.getHp()
                        + " hp remaining"
        );
    }

    private void performElectricDamage(Pokemon enemy) {
        int damage;

        switch (enemy.getType()) {
            case "water" -> damage = 20;
            case "grass" -> damage = 15;
            case "fire" -> damage = 10;
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