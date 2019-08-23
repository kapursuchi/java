/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 13, 2019
 * Project: Assignment 9 Polymorphism
 * Description: Tarot Card Class
 */
package j2.assignment.pkg9.polymorphism;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TarotCard extends Card
{
    private int value;
    private String name;
    
    //overloaded constructor
    public TarotCard(String path)
    {
        super(path);
    }
    
    //default constructor
    public TarotCard()
    {
        this("file:img\\maj_00.jpg");
    }
    
    private void getCardValue(String filePath)
    {
        name = filePath.substring(filePath.lastIndexOf("\\")+1, filePath.indexOf('.'));
        String number = "";
        for (int i = 0; i < name.length(); i++)
        {
            if (Character.isDigit(name.charAt(i)))
            {
                number += name.charAt(i);
            }
        }
        value = Integer.parseInt(number);

    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getName()
    {
        return name;
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
