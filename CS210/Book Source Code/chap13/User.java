/**
 * Represents a user with a userid.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class User
{
	private String userId;
	private String firstName;
	private String lastName;
	
	/**
	 * Sets up this user with the specified information.
	 * 
	 * @param userId a user identification string
	 * @param firstName the user's first name
	 * @param lastName the user's last name
	 */
	public User(String userId, String firstName, String lastName)
	{
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Returns the user id of this user.
	 * 
	 * @return the user id of the user
	 */
	public String getUserId()
	{
		return userId;
	}
	
	/**
	 * Returns a string representation of this user.
	 * 
	 * @return a string representation of the user
	 */
	public String toString()
	{
		return userId + ":\t" + lastName + ", " + firstName;
	}
}
