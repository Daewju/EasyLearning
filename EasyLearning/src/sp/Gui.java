package sp;
//halloo

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui extends JFrame{
	

	public Gui(){
		setLayout(null);
		setVisible(true);
		setSize(800,600);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	public void menuezeileErzeugen(JFrame gui){
		
		JMenuBar menuezeile = new JMenuBar();
		gui.setJMenuBar(menuezeile);
		
		JMenu dateiMenue = new JMenu("Datei");
		menuezeile.add(dateiMenue);
		
		JMenuItem neueKarteiEintrag = new JMenuItem("Neue Kartei");
		neueKarteiEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(neueKarteiEintrag);

		JMenuItem oeffnenEintrag = new JMenuItem("Öffnen");
		oeffnenEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(oeffnenEintrag);
		
		JMenuItem spracheEintrag = new JMenuItem("Sprache");
		spracheEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(spracheEintrag);

		
		JMenuItem beendenEintrag = new JMenuItem("Beenden");
		beendenEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(beendenEintrag);
		
		
	}
	
	
	public static void main(String[] args) {
		JFrame gui = new Gui();
		

	}

}
