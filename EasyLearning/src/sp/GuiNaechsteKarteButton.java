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

public class GuiNaechsteKarteButton
{
	private GuiMain guiMain;
	private SprachController sc;
	private Handler handler;
	private JPanel hauptpanel;
	private BufferedImage bildNaechsteKarte;
	private BufferedImage bildNaechsteKarteC;
	private BufferedImage bildNaechsteKarteO;
	private JButton buttonNaechsterButton;

	public GuiNaechsteKarteButton(GuiMain gui) throws IOException
	{
		guiMain = gui;
		this.sc = guiMain.getSprachcontroller();
		this.handler = new Handler(guiMain);
		hauptpanel = new JPanel(new GridBagLayout());
		hauptpanel.setBackground(GuiMain.BACKGROUNDCOLOR);
		bildNaechsteKarte = ImageIO.read(getClass().getResource(
				"/data/button_next.png"));
		bildNaechsteKarteC = ImageIO.read(getClass().getResource(
				"/data/button_next_clicked.png"));
		bildNaechsteKarteO = ImageIO.read(getClass().getResource(
				"/data/button_next_over.png"));
		
		buttonNaechsterButton = new JButton(new ImageIcon(bildNaechsteKarte));
		buttonNaechsterButton.setBorder(BorderFactory.createEmptyBorder());
		buttonNaechsterButton.setContentAreaFilled(false);
		hauptpanel.add(buttonNaechsterButton);

		buttonNaechsterButton.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				buttonNaechsterButton.setIcon(new ImageIcon(bildNaechsteKarteO));
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				buttonNaechsterButton.setIcon(new ImageIcon(bildNaechsteKarteO));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				buttonNaechsterButton.setIcon(new ImageIcon(bildNaechsteKarte));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				buttonNaechsterButton.setIcon(new ImageIcon(bildNaechsteKarteC));
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				buttonNaechsterButton.setIcon(new ImageIcon(bildNaechsteKarte));
				//todo
				// handler.empfangeEvent(e);
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
	 * @param guiMain the guiMain to set
	 */
	public void setGuiMain(GuiMain guiMain)
	{
		this.guiMain = guiMain;
	}

	/**
	 * @return the sc
	 */
	public SprachController getSc()
	{
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(SprachController sc)
	{
		this.sc = sc;
	}

	/**
	 * @return the handler
	 */
	public Handler getHandler()
	{
		return handler;
	}

	/**
	 * @param handler the handler to set
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
	 * @param hauptpanel the hauptpanel to set
	 */
	public void setHauptpanel(JPanel hauptpanel)
	{
		this.hauptpanel = hauptpanel;
	}

	/**
	 * @return the bildNaechsteKarte
	 */
	public BufferedImage getBildNaechsteKarte()
	{
		return bildNaechsteKarte;
	}

	/**
	 * @param bildNaechsteKarte the bildNaechsteKarte to set
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
	 * @param bildNaechsteKarteC the bildNaechsteKarteC to set
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
	 * @param bildNaechsteKarteO the bildNaechsteKarteO to set
	 */
	public void setBildNaechsteKarteO(BufferedImage bildNaechsteKarteO)
	{
		this.bildNaechsteKarteO = bildNaechsteKarteO;
	}

	/**
	 * @return the buttonNaechsterButton
	 */
	public JButton getButtonNaechsterButton()
	{
		return buttonNaechsterButton;
	}

	/**
	 * @param buttonNaechsterButton the buttonNaechsterButton to set
	 */
	public void setButtonNaechsterButton(JButton buttonNaechsterButton)
	{
		this.buttonNaechsterButton = buttonNaechsterButton;
	}
	
	

}
