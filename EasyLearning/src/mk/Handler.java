/**
 * 
 * 
 */
package mk;
import dd.KarteiHandler;
import dd.SprachController;

import java.awt.Color;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import sp.GuiDialog;
import sp.GuiMain;
import sp.GuiSchnittstelle;
import sp.GuiSmileyStatistik;
import sp.GuiStatistik;

/**
 * Diese Klasse koordiniert alle Aktionen und Mutationen welche an den 
 * Karteien,Karten & Fächern während der Laufzeit vorgenommen werden.
 * Dazu gehört auch die Abwicklung aller Userinputs und Outputs.
 * Wobei die Logik auf dem System von Sebastian Leitner aufbaut.
 * 
 * 
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
	
	/**
	 * Initialisiert einen Objetkt von Handler.
	 * Der Konstruktor verlangt eine Referenz auf ein GuiMain Objekt um
	 * spaeter mit die Komponenten der Gui ansprechen zu koennen.
	 * 
	 * @param gui	Referenz auf Objekt der Klasse GuiMain
	 */
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
	 * Erstellt ein Objekt der Klasse Kartei. Der Name wird ueber die erwarteten				
	 * Strings definiert. Dabei wird ueberprueft ob bereits eine Kartei mit selbem
	 * Namen existiert (Wenn Ja wird neue Kartei nicht erstellt).
	 * Die neue Kartei wird nach Erstellung sofort angezeigt und das Fach auf 1 gestellt.
	 *  
	 * @param eingabeFeldErgebnis	Hauptsprache der Kartei als String
	 * @param eingabeFeldErgebnis2	Fremdsprache der Kartei als String									
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
			guiDialog.fehlerDialog(sc.getSprache("Fehler", GuiMain.SPRACHCODE), sc.getSprache("Kartei schon vorhanden", GuiMain.SPRACHCODE));
		}
		else{
			gui.versteckeAlleElemente(false);
			this.kh = tempkh;
			this.usedKartei = kartei;
			eventGeheZuFach(1);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			eventDateiSpeichern();
		}
		
		
	}
	/**
	 *	Ueberprueft bei erster Ausfuehrung die Worteingabe des Users und fuehrt
	 *	dementsprechend weitere Schritte durch. Bei zweiter Ausfuehrung (ueberprueft = true)
	 *	wird die naechste Karte ausgegeben.
	 *	Wort richtig >positiven Smiley anzeigen > Karte in hoeheres Fach verschieben.
	 *	Wort falsch >negativen Smiley anzeigen > Karte in Fach 1 verschieben.
	 *	
	 *	@param benutzerEingabe	Eingabe des Users als String
	 */
	@Override
	public void eventNaechsteKarte(String benutzerEingabe)
	{
		if(!ueberprueft){
			
			if(benutzerEingabe.equals(this.usedKarte.getVokabel())){
				this.gui.setSmiley(true);
				this.usedKarte.setRichtigB(this.usedKarte.getRichtigB()+1);
				this.gui.setWort(this.usedKarte.getVokabel());
				this.usedKartei.moveKarte(this.usedKarte, (this.usedKarte.getFach()+1));
				this.gui.setKartenFarbe(gibFarbe("r"));
			}
			else{
				this.gui.setSmiley(false);
				this.gui.setWort(this.usedKarte.getVokabel());
				//verschiebe Karte in Fach 1
				this.usedKartei.moveKarte(this.usedKarte, 1);
				this.gui.setKartenFarbe(gibFarbe("f"));
			}
			this.gui.setEingabefeld("");
			this.usedKarte.setAufrufe(this.usedKarte.getAufrufe()+1);
			this.usedKarte.setBearbeitet(new Date());
			setUeberprueft(true);
		}
		else{
			this.gui.versteckeSmiley();;
			this.gui.setKartenFarbe(gibFarbe("d"));
			this.gui.setEingabefeld("");
			zeigeNaechsteKarte();
			setUeberprueft(false);
		}
		this.gui.versteckeStatistik(false);
		gui.repaint();
		eventDateiSpeichern();
		
	}
	
	/**
	 * Erstellt eine neue Karte und fuegt diese dem Fach1 der aktuellen Kartei hinzu, 
	 * falls dieses Wortbar nicht bereits existiert.
	 * 
	 * @param	wort	zu lernendes Wort als String
	 * @param	vokabel	entsprechende Vokabel als String
	 */
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
			guiDialog.infoDialog(sc.getSprache("Info",GuiMain.SPRACHCODE), sc.getSprache("Karte bereits vorhanden",GuiMain.SPRACHCODE));
			
		}
	}
	
	/**
	 *	Aendert das Wort und Vokabel einer Karte auf die ueber
	 *	Parameter erwarteten Werte. Wobei die alten Werte
	 *	ueberschrieben werden.
	 *
	 *	@param	wort	Wort neu als String
	 *	@param	vokabel Vokabel neu als String
	 */
	@Override
	public void eventKarteBearbeiten(String wort, String vokabel)
	{
		this.usedKarte.setWort(wort);
		this.usedKarte.setVokabel(vokabel);
		eventDateiSpeichern();
		gui.setWort(this.usedKarte.getWort());
		
	}

	/**
	 * Loescht die aktuell behandelte/angezeigte Karte aus der Kartei
	 * und gibt daraufhin die nachste Karte aus. 
	 * 
	 * @param	wort	zu loeschendes Wort als String
	 */
	@Override
	public void eventKarteLoeschen(String wort)
	{
		if(this.usedKarte == null){
			guiDialog.infoDialog(sc.getSprache("Info",GuiMain.SPRACHCODE), sc.getSprache("Keine Karte zum Loeschen vorhanden",GuiMain.SPRACHCODE));
		}
		else{
			this.usedKartei.removeKarte(this.usedKarte);
			zeigeNaechsteKarte();	
		}
		eventDateiSpeichern();
		
	}


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
			//read desired Kartei file
			this.kh = new KarteiHandler(vollPfad);
			this.usedKartei = this.kh.dateiLesen(fortschritt);
			//create Kartei file at default folder
			this.kh = new KarteiHandler(this.usedKartei);
			this.kh.dateiSchreiben(this.usedKartei, fortschritt);
			
			this.gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			eventGeheZuFach(1);
			gui.versteckeAlleElemente(false);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",GuiMain.SPRACHCODE));
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
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",GuiMain.SPRACHCODE));
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
			gui.versteckeAlleElemente(false);
			eventGeheZuFach(1);
			gui.setKarteiTitel(usedKartei.getSprache() + " - " + usedKartei.getFremdsprache());
			
			
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",GuiMain.SPRACHCODE));
			e.printStackTrace();
		}
	}

	@Override
	public void eventDateiSpeichern()
	{
		try {
			kh.dateiSchreiben(this.usedKartei, true);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",GuiMain.SPRACHCODE));
			
		}
		
	}
	
	@Override
	public void eventDateiLoeschen()
	{
		try
		{
			if(!kh.loescheKartei(kh.getKarteiPfad()))
			{
				guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Datei ist noch in Verwendung oder nicht mehr vorhanden",GuiMain.SPRACHCODE));
			}
			else
			{
				gui.versteckeAlleElemente(true);
			}
			
		} catch (IOException e)
		{
			this.guiDialog.fehlerDialog(this.sc.getSprache("Fehler",GuiMain.SPRACHCODE), this.sc.getSprache("Schwerwiegender I/O-Fehler",GuiMain.SPRACHCODE));
			e.printStackTrace();
		}	
	}
	
	@Override
	public void eventSpracheUmgestellt(){
		this.gui.setWort(this.sc.getSprache("Fach ist leer",GuiMain.SPRACHCODE));
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
			
			GuiStatistik statistik = gui.getguiSmileyStatistik().getGuiStatistik();
	
			NumberFormat n = NumberFormat.getInstance();
			n.setMaximumFractionDigits(2);
			
			statistik.setStatistik( ""+this.usedFach.size(),
									""+this.usedKarte.getAufrufe(),
									""+n.format((double)(this.usedKarte.getRichtigB()*100)/this.usedKarte.getAufrufe())+"%",
									dateToString(this.usedKarte.getErstellt()),
									dateToString(this.usedKarte.getBearbeitet())
									);
			this.gui.versteckeStatistik(true);
		}
		else{
			this.gui.setWort(sc.getSprache("Fach ist leer",GuiMain.SPRACHCODE));
			this.gui.versteckeStatistik(false);
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
	
	private String dateToString(Date date) throws NullPointerException{
		
		if(date!=null){
			String datum = null;
			
			switch(date.getDate()){
				case 1: datum="01";
						break;
				case 2: datum="02";
						break;
				case 3: datum="03";
						break;
				case 4: datum="04";
						break;
				case 5: datum="05";
						break;
				case 6: datum="06";
						break;
				case 7: datum="07";
						break;
				case 8: datum="08";
						break;
				case 9: datum="09";
						break;
				default: datum=""+date.getDate();
						break;
			}
			
			switch(date.getMonth()){
				case 1: datum=datum+".01";
						break;
				case 2: datum=datum+".02";
						break;
				case 3: datum=datum+".03";
						break;
				case 4: datum=datum+".04";
						break;
				case 5: datum=datum+".05";
						break;
				case 6: datum=datum+".06";
						break;
				case 7: datum=datum+".07";
						break;
				case 8: datum=datum+".08";
						break;
				case 9: datum=datum+".09";
						break;
				default: datum=datum+"."+date.getMonth();
						break;
			}
			
			datum = datum +"."+(date.getYear()+1900)+"  ";
			
			switch(date.getHours()){
				case 0: datum=datum+"00";
						break;
				case 1: datum=datum+"01";
						break;
				case 2: datum=datum+"02";
						break;
				case 3: datum=datum+"03";
						break;
				case 4: datum=datum+"04";
						break;
				case 5: datum=datum+"05";
						break;
				case 6: datum=datum+"06";
						break;
				case 7: datum=datum+"07";
						break;
				case 8: datum=datum+"08";
						break;
				case 9: datum=datum+"09";
						break;
				default: datum=datum+""+date.getHours();
						break;
			}
			
			switch(date.getMinutes()){
				case 0: datum=datum+":00";
						break;
				case 1: datum=datum+":01";
						break;
				case 2: datum=datum+":02";
						break;
				case 3: datum=datum+":03";
						break;
				case 4: datum=datum+":04";
						break;
				case 5: datum=datum+":05";
						break;
				case 6: datum=datum+":06";
						break;
				case 7: datum=datum+":07";
						break;
				case 8: datum=datum+":08";
						break;
				case 9: datum=datum+":09";
						break;
				default: datum=datum+":"+date.getMinutes();
						break;
			}
			
			return datum;
		}
		else{
			throw new NullPointerException("Date object missing");
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
