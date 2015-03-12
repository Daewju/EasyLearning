package mk;	
import java.lang.IllegalArgumentException;	
import java.util.ArrayList;	
import java.util.Iterator;	

/**	
 * 	Diese Klasse spiegelt die eigentliche Kartei wieder in welcher die Lernkarten verwaltet und 
 * 	abgelegt werden. Die Karten werden dabei in sechs ArrayList Objekten verwaltet. Wobei jede 
 * 	ArrayList fuer ein Fach der Kartei steht (Fach 1-6).
 * 	Neben den Karten enthaelt jede Kartei die Information, welche Sprachen behandelt werden.
 * 
 *	@author marko	
 *	@version 1.1	
 */	
public class Kartei {	

	private String sprache;
	private String fremdsprache;
	private String name;
	private ArrayList<Karte> fach1;
	private ArrayList<Karte> fach2;
	private ArrayList<Karte> fach3;	
	private ArrayList<Karte> fach4;	
	private ArrayList<Karte> fach5;	
	private ArrayList<Karte> fach6;	


	public Kartei(String sprache, String fremdsprache){	
		this.sprache = sprache;
		this.fremdsprache = fremdsprache;
		this.name = sprache + "-" + fremdsprache;
		this.fach1 = new ArrayList<Karte>();
		this.fach2 = new ArrayList<Karte>();
		this.fach3 = new ArrayList<Karte>();
		this.fach4 = new ArrayList<Karte>();
		this.fach5 = new ArrayList<Karte>();
		this.fach6 = new ArrayList<Karte>();

	}	

	/**	
	 * Fuegt ein Objekt der Klasse Karte einem Fach der aktuellen Kartei hinzu. Das Ziel-Fach wird
	 * ueber den Parameter "fach" festgelegt.
	 * 
	 * @param	karte	Referenz auf Karten-Objekt welches dem Fach hinzugefuegt werden soll.
	 * 		  		
	 * @param 	fach	INT-Wert welches der Fachnummer entspricht,
	 * 					in der die Karte hinzugefuegt werden soll. (z.B. 3 = Fach 3.)	  		
	 * 		  		
	 * @return	boolean (true = erfolgreich /false = fehlgeschlagen)
	 * @throws 	IllegalArgumentException	
	 */	
	public boolean addKarte(Karte karte, int fach) throws IllegalArgumentException{	
		
		if(karte!=null && fach >=1 && fach <=6)				
		{			
			ArrayList<Karte> f = gibFach(fach);
			
			if(f.isEmpty() || existKarte(karte)){ //goes into if fach is not empty or card doesnt exist	
				return f.add(karte);
			}		
		}			

		return false;			
	}				

	/**				
	 * Entfernt ein bestimmtes Karten-Objekt aus dem Fach in dem sich dieses momentan befindet. 
	 * Als Rueckgabe wird das zuvor entfernte Karten-Objekt zurueckgegeben.
	 * 			
	 * @param 	karte	Erwartet wird eine Referenz auf das Karten-Objekt
	 * 					welches geloescht/entfernt werden soll.							 	
	 * 		
	 * @return	Referenz auf Karten-Objekt das aus dem Fach entfernt wurde.						
	 */				
	public Karte removeKarte(Karte karte){
		
		ArrayList<Karte> f = gibFach(karte.getFach());					
		//Iterator<Karte> it = f.iterator();	
		int c = 0;

		while(c<f.size()){			
			
			if(f.get(c).equals(karte)){
				return f.remove(c);
			}		
			c++;
		}			
		return null;			
	}		
	
	/**				
	 * Verschiebt uebergebenes Objekt der Klasse Karte in das im Parameter "fach" angegeben Fach der aktuellen Kartei.		
	 * 
	 * @param 	karte	Erwartet wird eine Referenz auf das Karten-Objekt welches
	 * 					verschoben werden soll.
	 * 						
	 * @param 	fach	INT-Wert welcher f�r die Fachnummer steht in welches die
	 * 					Karte verschoben wird. (z.B. 3 = Fach 3)	  			
	 */		
	public void moveKarte(Karte karte, int fach){
		
		if(fach>=1 && fach<=6){
			ArrayList<Karte> f = gibFach(fach);
			f.add(removeKarte(karte));
			karte.setFach(fach);
		}
				
	}

