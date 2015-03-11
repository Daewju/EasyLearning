package sp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private JMenuItem loeschenEintrag;
	private JMenuItem importEintrag;
	private JMenuItem exportEintrag;
	private JMenuItem resetEintrag;
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
		this.handler = guiMain.getHandler();
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
		loeschenEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Löschen", GuiMain.SPRACHCODE));
		importEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Importieren", GuiMain.SPRACHCODE));
		exportEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Exportieren", GuiMain.SPRACHCODE));
		resetEintrag = new JMenuItem(sprachcontroller.getSprache(
				"Zurücksetzen", GuiMain.SPRACHCODE));
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
		dateiMenue.add(loeschenEintrag);
		dateiMenue.add(importEintrag);
		dateiMenue.add(exportEintrag);
		dateiMenue.add(resetEintrag);
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
				if (guiMain.getGuiDialog().getHauptsprache() != null
						&& guiMain.getGuiDialog().getFremdsprache() != null)
				{
					handler.eventNeueKartei(guiMain.getGuiDialog()
							.getHauptsprache().toUpperCase(), guiMain.getGuiDialog()
							.getFremdsprache().toUpperCase());
					guiMain.getGuiDialog().setHauptsprache(null);
					guiMain.getGuiDialog().setFremdsprache(null);
				}
			}
		});

		oeffnenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				final File karteiPfad = new File(KarteiHandler
						.getStandardPfad() + "/Karteien");
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
				handler.eventDateiOeffnen(chooser.getSelectedFile()
						.getAbsolutePath());
			}
		});

		speichernEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handler.eventDateiSpeichern();
			}
		});
		
		loeschenEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (guiMain.getGuiDialog().variableButtonsDialog(
						new Object[]
						{
								sprachcontroller.getSprache("Ja",
										GuiMain.SPRACHCODE),
								sprachcontroller.getSprache("Nein",
										GuiMain.SPRACHCODE) },
						sprachcontroller.getSprache("Kartei löschen",
								GuiMain.SPRACHCODE),
						sprachcontroller.getSprache("Sind Sie sicher?",
								GuiMain.SPRACHCODE)) == 0)
				{
					handler.eventDateiLoeschen();
				}
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
						handler.eventDateiImportieren(chooser.getSelectedFile()
								.getAbsolutePath(), true);
					} else
					{
						handler.eventDateiImportieren(chooser.getSelectedFile()
								.getAbsolutePath(), false);
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
						handler.eventDateiExportieren(chooser.getSelectedFile()
								.getAbsolutePath() + ".csv", true);
					} else
					{
						handler.eventDateiExportieren(chooser.getSelectedFile()
								.getAbsolutePath() + ".csv", false);
					}
				}
			}
		});
		
		
		resetEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (guiMain.getGuiDialog().variableButtonsDialog(
						new Object[]
						{
								sprachcontroller.getSprache("Ja",
										GuiMain.SPRACHCODE),
								sprachcontroller.getSprache("Nein",
										GuiMain.SPRACHCODE) },
						sprachcontroller.getSprache("Zurücksetzen",
								GuiMain.SPRACHCODE),
						sprachcontroller.getSprache("Sind Sie sicher?",
								GuiMain.SPRACHCODE)) == 0)
				{
					handler.eventZurücksetzen();
				}
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
								GuiMain.SPRACHCODE) + ": " + GuiMain.version);
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

	/**
	 * @return the guiMain
	 */
	public GuiMain getGuiMain()
	{
		return guiMain;
	}

	/**
	 * @param guiMain
	 *            the guiMain to set
	 */
	public void setGuiMain(GuiMain guiMain)
	{
		this.guiMain = guiMain;
	}

	/**
	 * @return the hintergrundColor
	 */
	public Color getHintergrundColor()
	{
		return hintergrundColor;
	}

	/**
	 * @param hintergrundColor
	 *            the hintergrundColor to set
	 */
	public void setHintergrundColor(Color hintergrundColor)
	{
		this.hintergrundColor = hintergrundColor;
	}

	/**
	 * @return the schriftColor
	 */
	public Color getSchriftColor()
	{
		return schriftColor;
	}

	/**
	 * @return the loeschenEintrag
	 */
	public JMenuItem getLoeschenEintrag()
	{
		return loeschenEintrag;
	}

	/**
	 * @param loeschenEintrag the loeschenEintrag to set
	 */
	public void setLoeschenEintrag(JMenuItem loeschenEintrag)
	{
		this.loeschenEintrag = loeschenEintrag;
	}

	/**
	 * @param schriftColor
	 *            the schriftColor to set
	 */
	public void setSchriftColor(Color schriftColor)
	{
		this.schriftColor = schriftColor;
	}

	/**
	 * @return the handler
	 */
	public Handler getHandler()
	{
		return handler;
	}

	/**
	 * @param handler
	 *            the handler to set
	 */
	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	/**
	 * @return the sprachcontroller
	 */
	public SprachController getSprachcontroller()
	{
		return sprachcontroller;
	}

	/**
	 * @param sprachcontroller
	 *            the sprachcontroller to set
	 */
	public void setSprachcontroller(SprachController sprachcontroller)
	{
		this.sprachcontroller = sprachcontroller;
	}

	/**
	 * @return the menuezeile
	 */
	public JMenuBar getMenuezeile()
	{
		return menuezeile;
	}

	/**
	 * @param menuezeile
	 *            the menuezeile to set
	 */
	public void setMenuezeile(JMenuBar menuezeile)
	{
		this.menuezeile = menuezeile;
	}

	/**
	 * @return the dateiMenue
	 */
	public JMenu getDateiMenue()
	{
		return dateiMenue;
	}

	/**
	 * @param dateiMenue
	 *            the dateiMenue to set
	 */
	public void setDateiMenue(JMenu dateiMenue)
	{
		this.dateiMenue = dateiMenue;
	}

	/**
	 * @return the spracheMenue
	 */
	public JMenu getSpracheMenue()
	{
		return spracheMenue;
	}

	/**
	 * @param spracheMenue
	 *            the spracheMenue to set
	 */
	public void setSpracheMenue(JMenu spracheMenue)
	{
		this.spracheMenue = spracheMenue;
	}

	/**
	 * @return the infoMenue
	 */
	public JMenu getInfoMenue()
	{
		return infoMenue;
	}

	/**
	 * @param infoMenue
	 *            the infoMenue to set
	 */
	public void setInfoMenue(JMenu infoMenue)
	{
		this.infoMenue = infoMenue;
	}

	/**
	 * @return the neueKarteiEintrag
	 */
	public JMenuItem getNeueKarteiEintrag()
	{
		return neueKarteiEintrag;
	}

	/**
	 * @param neueKarteiEintrag
	 *            the neueKarteiEintrag to set
	 */
	public void setNeueKarteiEintrag(JMenuItem neueKarteiEintrag)
	{
		this.neueKarteiEintrag = neueKarteiEintrag;
	}

	/**
	 * @return the oeffnenEintrag
	 */
	public JMenuItem getOeffnenEintrag()
	{
		return oeffnenEintrag;
	}

	/**
	 * @param oeffnenEintrag
	 *            the oeffnenEintrag to set
	 */
	public void setOeffnenEintrag(JMenuItem oeffnenEintrag)
	{
		this.oeffnenEintrag = oeffnenEintrag;
	}

	/**
	 * @return the speichernEintrag
	 */
	public JMenuItem getSpeichernEintrag()
	{
		return speichernEintrag;
	}

	/**
	 * @param speichernEintrag
	 *            the speichernEintrag to set
	 */
	public void setSpeichernEintrag(JMenuItem speichernEintrag)
	{
		this.speichernEintrag = speichernEintrag;
	}

	/**
	 * @return the importEintrag
	 */
	public JMenuItem getImportEintrag()
	{
		return importEintrag;
	}

	/**
	 * @param importEintrag
	 *            the importEintrag to set
	 */
	public void setImportEintrag(JMenuItem importEintrag)
	{
		this.importEintrag = importEintrag;
	}

	/**
	 * @return the exportEintrag
	 */
	public JMenuItem getExportEintrag()
	{
		return exportEintrag;
	}

	/**
	 * @param exportEintrag
	 *            the exportEintrag to set
	 */
	public void setExportEintrag(JMenuItem exportEintrag)
	{
		this.exportEintrag = exportEintrag;
	}

	/**
	 * @return the beendenEintrag
	 */
	public JMenuItem getBeendenEintrag()
	{
		return beendenEintrag;
	}

	/**
	 * @param beendenEintrag
	 *            the beendenEintrag to set
	 */
	public void setBeendenEintrag(JMenuItem beendenEintrag)
	{
		this.beendenEintrag = beendenEintrag;
	}

	/**
	 * @return the deutschEintrag
	 */
	public JMenuItem getDeutschEintrag()
	{
		return deutschEintrag;
	}

	/**
	 * @param deutschEintrag
	 *            the deutschEintrag to set
	 */
	public void setDeutschEintrag(JMenuItem deutschEintrag)
	{
		this.deutschEintrag = deutschEintrag;
	}

	/**
	 * @return the englischEintrag
	 */
	public JMenuItem getEnglischEintrag()
	{
		return englischEintrag;
	}

	/**
	 * @param englischEintrag
	 *            the englischEintrag to set
	 */
	public void setEnglischEintrag(JMenuItem englischEintrag)
	{
		this.englischEintrag = englischEintrag;
	}

	/**
	 * @return the franzoesischEintrag
	 */
	public JMenuItem getFranzoesischEintrag()
	{
		return franzoesischEintrag;
	}

	/**
	 * @param franzoesischEintrag
	 *            the franzoesischEintrag to set
	 */
	public void setFranzoesischEintrag(JMenuItem franzoesischEintrag)
	{
		this.franzoesischEintrag = franzoesischEintrag;
	}

	/**
	 * @return the italienischEintrag
	 */
	public JMenuItem getItalienischEintrag()
	{
		return italienischEintrag;
	}

	/**
	 * @param italienischEintrag
	 *            the italienischEintrag to set
	 */
	public void setItalienischEintrag(JMenuItem italienischEintrag)
	{
		this.italienischEintrag = italienischEintrag;
	}

	/**
	 * @return the versionEintrag
	 */
	public JMenuItem getVersionEintrag()
	{
		return versionEintrag;
	}

	/**
	 * @param versionEintrag
	 *            the versionEintrag to set
	 */
	public void setVersionEintrag(JMenuItem versionEintrag)
	{
		this.versionEintrag = versionEintrag;
	}

	/**
	 * @return the ueberEintrag
	 */
	public JMenuItem getUeberEintrag()
	{
		return ueberEintrag;
	}

	/**
	 * @param ueberEintrag
	 *            the ueberEintrag to set
	 */
	public void setUeberEintrag(JMenuItem ueberEintrag)
	{
		this.ueberEintrag = ueberEintrag;
	}

}