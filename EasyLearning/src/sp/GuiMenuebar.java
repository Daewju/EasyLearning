package sp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dd.SprachController;

public class GuiMenuebar
{
	private GuiMain guiMain;
	private SprachController sprachcontroller;
	private JMenuBar menuezeile;
	private JMenu dateiMenue;
	private JMenu spracheMenue;
	private JMenu infoMenue;
	private JMenuItem neueKarteiEintrag;
	private JMenuItem oeffnenEintrag;
	private JMenuItem speichernEintrag;
	private JMenuItem importEintrag;
	private JMenuItem exportEintrag;
	private JMenuItem beendenEintrag;
	private JMenuItem deutschEintrag;
	private JMenuItem englischEintrag;
	private JMenuItem franzoesischEintrag;
	private JMenuItem italienischEintrag;
	private JMenuItem versionEintrag;
	private JMenuItem ueberEintrag;

	public GuiMenuebar(GuiMain guiMain)
	{
		this.guiMain = guiMain;
		init();
	}
	
	public void init()
	{
		this.sprachcontroller = guiMain.getSprachcontroller();
		menuezeile = new JMenuBar();
		dateiMenue = new JMenu(sprachcontroller.getSprache("Datei",
				guiMain.getSprachcode()));
		spracheMenue = new JMenu(sprachcontroller.getSprache("Sprache",
				guiMain.getSprachcode()));
		infoMenue = new JMenu(sprachcontroller.getSprache("Info",
				guiMain.getSprachcode()));
		neueKarteiEintrag = new JMenuItem(sprachcontroller.getSprache("Neu",
				guiMain.getSprachcode()));
		oeffnenEintrag = new JMenuItem(sprachcontroller.getSprache("Öffnen",
				guiMain.getSprachcode()));
		speichernEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Speichern", guiMain.getSprachcode()));
		importEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Importieren", guiMain.getSprachcode()));
		exportEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Exportieren", guiMain.getSprachcode()));
		beendenEintrag = new JMenuItem(sprachcontroller.getSprache("Beenden",
				guiMain.getSprachcode()));
		deutschEintrag = new JMenuItem(sprachcontroller.getSprache("Deutsch",
				guiMain.getSprachcode()));
		englischEintrag = new JMenuItem(sprachcontroller.getSprache("Englisch",
				guiMain.getSprachcode()));
		franzoesischEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Französisch", guiMain.getSprachcode()));
		italienischEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Italienisch", guiMain.getSprachcode()));
		versionEintrag = new JMenuItem(sprachcontroller.getSprache("Version",
				guiMain.getSprachcode()));
		ueberEintrag = new JMenuItem(sprachcontroller.getSprache("Über …",
				guiMain.getSprachcode()));
		aufbauen();
		erzeugeActionListener();
	}

	private void aufbauen()
	{
		guiMain.setJMenuBar(menuezeile);
		menuezeile.add(dateiMenue);
		menuezeile.add(spracheMenue);
		menuezeile.add(infoMenue);
		dateiMenue.add(neueKarteiEintrag);
		dateiMenue.add(oeffnenEintrag);
		dateiMenue.add(speichernEintrag);
		dateiMenue.add(importEintrag);
		dateiMenue.add(exportEintrag);
		dateiMenue.add(beendenEintrag);
		spracheMenue.add(deutschEintrag);
		spracheMenue.add(englischEintrag);
		spracheMenue.add(franzoesischEintrag);
		spracheMenue.add(italienischEintrag);
		infoMenue.add(versionEintrag);
		infoMenue.add(ueberEintrag);
	}

	private void erzeugeActionListener()
	{
		neueKarteiEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		oeffnenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		speichernEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		importEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		exportEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		beendenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		deutschEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(0);
			}
		});

		englischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(1);
			}
		});

		franzoesischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(2);
			}
		});

		italienischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(3);
			}
		});

		versionEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.getGuiDialog().infoDialog(
						sprachcontroller.getSprache("Version",
								guiMain.getSprachcode()),
						sprachcontroller.getSprache("Version",
								guiMain.getSprachcode())
								+ ": " + GuiMain.version);
			}
		});

		ueberEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.getGuiDialog()
						.infoDialog(
								sprachcontroller.getSprache("Über …",
										guiMain.getSprachcode()),
								sprachcontroller.getSprache("Programmierer",
										guiMain.getSprachcode())
										+ ": \n\nMarko Kartelo\nDamjan Djuranovic\nSajeevan Premakumaran");
			}
		});
	}

}