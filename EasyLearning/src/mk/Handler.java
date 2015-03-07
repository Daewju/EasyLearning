/**
 * 
 * 
 */
package mk;
import dd.KarteiHandler;
import dd.SprachController;

import java.awt.Color;
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
	private SprachController sc;
	private Kartei usedKartei;
	private Karte usedKarte;
	private ArrayList<Karte> usedFach;
	private boolean ueberprueft;
	
	
	public Handler(GuiMain gui){
		this.gui = gui;
		this.ueberprueft = false;
		this.guiDialog = new GuiDialog(gui);
		this.usedKartei = null;
		this.usedKarte = null;
		this.usedFach = null;
		this.ueberprueft = false;
		
		try {
			this.sc = new SprachController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**				
	 * 				
	 * @param eingabeFeldErgebnis
	 * @param eingabeFeldErgebnis2									
	 * 				
	 */		
	@Override
	public void eventNeueKartei(String eingabeFeldErgebnis,
			String eingabeFeldErgebnis2)
	{
		KarteiHandler tempkh;
		Kartei kartei = new Kartei(eingabeFeldErgebnis, eingabeFeldErgebnis2);
		tempkh = new KarteiHandler(kartei);
		if(tempkh.dateiBereitsVorhanden()){
			tempkh = null;
			kartei = null;
			guiDialog.fehlerDialog(sc.getSprache("Fehler", gui.SPRACHCODE), sc.getSprache("Kartei schon vorhanden", gui.SPRACHCODE));
		}
		else{
			gui.versteckeAlleElemente(false);
			this.kh = tempkh;
			this.usedKartei = kartei;
			this.usedFach = this.usedKartei.gibFach(1);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			eventDateiSpeichern();
		}
		
		//System.out.println(eingabeFeldErgebnis + ", " + eingabeFeldErgebnis2);
	}

	@Override
	public void eventNaechsteKarte(String benutzerEingabe)
	{
		if(!ueberprueft){
			
			if(benutzerEingabe.equals(this.usedKarte.getWort())){
				gui.setSmiley(true);
				this.usedKarte.setRichtigB(this.usedKarte.getRichtigB()+1);
				this.gui.setWort(this.usedKarte.getWort());
				this.usedKartei.moveKarte(this.usedKarte, (this.usedKarte.getFach()+1));
				this.gui.setEingabefeld("");
				this.gui.setKartenFarbe(new Color(0,255,0));
			}
			else{
				gui.setSmiley(false);
				gui.setWort(this.usedKarte.getWort());
				//verschiebe Karte in Fach 1
				this.usedKartei.moveKarte(this.usedKarte, 1);
				this.gui.setEingabefeld("");
				this.gui.setKartenFarbe(new Color(255,0,0));
			}
			this.ueberprueft = true;
		}
		else{
			gui.setSmiley(false);
			this.gui.setKartenFarbe(new Color(0,255,255));
			
			//hole nächste Karte
			this.usedKarte = gibNaechsteKarte();
			gui.setWort(this.usedKarte.getVokabel());
			this.ueberprueft = false;
		}
		eventDateiSpeichern();
		
	}

	@Override
	public void eventNeueKarteHinzufuegen(String wort, String vokabel)
	{
		this.usedKartei.addKarte(new Karte(wort, vokabel), 1);
		eventDateiSpeichern();
 		if(this.usedKarte == null){
			this.usedKarte = this.usedFach.get(0);
			gui.setWort(this.usedKarte.getVokabel());
		}
		
	}

	@Override
	public void eventKarteBearbeiten(String wort, String vokabel)
	{
		this.usedKarte.setWort(wort);
		this.usedKarte.setVokabel(vokabel);
		eventDateiSpeichern();
		gui.setWort(this.usedKarte.getVokabel());
		
	}

	@Override
	public void eventKarteLoeschen(String wort)
	{
		if(this.usedKarte == null){
			guiDialog.fehlerDialog(sc.getSprache("Fehler",gui.SPRACHCODE), "Keine Karte zum Loeschen vorhanden.");
		}
		else{
			Karte temp = gibNaechsteKarte();
			this.usedKartei.removeKarte(this.usedKarte);
			this.usedKarte=temp;
			gui.setWort(this.usedKarte.getVokabel());
		}
		eventDateiSpeichern();
		
	}

	/*@Override
	public void eventNeueKarteiHinzufuegen(String hauptsprache, String fremdsprache)
	{
		
		
	}*/

	@Override
	public void eventGeheZuFach(int fach)
	{
		this.usedFach = this.usedKartei.gibFach(fach);
		this.usedKarte = gibNaechsteKarte();
		gui.setWort(this.usedKarte.getVokabel());
		
	}

	@Override
	public void eventDateiImportieren(String vollPfad, boolean fortschritt)
	{

		try {
			this.kh = new KarteiHandler(vollPfad);
			this.usedKartei = this.kh.dateiLesen(fortschritt);
			this.gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			this.usedFach = this.usedKartei.gibFach(1);
			this.usedKarte = gibNaechsteKarte();
			gui.setWort(this.usedKarte.getWort()); 
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gui.versteckeAlleElemente(false);	
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiExportieren(String vollPfad, boolean fortschritt)
	{
		kh.setKarteiPfad(vollPfad);
		try {
			kh.dateiSchreiben(this.usedKartei, fortschritt);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiOeffnen(String vollPfad)
	{
		gui.versteckeAlleElemente(false);
		try {
			this.kh = new KarteiHandler(vollPfad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.usedKartei = kh.dateiLesen(true);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
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
	public void eventDateiLoeschen()
	{
		try
		{
			if(!kh.loescheKartei(kh.getKarteiPfad()))
			{
				guiDialog.fehlerDialog("Error Kartei l�schen", "ACHTUNG: Datei ist noch in Verwendung oder nicht mehr vorhanden.");
			}
			else
			{
				gui.versteckeAlleElemente(true);
			}
			
		} catch (IOException e)
		{
			guiDialog.fehlerDialog("Error Kartei l�schen", "Schwerwiegender I/O-Fehler");
			e.printStackTrace();
		}	
	}


	@Override
	public void eventApplikationBeenden()
	{
		System.out.println("eventApplikationBeenden");
		
	}
	
	private Karte gibNaechsteKarte(){
		Karte temp;
		//ArrayList<Karte> f = this.usedKartei.gibFach(this.usedKarte.getFach());
		Random rand = new Random();
		temp = this.usedKarte;
		while(temp.equals(usedKarte)){ //verhindere dass zwei Mal dieselbe Karte gezogen wird
			temp = this.usedFach.get(rand.nextInt(this.usedFach.size()));
		}
		temp.setAufrufe(this.usedKarte.getAufrufe()+1);
		return temp;
	}

}
