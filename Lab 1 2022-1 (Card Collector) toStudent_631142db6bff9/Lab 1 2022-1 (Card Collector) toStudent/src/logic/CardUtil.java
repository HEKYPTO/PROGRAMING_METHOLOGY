package logic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		return list.contains(card);
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		return list.contains(deck);
	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck deck: deckList) {
			for (CardCounter element: deck.getCardsInDeck()) {
				if (element.getCard().equals(cardToTest)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		try {
			Scanner scanner = new Scanner(fileToRead);
			while (scanner.hasNextLine() ) {
				String line = scanner.nextLine();
				String[] text = line.split(",");
				
				UnitCard card = new UnitCard(text[0], Integer.parseInt(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]), text[4]);
				cardsFromFile.add(card);
			}	
			scanner.close();
			return cardsFromFile;
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file!");
		} catch (IllegalArgumentException e) {
			System.out.println("File contains string with incorrect format!");
		}
		return null;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}