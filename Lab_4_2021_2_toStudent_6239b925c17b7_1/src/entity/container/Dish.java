package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
    private int dirty;

    public Dish() {
        super("Dish", 4);
        setDirty(dirty);
    }

    public Dish(int dirty) {
        super("Dish", 4);
        setDirty(dirty);
    }

    public boolean isDirty() {
        return dirty > 0 ? true : false;
    }

    @Override
    public boolean verifyContent(Ingredient i) {
        return !isDirty() && i.isEdible() ? true : false;
    }

    public void setDirty(int dirty) {
        this.dirty = dirty < 0 ? 0 : dirty;
        setName(isDirty() ? "Dirty Dish" : "Dish");
    }

    public void clean(int amount) {
        dirty = dirty - amount > 0 ? dirty - amount : 0;
        setDirty(dirty);
    }

    public String toString() {
        System.out.println(dirty + " " + super.getCapacity());
        if (isDirty())
            return StringUtil.formatNamePercentage(getName(), dirty);
        else
            return super.toString();
    }

    public int getDirty() {
        return this.dirty;
    }

}
