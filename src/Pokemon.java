

public class Pokemon {

    private final String name;
    private final int level;
    private final int hp;
    private final String food;
    private final String sound;

    public Pokemon(
            String name,
            int level,
            int hp,
            String food,
            String sound
    )

    {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public String getFood() {
        return food;
    }

    public String getSound() {
        return sound;
    }

    public void setHp(int hp){
        this.hp = Math.max(hp, 0);
    }

    public abstract String getType();
}
