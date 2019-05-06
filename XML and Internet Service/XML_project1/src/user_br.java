import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class user_br extends JFrame {

    JButton btn_br, btn_rtn, btn_ren;
    JLabel label1, label2, label3;
    JPanel jPanel1, jPanel2;
    JScrollPane jScrollPane1, jScrollPane2, jScrollPane3;
    JTabbedPane jTabbedPane1;
    JTable table_br_user, table_br_lib, table_re;
    String [] datareg;
	String [] listelements;
    int count, countofuser = 0;
    String str, name_s, libn;
    ArrayList <String> list = new ArrayList<String>(); 
	DefaultTableModel listModelusrbr = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return false;
		}
	};
	DefaultTableModel listModellibbr = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return false;
		}
	};
    
    public user_br(String user) {
    	super("Borrow / Return System | Name:" + user);
    	name_s = user;
        initComponents();
    }


    @SuppressWarnings("unchecked")
     void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        table_br_user = new JTable();
        jScrollPane2 = new JScrollPane();
        table_br_lib = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        btn_br = new JButton();
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        table_re = new JTable();
        label3 = new JLabel();
        btn_rtn = new JButton();
        btn_ren = new JButton();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        String[] columns1 = {"Book", "ISBN", "Borrow date", "Due date"};
		listModelusrbr.setColumnIdentifiers(columns1);
		getdata();
        table_br_user.setModel(listModelusrbr);
        jScrollPane1.setViewportView(table_br_user);

        String[] columns2 = {"Book", "Author", "Shelf", "Library", "#Owned#Out", "ISBN"};
		listModellibbr.setColumnIdentifiers(columns2);
		getlibdata();
        table_br_lib.setModel(listModellibbr);
        jScrollPane2.setViewportView(table_br_lib);

        readXML_list(name_s);
        
        label1.setFont(new Font("Trebuchet MS", 0, 18)); // NOI18N
        label1.setText("Library book list");

        label2.setFont(new Font("Trebuchet MS", 0, 18)); // NOI18N
        label2.setText("Your book list");

        btn_br.setText("Borrow");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_br)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(label1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addComponent(label2)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(label2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_br, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jTabbedPane1.addTab("Borrow", jPanel1);

        table_re.setModel(listModelusrbr);
        jScrollPane3.setViewportView(table_re);

        label3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        label3.setText("Return & Renew");

        btn_rtn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_rtn.setText("Return");

        btn_ren.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_ren.setText("Renew");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btn_rtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btn_ren, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(label3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_rtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ren, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Return / Renew", jPanel2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        
        // Borrow Action
        btn_br.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String selbookn = (String) table_br_lib.getValueAt(table_br_lib.getSelectedRow(), 0);
            	String selbookis = (String) table_br_lib.getValueAt(table_br_lib.getSelectedRow(), 5);
            	try{
            		new brprocess().savepack(selbookn);
            		savedata_usrbr(selbookn.trim(), selbookis.trim());
            		dispose();
            		new user_br(name_s).startuserbr(name_s);
            	}catch(Exception ex){
            		JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+ex.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
            	}
            }
        });
        
        btn_rtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String selbookn = (String) table_re.getValueAt(table_re.getSelectedRow(), 0);
            	try{
            		new rtnprocess().savepack(name_s, selbookn);
            		new rtnprocess2().savepack(selbookn);
            		dispose();
            		new user_br(name_s).startuserbr(name_s);
            	}catch(Exception ex){
            		JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+ex.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
            	}
            }
        });
        
        btn_ren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String bookis = (String) table_re.getValueAt(table_re.getSelectedRow(),0);
            	try{
            		JOptionPane.showConfirmDialog(null, "Renew!");
            	}catch(Exception ex){
            		JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+ex.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
            	}
            }
        });
        
        // Below define the action I want it to happen when close button was clicked
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent ev){
        		if (JOptionPane.showConfirmDialog(new JFrame(), 
        	            "Are you sure you want to leave borrow/return system?", "Close confirm", 
        	            JOptionPane.YES_NO_OPTION,
        	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        	            dispose();
        	        }
        	}
        });
        
    }

    void startuserbr(final String user) {
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
            	new user_br(user).setVisible(true);
            }
        });
    }
    
    
    void getdata(){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler(){
				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
					if(name.equals("data")){
						datareg = new String [4];
					}
				}
				
				public void characters(char ch[], int start, int length){
					// Convert detected element into String
					str = new String(ch, start, length);
				}
				
				public void endElement(String uri, String lname, String name) throws SAXException{
					if(name.equals("fname")){
						System.out.println("name: "+str);
						name_s = str;
					}else if(name.equals("bookname")){
						System.out.println("book: "+str);
						datareg[0] = str;
					}else if(name.equals("ISBN")){
						System.out.println("isbn: "+str);
						datareg[1] = str;
					}else if(name.equals("borrow")){
						System.out.println("br: "+str);
						datareg[2] = str;
					}else if(name.equals("due")){
						System.out.println("due: "+str);
						datareg[3] = str;
					}else if(name.equals("returned")){
						if(str.trim().equals("1")){
							// Returned
							System.out.println("111"+datareg[0]);
						}else{
							// Not returned, show on table
							count++;
							listModelusrbr.addRow(datareg);
							System.out.println("000"+datareg[0]);
						}
					}
				}
			};
			
			saxparser.parse(new File(name_s + "_history.xml"), handler);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
		}
		
	}// End void getdata
	
    void getlibdata(){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			System.out.println("in try");
			DefaultHandler handler = new DefaultHandler(){
				int libch = 0;
				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
					System.out.println("in start: " + name);
					if(name.equals("bdata")){
						System.out.println("new");
						datareg = new String [6];
						libch = 1;
					}
				}
				
				public void characters(char ch[], int start, int length){
					// Convert detected element into String
					str = new String(ch, start, length);
					
				}
				
				public void endElement(String uri, String lname, String name) throws SAXException{
					
					System.out.println("out: "+name);
					if(name.equals("bdata")){
						System.out.println("new0");
						datareg[3] = libn;
						listModellibbr.addRow(datareg);
					}else if(name.equals("libraryname")){//
						libn = str;
						System.out.println("lib: " + libn);
					}else if(name.equals("bookname")){
						System.out.println("bname: " + str);
						datareg[0] = str;
					}else if(name.equals("author")){
						System.out.println("au: " + str);
						datareg[1] = str;
					}else if(name.equals("bookshelf")){
						System.out.println("sh: " + str);
						datareg[2] = str;
					}else if(name.equals("ISBN")){
						System.out.println("ser: " + str);
						datareg[5] = str;
					}else if(name.equals("returned")){
						if(str.trim().equals("0")){
							// Not yet returned
							datareg[4] = "1/1";
						}else{
							datareg[4] = "1/0";
						}
					}
					
					if(libch == 1){
						datareg[3] = libn;
						libch = 0;
					}else{
						
					}
					
				}
			};
			
			saxparser.parse(new File("library.xml"), handler);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
			System.out.println("Exception: "+e.getMessage());
		}
		
	}// End void getlibdata
    
	void savedata_usrbr(String s1, String s2){
		File saveFile=new File(name_s + "_history.xml");
        try {
                FileWriter br=new FileWriter(saveFile);
            
                for(int i = 0; i<list.size();i++){
                        br.write(list.get(i));
                }
                br.write("<data>");
                br.write("<bookname>");
                br.write(s1);
                br.write("</bookname>");
                br.write("<ISBN>");
                br.write(s2);
                br.write("</ISBN>");
                br.write("<borrow>");
                br.write(new Date().toString());
                br.write("</borrow>");
                br.write("<due>");
                br.write(new Date().toString());
                br.write("</due>");
                br.write("<returned>");
                br.write("0");
                br.write("</returned>");
                br.write("</data>");
                br.write("</item>");
                br.write("<quantities>");
                br.write(String.valueOf((countofuser+1)));
                br.write("</quantities>");
                br.write("</history>");
                br.close();
            
                JOptionPane.showMessageDialog(null, "Book has successfully borrowed!");
                
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nIOException Caught", "Error",JOptionPane.WARNING_MESSAGE);
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
        	JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\nIndexOutOfBoundsException", "Error",JOptionPane.WARNING_MESSAGE);
        }
	}// End savedata_userborrow
	
	
	void savedata_libbr(final String s, final String[] d){
		// d[0] checkout d[1] due
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler(){
				String chara, tagname;
				int shouldchange1 = 0, shouldchange2 = 0, shouldchange3 = 0;
				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
					tagname = name;
				}
				
				public void characters(char ch[], int start, int length){
					// Convert detected element into String
					chara = new String(ch, start, length);
					
					if(tagname.equals("bookname")){
						if(chara.trim().equals(s)){
							// Specific book confirmed
							shouldchange1 = 1;
							shouldchange2 = 1;
							shouldchange3 = 1;
						}
					}else if(tagname.equals("returned")){
						if(shouldchange1 == 1){
							// Change to checkouted
							ch = "0".toCharArray();
							// Flush shouldchange1
							shouldchange1 = 0;
						}
					}else if(tagname.equals("checkoutdate")){
						if(shouldchange2 == 1){
							// Change to checkouted
							ch = d[0].toCharArray();
							// Flush shouldchange1
							shouldchange2 = 0;
						}
					}else if(tagname.equals("returndate")){
						if(shouldchange3 == 1){
							// Change to checkouted
							ch = d[1].toCharArray();
							// Flush shouldchange1
							shouldchange3 = 0;
						}
					}
				}
				
				public void endElement(String uri, String lname, String name) throws SAXException{
					// do nothing
				}
			};
			saxparser.parse(new File("library.xml"), handler);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+e.getCause(), "Error",JOptionPane.WARNING_MESSAGE);
		}
	}// End savedata_librarybrrow
	
	void readXML_list(String user){
		try {
        	SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxparser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler(){
            	String tagname;
            	@Override
            	public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
            		tagname = name;
            		if(name.equals("history")){
            			list.add("<history>");
            		}else if(name.equals("fname")){
            			list.add("<fname>");
            		}else if(name.equals("item")){
            			list.add("<item>");
            		}else if(name.equals("data")){
            			list.add("<data>");
            		}else if(name.equals("bookname")){
            			countofuser++;
            			list.add("<bookname>");
            		}else if(name.equals("ISBN")){
            			list.add("<ISBN>");
            		}else if(name.equals("borrow")){
            			list.add("<borrow>");
            		}else if(name.equals("due")){
            			list.add("<due>");
            		}else if(name.equals("returned")){
            			list.add("<returned>");
            		}
            	}
            	
            	
            	@Override
            	public void characters(char ch[], int start, int length){
            		// Change to String
            		if(tagname.equals("quantities")){
            			
            		}else{
            			str = new String(ch, start, length);
                		list.add(str);
            		}
            	}
            	
            	@Override
            	public void endElement(String uri, String lname, String name) throws SAXException{
            		if(name.equals("fname")){
            			list.add("</fname>");
            		}else if(name.equals("data")){
            			list.add("</data>");
            		}else if(name.equals("bookname")){
            			list.add("</bookname>");
            		}else if(name.equals("ISBN")){
            			list.add("</ISBN>");
            		}else if(name.equals("borrow")){
            			list.add("</borrow>");
            		}else if(name.equals("due")){
            			list.add("</due>");
            		}else if(name.equals("returned")){
            			list.add("</returned>");
            		}
            	}
            };
			saxparser.parse(new File(user+"_history.xml"), handler);
			
         } catch (Exception e) {
        	 JOptionPane.showMessageDialog(null, "An error has occured. Please contact the admin\nand provide the following message:\n"+e.getCause(), "Error",JOptionPane.WARNING_MESSAGE);
         }
	}
}
