/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 13, 2019
 * Project: Assignment 9 Polymorphism
 * Description: PlayingCard Class
 */
package j2.assignment.pkg9.polymorphism;

import javafx.scene.image.*;

public class PlayingCard extends Card 
{
    private int value;
    private Suit suit;
    
    //overloaded constructor
    public PlayingCard(String path)
    {
        super(path);
    }
    
    //default constructor
    public PlayingCard()
    {
        this("file:img\\155.gif");
    }
    
    private void getCardValue(String filePath)
    {
        String number = "";
        for (int i = 0; i < filePath.length(); i++)
        {
            if (Character.isDigit(filePath.charAt(i)))
            {
                number += filePath.charAt(i);
            }
        }
        int cardNumber = Integer.parseInt(number.substring(1, 3));

        value = cardNumber % 13;
        
        if (value >= 11)
        {
            value = 10;
        }
        else if (value == 1)
        {
            value = 11;
        }
        
        if (cardNumber < 14)
            suit = Suit.Diamonds;
        else if (cardNumber < 27)
            suit = Suit.Clubs;
        else if (cardNumber < 40)
            suit = Suit.Hearts;
        else if (cardNumber <= 52)
            suit = Suit.Spades;
        
    }
    
    public int getValue()
    {
        return value;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    @Override
    protected boolean loadCard(String path)
    {
        imgCard = new Image(path);
        this.setGraphic(new ImageView(imgCard));
        this.getCardValue(path);
        return true;
    }
    
    
}
