package dd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Diese Klasse kann benutzt werden um die vier Sprachen aus einer CSV-Datei zu
 * lesen. Um den Code für die GUI lesbarer zu machen, wurde der SprachController
 * so implementiert, dass nur eine einzige Methode zur Verfügung steht und diese
 * nur das deutsche Wort / Satz als Parameter erwartet und den Sprachcode, der
 * für die Ausgabe dient. Sollte sich das Wort / Satz nicht in der CSV-Datei
 * finden, wird das deutsche Wort zurückgegeben. Die CSV-Datei liegt im Ordner 'Data'
 * 
 * @author Damjan Djuranovic
 *
 */
public class SprachController
{
	private String sprachePfad;
	private ArrayList<String[]> sprache;

	/**
	 * Konstruktor setzt Pfad der CSV-Datei, die im Ordner 'data' liegt.
	 */
	public SprachController()
	{
		sprachePfad = FileHandler.getStandardPfad()
				+ "\\bin\\data\\sprache.csv";
		sprache = new ArrayList<>();
	}

	/**
	 * @param deutsch Hier wird das deutsche Wort / Satz erwartet, Gross- und Kleinschreibung beachten, muss exakt sein!
	 * @param sprachcode 0: Deutsch, 1: Englisch, 2: Franzoesisch, 3: Italienisch
	 * @return String in Fremdsprache
	 */
	public String getSprache(String deutsch, int sprachcode)
	{
		CSVReader cr = null;
		try
		{
			cr = new CSVReader(sprachePfad);
			sprache = cr.leseKarten();
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
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return deutsch;
	}
}
