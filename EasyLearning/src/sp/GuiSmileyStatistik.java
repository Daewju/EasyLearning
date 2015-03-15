package sp;

import java.awt.GridLayout;

import javax.swing.JPanel;

import dd.SprachController;
/**
 * Diese Klasse definiert das JPanel in dem das Smiley und die Statistik zusammen
 * 
 * @author Damjan & Sajeevan
 * @version 1.2
 *
 */
public class GuiSmileyStatistik extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private GuiSmiley guiSmiley;
	private GuiStatistik guiStatistik;
	
	/**
	 * Konstruktor
	 * 
	 * @param sc als Parameter wird der SprachController erwartet
	 */
	public GuiSmileyStatistik(SprachController sc){

		this.guiSmiley = new GuiSmiley();
		this.guiStatistik = new GuiStatistik(sc);
		this.setLayout(new GridLayout(2,1));
		this.add(guiSmiley);
		this.add(guiStatistik);
		this.setBackground(GuiMain.COLOR_BACKGROUND);
		this.repaint();
	}

	/**
	 * @return gib das guiSmiley zurück
	 */
	public GuiSmiley getGuiSmiley() {
		return guiSmiley;
	}

	/**
	 * @return gibt die guiStatistik zurück
	 */
	public GuiStatistik getGuiStatistik() {
		return guiStatistik;
	}

	/**
	 * @param guiSmiley setzt das guiSmiley
	 */
	public void setGuiSmiley(GuiSmiley guiSmiley) {
		this.guiSmiley = guiSmiley;
	}

	/**
	 * @param guiStatistik setzt die guiStatistik
	 */
	public void setGuiStatistik(GuiStatistik guiStatistik) {
		this.guiStatistik = guiStatistik;
	}

	


}
