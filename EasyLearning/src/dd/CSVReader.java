/**
 * WICHTIG: Diese Klasse nur in Sonderfällen verwenden. Die Klasse FileHandler.java
 * benutzt diese Klasse, dies vereinfacht die Handhabung ungemein.
 * 
 * Diese Klasse liest aus einer vorhandenen CSV-Datei die jeweiligen Zeilen aus
 * und generiert daraus eine ArrayList<String> für die Kartei und ArrayList<String[]>
 * für die Karten. Alle möglichen Exceptionbehandlungen werden an den Benutzer diser
 * Klasse weitergereicht. Für dieses Projekt ist der GUI-Entwickler zuständig diese 
 * zu behandeln und dem Benutzer zu visualisieren.
 */
package dd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Damjan Djuranovic
 * @version 1.0
 */
public class CSVReader
{
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	/**
	 * @param pfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String. Zu
	 *            beachten gilt, dass in Java ein "\" für Escapen wie z.B. "\n"
	 *            gedacht ist. Daher muss ein Pfad mit doppeltem Backslash
	 *            übergeben werden. Beispiel: "C:\\Beispiel\\beispiel.csv".
	 * @throws IOException
	 */
	public CSVReader(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	/**
	 * Diese Methode wird nur vom Konstruktor verwendet.
	 * 
	 * @param pfad
	 *            Siehe Konstruktor.
	 * @throws IOException
	 */
	private void initialisieren(String pfad) throws IOException
	{
		if (pfad != null && pfad.contains(".csv") && pfad.contains("\\"))
		{
			System.out.println("Test");
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
	 * Die Methode liest aus einer CSV die Kartei-Informationen.
	 * 
	 * @return Rückgabetyp ist eine ArrayLists<String>. Sollte die Datei nicht
	 *         gelesen werden können, wird NULL zurückgegeben. Die
	 *         ArrayList<String> enthält die beiden Datenfelder der Klasse
	 *         Kartei als String. Sprache1 und Sprache2.
	 * @throws IOException
	 */
	public ArrayList<String> readKartei() throws IOException
	{
		String karteiArray[] = new String[0];
		String zeile = bufferedReader.readLine();
		ArrayList<String> kartei = new ArrayList<>();

		if (bufferedReader.ready())
		{
			if (zeile != null)
			{
				karteiArray = zeile.split(";");

				for (int i = 0; i < karteiArray.length; i++)
				{
					kartei.add(karteiArray[i]);
				}
				return kartei;
			}
		}
		return null;
	}

	/**
	 * Die Methode liest aus einer CSV die Karten-Informationen
	 * 
	 * @return Rückgabetyp ist eine ArrayList<String[]>. Sollte die Datei nicht
	 *         glesen werden können, wird NULL zurückgeben. Die
	 *         ArrayList<String[]> enthält die Karten, welche wiederum die
	 *         Informationen in einem Array enhält. (Wort, Vokabel, Aufrufe,
	 *         RichtigB, Fach, Erstetllt, Bearbeitet)
	 * @throws IOException
	 */
	public ArrayList<String[]> readKartenListe() throws IOException
	{
		ArrayList<String[]> kartenListe = new ArrayList<>();
		if (bufferedReader.ready())
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
		}
		return null;
	}

	/**
	 * Die Methode schliesst alle offenen Streams zu den Dateien. Nach jeder
	 * abgeschlossener Arbeit an den Dateien, muss der Stream zwingend
	 * geschlossen werden.
	 * 
	 * @title dlfdl
	 * @throws IOException
	 */
	public void closeStream() throws IOException
	{
		if (this.fileReader != null)
		{
			this.fileReader.close();
		}
	}

}