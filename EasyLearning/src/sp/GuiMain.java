package sp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import mk.Handler;
import dd.SprachController;

public class GuiMain extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static final int WINDOWWITDH = 1024;
	public static final int WINDOWHEIGHT = 768;
	public static final Color COLOR_BACKGROUND = new Color(30, 30, 30);
	public static final Color COLOR_TEXT_WHITE = new Color(240, 240, 240);
	public static final String version = "0.1";
	public static int SPRACHCODE = 0;
	private Handler handler;
	private Dimension dimension;
	private SprachController sprachcontroller;
	private GuiMenuebar guiMenuebar;
	private GuiKarteiTitel guiKarteiTitel;
	private GuiEingabeFeld guiEingabeFeld;
	private GuiSmileyStatistik guiSmileyStatistik;
	private GuiDialog guiDialog;
	private GuiKarteiKartePanel karteKarteiPanel;
	private GuiKarteButtons karteButtons;

	public GuiMain()
	{
		handler = new Handler(this);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		try
		{
			sprachcontroller = new SprachController();
		} catch (IOException e)
		{
			guiDialog.fehlerDialog("Error!",
					"Critital-Error with Language-File!");
			e.printStackTrace();
		}
		guiMenuebar = new GuiMenuebar(this);
		guiKarteiTitel = new GuiKarteiTitel();
		guiEingabeFeld = new GuiEingabeFeld(this);
		guiSmileyStatistik = new GuiSmileyStatistik();
		guiDialog = new GuiDialog(this);
		karteKarteiPanel = new GuiKarteiKartePanel(this, 60, 50, 0, Color.CYAN);
		karteButtons = new GuiKarteButtons(this);
		setLayout(new BorderLayout());
		getContentPane().setBackground(COLOR_BACKGROUND);
		setSize(WINDOWWITDH, WINDOWHEIGHT);
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		setSize(WINDOWWITDH, WINDOWHEIGHT);
		setResizable(false);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		versteckeAlleElemente(true);
	}

	public void init()
	{
		guiMenuebar.init();
		add(guiKarteiTitel.getPanel(), BorderLayout.NORTH);
		add(guiSmileyStatistik, BorderLayout.EAST);
		add(guiEingabeFeld.getPanel(), BorderLayout.SOUTH);
		add(karteButtons.getPanel(), BorderLayout.WEST);
		add(karteKarteiPanel.getPanel(), BorderLayout.CENTER);
		repaint();
		setVisible(true);
	}

	public void versteckeAlleElemente(boolean verstecken)
	{
		versteckeSmiley();
		versteckeKarte(verstecken);
		versteckeButtons(verstecken);
		versteckeKarteiTitel(verstecken);
		versteckeEingabefeld(verstecken);
		versteckeStatistik(!verstecken);
		guiMenuebar.getSpeichernEintrag().setEnabled(!verstecken);
		guiMenuebar.getExportEintrag().setEnabled(!verstecken);
		guiMenuebar.getLoeschenEintrag().setEnabled(!verstecken);
		this.repaint();
	}

	/**
	 * Diese Methode �ndert die Farbe der Karte inkl. der Fachauswahl
	 * 
	 * @param color
	 *            Vorschlag: Standard Color.CYAN, Richtig: Color.GREEN, Falsch:
	 *            Color.RED
	 */
	public void setKartenFarbe(Color color)
	{
		karteKarteiPanel.setKartenFarbe(color);
		
	}

	public void setSmiley(boolean like)
	{
		guiSmileyStatistik.getGuiSmiley().setSmiley(like);
	}

	public void versteckeSmiley()
	{
		guiSmileyStatistik.getGuiSmiley().versteckeSmiley();
	}
	
	public void versteckeStatistik(boolean anzeigen)
	{
		guiSmileyStatistik.getGuiStatistik().setVisible(anzeigen);
	}

	public void setWort(String wort)
	{
		if (wort != null)
			karteKarteiPanel.setzeText(wort);
	}

	public String getWort()
	{
		return karteKarteiPanel.getWort().getText();
	}

	public void setKarteiTitel(String titel)
	{
		if (titel != null)
		{
			guiKarteiTitel.setzeKarteiTitelText(titel);
		}
	}

	public String getKarteiTitel()
	{
		return guiKarteiTitel.getKarteiTitel().getText();
	}

	public String getEingabefeld()
	{
		return guiEingabeFeld.getTextFeld().toString();
	}

	public void setEingabefeld(String text)
	{
		guiEingabeFeld.getTextFeld().setText(text);
	}

	public void versteckeKarte(boolean verstecken)
	{
		karteKarteiPanel.getPanel().setVisible(!verstecken);
	}

	public void versteckeButtons(boolean verstecken)
	{
		karteButtons.getPanel().setVisible(!verstecken);
	}

	public void versteckeKarteiTitel(boolean verstecken)
	{
		guiKarteiTitel.getPanel().setVisible(!verstecken);
	}

	public void versteckeEingabefeld(boolean verstecken)
	{
		guiEingabeFeld.getPanel().setVisible(!verstecken);
	}

	/**
	 * @return the sPRACHCODE
	 */
	public static int getSPRACHCODE()
	{
		return SPRACHCODE;
	}

	/**
	 * @param sPRACHCODE
	 *            the sPRACHCODE to set
	 */
	public static void setSPRACHCODE(int sPRACHCODE)
	{
		SPRACHCODE = sPRACHCODE;
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
	 * @return the dimension
	 */
	public Dimension getDimension()
	{
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
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
	 * @return the guiMenuebar
	 */
	public GuiMenuebar getGuiMenuebar()
	{
		return guiMenuebar;
	}

	/**
	 * @param guiMenuebar
	 *            the guiMenuebar to set
	 */
	public void setGuiMenuebar(GuiMenuebar guiMenuebar)
	{
		this.guiMenuebar = guiMenuebar;
	}

	/**
	 * @return the guiKarteiTitel
	 */
	public GuiKarteiTitel getGuiKarteiTitel()
	{
		return guiKarteiTitel;
	}

	/**
	 * @param guiKarteiTitel
	 *            the guiKarteiTitel to set
	 */
	public void setGuiKarteiTitel(GuiKarteiTitel guiKarteiTitel)
	{
		this.guiKarteiTitel = guiKarteiTitel;
	}

	/**
	 * @return the guiEingabeFeld
	 */
	public GuiEingabeFeld getGuiEingabeFeld()
	{
		return guiEingabeFeld;
	}

	/**
	 * @param guiEingabeFeld
	 *            the guiEingabeFeld to set
	 */
	public void setGuiEingabeFeld(GuiEingabeFeld guiEingabeFeld)
	{
		this.guiEingabeFeld = guiEingabeFeld;
	}

	/**
	 * @return the guiSmileyStatistik
	 */
	public GuiSmileyStatistik getguiSmileyStatistik()
	{
		return guiSmileyStatistik;
	}

	/**
	 * @param guiSmileyStatistik
	 *            the guiSmileyStatistik to set
	 */
	public void setguiSmileyStatistik(GuiSmileyStatistik guiSmileyStatistik)
	{
		this.guiSmileyStatistik = guiSmileyStatistik;
	}

	/**
	 * @return the guiDialog
	 */
	public GuiDialog getGuiDialog()
	{
		return guiDialog;
	}

	/**
	 * @param guiDialog
	 *            the guiDialog to set
	 */
	public void setGuiDialog(GuiDialog guiDialog)
	{
		this.guiDialog = guiDialog;
	}

	/**
	 * @return the karteKarteiPanel
	 */
	public GuiKarteiKartePanel getKarteKarteiPanel()
	{
		return karteKarteiPanel;
	}

	/**
	 * @param karteKarteiPanel
	 *            the karteKarteiPanel to set
	 */
	public void setKarteKarteiPanel(GuiKarteiKartePanel karteKarteiPanel)
	{
		this.karteKarteiPanel = karteKarteiPanel;
	}

	/**
	 * @return the karteButtons
	 */
	public GuiKarteButtons getKarteButtons()
	{
		return karteButtons;
	}

	/**
	 * @param karteButtons
	 *            the karteButtons to set
	 */
	public void setKarteButtons(GuiKarteButtons karteButtons)
	{
		this.karteButtons = karteButtons;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	/**
	 * @return the windowwitdh
	 */
	public static int getWindowwitdh()
	{
		return WINDOWWITDH;
	}

	/**
	 * @return the windowheight
	 */
	public static int getWindowheight()
	{
		return WINDOWHEIGHT;
	}

	/**
	 * @return the colorBackground
	 */
	public static Color getColorBackground()
	{
		return COLOR_BACKGROUND;
	}

	/**
	 * @return the colorTextWhite
	 */
	public static Color getColorTextWhite()
	{
		return COLOR_TEXT_WHITE;
	}

	/**
	 * @return the version
	 */
	public static String getVersion()
	{
		return version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiMain [handler=" + handler + ", dimension=" + dimension
				+ ", sprachcontroller=" + sprachcontroller + ", guiMenuebar="
				+ guiMenuebar + ", guiKarteiTitel=" + guiKarteiTitel
				+ ", guiEingabeFeld=" + guiEingabeFeld + ", guiSmileyStatistik="
				+ guiSmileyStatistik + ", guiDialog=" + guiDialog
				+ ", karteKarteiPanel=" + karteKarteiPanel + ", karteButtons="
				+ karteButtons + "]";
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
		GuiMain other = (GuiMain) obj;
		if (dimension == null)
		{
			if (other.dimension != null)
				return false;
		} else if (!dimension.equals(other.dimension))
			return false;
		if (guiDialog == null)
		{
			if (other.guiDialog != null)
				return false;
		} else if (!guiDialog.equals(other.guiDialog))
			return false;
		if (guiEingabeFeld == null)
		{
			if (other.guiEingabeFeld != null)
				return false;
		} else if (!guiEingabeFeld.equals(other.guiEingabeFeld))
			return false;
		if (guiKarteiTitel == null)
		{
			if (other.guiKarteiTitel != null)
				return false;
		} else if (!guiKarteiTitel.equals(other.guiKarteiTitel))
			return false;
		if (guiMenuebar == null)
		{
			if (other.guiMenuebar != null)
				return false;
		} else if (!guiMenuebar.equals(other.guiMenuebar))
			return false;
		if (guiSmileyStatistik == null)
		{
			if (other.guiSmileyStatistik != null)
				return false;
		} else if (!guiSmileyStatistik.equals(other.guiSmileyStatistik))
			return false;
		if (handler == null)
		{
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		if (karteButtons == null)
		{
			if (other.karteButtons != null)
				return false;
		} else if (!karteButtons.equals(other.karteButtons))
			return false;
		if (karteKarteiPanel == null)
		{
			if (other.karteKarteiPanel != null)
				return false;
		} else if (!karteKarteiPanel.equals(other.karteKarteiPanel))
			return false;
		if (sprachcontroller == null)
		{
			if (other.sprachcontroller != null)
				return false;
		} else if (!sprachcontroller.equals(other.sprachcontroller))
			return false;
		return true;
	}

}
