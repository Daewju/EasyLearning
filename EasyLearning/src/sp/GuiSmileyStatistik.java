package sp;

import java.awt.GridLayout;

import javax.swing.JPanel;

import dd.SprachController;
/**
 * Diese Klasse 
 * 
 * @author Damjan & Sajeevan
 * @version 1.11
 *
 */
public class GuiSmileyStatistik extends JPanel{
	private GuiSmiley guiSmiley;
	private GuiStatistik guiStatistik;
	private SprachController sc;
	
	public GuiSmileyStatistik(SprachController sc){

		this.guiSmiley = new GuiSmiley();
		this.sc = sc;
		this.guiStatistik = new GuiStatistik(sc);
		this.setLayout(new GridLayout(2,1));
		this.add(guiSmiley);
		this.add(guiStatistik);
		this.setBackground(GuiMain.COLOR_BACKGROUND);
		this.repaint();
	}

	public GuiSmiley getGuiSmiley() {
		return guiSmiley;
	}

	public GuiStatistik getGuiStatistik() {
		return guiStatistik;
	}

	public void setGuiSmiley(GuiSmiley guiSmiley) {
		this.guiSmiley = guiSmiley;
	}

	public void setGuiStatistik(GuiStatistik guiStatistik) {
		this.guiStatistik = guiStatistik;
	}

	


}
