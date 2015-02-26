package sp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

import mk.Handler;
import dd.KarteiHandler;
import dd.SprachController;

public class GuiMenuebar
{
	private GuiMain guiMain;
	private Color hintergrundColor;
	private Color schriftColor;
	private Handler handler;
	private SprachController sprachcontroller;

	// Folgende Datenfelder werden nich mehr exisitieren, sobald die Klasse
	// Handler mit erweiterten Methoden implementiert wird.
	private String dateiPfadImport;
	private String dateiPfadExport;
	private String hauptsprache;
	private String fremdsprache;
	private boolean fortschrittUebernehmen;

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
		hintergrundColor = new Color(83, 83, 83);
		schriftColor = new Color(240, 240, 240);
		this.handler = new Handler(guiMain);
		this.sprachcontroller = guiMain.getSprachcontroller();
		menuezeile = new JMenuBar();
		menuezeile.setBackground(hintergrundColor);
		dateiMenue = new JMenu(sprachcontroller.getSprache("Datei",
				guiMain.getSprachcode()));
		dateiMenue.setForeground(schriftColor);
		spracheMenue = new JMenu(sprachcontroller.getSprache("Sprache",
				guiMain.getSprachcode()));
		spracheMenue.setForeground(schriftColor);
		infoMenue = new JMenu(sprachcontroller.getSprache("Info",
				guiMain.getSprachcode()));
		infoMenue.setForeground(schriftColor);
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
		guiMain.repaint();
		guiMain.setVisible(true);
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
				boolean ergebnis = false;
					while (!ergebnis)
					{
						ergebnis = guiMain.getGuiDialog().erzeugeNeuEingabeDialog(
								sprachcontroller.getSprache(
										"Geben Sie die Sprachen ein",
										guiMain.getSprachcode()),
								sprachcontroller.getSprache("Hauptsprache",
										guiMain.getSprachcode()) + ": ",
								sprachcontroller.getSprache("Fremdsprache",
										guiMain.getSprachcode()) + ": ");
					}
					handler.empfangeEvent(e);
				}
		});
		

		oeffnenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final File karteiPfad = new File(KarteiHandler
						.getStandardPfad() + "\\Karteien");
				JFileChooser chooser = new JFileChooser(karteiPfad);
				// fixiert den Ordner auf den Standard-Ordner
				chooser.setFileView(new FileView()
				{
					@Override
					public Boolean isTraversable(File f)
					{
						return karteiPfad.equals(f);
					}
				});
				chooser.setDialogTitle(sprachcontroller.getSprache("Öffnen",
						guiMain.getSprachcode()));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showOpenDialog(guiMain);
				dateiPfadImport = chooser.getSelectedFile().getAbsolutePath();
				handler.empfangeEvent(e);
			}
		});

		speichernEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handler.empfangeEvent(e);
			}
		});

		importEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle(sprachcontroller.getSprache(
						"Importieren", guiMain.getSprachcode()));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showOpenDialog(guiMain);
				if (chooser.getSelectedFile().getAbsolutePath() != null)
				{
					dateiPfadImport = chooser.getSelectedFile()
							.getAbsolutePath();
					int fortschritt = guiMain
							.getGuiDialog()
							.variableButtonsDialog(
									new Object[]
									{
											sprachcontroller.getSprache("Ja",
													guiMain.getSprachcode()),
											sprachcontroller.getSprache("Nein",
													guiMain.getSprachcode()) },
									sprachcontroller.getSprache("Importieren",
											guiMain.getSprachcode()),
									sprachcontroller
											.getSprache(
													"Möchten Sie den Lernfortschritt übernehmen?",
													guiMain.getSprachcode()));
					if (fortschritt == 0)
					{
						fortschrittUebernehmen = true;
					} else
					{
						fortschrittUebernehmen = false;
					}
				}
				handler.empfangeEvent(e);
			}
		});

		exportEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle(sprachcontroller.getSprache(
						"Exportieren", guiMain.getSprachcode()));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showSaveDialog(guiMain);
				if (chooser.getSelectedFile().getAbsolutePath() != null)
				{
					dateiPfadExport = chooser.getSelectedFile()
							.getAbsolutePath();
					int fortschritt = guiMain
							.getGuiDialog()
							.variableButtonsDialog(
									new Object[]
									{
											sprachcontroller.getSprache("Ja",
													guiMain.getSprachcode()),
											sprachcontroller.getSprache("Nein",
													guiMain.getSprachcode()) },
									sprachcontroller.getSprache("Exportieren",
											guiMain.getSprachcode()),
									sprachcontroller
											.getSprache(
													"Möchten Sie den Lernfortschritt übernehmen?",
													guiMain.getSprachcode()));
					if (fortschritt == 0)
					{
						fortschrittUebernehmen = true;
					} else
					{
						fortschrittUebernehmen = false;
					}
				}
				handler.empfangeEvent(e);
			}
		});

		beendenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handler.empfangeEvent(e);
			}
		});

		deutschEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(0);
				init();
			}
		});

		englischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(1);
				init();
			}
		});

		franzoesischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(2);
				init();
			}
		});

		italienischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSprachcode(3);
				init();
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