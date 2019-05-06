import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class user_info extends JFrame {
    JButton btn_mod, btn_exit;
    JLabel Fname_lb, Lname_lb, contact_lb, addr_lb;
    JMenu jMenu1, jMenu2;
    JMenuBar jMenuBar1;
    JSeparator jSeparator1;
    JTextField Fname_tf, Lname_tf, contact_tf, addr_tf;
    String data[];
    String name_s;
    
    public user_info(String who) {
    	super("User Information | Name: "+who );
    	name_s = who;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    
     void initComponents() {
        Fname_lb = new JLabel();
        Lname_lb = new JLabel();
        contact_lb = new JLabel();
        addr_lb = new JLabel();
        Fname_tf = new JTextField();
        Lname_tf = new JTextField();
        contact_tf = new JTextField();
        addr_tf = new JTextField();
        jSeparator1 = new JSeparator();
        btn_mod = new JButton();
        btn_exit = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        getdata(name_s);
        Fname_lb.setText("First Name");
        Fname_lb.setPreferredSize(new Dimension(60, 30));

        Lname_lb.setText("Last Name");
        Lname_lb.setPreferredSize(new Dimension(60, 30));

        contact_lb.setText("Contact");
        contact_lb.setPreferredSize(new Dimension(60, 30));

        addr_lb.setText("Address");
        addr_lb.setPreferredSize(new Dimension(60, 30));

        btn_mod.setText("Modify");
        btn_mod.setPreferredSize(new Dimension(90, 30));

        btn_exit.setText("Exit");
        btn_exit.setPreferredSize(new Dimension(90, 30));

        jMenu1.setText("About");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Fname_lb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lname_lb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addr_lb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(Fname_tf)
                    .addComponent(Lname_tf, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(contact_tf, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(addr_tf, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_mod, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Fname_lb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fname_tf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Lname_lb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lname_tf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(contact_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact_tf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addr_lb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addr_tf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        Fname_tf.setEditable(false);
        setVisible(true);
        pack();
        
        btn_mod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	String l = Lname_tf.getText();
            	String c = contact_tf.getText();
            	String a = addr_tf.getText();
            	writeintofile(l, c, a);
            }
        });
        
        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	dispose();
            }
        });
        
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
    }

    
    
    void getdata(String who){
			try {
	        	SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxparser = factory.newSAXParser();
	            
	            DefaultHandler handler = new DefaultHandler(){
	            	String tagname;
	            	@Override
	            	public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
	            		tagname = name;
	            	}
         	
	            	@Override
	            	public void characters(char ch[], int start, int length){
	            		// Change to String
	            		String str = new String(ch, start, length);
	            		if(tagname.equals("info")){
	            			
	            		}else if(tagname.equals("contact")){
	            			contact_tf.setText(str);
	            		}else if(tagname.equals("addr")){
	            			addr_tf.setText(str);
	            		}else if(tagname.equals("fname")){
	            			Fname_tf.setText(str);
	            		}else if(tagname.equals("lname")){
	            			Lname_tf.setText(str);
	            		}
	            	}
	            	
	            	@Override
	            	public void endElement(String uri, String lname, String name) throws SAXException{
	            		
	            	}
	            };
				saxparser.parse(new File(who+".xml"), handler);
				
	         } catch (Exception e) {
	           e.printStackTrace();
	         }
	}
    
    
    void writeintofile(String one, String two, String three){
    	File saveFile=new File(name_s+".xml");
        try {
                FileWriter br=new FileWriter(saveFile);
            
                br.write("<info>");
                br.write("<fname>");
                br.write(name_s);
                br.write("</fname>");
                br.write("<lname>");
                br.write(one);
                br.write("</lname>");
                br.write("<contact>");
                br.write(two);
                br.write("</contact>");
                br.write("<lastlogin>");
                br.write(new Date().toString());
                br.write("</lastlogin>");
                br.write("<addr>");
                br.write(three);
                br.write("</addr>");
                br.write("</info>");
                br.close();
            
                JOptionPane.showMessageDialog(null, "Book has successfully returned!");
                
        } catch (IOException ex) {
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
            System.out.println("Error place: \n");
            ex.printStackTrace();
        }
    }
}
