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
	private SprachController sc;
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

	public GuiKarteButtons(GuiMain gui) throws IOException
	{
		guiMain = gui;
		this.sc = guiMain.getSprachcontroller();
		this.handler = new Handler(guiMain);
		hauptpanel = new JPanel(new GridBagLayout());
		hauptpanel.setBackground(GuiMain.BACKGROUNDCOLOR);
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
		panel.setPreferredSize(new Dimension(GuiMain.getWindowwidth(), 100));
		panel.setBackground(GuiMain.BACKGROUNDCOLOR);
		panel.setPreferredSize(new Dimension(100, 500));
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
				buttonHinzufuegen.setIcon(new ImageIcon(bildHinzufuegen));
				boolean ergebnis = false;
				while (!ergebnis)
				{
					ergebnis = guiMain.getGuiDialog().erzeugeNeuEingabeDialog(
							sc.getSprache("Karte hinzufügen",
									guiMain.getSprachcode()),
							sc.getSprache("Wort", guiMain.getSprachcode())
									+ ": ",
							sc.getSprache("Vokabel", guiMain.getSprachcode())
									+ ": ");
				}
				// handler.empfangeEvent(e);
			}
		});

		buttonBearbeiten.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeitenO));
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
				buttonBearbeiten.setIcon(new ImageIcon(bildBearbeiten));
				boolean ergebnis = false;
				while (!ergebnis)
				{
					ergebnis = guiMain.getGuiDialog().erzeugeNeuEingabeDialog(
							sc.getSprache("Karte bearbeiten",
									guiMain.getSprachcode()),
							sc.getSprache("Wort", guiMain.getSprachcode())
									+ ": ",
							sc.getSprache("Vokabel", guiMain.getSprachcode())
									+ ": ");
				}
				// handler.empfangeEvent(e);
			}

		});

		buttonLoeschen.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{

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
				buttonLoeschen.setIcon(new ImageIcon(bildLoeschen));
				if (guiMain.getGuiDialog()
						.variableButtonsDialog(
								new Object[]
								{
										sc.getSprache("Ja",
												guiMain.getSprachcode()),
										sc.getSprache("Nein",
												guiMain.getSprachcode()) },
								sc.getSprache("Karte löschen",
										guiMain.getSprachcode()),
								sc.getSprache("Sind Sie sicher?",
										guiMain.getSprachcode())) == 0)
				{
					// handler.empfangeEvent(e);
				}
			}

		});

	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel()
	{
		return hauptpanel;
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
