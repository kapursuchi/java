/*
 * Name: Suchi Kapur
 * ID: 0558322
 * Date: May 11, 2019
 * Project: Assignment 15 Generic Collections
 * Description: PriQue class
 */
package j2.assignment.pkg15.generic.collections;

import java.util.ArrayList;


public class PriQueue <T> extends ArrayList
{
    public void enqueue(T elem, int pri)
    {
        if (pri > 10)
            pri = 5;
        this.add(0, new QElem(elem, pri));
        
        this.bubbleSort();
        
    }
    
    public QElem dequeue()
    {
        QElem elem = (QElem) this.remove(0);
        return elem;        
    }
    
    public QElem peek()
    {
        QElem elem = (QElem) this.get(0);
        return elem;
    }
    
    @Override
    public int size()
    {
        return super.size();
    }
    
    private void bubbleSort()
    {
        int n = this.size();
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                QElem leftElem = (QElem) this.get(j);
                QElem rightElem = (QElem) this.get(j + 1);
                if (leftElem.getPriority() < rightElem.getPriority())
                {
                    // swap temp and arr[i]
                    QElem temp = (QElem) this.get(j);
                    
                    this.set(j, rightElem);
                    this.set(j + 1, leftElem);
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        //testing PriQueue with Integer
        System.out.println("-------- Testing PriQueue with Integer --------");
        PriQueue<Integer> queInt = new PriQueue<Integer>();
        queInt.enqueue(5, 3);
        queInt.enqueue(10, 10);
        queInt.enqueue(15, 9);
        
        System.out.println("Size of queInt: " + queInt.size());
        QElem i = (QElem) queInt.dequeue();
        System.out.println("Dequeued element: " + i.getData() + " with priority: " + i.getPriority());
        System.out.println("Size of queInt after dequeue: " + queInt.size());
        QElem peeked = queInt.peek();
        System.out.println("Peeking element after dequeue: " + peeked.getData() + " with priority: " + peeked.getPriority());
        
        //testing PriQueue with Double
        System.out.println();
        System.out.println("-------- Testing PriQueue with Double --------");
        PriQueue<Double> queDouble = new PriQueue<Double>();
        queDouble.enqueue(5.5, 3);
        queDouble.enqueue(10.5, 10);
        queDouble.enqueue(15.5, 9);
        
        System.out.println("Size of queDouble: " + queDouble.size());
        QElem d = (QElem) queDouble.dequeue();
        System.out.println("Dequeued element: " + d.getData() + " with priority: " + d.getPriority());
        System.out.println("Size of queDouble after dequeue: " + queDouble.size());
        QElem peekedDouble = queDouble.peek();
        System.out.println("Peeking element after dequeue: " + peekedDouble.getData() + " with priority: " + peekedDouble.getPriority());
        
        //testing PriQueue with Char
        System.out.println();
        System.out.println("-------- Testing PriQueue with Character --------");
        PriQueue<Character> queChar = new PriQueue<Character>();
        queChar.enqueue('a', 11); // priority gets reset to 5 since bigger than 10
        queChar.enqueue('b', 2);
        queChar.enqueue('c', 1);
        
        System.out.println("Size of queChar: " + queChar.size());
        QElem c = (QElem) queChar.dequeue();
        System.out.println("Dequeued element: '" + c.getData() + "' with priority: " + c.getPriority());
        System.out.println("Size of queDouble after dequeue: " + queChar.size());
        QElem peekedChar = queChar.peek();
        System.out.println("Peeking element after dequeue: '" + peekedChar.getData() + "' with priority: " + peekedChar.getPriority());
        
    }
    
}
