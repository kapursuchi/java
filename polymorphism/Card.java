/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 13, 2019
 * Project: Assignment 9 Polymorphism
 * Description: Card Class
 */
package j2.assignment.pkg9.polymorphism;

import javafx.scene.image.*;
import javafx.scene.control.*;

public abstract class Card extends Label
{
    protected Image imgCard;
    protected String imgName;
    
    //overloaded constructor
    public Card(String path)
    {
        super();
        this.setImage(path);
    }
    
    //default constructor
    public Card()
    {
        this("file:img\\155.gif");
    }
    
    protected abstract boolean loadCard(String path);

    private void setImage(String path)
    {
        imgName = path;
        this.loadCard(imgName);
    }


    
}

