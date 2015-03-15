package sp;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mk.Handler;
import dd.SprachController;

/**
 * Diese Klasse definiert verschiedene Dialoge für Fehlermeldungen oder
 * Eingaben.
 * 
 * @author Sajeevan und Damjan
 * @version 1.5
 *
 */
public class GuiDialog
{
	private GuiMain guiMain;
	private SprachController sprachcontroller;
	private Handler handler;
	private String hauptsprache;
	private String fremdsprache;

	/**
	 * Konstruktor
	 * 
	 * @param guiMain
	 *            als Parameter wird eine guiMain erwartet
	 */
	public GuiDialog(GuiMain guiMain)
	{
		this.guiMain = guiMain;
		this.sprachcontroller = guiMain.getSprachcontroller();
		this.handler = guiMain.getHandler();
	}

	/**
	 * Diese Methode erzeugt ein Infodialog auf guiMain
	 * 
	 * @param titel
	 *            erwartet wird ein String und setzt den Titel des Dialoges
	 * @param text
	 *            erwartet wird ein String und setzt die Beschreibung in den
	 *            Dialog
	 */
	public void infoDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Diese Methode erzeugt ein Warunungsdialog auf guiMain
	 * 
	 * @param titel
	 *            erwartet wird ein String und setzt den Titel des Dialoges
	 * @param text
	 *            erwartet wird ein String und setzt die Beschreibung in den
	 *            Dialog
	 */
	public void warnungsDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Diese Methode erzeugt ein Fehlerdialog auf guiMain
	 * 
	 * @param titel
	 *            erwartet wird ein String und setzt den Titel des Dialoges
	 * @param text
	 *            erwartet wird ein String und setzt die Beschreibung in den
	 *            Dialog
	 */
	public void fehlerDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(guiMain, text, titel,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Diese Methode erzeugt ein Dialog mit mehreren Auswahlmöglichkeiten
	 * 
	 * @param optionen
	 *            erwartet wird ein Object-Array
	 * @param titel
	 *            erwartet wird ein String und setzt den Titel des Dialoges
	 * @param text
	 *            erwartet wird ein String und setzt die Beschreibung in den
	 *            Dialog
	 * @return gibt einen Intwert zurück die die Reihenfolge der Buttons
	 *         definiert
	 */
	public int variableButtonsDialog(Object[] optionen, String titel,
			String text)
	{
		int fortschritt = JOptionPane.showOptionDialog(guiMain, text, titel,
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				optionen, optionen[0]);
		return fortschritt;
	}

	/**
	 * Diese Methode erzeugt ein Dialog um dem Benutzer zwei verschieden
	 * Eingaben zu ermöglichen
	 * 
	 * @param titel
	 *            erwartet wird ein String und setzt den Titel des Dialoges
	 * @param feld1
	 *            erwartet wird ein String für die bezeichnung des ersten
	 *            Eingabefeldes
	 * @param feld2
	 *            erwartet wird ein String für die bezeichnung des zweiten
	 *            Eingabefeldes
	 * @return true wenn die Eingabe die Erwartungen erfüllt, false wenn die
	 *         Eingabe die Erwartungen nicht erfüllt
	 */
	public boolean erzeugeNeuEingabeDialog(String titel, String feld1,
			String feld2)
	{
		JTextField hauptsp = new JTextField(10);
		JTextField fremdsp = new JTextField(10);
		JPanel panelNeu = new JPanel();
		panelNeu.add(new JLabel(feld1));
		panelNeu.add(hauptsp);
		panelNeu.add(Box.createHorizontalStrut(20));
		panelNeu.add(new JLabel(feld2));
		panelNeu.add(fremdsp);
		int result = JOptionPane.showConfirmDialog(guiMain, panelNeu, titel,
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
			if (hauptsp.getText().trim().equals("")
					|| fremdsp.getText().trim().equals(""))
			{
				guiMain.getGuiDialog().fehlerDialog(
						sprachcontroller.getSprache("Fehler",
								GuiMain.SPRACHCODE),
						sprachcontroller.getSprache(
								"Die Felder dürfen nicht leer sein",
								GuiMain.SPRACHCODE));
				return false;
			} else
			{
				hauptsprache = hauptsp.getText().trim();
				fremdsprache = fremdsp.getText().trim();
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiDialog [guiMain=" + guiMain + ", sprachcontroller="
				+ sprachcontroller + ", handler=" + handler + ", hauptsprache="
				+ hauptsprache + ", fremdsprache=" + fremdsprache + "]";
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
				+ ((fremdsprache == null) ? 0 : fremdsprache.hashCode());
		result = prime * result + ((guiMain == null) ? 0 : guiMain.hashCode());
		result = prime * result + ((handler == null) ? 0 : handler.hashCode());
		result = prime * result
				+ ((hauptsprache == null) ? 0 : hauptsprache.hashCode());
		result = prime
				* result
				+ ((sprachcontroller == null) ? 0 : sprachcontroller.hashCode());
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
		GuiDialog other = (GuiDialog) obj;
		if (fremdsprache == null)
		{
			if (other.fremdsprache != null)
				return false;
		} else if (!fremdsprache.equals(other.fremdsprache))
			return false;
		if (guiMain == null)
		{
			if (other.guiMain != null)
				return false;
		} else if (!guiMain.equals(other.guiMain))
			return false;
		if (handler == null)
		{
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		if (hauptsprache == null)
		{
			if (other.hauptsprache != null)
				return false;
		} else if (!hauptsprache.equals(other.hauptsprache))
			return false;
		if (sprachcontroller == null)
		{
			if (other.sprachcontroller != null)
				return false;
		} else if (!sprachcontroller.equals(other.sprachcontroller))
			return false;
		return true;
	}

	/**
	 * @return the guiMain
	 */
	public GuiMain getGuiMain()
	{
		return guiMain;
	}

	/**
	 * @param guiMain
	 *            the guiMain to set
	 */
	public void setGuiMain(GuiMain guiMain)
	{
		this.guiMain = guiMain;
	}

	/**
	 * @return the sprachcontroller
	 */
	public SprachController getSprachcontroller()
	{
		return sprachcontroller;
	}

	/**
	 * @param sprachcontroller
	 *            the sprachcontroller to set
	 */
	public void setSprachcontroller(SprachController sprachcontroller)
	{
		this.sprachcontroller = sprachcontroller;
	}

	/**
	 * @return the handler
	 */
	public Handler getHandler()
	{
		return handler;
	}

	/**
	 * @param handler
	 *            the handler to set
	 */
	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	/**
	 * @return the hauptsprache
	 */
	public String getHauptsprache()
	{
		return hauptsprache;
	}

	/**
	 * @param hauptsprache
	 *            the hauptsprache to set
	 */
	public void setHauptsprache(String hauptsprache)
	{
		this.hauptsprache = hauptsprache;
	}

	/**
	 * @return the fremdsprache
	 */
	public String getFremdsprache()
	{
		return fremdsprache;
	}

	/**
	 * @param fremdsprache
	 *            the fremdsprache to set
	 */
	public void setFremdsprache(String fremdsprache)
	{
		this.fremdsprache = fremdsprache;
	}

}
