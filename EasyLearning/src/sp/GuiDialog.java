package sp;

import javax.swing.JOptionPane;

public class GuiDialog
{
	private GuiMain guiMain;

	public GuiDialog(GuiMain guiMain)
	{
		this.guiMain = guiMain;
	}

	public void infoDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void warnungsDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.WARNING_MESSAGE);
	}

	public void fehlerDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.ERROR_MESSAGE);
	}
}
