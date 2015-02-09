/**
 * 
 */
package mk;

import java.util.Date;

/**
 * @author marko hallo
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
		this.fach = 1;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aufrufe;
		result = prime * result
				+ ((bearbeitet == null) ? 0 : bearbeitet.hashCode());
		result = prime * result
				+ ((erstellt == null) ? 0 : erstellt.hashCode());
		result = prime * result + fach;
		result = prime * result + richtigB;
		result = prime * result + ((vokabel == null) ? 0 : vokabel.hashCode());
		result = prime * result + ((wort == null) ? 0 : wort.hashCode());
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
		Karte other = (Karte) obj;
		if (aufrufe != other.aufrufe)
			return false;
		if (bearbeitet == null) {
			if (other.bearbeitet != null)
				return false;
		} else if (!bearbeitet.equals(other.bearbeitet))
			return false;
		if (erstellt == null) {
			if (other.erstellt != null)
				return false;
		} else if (!erstellt.equals(other.erstellt))
			return false;
		if (fach != other.fach)
			return false;
		if (richtigB != other.richtigB)
			return false;
		if (vokabel == null) {
			if (other.vokabel != null)
				return false;
		} else if (!vokabel.equals(other.vokabel))
			return false;
		if (wort == null) {
			if (other.wort != null)
				return false;
		} else if (!wort.equals(other.wort))
			return false;
		return true;
	}
	
	

}
