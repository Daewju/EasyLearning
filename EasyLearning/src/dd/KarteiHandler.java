package dd;

import java.io.File;
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
 * Diese Klasse wird zum lesen und schreiben von Karteien in eine CSV-Datei
 * verwendet. Jede CSV-Datei symbolisiert eine Kartei. Der Standard-Pfad der
 * Karteien liegt im Ordner 'Karteien' neben der JAR-Datei. Die Klasse bietet
 * eine statische Methode um vor Erzeugung eines Objektes zu prüfen welche
 * CSV-Dateien bereits vorhanden sind. Alle möglichen Exceptionbehandlungen
 * werden an den Benutzer dieser Klasse weitergereicht.
 * 
 * @author Damjan Djuranovic
 * @version 1.11
 *
 */
public class KarteiHandler
{
	private static File ordner;
	private static SimpleDateFormat datumFormat = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);;
	private CSVReader cr;
	private CSVWriter cw;
	private String karteiPfad;

	/**
	 * Dieser Konstruktor kann benutzt werden, wenn die Datei ausserhalb des
	 * Standardpfades liegt oder liegen soll, z.B. beim Import oder Export.
	 * 
	 * @param karteiPfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String. Zu
	 *            beachten gilt, dass in Java ein "\" für Escapen wie z.B. "\n"
	 *            gedacht ist. Daher muss ein Pfad mit doppeltem Backslash
	 *            übergeben werden. Beispiel: "C:\\Beispiel\\beispiel.csv".
	 * @throws IOException
	 */
	public KarteiHandler(String karteiPfad) throws IOException
	{
		if (karteiPfad.equals(".csv") && karteiPfad.equals("\\"))
		{
			this.karteiPfad = karteiPfad;
		} else
		{
			throw new IllegalArgumentException(
					"Pfad entspricht nicht den Kriterien. Siehe Javadoc!");
		}
	}

	/**
	 * Dieser Konstruktor kann benutzt werden, wenn die Datei am Standardpfad
	 * liegt oder gespeichert werden soll. Der Standardpfad ist der Ort an dem
	 * die .jar liegt in einem Unterordner 'Karteien'. Der Pfad kann natuerlich
	 * spaeter auch manuell geaendert werden.
	 * 
	 * @param kartei
	 *            Erwartet wird eine Kartei. Mit Hilfe der darin befindlichen
	 *            Datenfelder Sprache und Fremdsprache und des Standardpfades
	 *            wird der entsprechende Pfad automatisch generiert.
	 */
	public KarteiHandler(Kartei kartei)
	{
		ordner = new File("Karteien");

		if (kartei != null)
		{
			if (!ordner.exists())
			{
				ordner.mkdir();
			}
			this.karteiPfad = getStandardPfad() + "\\" + ordner + "\\"
					+ kartei.getName() + ".csv";
		}

		else
		{
			throw new IllegalArgumentException("Kartei ist NULL!");
		}
	}

	/**
	 * Diese Methode kann benutzt werden um eine komplette Kartei aus einer
	 * CSV-Datei zu laden.
	 * 
	 * @param fortschritt
	 *            "True" lässt den gesamten Fortschritt des Lernenden
	 *            importieren. "False" dagegen übernimmt nur die Wortpaare und
	 *            setzt das Datum und die Uhrzeit auf die aktuelle Zeit.
	 *            Ausserdem werden dann alle Karten in das erste Fach gelegt.
	 * @return Es wird eine Kartei zurückgegeben.
	 * @throws ParseException
	 * @throws IOException
	 */
	public Kartei dateiLesen(boolean fortschritt) throws ParseException,
			IOException
	{
		cr = new CSVReader(karteiPfad);
		ArrayList<String> csvKartei = cr.leseKartei();
		ArrayList<String[]> karten = cr.leseKarten();
		Kartei kartei;
		Iterator<String> it = csvKartei.iterator();

		kartei = new Kartei((String) it.next(), (String) it.next());

		for (String karte[] : karten)
		{
			String wort = karte[0];
			String vokabel = karte[1];
			int aufrufe;
			int richtigB;
			int fach;
			Date erstellt;
			Date bearbeitet;

			if (fortschritt)
			{
				aufrufe = Integer.parseInt(karte[2]);
				richtigB = Integer.parseInt(karte[3]);
				fach = Integer.parseInt(karte[4]);
				erstellt = datumFormat.parse(karte[5]);
				bearbeitet = datumFormat.parse(karte[6]);
			}

			else
			{
				Date zeit = new Date();
				aufrufe = 0;
				richtigB = 0;
				fach = 1;
				erstellt = zeit;
				bearbeitet = zeit;
			}

			Karte fertigeKarte;

			fertigeKarte = new Karte(wort, vokabel, aufrufe, richtigB, fach,
					erstellt, bearbeitet);

			kartei.addKarte(fertigeKarte, fach);
		}
		cr.schliesseStream();
		return kartei;
	}

	/**
	 * Diese Methode kann benutzt werden um eine komplette Kartei in eine
	 * CSV-Datei zu schreiben.
	 * 
	 * @param kartei
	 *            Hier wird eine Kartei als Parameter erwartet.
	 * @param fortschritt
	 *            "True" lässt den gesamten Fortschritt des Lernenden in die
	 *            CSV-Datei schreiben. "False" dagegen übernimmt nur die
	 *            Wortpaare und setzt das Datum und die Uhrzeit auf die aktuelle
	 *            Zeit. Ausserdem werden Alle Karten in das erste Fach gelegt.
	 * @throws ParseException
	 * @throws IOException
	 */
	public void dateiSchreiben(Kartei kartei, boolean fortschritt)
			throws ParseException, IOException
	{
		cw = new CSVWriter(karteiPfad);

		ArrayList<String> karteiArrayList = new ArrayList<>();
		karteiArrayList.add(kartei.getSprache());
		karteiArrayList.add(kartei.getFremdsprache());
		cw.schreibeKartei(karteiArrayList);

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
					Date zeit = new Date();
					karteS[2] = "0";
					karteS[3] = "0";
					karteS[4] = "1";
					karteS[5] = datumFormat.format(zeit);
					karteS[6] = datumFormat.format(zeit);
				}

				karten.add(karteS);
			}
		}
		cw.schreibeKarten(karten);
		cw.schliesseStream();
	}

	/**
	 * Diese Methode kann benutzt werden um zu prüfe ob sich bereits Karteien im
	 * CSV-Format im Unterordner 'Karteien' befinden. Die Methode ist statisch
	 * und benoetigt keine Instatnz von KarteiHandler.
	 * 
	 * @return Gibt eine ArrayList mit den Pfaden zurück, wahlweise der
	 *         komplette Pfad oder nur der Name der Kartei.
	 * @param nurKarteiName
	 *            "False" gibt den kompletten Pfad zurück, "True" dagegen nur
	 *            den Titel der Kartei, z.b. "deutsch-englisch".
	 */
	public static ArrayList<String> leseExistierendeKarteiPfade(
			boolean nurKarteiName)
	{
		ArrayList<String> interneKarteien = new ArrayList<String>();
		File[] dateien = new File(getStandardPfad() + "\\" + ordner + "\\")
				.listFiles();

		for (File datei : dateien)
		{
			if (datei.isFile() && datei.getName().contains(".csv")
					&& !nurKarteiName)
			{
				interneKarteien.add(datei.getAbsolutePath());
			} else if (datei.isFile() && datei.getName().contains(".csv")
					&& nurKarteiName)
			{
				interneKarteien.add(datei.getName().replaceAll(".csv", ""));
			}
		}

		return interneKarteien;
	}

	/**
	 * Diese Methode kann benutzt werden um den Pfad der aktuell liegenden JAR
	 * herausfinden zu können. Die Methode ist statisch und benoetigt keine
	 * Instanz von KarteiHandler.
	 * 
	 * @return Komplett-Pfad der JAR auf dem Filesystem.
	 */
	public static String getStandardPfad()
	{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		return path;
	}

	/**
	 * Diese Methode sollte vor jedem Schreiben benutzt werden um zu überprüfen
	 * ob eine solche CSV-Datei bereits vorhanden ist. Wäre dies nämlich so,
	 * würde sie dann überschrieben werden! Falls eine gleichnamige Kartei
	 * erstellt wird, sollte dies überprüft werden.
	 * 
	 * @return "True" für bereites-vorhanden, "False" für nicht-vorhanden.
	 */
	public boolean dateiBereitsVorhanden()
	{
		File datei = new File(karteiPfad);
		if (datei.isFile())
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	/**
	 * Diese Methode kann benutzt werden um den Arbeitspfad dens KarteiHandlers
	 * zu ändern. z.B. nachdem der Lernende die Kartei wechselt.
	 * 
	 * @param karteiPfad
	 *            Erwartet wird ein kompletter Pfad des Datentyps String. Zu
	 *            beachten gilt, dass in Java ein "\" für Escapen wie z.B. "\n"
	 *            gedacht ist. Daher muss ein Pfad mit doppeltem Backslash
	 *            übergeben werden. Beispiel: "C:\\Beispiel\\beispiel.csv".
	 * @return "True" wenn der Pfad angenommen wurde, ansonsnten "False".
	 */
	public boolean setKarteiPfad(String karteiPfad)
	{
		if (karteiPfad.equals(".csv") && karteiPfad.equals("\\"))
		{
			this.karteiPfad = karteiPfad;
			return true;
		} else
		{
			return false;
		}
	}
}
