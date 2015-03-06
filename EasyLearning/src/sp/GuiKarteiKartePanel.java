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
	private int kartenFarbe;
	private Color color;
	private Color colorCorrect;
	private Color colorIncorrect;

	public GuiKarteiKartePanel(GuiMain guiMain, int xSize, int ySize,
			int kartenFarbe)
	{
		gui = guiMain;
		this.color = Color.CYAN;;
		this.colorCorrect = Color.GREEN;
		this.colorIncorrect = Color.RED;
		this.kartenFarbe = kartenFarbe;
		handler = gui.getHandler();
		panel = new JLayeredPane();
		faecherBez = new ArrayList<>();
		panel.setBackground(GuiMain.COLOR_BACKGROUND);
		karte = new KarteGui(null);
		karte.setBackground(getKartenFarbe());
		setKartenFarbe(kartenFarbe);
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
			this.wort.setBackground(getKartenFarbe());
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
			fach.setBackground(karte.getBackground());
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
				switch (kartenFarbe)
				{
				case 0:
					fach.setBackground(color);
					break;
				case 1:
					fach.setBackground(colorCorrect);
					break;
				case 2:
					fach.setBackground(colorIncorrect);
					break;
				default:
					fach.setBackground(color);
					break;
				}
			}
		}
	}

	public void setKartenFarbe(int kartenFarbe)
	{
		this.kartenFarbe = kartenFarbe;
		switch (kartenFarbe)
		{
		case 0:
			karte.setBackground(color);
			break;
		case 1:
			karte.setBackground(colorCorrect);
			break;
		case 2:
			karte.setBackground(colorIncorrect);
			break;
		default:
			karte.setBackground(color);
			break;
		}
	}
	
	public Color getKartenFarbe()
	{
		return karte.getBackground();
	}


	/**
	 * @return the gui
	 */
	public GuiMain getGui()
	{
		return gui;
	}

	/**
	 * @param gui
	 *            the gui to set
	 */
	public void setGui(GuiMain gui)
	{
		this.gui = gui;
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

	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}

	/**
	 * @return the colorCorrect
	 */
	public Color getColorCorrect()
	{
		return colorCorrect;
	}

	/**
	 * @param colorCorrect
	 *            the colorCorrect to set
	 */
	public void setColorCorrect(Color colorCorrect)
	{
		this.colorCorrect = colorCorrect;
	}

	/**
	 * @return the colorIncorrect
	 */
	public Color getColorIncorrect()
	{
		return colorIncorrect;
	}

	/**
	 * @param colorIncorrect
	 *            the colorIncorrect to set
	 */
	public void setColorIncorrect(Color colorIncorrect)
	{
		this.colorIncorrect = colorIncorrect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiKarteiKartePanel [gui=" + gui + ", handler=" + handler
				+ ", panel=" + panel + ", karte=" + karte + ", wort=" + wort
				+ ", faecherBez=" + faecherBez + ", fach1Bez=" + fach1Bez
				+ ", fach2Bez=" + fach2Bez + ", fach3Bez=" + fach3Bez
				+ ", fach4Bez=" + fach4Bez + ", fach5Bez=" + fach5Bez
				+ ", fach6Bez=" + fach6Bez + ", kartenFarbe=" + kartenFarbe
				+ ", color=" + color + ", colorCorrect=" + colorCorrect
				+ ", colorIncorrect=" + colorIncorrect + "]";
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
		GuiKarteiKartePanel other = (GuiKarteiKartePanel) obj;
		if (color == null)
		{
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (colorCorrect == null)
		{
			if (other.colorCorrect != null)
				return false;
		} else if (!colorCorrect.equals(other.colorCorrect))
			return false;
		if (colorIncorrect == null)
		{
			if (other.colorIncorrect != null)
				return false;
		} else if (!colorIncorrect.equals(other.colorIncorrect))
			return false;
		if (fach1Bez == null)
		{
			if (other.fach1Bez != null)
				return false;
		} else if (!fach1Bez.equals(other.fach1Bez))
			return false;
		if (fach2Bez == null)
		{
			if (other.fach2Bez != null)
				return false;
		} else if (!fach2Bez.equals(other.fach2Bez))
			return false;
		if (fach3Bez == null)
		{
			if (other.fach3Bez != null)
				return false;
		} else if (!fach3Bez.equals(other.fach3Bez))
			return false;
		if (fach4Bez == null)
		{
			if (other.fach4Bez != null)
				return false;
		} else if (!fach4Bez.equals(other.fach4Bez))
			return false;
		if (fach5Bez == null)
		{
			if (other.fach5Bez != null)
				return false;
		} else if (!fach5Bez.equals(other.fach5Bez))
			return false;
		if (fach6Bez == null)
		{
			if (other.fach6Bez != null)
				return false;
		} else if (!fach6Bez.equals(other.fach6Bez))
			return false;
		if (faecherBez == null)
		{
			if (other.faecherBez != null)
				return false;
		} else if (!faecherBez.equals(other.faecherBez))
			return false;
		if (gui == null)
		{
			if (other.gui != null)
				return false;
		} else if (!gui.equals(other.gui))
			return false;
		if (handler == null)
		{
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		if (karte == null)
		{
			if (other.karte != null)
				return false;
		} else if (!karte.equals(other.karte))
			return false;
		if (kartenFarbe != other.kartenFarbe)
			return false;
		if (panel == null)
		{
			if (other.panel != null)
				return false;
		} else if (!panel.equals(other.panel))
			return false;
		if (wort == null)
		{
			if (other.wort != null)
				return false;
		} else if (!wort.equals(other.wort))
			return false;
		return true;
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

}
