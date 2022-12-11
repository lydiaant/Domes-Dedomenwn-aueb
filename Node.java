public class Node <T>
{
    protected T item;
    protected Node<T> next;
        
    Node(T item)
    {
        this.item = item;
        next = null; 
    }

    Node(T item, Node<T> next) 
    {
        this.item = item; 
        this.next = next; 
    }

    public T getItem() {return item;}

    public Node<T> getNext() {return next;}

    public void setNext(Node<T> next) {this.next = next;}
}