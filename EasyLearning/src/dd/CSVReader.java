package dd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * WICHTIG: Diese Klasse nur in Sonderfällen verwenden. Um Karteien zu laden,
 * bitte die Klasse KarteiHandler benutzten. Um Sprachen zu laden, bitte die
 * Klasse SprachController benutzen.
 * 
 * Diese Klasse liest aus einer vorhandenen CSV-Datei die jeweiligen Zeilen aus
 * und generiert daraus eine ArrayList für die Kartei und ArrayList für die
 * Karten.
 * 
 * @author Damjan Djuranovic
 * @version 1.11
 */
public class CSVReader
{
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	/**
	 * Dieser Konstruktor wird vom KarteiHandler verwendet.
	 * 
	 * @param pfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String.
	 * @throws IOException
	 */
	public CSVReader(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	/**
	 * Dieser Konstruktor wird vom SprachController verwendet.
	 * 
	 * @param bufferedReader
	 *            Ewartet einen BufferedReader, der den Pfad der sprache.csv
	 *            enthaelt.
	 * @throws IOException
	 */
	public CSVReader(BufferedReader bufferedReader) throws IOException
	{
		if (bufferedReader != null)
		{
			this.bufferedReader = bufferedReader;
		}
	}

	/**
	 * Diese Methode wird vom Konstrutkor verwendet. Sie initialisiert die
	 * Datenfelder und schmeisst eine Exception falls der Pfad nicht korrekt
	 * formatiert ist.
	 * 
	 * @param pfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String.
	 * @throws IOException
	 */
	private void initialisieren(String pfad) throws IOException
	{
		if (pfad != null && pfad.contains(".csv"))
		{
			fileReader = new FileReader(pfad);
			bufferedReader = new BufferedReader(fileReader);
		}

		else
		{
			throw new IllegalArgumentException(
					"Pfad entspricht nicht den Kriterien. Siehe Javadoc!");
		}
	}

	/**
	 * Die Methode liest aus einer CSV die Kartei-Informationen. In diesem
	 * Projekt ist dies die erste Zeile.
	 * 
	 * @return Rückgabetyp ist eine ArrayList. Sollte die Datei nicht gelesen
	 *         werden können, wird NULL zurückgegeben. Die ArrayList enthält die
	 *         beiden Datenfelder der Klasse Kartei als String. Sprache und
	 *         Fremdsprache.
	 * @throws IOException
	 */
	public ArrayList<String> leseKartei() throws IOException
	{
		String karteiArray[] = new String[0];
		String zeile;
		ArrayList<String> kartei = new ArrayList<>();

		if (bufferedReader.ready()
				&& (zeile = bufferedReader.readLine()) != null)
		{
			karteiArray = zeile.split(";");

			for (int i = 0; i < karteiArray.length; i++)
			{
				kartei.add(karteiArray[i]);
			}
			return kartei;
		}
		return null;
	}

	/**
	 * Die Methode liest aus einer CSV die Karten-Informationen oder
	 * Sprach-Informationen
	 * 
	 * @return Rückgabetyp ist eine ArrayList. Sollte die Datei nicht glesen
	 *         werden können, wird NULL zurückgeben. Die ArrayList enthält die
	 *         Karten, welche wiederum die Informationen in einem Array enhält.
	 *         Die Reihenfolge ist folgende: Wort, Vokabel, Aufrufe, RichtigB,
	 *         Fach, Erstetllt, Bearbeitet.
	 * @throws IOException
	 */
	public ArrayList<String[]> leseKarten() throws IOException
	{
		ArrayList<String[]> kartenListe = new ArrayList<>();
		if (bufferedReader.ready())
		{
			String zeile;
			while (bufferedReader.ready()
					&& (zeile = bufferedReader.readLine()) != null)
			{
				if (zeile != null)
				{
					String karte[] = zeile.split(";");
					kartenListe.add(karte);
				}
			}
			return kartenListe;
		}
		return null;
	}

	/**
	 * Die Methode schliesst alle offenen Streams zu den Dateien. Nach jeder
	 * abgeschlossener Arbeit an den Dateien, muss der Stream zwingend
	 * geschlossen werden.
	 * 
	 * @throws IOException
	 */
	public void schliesseStream() throws IOException
	{
		if (this.fileReader != null)
		{
			this.fileReader.close();
		}
		if (bufferedReader != null)
		{
			this.bufferedReader.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CSVReader [fileReader=" + fileReader + ", bufferedReader="
				+ bufferedReader + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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

	/**
	 * @return the fileReader
	 */
	public FileReader getFileReader()
	{
		return fileReader;
	}

	/**
	 * @param fileReader
	 *            the fileReader to set
	 */
	public void setFileReader(FileReader fileReader)
	{
		this.fileReader = fileReader;
	}

	/**
	 * @return the bufferedReader
	 */
	public BufferedReader getBufferedReader()
	{
		return bufferedReader;
	}

	/**
	 * @param bufferedReader
	 *            the bufferedReader to set
	 */
	public void setBufferedReader(BufferedReader bufferedReader)
	{
		this.bufferedReader = bufferedReader;
	}

}