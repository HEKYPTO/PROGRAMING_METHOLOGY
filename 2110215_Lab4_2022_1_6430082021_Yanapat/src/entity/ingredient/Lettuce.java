package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
    private boolean chopState;
    public Lettuce() {
        super("Lettuce");
        setEdible(true);
        chopState = false;
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

    public void setChopState(boolean chopState) {
        this.chopState = chopState;
    }
}
