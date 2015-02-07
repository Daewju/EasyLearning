/**
 * 
 */
package dd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Damjan Djuranovic
 *
 */
public class CSVReader
{
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public CSVReader(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	
	private boolean initialisieren(String pfad) throws IOException
	{
		if(pfad != null)
		{
			fileReader = new FileReader(pfad);
			bufferedReader = new BufferedReader(fileReader);
			return true;
		}
			return false;
	}

	
	public ArrayList<String> readKartei() throws IOException
	{
		String karteiArray[] = new String[0];
	
			String zeile = bufferedReader.readLine();
			if (bufferedReader.ready())
			{
				if (zeile != null)
				{
					karteiArray = zeile.split(";");

					ArrayList<String> kartei = new ArrayList<>();
					
					for (int i = 0; i < karteiArray.length; i++)
					{
						kartei.add(karteiArray[i]);
					}

					return kartei;
				}
			}
		return null;
	}
	

	public ArrayList<String[]> readKartenListe() throws IOException
	{
		ArrayList<String[]> kartenListe = new ArrayList<>();

			while (bufferedReader.ready())
			{
				String zeile = bufferedReader.readLine();
				if (zeile != null)
				{
					String karte[] = zeile.split(";");
					kartenListe.add(karte);
				}
			}
			return kartenListe;
	}

	
	public void closeStream() throws IOException
	{
		if(this.fileReader != null)
		{
			this.fileReader.close();
		}
	}
	
	
}