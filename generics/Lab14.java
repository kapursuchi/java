/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Assignment 14 Generics
 * Description: Using Generic Templates
 */
package j2.assignment.pkg14.generics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab14 extends Application 
{
    
    TextField tfOneX = new TextField();
    TextField tfOneY = new TextField();
    Button btnSetFirst = new Button("Set Pair");
    Label lblFirstPair = new Label("Pair Values --> First:       Second:       ");
    
    TextField tfTwoX = new TextField();
    TextField tfTwoY = new TextField();
    Button btnSetSecond = new Button("Set Pair");
    Label lblSecondPair = new Label("Pair Values --> First:       Second:       ");
    
    TextField tfThreeX = new TextField();
    TextField tfThreeY = new TextField();
    Button btnSetThird = new Button("Set Pair");
    Label lblThirdPair = new Label("Pair Values --> First:       Second:       ");
    
    @Override
    public void start(Stage primaryStage) 
    {
        GridPane root = new GridPane();
        
        Scene scene = new Scene(root, 500, 300);
        
        root.add(new Label("Enter Integer 1: "), 0, 0);
        root.add(tfOneX, 1, 0);
        root.add(new Label("Enter Integer 2: "), 0, 1);
        root.add(tfOneY, 1, 1);
        root.add(btnSetFirst, 0, 2);
        root.add(lblFirstPair, 0, 3);
        
        root.add(new Label("Enter Double 1: "), 0, 4);
        root.add(tfTwoX, 1, 4);
        root.add(new Label("Enter Double 2: "), 0, 5);
        root.add(tfTwoY, 1, 5);
        root.add(btnSetSecond, 0, 6);
        root.add(lblSecondPair, 0, 7);
        
        root.add(new Label("Enter String 1: "), 0, 8);
        root.add(tfThreeX, 1, 8);
        root.add(new Label("Enter String 2: "), 0, 9);
        root.add(tfThreeY, 1, 9);
        root.add(btnSetThird, 0, 10);
        root.add(lblThirdPair, 0, 11);
        
        btnSetFirst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                Integer fVal = Integer.parseInt(tfOneX.getText());
                Integer sVal = Integer.parseInt(tfOneY.getText());
                Pair <Integer, Integer> first = new Pair<Integer, Integer>(fVal, sVal);
                Integer firstVal = first.getFirst();
                Integer secondVal = first.getSecond();
                
                lblFirstPair.setText("Pair Values --> First: " + firstVal + " Second: " + secondVal);
            }
        });
        
        btnSetSecond.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                Double fVal = Double.parseDouble(tfTwoX.getText());
                Double sVal = Double.parseDouble(tfTwoY.getText());
                Pair <Double, Double> first = new Pair<Double, Double>(fVal, sVal);
                Double firstVal = first.getFirst();
                Double secondVal = first.getSecond();
                
                lblSecondPair.setText("Pair Values --> First: " + firstVal + " Second: " + secondVal);
            }
        });
        
        btnSetThird.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                String fVal = tfThreeX.getText();
                String sVal = tfThreeY.getText();
                Pair <String, String> first = new Pair<String, String>(fVal, sVal);
                String firstVal = first.getFirst();
                String secondVal = first.getSecond();
                
                lblThirdPair.setText("Pair Values --> First: " + firstVal + " Second: " + secondVal);
            }
        });
        
        primaryStage.setTitle("Lab 14 Generics");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
