package logic;

import java.util.ArrayList;

public class UnitDeck {
	
	//Fields
	private ArrayList<CardCounter> cardsInDeck = new ArrayList<CardCounter>();
	private String deckName = "";
	
	//Constructor
	public UnitDeck(String deckName) {
		setDeckName(deckName);
		setCardsInDeck(cardsInDeck);
	}
	
	//Setter
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName.isBlank() ? "Untitled Deck": deckName;
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
		if (cardsInDeck == null) {
			cardsInDeck = new ArrayList<>();
		}
		if (count > 0) {
			for (CardCounter card: cardsInDeck) {
				if (card.getCard().equals(newCard)) {
					card.setCount(card.getCount() + count);
					return;
				}
			}
			cardsInDeck.add(new CardCounter(newCard, count));
		}		
	}
	public void removeCard(UnitCard toRemove, int count) {
		if (count <= 0) {
			return;
		}
		for (CardCounter card: cardsInDeck) {
			if (card.getCard().equals(toRemove)) {
				card.setCount(card.getCount() - count);
			}
			if (card.getCount() <= 0) {
				cardsInDeck.remove(card);
				return;
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
		if (cardsInDeck == null) {
			cardsInDeck = new ArrayList<>();
		}
		for (CardCounter element: cardsInDeck) {
			if (element.getCard().equals(card)) {
				return true;
			}
		}
		return false;
	}
	public boolean equals(UnitDeck other) {
		return deckName.equals(other.deckName);
	}
}