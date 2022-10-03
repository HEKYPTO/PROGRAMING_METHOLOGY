package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import entity.ingredient.Meat;
import entity.ingredient.Egg;

public class Pan extends Container {

    public Pan() {
        super("Pan", 1);
    }

    @Override
    public boolean verifyContent(Ingredient i) {
        return (i instanceof Meat || i instanceof Egg); 
    }

    public void cook() {
        if (!isEmpty()) {
            for (Ingredient i : getContent()) {
                if (verifyContent(i)) {
                    if (i instanceof Meat) {
                        Meat m = (Meat) i;
                        m.cook();
                    } else if (i instanceof Egg) {
                        Egg e = (Egg) i;
                        e.cook();
                    }
                }
            }
        }
    }
}
