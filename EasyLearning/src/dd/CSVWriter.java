/**
 * 
 */
package dd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Damjan Djuranovic
 *
 */
public class CSVWriter
{
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;

	public CSVWriter(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	private boolean initialisieren(String pfad) throws IOException
	{
		if (pfad != null)
		{
			fileWriter = new FileWriter(pfad);
			bufferedWriter = new BufferedWriter(fileWriter);
			return true;
		}
		return false;
	}

	public void writeKartei(ArrayList<String> kartei) throws IOException
	{
		if (kartei != null)
		{
			String zeile = "";
			for (String feld : kartei)
			{
				zeile += feld + ";";
			}

				bufferedWriter.write(zeile);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			
		}
	}

	public void writeKartenListe(ArrayList<String[]> kartenListe) throws IOException
	{
		if (kartenListe != null)
		{
			for (String karte[] : kartenListe)
			{
				String zeile = "";
				for (int i = 0; i < karte.length; i++)
				{
					zeile += karte[i] + ";";
				}
				bufferedWriter.write(zeile);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}
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
		if (this.fileWriter != null)
		{
			this.fileWriter.close();
		}
	}

}