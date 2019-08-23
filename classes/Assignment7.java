/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 6, 2019
 * Project: Assignment 7 Static Classes
 * Description: Assignment7.java
 */
package j2.assignment.pkg7.pkgstatic.classes;


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


public class Assignment7 extends Application 
{
    private Label lblScore = new Label("Score: ");
    private TextField leftScore = new TextField();
    private TextField rightScore = new TextField();
    private Label lblCardLeft = new Label();
    private Label lblCardRight = new Label();
    private Label lblCardDeck = new Label();
    private Button btnReset = new Button("Reset");
    private Card leftCard;
    private Card rightCard;
    private Card deckCard;
    
    private int rightVal = 0;
    private int leftVal = 0;
    private boolean rightsTurn = true;

    private Deck deck = new Deck();
    
    @Override
    public void start(Stage primaryStage) 
    {
        btnReset.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Score.resetScore();
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
                //get new card
                Card newCard = deck.deal();
                
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
                        Score.setRightScore(rightVal);
                        rightScore.setText("" + Score.getRightScore());

                    }
                    else if (leftVal > rightVal)
                    {
                        //update scores
                        Score.setLeftScore(leftVal);
                        leftScore.setText("" + Score.getLeftScore());
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
        primaryStage.setTitle("Assignment 6");
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
        leftCard = new Card();
        lblCardLeft.setGraphic(leftCard.getCard());
       
        rightCard = new Card();
        lblCardRight.setGraphic(rightCard.getCard());
        
        deckCard = new Card();
        lblCardDeck.setGraphic(deckCard.getCard());

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
