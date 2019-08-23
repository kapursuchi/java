/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 6, 2019
 * Project: Assignment 8 Inheritance
 * Description: Deck Class
 */
package j2.assignment.pkg8.inheritance;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList
{
    private int index = 0;
    private final int LAST_CARD = 45;
    private ArrayList<Card> deck = new ArrayList<>();
    
    //overloaded constructor
    public Deck(String pathToCards)
    {
        super();
        this.loadCards(pathToCards);
    }
    
    //default constructor
    public Deck()
    {
        this("file:img\\");
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    private void loadCards(String path)
    {
        String cardPath = "";
        
        for (int card = 101; card < 153; card++)
        {
                cardPath = path + card + ".gif";
                Card newCard = new Card(cardPath);
                deck.add(newCard);
        }

        
    }
    
    public Card deal()
    {
        if (index >= LAST_CARD)
        {
            this.shuffle();
            index = 0;
        }
        Card returnCard = deck.get(index);
        index++;
        return returnCard;
    }
}
