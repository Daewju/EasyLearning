package sp;
//halloo

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui extends JFrame{
	

	public Gui(){
		setLayout(null); //LayoutManager verwenden
		setVisible(true);
		setSize(800,600);
		setTitle("EasyLearning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuezeileErzeugen(this);
		repaint();
	
	}
	
	
	public void menuezeileErzeugen(JFrame gui){
		
		JMenuBar menuezeile = new JMenuBar();
		gui.setJMenuBar(menuezeile);
		
		JMenu dateiMenue = new JMenu("Datei");
		menuezeile.add(dateiMenue);
		
		JMenuItem neueKarteiEintrag = new JMenuItem("Neue Kartei");
		neueKarteiEintrag.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){test();}});
		dateiMenue.add(neueKarteiEintrag);

		JMenuItem oeffnenEintrag = new JMenuItem("Öffnen");
	//	oeffnenEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(oeffnenEintrag);
		
		JMenuItem spracheEintrag = new JMenuItem("Sprache");
	//	spracheEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(spracheEintrag);

		
		JMenuItem beendenEintrag = new JMenuItem("Beenden");
	//	beendenEintrag.addActionListener((ActionListener) this);
		dateiMenue.add(beendenEintrag);
		
		
	}
	
	public void test()
	{
		setSize(1600,600);
		repaint();
	}
	
	
	public static void main(String[] args) {
		JFrame gui = new Gui();
		

	}
	
	class neueKarteiActionsListener implements ActionsListener
	{
		
	}

}
