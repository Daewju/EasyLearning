package sp;

//halloo

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dd.SprachController;

public class Gui extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sprachcode = 0;
	private SprachController sc;
	private Dimension dimension;
	private static String version = "0.1";

	public Gui()
	{
		try
		{
			sc = new SprachController();
		} catch (IOException e)
		{
			fehlerDialog("Error!", "Critital-Error of Language-File!");
			e.printStackTrace();
		}
		setLayout(null); // LayoutManager verwenden
		getContentPane().setBackground(new Color(40, 40, 40));
		setSize(1024, 768);
		// Fenster mittig plazieren
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		setResizable(false);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // speichern vor
														// beenden!
		guiNeuInitialisieren();
	}

	public void guiNeuInitialisieren()
	{

		menuezeileErzeugen(this, sprachcode);
		repaint();
		setVisible(true);
	}

	public void menuezeileErzeugen(JFrame gui, int sprachcode)
	{
		JMenuBar menuezeile = new JMenuBar();
		gui.setJMenuBar(menuezeile);

		JMenu dateiMenue = new JMenu(sc.getSprache("Datei", sprachcode));
		menuezeile.add(dateiMenue);

		JMenu spracheMenue = new JMenu(sc.getSprache("Sprache", sprachcode));
		menuezeile.add(spracheMenue);

		JMenu infoMenue = new JMenu(sc.getSprache("Info", sprachcode));
		menuezeile.add(infoMenue);

		JMenuItem neueKarteiEintrag = new JMenuItem(sc.getSprache("Neu",
				sprachcode));
		neueKarteiEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				eingabeDialog(sc.getSprache("Neue Kartei erstellen", getSprachcode()),sc.getSprache("Geben Sie die Hauptsprache ein", getSprachcode()));
			}
		});
		
		dateiMenue.add(neueKarteiEintrag);

		JMenuItem oeffnenEintrag = new JMenuItem(sc.getSprache("Öffnen",
				sprachcode));
		oeffnenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// toDo
			}
		});
		dateiMenue.add(oeffnenEintrag);

		JMenuItem speichernEintrag = new JMenuItem(sc.getSprache("Speichern",
				sprachcode));
		speichernEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// toDo
			}
		});
		dateiMenue.add(speichernEintrag);

		JMenuItem importEintrag = new JMenuItem(sc.getSprache("Importieren",
				sprachcode));
		importEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// toDo
			}
		});
		dateiMenue.add(importEintrag);

		JMenuItem exportEintrag = new JMenuItem(sc.getSprache("Exportieren",
				sprachcode));
		exportEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// toDo
			}
		});
		dateiMenue.add(exportEintrag);

		JMenuItem beendenEintrag = new JMenuItem(sc.getSprache("Beenden",
				sprachcode));
		beendenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// toDo
			}
		});
		dateiMenue.add(beendenEintrag);

		JMenuItem deutschEintrag = new JMenuItem(sc.getSprache("Deutsch",
				sprachcode));
		deutschEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSprachcode(0);
			}
		});
		spracheMenue.add(deutschEintrag);

		JMenuItem englischEintrag = new JMenuItem(sc.getSprache("Englisch",
				sprachcode));
		englischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSprachcode(1);
			}
		});
		spracheMenue.add(englischEintrag);

		JMenuItem franzoesischEintrag = new JMenuItem(sc.getSprache(
				"Französisch", sprachcode));
		franzoesischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSprachcode(2);
			}
		});
		spracheMenue.add(franzoesischEintrag);

		JMenuItem italienischEintrag = new JMenuItem(sc.getSprache(
				"Italienisch", sprachcode));
		italienischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSprachcode(3);
			}
		});
		spracheMenue.add(italienischEintrag);

		JMenuItem versionEintrag = new JMenuItem(sc.getSprache("Version",
				sprachcode));
		versionEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				infoDialog(sc.getSprache("Version", getSprachcode()),
						sc.getSprache("Version", getSprachcode()) + ": "
								+ version);
			}
		});
		infoMenue.add(versionEintrag);

		JMenuItem ueberEintrag = new JMenuItem(sc.getSprache("Über …",
				sprachcode));
		ueberEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				infoDialog(
						sc.getSprache("Über …", getSprachcode()),
						sc.getSprache("Programmierer", getSprachcode())
								+ ": \n\nMarko Kartelo\nDamjan Djuranovic\nSajeevan Premakumaran");
			}
		});
		infoMenue.add(ueberEintrag);
	}

	/**
	 * @return the sprachcode
	 */
	public int getSprachcode()
	{
		return sprachcode;
	}

	/**
	 * @param sprachcode
	 *            the sprachcode to set
	 */
	public void setSprachcode(int sprachcode)
	{
		this.sprachcode = sprachcode;
		guiNeuInitialisieren();
	}

	/**
	 * @return the sc
	 */
	public SprachController getSc()
	{
		return sc;
	}

	/**
	 * @param sc
	 *            the sc to set
	 */
	public void setSc(SprachController sc)
	{
		this.sc = sc;
	}

	public void infoDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(this, text, titel,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void warnungsDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(this, text, titel,
				JOptionPane.WARNING_MESSAGE);
	}

	public void fehlerDialog(String titel, String text)
	{
		JOptionPane.showMessageDialog(this, text, titel,
				JOptionPane.ERROR_MESSAGE);
	}

	public void eingabeDialog(String titel, String text)
	{
		JOptionPane.showInputDialog(this, text, titel,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
