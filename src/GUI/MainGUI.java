package GUI;

import javax.swing.*;
/**
 * This creates the GUI form with a main function
 * @author Sean O'Connell
 *
 */
public class MainGUI{
		
	/**
	 * Create a new GUI using GUIModel Class
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		GUIModel gui = new GUIModel();
		// make the GUI visible
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	
}