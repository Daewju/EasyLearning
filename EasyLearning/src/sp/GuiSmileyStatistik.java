package sp;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class GuiSmileyStatistik extends JPanel{
	private GuiSmiley guiSmiley;
	private GuiStatistik guiStatistik;
	
	public GuiSmileyStatistik(){

		this.guiSmiley = new GuiSmiley();
		this.guiStatistik = new GuiStatistik();
		this.guiStatistik.setStatistik("0","0", "0", "a", "b");
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
