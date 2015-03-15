package dd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * WICHTIG: Diese Klasse nur in Sonderfällen verwenden. Um Karteien zu
 * speichern, bitte die Klasse KarteiHandler benutzten.
 * 
 * Die Klasse schreibt in eine CSV mit einer ArrayList als Input. Die oberste
 * Zeile beschreibt die Kartei. Die darauf folgenden Zeilen beschreiben jeweils
 * eine Karte die einer Kartei angehört. Alle möglichen Exceptionbehandlungen
 * werden an den Benutzer dieser Klasse weitergereicht.
 * 
 * @author Damjan Djuranovic
 * @version 1.11
 */
public class CSVWriter
{
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;

	/**
	 * @param pfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String.
	 * @throws IOException
	 */
	public CSVWriter(String pfad) throws IOException
	{
		initialisieren(pfad);
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
			fileWriter = new FileWriter(pfad);
			bufferedWriter = new BufferedWriter(fileWriter);
		}

		else
		{
			throw new IllegalArgumentException(
					"Pfad entspricht nicht den Kriterien. Siehe Javadoc!");
		}
	}

	/**
	 * Diese Methode schreibt in eine CSV die erste Zeile, welche die
	 * Infomationen über die Kartei speichert.
	 * 
	 * @param kartei
	 *            Es wird eine ArrayList mit folgenden Strings erwartet. Sprache
	 *            und Fremdsprache in dieser Reihenfolge.
	 * @throws IOException
	 */
	public void schreibeKartei(ArrayList<String> kartei) throws IOException
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

		else
		{
			throw new IllegalArgumentException("Kartei ist NULL!");
		}
	}

	/**
	 * Diese Methode schreibt die Karten in eine CSV.
	 * 
	 * @param karten
	 *            Es wird eine ArrayList mit Strings in einem Array erwartet.
	 *            Die Strings im Array haben folgende Reihenfolge: Wort,
	 *            Vokabel, Aufrufe, RichtigB, Fach, Erstetllt, Bearbeitet.
	 * @throws IOException
	 */
	public void schreibeKarten(ArrayList<String[]> karten) throws IOException
	{
		if (karten != null)
		{
			for (String karte[] : karten)
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

		else
		{
			throw new IllegalArgumentException("Karten ist NULL!");
		}
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
		if (this.fileWriter != null)
		{
			this.fileWriter.close();
		}
		if(this.bufferedWriter != null)
		{
			this.bufferedWriter.close();
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
		return "CSVWriter [fileWriter=" + fileWriter + ", bufferedWriter="
				+ bufferedWriter + "]";
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
				+ ((bufferedWriter == null) ? 0 : bufferedWriter.hashCode());
		result = prime * result
				+ ((fileWriter == null) ? 0 : fileWriter.hashCode());
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
		CSVWriter other = (CSVWriter) obj;
		if (bufferedWriter == null)
		{
			if (other.bufferedWriter != null)
				return false;
		} else if (!bufferedWriter.equals(other.bufferedWriter))
			return false;
		if (fileWriter == null)
		{
			if (other.fileWriter != null)
				return false;
		} else if (!fileWriter.equals(other.fileWriter))
			return false;
		return true;
	}

	/**
	 * @return the fileWriter
	 */
	public FileWriter getFileWriter()
	{
		return fileWriter;
	}

	/**
	 * @param fileWriter
	 *            the fileWriter to set
	 */
	public void setFileWriter(FileWriter fileWriter)
	{
		this.fileWriter = fileWriter;
	}

	/**
	 * @return the bufferedWriter
	 */
	public BufferedWriter getBufferedWriter()
	{
		return bufferedWriter;
	}

	/**
	 * @param bufferedWriter
	 *            the bufferedWriter to set
	 */
	public void setBufferedWriter(BufferedWriter bufferedWriter)
	{
		this.bufferedWriter = bufferedWriter;
	}

}