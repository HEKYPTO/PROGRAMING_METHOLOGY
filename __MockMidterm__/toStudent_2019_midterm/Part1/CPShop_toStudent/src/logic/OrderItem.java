package logic;

public class OrderItem {
    Item item;
    int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        this.item = item;
        setItemAmount(itemAmount);
    }

    public void increaseItemAmount(int amount) {
        itemAmount = amount > 0 ? itemAmount + amount : itemAmount;
    }

    public int calculateTotalPrice() {
        return item.getPricePerPiece() * itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount > 0 ? itemAmount : 0;
    }

    public Item getItem() {
        return this.item;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }


}
