/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 30, 2019
 * Project: Assignment 5 
 * Description: Class Construction
 */
package j2.assignment.pkg5.pkgclass.construction;

import java.util.Random;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Assignment5 extends Application 
{
    Label lblScore = new Label("Score: ");
    TextField leftScore = new TextField();
    TextField rightScore = new TextField();
    Label lblCardLeft = new Label();
    Label lblCardRight = new Label();
    Label lblCardDeck = new Label();
    Button btnReset = new Button("Reset");
    Card leftCard = new Card();
    Card rightCard = new Card();
    Card deckCard = new Card();
    
    int rightVal = 0;
    int leftVal = 0;
    int score = 0;
    boolean rightsTurn = true;
    
    @Override
    public void start(Stage primaryStage) 
    {
        btnReset.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                score = 0;
                rightScore.setText("0");
                leftScore.setText("0");
                rightsTurn = true;
                resetCardImages();
            }
        });
        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                //generate a random number between 101-152
                Random rand = new Random();
                int range = (152 - 101) + 1;
                int randomNumber = rand.nextInt(range) + 101;
                
                //create file path with random number & create new image
                String filePath = "file:img\\" + randomNumber + ".gif";
                Card newCard = new Card();
                newCard.setImage(filePath);
                
                
                
                if (rightsTurn == true)
                {
                    //if rights turn set graphic to new image
                    lblCardRight.setGraphic(newCard.getCard());
                    rightVal = newCard.getValue();
                }
                else
                {
                    //if lefts turn set graphic to new image
                    lblCardLeft.setGraphic(newCard.getCard());
                    leftVal = newCard.getValue();
                    
                    
                    if (rightVal > leftVal)
                    {
                        //update scores
                        score = Integer.parseInt(rightScore.getText());
                        score += rightVal;
                        rightScore.setText("" + score);

                    }
                    else if (leftVal > rightVal)
                    {
                        //update scores
                        score = Integer.parseInt(leftScore.getText());
                        score += leftVal;
                        leftScore.setText("" + score);
                    }
                    
                }
                //flip turns
                rightsTurn = !rightsTurn;
                
            }
        });
        
        //layouts
        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();
        GridPane cardPane = new GridPane();
        
        //set scene and show
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Assignment 4 - Simple Game of War");
        primaryStage.show();
        primaryStage.setScene(scene);
        
        //top pane components
        lblScore.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        lblScore.setTextFill(Color.RED);
        
        leftScore.setPrefWidth(50);
        leftScore.setDisable(true);
        leftScore.setText("0");
        
        rightScore.setPrefWidth(50);
        rightScore.setDisable(true);
        rightScore.setText("0");
        
        topPane.add(lblScore, 0, 0);
        topPane.add(new Label("Left: "), 0, 1);
        topPane.add(leftScore, 1, 1);
        topPane.add(new Label("Right: "), 2, 1);
        topPane.add(rightScore, 3, 1);
        topPane.setHgap(20);
        topPane.setVgap(10);
        
        //center pane
        cardPane.setHgap(20.0);
        cardPane.add(lblCardLeft, 0, 0);
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.add(lblCardRight, 2, 0);
        cardPane.setAlignment(Pos.CENTER);
        
        //set top, bottom, and center. load default imaged
        this.resetCardImages();
        root.setTop(topPane);
        root.setCenter(cardPane);
       
        root.setBottom(btnReset);

    }
    
    public void resetCardImages()
    {
        //load default images
        leftCard.setImage("file:img\\155.gif");
        lblCardLeft.setGraphic(leftCard.getCard());
       
        rightCard.setImage("file:img\\155.gif");
        lblCardRight.setGraphic(rightCard.getCard());
        
        deckCard.setImage("file:img\\155.gif");
        lblCardDeck.setGraphic(deckCard.getCard());

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
