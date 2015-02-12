package dd;

import java.io.IOException;
import java.text.ParseException;

import mk.Karte;
import mk.Kartei;

public class Test
{
	public Test()
	{
		Karte karte = new Karte("Auto", "Car");
		Karte karte2 = new Karte("Haus", "House");
		Kartei kartei = new Kartei("deutsch", "englisch");
		kartei.addKarte(karte, 1);
		kartei.addKarte(karte2, 1);

		KarteiHandler kh = new KarteiHandler(kartei);
		try
		{
			kh.dateiSchreiben(kartei, true);
		} catch (ParseException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
