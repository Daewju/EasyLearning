/**
 * 
 */
package mk;

import java.util.Date;

/**
 * @author marko
 *
 */
public class Karte {
	private String wort;
	private String vokabel;
	private int aufrufe;
	private int richtigB; //Counter richtig Beantwortet
	private int fach;
	private Date erstellt;
	private Date bearbeitet;
	
	
	public Karte(String wort, String vokabel){
		this.wort = wort;
		this.vokabel = vokabel;
		this.aufrufe = 0;
		this.richtigB = 0;
		this.fach = 0;
		this.erstellt = new Date();
		this.bearbeitet = new Date();
	}
	
	public Karte(String wort, String vokabel, int aufrufe, int richtigB, int fach, Date erstellt, Date bearbeitet){
		this.wort = wort;
		this.vokabel = vokabel;
		this.aufrufe = aufrufe;
		this.richtigB = richtigB;
		this.fach = fach;
		this.erstellt = erstellt;
		this.bearbeitet = bearbeitet;
	}

	/**
	 * @return the wort
	 */
	public String getWort() {
		return wort;
	}

	/**
	 * @param wort the wort to set
	 */
	public void setWort(String wort) {
		this.wort = wort;
	}

	/**
	 * @return the vokabel
	 */
	public String getVokabel() {
		return vokabel;
	}

	/**
	 * @param vokabel the vokabel to set
	 */
	public void setVokabel(String vokabel) {
		this.vokabel = vokabel;
	}

	/**
	 * @return the aufrufe
	 */
	public int getAufrufe() {
		return aufrufe;
	}

	/**
	 * @param aufrufe the aufrufe to set
	 */
	public void setAufrufe(int aufrufe) {
		this.aufrufe = aufrufe;
	}

	/**
	 * @return the richtigB
	 */
	public int getRichtigB() {
		return richtigB;
	}

	/**
	 * @param richtigB the richtigB to set
	 */
	public void setRichtigB(int richtigB) {
		this.richtigB = richtigB;
	}

	/**
	 * @return the fach
	 */
	public int getFach() {
		return fach;
	}

	/**
	 * @param fach the fach to set
	 */
	public void setFach(int fach) {
		this.fach = fach;
	}

	/**
	 * @return the erstellt
	 */
	public Date getErstellt() {
		return erstellt;
	}

	/**
	 * @param erstellt the erstellt to set
	 */
	public void setErstellt(Date erstellt) {
		this.erstellt = erstellt;
	}

	/**
	 * @return the bearbeitet
	 */
	public Date getBearbeitet() {
		return bearbeitet;
	}

	/**
	 * @param bearbeitet the bearbeitet to set
	 */
	public void setBearbeitet(Date bearbeitet) {
		this.bearbeitet = bearbeitet;
	}
	
	

}
