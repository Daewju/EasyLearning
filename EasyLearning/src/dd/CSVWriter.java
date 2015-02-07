package dd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * WICHTIG: Diese Klasse nur in Sonderfällen verwenden. Die Klasse
 * FileHandler.java benutzt diese Klasse, dies vereinfacht die Handhabung
 * ungemein.
 * 
 * Die Klasse schreibt in eine CSV mit einer ArrayList als Input. Die oberste
 * Zeile beschreibt die Kartei. Die darauf folgenden Zeilen beschreiben jeweils
 * eine Karte die einer Kartei angehört. Alle möglichen Exceptionbehandlungen
 * werden an den Benutzer dieser Klasse weitergereicht. Für dieses Projekt ist
 * der GUI-Entwickler zuständig diese zu behandeln und dem Benutzer zu
 * visualisieren.
 * 
 * @author Damjan Djuranovic
 * @version 1.0
 */
public class CSVWriter
{
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;

	/**
	 * @param pfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String. Zu
	 *            beachten gilt, dass in Java ein "\" für Escapen wie z.B. "\n"
	 *            gedacht ist. Daher muss ein Pfad mit doppeltem Backslash
	 *            übergeben werden. Beispiel: "C:\\Beispiel\\beispiel.csv".
	 * @throws IOException
	 */
	public CSVWriter(String pfad) throws IOException
	{
		initialisieren(pfad);
	}

	/**
	 * Diese Methode wird nur vom Konstrutkor verwendet. Sie initialisiert die
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
	 * Infomationen über diese speichert.
	 * 
	 * @param kartei
	 *            Es wird eine ArrayList mit folgenden Strings erwartet.
	 *            Sprache1 und Sprache2. Als Parameter muss eine Kartei
	 *            übergeben werden.
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
	}

}