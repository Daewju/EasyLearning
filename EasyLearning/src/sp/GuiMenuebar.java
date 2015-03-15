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

/**
 * Diese Klasse erzeugt die JMenuebar auf der guiMain
 * 
 * @author Sajeevan und Damjan
 * @version 1.1
 *
 */
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

	/**
	 * Konstruktor
	 * 
	 * @param guiMain
	 *            als Paramater wird die guiMain erwartet
	 */
	public GuiMenuebar(GuiMain guiMain)
	{
		this.guiMain = guiMain;
		init();
	}

	/**
	 * Diese Methode initialisiert alle Datenfelder
	 */
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
		loeschenEintrag = new JMenuItem(sprachcontroller.getSprache("Löschen",
				GuiMain.SPRACHCODE));
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
		if (handler.getUsedKartei() != null)
		{
			handler.eventSpracheUmgestellt();
		}
		guiMain.setVisible(true);
	}

	/**
	 * Diese Methode added alle JMenuItems in die JMenu, die wiederum in die
	 * JMenuBar geadded werden
	 */
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

	/**
	 * Diese Methode erzeugt alle ActionListener für die JMenuItems
	 */
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
							.getHauptsprache().toUpperCase(), guiMain
							.getGuiDialog().getFremdsprache().toUpperCase());
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
					handler.eventZuruecksetzen();
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
				GuiMain.setSPRACHCODE(0);
				init();
				guiMain.getguiSmileyStatistik().getGuiStatistik()
						.anzeigeAktualisieren();
				;

			}
		});

		englischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GuiMain.setSPRACHCODE(1);
				init();
				guiMain.getguiSmileyStatistik().getGuiStatistik()
						.anzeigeAktualisieren();
				;

			}
		});

		franzoesischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GuiMain.setSPRACHCODE(2);
				init();
				guiMain.getguiSmileyStatistik().getGuiStatistik()
						.anzeigeAktualisieren();
				;

			}
		});

		italienischEintrag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GuiMain.setSPRACHCODE(3);
				init();
				guiMain.getguiSmileyStatistik().getGuiStatistik()
						.anzeigeAktualisieren();
				;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beendenEintrag == null) ? 0 : beendenEintrag.hashCode());
		result = prime * result
				+ ((dateiMenue == null) ? 0 : dateiMenue.hashCode());
		result = prime * result
				+ ((deutschEintrag == null) ? 0 : deutschEintrag.hashCode());
		result = prime * result
				+ ((englischEintrag == null) ? 0 : englischEintrag.hashCode());
		result = prime * result
				+ ((exportEintrag == null) ? 0 : exportEintrag.hashCode());
		result = prime
				* result
				+ ((franzoesischEintrag == null) ? 0 : franzoesischEintrag
						.hashCode());
		result = prime * result + ((guiMain == null) ? 0 : guiMain.hashCode());
		result = prime * result + ((handler == null) ? 0 : handler.hashCode());
		result = prime
				* result
				+ ((hintergrundColor == null) ? 0 : hintergrundColor.hashCode());
		result = prime * result
				+ ((importEintrag == null) ? 0 : importEintrag.hashCode());
		result = prime * result
				+ ((infoMenue == null) ? 0 : infoMenue.hashCode());
		result = prime
				* result
				+ ((italienischEintrag == null) ? 0 : italienischEintrag
						.hashCode());
		result = prime * result
				+ ((loeschenEintrag == null) ? 0 : loeschenEintrag.hashCode());
		result = prime * result
				+ ((menuezeile == null) ? 0 : menuezeile.hashCode());
		result = prime
				* result
				+ ((neueKarteiEintrag == null) ? 0 : neueKarteiEintrag
						.hashCode());
		result = prime * result
				+ ((oeffnenEintrag == null) ? 0 : oeffnenEintrag.hashCode());
		result = prime * result
				+ ((resetEintrag == null) ? 0 : resetEintrag.hashCode());
		result = prime * result
				+ ((schriftColor == null) ? 0 : schriftColor.hashCode());
		result = prime
				* result
				+ ((speichernEintrag == null) ? 0 : speichernEintrag.hashCode());
		result = prime
				* result
				+ ((sprachcontroller == null) ? 0 : sprachcontroller.hashCode());
		result = prime * result
				+ ((spracheMenue == null) ? 0 : spracheMenue.hashCode());
		result = prime * result
				+ ((ueberEintrag == null) ? 0 : ueberEintrag.hashCode());
		result = prime * result
				+ ((versionEintrag == null) ? 0 : versionEintrag.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiMenuebar other = (GuiMenuebar) obj;
		if (beendenEintrag == null)
		{
			if (other.beendenEintrag != null)
				return false;
		} else if (!beendenEintrag.equals(other.beendenEintrag))
			return false;
		if (dateiMenue == null)
		{
			if (other.dateiMenue != null)
				return false;
		} else if (!dateiMenue.equals(other.dateiMenue))
			return false;
		if (deutschEintrag == null)
		{
			if (other.deutschEintrag != null)
				return false;
		} else if (!deutschEintrag.equals(other.deutschEintrag))
			return false;
		if (englischEintrag == null)
		{
			if (other.englischEintrag != null)
				return false;
		} else if (!englischEintrag.equals(other.englischEintrag))
			return false;
		if (exportEintrag == null)
		{
			if (other.exportEintrag != null)
				return false;
		} else if (!exportEintrag.equals(other.exportEintrag))
			return false;
		if (franzoesischEintrag == null)
		{
			if (other.franzoesischEintrag != null)
				return false;
		} else if (!franzoesischEintrag.equals(other.franzoesischEintrag))
			return false;
		if (guiMain == null)
		{
			if (other.guiMain != null)
				return false;
		} else if (!guiMain.equals(other.guiMain))
			return false;
		if (handler == null)
		{
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		if (hintergrundColor == null)
		{
			if (other.hintergrundColor != null)
				return false;
		} else if (!hintergrundColor.equals(other.hintergrundColor))
			return false;
		if (importEintrag == null)
		{
			if (other.importEintrag != null)
				return false;
		} else if (!importEintrag.equals(other.importEintrag))
			return false;
		if (infoMenue == null)
		{
			if (other.infoMenue != null)
				return false;
		} else if (!infoMenue.equals(other.infoMenue))
			return false;
		if (italienischEintrag == null)
		{
			if (other.italienischEintrag != null)
				return false;
		} else if (!italienischEintrag.equals(other.italienischEintrag))
			return false;
		if (loeschenEintrag == null)
		{
			if (other.loeschenEintrag != null)
				return false;
		} else if (!loeschenEintrag.equals(other.loeschenEintrag))
			return false;
		if (menuezeile == null)
		{
			if (other.menuezeile != null)
				return false;
		} else if (!menuezeile.equals(other.menuezeile))
			return false;
		if (neueKarteiEintrag == null)
		{
			if (other.neueKarteiEintrag != null)
				return false;
		} else if (!neueKarteiEintrag.equals(other.neueKarteiEintrag))
			return false;
		if (oeffnenEintrag == null)
		{
			if (other.oeffnenEintrag != null)
				return false;
		} else if (!oeffnenEintrag.equals(other.oeffnenEintrag))
			return false;
		if (resetEintrag == null)
		{
			if (other.resetEintrag != null)
				return false;
		} else if (!resetEintrag.equals(other.resetEintrag))
			return false;
		if (schriftColor == null)
		{
			if (other.schriftColor != null)
				return false;
		} else if (!schriftColor.equals(other.schriftColor))
			return false;
		if (speichernEintrag == null)
		{
			if (other.speichernEintrag != null)
				return false;
		} else if (!speichernEintrag.equals(other.speichernEintrag))
			return false;
		if (sprachcontroller == null)
		{
			if (other.sprachcontroller != null)
				return false;
		} else if (!sprachcontroller.equals(other.sprachcontroller))
			return false;
		if (spracheMenue == null)
		{
			if (other.spracheMenue != null)
				return false;
		} else if (!spracheMenue.equals(other.spracheMenue))
			return false;
		if (ueberEintrag == null)
		{
			if (other.ueberEintrag != null)
				return false;
		} else if (!ueberEintrag.equals(other.ueberEintrag))
			return false;
		if (versionEintrag == null)
		{
			if (other.versionEintrag != null)
				return false;
		} else if (!versionEintrag.equals(other.versionEintrag))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GuiMenuebar [guiMain=" + guiMain + ", hintergrundColor="
				+ hintergrundColor + ", schriftColor=" + schriftColor
				+ ", handler=" + handler + ", sprachcontroller="
				+ sprachcontroller + ", menuezeile=" + menuezeile
				+ ", dateiMenue=" + dateiMenue + ", spracheMenue="
				+ spracheMenue + ", infoMenue=" + infoMenue
				+ ", neueKarteiEintrag=" + neueKarteiEintrag
				+ ", oeffnenEintrag=" + oeffnenEintrag + ", speichernEintrag="
				+ speichernEintrag + ", loeschenEintrag=" + loeschenEintrag
				+ ", importEintrag=" + importEintrag + ", exportEintrag="
				+ exportEintrag + ", resetEintrag=" + resetEintrag
				+ ", beendenEintrag=" + beendenEintrag + ", deutschEintrag="
				+ deutschEintrag + ", englischEintrag=" + englischEintrag
				+ ", franzoesischEintrag=" + franzoesischEintrag
				+ ", italienischEintrag=" + italienischEintrag
				+ ", versionEintrag=" + versionEintrag + ", ueberEintrag="
				+ ueberEintrag + "]";
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
	 * @param loeschenEintrag
	 *            the loeschenEintrag to set
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