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
	 *            Erwartet wird ein kompletter Pfad des Datentyps String. Zu
	 *            beachten gilt, dass in Java ein "\" für Escapen wie z.B. "\n"
	 *            gedacht ist. Daher muss ein Pfad mit doppeltem Backslash
	 *            übergeben werden. Beispiel: "C:\\Beispiel\\beispiel.csv".
	 * @throws IOException
	 */
	private void initialisieren(String pfad) throws IOException
	{
		if (pfad != null && pfad.contains(".csv") && pfad.contains("\\"))
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
	 * Die Methode liest aus einer CSV die Karten-Informationen oder Sprach-Informationen
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
	}
	
}