package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
    protected int damage;

    public NormalRock(int damage) {
        setDamage(damage);
    }
    
    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage > 0 ? damage : 0;
    }

    public int dealDamage(Zombie zombie) {
        if (zombie.getDefense() >= damage) return 0;

        zombie.setHealth(zombie.getHealth() - damage + zombie.getDefense());
        return damage - zombie.getDefense();
    }

    public String toString() {
        return "Normal Rock (" + getDamage() + ")";
    }
}
