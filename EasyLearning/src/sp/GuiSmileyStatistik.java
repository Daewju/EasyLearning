package sp;

import java.awt.GridLayout;

import javax.swing.JPanel;

import dd.SprachController;

/**
 * Diese Klasse definiert das JPanel in dem das Smiley und die Statistik
 * zusammen
 * 
 * @author Damjan und Sajeevan
 * @version 1.2
 *
 */
public class GuiSmileyStatistik extends JPanel
{

	private static final long serialVersionUID = 1L;
	private GuiSmiley guiSmiley;
	private GuiStatistik guiStatistik;

	/**
	 * Konstruktor
	 * 
	 * @param sc
	 *            als Parameter wird der SprachController erwartet
	 */
	public GuiSmileyStatistik(SprachController sc)
	{

		this.guiSmiley = new GuiSmiley();
		this.guiStatistik = new GuiStatistik(sc);
		this.setLayout(new GridLayout(2, 1));
		this.add(guiSmiley);
		this.add(guiStatistik);
		this.setBackground(GuiMain.COLOR_BACKGROUND);
		this.repaint();
	}

	/**
	 * @return gib das guiSmiley zurü¼ck
	 */
	public GuiSmiley getGuiSmiley()
	{
		return guiSmiley;
	}

	/**
	 * @return gibt die guiStatistik zurü¼ck
	 */
	public GuiStatistik getGuiStatistik()
	{
		return guiStatistik;
	}

	/**
	 * @param guiSmiley
	 *            setzt das guiSmiley
	 */
	public void setGuiSmiley(GuiSmiley guiSmiley)
	{
		this.guiSmiley = guiSmiley;
	}

	/**
	 * @param guiStatistik
	 *            setzt die guiStatistik
	 */
	public void setGuiStatistik(GuiStatistik guiStatistik)
	{
		this.guiStatistik = guiStatistik;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiSmileyStatistik [guiSmiley=" + guiSmiley + ", guiStatistik="
				+ guiStatistik + "]";
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
				+ ((guiSmiley == null) ? 0 : guiSmiley.hashCode());
		result = prime * result
				+ ((guiStatistik == null) ? 0 : guiStatistik.hashCode());
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
		GuiSmileyStatistik other = (GuiSmileyStatistik) obj;
		if (guiSmiley == null)
		{
			if (other.guiSmiley != null)
				return false;
		} else if (!guiSmiley.equals(other.guiSmiley))
			return false;
		if (guiStatistik == null)
		{
			if (other.guiStatistik != null)
				return false;
		} else if (!guiStatistik.equals(other.guiStatistik))
			return false;
		return true;
	}

}
