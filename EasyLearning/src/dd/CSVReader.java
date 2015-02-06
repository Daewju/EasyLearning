/**
 * 
 */
package dd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Alpha0
 *
 */
public class CSVReader
{
	private FileReader f;
	private BufferedReader b;
	private ArrayList<String> karteiListe;

	public CSVReader() throws IOException
	{
		f = new FileReader("C:\\Users\\Alpha0\\Desktop\\test.csv");
		b = new BufferedReader(f);
		karteiListe = new ArrayList<>();
	}

	public ArrayList<String> getKarteiListe()
	{
		try
		{
			while (b.readLine() != null)
			{
				karteiListe.add(b.readLine());
			}
			return karteiListe;

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}