	/**				
	 * Ueberprueft ob bereits eine Karte mit demselben Wortpaar in der Kartei existiert.
	 *  	
	 * @param it	
	 * 					
	 * @param	karte	Objekt der Klasse Karte welches geprueft werden soll.		
	 * 				
	 * @return	boolean (true = Karte existiert nicht  /false = Karte existiert)	
	 * @throws IllegalArgumentException		
	 */		
	private boolean existKarte(Karte karte) throws IllegalArgumentException{		
		Karte k;
		Iterator<Karte> it;
		for(int i=1;i<7;i++){
			it=gibFach(i).iterator();
			while(it.hasNext()){
				k = it.next();
				if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
					throw new IllegalArgumentException("Diese Karte existiert bereits");
				}		
			}	
		}
		return true;		
	}
	
	/**				
	 * Gibt anahand eines INT-Wertes, welcher der Fachnummer entspricht, das entsprechende Fach als ArrayList-Objekt zurueck.
	 * 				
	 * @param 	fach		
	 * 		 		Erwartet wird gewuenschte Fachnummer. Anhand dieses INT-Werts wird das
	 * 		  		entsprechende ArrayList Objekt identifiziert und zurueckgeliefert.
	 * @return	Referenz zu ArrayList Objekt des gewuenschten Fachs	
	 */	
	public ArrayList<Karte> gibFach(int fach){
		
		ArrayList<Karte> f = new ArrayList<Karte>();			

		switch(fach) {			
			case 1:	f=fach1;	
					break;
			case 2: f=fach2;		
					break;
			case 3: f=fach3;		
					break;
			case 4: f=fach4;		
					break;
			case 5: f=fach5;		
					break;
			case 6: f=fach6;		
					break;
			}
		return f;
	}


	/**			
	 * @return the sprache			
	 */			
	public String getSprache()			
	{			
		return sprache;		
	}	

	/**	
	 * @param sprache the sprache to set	
	 */	
	public void setSprache(String sprache)	
	{	
		this.sprache = sprache;
	}	

	/**	
	 * @return the fremdsprache	
	 */	
	public String getFremdsprache()	
	{	
		return fremdsprache;
	}	

	/**	
	 * @param fremdsprache the fremdsprache to set	
	 */	
	public void setFremdsprache(String fremdsprache)	
	{	
		this.fremdsprache = fremdsprache;
	}	

	/**	
	 * @return the name	
	 */	
	public String getName()	
	{	
		return name;
	}	

	/**	
	 * @param name the name to set	
	 */	
	public void setName(String name)	
	{	
		this.name = name;
	}	

	/**	
	 * @return the fach1	
	 */	
	public ArrayList<Karte> getFach1()	
	{	
		return fach1;
	}	

	/**	
	 * @param fach1 the fach1 to set	
	 */	
	public void setFach1(ArrayList<Karte> fach1)	
	{	
		this.fach1 = fach1;
	}	

	/**	
	 * @return the fach2	
	 */	
	public ArrayList<Karte> getFach2()	
	{	
		return fach2;
	}	

	/**	
	 * @param fach2 the fach2 to set	
	 */	
	public void setFach2(ArrayList<Karte> fach2)	
	{	
		this.fach2 = fach2;
	}	

	/**	
	 * @return the fach3	
	 */	
	public ArrayList<Karte> getFach3()	
	{	
		return fach3;
	}	

	/**	
	 * @param fach3 the fach3 to set	
	 */	
	public void setFach3(ArrayList<Karte> fach3)	
	{	
		this.fach3 = fach3;
	}	

	/**	
	 * @return the fach4	
	 */	
	public ArrayList<Karte> getFach4()	
	{	
		return fach4;
	}	

	/**	
	 * @param fach4 the fach4 to set	
	 */	
	public void setFach4(ArrayList<Karte> fach4)	
	{	
		this.fach4 = fach4;
	}	

	/**	
	 * @return the fach5	
	 */	
	public ArrayList<Karte> getFach5()	
	{	
		return fach5;
	}	

	/**	
	 * @param fach5 the fach5 to set	
	 */	
	public void setFach5(ArrayList<Karte> fach5)	
	{	
		this.fach5 = fach5;
	}	

	/**	
	 * @return the fach6	
	 */	
	public ArrayList<Karte> getFach6()	
	{	
		return fach6;
	}	

	/**	
	 * @param fach6 the fach6 to set	
	 */	
	public void setFach6(ArrayList<Karte> fach6)	
	{	
		this.fach6 = fach6;
	}	



}		