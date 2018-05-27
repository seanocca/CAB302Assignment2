package GUI;

import javax.swing.*;

public class MainGUI{
		
	/**
	 * Create a new GUI using GUIModel Class
	 * @param args
	 * @author Sean O'Connell
	 */
	public static void main(String[] args) {
		GUIModel gui = new GUIModel();
		// make the GUI visible
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	
}