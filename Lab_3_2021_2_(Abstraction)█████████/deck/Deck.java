package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList;
	
	public Deck(String name, Card[] deckList) {
		setName(name);
		setDeckList(deckList);
		setDeckSize(deckList.length);		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeckSize() {
		return this.deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public Card[] getDeckList() {
		return this.deckList;
	}

	public void setDeckList(Card[] deckList) {
		this.deckList = deckList;
	}

	//You CAN modify the first line
		public int insertCard(Card card) throws InsertCardFailedException {
			int count = 0;
			for (Card x: deckList) if (card.equals(x)) count++;

			if(count >= 4) 
				throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
			//FILL CODE HERE
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
			//Must return new deckSize
			else {
				Card[] newDeck = Arrays.copyOf(deckList, deckSize + 1);
				newDeck[deckSize] = card;
				setDeckList(newDeck);
				setDeckSize(newDeck.length);
				return newDeck.length;
			}
		}


		//You CAN modify the first line
		public Card removeCard(int slotNumber) throws RemoveCardFailedException {
			if (this.deckList.length <= slotNumber) {
				throw new RemoveCardFailedException("Number you insert exceed deck size");
			}		
			if (this.deckList[slotNumber] == null) {
				throw new RemoveCardFailedException("There is no card in that slot");
			}
			//FILL CODE HERE
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
			//Once card is removed, other card down the list must rearrange to the empty slot
			//Must return card that was removed
			
			Card card = deckList[slotNumber];
			Card[] newArray = Arrays.copyOf(deckList, deckSize - 1);
			System.arraycopy(deckList, 0, newArray, 0, slotNumber);
			if (deckSize - slotNumber - 1 >= 0) System.arraycopy(deckList, slotNumber + 1, newArray, slotNumber, newArray.length - slotNumber - 1);
			setDeckList(newArray);
			setDeckSize(deckSize - 1);
			return card;
		}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}

	/* GETTERS & SETTERS */

}
