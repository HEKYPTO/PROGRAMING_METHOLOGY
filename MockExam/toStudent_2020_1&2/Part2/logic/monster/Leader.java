package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster {
    private int maxChargeTurns;
    private int currentChargeTurns;
    private boolean isGuard = false;


    public Leader(String name, int hp, int def, int sp_def, Attack attack, int chargeTurns) {
        super(name, hp, def, sp_def, attack);
        setMaxChargeTurns(chargeTurns);
        setCurrentChargeTurns(0);
	}

    public int getMaxChargeTurns() {
        return this.maxChargeTurns;
    }

    public void setMaxChargeTurns(int maxChargeTurns) {
        this.maxChargeTurns = maxChargeTurns;
    }

    public int getCurrentChargeTurns() {
        return this.currentChargeTurns;
    }

    public void setCurrentChargeTurns(int currentChargeTurns) {
        this.currentChargeTurns = currentChargeTurns < 0 ? 0: currentChargeTurns > maxChargeTurns ? maxChargeTurns: currentChargeTurns;
    }

    public boolean isGuard() {
        return this.isGuard;
    }

    public void setGuard(boolean isGuard) {
        this.isGuard = isGuard;
    }

    public boolean isReady() {return currentChargeTurns >= maxChargeTurns;}

    public int takeDamage(Attack attack) {
        if (isGuard) return 0;

        int health = 0;
        if (attack.isLeader()) {
            health = getHp() - attack.calculateDamage(this);
        } else {
            health = (int) (getHp() - Math.ceil(attack.calculateDamage(this) * 0.5));
        }
        
        if (health < 0)
            isDead = true;
        setHp(health);

        if (attack.isLeader()) {
            return attack.calculateDamage(this);
        } else {
            return (int) Math.ceil(attack.calculateDamage(this) * 0.5);
        }
    }
}
