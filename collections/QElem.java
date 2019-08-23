/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Assignment 15 Generic Collections
 * Description: QElem Class
 */
package j2.assignment.pkg15.generic.collections;

public class QElem <T>
{
    T data;
    int priority;
    
    public QElem(T elem, int pri)
    {
        this.data = elem;
        this.priority = pri;
    }
    
    public int getPriority()
    {
        return this.priority;
    }
    
    public T getData()
    {
        return this.data;
    }
    
    
}
