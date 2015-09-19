import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A URL domain blocker.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class DomainBlocker
{
	private TreeSet<String> blockedSet;
	
	/**
	 * Sets up the domain blocker by reading in the blocked domain names from
	 * a file and storing them in a TreeSet.
	 * @throws FileNotFoundException
	 */
	public DomainBlocker() throws FileNotFoundException
	{
		blockedSet = new TreeSet<String>();
		
		File inputFile = new File("blockedDomains.txt");
		Scanner scan = new Scanner(inputFile);
		
		while (scan.hasNextLine())
		{
			blockedSet.add(scan.nextLine());
		}
	}
	
	/**
	 * Checks to see if the specified domain has been blocked.
	 * 
	 * @param domain the domain to be checked
	 * @return true if the domain is blocked and false otherwise
	 */
	public boolean domainIsBlocked(String domain)
	{
		return blockedSet.contains(domain);
	}
}
