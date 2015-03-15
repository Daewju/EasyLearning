package sp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dd.SprachController;

/**
 * Diese Klasse gibt die Statistik mit folgenden Angaben aus. Anzahl Aufrufe
 * 
 * 
 * @author Damjan und Sajeevan
 * @version 1.6
 *
 */
public class GuiStatistik extends JPanel
{

	private static final long serialVersionUID = 1L;

	private String anzahlKarten;
	private String anzahlAufrufe;
	private String anzahlKorrekt;
	private String datumErstellt;
	private String zuletztBearbeitet;
	private JLabel karten;
	private JLabel aufrufe;
	private JLabel korrekt;
	private JLabel erstellt;
	private JLabel erstelltWert;
	private JLabel bearbeitet;
	private JLabel bearbeitetWert;
	private JLabel titel;
	private ArrayList<JLabel> zwischenzeilen;
	private SprachController sc;

	/**
	 * Konstruktor
	 * 
	 * @param sc
	 *            als Parameter wird der SprachController erwartet
	 */
	public GuiStatistik(SprachController sc)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(200, 0));
		this.sc = sc;
		anzahlKarten = "0";
		anzahlAufrufe = "0";
		anzahlKorrekt = "0";
		datumErstellt = "dd.mm.yyyy hh:mm";
		zuletztBearbeitet = "dd.mm.yyyy hh:mm";
		karten = new JLabel();
		aufrufe = new JLabel();
		korrekt = new JLabel();
		erstellt = new JLabel();
		erstelltWert = new JLabel();
		bearbeitet = new JLabel();
		bearbeitetWert = new JLabel();
		titel = new JLabel();
		zwischenzeilen = new ArrayList<>();
		for (int i = 0; i < 5; i++)
		{
			JLabel zwischenzeile = new JLabel(" ");
			zwischenzeile.setFont(new Font(null, Font.BOLD, 5));
			zwischenzeilen.add(zwischenzeile);
		}
	}

	/**
	 * Als Parameter werden alle Werte als String erwartet und auf das JPanel
	 * gezeichnet.
	 * 
	 * @param anzahlKarten
	 *            Anzahl Karten
	 * @param anzahlAufrufe
	 *            Anzahl Aufrufe
	 * @param anzahlKorrekt
	 *            Prozentwert der korrekten Aufrufe
	 * @param datumErstellt
	 *            Datum erstellt
	 * @param zuletztBearbeitet
	 *            Datum bearbeitet
	 */
	public void setStatistik(String anzahlKarten, String anzahlAufrufe,
			String anzahlKorrekt, String datumErstellt, String zuletztBearbeitet)
	{
		setBackground(GuiMain.COLOR_BACKGROUND);
		this.anzahlKarten = anzahlKarten;
		this.anzahlAufrufe = anzahlAufrufe;
		this.anzahlKorrekt = anzahlKorrekt;
		this.datumErstellt = datumErstellt;
		this.zuletztBearbeitet = zuletztBearbeitet;
		anzeigeAktualisieren();
	}

	/**
	 * Diese Methode setzt alle JLabels neu aufgrund der Datenfelder
	 */
	public void anzeigeAktualisieren()
	{
		titel.setFont(new Font(null, Font.BOLD, 21));
		titel.setForeground(Color.ORANGE);
		karten.setFont(new Font(null, Font.BOLD, 16));
		karten.setForeground(Color.CYAN);
		karten.setText(sc.getSprache("Karten im Fach", GuiMain.SPRACHCODE)
				+ ": " + anzahlKarten);
		aufrufe.setFont(new Font(null, Font.BOLD, 16));
		aufrufe.setForeground(Color.CYAN);
		aufrufe.setText(sc.getSprache("Aufrufe", GuiMain.SPRACHCODE) + ": "
				+ anzahlAufrufe);
		korrekt.setFont(new Font(null, Font.BOLD, 16));
		korrekt.setForeground(Color.CYAN);
		korrekt.setText(sc.getSprache("Korrekt", GuiMain.SPRACHCODE) + ": "
				+ anzahlKorrekt);
		erstellt.setFont(new Font(null, Font.BOLD, 16));
		erstellt.setForeground(Color.CYAN);
		erstellt.setText(sc.getSprache("Erstellt", GuiMain.SPRACHCODE) + ": ");
		erstelltWert.setFont(new Font(null, Font.BOLD, 16));
		erstelltWert.setForeground(Color.CYAN);
		erstelltWert.setText(datumErstellt);
		bearbeitet.setFont(new Font(null, Font.BOLD, 16));
		bearbeitet.setForeground(Color.CYAN);
		bearbeitet.setText(sc.getSprache("Bearbeitet", GuiMain.SPRACHCODE)
				+ ": ");
		bearbeitetWert.setFont(new Font(null, Font.BOLD, 16));
		bearbeitetWert.setForeground(Color.CYAN);
		bearbeitetWert.setText(zuletztBearbeitet);
		titel.setText(sc.getSprache("Statistik", GuiMain.SPRACHCODE));
		add(titel);
		add(zwischenzeilen.get(0));
		add(aufrufe);
		add(zwischenzeilen.get(1));
		add(korrekt);
		add(zwischenzeilen.get(2));
		add(erstellt);
		add(erstelltWert);
		add(zwischenzeilen.get(3));
		add(bearbeitet);
		add(bearbeitetWert);
		add(zwischenzeilen.get(4));
		add(karten);
		repaint();
	}

	/**
	 * @return the anzahlKarten
	 */
	public String getAnzahlKarten()
	{
		return anzahlKarten;
	}

	/**
	 * @param anzahlKarten
	 *            the anzahlKarten to set
	 */
	public void setAnzahlKarten(String anzahlKarten)
	{
		this.anzahlKarten = anzahlKarten;
	}

	/**
	 * @return the anzahlAufrufe
	 */
	public String getAnzahlAufrufe()
	{
		return anzahlAufrufe;
	}

	/**
	 * @param anzahlAufrufe
	 *            the anzahlAufrufe to set
	 */
	public void setAnzahlAufrufe(String anzahlAufrufe)
	{
		this.anzahlAufrufe = anzahlAufrufe;
	}

	/**
	 * @return the anzahlKorrekt
	 */
	public String getAnzahlKorrekt()
	{
		return anzahlKorrekt;
	}

	/**
	 * @param anzahlKorrekt
	 *            the anzahlKorrekt to set
	 */
	public void setAnzahlKorrekt(String anzahlKorrekt)
	{
		this.anzahlKorrekt = anzahlKorrekt;
	}

	/**
	 * @return the datumErstellt
	 */
	public String getDatumErstellt()
	{
		return datumErstellt;
	}

	/**
	 * @param datumErstellt
	 *            the datumErstellt to set
	 */
	public void setDatumErstellt(String datumErstellt)
	{
		this.datumErstellt = datumErstellt;
	}

	/**
	 * @return the zuletztBearbeitet
	 */
	public String getZuletztBearbeitet()
	{
		return zuletztBearbeitet;
	}

	/**
	 * @param zuletztBearbeitet
	 *            the zuletztBearbeitet to set
	 */
	public void setZuletztBearbeitet(String zuletztBearbeitet)
	{
		this.zuletztBearbeitet = zuletztBearbeitet;
	}

	/**
	 * @return the karten
	 */
	public JLabel getKarten()
	{
		return karten;
	}

	/**
	 * @param karten
	 *            the karten to set
	 */
	public void setKarten(JLabel karten)
	{
		this.karten = karten;
	}

	/**
	 * @return the aufrufe
	 */
	public JLabel getAufrufe()
	{
		return aufrufe;
	}

	/**
	 * @param aufrufe
	 *            the aufrufe to set
	 */
	public void setAufrufe(JLabel aufrufe)
	{
		this.aufrufe = aufrufe;
	}

	/**
	 * @return the korrekt
	 */
	public JLabel getKorrekt()
	{
		return korrekt;
	}

	/**
	 * @param korrekt
	 *            the korrekt to set
	 */
	public void setKorrekt(JLabel korrekt)
	{
		this.korrekt = korrekt;
	}

	/**
	 * @return the erstellt
	 */
	public JLabel getErstellt()
	{
		return erstellt;
	}

	/**
	 * @param erstellt
	 *            the erstellt to set
	 */
	public void setErstellt(JLabel erstellt)
	{
		this.erstellt = erstellt;
	}

	/**
	 * @return the erstelltWert
	 */
	public JLabel getErstelltWert()
	{
		return erstelltWert;
	}

	/**
	 * @param erstelltWert
	 *            the erstelltWert to set
	 */
	public void setErstelltWert(JLabel erstelltWert)
	{
		this.erstelltWert = erstelltWert;
	}

	/**
	 * @return the bearbeitet
	 */
	public JLabel getBearbeitet()
	{
		return bearbeitet;
	}

	/**
	 * @param bearbeitet
	 *            the bearbeitet to set
	 */
	public void setBearbeitet(JLabel bearbeitet)
	{
		this.bearbeitet = bearbeitet;
	}

	/**
	 * @return the bearbeitetWert
	 */
	public JLabel getBearbeitetWert()
	{
		return bearbeitetWert;
	}

	/**
	 * @param bearbeitetWert
	 *            the bearbeitetWert to set
	 */
	public void setBearbeitetWert(JLabel bearbeitetWert)
	{
		this.bearbeitetWert = bearbeitetWert;
	}

	/**
	 * @return the titel
	 */
	public JLabel getTitel()
	{
		return titel;
	}

	/**
	 * @param titel
	 *            the titel to set
	 */
	public void setTitel(JLabel titel)
	{
		this.titel = titel;
	}

	/**
	 * @return the zwischenzeilen
	 */
	public ArrayList<JLabel> getZwischenzeilen()
	{
		return zwischenzeilen;
	}

	/**
	 * @param zwischenzeilen
	 *            the zwischenzeilen to set
	 */
	public void setZwischenzeilen(ArrayList<JLabel> zwischenzeilen)
	{
		this.zwischenzeilen = zwischenzeilen;
	}

	/**
	 * @return the sc
	 */
	public SprachController getSc()
	{
		return sc;
	}

	/**
	 * @param sc
	 *            the sc to set
	 */
	public void setSc(SprachController sc)
	{
		this.sc = sc;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiStatistik [anzahlKarten=" + anzahlKarten
				+ ", anzahlAufrufe=" + anzahlAufrufe + ", anzahlKorrekt="
				+ anzahlKorrekt + ", datumErstellt=" + datumErstellt
				+ ", zuletztBearbeitet=" + zuletztBearbeitet + ", karten="
				+ karten + ", aufrufe=" + aufrufe + ", korrekt=" + korrekt
				+ ", erstellt=" + erstellt + ", erstelltWert=" + erstelltWert
				+ ", bearbeitet=" + bearbeitet + ", bearbeitetWert="
				+ bearbeitetWert + ", titel=" + titel + ", zwischenzeilen="
				+ zwischenzeilen + ", sc=" + sc + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anzahlAufrufe == null) ? 0 : anzahlAufrufe.hashCode());
		result = prime * result
				+ ((anzahlKarten == null) ? 0 : anzahlKarten.hashCode());
		result = prime * result
				+ ((anzahlKorrekt == null) ? 0 : anzahlKorrekt.hashCode());
		result = prime * result + ((aufrufe == null) ? 0 : aufrufe.hashCode());
		result = prime * result
				+ ((bearbeitet == null) ? 0 : bearbeitet.hashCode());
		result = prime * result
				+ ((bearbeitetWert == null) ? 0 : bearbeitetWert.hashCode());
		result = prime * result
				+ ((datumErstellt == null) ? 0 : datumErstellt.hashCode());
		result = prime * result
				+ ((erstellt == null) ? 0 : erstellt.hashCode());
		result = prime * result
				+ ((erstelltWert == null) ? 0 : erstelltWert.hashCode());
		result = prime * result + ((karten == null) ? 0 : karten.hashCode());
		result = prime * result + ((korrekt == null) ? 0 : korrekt.hashCode());
		result = prime * result + ((sc == null) ? 0 : sc.hashCode());
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
		result = prime
				* result
				+ ((zuletztBearbeitet == null) ? 0 : zuletztBearbeitet
						.hashCode());
		result = prime * result
				+ ((zwischenzeilen == null) ? 0 : zwischenzeilen.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiStatistik other = (GuiStatistik) obj;
		if (anzahlAufrufe == null)
		{
			if (other.anzahlAufrufe != null)
				return false;
		} else if (!anzahlAufrufe.equals(other.anzahlAufrufe))
			return false;
		if (anzahlKarten == null)
		{
			if (other.anzahlKarten != null)
				return false;
		} else if (!anzahlKarten.equals(other.anzahlKarten))
			return false;
		if (anzahlKorrekt == null)
		{
			if (other.anzahlKorrekt != null)
				return false;
		} else if (!anzahlKorrekt.equals(other.anzahlKorrekt))
			return false;
		if (aufrufe == null)
		{
			if (other.aufrufe != null)
				return false;
		} else if (!aufrufe.equals(other.aufrufe))
			return false;
		if (bearbeitet == null)
		{
			if (other.bearbeitet != null)
				return false;
		} else if (!bearbeitet.equals(other.bearbeitet))
			return false;
		if (bearbeitetWert == null)
		{
			if (other.bearbeitetWert != null)
				return false;
		} else if (!bearbeitetWert.equals(other.bearbeitetWert))
			return false;
		if (datumErstellt == null)
		{
			if (other.datumErstellt != null)
				return false;
		} else if (!datumErstellt.equals(other.datumErstellt))
			return false;
		if (erstellt == null)
		{
			if (other.erstellt != null)
				return false;
		} else if (!erstellt.equals(other.erstellt))
			return false;
		if (erstelltWert == null)
		{
			if (other.erstelltWert != null)
				return false;
		} else if (!erstelltWert.equals(other.erstelltWert))
			return false;
		if (karten == null)
		{
			if (other.karten != null)
				return false;
		} else if (!karten.equals(other.karten))
			return false;
		if (korrekt == null)
		{
			if (other.korrekt != null)
				return false;
		} else if (!korrekt.equals(other.korrekt))
			return false;
		if (sc == null)
		{
			if (other.sc != null)
				return false;
		} else if (!sc.equals(other.sc))
			return false;
		if (titel == null)
		{
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		if (zuletztBearbeitet == null)
		{
			if (other.zuletztBearbeitet != null)
				return false;
		} else if (!zuletztBearbeitet.equals(other.zuletztBearbeitet))
			return false;
		if (zwischenzeilen == null)
		{
			if (other.zwischenzeilen != null)
				return false;
		} else if (!zwischenzeilen.equals(other.zwischenzeilen))
			return false;
		return true;
	}

}