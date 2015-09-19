import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;

/**
 * Demonstrates the use of an explicit iterator.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class POSClear
{
    /**
     * Reads a serialized Program of Study, then removes all courses that
     * don't have a grade.
     */
    public static void main(String[] args) throws Exception
    {
        ProgramOfStudy pos = ProgramOfStudy.load("ProgramOfStudy");

        System.out.println(pos);
        
        System.out.println("Removing courses with no grades.\n");
        
        Iterator<Course> itr = pos.iterator();
        while (itr.hasNext())
        {
            Course course = itr.next();
            if (!course.taken())
                itr.remove();
        }
        
        System.out.println(pos);
        
        pos.save("ProgramOfStudy");
    }
}