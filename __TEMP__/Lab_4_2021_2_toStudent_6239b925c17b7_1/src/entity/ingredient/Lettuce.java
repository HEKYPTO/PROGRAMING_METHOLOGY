package entity.ingredient;

import entity.base.Ingredient;

public class Lettuce extends Ingredient {
    private boolean chopState;

    public Lettuce() {
        super("Lettuce");
        this.chopState = false; 
        setEdible(true);
    }

    public void chop() {
        if (!chopState) {
            chopState = true;
            setName("Chopped Lettuce");
        }
    }

    public boolean isChopped() {
        return chopState;
    }
}