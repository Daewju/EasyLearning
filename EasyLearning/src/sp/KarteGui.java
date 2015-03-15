package sp;

import java.awt.Canvas;
import java.awt.Color;

/**
 * Diese Klasse beschreibt eine visuelle Karteikarte. Sie hat eine Grundfarbe
 * und eine Farbe für die korrekte, sowie eine Farbe für die falsche Antwort.
 * Eine Methode 'umdrehen' dreht die Karte um, erwartet wird ein boolean. Der
 * Text wird hier nicht angezeigt. es handelt sich um die blanke Karte.
 * 
 * @author Damjan Djuranovic
 * @version 1.3
 */
public class KarteGui extends Canvas
{
	private static final long serialVersionUID = 1L;
	private int sizeX;
	private int sizeY;
	private int posX;
	private int posY;
	private Color color;

	/**
	 * Konstruktor
	 * 
	 * @param color
	 *            Farbe der Karte
	 */
	public KarteGui(Color color)
	{
		super();
		this.sizeX = 500;
		this.sizeY = 350;
		this.posX = 155;
		this.posY = 150;
		this.color = color;
		setLocation(this.posX, this.posY);
		setSize(sizeX, sizeY);
		setBackground(color);
	}

	/**
	 * @param sizeX
	 *            Groesse in Pixel für Horizontale
	 * @param sizeY
	 *            Groesse in Pixel für Vertikale
	 * @param posX
	 *            Position X linke-obere Ecke
	 * @param posY
	 *            Position Y linke-obere Ecke
	 * @param color
	 *            Farbe der Karte
	 */
	public KarteGui(int sizeX, int sizeY, int posX, int posY, Color color)
	{
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.posX = posX;
		this.posY = posY;
		setLocation(this.posX, this.posY);
		setSize(sizeX, sizeY);
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
		setBackground(color);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "KarteGui [sizeX=" + sizeX + ", sizeY=" + sizeY + ", posX="
				+ posX + ", posY=" + posY + "]";
	}

}
