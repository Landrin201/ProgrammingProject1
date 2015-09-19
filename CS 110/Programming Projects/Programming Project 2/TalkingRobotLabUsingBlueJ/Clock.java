//import java.util.Calendar;
import java.util.Random;

/**
 * Talking Robot: <br>
 * The Clock class is a "stub" for a class that should return the
 * hour of the current time of day as represented by a 24-hour clock
 * (in other words, in the range of 0 .. 23).  Objects of the class do
 * not actually return the current hour, however; instead they return a
 * random hour.
 * <br> <br>
 * Created: <br>
 *   2 April 2008,  Alyce Brady<br>
 * 
 * @author Alyce Brady
 * @version 2 April 2008
 */
public class Clock
{
    /**
     * Returns an hour in the range of 0 - 23.  (Should be the hour of
     * the current time of day, but is actually a random hour.)
     * 
     * @return     the hour 
     */
    public int getHour()
    {
        Random generator = new Random();
        return generator.nextInt(24);   // returns a number from 0 to 23
    }
}
