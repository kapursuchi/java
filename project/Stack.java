/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Final Project - Batting Averages
 * Description: Stack.java
 */
package j2.pkgfinal.project;

import java.util.ArrayList;


public class Stack <T>
{
    private ArrayList<T> al = new ArrayList<T>();
    
    public Stack(){}
    
    private T getElement(boolean erase)
    {
        T data = null;
        if(!this.al.isEmpty())
        {
            data = this.al.get(0);
            if(erase == true)
            {
                this.al.remove(0);
            }
        }
        return data;
    }
    
    public void push(T elem) {
        this.al.add(0, elem);
    }

    public T pop() {
        return this.getElement(true);
    }

    public T peek() {
        return this.getElement(false);
    }
}
