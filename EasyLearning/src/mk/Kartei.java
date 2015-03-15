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
 *	@version 1.0	
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

/**
 * Erezeugt eine Instanz von Kartei mit sechs leeren Faechern. Die Sprachen 
 * werden ueber Parameter festgelegt.
 * 
 * @param sprache	Hauptsprache der Kartei als String
 * @param fremdsprache	Fremdsprache die gelernt werden soll als String
 */
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
			
				if((fach1.isEmpty() && fach2.isEmpty() && fach3.isEmpty() && fach4.isEmpty() && fach5.isEmpty() && fach6.isEmpty()) || existKarte(karte)){ //goes into if fach is not empty or card doesnt exist	
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
	 * @param	karte	Objekt der Klasse Karte welches geprueft werden soll.		
	 * 				
	 * @return	boolean (true = Karte existiert nicht  /false = Karte existiert)	
	 * @throws IllegalArgumentException		
	 */		
	private boolean existKarte(Karte karte){		
		Karte k;
		Iterator<Karte> it;
		for(int i=1;i<7;i++){
			it=gibFach(i).iterator();
			while(it.hasNext()){
				k = it.next();
				if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
					throw new IllegalArgumentException("card exists");
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
	 * @return Referenz auf ArrayList Fach1	
	 */	
	public ArrayList<Karte> getFach1()	
	{	
		return fach1;
	}	

	/**	
	 * @param fach1 ArrayList Objekt auf welches fach1 zeigen soll.	
	 */	
	public void setFach1(ArrayList<Karte> fach1)	
	{	
		this.fach1 = fach1;
	}	

	/**	
	 * @return Referenz auf ArrayList Fach2	
	 */	
	public ArrayList<Karte> getFach2()	
	{	
		return fach2;
	}	

	/**	
	 * @param fach2 ArrayList Objekt auf welches fach2 zeigen soll.	
	 */	
	public void setFach2(ArrayList<Karte> fach2)	
	{	
		this.fach2 = fach2;
	}	

	/**	
	 * @return Referenz auf ArrayList Fach3	
	 */	
	public ArrayList<Karte> getFach3()	
	{	
		return fach3;
	}	

	/**	
	 * @param fach3 ArrayList Objekt auf welches fach3 zeigen soll.	
	 */	
	public void setFach3(ArrayList<Karte> fach3)	
	{	
		this.fach3 = fach3;
	}	

	/**	
	 * @return Referenz auf ArrayList Fach4	
	 */	
	public ArrayList<Karte> getFach4()	
	{	
		return fach4;
	}	

	/**	
	 * @param fach4 ArrayList Objekt auf welches fach4 zeigen soll.	
	 */	
	public void setFach4(ArrayList<Karte> fach4)	
	{	
		this.fach4 = fach4;
	}	

	/**	
	 * @return Referenz auf ArrayList Fach5	
	 */	
	public ArrayList<Karte> getFach5()	
	{	
		return fach5;
	}	

	/**	
	 * @param fach5 ArrayList Objekt auf welches fach5 zeigen soll.	
	 */	
	public void setFach5(ArrayList<Karte> fach5)	
	{	
		this.fach5 = fach5;
	}	

	/**	
	 * @return Referenz auf ArrayList Fach6	
	 */	
	public ArrayList<Karte> getFach6()	
	{	
		return fach6;
	}	

	/**	
	 * @param fach6 ArrayList Objekt auf welches fach6 zeigen soll.	
	 */	
	public void setFach6(ArrayList<Karte> fach6)	
	{	
		this.fach6 = fach6;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Kartei [sprache=" + sprache + ", fremdsprache=" + fremdsprache
				+ ", name=" + name + ", fach1=" + fach1 + ", fach2=" + fach2
				+ ", fach3=" + fach3 + ", fach4=" + fach4 + ", fach5=" + fach5
				+ ", fach6=" + fach6 + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fach1 == null) ? 0 : fach1.hashCode());
		result = prime * result + ((fach2 == null) ? 0 : fach2.hashCode());
		result = prime * result + ((fach3 == null) ? 0 : fach3.hashCode());
		result = prime * result + ((fach4 == null) ? 0 : fach4.hashCode());
		result = prime * result + ((fach5 == null) ? 0 : fach5.hashCode());
		result = prime * result + ((fach6 == null) ? 0 : fach6.hashCode());
		result = prime * result
				+ ((fremdsprache == null) ? 0 : fremdsprache.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sprache == null) ? 0 : sprache.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kartei other = (Kartei) obj;
		if (fach1 == null) {
			if (other.fach1 != null)
				return false;
		} else if (!fach1.equals(other.fach1))
			return false;
		if (fach2 == null) {
			if (other.fach2 != null)
				return false;
		} else if (!fach2.equals(other.fach2))
			return false;
		if (fach3 == null) {
			if (other.fach3 != null)
				return false;
		} else if (!fach3.equals(other.fach3))
			return false;
		if (fach4 == null) {
			if (other.fach4 != null)
				return false;
		} else if (!fach4.equals(other.fach4))
			return false;
		if (fach5 == null) {
			if (other.fach5 != null)
				return false;
		} else if (!fach5.equals(other.fach5))
			return false;
		if (fach6 == null) {
			if (other.fach6 != null)
				return false;
		} else if (!fach6.equals(other.fach6))
			return false;
		if (fremdsprache == null) {
			if (other.fremdsprache != null)
				return false;
		} else if (!fremdsprache.equals(other.fremdsprache))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sprache == null) {
			if (other.sprache != null)
				return false;
		} else if (!sprache.equals(other.sprache))
			return false;
		return true;
	}	
	
	


}		