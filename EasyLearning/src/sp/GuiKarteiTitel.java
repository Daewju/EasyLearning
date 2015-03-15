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
 * @author Sajeevan & Damjan
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
		panel.setPreferredSize(new Dimension(GuiMain.WINDOWWITDH,65));
		panel.setForeground(GuiMain.COLOR_BACKGROUND);
		panel.setBackground(Color.ORANGE);
		panel.setBorder(BorderFactory.createEmptyBorder());
		karteiTitel = new JLabel();
		karteiTitel.setFont(new Font(null, Font.BOLD, 40));
		panel.add(karteiTitel);
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel()
	{
		return panel;
	}

	/**
	 * @param panel the panel to set
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
	 * @param karteiTitel the karteiTitel to set
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
