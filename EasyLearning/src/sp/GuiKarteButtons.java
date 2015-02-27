package sp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import mk.Handler;
import dd.SprachController;

public class GuiKarteButtons
{
	private GuiMain guiMain;
	private SprachController sprachcontroller;
	private Handler handler;
	private JPanel hauptpanel;
	private JPanel panel;
	private BufferedImage bildHinzufuegen;
	private BufferedImage bildBearbeiten;
	private BufferedImage bildLoeschen;
	private BufferedImage bildHinzufuegenC;
	private BufferedImage bildBearbeitenC;
	private BufferedImage bildLoeschenC;
	private BufferedImage bildHinzufuegenO;
	private BufferedImage bildBearbeitenO;
	private BufferedImage bildLoeschenO;
	private JButton buttonHinzufuegen;
	private JButton buttonBearbeiten;
	private JButton buttonLoeschen;

	public GuiKarteButtons(GuiMain gui)
	{
		guiMain = gui;
		sprachcontroller = guiMain.getSprachcontroller();
		handler = new Handler(guiMain);
		hauptpanel = new JPanel(new GridBagLayout());
		hauptpanel.setBackground(GuiMain.COLOR_BACKGROUND);
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
		panel.setBackground(GuiMain.COLOR_BACKGROUND);
		panel.setPreferredSize(new Dimension(100, 500));
		try
		{
			bildHinzufuegen = ImageIO.read(getClass().getResource(
					"/data/button_add.png"));
			bildBearbeiten = ImageIO.read(getClass().getResource(
					"/data/button_change.png"));
			bildLoeschen = ImageIO.read(getClass().getResource(
					"/data/button_remove.png"));
			bildHinzufuegenC = ImageIO.read(getClass().getResource(
					"/data/button_add_clicked.png"));
			bildBearbeitenC = ImageIO.read(getClass().getResource(
					"/data/button_change_clicked.png"));
			bildLoeschenC = ImageIO.read(getClass().getResource(
					"/data/button_remove_clicked.png"));
			bildHinzufuegenO = ImageIO.read(getClass().getResource(
					"/data/button_add_over.png"));
			bildBearbeitenO = ImageIO.read(getClass().getResource(
					"/data/button_change_over.png"));
			bildLoeschenO = ImageIO.read(getClass().getResource(
					"/data/button_remove_over.png"));
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		buttonHinzufuegen = new JButton(new ImageIcon(bildHinzufuegen));
		buttonBearbeiten = new JButton(new ImageIcon(bildBearbeiten));
		buttonLoeschen = new JButton(new ImageIcon(bildLoeschen));
		buttonHinzufuegen.setBorder(BorderFactory.createEmptyBorder());
		buttonHinzufuegen.setContentAreaFilled(false);
		buttonBearbeiten.setBorder(BorderFactory.createEmptyBorder());
		buttonBearbeiten.setContentAreaFilled(false);
		buttonLoeschen.setBorder(BorderFactory.createEmptyBorder());
		buttonLoeschen.setContentAreaFilled(false);
		panel.add(buttonHinzufuegen);
		panel.add(buttonBearbeiten);
		panel.add(buttonLoeschen);
		hauptpanel.add(panel, new GridBagConstraints());

		buttonHinzufuegen.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				buttonHinzufuegen.setIcon(new ImageIcon(bildHinzufuegenO));
				boolean ergebnis = false;
				while (!ergebnis)
				{
					ergebnis = guiMain.getGuiDialog().erzeugeNeuEingabeDialog(
							sprachcontroller.getSprache("Karte hinzufügen",
									GuiMain.SPRACHCODE),
							sprachcontroller.getSprache("Wort",
									GuiMain.SPRACHCODE) + ": ",
							sprachcontroller.getSprache("Vokabel",
									GuiMain.SPRACHCODE) + ": ");
				}
				if (guiMain.getGuiDialog().getHauptsprache() != null
						&& guiMain.getGuiDialog().getFremdsprache() != null)
				{
					handler.eventNeueKarteHinzufuegen(guiMain.getGuiDialog()
							.getHauptsprache(), guiMain.getGuiDialog()
							.getFremdsprache());
					guiMain.getGuiDialog().setHauptsprache(null);
					guiMain.getGuiDialog().setFremdsprache(null);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				buttonHinzufuegen.setIcon(new ImageIcon(bildHinzufuegenO));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				buttonHinzufuegen.setIcon(new ImageIcon(bildHinzufuegen));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				buttonHinzufuegen.setIcon(new ImageIcon(bildHinzufuegenC));
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});

		buttonBearbeiten.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeitenO));
				boolean ergebnis = false;
				while (!ergebnis)
				{
					ergebnis = guiMain.getGuiDialog().erzeugeNeuEingabeDialog(
							sprachcontroller.getSprache("Karte bearbeiten",
									GuiMain.SPRACHCODE),
							sprachcontroller.getSprache("Wort",
									GuiMain.SPRACHCODE) + ": ",
							sprachcontroller.getSprache("Vokabel",
									GuiMain.SPRACHCODE) + ": ");
				}
				handler.eventKarteBearbeiten(guiMain.getGuiDialog()
						.getHauptsprache(), guiMain.getGuiDialog()
						.getFremdsprache());
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeitenO));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeiten));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeitenC));
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{

			}

		});

		buttonLoeschen.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				buttonLoeschen.setIcon(new ImageIcon(bildLoeschen));
				if (guiMain.getGuiDialog().variableButtonsDialog(
						new Object[]
						{
								sprachcontroller.getSprache("Ja",
										GuiMain.SPRACHCODE),
								sprachcontroller.getSprache("Nein",
										GuiMain.SPRACHCODE) },
						sprachcontroller.getSprache("Karte löschen",
								GuiMain.SPRACHCODE),
						sprachcontroller.getSprache("Sind Sie sicher?",
								GuiMain.SPRACHCODE)) == 0)
				{
					handler.eventKarteLoeschen(guiMain.getKarteKarteiPanel()
							.getWort().getText());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				buttonLoeschen.setIcon(new ImageIcon(bildLoeschenO));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				buttonLoeschen.setIcon(new ImageIcon(bildLoeschen));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				buttonLoeschen.setIcon(new ImageIcon(bildLoeschenC));
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{

			}

		});

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
	 * @return the hauptpanel
	 */
	public JPanel getHauptpanel()
	{
		return hauptpanel;
	}

	/**
	 * @param hauptpanel
	 *            the hauptpanel to set
	 */
	public void setHauptpanel(JPanel hauptpanel)
	{
		this.hauptpanel = hauptpanel;
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
	 * @return the bildHinzufuegen
	 */
	public BufferedImage getBildHinzufuegen()
	{
		return bildHinzufuegen;
	}

	/**
	 * @param bildHinzufuegen
	 *            the bildHinzufuegen to set
	 */
	public void setBildHinzufuegen(BufferedImage bildHinzufuegen)
	{
		this.bildHinzufuegen = bildHinzufuegen;
	}

	/**
	 * @return the bildBearbeiten
	 */
	public BufferedImage getBildBearbeiten()
	{
		return bildBearbeiten;
	}

	/**
	 * @param bildBearbeiten
	 *            the bildBearbeiten to set
	 */
	public void setBildBearbeiten(BufferedImage bildBearbeiten)
	{
		this.bildBearbeiten = bildBearbeiten;
	}

	/**
	 * @return the bildLoeschen
	 */
	public BufferedImage getBildLoeschen()
	{
		return bildLoeschen;
	}

	/**
	 * @param bildLoeschen
	 *            the bildLoeschen to set
	 */
	public void setBildLoeschen(BufferedImage bildLoeschen)
	{
		this.bildLoeschen = bildLoeschen;
	}

	/**
	 * @return the bildHinzufuegenC
	 */
	public BufferedImage getBildHinzufuegenC()
	{
		return bildHinzufuegenC;
	}

	/**
	 * @param bildHinzufuegenC
	 *            the bildHinzufuegenC to set
	 */
	public void setBildHinzufuegenC(BufferedImage bildHinzufuegenC)
	{
		this.bildHinzufuegenC = bildHinzufuegenC;
	}

	/**
	 * @return the bildBearbeitenC
	 */
	public BufferedImage getBildBearbeitenC()
	{
		return bildBearbeitenC;
	}

	/**
	 * @param bildBearbeitenC
	 *            the bildBearbeitenC to set
	 */
	public void setBildBearbeitenC(BufferedImage bildBearbeitenC)
	{
		this.bildBearbeitenC = bildBearbeitenC;
	}

	/**
	 * @return the bildLoeschenC
	 */
	public BufferedImage getBildLoeschenC()
	{
		return bildLoeschenC;
	}

	/**
	 * @param bildLoeschenC
	 *            the bildLoeschenC to set
	 */
	public void setBildLoeschenC(BufferedImage bildLoeschenC)
	{
		this.bildLoeschenC = bildLoeschenC;
	}

	/**
	 * @return the bildHinzufuegenO
	 */
	public BufferedImage getBildHinzufuegenO()
	{
		return bildHinzufuegenO;
	}

	/**
	 * @param bildHinzufuegenO
	 *            the bildHinzufuegenO to set
	 */
	public void setBildHinzufuegenO(BufferedImage bildHinzufuegenO)
	{
		this.bildHinzufuegenO = bildHinzufuegenO;
	}

	/**
	 * @return the bildBearbeitenO
	 */
	public BufferedImage getBildBearbeitenO()
	{
		return bildBearbeitenO;
	}

	/**
	 * @param bildBearbeitenO
	 *            the bildBearbeitenO to set
	 */
	public void setBildBearbeitenO(BufferedImage bildBearbeitenO)
	{
		this.bildBearbeitenO = bildBearbeitenO;
	}

	/**
	 * @return the bildLoeschenO
	 */
	public BufferedImage getBildLoeschenO()
	{
		return bildLoeschenO;
	}

	/**
	 * @param bildLoeschenO
	 *            the bildLoeschenO to set
	 */
	public void setBildLoeschenO(BufferedImage bildLoeschenO)
	{
		this.bildLoeschenO = bildLoeschenO;
	}

	/**
	 * @return the buttonHinzufuegen
	 */
	public JButton getButtonHinzufuegen()
	{
		return buttonHinzufuegen;
	}

	/**
	 * @param buttonHinzufuegen
	 *            the buttonHinzufuegen to set
	 */
	public void setButtonHinzufuegen(JButton buttonHinzufuegen)
	{
		this.buttonHinzufuegen = buttonHinzufuegen;
	}

	/**
	 * @return the buttonBearbeiten
	 */
	public JButton getButtonBearbeiten()
	{
		return buttonBearbeiten;
	}

	/**
	 * @param buttonBearbeiten
	 *            the buttonBearbeiten to set
	 */
	public void setButtonBearbeiten(JButton buttonBearbeiten)
	{
		this.buttonBearbeiten = buttonBearbeiten;
	}

	/**
	 * @return the buttonLoeschen
	 */
	public JButton getButtonLoeschen()
	{
		return buttonLoeschen;
	}

	/**
	 * @param buttonLoeschen
	 *            the buttonLoeschen to set
	 */
	public void setButtonLoeschen(JButton buttonLoeschen)
	{
		this.buttonLoeschen = buttonLoeschen;
	}

}
