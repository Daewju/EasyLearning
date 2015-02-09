package dd;

import java.io.IOException;
import java.text.ParseException;

import mk.Karte;
import mk.Kartei;

public class Test
{

	public static void main(String[] args)
	{
		Kartei kartei = new Kartei("deutsch", "englisch");
		kartei.addKarte(new Karte("Auto", "Car"), 1);
		FileHandler filehandler = new FileHandler(kartei);
		try
		{
			filehandler.schreibeDateiVonKartei(kartei, true);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
