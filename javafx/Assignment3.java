/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 25, 2019
 * Project: Assignment 3 Intro to Java FX
 * Description: Create a JavaFX project that displays a random card
 */
package j2.assignment.pkg3.intro.to.javafx;

import javafx.application.Application;
import javafx.scene.image.*;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Assignment3 extends Application 
{ 
    @Override
    public void start(Stage primaryStage) 
    {
        //step 1 - create border pane, scene, set title, and show
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Assignment 3");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //create label for top
        Label randomCardLabel = new Label();
        randomCardLabel.setText("Random Card");
        randomCardLabel.setFont(Font.font("HELVETICA", FontWeight.BOLD, 20));
        randomCardLabel.setTextFill(Color.BLUEVIOLET);
        
        //create label to hold random card image
        Label lblCard = new Label();
        
        //create label for bottom
        Label sleeveLabel = new Label();
        sleeveLabel.setText("Nothing Up My Sleeve");
        sleeveLabel.setFont(Font.font("HELVETICA", FontWeight.BOLD, 15));
        sleeveLabel.setTextFill(Color.LIGHTPINK);
        
        //set top and bottom labels
        root.setTop(randomCardLabel);
        root.setBottom(sleeveLabel);
        
        //create stackpane, add label card & add stackpane (middle) to root
        StackPane middle = new StackPane();
        middle.getChildren().add(lblCard);
        root.setCenter(middle);
        
        //generate random number between 101-155
        Random rnd = new Random();
        int range = (155 - 101) + 1;
        int randomNumber = rnd.nextInt(range) + 101;
        String filePath = "file:img\\" + randomNumber + ".gif";
       
        //set graphic for random card image
        Image imgCard = new Image(filePath);
        lblCard.setGraphic(new ImageView(imgCard));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
