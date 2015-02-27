/**
 * 
 */
package mk;
import java.awt.event.ActionEvent;

import sp.GuiMain;
import sp.GuiSchnittstelle;
/**
 * @author marko
 *
 */
public class Handler implements GuiSchnittstelle{
	private GuiMain gui;
	
	public Handler(GuiMain gui){
		this.gui = gui;
		
	}
	
//	Sry für das, han aber die Methodene brucht, damit GUI-Klasse kein Fehler azeigt und ich mini 3400 Zeile Code teste chan :D

	@Override
	public void eventNeueKartei(String eingabeFeldErgebnis,
			String eingabeFeldErgebnis2)
	{
		gui.versteckeAlleElemente(false);
		System.out.println(eingabeFeldErgebnis + ", " + eingabeFeldErgebnis2);
	}

	@Override
	public void eventNaechsteKarte(String benutzerEingabe)
	{
		System.out.println(benutzerEingabe);
		
	}

	@Override
	public void eventNeueKarteHinzufuegen(String wort, String vokabel)
	{
		System.out.println(wort + ", " + vokabel);
		
	}

	@Override
	public void eventKarteBearbeiten(String wort, String vokabel)
	{
		System.out.println(wort + ", " + vokabel);
		
	}

	@Override
	public void eventKarteLoeschen(String wort)
	{
		System.out.println(wort);
		
	}

	@Override
	public void eventNeueKarteiHinzufuegen(String hauptsprache, String fremdsprache)
	{
		System.out.println(hauptsprache + ", " + fremdsprache);
		
	}

	@Override
	public void eventGeheZuFach(int fach)
	{
		System.out.println(fach);
		
	}

	@Override
	public void eventDateiImportieren(String vollPfad, boolean fortschritt)
	{
		gui.versteckeAlleElemente(false);
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiExportieren(String vollPfad, boolean fortschritt)
	{
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiOeffnen(String vollPfad)
	{
		gui.versteckeAlleElemente(false);
		System.out.println(vollPfad);
		
	}

	@Override
	public void eventDateiSpeichern()
	{
		System.out.println("eventDateiSpeichern");
		
	}

	@Override
	public void eventApplikationBeenden()
	{
		System.out.println("eventApplikationBeenden");
		
	}

}
