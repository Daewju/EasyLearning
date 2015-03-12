package sp;

public interface GuiSchnittstelle
{
	public void eventNeueKartei(String eingabeFeldErgebnis, String eingabeFeldErgebnis2);
	public void eventNaechsteKarte(String benutzerEingabe);
	public void eventNeueKarteHinzufuegen(String wort, String vokabel);
	public void eventKarteBearbeiten(String wort, String vokabel);
	public void eventKarteLoeschen(String wort);
	public void eventGeheZuFach(int fach);
	public void eventDateiImportieren(String vollPfad, boolean fortschritt);
	public void eventDateiExportieren(String vollPfad, boolean fortschritt);
	public void eventZuruecksetzen();
	public void eventDateiOeffnen(String vollPfad);
	public void eventDateiSpeichern();
	public void eventDateiLoeschen();
	public void eventApplikationBeenden();
}
