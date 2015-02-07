/**
 * 
 */
package dd;

import java.io.BufferedReader;
import java.io.File;
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

	
	public ArrayList<String> readKartei()
	{
		String karteiArray[] = new String[0];
		try
		{
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
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<String[]> readKartenListe()
	{
		ArrayList<String[]> kartenListe = new ArrayList<>();
		try
		{
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
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static ArrayList<String> readExistierendeKarteien()
	{
		ArrayList<String> interneKarteien = new ArrayList<String>();
		File[] dateien = new File(getStandardPfad()).listFiles();

		for (File datei : dateien)
		{
			if (datei.isFile() && datei.getName().contains(".csv"))
			{
				interneKarteien.add(datei.getAbsolutePath());
			}
		}
		
		return interneKarteien;
	}
	
	public static String getStandardPfad()
	{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		return path;
	}
	
	public void closeStream() throws IOException
	{
		if(this.fileReader != null)
		{
			this.fileReader.close();
		}
	}
	
	
}