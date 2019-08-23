/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 25, 2019
 * Project: Assignment 2 Swing Review
 * Description: Create an interface for Lab1's methods
 */
package j2.assignment.pkg2.swing.review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingReview extends JFrame implements ActionListener
{
    //program settings
    private static final String FRAME_TITLE = "Lab 2";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    
    private JLabel promptLabel;
    private JTextField numberTextField;
    private JLabel sumLabel;
    private JLabel computedSumLabel;
    private JLabel reverseLabel;
    private JLabel computedReverseLabel;
    private JLabel arrayLabel;
    private JLabel computedArrayLabel;
    private JLabel textColorLabel;
    private JRadioButton redButton;
    private JRadioButton greenButton;
    private JRadioButton blueButton;
    private JButton computeButton;
    
    public SwingReview(String title, int width, int height)
    {
        //create components
        promptLabel = new JLabel("Enter a 3-digit Number: ");
        numberTextField = new JTextField(5);
        sumLabel = new JLabel("Sum: ");
        computedSumLabel = new JLabel("");
        reverseLabel = new JLabel("Reverse: ");
        computedReverseLabel = new JLabel("");
        arrayLabel = new JLabel("Array: ");
        computedArrayLabel = new JLabel("");
        textColorLabel = new JLabel("Text Color: ");
        redButton = new JRadioButton("Red");
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");
        computeButton = new JButton("Compute");
        
        //create and set layout
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        //add components to frame and spring layout
        add(promptLabel);
        layout.putConstraint(SpringLayout.WEST, promptLabel, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, promptLabel, 15, SpringLayout.NORTH, this);
        
        add(numberTextField);
        layout.putConstraint(SpringLayout.WEST, numberTextField, 150, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, numberTextField, 15, SpringLayout.NORTH, this);
        
        add(sumLabel);
        layout.putConstraint(SpringLayout.WEST, sumLabel, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, sumLabel, 30, SpringLayout.SOUTH, promptLabel);
        
        add(computedSumLabel);
        layout.putConstraint(SpringLayout.WEST, computedSumLabel, 150, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, computedSumLabel, 30, SpringLayout.SOUTH, promptLabel);
        
        add(reverseLabel);
        layout.putConstraint(SpringLayout.WEST, reverseLabel, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, reverseLabel, 30, SpringLayout.SOUTH, sumLabel);
        
        add(computedReverseLabel);
        layout.putConstraint(SpringLayout.WEST, computedReverseLabel, 150, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, computedReverseLabel, 30, SpringLayout.SOUTH, sumLabel);
        
        add(arrayLabel);
        layout.putConstraint(SpringLayout.WEST, arrayLabel, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, arrayLabel, 30, SpringLayout.SOUTH, reverseLabel);
        
        add(computedArrayLabel);
        layout.putConstraint(SpringLayout.WEST, computedArrayLabel, 90, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, computedArrayLabel, 30, SpringLayout.SOUTH, reverseLabel);
        
        add(textColorLabel);
        layout.putConstraint(SpringLayout.WEST, textColorLabel, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, textColorLabel, 30, SpringLayout.SOUTH, arrayLabel);
        
        add(redButton);
        layout.putConstraint(SpringLayout.WEST, redButton, 15, SpringLayout.EAST, textColorLabel);
        layout.putConstraint(SpringLayout.NORTH, redButton, 30, SpringLayout.SOUTH, arrayLabel);
        
        add(greenButton);
        layout.putConstraint(SpringLayout.WEST, greenButton, 15, SpringLayout.EAST, redButton);
        layout.putConstraint(SpringLayout.NORTH, greenButton, 30, SpringLayout.SOUTH, arrayLabel);
        
        add(blueButton);
        layout.putConstraint(SpringLayout.WEST, blueButton, 15, SpringLayout.EAST, greenButton);
        layout.putConstraint(SpringLayout.NORTH, blueButton, 30, SpringLayout.SOUTH, arrayLabel);
        
        add(computeButton);
        layout.putConstraint(SpringLayout.WEST, computeButton, 125, SpringLayout.WEST, textColorLabel);
        layout.putConstraint(SpringLayout.NORTH, computeButton, 100, SpringLayout.SOUTH, arrayLabel);

        //add action listener
        computeButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        // set the Frame and display
        createFrame(title, width, height);
    }
    
    public SwingReview()
    {
        this(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
    }
    private void createFrame(String title, int width, int height) 
    {
        
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        ComputeButtons compute = new ComputeButtons();
        compute.actionPerformed(e);
        RadioButtons radio = new RadioButtons();
        radio.actionPerformed(e);

    }
    
    private class RadioButtons implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //default color
            Color color = Color.BLACK;
            
            if (e.getSource() == redButton)
            {
                color = Color.RED;
            }
            else if (e.getSource() == greenButton)
            {
                color = Color.GREEN;
            }
            else if (e.getSource() == blueButton)
            {
                color = Color.BLUE; 
            }

            computedSumLabel.setForeground(color);
            computedReverseLabel.setForeground(color);
            computedArrayLabel.setForeground(color);
        }
        
    }
    
    private class ComputeButtons implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String numberAsStr = numberTextField.getText();
            int number = Integer.parseInt(numberAsStr);

            String space = "                ";
            computedSumLabel.setText("" + sumNums(number));
            computedReverseLabel.setText("" + reverseNums(number));
            int[] array = getArray(number);
            computedArrayLabel.setText(array[0] + space + array[1] + space + array[2]);

        }
        
    }
    
    public int sumNums(int number)
    {
        int sum = 0;
        
        for (int i = 0; i < 3; i++)
        {
            sum += number % 10;
            number /= 10;
        }
        
        return sum;
    }
    
    public String reverseNums(int number)
    {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < 3; i++)
        {
            int digit = number % 10;
            builder.append(digit);
            number /= 10;
            
        }
        
        String reverse = builder.toString();
        return reverse;
    }
    
    public int[] getArray(int number)
    {
        int[] array = new int[3];
        
        for (int i = array.length - 1; i >= 0; i--)
        {
            array[i] = number % 10;
            number /= 10;
        }
        
        return array;
    }
    
    public static void main(String[] args) 
    {
        // create instance of SwingReview class
        SwingReview userInterface = new SwingReview();
    }

}
