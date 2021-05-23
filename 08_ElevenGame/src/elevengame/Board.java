package elevengame;

/**
 * Represents the table with cards to play and a deck
 *
 * @author jiri.turyna
 */
public class Board implements BoardInterface {

    private Card[] cards;
    private Deck deck;

    public Board() {
        deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        cards = new Card[nCards()];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.deal();
        }
    }

    @Override
    public String gameName() {
        return "Hra jedenactka";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        if (cards[index] == null) {
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (cards[i].getnPoints() + cards[j].getnPoints() == 11) {
                    return true;
                } else {
                    for (int k = 0; k < cards.length; k++) {
                        if (cards[i].getnPoints() == 0) {
                            if (cards[i].getValue() == "J" && cards[j].getValue() == "Q" && cards[k].getValue() == "K") {
                                return true;
                            }
                            if (cards[i].getValue() == "J" && cards[j].getValue() == "K" && cards[k].getValue() == "Q") {
                                return true;
                            }
                            if (cards[i].getValue() == "Q" && cards[j].getValue() == "J" && cards[k].getValue() == "K") {
                                return true;
                            }
                            if (cards[i].getValue() == "Q" && cards[j].getValue() == "K" && cards[k].getValue() == "J") {
                                return true;
                            }
                            if (cards[i].getValue() == "K" && cards[j].getValue() == "J" && cards[k].getValue() == "Q") {
                                return true;
                            }
                            if (cards[i].getValue() == "K" && cards[j].getValue() == "Q" && cards[k].getValue() == "J") {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;

    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        int numKs = 0;
        int numJs = 0;
        int numQs = 0;
        boolean valid = false;
        if (iSelectedCards.length == 2) {
            if ((cards[iSelectedCards[0]].getnPoints() + cards[iSelectedCards[1]].getnPoints()) == 11) {
                valid = true;
            }

        } else if (iSelectedCards.length == 3) {
            for (int i = 0; i < iSelectedCards.length; i++) {
                if ("K".equals(cards[iSelectedCards[i]].getValue())) {
                    numKs++;
                }
                if ("J".equals(cards[iSelectedCards[i]].getValue())) {
                    numJs++;
                }
                if ("Q".equals(cards[iSelectedCards[i]].getValue())) {
                    numQs++;
                }
            }
            if (numKs == 1 && numQs == 1 && numJs == 1){
                valid = true;
            }
        }
        if (valid){
            
            for (int i = 0; i < iSelectedCards.length; i++) {
                cards[iSelectedCards[i]] = deck.deal();
            }
        }
        return valid;
    }

    @Override
    public boolean isWon() {
        return deck.isEmpty();
    }
}
