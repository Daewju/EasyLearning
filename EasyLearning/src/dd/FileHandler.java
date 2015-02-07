/**
 * 
 */
package dd;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import mk.Karte;
import mk.Kartei;

/**
 * @author Alpha0
 *
 */
public class FileHandler
{
	private CSVReader cr;
	private CSVWriter cw;
	private String pfad;

	public FileHandler(String pfad) throws IOException
	{
		this.pfad = pfad;

	}

	public Kartei readKarteiFromFile() throws ParseException, IOException
	{
		cr = new CSVReader(pfad);
		ArrayList<String> csvKartei = cr.readKartei();
		Kartei kartei;
		Iterator it = csvKartei.iterator();
		kartei = new Kartei((String) it.next(), (String) it.next());
		ArrayList<String[]> karten = cr.readKartenListe();

		for (String karte[] : karten)
		{
			String wort = karte[0];
			String vokabel = karte[1];
			int aufrufe = Integer.parseInt(karte[2]);
			int richtigB = Integer.parseInt(karte[3]);
			int fach = Integer.parseInt(karte[4]);
			SimpleDateFormat erstelltSDF = new SimpleDateFormat(
					"dd.MM.yyyy HH:mm:ss");
			SimpleDateFormat bearbeitetSDF = new SimpleDateFormat(
					"dd.MM.yyyy HH:mm:ss");
			Date erstellt = erstelltSDF.parse(karte[5]);
			Date bearbeitet = bearbeitetSDF.parse(karte[6]);

			Karte fertigeKarte = new Karte(wort, vokabel, aufrufe, richtigB,
					fach, erstellt, bearbeitet);

			kartei.addKarte(fertigeKarte, fach);
		}
		cr.closeStream();
		return kartei;
	}

	public boolean writeKarteiFromFile() throws ParseException, IOException
	{
		cw = new CSVWriter(pfad);
		
		return false;
	}
}
