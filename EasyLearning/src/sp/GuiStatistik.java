package sp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dd.SprachController;

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

	public GuiStatistik(SprachController sc){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(210,0));
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
		titel = new JLabel("Statistik");
		this.sc = sc;
		zwischenzeilen = new ArrayList<>();
		for(int i=0; i<5; i++)
		{
			JLabel zwischenzeile = new JLabel(" ");
			zwischenzeile.setFont(new Font(null, Font.BOLD, 5));
			zwischenzeilen.add(zwischenzeile);
		}
	}
	
	public void setStatistik(String anzahlKarten, String anzahlAufrufe, String anzahlKorrekt, String datumErstellt, String zuletztBearbeitet){
		setBackground(GuiMain.COLOR_BACKGROUND);
		this.anzahlKarten = anzahlKarten;
		this.anzahlAufrufe = anzahlAufrufe;
		this.anzahlKorrekt = anzahlKorrekt;
		this.datumErstellt = datumErstellt;
		this.zuletztBearbeitet = zuletztBearbeitet;
		anzeigeAktualisieren();
	}
	
	public void anzeigeAktualisieren()
	{
		titel.setFont(new Font(null, Font.BOLD, 21));
		titel.setForeground(Color.ORANGE);
		karten.setFont(new Font(null, Font.BOLD, 16));
		karten.setForeground(Color.CYAN);
		karten.setText(sc.getSprache("Karten im Fach", GuiMain.SPRACHCODE) +": " + anzahlKarten);
		aufrufe.setFont(new Font(null, Font.BOLD, 16));
		aufrufe.setForeground(Color.CYAN);
		aufrufe.setText("Aufrufe: " + anzahlAufrufe);
		korrekt.setFont(new Font(null, Font.BOLD, 16));
		korrekt.setForeground(Color.CYAN);
		korrekt.setText("Korrekt: " + anzahlKorrekt);
		erstellt.setFont(new Font(null, Font.BOLD, 16));
		erstellt.setForeground(Color.CYAN);
		erstellt.setText("Erstellt: ");
		erstelltWert.setFont(new Font(null, Font.BOLD,16));
		erstelltWert.setForeground(Color.CYAN);
		erstelltWert.setText(datumErstellt);
		bearbeitet.setFont(new Font(null, Font.BOLD, 16));
		bearbeitet.setForeground(Color.CYAN);
		bearbeitet.setText("Bearbeitet: ");
		bearbeitetWert.setFont(new Font(null, Font.BOLD, 16));
		bearbeitetWert.setForeground(Color.CYAN);
		bearbeitetWert.setText(zuletztBearbeitet);
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