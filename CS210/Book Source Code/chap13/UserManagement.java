import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates the use of a map to manage a set of objects.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class UserManagement
{
	/**
	 * Creates and populates a group of users. Then prompts for interactive
	 * searches, and finally prints all users.
	 */
	public static void main(String[] args) throws IOException
	{
		Users users = new Users();
		
		users.addUser(new User("fziffle", "Fred", "Ziffle"));
		users.addUser(new User("geoman57", "Marco", "Kane"));
		users.addUser(new User("rover322", "Kathy", "Shear"));
		users.addUser(new User("appleseed", "Sam", "Geary"));
		users.addUser(new User("mon2016", "Monica", "Blankenship"));
		
		Scanner scan = new Scanner(System.in);
		String uid;
		User user;
		
		do
		{
			System.out.print("Enter User Id (DONE to quit): ");
			uid = scan.nextLine();
			if (!uid.equalsIgnoreCase("DONE"))
			{
				user = users.getUser(uid);
				if (user == null)
					System.out.println("User not found.");
				else
					System.out.println(user);
			}
		} while (!uid.equalsIgnoreCase("DONE"));

		// print all users
		System.out.println("\nAll Users:\n");
		for (String userId : users.getUserIds())
			System.out.println(users.getUser(userId));
	}
}
