package dd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Diese Klasse kann benutzt werden um die vier Sprachen aus einer CSV-Datei zu
 * lesen. Um den Code für die GUI lesbarer zu machen, wurde der SprachController
 * so implementiert, dass der deutsche String als Parameter erwartet wird.
 * Sollte sich der String nicht in der CSV-Datei finden lassen, wird das
 * deutsche Wort zurückgegeben um wenigstens etwas anzuzeigen. Die CSV-Datei
 * liegt im Ordner 'Data' und kann mit dem TextEditor oder Excel editiert
 * werden.
 * 
 * @author Damjan Djuranovic
 * @version 1.11
 *
 */
public class SprachController
{
	private BufferedReader bufferedReader;
	private CSVReader cr;
	private ArrayList<String[]> sprache;

	/**
	 * Konstruktor
	 * 
	 * @throws IOException
	 */
	public SprachController() throws IOException
	{
		bufferedReader = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream("/data/sprache.csv")));
		cr = new CSVReader(bufferedReader);
		sprache = new ArrayList<>();
		sprache = cr.leseKarten();
		cr.schliesseStream();
	}

	/**
	 * @param deutsch
	 *            Hier wird das deutsche Wort / Satz erwartet, Gross- und
	 *            Kleinschreibung beachten, muss exakt sein!
	 * @param sprachcode
	 *            0: Deutsch, 1: Englisch, 2: Franzoesisch, 3: Italienisch
	 * @return String in Fremdsprache
	 */
	public String getSprache(String deutsch, int sprachcode)
	{
		if (sprache != null)
		{
			for (String wort[] : sprache)
			{
				if (deutsch != null && sprachcode >= 0 && sprachcode <= 3)
				{
					if (wort[0].equals(deutsch))
					{
						return wort[sprachcode];
					}
				}

			}
		}
		return deutsch;
	}
}
