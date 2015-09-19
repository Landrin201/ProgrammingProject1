import java.awt.Rectangle;
/**
 * Write a description of class Class here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class makeRectangle
{
    /**
     * Constructor for objects of class Class
     */
    public static void main(String[] args)
    {
        // initialise instance variables
        Rectangle r1 = new Rectangle(100, 200);
        Rectangle r2 = new Rectangle(100, 200);
        Rectangle box = new Rectangle(5, 10, 20, 30);
        box.add(0, 0);
        System.out.println("x" + box.getX());
    }

}