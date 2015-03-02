/**
 * 
 */
package mk;
import dd.KarteiHandler;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import sp.GuiDialog;
import sp.GuiMain;
import sp.GuiSchnittstelle;
/**
 * @author marko
 *
 */
public class Handler implements GuiSchnittstelle{
	private GuiMain gui;
	private GuiDialog guiDialog;
	private KarteiHandler kh;
	private Kartei usedKartei;
	private Karte usedKarte;
	private int usedFach;
	private boolean ueberprueft;
	
	public Handler(GuiMain gui){
		this.gui = gui;
		this.ueberprueft = false;
		
	}
	

	@Override
	public void eventNeueKartei(String eingabeFeldErgebnis,
			String eingabeFeldErgebnis2)
	{
		gui.versteckeAlleElemente(false);
		Kartei kartei = new Kartei(eingabeFeldErgebnis, eingabeFeldErgebnis2);
		this.usedKartei = kartei;
		
		//System.out.println(eingabeFeldErgebnis + ", " + eingabeFeldErgebnis2);
	}

	@Override
	public void eventNaechsteKarte(String benutzerEingabe)
	{
		if(!ueberprueft){
			
			if(benutzerEingabe.equals(this.usedKarte.getWort())){
				gui.setSmiley(true);
				this.usedKarte.setRichtigB(this.usedKarte.getRichtigB()+1);
			}
			else{
				gui.setSmiley(false);
				
			}
			this.ueberprueft = true;
		}
		else{
			gui.setSmiley(false);
			Karte temp;
			ArrayList<Karte> f = this.usedKartei.gibFach(this.usedKarte.getFach());
			Random rand = new Random();
			
			//verschiebe Karte in Fach 1
			this.usedKartei.moveKarte(this.usedKarte, 1);
			
			//hole nächste Karte
			temp = this.usedKarte;
			while(temp.equals(usedKarte)){ //verhindere dass zwei Mal dieselbe Karte gezogen wird
				this.usedKarte = f.get(rand.nextInt(f.size()));
			}
			this.usedKarte.setAufrufe(this.usedKarte.getAufrufe()+1);
			gui.setWort(usedKarte.getVokabel());
			this.ueberprueft = false;
		}
		
	}

	@Override
	public void eventNeueKarteHinzufuegen(String wort, String vokabel)
	{
		this.usedKartei.addKarte(new Karte(wort, vokabel), 1);		
	}

	@Override
	public void eventKarteBearbeiten(String wort, String vokabel)
	{
		this.usedKarte.setWort(wort);
		this.usedKarte.setVokabel(vokabel);
	}

	@Override
	public void eventKarteLoeschen(String wort)
	{
		System.out.println(wort);
		
	}

	@Override
	public void eventNeueKarteiHinzufuegen(String hauptsprache, String fremdsprache)
	{
		
		
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
		try {
			kh.dateiSchreiben(this.usedKartei, true);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			guiDialog.fehlerDialog("Error Kartei erstellen", "ACHTUNG: Kartei konnte nicht erstellt werden.");
			
		}
		
	}

	@Override
	public void eventApplikationBeenden()
	{
		System.out.println("eventApplikationBeenden");
		
	}

}
