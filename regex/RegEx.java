/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 4, 2019
 * Project: Assignment 13
 * Description: Regular Expressions
 */
package j2.assignment.pkg13.regex;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class RegEx extends Application 
{
    Button btnFile = new Button("Choose File");
    TextArea taOutput = new TextArea();
    TextArea taPalindrome = new TextArea();
    String palindromes = "The following words are palindromes: \n";
    FileChooser fc = new FileChooser();
    String matches = "";
    
    @Override
    public void start(Stage primaryStage) 
    {
        HBox box = new HBox();
        box.getChildren().add(btnFile);
        btnFile.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) 
            {
                fc.setTitle("Regular Expression Files");
                fc.setInitialDirectory(new File(".\\v003"));
                fc.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Web pages", "*.html"));
                
                File file = fc.showOpenDialog(primaryStage);
                
                if (file != null)
                {
                    readFile(file);
                }
                
            }

        });
        BorderPane root = new BorderPane();
        root.setBottom(box);
        root.setLeft(taOutput);
        root.setRight(taPalindrome);
        
        Scene scene = new Scene(root, 950, 500);
        
        primaryStage.setTitle("Assignment 13 RegEx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   private void readFile(File file)
   {
        taOutput.setText(matches);
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
           fr  = new FileReader(file);
           br = new BufferedReader(fr);
           String line;
           while((line = br.readLine()) != null)
           {
               Pattern p = Pattern.compile("\\b^[A-Za-z]+([-,'])?[A-Za-z, ]*\\d?\\b");

               line = line.replaceAll("\\<.*?\\>", "");
               
               Matcher m = p.matcher(line);
               
               String word = "";
               String reversed = "";
               //System.out.println(line);
               while(m.find())
               {
                    word = m.group();
                    if (word.length() == 5)
                    {
                        for (int i = word.length() - 1; i >= 0; i--)
                        {
                            reversed += Character.toLowerCase(word.charAt(i)); 
                            
                        }
                        if (word.equalsIgnoreCase(reversed))
                            palindromes += word + "\n";
                    }
                    //System.out.println(m.group());
                    matches += m.group() + "\n";
                    
                   
               }
                    
           }
           taOutput.setText(matches);
           taPalindrome.setText(palindromes);
        }
        catch(Exception e){
           System.out.println("Error opening file");
        }
        finally{
           try{
              fr.close();
              br.close();
           }
           catch(Exception e){
              System.out.println(e.getMessage());
           }
        }
        
}


    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
