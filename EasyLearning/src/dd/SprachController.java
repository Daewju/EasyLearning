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
				.getResourceAsStream("/data/sprache.csv"), "Cp1252"));
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SprachController [bufferedReader=" + bufferedReader + ", cr="
				+ cr + ", sprache=" + sprache + "]";
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
		result = prime * result + ((cr == null) ? 0 : cr.hashCode());
		result = prime * result + ((sprache == null) ? 0 : sprache.hashCode());
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
		SprachController other = (SprachController) obj;
		if (bufferedReader == null)
		{
			if (other.bufferedReader != null)
				return false;
		} else if (!bufferedReader.equals(other.bufferedReader))
			return false;
		if (cr == null)
		{
			if (other.cr != null)
				return false;
		} else if (!cr.equals(other.cr))
			return false;
		if (sprache == null)
		{
			if (other.sprache != null)
				return false;
		} else if (!sprache.equals(other.sprache))
			return false;
		return true;
	}

	/**
	 * @return the bufferedReader
	 */
	public BufferedReader getBufferedReader()
	{
		return bufferedReader;
	}

	/**
	 * @param bufferedReader the bufferedReader to set
	 */
	public void setBufferedReader(BufferedReader bufferedReader)
	{
		this.bufferedReader = bufferedReader;
	}

	/**
	 * @return the cr
	 */
	public CSVReader getCr()
	{
		return cr;
	}

	/**
	 * @param cr the cr to set
	 */
	public void setCr(CSVReader cr)
	{
		this.cr = cr;
	}

	/**
	 * @return the sprache
	 */
	public ArrayList<String[]> getSprache()
	{
		return sprache;
	}

	/**
	 * @param sprache the sprache to set
	 */
	public void setSprache(ArrayList<String[]> sprache)
	{
		this.sprache = sprache;
	}
	
	
}
