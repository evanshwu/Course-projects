import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class Create extends JFrame{
	
	JTextField Fname_tf, Lname_tf, contact_tf, addr_tf;
	JLabel Fname_lb, Lname_lb, contact_lb, addr_lb, error_lb;
	JButton btn_submit, btn_clear, btn_cancel;
	JMenu menu_about, menu_exit;
    JMenuBar menubar;
    JSeparator jSeparator1;
	
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
            	createinterface();
            }
        });
	}
    
    
	void createinterface(){
		
		error_lb = new JLabel("Please enter something!");
		error_lb.setForeground(Color.RED); // Set label color RED
		error_lb.setVisible(false);
		Fname_lb = new JLabel();
        Lname_lb = new JLabel();
        contact_lb = new JLabel();
        addr_lb = new JLabel();
        Fname_tf = new JTextField();
        Lname_tf = new JTextField();
        contact_tf = new JTextField();
        addr_tf = new JTextField();
        btn_submit = new JButton();
        btn_clear = new JButton();
        btn_cancel = new JButton();
        jSeparator1 = new JSeparator();
        menubar = new JMenuBar();
        menu_about = new JMenu();
        menu_exit = new JMenu();
		
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        Fname_lb.setText("First Name");
        Fname_lb.setPreferredSize(new Dimension(60, 30));

        Lname_lb.setText("Last Name");
        Lname_lb.setPreferredSize(new Dimension(60, 30));

        contact_lb.setText("Contact");
        contact_lb.setPreferredSize(new Dimension(60, 30));

        addr_lb.setText("Address");
        addr_lb.setPreferredSize(new Dimension(60, 30));

        Fname_tf.setPreferredSize(new Dimension(170, 25));
        Lname_tf.setPreferredSize(new Dimension(170, 25));
        contact_tf.setPreferredSize(new Dimension(170, 25));
        addr_tf.setPreferredSize(new Dimension(170, 25));

        btn_submit.setText("Submit");
        btn_submit.setPreferredSize(new Dimension(90, 30));

        btn_clear.setText("Clear");
        btn_clear.setPreferredSize(new Dimension(90, 30));
        

        btn_cancel.setText("Cancel");
        btn_cancel.setPreferredSize(new Dimension(90, 30));

        menu_about.setText("About");
        menubar.add(menu_about);

        menu_exit.setText("Exit");
        menubar.add(menu_exit);

        setJMenuBar(menubar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(Fname_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lname_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addr_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(addr_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lname_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fname_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_submit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Fname_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fname_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Lname_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lname_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(contact_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addr_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addr_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_submit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        setVisible(true);
        pack();
        
		// Add action listeners
        btn_submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	// Submit and write to xml, then close frame_create
            	if(Fname_tf.getText().isEmpty() && Lname_tf.getText().isEmpty()&& addr_tf.getText().isEmpty()){
                    error_lb.setVisible(true);
                }else if(new File(Fname_tf.getText() + ".xml").exists()){
                	error_lb.setText("User name exists! Try a different one!");
                	error_lb.setVisible(true);
                	
                	//or JOptionPane.showMessageDialog(null, "Data added successfully!\nEnter your first name and login!");
                }else{
                    // Start saving file
            		File userinfo = new File(Fname_tf.getText() + ".xml");
            		File userhistory = new File(Fname_tf.getText() + "_history.xml");
            		try {
						FileWriter br = new FileWriter(userinfo);
						br.write("<?xml version='1.0' ?>");
                        br.write("<info>");
                        br.write("<fname>");
                        br.write(Fname_tf.getText());
                        br.write("</fname>");
                        br.write("<lname>");
                        br.write(Lname_tf.getText());
                        br.write("</lname>");
                        br.write("<contact>");
                        br.write(contact_tf.getText());
                        br.write("</contact>");
                        br.write("<lastlogin>");
                        br.write(new Date().toString());
                        br.write("</lastlogin>");
                        br.write("<addr>");
                        br.write(addr_tf.getText());
                        br.write("</addr>");
                        br.write("</info>");
                        br.close();
                        
                        FileWriter br2 = new FileWriter(userhistory);
                        br2.write("<?xml version='1.0' ?>");
                        br2.write("<history>");
                        br2.write("<fname>");
                        br2.write(Fname_tf.getText());
                        br2.write("</fname>");
                        br2.write("<item>");
                        br2.write("</item>");
                        br2.write("<quantities>");
                        br2.write("</quantities>");
                        br2.write("</history>");
                        br2.close();
                        
                        JOptionPane.showMessageDialog(null, "Data added successfully!\nEnter your first name and login!");
                        // Close this frame_create
                        dispose();
                        new mainIntro().run();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Something went wrong!");
						// TODO: Logfile
					}// End try catch
                }
            }
		});
		
        btn_clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	// Clear textfields -> use 'for' loop
            	Fname_tf.setText("");
            	Lname_tf.setText("");
            	contact_tf.setText("");
            	addr_tf.setText("");
            	error_lb.setVisible(false);            
            }
		});
		
        btn_cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	// Dump frame_create
            	dispose();
            	new mainIntro().run();
            }
		});
        
        
	}

}
