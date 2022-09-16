package entity.counter;

import logic.Player;

public class Crate extends Counter {
    private String myIngredient;

    public Crate(String s) {
        super(s + " Crate");
        myIngredient = s;
    }

    public void interact(Player p) {
        if (!p.isHandEmpty() || ) {

        }
    }

    public String getMyIngredient() {
        return this.myIngredient;
    }

    public void setMyIngredient(String myIngredient) {
        this.myIngredient = myIngredient;
    }

}
