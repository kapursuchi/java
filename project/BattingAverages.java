/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Final Project - Batting Averages
 * Description: Batting Averages - GUI
 */
package j2.pkgfinal.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BattingAverages extends Application 
{

    Button btnFile = new Button("Choose File");
    FileChooser fc = new FileChooser();
    TextArea taHighest = new TextArea();
    TextArea taLowest = new TextArea();

    @Override
    public void start(Stage primaryStage) 
    {
        HBox box = new HBox();
        box.getChildren().add(btnFile);
        btnFile.setOnAction((ActionEvent event) -> 
        {
            fc.setTitle("Batting Averages File");
            fc.setInitialDirectory(new File("."));
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text files", "*.txt"));

            File file = fc.showOpenDialog(primaryStage);

            if (file != null) {
                readFile(file);
            }
        });
        BorderPane root = new BorderPane();
        root.setBottom(box);
        root.setLeft(taHighest);
        root.setRight(taLowest);

        Scene scene = new Scene(root, 950, 500);

        primaryStage.setTitle("Final Project - Batting Averages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void readFile(File file) 
    {
        FileReader fr = null;
        BufferedReader br = null;
        double highestAvg = 0;
        double lowestAvg = 1;
        Stack<String> highestAvgNames = new Stack<String>();
        Stack<String> lowestAvgNames = new Stack<String>();
        try 
        {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            String name;
            double batting = 0;
            while ((line = br.readLine()) != null) 
            {
                if (!line.equals("")) 
                {
                    int periodPos = line.lastIndexOf(".");
                    name = line.substring(0, periodPos);
                    batting = Double.parseDouble(line.substring(periodPos));
                    System.out.println("name: " + name + " avg: " + batting);

                    if (batting > highestAvg) 
                    {
                        highestAvg = batting;

                        while (highestAvgNames.peek() != null) 
                        {
                            highestAvgNames.pop();
                        }
                        highestAvgNames.push(name);

                    } 
                    else if (batting == highestAvg) 
                    {

                        highestAvgNames.push(name);
                    } 
                    else if (batting < lowestAvg) 
                    {
                        lowestAvg = batting;
                        while (lowestAvgNames.peek() != null) 
                        {
                            lowestAvgNames.pop();
                        }
                        lowestAvgNames.push(name);

                    } 
                    else if (batting == lowestAvg) 
                    {
                        lowestAvgNames.push(name);
                    }
                }

            }

            String highestAvgStr = "The highest batting average is: " + highestAvg + "\n\t";
            highestAvgStr += "The following people have this batting average: \n\t";

            while (highestAvgNames.peek() != null) 
            {
                highestAvgStr += highestAvgNames.pop() + "\n\t";
            }

            taHighest.setText(highestAvgStr);

            String lowestAvgStr = "The lowest batting average is: " + lowestAvg + "\n\t";
            lowestAvgStr += "The following people have this batting average: \n\t";

            while (lowestAvgNames.peek() != null) 
            {
                lowestAvgStr += lowestAvgNames.pop() + "\n\t";
            }

            taLowest.setText(lowestAvgStr);
        } 
        catch (Exception e) 
        {
            System.out.println("Error opening file " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                fr.close();
                br.close();
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) 
    {
        launch(args);
    }

}
