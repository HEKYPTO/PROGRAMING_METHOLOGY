package logic;

public class Fighter extends Piece {
    private boolean promoted;
    private PositionList promotedMovedPositions;


    public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
        super(initialPositionX, initialPositionY, reverse, name);
        promotedMovedPositions = new PositionList();

        movePositions.add(new Position(-1, 2));
        movePositions.add(new Position(1, 2));

        promotedMovedPositions.add(new Position(0, 2));
        promotedMovedPositions.add(new Position(1, 0));
        promotedMovedPositions.add(new Position(0, -2));
        promotedMovedPositions.add(new Position(-1, 0));
        if (isReverse()) {
            for (Position p: movePositions) {
                p.reverse();
            }
            for (Position p: promotedMovedPositions) {
                p.reverse();
            }
        }

        promoted = false;
    }   

    @Override
    public void move(int movePattern) {
        Position pos;
        if (!promoted) {
            pos = getCurrentPosition().addPositionValue(getMovePositions().get(movePattern));

        } else {
            pos = getCurrentPosition().addPositionValue(getPromotedMovePositions().get(movePattern));
        }
        pos.normalizedPosition();
        setCurrentPosition(pos);
    }

    @Override
    public Position attackTargetPosition(int actionPattern) {
        Position pos= this.currentPosition.addPositionValue(getMovePositions().get(actionPattern));
        pos.normalizedPosition();
        setCurrentPosition(pos);
        return pos;
    }

    public boolean isPromoted() {
        return this.promoted;
    }

    public boolean getPromoted() {
        return this.promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public PositionList getPromotedMovePositions() {
        return this.promotedMovedPositions;
    }

    public void setPromotedMovedPositions(PositionList promotedMovedPositions) {
        this.promotedMovedPositions = promotedMovedPositions;
    }

}
