/*
 * Name: Suchi Kapur
 * SID: 0558322
 * Date: April 17, 2019
 * Project: Midterm Project
 * Description: The Great BattleShip Challenege - BattleShip.java
 */
package battleship;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.util.Random;
import javafx.scene.input.MouseEvent;


public class BattleShip extends Application {
    
    private static final int MAXSHIPS = 14;
    private static final int GRIDSIZE  = 16;
    private GridPane pnlPlayer = new GridPane();
    private Label[][] lblPlayer = new Label[GRIDSIZE][GRIDSIZE];
    private Image[] imgShips = new Image[10];
    private Ship[] shipInfo = new Ship[8];
    private char[][] ocean = new char[16][16];   
    private Button btnReset = new Button("Reset");
    private Button btnShowShips = new Button("Show Ships");
    private Image[][] hiddenShips = new Image[GRIDSIZE][GRIDSIZE];
    private char[][] attackShips = new char[GRIDSIZE][GRIDSIZE];
    private String[] shipPos = new String[14];
    private String[] paths = new String[10];
    private int shipPosIdx = 0;
    private int numOfMisses = 0;
    
    
    @Override
    public void start(Stage primaryStage) 
    {        
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
                
        Scene scene = new Scene(root, 288, 315);
        
        scene.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                Label reference = (Label)event.getTarget();
                
                ImageView hitImg = new ImageView(new Image("file:Images\\batt103.gif"));
                ImageView missImg = new ImageView(new Image("file:Images\\batt102.gif"));
                
                for(int row = 0; row < GRIDSIZE; row++)
                {
                    for(int col = 0; col < GRIDSIZE; col++)
                    {
                        if(lblPlayer[row][col] == reference)
                        {
                            if (ocean[row][col] == 'O')
                            {
                                lblPlayer[row][col].setGraphic(missImg);
                                numOfMisses++;
                                attackShips[row][col] = 'M'; //m for miss
                            }
                            else
                            {
                                lblPlayer[row][col].setGraphic(hitImg);
                                attackShips[row][col] = 'H'; //h for hit
                                
                                char shipType = ocean[row][col];
                                int length = 0;
                                
                                switch(shipType)
                                {
                                    case 'F':
                                        length = 2;
                                        break;
                                    case 'M':
                                        length = 3;
                                        break;
                                    case 'C':
                                        length = 4;
                                        break;
                                    case 'B':
                                        length = 5;
                                        break;
                                }
                                
                                for (int i = 0; i < shipPos.length; i++)
                                {
                                    String dir = shipPos[i].substring(0, shipPos[i].indexOf(","));
                                    int commaLoc = shipPos[i].indexOf(",");
                                    String rowStr = shipPos[i].substring(commaLoc + 2, shipPos[i].indexOf(", ", commaLoc + 1));
                                    String colStr = shipPos[i].substring(shipPos[i].indexOf(", ", commaLoc  + 1) + 2);
                                    
                                    int startShipR = Integer.parseInt(rowStr);
                                    int startShipC = Integer.parseInt(colStr);
                                    char direction = dir.charAt(0);
                                    
                                    int endShipR = startShipR + length - 1;
                                    int endShipC = startShipC + length - 1;
                                    
                                    
                                    int hits = 0;
                                    
                                    if (direction == 'V')
                                    {
                                        if (startShipC == col)
                                        {
                                            if (row >= startShipR && row <= endShipR) 
                                            {
                                                for (int pos = startShipR; pos <= endShipR; pos++) //looping from the start of the ship to the end of the ship
                                                {
                                                    //checking to see if user hit every part of the ship
                                                    if (attackShips[pos][col] == 'H') {
                                                        hits++;
                                                    }

                                                }

                                                if (hits == length) 
                                                {
                                                    lblPlayer[startShipR][col].setGraphic(new ImageView(new Image("file:Images\\batt204.gif"))); //back end of ship
                                                    
                                                    for (int pos = startShipR + 1; pos < endShipR; pos++) 
                                                    {
                                                        lblPlayer[pos][col].setGraphic(new ImageView(new Image("file:Images\\batt205.gif")));
                                                    }
                                                    
                                                    lblPlayer[endShipR][col].setGraphic(new ImageView(new Image("file:Images\\batt206.gif"))); //front of ship
                                                }
                                            }
                                        }
                                    }
                                    else if (direction == 'H')
                                    {
                                        if (row == startShipR)
                                        {
                                            if (col >= startShipC && col <= endShipC)
                                            {
                                                for (int k = startShipC; k <= endShipC; k++) //looping from the start of the ship to the end of the ship
                                                {
                                                    //checking to see if user hit every part of the ship
                                                    if (attackShips[row][k] == 'H') 
                                                    {
                                                        hits++;
                                                    }

                                                }

                                                if (hits == length)
                                                {
                                                    lblPlayer[row][startShipC].setGraphic(new ImageView(new Image("file:Images\\batt201.gif"))); //back end of ship
                                                    
                                                    for (int l = startShipC + 1; l < endShipC; l++) 
                                                    {
                                                        lblPlayer[row][l].setGraphic(new ImageView(new Image("file:Images\\batt202.gif")));
                                                    }
                                                    
                                                    lblPlayer[row][endShipC].setGraphic(new ImageView(new Image("file:Images\\batt203.gif"))); //front of ship
                                                }

                                            }
                                        }
                                    }//end if else checking directions
                                }//end for loop for checking sunk ships

                            }
                            //end inner if-else 
                            
                        }
                        //end lonely if      
                    }
                    //end inner for loop
                }
                //end outer for loop

            }
            //end handle function
        });
        
        btnReset.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                
                shipPosIdx = 0;
                initOcean();
                createPlayerPanel();
                createShips();
                placeShips();
                
            }
        });
        
        btnShowShips.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                for (int shipIdx = 0; shipIdx < 8; shipIdx++)
                {
                    Ship si = shipInfo[shipIdx];

                    for(int row = 0; row < GRIDSIZE; row++)
                    {
                        for(int col = 0; col < GRIDSIZE; col++)
                        {
                            Label[][] images = si.getImages();
                            if (ocean[row][col] != 'O' && !images[row][col].getText().isEmpty())
                            {
                                lblPlayer[row][col].setGraphic(new ImageView(images[row][col].getText()));
                            }
                        }
                    }
                    
                }
                
            }
            
        });
        
        grid.add(btnReset, 1, 0);
        grid.add(btnShowShips, 2, 0);
        root.setBottom(grid);
        
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.initOcean();
        this.createPlayerPanel();
        createShips();
        root.setCenter(pnlPlayer);
        placeShips();

    }
    private void createPlayerPanel()
    {
       pnlPlayer.setStyle("-fx-background-color:#0000FF;");
       for(int row = 0; row < GRIDSIZE; row++)
       {
           for(int col = 0; col < GRIDSIZE; col++)
           {
               lblPlayer[row][col] = new Label();               
               Image imgShip = new Image("file:Images\\batt100.gif");
               lblPlayer[row][col].setGraphic(new ImageView(imgShip));
               lblPlayer[row][col].setMaxSize(16.0, 16.0);
               lblPlayer[row][col].setStyle("-fx-border-width:1;-fx-border-color:black;");
               pnlPlayer.add(lblPlayer[row][col], col, row);
           }
       }
      
    }
    private void createShips()
    {
        this.loadShipImages();
        this.createShipInfo();
    }
    private void loadShipImages()
    {
        for(int i = 0; i < 10 ; i++)
        {
            imgShips[i] = new Image("file:Images\\batt" + (i + 1) + ".gif");
            paths[i] = "file:Images\\batt" + (i + 1) + ".gif";
        }
    }
    private void createShipInfo()
    {
        //Start with the frigate, we create 2 of them here but will place 3 total randomly it as two images
		int[] frigateH = {0,4};
		shipInfo[0] = new Frigate(frigateH, 'H');
		int[] frigateV = {5,9};
		shipInfo[1] = new Frigate(frigateV, 'V');
		
        // Create the mine Sweep it has 3 pieces
		int[] mineSweepH = {0,1,4};
		shipInfo[2] = new Minesweep(mineSweepH, 'H');
		int[] mineSweepV = {5,6,9};
		shipInfo[3] = new Minesweep(mineSweepV, 'V');
		
		int[] cruiserH = {0,1,2,4};
		shipInfo[4] = new Cruiser(cruiserH, 'H');
		int[] cruiserV = {5,6,7,9};
		shipInfo[5] = new Cruiser(cruiserV, 'V');
		
		int[] battleShipH = {0,1,2,3,4};
		shipInfo[6] = new Battle(battleShipH, 'H');
		int[] battleShipV = {5,6,7,8,9};
		shipInfo[7] = new Battle(battleShipV, 'V'); 
    }
    private void initOcean()
    {
        for(int row = 0; row < 16; row++)
        {
            for(int col = 0; col < 16; col++)
            {
                ocean[row][col] = 'O';
                attackShips[row][col] = 'O';
            }
        }
    }
    private void placeShips()
    {
       // Create a Random object to select ships
        Random r = new Random();

        // Create random objects to place the shipInfo at a row and a column
        Random randCol = new Random();
        Random randRow = new Random();

        //Place the ships, typically there are 14
        for(int ships = 0; ships < MAXSHIPS; ships++)
        {
                //Get a random shipInfo
                Ship si = shipInfo[r.nextInt(8)];

                int row = randRow.nextInt(16);
                int col = randCol.nextInt(16);
                int direction = checkDirection(si, row, col);
                while(direction == 0) // 0 direction says that we can not place the shipInfo
                {
                        row = randRow.nextInt(16);
                        col = randCol.nextInt(16);
                        direction = checkDirection(si, row, col);
                }
                // got a clear path, let put the shipInfo on the ocean
                int shipPieces[] = si.getShipPieces();
                if(si.Direction == 'H')  // place horizontal
                {
                        if(direction == 1)
                        {
                            for(int i = col, j = 0; i < col + si.length(); i++, j++)
                            {      
                                if (j == 0)
                                {
                                    shipPos[shipPosIdx] = String.format("%s, %s, %s", si.Direction, row, i);
                                    shipPosIdx++;
                                }
                                hiddenShips[row][i] = imgShips[shipPieces[j]];
                                si.holdImage(paths[shipPieces[j]], row, i);
                                //lblPlayer[row][i].setGraphic(new ImageView(imgShips[shipPieces[j]]));
                                lblPlayer[row][i].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                                String name = si.getName();
                                ocean[row][i] = name.charAt(0);
                            }
                        }
                        else
                        {
                            for(int i = col + si.length(), j = 0 ; i > col; i--, j++)
                            {
                                if (j == 0)
                                {
                                    shipPos[shipPosIdx] = String.format("%s, %s, %s", si.Direction, row, i);
                                    shipPosIdx++;
                                }
                                hiddenShips[row][i] = imgShips[shipPieces[j]];
                                si.holdImage(paths[shipPieces[j]], row, i);
                                //lblPlayer[row][i].setGraphic(new ImageView(imgShips[shipPieces[j]]));	
                                lblPlayer[row][i].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                                String name = si.getName();
                                ocean[row][i] = name.charAt(0);
                            }
                        }
                }
                else // Must be vertical direction
                {
                        if(direction == 1) // place pieces in positive direction
                        {
                            for(int i = row, j = 0; i < row + si.length(); i++, j++)
                            {
                                if (j == 0)
                                {
                                    shipPos[shipPosIdx] = String.format("%s, %s, %s", si.Direction, i, col);
                                    shipPosIdx++;
                                }
                                hiddenShips[i][col] = imgShips[shipPieces[j]];
                                si.holdImage(paths[shipPieces[j]], i, col);
                                //lblPlayer[i][col].setGraphic(new ImageView(imgShips[shipPieces[j]]));	
                                lblPlayer[i][col].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                                String name = si.getName();
                                ocean[i][col] = name.charAt(0);
                            }
                        }
                        else
                        {
                                for(int i = row + si.length(), j = 0; i > row; i--, j++)
                                {
                                    if (j == 0)
                                    {
                                        shipPos[shipPosIdx] = String.format("%s, %s, %s", si.Direction, i, col);
                                        shipPosIdx++;
                                    }
                                    hiddenShips[i][col] = imgShips[shipPieces[j]];
                                    si.holdImage(paths[shipPieces[j]], i, col);
                                    //lblPlayer[i][col].setGraphic(new ImageView(imgShips[shipPieces[j]]));	
                                    lblPlayer[i][col].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                                    String name = si.getName();
                                    ocean[i][col] = name.charAt(0);
                                }
                        }
                }			
        } 
        
        
    }
    
    private int checkDirection(Ship si, int row, int col)
    {
        if(si.Direction == 'H')
            return checkHorizontal(si, row, col);
        else
            return checkVertical(si, row, col);
    }
    
    int checkHorizontal(Ship si,int row, int col)
    {
            boolean clearPath = true;

            int len = si.length();
            System.out.println(len);
            for(int i = col; i < (col + si.length()); i++)
            {
                    if(i >= GRIDSIZE) //This would put us outside the ocean
                    {
                            clearPath = false;
                            break;
                    }
                    if(ocean[row][i] != 'O') // Ship already exists in this spot
                    {
                            clearPath = false;
                            break;
                    }
            }
            if(clearPath == true) // ok to move in the positive direction
                    return 1; 

            //Next Chec the negative direction
            for(int i = col; i > (col - si.length()); i--)
            {
                    if(i < 0) //This would put us outside the ocean
                    {
                            clearPath = false;
                            break;
                    }
                    if(ocean[row][i] != 'O') // Ship already exists in this spot
                    {
                            clearPath = false;
                            break;
                    }			

            }
            if(clearPath == true) //Ok to move in negative direction
                    return -1;
            else
                    return 0;   // No place to move			

    }
	
    int checkVertical(Ship si,int row, int col)
    {
            boolean clearPath = true;
            int len = si.length();
            System.out.println(len);

            for(int i = row; i < (row + si.length()); i++)
            {
                if(i >= GRIDSIZE) //This would put us outside the ocean
                {
                        clearPath = false;
                        break;
                }
                if(ocean[i][col] != 'O') // Ship already exists in this spot
                {
                        clearPath = false;
                        break;
                }
            }
            if(clearPath == true) // ok to move in the positive direction
                    return 1; 

            //Next Check the negative direction
            for(int i = row; i > (row - si.length() ); i--)
            {
                if(i < 0) //This would put us outside the ocean
                {
                        clearPath = false;
                        break;
                }
                if(ocean[i][col] != 'O') // Ship already exists in this spot
                {
                        clearPath = false;
                        break;
                }			

            }
            if(clearPath == true) //Ok to move in negative direction
                return -1;
            else
                return 0;   // No place to move			

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
