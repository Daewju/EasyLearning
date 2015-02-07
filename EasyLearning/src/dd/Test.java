package dd;

import java.io.IOException;
import java.text.ParseException;

import mk.Kartei;

public class Test
{

	public static void main(String[] args) throws IOException, ParseException
	{
	//	CSVReader cr = new CSVReader(CSVReader.getStandardPfad() + "\\deutsch-englisch.csv");
	//	ArrayList<String> kartei = cr.readKartei();
	//	ArrayList<String[]> kartenListe = cr.readKartenListe();
	//	cr.closeStream();
	//	CSVWriter cw = new CSVWriter(CSVReader.getStandardPfad() + "\\deutsch-englisch.csv");
	//	cw.writeKartei(kartei);
	//	cw.writeKartenListe(kartenListe);
	//	cw.closeStream();
		
		// Beispiel zum eine Kartei aus einer Datei zu lesen
		FileHandler fh = new FileHandler ("C:\\Users\\Alpha0\\Desktop" + "\\testWrite.csv");
		Kartei kartei = fh.readKarteiFromFile(true);
		fh.setPfad("C:\\Users\\Alpha0\\Desktop" + "\\neuuuuuuuuu.csv");
		fh.writeKarteiToFile(kartei, true);
	}

}
