package sp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Diese Klasse erzeugt auf der guiMain ein JPanel mit dem Titel der Kartei
 * 
 * @author Sajeevan und Damjan
 * @version 1.2
 *
 */
public class GuiKarteiTitel
{
	private JPanel panel;
	private JLabel karteiTitel;

	/**
	 * Konstruktor
	 */
	public GuiKarteiTitel()
	{
		panel = new JPanel(true);
		panel.setPreferredSize(new Dimension(GuiMain.WINDOWWITDH, 65));
		panel.setForeground(GuiMain.COLOR_BACKGROUND);
		panel.setBackground(Color.ORANGE);
		panel.setBorder(BorderFactory.createEmptyBorder());
		karteiTitel = new JLabel();
		karteiTitel.setFont(new Font(null, Font.BOLD, 40));
		panel.add(karteiTitel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiKarteiTitel [panel=" + panel + ", karteiTitel="
				+ karteiTitel + "]";
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
				+ ((karteiTitel == null) ? 0 : karteiTitel.hashCode());
		result = prime * result + ((panel == null) ? 0 : panel.hashCode());
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
		GuiKarteiTitel other = (GuiKarteiTitel) obj;
		if (karteiTitel == null)
		{
			if (other.karteiTitel != null)
				return false;
		} else if (!karteiTitel.equals(other.karteiTitel))
			return false;
		if (panel == null)
		{
			if (other.panel != null)
				return false;
		} else if (!panel.equals(other.panel))
			return false;
		return true;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel()
	{
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public void setPanel(JPanel panel)
	{
		this.panel = panel;
	}

	/**
	 * @return the karteiTitel
	 */
	public JLabel getKarteiTitel()
	{
		return karteiTitel;
	}

	/**
	 * @param karteiTitel
	 *            the karteiTitel to set
	 */
	public void setKarteiTitel(JLabel karteiTitel)
	{
		this.karteiTitel = karteiTitel;
	}

	public void setzeKarteiTitelText(String titel)
	{
		this.karteiTitel.setText(titel);
	}

}
