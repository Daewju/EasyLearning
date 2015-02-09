/**
 * 
 */
package sp;

/**
 * Reihenfolge: Deutsch, Englisch, Italienisch, Französisch
 * @author Alpha0
 *
 */
public class Sprache
{
	private static int anzahlSprachen = 4;
	protected static String[] datei = new String[anzahlSprachen];;
	protected static String[] fehler = new String[anzahlSprachen];;
	protected static String[] neu = new String[anzahlSprachen];;

	
	public Sprache()
	{
		initialisierenDatei();
		initialisierenFehler();
		initialisierenNeu();
	}
	
	private void initialisierenDatei()
	{
		datei[0] = "Datei";
		datei[1] = "File";
		datei[2] = "File";
		datei[3] = "Fichier";
	}
	
	private void initialisierenFehler()
	{
		fehler[0] = "Fehler";
		fehler[1] = "Error";
		fehler[2] = "Errore";
		fehler[3] = "Erreur";
	}
	
	private void initialisierenNeu()
	{
		neu[0] = "Neu";
		neu[1] = "New";
		neu[2] = "Nuovo";
		neu[3] = "Nouveau";
	}
	
	
}
