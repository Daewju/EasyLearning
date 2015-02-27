package sp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Diese Klasse beschreibt eine visuelle Karteikarte. Sie hat eine Grundfarbe
 * und eine Farbe für die korrekte, sowie eine Farbe für die falsche Antwort.
 * Eine Methode 'umdrehen' dreht die Karte um, erwartet wird ein boolean. Der
 * Text wird hier nicht angezeigt. es handelt sich um die blanke Karte.
 * 
 * @author Damjan Djuranovic
 *
 */
public class KarteGui extends Canvas
{
	private static final long serialVersionUID = 1L;
	private int sizeX;
	private int sizeY;
	private int posX;
	private int posY;
	private Color color;
	private Color colorCorrect;
	private Color colorIncorrect;

	/**
	 * Konstruktor
	 * 
	 */
	public KarteGui()
	{
		super();
		this.sizeX = 500;
		this.sizeY = 350;
		this.posX = 155;
		this.posY = 150;
		this.color = Color.CYAN;
		this.colorCorrect = new Color(0, 255, 0);
		this.colorIncorrect = new Color(255, 0, 0);
		setLocation(this.posX, this.posY);
		setSize(sizeX, sizeY);
		setBackground(color);
		addMouseListener(new MyMouseListener());
	}
	
	/**
	 * @param sizeX Groesse in Pixel für Horizontale
	 * @param sizeY Groesse in Pixel für Vertikale
	 * @param posX Position X linke-obere Ecke
	 * @param posY Position Y linke-obere Ecke
	 */
	public KarteGui(int sizeX, int sizeY, int posX, int posY)
	{
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.posX = posX;
		this.posY = posY;
		this.color = Color.DARK_GRAY;
		this.colorCorrect = new Color(0, 255, 0);
		this.colorIncorrect = new Color(255, 0, 0);
		setLocation(this.posX, this.posY);
		setSize(sizeX, sizeY);
		setBackground(color);
		addMouseListener(new MyMouseListener());
	}
	
	/**
	 * @param korrekteAntwort
	 *            "True": richtige Antwort, die Karte wird grün. "False":
	 *            falsche Antwort, die Karte wird rot.
	 */
	public void umdrehen(boolean korrekteAntwort)
	{
		if (korrekteAntwort)
		{
			this.color = colorCorrect;
		} else
		{
			this.color = colorIncorrect;
		}
		setBackground(color);
	}
	
	/**
	 * Setzt die Karte wieder auf ihre Standard-Farbe zurück.
	 */
	public void zuruecksetzten()
	{
		this.color = Color.DARK_GRAY;
		setBackground(color);
	}

	/**
	 * @return the sizeX
	 */
	public int getSizeX()
	{
		return sizeX;
	}

	/**
	 * @param sizeX
	 *            the sizeX to set
	 */
	public void setSizeX(int sizeX)
	{
		this.sizeX = sizeX;
	}

	/**
	 * @return the sizeY
	 */
	public int getSizeY()
	{
		return sizeY;
	}

	/**
	 * @param sizeY
	 *            the sizeY to set
	 */
	public void setSizeY(int sizeY)
	{
		this.sizeY = sizeY;
	}

	/**
	 * @return the posX
	 */
	public int getPosX()
	{
		return posX;
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY()
	{
		return posY;
	}

	/**
	 * @param posY
	 *            the posY to set
	 */
	public void setPosY(int posY)
	{
		this.posY = posY;
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
		return "KarteGui [sizeX=" + sizeX + ", sizeY=" + sizeY + ", posX="
				+ posX + ", posY=" + posY + ", color=" + color
				+ ", colorCorrect=" + colorCorrect + ", colorIncorrect="
				+ colorIncorrect + "]";
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
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((colorCorrect == null) ? 0 : colorCorrect.hashCode());
		result = prime * result
				+ ((colorIncorrect == null) ? 0 : colorIncorrect.hashCode());
		result = prime * result + posX;
		result = prime * result + posY;
		result = prime * result + sizeX;
		result = prime * result + sizeY;
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
		KarteGui other = (KarteGui) obj;
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
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		if (sizeX != other.sizeX)
			return false;
		if (sizeY != other.sizeY)
			return false;
		return true;
	}

	class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			KarteGui k = (KarteGui) e.getSource();
			k.setBackground(color);
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
