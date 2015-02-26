package sp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiKarteiTitel
{
	private JPanel panel;
	private JLabel karteiTitel;
	
	public GuiKarteiTitel()
	{
		panel = new JPanel(true);
		panel.setPreferredSize(new Dimension(GuiMain.getWindowwidth(),75));
		panel.setBackground(Color.ORANGE);
		this.karteiTitel = new JLabel("Kartei");
		this.karteiTitel.setFont(new Font(null, Font.BOLD, 50));
		panel.add(this.karteiTitel);
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
	
	public void setzeKarteiTitelText(String karteiTitel)
	{
		this.karteiTitel.setText(karteiTitel);
	}
	

}
