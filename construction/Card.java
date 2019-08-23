/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 30, 2019
 * Project: Assignment 5 
 * Description: Class Construction
 */
package j2.assignment.pkg5.pkgclass.construction;

import javafx.scene.image.*;
import javafx.scene.control.*;

public class Card 
{
    Label cardImage = new Label();
    Image referenceImage;
    int cardValue;
    String filePath;
    private Suit suit;
    private int value;
    
    private boolean loadCard(String filePath)
    {
        referenceImage = new Image(filePath);
        cardImage.setGraphic(new ImageView(referenceImage));
        this.getCardValue(filePath);
        return true;
    }
    
    public void setImage(String path)
    {
        filePath = path;
        this.loadCard(filePath);
    }
    
    public Label getCard()
    {
        return cardImage;
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
    
    
}
