/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: April 6, 2019
 * Project: Assignment 7 Static Classes
 * Description: Score class
 */
package j2.assignment.pkg7.pkgstatic.classes;

public class Score 
{
    private static int scoreRight = 0;
    private static int scoreLeft = 0;
    
    //static overloaded mutator method
    public static void setRightScore(int score)
    {
        scoreRight += score;
    }
    
    //static overloaded mutator method
    public static void setRightScore(String score)
    {
        int scoreNum = Integer.parseInt(score);
        scoreRight += scoreNum;
    }
    
    //static overloaded mutator method
    public static void setLeftScore(int score)
    {
        scoreLeft += score;
    }
    
    //static overloaded mutator method
    public static void setLeftScore(String score)
    {
        int scoreNum = Integer.parseInt(score);
        scoreLeft += scoreNum;
    }
    
    //accessor method
    public static int getRightScore()
    {
        return scoreRight;
    }
    
    //accessor method
    public static int getLeftScore()
    {
        return scoreLeft;
    }
    
    //reset score method - mutator
    public static void resetScore()
    {
        scoreRight = 0;
        scoreLeft = 0;
    }
    
}
