package sp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import mk.Handler;
import dd.SprachController;

public class GuiMain extends JFrame
{
	private static final long serialVersionUID = 1L;
	protected static final int WINDOWWITDH = 1024;
	protected static final int WINDOWHEIGHT = 768;
	private Handler handler;
	private Dimension dimension;
	private SprachController sprachcontroller;
	private GuiMenuebar guiMenuebar;
	private GuiKarteiTitel guiKarteiTitel;
	private GuiDialog guiDialog;
	protected final static Color BACKGROUNDCOLOR = new Color(40, 40, 40);;
	private int sprachcode = 0;
	protected static final String version = "0.1";
	
	public GuiMain()
	{
		handler = new Handler(this);
		setSize(WINDOWWITDH, WINDOWHEIGHT);
		try
		{
			sprachcontroller = new SprachController();
		} catch (IOException e)
		{
			guiDialog.fehlerDialog("Error!", "Critital-Error with Language-File!");
			e.printStackTrace();
		}
		guiMenuebar = new GuiMenuebar(this);
		guiKarteiTitel = new GuiKarteiTitel();
		guiDialog = new GuiDialog(this);
		setLayout(new BorderLayout());
		getContentPane().setBackground(BACKGROUNDCOLOR);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		setSize(WINDOWWITDH, WINDOWHEIGHT);
		setResizable(false);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			GuiKarteButtons gkb = new GuiKarteButtons(this);
			this.add(gkb.getPanel(), BorderLayout.WEST);
			GuiNaechsteKarteButton gnkb = new GuiNaechsteKarteButton(this);
			this.add(gnkb.getHauptpanel(), BorderLayout.EAST);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}

	public void init()
	{
		guiMenuebar.init();
		this.add(guiKarteiTitel.getPanel(),BorderLayout.NORTH);
		repaint();
		setVisible(true);
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
	 * @return the dimension
	 */
	public Dimension getDimension()
	{
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}

	/**
	 * @return the sprachcontroller
	 */
	public SprachController getSprachcontroller()
	{
		return sprachcontroller;
	}

	/**
	 * @param sprachcontroller the sprachcontroller to set
	 */
	public void setSprachcontroller(SprachController sprachcontroller)
	{
		this.sprachcontroller = sprachcontroller;
	}

	/**
	 * @return the guiMenuebar
	 */
	public GuiMenuebar getGuiMenuebar()
	{
		return guiMenuebar;
	}

	/**
	 * @param guiMenuebar the guiMenuebar to set
	 */
	public void setGuiMenuebar(GuiMenuebar guiMenuebar)
	{
		this.guiMenuebar = guiMenuebar;
	}

	/**
	 * @return the guiDialog
	 */
	public GuiDialog getGuiDialog()
	{
		return guiDialog;
	}

	/**
	 * @param guiDialog the guiDialog to set
	 */
	public void setGuiDialog(GuiDialog guiDialog)
	{
		this.guiDialog = guiDialog;
	}

	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor()
	{
		return BACKGROUNDCOLOR;
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
	 * @return the windowwidth
	 */
	public static int getWindowwidth()
	{
		return WINDOWWITDH;
	}

	/**
	 * @return the windowheight
	 */
	public static int getWindowheight()
	{
		return WINDOWHEIGHT;
	}

	/**
	 * @return the version
	 */
	public static String getVersion()
	{
		return version;
	}
	
	


	
}


