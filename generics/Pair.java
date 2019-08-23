/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Assignment 14 Generics
 * Description: Pair Class
 */
package j2.assignment.pkg14.generics;

public class Pair <F, S>
{
    F pValOne;
    S pValTwo;
    
    //working constructor
    public Pair(F firstVal, S secondVal)
    {
        pValOne = firstVal;
        pValTwo = secondVal;
    }
    
    public F getFirst()
    {
        return pValOne;
    }
    
    public S getSecond()
    {
        return pValTwo;
    }
    
    public void setFirst(F first)
    {
        pValOne = first;
    }
    
    public void setSecond(S second)
    {
        pValTwo = second;
    }
}
