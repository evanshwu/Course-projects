import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class libinfo_admin_bookadd extends JFrame {
	
	JButton btn_submit, btn_clear, btn_cancel;
    JLabel jLabel1, label_name, label_isbn, label_auth, label_shelf, label_serial;
    JPanel jPanel1;
    JTextField tf_name, tf_isbn, tf_author, tf_shelf, tf_serial;
    int libno;
    ArrayList<ArrayList<String>> dd = new ArrayList<ArrayList<String>>();
    
    public libinfo_admin_bookadd(ArrayList<ArrayList<String>> d, int lib) {
    	super("Add New Books...");
    	dd = d;
    	libno = lib;
        initComponents();
    }
     void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        label_name = new JLabel();
        label_isbn = new JLabel();
        label_auth = new JLabel();
        label_shelf = new JLabel();
        tf_name = new JTextField();
        tf_isbn = new JTextField();
        tf_author = new JTextField();
        tf_shelf = new JTextField();
        tf_serial = new JTextField();
        btn_submit = new JButton();
        btn_clear = new JButton();
        btn_cancel = new JButton();
        label_serial = new JLabel();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jLabel1.setText("jLabel1");
        label_name.setText("Name:");
        label_isbn.setText("ISBN:");
        label_auth.setText("Author:");
        label_shelf.setText("Shelf:");
        label_serial.setText("Serial:");
        
        btn_submit.setText("Submit");
        btn_clear.setText("Clear");
        btn_cancel.setText("Cancel");

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
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_isbn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_isbn, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_shelf, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_shelf, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_auth, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_author, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_name, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_submit, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_serial, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_serial, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(label_auth, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btn_submit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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

        btn_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                savenewbook();
                btn_cancel.setText("Close");
                JOptionPane.showMessageDialog(null, "A book has been added, please \nreload the page to update the data!");
            }
        });
        
        btn_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tf_name.setText("");
                tf_isbn.setText("");
                tf_author.setText("");
                tf_shelf.setText("");
                tf_serial.setText("");
            }
        });
        
        btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent ev){
        		dispose();
        	}
        });
        
        pack();
    }

     void savenewbook(){
    	 File saveFile=new File("library.xml");
    	 int first = 0;
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
                 	if(first==1){
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
                 		br.write(tf_serial.getText());
                 		br.write("</serial>");
                 		br.write("<returned>");
                 		br.write("1");
                 		br.write("</returned>");
                 		br.write("<checkoutdate>");
                 		br.write("0");
                 		br.write("</checkoutdate>");
                 		br.write("<returndate>");
                 		br.write("0");
                 		br.write("</returndate>");
                 		br.write("</bdata>");
                 		first = 0;
                 	}
                     for(int j=4;j<dd.get(i).size();j+=8){
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
                     br.write("</books>");
                 	 br.write("</data>");
                 }
                 
                 br.write("</libraries>");
                 br.close();
             
                 JOptionPane.showMessageDialog(null, "A book has been added!");
                 
         } catch (IOException ex) {
             System.out.println("IOException Caught\n");
         } catch(IndexOutOfBoundsException ex){
             System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
             System.out.println("Error place: \n");
             ex.printStackTrace();
         }
     }
}
