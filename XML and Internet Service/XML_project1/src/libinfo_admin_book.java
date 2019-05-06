import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class libinfo_admin_book extends JFrame {
	JButton btn_add, btn_del, btn_mod, btn_cancel;
    JLabel jLabel1;
    JList jlist;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    DefaultListModel listM = new DefaultListModel();
    String libname;
    String [] data;
    ArrayList<ArrayList<String>> dd = new ArrayList<ArrayList<String>>();
    int libno;

    public libinfo_admin_book(String [] books, ArrayList<ArrayList<String>> d, int lib) {
    	super("Book List");
    	libno = lib;
    	dd = d;
    	data = books;
    	loadalldata(books);
        initComponents();
    }

     void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jlist = new JList();
        btn_add = new JButton();
        btn_del = new JButton();
        btn_mod = new JButton();
        btn_cancel = new JButton();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Books from "+libname);

        jlist.setModel(listM);
        jScrollPane1.setViewportView(jlist);

        btn_add.setText("ADD");
        btn_del.setText("DELETE");
        btn_del.setEnabled(false);
        btn_mod.setText("MODIFY");
        btn_mod.setEnabled(false);
        btn_cancel.setText("Cancel");
        


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
                        .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
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

        btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new libinfo_admin().setVisible(true);;
            }
        });
        
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new libinfo_admin_bookadd(dd, libno).setVisible(true);
            }
        });
        
        btn_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	int bookno = 4+(jlist.getSelectedIndex())*8;
            	deletebook(libno, bookno);
            }
        });
        
        btn_mod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int sel = 4+(jlist.getSelectedIndex())*8;
                String [] s = new String [5];
                s[0] = data[sel];
                s[1] = data[sel+1];
                s[2] = data[sel+2];
                s[3] = data[sel+3];
                s[4] = data[sel+4];
                new libinfo_admin_bookch(s, dd, sel, libno).setVisible(true);
                btn_cancel.setText("Close");
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
     
     void loadalldata(String [] books){
    	 libname = books[0];
    	 System.out.println(libname);
    	 for(int i = 4;i<books.length;i+=8){
    		 listM.addElement(books[i]);
    	 }
     }
     
     void deletebook(int libno, int bookno){
    	 int first = 0;
     	 File saveFile=new File("library.xml");
         try {
                 FileWriter br=new FileWriter(saveFile);
                 br.write("<?xml version='1.0' ?>");
             	 br.write("<libraries>");
                 for(int i = 0; i<dd.size();i++){
                 	if(i==libno){
                 		first = 1;
                 	}
                 	br.write("<data>");
                 	br.write("<libraryinfo>");
                 	br.write("<libraryname>");
                 	br.write(dd.get(i).get(0));
                 	br.write("</libraryname>");
                 	br.write("<librarytel>");
                 	br.write(dd.get(i).get(1));
                 	br.write("</librarytel>");
                 	br.write("<librarysite>");
                 	br.write(dd.get(i).get(2));
                 	br.write("</librarysite>");
                 	br.write("<libraryaddr>");
                 	br.write(dd.get(i).get(3));
                 	br.write("</libraryaddr>");
                 	br.write("</libraryinfo>");
                 	br.write("<books>");
                     for(int j=4;j<dd.get(i).size();j+=8){
                     	if(first==1){
                     		if(j==bookno){
                     			
                     		}
                     		first = 0;
                     	}else{
                     		br.write("<bdata>");
                     		br.write("<bookname>");
                     		br.write(dd.get(i).get(j));
                     		br.write("</bookname>");
                     		br.write("<ISBN>");
                     		br.write(dd.get(i).get(j+1));
                     		br.write("</ISBN>");
                     		br.write("<author>");
                     		br.write(dd.get(i).get(j+2));
                     		br.write("</author>");
                     		br.write("<bookshelf>");
                     		br.write(dd.get(i).get(j+3));
                     		br.write("</bookshelf>");
                     		br.write("<serial>");
                     		br.write(dd.get(i).get(j+4));
                     		br.write("</serial>");
                     		br.write("<returned>");
                     		br.write(dd.get(i).get(j+5));
                     		br.write("</returned>");
                     		br.write("<checkoutdate>");
                     		br.write(dd.get(i).get(j+6));
                     		br.write("</checkoutdate>");
                     		br.write("<returndate>");
                     		br.write(dd.get(i).get(j+7));
                     		br.write("</returndate>");
                     		br.write("</bdata>");
                     	}
                     }
                     br.write("</books>");
                 	 br.write("</data>");
                 }
                 
                 br.write("</libraries>");
                 br.close();
             
                 JOptionPane.showMessageDialog(null, "A book has been deleted!");
                 
         } catch (IOException ex) {
             System.out.println("IOException Caught\n");
         } catch(IndexOutOfBoundsException ex){
             System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
             System.out.println("Error place: \n");
             ex.printStackTrace();
         }
     }
}
