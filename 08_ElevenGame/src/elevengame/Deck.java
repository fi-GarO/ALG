package elevengame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck //balicek karet
 *
 * @author jiri.turyna
 */
public class Deck {

    //do not have to change during the game, deckSize can simulate removing the cards
    private ArrayList<Card> deckCards;
    private int deckSize; //actual deck size

    public Deck(String[] symbols, String[] values, int[] nPoints) {
        deckCards = new ArrayList<>();
        generateAllCards(symbols, values, nPoints);
        shuffle();
    }

    /**
     * Generate List of all cards e.g. using DataStore class with arrays of
     * symbols, values, nPoints
     */
    private void generateAllCards(String[] symbols, String[] values, int[] nPoints) {
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; i < values.length; j++) {
                deckCards.add(new Card(symbols[i], values[j], nPoints[i]));

            }
        }
    }

    /**
     * Shuffle list of cards An algorithm to permute an array.
     */
    public void shuffle() {
        Collections.shuffle(deckCards);
    }

    /**
     * Deal one card Get the card at deckSize-1 index and decrement deckSize by
     * one
     *
     * @return the dealt card, or null if all the cards have been previously
     * dealt.
     */
    public Card deal() {
        Card card = deckCards.get(deckCards.size() - 1);
        deckCards.remove(deckCards.size() - 1);
        return card;
    }

    public int getDeckSize() {
        return deckCards.size();
    }

    public boolean isEmpty() {
        if (deckCards.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}
