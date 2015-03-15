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

/**
 * Diese Klasse wird für die Eingabe der Vokabeln benötigt. Es wird auf der
 * guiMain ein JPanel, ein Eingabefeld und ein Button gezeichnet
 * 
 * @author Sajeevan und Damjan
 * @version 1.3
 *
 */
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

	/**
	 * Konstruktor
	 * 
	 * @param gui
	 *            als Parameter wird ein guiMain erwartet
	 */
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

	/**
	 * Diese Methode added den Actionlistener für den Button
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiEingabeFeld [guiMain=" + guiMain + ", sprachcontroller="
				+ sprachcontroller + ", handler=" + handler
				+ ", bildNaechsteKarte=" + bildNaechsteKarte
				+ ", bildNaechsteKarteC=" + bildNaechsteKarteC
				+ ", bildNaechsteKarteO=" + bildNaechsteKarteO
				+ ", buttonNaechsteKarte=" + buttonNaechsteKarte
				+ ", hauptpanel=" + hauptpanel + ", panel=" + panel
				+ ", textFeld=" + textFeld + "]";
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
		result = prime
				* result
				+ ((bildNaechsteKarte == null) ? 0 : bildNaechsteKarte
						.hashCode());
		result = prime
				* result
				+ ((bildNaechsteKarteC == null) ? 0 : bildNaechsteKarteC
						.hashCode());
		result = prime
				* result
				+ ((bildNaechsteKarteO == null) ? 0 : bildNaechsteKarteO
						.hashCode());
		result = prime
				* result
				+ ((buttonNaechsteKarte == null) ? 0 : buttonNaechsteKarte
						.hashCode());
		result = prime * result + ((guiMain == null) ? 0 : guiMain.hashCode());
		result = prime * result + ((handler == null) ? 0 : handler.hashCode());
		result = prime * result
				+ ((hauptpanel == null) ? 0 : hauptpanel.hashCode());
		result = prime * result + ((panel == null) ? 0 : panel.hashCode());
		result = prime
				* result
				+ ((sprachcontroller == null) ? 0 : sprachcontroller.hashCode());
		result = prime * result
				+ ((textFeld == null) ? 0 : textFeld.hashCode());
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
		GuiEingabeFeld other = (GuiEingabeFeld) obj;
		if (bildNaechsteKarte == null)
		{
			if (other.bildNaechsteKarte != null)
				return false;
		} else if (!bildNaechsteKarte.equals(other.bildNaechsteKarte))
			return false;
		if (bildNaechsteKarteC == null)
		{
			if (other.bildNaechsteKarteC != null)
				return false;
		} else if (!bildNaechsteKarteC.equals(other.bildNaechsteKarteC))
			return false;
		if (bildNaechsteKarteO == null)
		{
			if (other.bildNaechsteKarteO != null)
				return false;
		} else if (!bildNaechsteKarteO.equals(other.bildNaechsteKarteO))
			return false;
		if (buttonNaechsteKarte == null)
		{
			if (other.buttonNaechsteKarte != null)
				return false;
		} else if (!buttonNaechsteKarte.equals(other.buttonNaechsteKarte))
			return false;
		if (guiMain == null)
		{
			if (other.guiMain != null)
				return false;
		} else if (!guiMain.equals(other.guiMain))
			return false;
		if (handler == null)
		{
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		if (hauptpanel == null)
		{
			if (other.hauptpanel != null)
				return false;
		} else if (!hauptpanel.equals(other.hauptpanel))
			return false;
		if (panel == null)
		{
			if (other.panel != null)
				return false;
		} else if (!panel.equals(other.panel))
			return false;
		if (sprachcontroller == null)
		{
			if (other.sprachcontroller != null)
				return false;
		} else if (!sprachcontroller.equals(other.sprachcontroller))
			return false;
		if (textFeld == null)
		{
			if (other.textFeld != null)
				return false;
		} else if (!textFeld.equals(other.textFeld))
			return false;
		return true;
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
