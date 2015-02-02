/**
 * 
 */
package mk;
import java.util.ArrayList;

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
	
	public boolean addKarte(Karte karte, int fach){
		boolean ret = false;
		if(karte!=null && fach >=1 && fach <=6)
		{
			switch(fach) {
			case 1:	fach1.add(karte);
					ret=true;
					break;
			case 2: fach2.add(karte);
					ret=true;
					break;
			case 3: fach3.add(karte);
					ret=true;
					break;
			case 4: fach4.add(karte);
					ret=true;
					break;
			case 5: fach5.add(karte);
					ret=true;
					break;
			case 6: fach6.add(karte);
					ret=true;
					break;
			default:	ret=false;
						break;
			}
		}
		return ret;
	}
}
