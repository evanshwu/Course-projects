import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class reader extends JFrame{
	JFrame frame_reader;
	JPanel panel;
	JLabel label_br, label_info, label_exit;
	JButton btn_br, btn_info, btn_exit;
	String name;
	ButtonGroup  btng1, btng2;
	JMenu menu;
	JMenuBar menubar;
	
	void run(final String s){
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
            	//reader(s);
            }
        });
	}
	
	public reader(String user){
		super("LCS - Welcome, "+user+"!");
		name = user;
		
		// Define new elements contained in the frame
		btng1 = new ButtonGroup();
        btng2 = new ButtonGroup();

        btn_br = new JButton();
        btn_info = new JButton();
        btn_exit = new JButton();
        label_br = new JLabel();
        label_info = new JLabel();
        label_exit = new JLabel();
        menubar = new JMenuBar();
        menu = new JMenu();

        // Define actions of JFrame
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        setResizable(false);
        setVisible(true);

        // Set button icon
        if(name.equals("admin")){
        	// Admin permission
        	btn_br.setIcon(new ImageIcon("admin_br.png"));
        }else{
        	// Reader permission
        	btn_br.setIcon(new ImageIcon("br_icon.png"));
        }
        btn_info.setIcon(new ImageIcon("info.png"));
        btn_exit.setIcon(new ImageIcon("exit.png"));
        
        label_br.setFont(new java.awt.Font("", 1, 14));
        // Change JLabel content according to user 
        label_br.setHorizontalAlignment(SwingConstants.CENTER);
        if(name.equals("admin")){
        	// Admin permission
        	label_br.setText("Modify Library");
        }else{
        	// Reader permission
        	label_br.setText("Borrow/Return");
        }
        
        label_br.setMaximumSize(new Dimension(80, 30));
        label_br.setMinimumSize(new Dimension(80, 30));
        label_br.setPreferredSize(new Dimension(80, 30));

        label_info.setFont(new java.awt.Font("", 1, 14)); // NOI18N
        label_info.setHorizontalAlignment(SwingConstants.CENTER);
        label_info.setText("User Info");

        label_exit.setFont(new java.awt.Font("", 1, 14)); // NOI18N
        label_exit.setHorizontalAlignment(SwingConstants.CENTER);
        label_exit.setText("Exit");
        label_exit.setHorizontalTextPosition(SwingConstants.CENTER);
        label_exit.setMaximumSize(new Dimension(80, 30));
        label_exit.setMinimumSize(new Dimension(80, 30));
        label_exit.setPreferredSize(new Dimension(80, 30));

        menu.setText("About");
        menubar.add(menu);
        setJMenuBar(menubar);

        // Some layout using Groups
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_br, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_info, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(label_br, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(label_info, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(label_exit, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_br, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_info, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label_exit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label_info, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_br, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        label_br.getAccessibleContext().setAccessibleDescription("");

        // Add 3 actionlisteners
        btn_br.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(name.equals("admin")){
            		new libinfo_admin().setVisible(true);;
            	}else{
            		// Open borrow-return interface
                    new user_br(name).startuserbr(name);
            	}
            	
            }
        });
        
        btn_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Open user-info interface
            	new user_info(name);
            	
            }
        });
        
        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if (JOptionPane.showConfirmDialog(new JFrame(),
            	        "Are you sure you want to quit this application ?", "Exit Application",
            	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            		// And.....goodbye!
            		System.exit(0);
            	}
            }
        });
        
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
        pack();
	}
}
