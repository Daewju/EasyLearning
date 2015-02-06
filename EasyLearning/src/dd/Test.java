package dd;

import java.io.IOException;
import java.util.ArrayList;

public class Test
{

	public static void main(String[] args) throws IOException
	{
		CSVReader cr = new CSVReader(CSVReader.getStandardPfad() + "\\deutsch-englisch.csv");
		ArrayList<String> kartei = cr.readKartei();
		ArrayList<String[]> kartenListe = cr.readKartenListe();
		cr.closeStream();
		CSVWriter cw = new CSVWriter(CSVReader.getStandardPfad() + "\\deutsch-englisch.csv");
		cw.writeKartei(kartei);
		cw.writeKartenListe(kartenListe);
		cw.closeStream();
	}

}
