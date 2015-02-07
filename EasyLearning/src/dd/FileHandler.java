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
import java.util.Locale;

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
	SimpleDateFormat datumFormat = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
	Date zeit = new Date();

	public FileHandler(String pfad) throws IOException
	{
		this.pfad = pfad;
	}

	public Kartei readKarteiFromFile(boolean fortschritt)
			throws ParseException, IOException
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
			Date erstellt = datumFormat.parse(karte[5]);
			Date bearbeitet = datumFormat.parse(karte[6]);

			Karte fertigeKarte;
			if (fortschritt)
			{
				fertigeKarte = new Karte(wort, vokabel, aufrufe, richtigB,
						fach, erstellt, bearbeitet);
			} else
			{

				fertigeKarte = new Karte(wort, vokabel, 0, 0, 0, zeit, zeit);
			}

			kartei.addKarte(fertigeKarte, fach);
		}
		cr.closeStream();
		return kartei;
	}

	public void writeKarteiToFile(Kartei kartei, boolean fortschritt)
			throws ParseException, IOException
	{
		cw = new CSVWriter(pfad);

		ArrayList<String> karteiArrayList = new ArrayList<>();
		karteiArrayList.add(kartei.getSprache());
		karteiArrayList.add(kartei.getFremdsprache());
		cw.writeKartei(karteiArrayList);
		ArrayList<ArrayList<Karte>> faecher = new ArrayList<>();
		faecher.add(kartei.getFach1());
		faecher.add(kartei.getFach2());
		faecher.add(kartei.getFach3());
		faecher.add(kartei.getFach4());
		faecher.add(kartei.getFach5());
		faecher.add(kartei.getFach6());
		ArrayList<String[]> karten = new ArrayList<>();
		for (ArrayList<Karte> fach : faecher)
		{
			for (Karte k : fach)
			{
				String[] karteS = new String[7];
				karteS[0] = k.getWort();
				karteS[1] = k.getVokabel();
				
				if (fortschritt)
				{
					karteS[2] = Integer.toString(k.getAufrufe());
					karteS[3] = Integer.toString(k.getRichtigB());
					karteS[4] = Integer.toString(k.getFach());
					karteS[5] = datumFormat.format(k.getErstellt());
					karteS[6] = datumFormat.format(k.getBearbeitet());
				}

				else
				{
					karteS[2] = "0";
					karteS[3] = "0";
					karteS[4] = "0";
					karteS[5] = datumFormat.format(zeit);
					karteS[6] = datumFormat.format(zeit);
				}
				
				karten.add(karteS);
			}
		}
		cw.writeKartenListe(karten);
		cw.closeStream();
	}

	/**
	 * @return the cr
	 */
	public CSVReader getCr()
	{
		return cr;
	}

	/**
	 * @param cr
	 *            the cr to set
	 */
	public void setCr(CSVReader cr)
	{
		this.cr = cr;
	}

	/**
	 * @return the cw
	 */
	public CSVWriter getCw()
	{
		return cw;
	}

	/**
	 * @param cw
	 *            the cw to set
	 */
	public void setCw(CSVWriter cw)
	{
		this.cw = cw;
	}

	/**
	 * @return the pfad
	 */
	public String getPfad()
	{
		return pfad;
	}

	/**
	 * @param pfad
	 *            the pfad to set
	 */
	public void setPfad(String pfad)
	{
		this.pfad = pfad;
	}

}
