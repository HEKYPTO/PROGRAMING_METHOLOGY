package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {

    public int dirty;

    public Dish() {
        super("Dish", 4);
        dirty = 0;
    }

    public Dish(int dirty) {
        super("Dish", 4);
        setDirty(dirty);
    }

    public boolean isDirty() {
        return dirty > 0;
    }

    @Override
    public boolean verifyContent(Ingredient i) {
        return !isDirty() && i.isEdible();
    }

    public void setDirty(int dirty) {
        this.dirty = Math.max(dirty, 0);
        if (dirty > 0) {
            setName("Dirty Dish");
        } else {
            setName("Dish");
        }
    }

    public void clean(int amount) {
        setDirty(dirty - amount);
    }

    public String toString() {
        if (isDirty()) {
            return StringUtil.formatNamePercentage(getName(), dirty);
        } else {
            return super.toString();
        }
    }

    public int getDirty() {
        return dirty;
    }
}
