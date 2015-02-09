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

	public Gui()
	{
		setLayout(null); // LayoutManager verwenden
		setVisible(true);
		setSize(800, 600);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuezeileErzeugen(this);
		repaint();
		bestaetigungsDialog(this, "Irgndetwas hat einen Fehler!");
	}

	public void menuezeileErzeugen(JFrame gui)
	{
		JMenuBar menuezeile = new JMenuBar();
		gui.setJMenuBar(menuezeile);

		JMenu dateiMenue = new JMenu("Datei");
		menuezeile.add(dateiMenue);

		JMenuItem neueKarteiEintrag = new JMenuItem("Neu");
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
	
	public void warnungsDialog(Gui gui, String text)
	{
		JOptionPane.showMessageDialog(gui,
			    text,
			    "Warnung",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void fehlerDialog(Gui gui, String text)
	{
		JOptionPane.showMessageDialog(gui,
			    text,
			    "Fehler",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void bestaetigungsDialog(Gui gui, String text)
	{
		JOptionPane.showInternalConfirmDialog(gui,
			    text,
			    "Fehler",
			    JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args)
	{
		JFrame gui = new Gui();

	}
}
