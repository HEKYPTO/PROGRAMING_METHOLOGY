package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock {
    private int damageOverTime;


    public PoisonRock(int damage, int damageOverTime) {
        super(damage);
        setDamageOverTime(damageOverTime);
    }

    public int getDamageOverTime() {
        return this.damageOverTime;
    }

    public void setDamageOverTime(int damageOverTime) {
        this.damageOverTime = damageOverTime < 0 ? 0: damageOverTime;
    }

    public int dealDamage(Zombie zombie) {
        zombie.setDecay(zombie.getDecay() + damageOverTime);

        if (zombie.getDefense() >= damage)
            return 0;

        zombie.setHealth(zombie.getHealth() - damage + zombie.getDefense());
        return damage - zombie.getDefense();
    }
    
    public String toString() {
        return "Poison Rock (" + getDamage() + ", DoT = " + getDamageOverTime() + ")";
    }
}
