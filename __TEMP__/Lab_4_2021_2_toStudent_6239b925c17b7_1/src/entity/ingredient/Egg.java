package entity.ingredient;

import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient {
    private int cookedPercentage;

    public Egg() {
        super("Egg");
        cookedPercentage = 0;
    }

    public void cook() {
        cookedPercentage += 12;

        if (cookedPercentage <= 50) {
            setName("Raw Egg");
            setEdible(false);
        } else if (cookedPercentage <= 80) {
            setName("Sunny Side Egg");
            setEdible(true);
        } else if (cookedPercentage <= 100) {
            setName("Fried Egg");
            setEdible(true);
        } else {
            setName("Burnt Egg");
            setEdible(false);
        }
    }

    public boolean isBurnt() {
        return cookedPercentage > 100 ? true : false;
    }

    public String toString() {
        return StringUtil.formatNamePercentage(getName(), cookedPercentage);
    }

    public int getCookedPercentage() {
        return this.cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

}
