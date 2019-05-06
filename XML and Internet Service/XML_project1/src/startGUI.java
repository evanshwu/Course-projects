import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;


public class startGUI {
	public static void main(String args[]){
		// Create new window for splash screen
		JWindow window = new JWindow();
		
		// Add splash screen image to window
    	window.getContentPane().add(new JLabel("", new ImageIcon("Startup_splash.png"), SwingConstants.CENTER));
    	
    	// To let the window pop out in the center of the screen, first get screen resolution
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double width = screenSize.getWidth();
    	double height = screenSize.getHeight();
    	
    	// Set the position window will display
    	window.setBounds((int)width/2-300, (int)height/2-170, 600, 340);
    	window.setVisible(true);
    	
    	// Let the window remain visible to 5 secs
    	try {
    	    Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nInterruptedException", "Error",JOptionPane.WARNING_MESSAGE);
    	}
    	
    	// After splash shown, display mian menu and start the application
    	window.dispose();
		new mainIntro().run();
	}
}
