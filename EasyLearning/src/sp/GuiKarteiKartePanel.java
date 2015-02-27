package sp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import mk.Handler;

public class GuiKarteiKartePanel
{
	private GuiMain gui;
	private Handler handler;
	private JLayeredPane panel;
	private KarteGui karte;
	private JLabel wort;
	private ArrayList<JLabel> faecherBez;
	private JLabel fach1Bez;
	private JLabel fach2Bez;
	private JLabel fach3Bez;
	private JLabel fach4Bez;
	private JLabel fach5Bez;
	private JLabel fach6Bez;

	public GuiKarteiKartePanel(GuiMain guiMain, int xSize, int ySize)
	{
		gui = guiMain;
		handler = gui.getHandler();
		panel = new JLayeredPane();
		faecherBez = new ArrayList<>();
		panel.setBackground(GuiMain.COLOR_BACKGROUND);
		karte = new KarteGui();
		panel.add(karte, 1, 0);
		this.wort = new JLabel();
		panel.add(wort, 2, 0);
		this.fach1Bez = new JLabel();
		this.fach1Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach1Bez);
		panel.add(fach1Bez, 2, 0);
		this.fach2Bez = new JLabel();
		this.fach2Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach2Bez);
		panel.add(fach2Bez, 2, 0);
		this.fach3Bez = new JLabel();
		this.fach3Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach3Bez);
		panel.add(fach3Bez, 2, 0);
		this.fach4Bez = new JLabel();
		this.fach4Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach4Bez);
		panel.add(fach4Bez, 2, 0);
		this.fach5Bez = new JLabel();
		this.fach5Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach5Bez);
		panel.add(fach5Bez, 2, 0);
		this.fach6Bez = new JLabel();
		this.fach6Bez.addMouseListener(new MyMouseListener());
		faecherBez.add(fach6Bez);
		panel.add(fach6Bez, 2, 0);
		setzeFachBez();
		setzeFachAktiv(fach1Bez);
	}

	public void setzeText(String wort)
	{
		if (wort != null)
		{
			int schriftgroesse = 55 - (wort.length());
			this.wort.setText(wort);
			this.wort.setHorizontalAlignment(JLabel.CENTER);
			this.wort.setSize(500, 55);
			this.wort.setLocation(155, 295);
			this.wort.setFont(new Font(null, Font.BOLD, schriftgroesse));
			this.wort.setBackground(Color.CYAN);
			this.wort.setForeground(GuiMain.COLOR_BACKGROUND);
			this.wort.setOpaque(true);
		}
	}

	public void setzeFachBez()
	{
		int i = 1;
		int startPosX = 67;
		for (JLabel fach : faecherBez)
		{
			fach.setText("" + i);
			fach.setSize(60, 50);
			fach.setFont(new Font(null, Font.BOLD, 30));
			fach.setHorizontalAlignment(JLabel.CENTER);
			fach.setOpaque(true);
			fach.setBackground(GuiMain.COLOR_BACKGROUND);
			fach.setLocation(startPosX += 88, 100);
			i++;
		}
		i = 0;
	}

	public void setzeFachAktiv(JLabel fach)
	{
		for (JLabel faechlein : faecherBez)
		{
			if (!faechlein.equals(fach))
			{
				faechlein.setBackground(Color.DARK_GRAY);
			} else
			{
				fach.setBackground(Color.CYAN);
			}
		}
	}

	class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			JLabel k = (JLabel) e.getSource();
			setzeFachAktiv(k);
			handler.eventGeheZuFach(Integer.parseInt(k.getText()));
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{

		}

		@Override
		public void mouseExited(MouseEvent e)
		{

		}

		@Override
		public void mousePressed(MouseEvent e)
		{

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{

		}
	}

	/**
	 * @return the panel
	 */
	public JLayeredPane getPanel()
	{
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public void setPanel(JLayeredPane panel)
	{
		this.panel = panel;
	}

	/**
	 * @return the karte
	 */
	public KarteGui getKarte()
	{
		return karte;
	}

	/**
	 * @param karte
	 *            the karte to set
	 */
	public void setKarte(KarteGui karte)
	{
		this.karte = karte;
	}

	/**
	 * @return the wort
	 */
	public JLabel getWort()
	{
		return wort;
	}

	/**
	 * @param wort
	 *            the wort to set
	 */
	public void setWort(JLabel wort)
	{
		this.wort = wort;
	}

	/**
	 * @return the faecherBez
	 */
	public ArrayList<JLabel> getFaecherBez()
	{
		return faecherBez;
	}

	/**
	 * @param faecherBez
	 *            the faecherBez to set
	 */
	public void setFaecherBez(ArrayList<JLabel> faecherBez)
	{
		this.faecherBez = faecherBez;
	}

	/**
	 * @return the fach1Bez
	 */
	public JLabel getFach1Bez()
	{
		return fach1Bez;
	}

	/**
	 * @param fach1Bez
	 *            the fach1Bez to set
	 */
	public void setFach1Bez(JLabel fach1Bez)
	{
		this.fach1Bez = fach1Bez;
	}

	/**
	 * @return the fach2Bez
	 */
	public JLabel getFach2Bez()
	{
		return fach2Bez;
	}

	/**
	 * @param fach2Bez
	 *            the fach2Bez to set
	 */
	public void setFach2Bez(JLabel fach2Bez)
	{
		this.fach2Bez = fach2Bez;
	}

	/**
	 * @return the fach3Bez
	 */
	public JLabel getFach3Bez()
	{
		return fach3Bez;
	}

	/**
	 * @param fach3Bez
	 *            the fach3Bez to set
	 */
	public void setFach3Bez(JLabel fach3Bez)
	{
		this.fach3Bez = fach3Bez;
	}

	/**
	 * @return the fach4Bez
	 */
	public JLabel getFach4Bez()
	{
		return fach4Bez;
	}

	/**
	 * @param fach4Bez
	 *            the fach4Bez to set
	 */
	public void setFach4Bez(JLabel fach4Bez)
	{
		this.fach4Bez = fach4Bez;
	}

	/**
	 * @return the fach5Bez
	 */
	public JLabel getFach5Bez()
	{
		return fach5Bez;
	}

	/**
	 * @param fach5Bez
	 *            the fach5Bez to set
	 */
	public void setFach5Bez(JLabel fach5Bez)
	{
		this.fach5Bez = fach5Bez;
	}

	/**
	 * @return the fach6Bez
	 */
	public JLabel getFach6Bez()
	{
		return fach6Bez;
	}

	/**
	 * @param fach6Bez
	 *            the fach6Bez to set
	 */
	public void setFach6Bez(JLabel fach6Bez)
	{
		this.fach6Bez = fach6Bez;
	}

}
