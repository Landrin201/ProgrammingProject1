import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataFileCreator
{
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		String[] codes = {"BR742", "TJ991", "DX555", "WL812", "YG904", "NP466",
				"WL310", "BV693", "TT232", "UI294", "DX699", "LH933", "OB311",
				"WL023", "HR588", "CB329", "EW231", "VA838", "LF845", "GB637"};
		
		Random gen = new Random();
		
		PrintWriter out = new PrintWriter(new FileWriter("salesData.txt"));
		
		for (int i = 1; i < 1384; i++)
		{
			out.println(codes[gen.nextInt(codes.length)]);
		}
		
		System.out.println("File written.");
		
		out.close();
	}
}
