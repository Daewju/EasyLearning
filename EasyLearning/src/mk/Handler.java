/**
 * 
 */
package mk;
import java.awt.event.ActionEvent;

import sp.GuiMain;
/**
 * @author marko
 *
 */
public class Handler {
	private GuiMain gui;
	
	public Handler(GuiMain gui){
		this.gui = gui;
		
		
	}
	
	public void empfangeEvent(ActionEvent e){
		if(e.getSource().toString()=="Buttttttooooom"){
			System.out.println(e.getSource().toString() + "ooh behinderte");
		}
		System.out.println(e.getSource().toString());
	}
	

}
