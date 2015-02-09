package sp;

//halloo

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Gui extends JFrame
{
	private int sprachcode = 0; //nur zu Testzwecken!!
	private Sprache sprache;

	public Gui()
	{
		sprache = new Sprache();
		setLayout(null); // LayoutManager verwenden
		setVisible(true);
		setSize(800, 600);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuezeileErzeugen(this, sprachcode);
		repaint();
		
	}

	public void menuezeileErzeugen(JFrame gui, int sprachcode)
	{
		JMenuBar menuezeile = new JMenuBar();
		gui.setJMenuBar(menuezeile);

		JMenu dateiMenue = new JMenu(Sprache.neu[sprachcode]);
		menuezeile.add(dateiMenue);

		JMenuItem neueKarteiEintrag = new JMenuItem(Sprache.neu[sprachcode]);
		neueKarteiEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//toDo
			}
		});
		dateiMenue.add(neueKarteiEintrag);

		JMenuItem oeffnenEintrag = new JMenuItem("Öffnen");
		oeffnenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//toDo
			}
		});
		dateiMenue.add(oeffnenEintrag);

		JMenuItem spracheEintrag = new JMenuItem("Sprache");
		spracheEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//toDo
			}
		});
		dateiMenue.add(spracheEintrag);

		JMenuItem beendenEintrag = new JMenuItem("Beenden");
		beendenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//toDo
			}
		});
		dateiMenue.add(beendenEintrag);
	}
	
	
	
	public void warnungsDialog(Gui gui, String titel, String text)
	{
		JOptionPane.showMessageDialog(gui,
			    text,
			    titel,
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void fehlerDialog(Gui gui, String titel, String text)
	{
		JOptionPane.showMessageDialog(gui,
			    text,
			    titel,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void eingabeDialog(Gui gui, String titel, String text)
	{
		JOptionPane.showInputDialog(gui,
			    text,
			    titel,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	

	
	
	public static void main(String[] args)
	{
		JFrame gui = new Gui();

	}
}
