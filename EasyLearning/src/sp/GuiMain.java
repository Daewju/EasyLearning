package sp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dd.SprachController;

public class GuiMain extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Dimension dimension;
	private SprachController sprachcontroller;
	private GuiMenuebar guiMenuebar;
	private GuiDialog guiDialog;
	private int sprachcode = 0;
	protected static final String version = "0.1";
	
	public GuiMain()
	{
		dimension = new Dimension();
		dimension.setSize(1024, 768);
		try
		{
			sprachcontroller = new SprachController();
		} catch (IOException e)
		{
			guiDialog.fehlerDialog("Error!", "Critital-Error with Language-File!");
			e.printStackTrace();
		}
		guiMenuebar = new GuiMenuebar(this);
		guiDialog = new GuiDialog(this);
		setLayout(new BorderLayout(20,20));
		getContentPane().setBackground(new Color(40, 40, 40));
		setSize(dimension.width, dimension.height);
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		setResizable(false);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		neuZeichnen();
	}

	public void neuZeichnen()
	{
		guiMenuebar.init();
		repaint();
		setVisible(true);
	}
	

	/**
	 * @return the sprachcode
	 */
	public int getSprachcode()
	{
		return sprachcode;
	}


	/**
	 * @param sprachcode the sprachcode to set
	 */
	public void setSprachcode(int sprachcode)
	{
		this.sprachcode = sprachcode;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}


	/**
	 * @return the dimension
	 */
	public Dimension getDimension()
	{
		return dimension;
	}


	/**
	 * @return the sc
	 */
	public SprachController getSprachcontroller()
	{
		return sprachcontroller;
	}


	/**
	 * @return the guiDialog
	 */
	public GuiDialog getGuiDialog()
	{
		return guiDialog;
	}
	
}

