import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class libinfo_admin extends JFrame {
	JButton btn_add, btn_del, btn_mod ,btn_exit;
    JLabel label;
    JList jlist;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    ArrayList<ArrayList<String>> liblist = new ArrayList<ArrayList<String>>();
    DefaultListModel model = new DefaultListModel();
    String [] listM;
    String [] datareg;
    String str;
	int count = 0;
	int countofdata = 0;
	ArrayList<String> bdatalist;
    
    public libinfo_admin() {
    	super("Edit Libraries....ADMIN");
        initComponents();
    }
     void initComponents() {

        jPanel1 = new JPanel();
        label = new JLabel();
        jScrollPane1 = new JScrollPane();
        
        btn_add = new JButton();
        btn_del = new JButton();
        btn_mod = new JButton();
        btn_exit = new JButton();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        label.setText("List of Libraries:");

        loadlibname();
        jlist = new JList();
        jlist.setModel(model);
        jScrollPane1.setViewportView(jlist);
        
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        m.setLeadAnchorNotificationEnabled(false);
        jlist.setSelectionModel(m);

        btn_add.setText("ADD");
        btn_del.setText("DELETE");
        btn_del.setEnabled(false);
        btn_mod.setText("MODIFY");
        btn_mod.setEnabled(false);
        btn_exit.setText("EXIT");
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_mod, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btn_del, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        
        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        
        btn_mod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	loadbook();
            	String [] books = new String [liblist.get(jlist.getSelectedIndex()).size()];
            	for(int i = 0;i<liblist.get(jlist.getSelectedIndex()).size();i++){
            		System.out.println("i="+i+"Sel:"+jlist.getSelectedIndex());
            		books[i] = liblist.get(jlist.getSelectedIndex()).get(i);
            	}
            	dispose();
            	new libinfo_admin_book(books, liblist, jlist.getSelectedIndex()).setVisible(true);
            }
        });
        
        btn_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int select = jlist.getSelectedIndex();
                loadbook();
                try{
                	new savelibibfo_del().readandsave(liblist, select);
                    JOptionPane.showMessageDialog(null, "Delete suc!");
                }catch(Exception ex){
                	JOptionPane.showMessageDialog(null, "Exceeeeeeeption!"+ex.getMessage());
                }
            }
        });
        
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new libinfo_admin_add().setVisible(true);
            }
        });
        
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
              JList theList = (JList) mouseEvent.getSource();
              if (mouseEvent.getClickCount() == 1) {
                int index = theList.locationToIndex(mouseEvent.getPoint());
                if (index >= 0) {
                  btn_mod.setEnabled(true);
                  btn_del.setEnabled(true);
                }
              }
            }
          };
        jlist.addMouseListener(mouseListener);
        
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent ev){
        		dispose();
        	}
        });
        
        pack();
    }
     
     void loadlibname(){
     	try{
 			SAXParserFactory factory = SAXParserFactory.newInstance();
 			SAXParser saxparser = factory.newSAXParser();
 			
 			DefaultHandler handler = new DefaultHandler(){
 				String tagname;
 				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
 					tagname = name;
 				}
 				
 				public void characters(char ch[], int start, int length){
 					// Convert detected element into String
 					str = new String(ch, start, length);
 					if(tagname.equals("libraryname")){
 						System.out.println("FOUND NEW LIB-name"+str);
 						model.addElement(str);
 					}else if(tagname.equals("librarytel")){
 						System.out.println("FOUND NEW LIB-tel"+str);
 					}else if(tagname.equals("librarysite")){
 						System.out.println("FOUND NEW LIB-site"+str);
 					}else if(tagname.equals("libraryaddr")){
 						System.out.println("FOUND NEW LIB-addr"+str);
 					}
 				}
 				
 				public void endElement(String uri, String lname, String name) throws SAXException{
 					
 				}
 			};
 			
 			saxparser.parse(new File("library.xml"), handler);
 			
 		}catch(Exception e){
 			
 		}
     }// End loadlibname
     
     
     void getselectedrow(){
    	 int row = jlist.getSelectedIndex();
     }// End getselectedrow
     
     void loadbook(){
    	 try{
  			SAXParserFactory factory = SAXParserFactory.newInstance();
  			SAXParser saxparser = factory.newSAXParser();
  			
  			DefaultHandler handler = new DefaultHandler(){
  				String tagname;
  				int counts = 0;
  				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
  					tagname = name;
  				}
  				
  				public void characters(char ch[], int start, int length){
  					// Convert detected element into String
  					str = new String(ch, start, length);
  					if(tagname.equals("libraryname")){
  						counts = 0;
  						System.out.println("-----IN LIB-name"+str+"-----"+" "+counts);
  						bdatalist = new ArrayList<String>();
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("librarytel")){
  						System.out.println("-LIB TEL-"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("librarysite")){
  						System.out.println("-LIB SITE-"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("libraryaddr")){
  						System.out.println("-LIB ADDR-"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("bdata")){
  						System.out.println("-FOUND NEW BOOK-");
  					}else if(tagname.equals("bookname")){
  						System.out.println("FOUND BOOK-NAME"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("ISBN")){
  						System.out.println("FOUND BOOK-ISBN"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("author")){
  						System.out.println("FOUND BOOK-AUTHOR"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("bookshelf")){
  						System.out.println("FOUND BOOK-SHELF"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("serial")){
  						System.out.println("FOUND BOOK-SERIAL"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("returned")){
  						System.out.println("FOUND BOOK-returned"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("checkoutdate")){
  						System.out.println("FOUND BOOK-chkdate"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}else if(tagname.equals("returndate")){
  						System.out.println("FOUND BOOK-rtndate"+str+" "+counts);
  						bdatalist.add(counts, str);
  						counts++;
  					}
  					
  				}
  				
  				public void endElement(String uri, String lname, String name) throws SAXException{
  					if(name.equals("data")){
  						// End of a library
  						System.out.println("ADD to liblist");
  						liblist.add(bdatalist);  
  						System.out.println("-----End LIB-----");
  					}
  				}
  			};
  			
  			saxparser.parse(new File("library.xml"), handler);
  			
  		}catch(Exception e){
  			System.out.printf("#####ERROR#####\n"+e.getStackTrace()+"#####ERROR#####");
  		}
     }// End loadbook
}
