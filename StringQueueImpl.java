import java.io.PrintStream;
import java.util.NoSuchElementException;

class StringQueueImpl<T> implements StringQueue<T> {

    Node<T> head, tail;
    
    StringQueueImpl() 
    {
        head = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {return head == null;}

    @Override
    public void put(T item)
    {
        Node<T> t = tail;
        tail = new Node<T>(item);
        
        if(isEmpty()) {head = tail;}
        else {t.next = tail;}
    }

    @Override
    public T get() throws NoSuchElementException
    {
        if (isEmpty()) throw new NoSuchElementException();
        else
        {
            T value = head.item;
            Node<T> t = head.next;
            head = t;
            return value;
        }
    }

    @Override
    public T peek() throws NoSuchElementException
    {
        if (isEmpty()) throw new NoSuchElementException();
            return head.item;
    }

    @Override
    public void printQueue(PrintStream stream) 
    {
        if (isEmpty())
            stream.println("Empty");
        else 
        {
            Node<T> temp_start = head;
            Node<T> temp_end = tail;

            while (temp_start != temp_end) 
            {
                stream.println(temp_start.item);
                stream.flush();
                temp_start = temp_start.next;
            }
            stream.println(temp_start.item);
            stream.flush();
        }
    }

    @Override
    public int size() 
    {   
        int number = 0;
        if (isEmpty()) {return number;}
        else
        {
            Node<T> temp = tail;
            while (temp != null) 
            {
                number ++;
                temp = temp.getNext();
            }
        }
        return number;
    }
}
