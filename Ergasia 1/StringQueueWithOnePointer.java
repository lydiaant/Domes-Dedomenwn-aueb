import java.io.PrintStream;
import java.util.NoSuchElementException;

class StringQueueWithOnePointer<T> implements StringQueue<T> 
{
    Node<T> rear;

    StringQueueWithOnePointer() {rear = null;}
    
    @Override
    public boolean isEmpty() {return rear == null;}

    @Override
    public void put(T item) 
    {
        Node<T> t = new Node<T>(item);

        if(rear == null) 
        {
            rear = t;
            rear.next = t;
        }
        else
        {
            t.next = rear.next;
            rear.next = t;
            rear = rear.next;
        }
    }

    @Override
    public T get() throws NoSuchElementException 
    {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> t = rear.next;
        
        if (size() == 1)
        {
            rear.next = null;
            rear = null;
            return t.getItem();
        }
        
        rear.next = rear.next.next;
        return t.getItem();
    }

    @Override
    public T peek() throws NoSuchElementException 
    {
        if (isEmpty()) throw new NoSuchElementException();
        return rear.next.item;
    }

    @Override
    public void printQueue(PrintStream stream) 
    {
        if(isEmpty()) {System.out.println("Empty");}
        else 
        {
            Node<T> t = rear.next;
            if (size() == 1) {stream.println(t.getItem());} 
            else
            {
                while(t != rear) 
                {
                    stream.println(t.getItem());
                    stream.flush();            
                    t = t.next;
                }
                stream.println(t.getItem());
            }
            
        }   
    }

    @Override
    public int size() 
    {
        int counter = 0;
        if (isEmpty()) {return 0;}
            
        Node<T> t = rear;
        if (rear.next == rear) {return 1;}
        while(t.next != rear)
        {
            counter++;
            t = t.next;
        }
        counter++;
        return counter;
    }
    
}




