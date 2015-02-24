package sp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FachGui extends KarteGui
{
	private static final long serialVersionUID = 1L;
	private boolean aktiv;

	public FachGui(int sizeX, int sizeY, int posX, int posY)
	{
		super(sizeX, sizeY, posX, posY);
		addMouseListener(new MyMouseListener());
		aktiv = false;
	}

	public int getNaechstePosX()
	{
		return getPosX() + 90;
	}
	
	

	/**
	 * @return the aktiv
	 */
	public boolean isAktiv()
	{
		return aktiv;
	}

	/**
	 * @param aktiv the aktiv to set
	 */
	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}



	class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			FachGui k = (FachGui) e.getSource();
			if (!aktiv)
			{
				k.setBackground(getColorCorrect());
				aktiv = true;
			} else
			{
				k.zuruecksetzten();
				aktiv = false;
			}
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
