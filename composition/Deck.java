/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 30, 2019
 * Project: Assignment 6 
 * Description: Constructors & Composition - Deck
 */
package j2.assignment.pkg6.constructors.and.composition;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    int index = 0;
    final int LAST_CARD = 45;
    ArrayList<Card> deck = new ArrayList<Card>();
    
    //overloaded constructor
    public Deck(String pathToCards)
    {
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
