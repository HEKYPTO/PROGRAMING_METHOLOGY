package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

    public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        setHp(2);
    }

    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit enemy: targetPieces) {
            if (this.isWhite() && this.getRow() + 1 == enemy.getRow() && this.getColumn() == enemy.getColumn()) {
                System.out.println(this.getName() + " attacks " + enemy.getName());
                enemy.setHp(enemy.getHp() - this.getPower());
            } 

            if (!this.isWhite() && this.getRow() - 1 == enemy.getRow() && this.getColumn() == enemy.getColumn()) {
                System.out.println(this.getName() + " attacks " + enemy.getName());
                enemy.setHp(enemy.getHp() - this.getPower());
            } 
        }
    }
}
