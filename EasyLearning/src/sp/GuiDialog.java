package sp;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dd.SprachController;

public class GuiDialog
{
	private GuiMain guiMain;
	private SprachController sc;
	private String eingabeFeldErgebnis;
	private String eingabeFeldErgebnis2;

	public GuiDialog(GuiMain guiMain)
	{
		this.guiMain = guiMain;
		this.sc = guiMain.getSprachcontroller();
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

	public int variableButtonsDialog(Object[] optionen, String titel,
			String text)
	{
		int fortschritt = JOptionPane.showOptionDialog(guiMain, text, titel,
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				optionen, optionen[0]);
		return fortschritt;
	}

	public boolean erzeugeNeuEingabeDialog(String titel, String feld1, String feld2)
	{
			JTextField hauptsp = new JTextField(10);
			JTextField fremdsp = new JTextField(10);
			JPanel panelNeu = new JPanel();
			panelNeu.add(new JLabel(feld1));
			panelNeu.add(hauptsp);
			panelNeu.add(Box.createHorizontalStrut(20));
			panelNeu.add(new JLabel(feld2));
			panelNeu.add(fremdsp);
			int result = JOptionPane.showConfirmDialog(guiMain, panelNeu,
					titel, JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				if (hauptsp.getText().trim().equals("")
						|| fremdsp.getText().trim().equals(""))
				{
					guiMain.getGuiDialog().fehlerDialog(
							sc.getSprache("Fehler", guiMain.getSprachcode()),
							sc.getSprache("Die Felder dürfen nicht leer sein",
									guiMain.getSprachcode()));
					return false;
				} else
				{
					eingabeFeldErgebnis = hauptsp.getText().trim();
					eingabeFeldErgebnis2= fremdsp.getText().trim();
				}
		}
		return true;
	}


	/**
	 * @return the eingabeFeldErgebnis
	 */
	public String getEingabeFeldErgebnis()
	{
		return eingabeFeldErgebnis;
	}

	/**
	 * @param eingabeFeldErgebnis the eingabeFeldErgebnis to set
	 */
	public void setEingabeFeldErgebnis(String eingabeFeldErgebnis)
	{
		this.eingabeFeldErgebnis = eingabeFeldErgebnis;
	}

	/**
	 * @return the eingabeFeldErgebnis2
	 */
	public String getEingabeFeldErgebnis2()
	{
		return eingabeFeldErgebnis2;
	}

	/**
	 * @param eingabeFeldErgebnis2 the eingabeFeldErgebnis2 to set
	 */
	public void setEingabeFeldErgebnis2(String eingabeFeldErgebnis2)
	{
		this.eingabeFeldErgebnis2 = eingabeFeldErgebnis2;
	}

	/**
	 * @return the guiMain
	 */
	public GuiMain getGuiMain()
	{
		return guiMain;
	}

	/**
	 * @param guiMain the guiMain to set
	 */
	public void setGuiMain(GuiMain guiMain)
	{
		this.guiMain = guiMain;
	}

	/**
	 * @return the sc
	 */
	public SprachController getSc()
	{
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(SprachController sc)
	{
		this.sc = sc;
	}

}
