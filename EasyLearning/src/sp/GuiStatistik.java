package sp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private JLabel zwischenZeile;
	

	public GuiStatistik(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(50,50));
		this.anzahlKarten = "0";
		this.anzahlAufrufe = "0";
		this.anzahlKorrekt = "0";
		this.datumErstellt = "dd.mm.yyyy hh:mm";
		this.zuletztBearbeitet = "dd.mm.yyyy hh:mm";
		this.karten = new JLabel();
		this.aufrufe = new JLabel();
		this.korrekt = new JLabel();
		this.erstellt = new JLabel();
		this.erstelltWert = new JLabel();
		this.bearbeitet = new JLabel();
		this.bearbeitetWert = new JLabel();
		this.zwischenZeile = new JLabel();

		
	}
	
	public void setStatistik(String anzahlKarten, String anzahlAufrufe, String anzahlKorrekt, String datumErstellt, String zuletztBearbeitet){
		this.setBackground(GuiMain.COLOR_BACKGROUND);
		karten.setFont(new Font(null, Font.BOLD, 20));
		karten.setForeground(GuiMain.COLOR_TEXT_WHITE);
		karten.setText("Karten: " + anzahlKarten);
		aufrufe.setFont(new Font(null, Font.BOLD, 20));
		aufrufe.setForeground(GuiMain.COLOR_TEXT_WHITE);
		aufrufe.setText("Aufrufe: " + anzahlAufrufe);
		korrekt.setFont(new Font(null, Font.BOLD, 20));
		korrekt.setForeground(GuiMain.COLOR_TEXT_WHITE);
		korrekt.setText("Korrekt: " + anzahlKorrekt);
		erstellt.setFont(new Font(null, Font.BOLD, 20));
		erstellt.setForeground(GuiMain.COLOR_TEXT_WHITE);
		erstellt.setText("Erstellt: ");
		erstelltWert.setFont(new Font(null, Font.BOLD,20));
		erstelltWert.setForeground(GuiMain.COLOR_TEXT_WHITE);
		erstelltWert.setText(datumErstellt);
		bearbeitet.setFont(new Font(null, Font.BOLD, 20));
		bearbeitet.setForeground(GuiMain.COLOR_TEXT_WHITE);
		bearbeitet.setText("Bearbeitet: ");
		bearbeitetWert.setFont(new Font(null, Font.BOLD, 20));
		bearbeitetWert.setForeground(GuiMain.COLOR_TEXT_WHITE);
		bearbeitetWert.setText(zuletztBearbeitet);
		zwischenZeile.setText(" ");
		
		this.add(karten);
		this.add(zwischenZeile);
		this.add(aufrufe);
		this.add(zwischenZeile);
		this.add(korrekt);
		this.add(zwischenZeile);
		this.add(erstellt);
		this.add(erstelltWert);
		this.add(zwischenZeile);
		this.add(bearbeitet);
		this.add(bearbeitetWert);
		this.repaint();
	}
	
}