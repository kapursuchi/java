/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 4, 2019
 * Project: Assignment 12
 * Description: Recursion - finding number of ones in an integers 
                binary value
 */
package j2.assignment.pkg12.recursion;

import java.util.Scanner;


public class Recursion 
{
    public int ones(int num)
    {
        int count = 0;
        
        while(num > 0)
        {   
            //if binary digit is 1 increase ones count
            if((num % 2) == 1)
            {
                count++;
            }
            //move onto next number
            num /= 2;

            ones(num);
        }
        //return number of ones
        return count;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = in.nextInt();

        Recursion rec = new Recursion();
        int numOnes = rec.ones(number);
        
        System.out.println("There are " + numOnes + " ones in " + number + "\'s binary value.");
    }
    
}
