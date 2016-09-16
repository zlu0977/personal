package card_engine;

import java.util.LinkedList;
import java.util.Random;

public class CardEngine {

	final static String[] suitArray = {"diamonds", "hearts", "clubs", "spades"};
	final static int[] valueArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	static LinkedList<Card> cardDeck = new LinkedList<Card>();
	
	static Random rand = new Random();
	
	public static void main(String[] args) {
		createDeck(cardDeck);
		float timer1 = System.currentTimeMillis();
		cardDeck = shuffleDeckRecursive(cardDeck, new LinkedList<Card>());
		//shuffleDeck(cardDeck);
		//float timer2 = System.currentTimeMillis();
		//System.out.println(cardDeck.getLast().value);
		//System.out.println(timer2 - timer1);
	}
	
	public static void createDeck(LinkedList<Card> deck)
	{
		deck.clear();
		
		for(int x : valueArray)
			for(String y : suitArray)
				deck.add(new Card(x, y));
	}
	
	public static void shuffleDeck(LinkedList<Card> deck)
	{
		LinkedList<Card> tempDeck = new LinkedList<Card>();
		createDeck(tempDeck);
		
		int ctr = 0;
		while(tempDeck.size() > 0)
		{
			int n = rand.nextInt(tempDeck.size());
			deck.set(ctr, tempDeck.get(n));
			tempDeck.remove(n);
			ctr ++;
		}
	}
	
	public static LinkedList<Card> shuffleDeckRecursive(LinkedList<Card> deck, LinkedList<Card> newDeck)
	{
		if(deck.size() <= 0)
			return newDeck;
		else
		{
			newDeck.add(deck.remove(rand.nextInt(deck.size())));
			return shuffleDeckRecursive(deck, newDeck);
		}
	}

}
