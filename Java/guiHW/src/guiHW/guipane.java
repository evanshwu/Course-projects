package guiHW;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
/*403530026 ��ޤ@ �d�H��
 *This file is the sub class of GUI homework. (2/2)
 * 2015/5/12
 * Made by HSIN HAN WU.
 */
public class guipane extends JFrame{
	//first of all, i set those elements that we needed 
	private JFrame F;
	private JPanel p1, p2, p3, p4, p5, p6;
	private JLabel l1, l2, l3, l4, l5, l6;
	private JTextField name, phone;
	private JRadioButton gender1, gender2;
	private JComboBox dep01, dep02;
	private JButton b1, b2, b3;
	private JCheckBox hob1;
	private JCheckBox hob2;
	private JCheckBox hob3;
	private JCheckBox hob4;
	private JTextArea show;
	private ButtonGroup bg;//this one is special---to create a group for buttons and prevent user to choose the incorrect amount of choices
	
	public guipane(){//let's start the guipane 
		
		super("Student Data System");
		F = new JFrame();
		Container c = this.getContentPane();
		setLayout(new GridLayout(6,1));
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		//Label1
		l1 = new JLabel("�m�W");
		name = new JTextField(5);
		add(l1);
		add(name);
		p1.add(l1);
		p1.add(name);
		
		//Label2
		l2 = new JLabel("�ʧO");
		gender1 = new JRadioButton("�k");
		gender2 = new JRadioButton("�k");
		bg = new ButtonGroup();//buttongroup---"bg"
		add(l2);
		add(gender1);
		add(gender2);
		bg.add(gender1);//now we put these buttons into the group
		bg.add(gender2);
		p1.add(l2);
		p1.add(gender1);
		p1.add(gender2);
		
		//Label3
		l3 = new JLabel("�ǰ|");
		String[] dep1 = {"�п�ܾǰ|", "�޾ǰ|", "�u�ǰ|", "����|"};
		dep01 = new JComboBox(dep1);
		itemhandler handlerI = new itemhandler();//here we create an itemhandler, which can let user see choices for the department they choose
		add(l3);
		add(dep01);
		dep01.addItemListener(handlerI);
		p2.add(l3);
		p2.add(dep01);
		
		//Label4
		l4 = new JLabel("�t��");
		String dep2[] = {};//i didn't put things in it because i will set these later in the itemhandler place
		dep02 = new JComboBox(dep2);
		add(l4);
		add(dep02);
		p2.add(l4);
		p2.add(dep02);
		
		//Label5
		l5 = new JLabel("�q��");
		phone = new JTextField(12);
		add(l5);
		add(phone);
		p3.add(l5);
		p3.add(phone);
		
		//Label6
		p4 = new JPanel();
		l6 = new JLabel("����");
		hob1 = new JCheckBox("�ݹq�v");
		add(l6);
		add(hob1);
		hob2 = new JCheckBox("���y");
		add(hob2);
		hob3 = new JCheckBox("�gAPP");
		add(hob3);
		hob4 = new JCheckBox("��ı");
		add(hob4);
		p4.add(l6);
		p4.add(hob1);
		p4.add(hob2);
		p4.add(hob3);
		p4.add(hob4);
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		
		p5 = new JPanel();
		show = new JTextArea("  ", 2, 20);
		
		show.setEditable(false);
		p5.add(show);
		c.add(p5);
		
		p6 = new JPanel();
		b1 = new JButton("Submit!");
		b2 = new JButton("Remove");
		b3 = new JButton("Close");
		actionhandler handler = new actionhandler();//now we have an actionhandler to make sure our button can do special things
		p6.add(b1);
		b1.addActionListener(handler);
		p6.add(b2);
		b2.addActionListener(handler);
		p6.add(b3);
		b3.addActionListener(handler);
		c.add(p6);
	}
	
	private class actionhandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
			//setting temps---because i will use the "remove" function later, so using a string for each elements will be more convenient
			String tempn = " ";
			String tempp = " ";
			String tempg = " ";
			String tempd1 = " ";
			String tempd2 = " ";
			String temph = " ";
		
			//submit button
			if(e.getSource() == b1){
				if(gender1.isSelected()){
					tempg += gender1.getText();
				}
				if(gender2.isSelected()){
					tempg += gender2.getText();
				}
				if(hob1.isSelected()){
					temph += "�ݹq�v ";
				}
				if(hob2.isSelected()){
					temph += "���y ";
				}
				if(hob3.isSelected()){
					temph += "�gAPP ";
				}
				if(hob4.isSelected()){
					temph += "��ı~";
				}
				
				tempn += name.getText();
				tempp += phone.getText();
				tempd1 += dep01.getSelectedItem();
				tempd2 += dep02.getSelectedItem();
				
			}
			//remove button
			else if(e.getSource() == b2){
				show.setText("");
			}
			//close button
			else if(e.getSource() == b3){
				System.exit(0);
			}
			
			//i use temps to display those words i wanted
			show.setText("�m�W: " + tempn + "\n" + 
					"���: " + tempp + "\n" + 
					"�ʧO: " + tempg + "\n" + 
					"�ǰ|: " + tempd1 + "\n" + 
					"�t��: " + tempd2 + "\n" + 
					"����: " + temph);
			}//end actionperformed
		}//end actionlistener
	
	private class itemhandler implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(e.getSource() == dep01){
				String s = (String)e.getItem();
				dep02.removeAllItems();
				if(s.equals("�޾ǰ|")){
					dep02.addItem("��T�޲z�Ǩt");
					dep02.addItem("���~�޲z�Ǩt");
					dep02.addItem("�]�Ȫ��ľǨt");
					dep02.addItem("�|�p�P��T�Ǩt");
				}else if(s.equals("�u�ǰ|")){
					dep02.addItem("��T�u�{�Ǩt");
					dep02.addItem("�q�T�u�{�Ǩt");
					dep02.addItem("����u�{�Ǩt");
					dep02.addItem("�q���u�{�Ǩt");
					dep02.addItem("�ƾǤu�{�Ǩt");
				}else if(s.equals("����|")){
					dep02.addItem("�߲z�Ǩt");
					dep02.addItem("�Ҥu�t");
					dep02.addItem("�F�v�t");
					dep02.addItem("�Ǽ��Ǩt");
				}//end if
			}//end if
		}//end itemStateChanged
	}//end itemhandler

}//end guipane class