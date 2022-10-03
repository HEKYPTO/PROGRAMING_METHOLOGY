package logic;

public class Item {
    private String name;
    private int pricePerPiece;

    public Item(String name, int pricePerPiece) {
        this.name = name;
        setPricePerPiece(pricePerPiece);
    }

    public void setPricePerPiece(int pricePerPiece) {
        this.pricePerPiece = pricePerPiece < 1 ? 1: pricePerPiece;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerPiece() {
        return this.pricePerPiece;
    } 

}
