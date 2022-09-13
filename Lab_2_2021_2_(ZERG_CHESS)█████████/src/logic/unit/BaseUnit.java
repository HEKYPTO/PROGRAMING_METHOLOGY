package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    private int hp;
    private int power;
    private boolean isFlying;

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
        setColumn(startColumn);
        setRow(startRow);
        setWhite(isWhite);
        setName(name);
        setHp(2);
        isFlying(false);
        setPower(1);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = (row > 0 ? (row > 4 ? 4: row) : 0);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = (column > 0 ? (column > 4 ? 4: column) : 0);
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void isFlying(Boolean isFlying) {
        this.isFlying = isFlying;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public boolean move(int direction) {
        switch(direction) {
            case 0:
                if (this.getRow() + 1 <= 4) {this.setRow(this.getRow() + 1); return true;} 
                else return false;
            case 1:
                if (this.getColumn() + 1 <= 4) {this.setColumn(this.getColumn() + 1); return true;}
                else return false;
            case 2:
                if (this.getRow() - 1 >= 0) {this.setRow(this.getRow() - 1); return true;} 
                else return false;
            case 3:
                if (this.getColumn() - 1 >= 0) {this.setColumn(this.getColumn() - 1); return true;}
                else return false;
            default:
                return false;
        }
    }

    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit enemy: targetPieces) {
            if (!enemy.isFlying() && getColumn() == enemy.getColumn() && getRow() == enemy.getRow()) {
                System.out.println(this.getName() + " attacks " + enemy.getName());
                enemy.setHp(enemy.getHp() - this.getPower());
            }
        }
    }
}