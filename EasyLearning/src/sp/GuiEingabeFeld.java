package sp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextField;

import mk.Handler;
import dd.SprachController;

public class GuiEingabeFeld
{
	private GuiMain guiMain;
	private SprachController sprachcontroller;
	private Handler handler;
	private BufferedImage bildNaechsteKarte;
	private BufferedImage bildNaechsteKarteC;
	private BufferedImage bildNaechsteKarteO;
	private JButton buttonNaechsteKarte;
	private JPanel hauptpanel;
	private JPanel panel;
	private JTextField textFeld;

	public GuiEingabeFeld(GuiMain gui)
	{
		guiMain = gui;
		sprachcontroller = guiMain.getSprachcontroller();
		handler = gui.getHandler();
		try
		{
			bildNaechsteKarte = ImageIO.read(getClass().getResource(
					"/data/button_next.png"));
			bildNaechsteKarteC = ImageIO.read(getClass().getResource(
					"/data/button_next_clicked.png"));
			bildNaechsteKarteO = ImageIO.read(getClass().getResource(
					"/data/button_next_over.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonNaechsteKarte = new JButton(new ImageIcon(bildNaechsteKarte));
		buttonNaechsteKarte.setBorder(BorderFactory.createEmptyBorder());
		buttonNaechsteKarte.setContentAreaFilled(false);
		hauptpanel = new JPanel(new GridBagLayout());
		hauptpanel.setBackground(GuiMain.COLOR_BACKGROUND);
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));
		panel.setPreferredSize(new Dimension(GuiMain.WINDOWWITDH, 65));
		panel.setBackground(Color.ORANGE);
		textFeld = new JTextField();
		textFeld.setEditable(true);
		textFeld.setBackground(GuiMain.COLOR_BACKGROUND);
		textFeld.setForeground(GuiMain.COLOR_TEXT_WHITE);
		textFeld.setBorder(BorderFactory.createEmptyBorder());
		textFeld.setPreferredSize(new Dimension(435, 50));
		textFeld.setFont(new Font(null, Font.BOLD, 30));
		panel.add(textFeld);
		panel.add(buttonNaechsteKarte);
		hauptpanel.add(panel, new GridBagConstraints());
		setActionListener();
	}

	public void setActionListener()
	{
		buttonNaechsteKarte.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				buttonNaechsteKarte.setIcon(new ImageIcon(bildNaechsteKarteO));
				handler.eventNaechsteKarte(textFeld.getText());
			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				buttonNaechsteKarte.setIcon(new ImageIcon(bildNaechsteKarteO));
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
				buttonNaechsteKarte.setIcon(new ImageIcon(bildNaechsteKarte));
			}

			@Override
			public void mousePressed(MouseEvent arg0)
			{
				buttonNaechsteKarte.setIcon(new ImageIcon(bildNaechsteKarteC));
			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				buttonNaechsteKarte.setIcon(new ImageIcon(bildNaechsteKarte));
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
	 * @return the bildNaechsteKarte
	 */
	public BufferedImage getBildNaechsteKarte()
	{
		return bildNaechsteKarte;
	}

	/**
	 * @param bildNaechsteKarte
	 *            the bildNaechsteKarte to set
	 */
	public void setBildNaechsteKarte(BufferedImage bildNaechsteKarte)
	{
		this.bildNaechsteKarte = bildNaechsteKarte;
	}

	/**
	 * @return the bildNaechsteKarteC
	 */
	public BufferedImage getBildNaechsteKarteC()
	{
		return bildNaechsteKarteC;
	}

	/**
	 * @param bildNaechsteKarteC
	 *            the bildNaechsteKarteC to set
	 */
	public void setBildNaechsteKarteC(BufferedImage bildNaechsteKarteC)
	{
		this.bildNaechsteKarteC = bildNaechsteKarteC;
	}

	/**
	 * @return the bildNaechsteKarteO
	 */
	public BufferedImage getBildNaechsteKarteO()
	{
		return bildNaechsteKarteO;
	}

	/**
	 * @param bildNaechsteKarteO
	 *            the bildNaechsteKarteO to set
	 */
	public void setBildNaechsteKarteO(BufferedImage bildNaechsteKarteO)
	{
		this.bildNaechsteKarteO = bildNaechsteKarteO;
	}

	/**
	 * @return the buttonNaechsteKarte
	 */
	public JButton getButtonNaechsteKarte()
	{
		return buttonNaechsteKarte;
	}

	/**
	 * @param buttonNaechsteKarte
	 *            the buttonNaechsteKarte to set
	 */
	public void setButtonNaechsteKarte(JButton buttonNaechsteKarte)
	{
		this.buttonNaechsteKarte = buttonNaechsteKarte;
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
	 * @return the textFeld
	 */
	public JTextField getTextFeld()
	{
		return textFeld;
	}

	/**
	 * @param textFeld
	 *            the textFeld to set
	 */
	public void setTextFeld(JTextField textFeld)
	{
		this.textFeld = textFeld;
	}

}
