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


	/**
	 * @return the csvUnterverzeichnis
	 */
	public static String getCsvUnterverzeichnis()
	{
		return CSV_UNTERVERZEICHNIS;
	}


	/**
	 * @return the standardPfad
	 */
	public static String getStandardPfad()
	{
		return STANDARD_PFAD;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CSVReader [fileReader=" + fileReader + ", bufferedReader="
				+ bufferedReader + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bufferedReader == null) ? 0 : bufferedReader.hashCode());
		result = prime * result
				+ ((fileReader == null) ? 0 : fileReader.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSVReader other = (CSVReader) obj;
		if (bufferedReader == null)
		{
			if (other.bufferedReader != null)
				return false;
		} else if (!bufferedReader.equals(other.bufferedReader))
			return false;
		if (fileReader == null)
		{
			if (other.fileReader != null)
				return false;
		} else if (!fileReader.equals(other.fileReader))
			return false;
		return true;
	}
	
	
}