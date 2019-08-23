/*
 * Name: Suchi Kapur
 * SID: 0558322
 * Date: April 17, 2019
 * Project: Midterm Project
 * Description: The Great BattleShip Challenege - Ship.java
 */
package battleship;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Ship
{
    private String shipName;
    private int[] shipPieces; 
    char Direction;
    protected Image[][] imgShips = new Image[16][16];
    protected Label[][] lblShips = new Label[16][16];

    public Ship(String name, int[] pieces,char Direction)
    {
            this.Direction = Direction;
            this.shipName = name;
            shipPieces = new int[pieces.length];
            for (int i = 0; i < pieces.length; i++)
                    shipPieces[i] = pieces[i];
            
            for (int r = 0; r < imgShips.length; r++)
            {
                for (int c = 0; c < imgShips[0].length; c++)
                {
                    lblShips[r][c] = new Label();
                }
            }

    }
    public String getName()
    {
            return this.shipName;
    }
    public int[] getShipPieces()
    {
            return shipPieces;
    }
    public int getDirection()
    {
            return this.Direction;
    }
    public int length()
    {
            return shipPieces.length;
    }
    
    public abstract void holdImage(String path, int row, int col);
    
    
    public abstract Label[][] getImages();


}