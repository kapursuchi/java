/*
 * Name: Suchi Kapur
 * SID: 0558322
 * Date: April 17, 2019
 * Project: Midterm Project
 * Description: The Great BattleShip Challenege - Battle.java
 */
package battleship;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Battle extends Ship
{
    public Battle(int[] pieces, char direction)
    {
        super("Battleship", pieces, direction);
    }
    
    @Override
    public void holdImage(String path, int row, int col)
    {
        imgShips[row][col] = new Image(path);
        lblShips[row][col].setText(path);
        
    }
    
    @Override
    public Label[][] getImages()
    {
        return lblShips;
    }   


}
