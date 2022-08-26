package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	//Constructors
	public CardCounter(UnitCard card, int count) {
		this.card = card;
		this.count = count;
	}
	
	//Methods
	//setter
	public void setCount(int count) {
		this.count = (count < 0) ? 0: count;
	}
	public void setCard(UnitCard card) {
		this.card = card;
	}
	//getter
	public int getCount() {
		return count;
	}
	public UnitCard getCard() {
		return card;
	}
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

}
