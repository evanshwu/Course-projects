import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class mainIntro extends JFrame{
	JButton btn_login, btn_join;
    JLabel label_loginico, label_login;
    JSeparator jSeparator1;
    JTextField textfield;
	
    void run(){
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nClassNotFound", "Error",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nInstantiationException", "Error",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nIllegalAccessException", "Error",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nUnsupportedLookAndFeelException", "Error",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	//mainIntro();
            }
        });
	}
    
	public mainIntro(){
		// JFrame draw starts here
		super("Library Checkout System");
		// Define elements
		label_loginico = new JLabel();
        label_login = new JLabel();
        textfield = new JTextField();
        btn_login = new JButton();
        btn_join = new JButton();
        jSeparator1 = new JSeparator();

        // Define the main actions of JFrame
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(320, 460));
        setResizable(false);

        // A simple JLabel contains an image
        label_loginico.setIcon(new ImageIcon("Starter.png"));

        label_login.setText("Libray ID: ");
        btn_login.setText("Login");
        btn_join.setText("Join");
        
        // Below defines and sets the layout of the GUI design
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // Used groups to adjust layout positions
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_loginico, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(label_login, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfield, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_join, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        // And the second one...
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_loginico, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_login, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_join, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        
        // Button listeners - define what to do when the button pressed
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String user = textfield.getText();
            	// Now do different actions according to the user exists or not
            	if(new File(user + ".xml").exists()){
            		// He/She is one of us
            		if(user.equals("admin")){
            			JOptionPane.showMessageDialog(null, "Admin Login!");
            		}else{
            			JOptionPane.showMessageDialog(null, "Welcome! "+user);
            		}
            		
            		// Once login, update lastlogin
            		new WriteRecord().write(user);
            		// Create new window from reader.java
            		new reader(user).run(user);
            		// Close this frame
            		dispose();
            	}else{
            		// Cannot find user, uhoh
            		JOptionPane.showMessageDialog(null, "User doesn't exist!");
            		// Renew textfield
            		textfield.setText("");
            	}
            }
        });
        
        // Button listener for join
        btn_join.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// Handled for unexpecting errors - for safety!
            	try{
            		dispose();
            		new Create().run();
            	}catch(Exception ex){
            		// Error Caught
            		JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin.", "Error",JOptionPane.WARNING_MESSAGE);
            		ex.printStackTrace();
            	}
            }
        });
        
        // Below define the default action when you pressed enter
        getRootPane().setDefaultButton(btn_login);

        // Below define the action I want it to happen when close button was clicked
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent ev){
        		if (JOptionPane.showConfirmDialog(new JFrame(), 
        	            "Are you sure you want to leave?", "Close confirm", 
        	            JOptionPane.YES_NO_OPTION,
        	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        	            System.exit(0);
        	        }
        	}
        });
        
        setVisible(true);
        pack();
		
	}
	
	

}




