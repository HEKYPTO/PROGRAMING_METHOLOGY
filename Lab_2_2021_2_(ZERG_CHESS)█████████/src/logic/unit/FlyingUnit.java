package logic.unit;

public class FlyingUnit extends BaseUnit {

    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        setHp(2);
        isFlying(true);
    }  

    public boolean move(int direction) {
        switch(direction) {
            case 0:
                if (this.getRow() + 2 <= 4) {this.setRow(this.getRow() + 2); return true;} 
                else return false;
            case 1:
                if (this.getColumn() + 2 <= 4) {this.setColumn(this.getColumn() + 2); return true;}
                else return false;
            case 2:
                if (this.getRow() - 2 >= 0) {this.setRow(this.getRow() - 2); return true;} 
                else return false;
            case 3:
                if (this.getColumn() - 2 >= 0) {this.setColumn(this.getColumn() - 2); return true;}
                else return false;
            default:
                return false;
        }
    }

    
}
