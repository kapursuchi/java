/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: March 25, 2019
 * Project: Lab 1 Console Application
 * Description: Create a class called Lab 1, inside the class you
                will create 3 methods that will modify a 3-digit
                int number.
 */
package j2.assignment.pkg1.console.application;

import java.util.Scanner;

public class Lab1 
{
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
        //create instance of Scanner class for keyboard entry
        Scanner in = new Scanner(System.in);
        
        //prompt user to enter 3 digit number
        System.out.println("Enter a 3-digit number: ");
        int number = in.nextInt();
        
        // create instance of lab1 class
        Lab1 console = new Lab1();
        
        //call sumNum using number user entered
        int sum = console.sumNums(number);
        
        //display sum
        System.out.println("The sum of the numbers is: " + sum);
    
        //call reverseNums using number user entered
        String reverse = console.reverseNums(number);
        
        //display reverse of numbers
        System.out.println("In reverse the numbers are " + reverse);
    
        //call getArray using user input
        int[] myArray = console.getArray(number);
        
        //print array
        System.out.println("Printing Array");
        for (int i = 0; i < myArray.length; i++)
        {
            System.out.println(myArray[i]);
        }
        
    
    }
    
}
