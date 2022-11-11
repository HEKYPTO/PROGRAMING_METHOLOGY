package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
    private boolean chopState;
    private int cookedPercentage;

    public Meat() {
        super("Meat");
        chopState = false;
        cookedPercentage = 0;
    }

    public void chop() {
        if (!(chopState || cookedPercentage != 0)) {
            chopState = true;
            setName("Minced Meat");
        }
    }

    public void cook() {
        if (!chopState) {
            cookedPercentage += 10;
            if (cookedPercentage <= 50) {
                setName("Raw Meat");
                setEdible(false);
            } else if (cookedPercentage <= 80) {
                setName("Medium Rare Steak");
                setEdible(true);
            } else if (cookedPercentage <= 100) {
                setName("Well Done Steak");
                setEdible(true);
            } else {
                setName("Burnt Steak");
                setEdible(false);
            }
        } else {
            cookedPercentage += 15;
            if (cookedPercentage <= 80) {
                setName("Raw Burger");
                setEdible(false);
            } else if (cookedPercentage <= 100) {
                setName("Cooked Burger");
                setEdible(true);
            } else {
                setName("Burnt Burger");
                setEdible(false);
            }
        }
    }

    public boolean isBurnt() {
        return cookedPercentage > 100;
    }

    public String toString() {
        return StringUtil.formatNamePercentage(getName(), cookedPercentage);
    }

    public boolean isChopped() {
        return chopState;
    }

    public void setChop(boolean chopState) {
        this.chopState = chopState;
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }
}

