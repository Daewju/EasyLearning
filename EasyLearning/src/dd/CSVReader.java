/**
 * 
 */
package dd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Damjan Djuranovic
 *
 */
public class CSVReader
{
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private static final String CSV_UNTERVERZEICHNIS = "\\dd\\CSV\\";
	private static final String STANDARD_PFAD = System.getProperty("java.class.path") + CSV_UNTERVERZEICHNIS;

	
	public CSVReader(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	
	private void initialisieren(String pfad) throws IOException
	{
		fileReader = new FileReader(pfad);
		bufferedReader = new BufferedReader(fileReader);
	}

	
	public ArrayList<String> getKartei()
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
					bufferedReader.close();
					fileReader.close();
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
	

	public ArrayList<String[]> getKartenListe()
	{
		ArrayList<String[]> kartenListe = new ArrayList<>();
		try
		{
			bufferedReader.readLine(); // überspringt die erste Zeile (Kartei)
			while (bufferedReader.ready())
			{
				String zeile = bufferedReader.readLine();
				if (zeile != null)
				{
					String karte[] = zeile.split(";");
					kartenListe.add(karte);
				} else
				{
					bufferedReader.close();
					fileReader.close();
					return kartenListe;
				}
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static ArrayList<String> getExistierendeKarteien()
	{
		ArrayList<String> interneKarteien = new ArrayList<String>();
		File[] dateien = new File(STANDARD_PFAD).listFiles();

		for (File datei : dateien)
		{
			if (datei.isFile() && datei.getName().contains(".csv"))
			{
				interneKarteien.add(datei.getAbsolutePath());
			}
		}
		
		return interneKarteien;
	}

}