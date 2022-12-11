import java.io.PrintStream;
import java.util.NoSuchElementException;

class StringStackImpl<T> implements StringStack<T>
{
    private Node<T> head;

    StringStackImpl() {head = null;}

    @Override
    public boolean isEmpty() {return head == null;}

    @Override
    public void push(T item) {head = new Node<T>(item, head);}

    @Override
    public T pop() throws NoSuchElementException 
    {
        if (isEmpty()) throw new NoSuchElementException();
        T temp = head.item;
        head = head.next;
        return temp;
    }

    @Override
    public T peek() throws NoSuchElementException
    {
        if (isEmpty()) throw new NoSuchElementException();
        return head.item;
    }

    @Override
    public void printStack(PrintStream stream) 
    {
        Node<T> temp = head;
        while(temp != null)
        {
            stream.println(temp.item);
            stream.flush();
            temp = temp.next;
        }
    }

    @Override
    public int size() 
    {
        int num = 0;
        Node<T> temp = head;
        
        if (!isEmpty()) 
        {
            while (temp != null) 
            {
                num ++;
                temp = temp.next;
            }
        }
        return num;
    }
}
