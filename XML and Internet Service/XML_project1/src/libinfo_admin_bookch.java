import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class libinfo_admin_bookch extends JFrame {
	JButton btn_save, btn_cancel;
    JLabel jLabel1, label_name, label_isbn, label_author, label_shelf, label_serial;
    JPanel jPanel1;
    JTextField tf_name, tf_isbn, tf_author, tf_shelf, tf_serial;
    ArrayList<ArrayList<String>> dd = new ArrayList<ArrayList<String>>();
    int selindex, libno;
    
    public libinfo_admin_bookch(String [] k, ArrayList<ArrayList<String>> d, int selected, int lib) {
    	super("Edit Books");
    	libno = lib;
    	selindex = selected;
    	dd = d;
        initComponents(k);
    }

    @SuppressWarnings("unchecked")

     void initComponents(String [] s) {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        label_name = new JLabel();
        label_isbn = new JLabel();
        label_author = new JLabel();
        label_shelf = new JLabel();
        tf_name = new JTextField();
        tf_isbn = new JTextField();
        tf_author = new JTextField();
        tf_shelf = new JTextField();
        btn_save = new JButton();
        btn_cancel = new JButton();
        label_serial = new JLabel();
        tf_serial = new JTextField();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Modify book (serial:"+s[4]+")");
        label_name.setText("Name:");
        tf_name.setText(s[0]);
        label_isbn.setText("ISBN:");
        tf_isbn.setText(s[1]);
        label_author.setText("Author:");
        tf_author.setText(s[2]);
        label_shelf.setText("Shelf:");
        tf_shelf.setText(s[3]);
        label_serial.setText("Serial:");
        tf_serial.setText(s[4]);
        tf_serial.setEditable(false);

        btn_save.setText("Save");
        btn_cancel.setText("Close");
        


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_isbn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_isbn, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_shelf, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_shelf, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_author, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_author, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_name, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_serial, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tf_serial, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label_isbn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_isbn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_author, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_author, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_shelf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_shelf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_serial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_serial, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
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

        btn_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveit();
            }
        });
        
        btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                JOptionPane.showMessageDialog(null, "A book has been modified, please \nreload the page to update the data!");
            }
        });
        
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent ev){
        		dispose();
        	}
        });
        
        pack();
    }
    
    
    void saveit(){
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
                    		if(j==selindex){
                    			br.write("<bdata>");
                        		br.write("<bookname>");
                        		br.write(tf_name.getText());
                        		br.write("</bookname>");
                        		br.write("<ISBN>");
                        		br.write(tf_isbn.getText());
                        		br.write("</ISBN>");
                        		br.write("<author>");
                        		br.write(tf_author.getText());
                        		br.write("</author>");
                        		br.write("<bookshelf>");
                        		br.write(tf_shelf.getText());
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
            
                JOptionPane.showMessageDialog(null, "Book data has successfully edited!");
                
        } catch (IOException ex) {
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
            System.out.println("Error place: \n");
            ex.printStackTrace();
        }
    }
}
