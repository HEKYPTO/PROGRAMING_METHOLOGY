package logic;

import java.util.ArrayList;

public class UnitDeck {
	
	//Fields
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName = "";
	
	//Constructor
	public UnitDeck(String deckName) {
		cardsInDeck = new ArrayList<CardCounter>();
		this.deckName = deckName;
	}
	
	//Setter
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	//Getter
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
	public String getDeckName() {
		return deckName;
	}
	
	//Method
	public void addCard(UnitCard newCard, int count) {
		for (CardCounter card: cardsInDeck) {
			if (card.getCard().equals(newCard)) {
				card.setCount(card.getCount() + count);
				return;
			}
		}
		cardsInDeck.add(new CardCounter(newCard, count));
	}
	public void removeCard(UnitCard toRemove, int count) {
		for (CardCounter card: cardsInDeck) {
			if (card.getCard().equals(toRemove)) {
				card.setCount(card.getCount() - count);
			}
			if (card.getCount() == 0) {
				cardsInDeck.remove(card);
			}
		}
	}
	public int cardCount() {
		int count = 0;
		for (CardCounter card: cardsInDeck) {
			count += card.getCount();
		}
		return count;
	}
	public boolean existsInDeck(UnitCard card) {
		for (CardCounter element: cardsInDeck) {
			if (element.getCount() > 0) {
				return true;
			}
		}
		return false;
	}
	public boolean equals(UnitDeck other) {
		if (this.deckName.equals(other.deckName)) {
			return true;
		}
		return false;
	}
}
