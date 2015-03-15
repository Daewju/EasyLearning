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
 * @author Sajeevan und Damjan
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
	 * @param richtig
	 *            true = lächelndes Smiley, false = trauriges Smiley
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

	/**
	 * @return the smileyLike
	 */
	public BufferedImage getSmileyLike()
	{
		return smileyLike;
	}

	/**
	 * @param smileyLike
	 *            the smileyLike to set
	 */
	public void setSmileyLike(BufferedImage smileyLike)
	{
		this.smileyLike = smileyLike;
	}

	/**
	 * @return the smileyDislike
	 */
	public BufferedImage getSmileyDislike()
	{
		return smileyDislike;
	}

	/**
	 * @param smileyDislike
	 *            the smileyDislike to set
	 */
	public void setSmileyDislike(BufferedImage smileyDislike)
	{
		this.smileyDislike = smileyDislike;
	}

	/**
	 * @return the smiley
	 */
	public BufferedImage getSmiley()
	{
		return smiley;
	}

	/**
	 * @param smiley
	 *            the smiley to set
	 */
	public void setSmiley(BufferedImage smiley)
	{
		this.smiley = smiley;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid()
	{
		return serialVersionUID;
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
		result = prime * result + ((smiley == null) ? 0 : smiley.hashCode());
		result = prime * result
				+ ((smileyDislike == null) ? 0 : smileyDislike.hashCode());
		result = prime * result
				+ ((smileyLike == null) ? 0 : smileyLike.hashCode());
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
		GuiSmiley other = (GuiSmiley) obj;
		if (smiley == null)
		{
			if (other.smiley != null)
				return false;
		} else if (!smiley.equals(other.smiley))
			return false;
		if (smileyDislike == null)
		{
			if (other.smileyDislike != null)
				return false;
		} else if (!smileyDislike.equals(other.smileyDislike))
			return false;
		if (smileyLike == null)
		{
			if (other.smileyLike != null)
				return false;
		} else if (!smileyLike.equals(other.smileyLike))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiSmiley [smileyLike=" + smileyLike + ", smileyDislike="
				+ smileyDislike + ", smiley=" + smiley + "]";
	}

}
