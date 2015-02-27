package sp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
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
				GuiMain.SPRACHCODE));
		dateiMenue.setForeground(schriftColor);
		spracheMenue = new JMenu(sprachcontroller.getSprache("Sprache",
				GuiMain.SPRACHCODE));
		spracheMenue.setForeground(schriftColor);
		infoMenue = new JMenu(sprachcontroller.getSprache("Info",
				GuiMain.SPRACHCODE));
		infoMenue.setForeground(schriftColor);
		neueKarteiEintrag = new JMenuItem(sprachcontroller.getSprache("Neu",
				GuiMain.SPRACHCODE));
		oeffnenEintrag = new JMenuItem(sprachcontroller.getSprache("Öffnen",
				GuiMain.SPRACHCODE));
		speichernEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Speichern", GuiMain.SPRACHCODE));
		importEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Importieren", GuiMain.SPRACHCODE));
		exportEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Exportieren", GuiMain.SPRACHCODE));
		beendenEintrag = new JMenuItem(sprachcontroller.getSprache("Beenden",
				GuiMain.SPRACHCODE));
		deutschEintrag = new JMenuItem(sprachcontroller.getSprache("Deutsch",
				GuiMain.SPRACHCODE));
		englischEintrag = new JMenuItem(sprachcontroller.getSprache("Englisch",
				GuiMain.SPRACHCODE));
		franzoesischEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Französisch", GuiMain.SPRACHCODE));
		italienischEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Italienisch", GuiMain.SPRACHCODE));
		versionEintrag = new JMenuItem(sprachcontroller.getSprache("Version",
				GuiMain.SPRACHCODE));
		ueberEintrag = new JMenuItem(sprachcontroller.getSprache("Über …",
				GuiMain.SPRACHCODE));
		aufbauen();
		erzeugeActionListener();
		guiMain.repaint();
		guiMain.setVisible(true);
	}

	private void aufbauen()
	{
		guiMain.setJMenuBar(menuezeile);
		menuezeile.add(dateiMenue);
		menuezeile.setBorder(BorderFactory.createEmptyBorder());
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
										GuiMain.SPRACHCODE),
								sprachcontroller.getSprache("Hauptsprache",
										GuiMain.SPRACHCODE) + ": ",
								sprachcontroller.getSprache("Fremdsprache",
										GuiMain.SPRACHCODE) + ": ");
					}
					handler.eventNeueKartei(guiMain.getGuiDialog().getHauptsprache(), guiMain.getGuiDialog().getFremdsprache());
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
						GuiMain.SPRACHCODE));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showOpenDialog(guiMain);
				handler.eventDateiOeffnen(chooser.getSelectedFile().getAbsolutePath());
			}
		});

		speichernEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handler.eventDateiSpeichern();
			}
		});

		importEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle(sprachcontroller.getSprache(
						"Importieren", GuiMain.SPRACHCODE));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showOpenDialog(guiMain);
				if (chooser.getSelectedFile().getAbsolutePath() != null)
				{

					int fortschritt = guiMain
							.getGuiDialog()
							.variableButtonsDialog(
									new Object[]
									{
											sprachcontroller.getSprache("Ja",
													GuiMain.SPRACHCODE),
											sprachcontroller.getSprache("Nein",
													GuiMain.SPRACHCODE) },
									sprachcontroller.getSprache("Importieren",
											GuiMain.SPRACHCODE),
									sprachcontroller
											.getSprache(
													"Möchten Sie den Lernfortschritt übernehmen?",
													GuiMain.SPRACHCODE));
					if (fortschritt == 0)
					{
						handler.eventDateiImportieren(chooser.getSelectedFile().getAbsolutePath(), true);
					} else
					{
						handler.eventDateiImportieren(chooser.getSelectedFile().getAbsolutePath(), false);
					}
				}
			}
		});

		exportEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle(sprachcontroller.getSprache(
						"Exportieren", GuiMain.SPRACHCODE));
				chooser.setFileFilter(new FileNameExtensionFilter(".csv", "CSV"));
				chooser.setMultiSelectionEnabled(false);
				chooser.showSaveDialog(guiMain);
				if (chooser.getSelectedFile().getAbsolutePath() != null)
				{
							.getAbsolutePath();
					int fortschritt = guiMain
							.getGuiDialog()
							.variableButtonsDialog(
									new Object[]
									{
											sprachcontroller.getSprache("Ja",
													GuiMain.SPRACHCODE),
											sprachcontroller.getSprache("Nein",
													GuiMain.SPRACHCODE) },
									sprachcontroller.getSprache("Exportieren",
											GuiMain.SPRACHCODE),
									sprachcontroller
											.getSprache(
													"Möchten Sie den Lernfortschritt übernehmen?",
													GuiMain.SPRACHCODE));
					if (fortschritt == 0)
					{
						handler.eventDateiExportieren(chooser.getSelectedFile().getAbsolutePath(), true);
					} else
					{
						handler.eventDateiExportieren(chooser.getSelectedFile().getAbsolutePath(), false);
					}
				}
				handler.empfangeEvent(e);
			}
		});

		beendenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handler.eventApplikationBeenden();
			}
		});

		deutschEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSPRACHCODE(0);
				init();
			}
		});

		englischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSPRACHCODE(1);
				init();
			}
		});

		franzoesischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSPRACHCODE(2);
				init();
			}
		});

		italienischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.setSPRACHCODE(3);
				init();
			}
		});

		versionEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guiMain.getGuiDialog().infoDialog(
						sprachcontroller.getSprache("Version",
								GuiMain.SPRACHCODE),
						sprachcontroller.getSprache("Version",
								GuiMain.SPRACHCODE)
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
										GuiMain.SPRACHCODE),
								sprachcontroller.getSprache("Programmierer",
										GuiMain.SPRACHCODE)
										+ ": \n\nMarko Kartelo\nDamjan Djuranovic\nSajeevan Premakumaran");
			}
		});
	}

}