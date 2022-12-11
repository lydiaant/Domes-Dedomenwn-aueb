public class Point
{
    private int x;
    private int y;
    private char value;

    Point(int x, int y, char value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    
    public int getX() {return x;}
    
    public void setX(int x) {this.x = x;}
    
    public int getY() {return y;}
    
    public void setY(int y) {this.y = y;}
    
    public char getValue() {return value;}
    
    public void setValue(char value) {this.value = value;}

    public String toString() {return "x: " + x + " y: " + y + " value: " + value + "\n";}
}