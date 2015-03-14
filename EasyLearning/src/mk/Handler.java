/**
 * 
 * 
 */
package mk;
import dd.KarteiHandler;
import dd.SprachController;

import java.awt.Color;
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
		KarteiHandler.ordnerErstellen();
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
			//this.usedFach = this.usedKartei.gibFach(1);
			eventGeheZuFach(1);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			eventDateiSpeichern();
		}
		
		//System.out.println(eingabeFeldErgebnis + ", " + eingabeFeldErgebnis2);
	}

	@Override
	public void eventNaechsteKarte(String benutzerEingabe)
	{
		if(!ueberprueft){
			
			if(benutzerEingabe.equals(this.usedKarte.getVokabel())){
				this.gui.setSmiley(true);
				this.usedKarte.setRichtigB(this.usedKarte.getRichtigB()+1);
				this.gui.setWort(this.usedKarte.getVokabel());
				this.usedKartei.moveKarte(this.usedKarte, (this.usedKarte.getFach()+1));
				this.gui.setEingabefeld("");
				this.gui.setKartenFarbe(gibFarbe("r"));
			}
			else{
				this.gui.setSmiley(false);
				this.gui.setWort(this.usedKarte.getVokabel());
				//verschiebe Karte in Fach 1
				this.usedKartei.moveKarte(this.usedKarte, 1);
				this.gui.setEingabefeld("");
				this.gui.setKartenFarbe(gibFarbe("f"));
			}
			this.usedKarte.setAufrufe(this.usedKarte.getAufrufe()+1);
			setUeberprueft(true);
		}
		else{
			this.gui.versteckeSmiley();;
			this.gui.setKartenFarbe(gibFarbe("d"));
			zeigeNaechsteKarte();
			setUeberprueft(false);
		}
		gui.repaint();
		eventDateiSpeichern();
		
	}

	@Override
	public void eventNeueKarteHinzufuegen(String wort, String vokabel)
	{
		try{
			this.usedKartei.addKarte(new Karte(wort, vokabel), 1);
			eventDateiSpeichern();
	 		if(this.usedKarte == null){
				zeigeNaechsteKarte();
			}
		}
		catch(IllegalArgumentException e){
			guiDialog.infoDialog(sc.getSprache("Info",gui.SPRACHCODE), sc.getSprache("Karte bereits vorhanden",gui.SPRACHCODE));
			
		}
		
	}

	@Override
	public void eventKarteBearbeiten(String wort, String vokabel)
	{
		this.usedKarte.setWort(wort);
		this.usedKarte.setVokabel(vokabel);
		eventDateiSpeichern();
		gui.setWort(this.usedKarte.getWort());
		
	}

	@Override
	public void eventKarteLoeschen(String wort)
	{
		if(this.usedKarte == null){
			guiDialog.infoDialog(sc.getSprache("Info",gui.SPRACHCODE), sc.getSprache("Keine Karte zum Loeschen vorhanden",gui.SPRACHCODE));
		}
		else{
			this.usedKartei.removeKarte(this.usedKarte);
			zeigeNaechsteKarte();	
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
		if(this.usedFach!=this.usedKartei.gibFach(fach)){
			this.usedFach = this.usedKartei.gibFach(fach);
			zeigeNaechsteKarte();
			this.gui.versteckeSmiley();;
			this.gui.setKartenFarbe(gibFarbe("d"));
			this.gui.repaint();
		}	
	}

	@Override
	public void eventDateiImportieren(String vollPfad, boolean fortschritt)
	{

		try {
			this.kh = new KarteiHandler(vollPfad);
			this.usedKartei = this.kh.dateiLesen(fortschritt);
			this.gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			eventGeheZuFach(1);
			gui.versteckeAlleElemente(false);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",gui.SPRACHCODE));
			e.printStackTrace();
		}
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiExportieren(String vollPfad, boolean fortschritt)
	{
		String temp = kh.getKarteiPfad();
		kh.setKarteiPfad(vollPfad);
		try {
			kh.dateiSchreiben(this.usedKartei, fortschritt);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",gui.SPRACHCODE));
			e.printStackTrace();
		}
		kh.setKarteiPfad(temp);
		System.out.println(vollPfad + ", " + fortschritt);
		
	}

	@Override
	public void eventDateiOeffnen(String vollPfad)
	{
			this.kh = new KarteiHandler(vollPfad);
		try {
			this.usedKartei = kh.dateiLesen(true);
			eventGeheZuFach(1);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			gui.versteckeAlleElemente(false);
			
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",gui.SPRACHCODE));
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
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",gui.SPRACHCODE));
			
		}
		
	}
	
	@Override
	public void eventDateiLoeschen()
	{
		try
		{
			if(!kh.loescheKartei(kh.getKarteiPfad()))
			{
				guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Datei ist noch in Verwendung oder nicht mehr vorhanden",gui.SPRACHCODE));
			}
			else
			{
				gui.versteckeAlleElemente(true);
			}
			
		} catch (IOException e)
		{
			this.guiDialog.fehlerDialog(this.sc.getSprache("Fehler",gui.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",gui.SPRACHCODE));
			e.printStackTrace();
		}	
	}
	
	@Override
	public void eventSpracheUmgestellt(){
		this.gui.setWort(this.sc.getSprache("Fach ist leer",gui.SPRACHCODE));
	}


	@Override
	public void eventApplikationBeenden()
	{
		if(this.kh!=null){
			eventDateiSpeichern();
		}
		System.exit(0);
		
	}
	
	private Karte gibNaechsteKarte(){
		Karte temp;
		//ArrayList<Karte> f = this.usedKartei.gibFach(this.usedKarte.getFach());
		Random rand = new Random();
		temp = this.usedKarte;
		
		if(this.usedFach.size()==1){
			//temp = this.usedFach.get(rand.nextInt(this.usedFach.size()));
			temp = this.usedFach.get(0);
		}
		else if(this.usedFach.size()==0)
		{
			return null;
		}
		else{
			
			if(this.usedKarte==null){
				temp = this.usedFach.get(rand.nextInt(this.usedFach.size()));
			}
			else{
				while(temp.equals(usedKarte)){ //verhindere dass zwei Mal dieselbe Karte gezogen wird
					temp = this.usedFach.get(rand.nextInt(this.usedFach.size()));
				}
			}
		}
		//temp.setAufrufe(temp.getAufrufe()+1);
		return temp;
	}
	
	private void zeigeNaechsteKarte(){
		this.usedKarte = gibNaechsteKarte();
		if(this.usedKarte!=null){
			this.gui.setWort(this.usedKarte.getWort());
		}
		else{
			this.gui.setWort(sc.getSprache("Fach ist leer",gui.SPRACHCODE));
		}
	}
	
	public void setUeberprueft(boolean status){
		this.ueberprueft = status;
	}

	@Override
	public void eventZuruecksetzen()
	{
		KarteiHandler.ordnerLoeschen();
		gui.versteckeAlleElemente(true);
	}
	
	private Color gibFarbe(String farbe){
		switch(farbe){
			case "r": 	return new Color(0,255,0);
						
			case "f":	return new Color(255,0,0);
						
			case "d":	return new Color(0,255,255);
						
			default:	return new Color(0,255,255);
		}
	}

	/**
	 * @return the usedKartei
	 */
	public Kartei getUsedKartei() {
		return usedKartei;
	}

	/**
	 * @param usedKartei the usedKartei to set
	 */
	public void setUsedKartei(Kartei usedKartei) {
		this.usedKartei = usedKartei;
	}

	/**
	 * @return the usedKarte
	 */
	public Karte getUsedKarte() {
		return usedKarte;
	}

	/**
	 * @param usedKarte the usedKarte to set
	 */
	public void setUsedKarte(Karte usedKarte) {
		this.usedKarte = usedKarte;
	}

	/**
	 * @return the usedFach
	 */
	public ArrayList<Karte> getUsedFach() {
		return usedFach;
	}

	/**
	 * @param usedFach the usedFach to set
	 */
	public void setUsedFach(ArrayList<Karte> usedFach) {
		this.usedFach = usedFach;
	}

	
}
