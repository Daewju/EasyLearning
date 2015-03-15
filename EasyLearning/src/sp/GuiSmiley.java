
package sp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Diese Klasse erzeugt JPanel mit einem Smiley
 * 
 * @author Sajeevan & Damjan
 * @version 1.11
 *
 */
public class GuiSmiley extends JPanel
{

	private static final long serialVersionUID = 1L;
	private BufferedImage smileyLike;
	private BufferedImage smileyDislike;
	private BufferedImage smiley;
	/**
	 * Konstruktor
	 * 
	 */
	public GuiSmiley()
	{
		setLayout(null);
		setBackground(GuiMain.COLOR_BACKGROUND);
		setPreferredSize(new Dimension(190, 128));
		try
		{
			smileyLike = ImageIO.read(getClass().getResource("/data/like.png"));
			smileyDislike = ImageIO.read(getClass().getResource(
					"/data/dislike.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param richtig true = lächelndes Smiley, false = trauriges Smiley
	 */
	public void setSmiley(boolean richtig)
	{
		if (richtig)
		{
			smiley = smileyLike;
		} else
		{
			smiley = smileyDislike;
		}
	}

	/**
	 * Diese Methode versteckt das Smiley
	 */
	public void versteckeSmiley()
	{

		smiley = null;

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(smiley, 0, 100, null);
	}

}
