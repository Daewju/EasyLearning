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
 * @author Damjan & Sajeevan
 * @version 1.6
 *
 */
public class GuiStatistik extends JPanel {

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
	public GuiStatistik(SprachController sc) {
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
		for (int i = 0; i < 5; i++) {
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
			String anzahlKorrekt, String datumErstellt, String zuletztBearbeitet) {
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
	public void anzeigeAktualisieren() {
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
}