/**
 * 
 */
package mk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author marko
 *
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
	 * 
	 * @param karte
	 * @param fach
	 * addKarte erwartet ein Objekt der Klasse Karte und einen Int Wert welcher für das Fach
	 * steht indem das Kartenobjket eingefügt werden soll.
	 * @return	boolean (true = erfolgreich /false = fehlgeschlagen)
	 * @throws IOException
	 */
	public boolean addKarte(Karte karte, int fach) throws IOException{
		Iterator<Karte> it;
		Karte k;
		
		if(karte!=null && fach >=1 && fach <=6)
		{
			switch(fach) {
			case 1:	it  = fach1.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach1.add(karte);
						}
					}
				
			case 2: it  = fach2.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach2.add(karte);
						}
					}
					
			case 3: it  = fach3.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach3.add(karte);
						}
					}
			
			case 4: it  = fach4.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach4.add(karte);
						}
					}
					
			case 5: it  = fach5.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach5.add(karte);
						}
					}
					
			case 6: it  = fach6.iterator();
					while(it.hasNext()){
						k = it.next();
						if(k.getWort().equals(karte.getWort()) && k.getVokabel().equals(karte.getVokabel())){
							throw new IllegalArgumentException("Diese Karte existiert bereits");
						}
						else{
							return fach6.add(karte);
						}
					}
			}
			
		}
		
		return false;
	}
	
	
	public boolean removeKarte(Karte karte, int fach){
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
			
		Iterator<Karte> it = f.iterator();
			
		while(it.hasNext()){
			
			if(it.next().equals(karte)){
				it.remove();
				return true;
			}
		}
		return false;
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
