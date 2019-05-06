
// made by hae0347
// visit http://hae0347.github.io
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;


public class Test extends JFrame{
	private JFrame frame;
	private JTextArea textarea;
	private JTextField textfield;
	int phase = 0, a;
	double number1 = 0, number2 = 0, result = 0;
	String n1, n2, r, sys;
	NumberFormat nf;
	JButton num1;
	int dothasdef = 0;
	
	
	
	public void Test(){
		// TODO Auto-generated method stub
		frame = new JFrame("Java Calculator");
		frame.setBounds(400,100,400,500);
		frame.setLayout(new GridBagLayout());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textfield = new JTextField(8);
		textfield.setEditable(false);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		Font font = new Font("¼Ð·¢Åé", Font.BOLD,24);
		textfield.setFont(font);
		
		
		GridBagConstraints t00 = new GridBagConstraints();
		t00.gridx = 0;
		t00.gridy = 0;
		t00.gridwidth = 5;
		t00.gridheight = 4;
		t00.fill = GridBagConstraints.HORIZONTAL;
		t00.anchor = GridBagConstraints.NORTH;
		t00.insets = new Insets(7,5,30,5);
		
		//frame.add(textarea,t00);
		frame.add(textfield,t00);
		textfield.setText("0");
		
		JButton babout = new JButton("ABOUT");
		GridBagConstraints b01 = new GridBagConstraints();
		b01.gridx = 0;
		b01.gridy = 4;
		b01.gridwidth = 1;
		b01.gridheight = 2;
		b01.fill = GridBagConstraints.HORIZONTAL;
		b01.anchor = GridBagConstraints.NORTH;
		b01.insets = new Insets(7,5,7,5);
		
		frame.add(babout,b01);
		
		JButton none1 = new JButton("   ");
		GridBagConstraints b11 = new GridBagConstraints();
		b11.gridx = 1;
		b11.gridy = 4;
		b11.gridwidth = 1;
		b11.gridheight = 2;
		b11.fill = GridBagConstraints.HORIZONTAL;
		b11.anchor = GridBagConstraints.NORTH;
		b11.insets = new Insets(7,5,7,5);
		frame.add(none1,b11);
		
		
		JButton none2 = new JButton("   ");
		GridBagConstraints b21 = new GridBagConstraints();
		b21.gridx = 2;
		b21.gridy = 4;
		b21.gridwidth = 1;
		b21.gridheight = 2;
		b21.fill = GridBagConstraints.HORIZONTAL;
		b21.anchor = GridBagConstraints.NORTH;
		b21.insets = new Insets(7,5,7,5);
		frame.add(none2,b21);
		
		JButton sqrt = new JButton(" ¡Ô ");
		GridBagConstraints b31 = new GridBagConstraints();
		b31.gridx = 3;
		b31.gridy = 4;
		b31.gridwidth = 1;
		b31.gridheight = 2;
		b31.fill = GridBagConstraints.HORIZONTAL;
		b31.anchor = GridBagConstraints.NORTH;
		b31.insets = new Insets(7,5,7,5);
		frame.add(sqrt,b31);
		
		JButton div = new JButton(" ¡Ò ");
		GridBagConstraints d41 = new GridBagConstraints();
		d41.gridx = 4;
		d41.gridy = 4;
		d41.gridwidth = 1;
		d41.gridheight = 2;
		d41.fill = GridBagConstraints.HORIZONTAL;
		d41.anchor = GridBagConstraints.NORTH;
		d41.insets = new Insets(7,5,7,5);
		frame.add(div,d41);
		
		JButton none4 = new JButton("   ");
		GridBagConstraints b02 = new GridBagConstraints();
		b02.gridx = 0;
		b02.gridy = 6;
		b02.gridwidth = 1;
		b02.gridheight = 2;
		b02.fill = GridBagConstraints.HORIZONTAL;
		b02.anchor = GridBagConstraints.NORTH;
		b02.insets = new Insets(7,5,7,5);
		frame.add(none4,b02);
		
		JButton num7 = new JButton(" 7 ");
		GridBagConstraints b12 = new GridBagConstraints();
		b12.gridx = 1;
		b12.gridy = 6;
		b12.gridwidth = 1;
		b12.gridheight = 2;
		b12.fill = GridBagConstraints.HORIZONTAL;
		b12.anchor = GridBagConstraints.NORTH;
		b12.insets = new Insets(7,5,7,5);
		frame.add(num7,b12);
		
		JButton num8 = new JButton(" 8 ");
		GridBagConstraints b22 = new GridBagConstraints();
		b22.gridx = 2;
		b22.gridy = 6;
		b22.gridwidth = 1;
		b22.gridheight = 2;
		b22.fill = GridBagConstraints.HORIZONTAL;
		b22.anchor = GridBagConstraints.NORTH;
		b22.insets = new Insets(7,5,7,5);
		frame.add(num8,b22);
		
		JButton num9 = new JButton(" 9 ");
		GridBagConstraints b32 = new GridBagConstraints();
		b32.gridx = 3;
		b32.gridy = 6;
		b32.gridwidth = 1;
		b32.gridheight = 2;
		b32.fill = GridBagConstraints.HORIZONTAL;
		b32.anchor = GridBagConstraints.NORTH;
		b32.insets = new Insets(7,5,7,5);
		frame.add(num9,b32);
		
		JButton mul = new JButton(" x ");
		GridBagConstraints b42 = new GridBagConstraints();
		b42.gridx = 4;
		b42.gridy = 6;
		b42.gridwidth = 1;
		b42.gridheight = 2;
		b42.fill = GridBagConstraints.HORIZONTAL;
		b42.anchor = GridBagConstraints.NORTH;
		b42.insets = new Insets(7,5,7,5);
		frame.add(mul,b42);
		
		JButton none3 = new JButton("   ");
		GridBagConstraints b03 = new GridBagConstraints();
		b03.gridx = 0;
		b03.gridy = 8;
		b03.gridwidth = 1;
		b03.gridheight = 2;
		b03.fill = GridBagConstraints.HORIZONTAL;
		b03.anchor = GridBagConstraints.NORTH;
		b03.insets = new Insets(7,5,7,5);
		frame.add(none3,b03);
		
		JButton num4 = new JButton(" 4 ");
		GridBagConstraints b13 = new GridBagConstraints();
		b13.gridx = 1;
		b13.gridy = 8;
		b13.gridwidth = 1;
		b13.gridheight = 2;
		b13.fill = GridBagConstraints.HORIZONTAL;
		b13.anchor = GridBagConstraints.NORTH;
		b13.insets = new Insets(7,5,7,5);
		frame.add(num4,b13);
		
		JButton num5 = new JButton(" 5 ");
		GridBagConstraints b23 = new GridBagConstraints();
		b23.gridx = 2;
		b23.gridy = 8;
		b23.gridwidth = 1;
		b23.gridheight = 2;
		b23.fill = GridBagConstraints.HORIZONTAL;
		b23.anchor = GridBagConstraints.NORTH;
		b23.insets = new Insets(7,5,7,5);
		frame.add(num5,b23);
		
		JButton num6 = new JButton(" 6 ");
		GridBagConstraints b33 = new GridBagConstraints();
		b33.gridx = 3;
		b33.gridy = 8;
		b33.gridwidth = 1;
		b33.gridheight = 2;
		b33.fill = GridBagConstraints.HORIZONTAL;
		b33.anchor = GridBagConstraints.NORTH;
		b33.insets = new Insets(7,5,7,5);
		frame.add(num6,b33);
		
		JButton sub = new JButton(" - ");
		GridBagConstraints b43 = new GridBagConstraints();
		b43.gridx = 4;
		b43.gridy = 8;
		b43.gridwidth = 1;
		b43.gridheight = 2;
		b43.fill = GridBagConstraints.HORIZONTAL;
		b43.anchor = GridBagConstraints.NORTH;
		b43.insets = new Insets(7,5,7,5);
		frame.add(sub,b43);
		
		JButton c= new JButton(" C ");
		GridBagConstraints b04 = new GridBagConstraints();
		b04.gridx = 0;
		b04.gridy = 10;
		b04.gridwidth = 1;
		b04.gridheight = 2;
		b04.fill = GridBagConstraints.HORIZONTAL;
		b04.anchor = GridBagConstraints.NORTH;
		b04.insets = new Insets(7,5,7,5);
		frame.add(c,b04);
		
		 num1 = new JButton(" 1 ");
		GridBagConstraints b14 = new GridBagConstraints();
		b14.gridx = 1;
		b14.gridy = 10;
		b14.gridwidth = 1;
		b14.gridheight = 2;
		b14.fill = GridBagConstraints.HORIZONTAL;
		b14.anchor = GridBagConstraints.NORTH;
		b14.insets = new Insets(7,5,7,5);
		frame.add(num1,b14);
		
		JButton num2 = new JButton(" 2 ");
		GridBagConstraints b24 = new GridBagConstraints();
		b24.gridx = 2;
		b24.gridy = 10;
		b24.gridwidth = 1;
		b24.gridheight = 2;
		b24.fill = GridBagConstraints.HORIZONTAL;
		b24.anchor = GridBagConstraints.NORTH;
		b24.insets = new Insets(7,5,7,5);
		frame.add(num2,b24);
		
		JButton num3 = new JButton(" 3 ");
		GridBagConstraints b34 = new GridBagConstraints();
		b34.gridx = 3;
		b34.gridy = 10;
		b34.gridwidth = 1;
		b34.gridheight = 2;
		b34.fill = GridBagConstraints.HORIZONTAL;
		b34.anchor = GridBagConstraints.NORTH;
		b34.insets = new Insets(7,5,7,5);
		frame.add(num3,b34);
		
		JButton add = new JButton(" + ");
		GridBagConstraints b44 = new GridBagConstraints();
		b44.gridx = 4;
		b44.gridy = 10;
		b44.gridwidth = 1;
		b44.gridheight = 4;
		b44.fill = GridBagConstraints.BOTH;
		b44.anchor = GridBagConstraints.NORTH;
		b44.insets = new Insets(7,5,7,5);
		frame.add(add,b44);
		
		JButton num0 = new JButton(" 0 ");
		GridBagConstraints b05 = new GridBagConstraints();
		b05.gridx = 0;
		b05.gridy = 12;
		b05.gridwidth = 1;
		b05.gridheight = 2;
		b05.fill = GridBagConstraints.HORIZONTAL;
		b05.anchor = GridBagConstraints.NORTH;
		b05.insets = new Insets(7,5,7,5);
		frame.add(num0,b05);
		
		// unused
		JButton num00 = new JButton("  ");
		GridBagConstraints b15 = new GridBagConstraints();
		b15.gridx = 1;
		b15.gridy = 12;
		b15.gridwidth = 1;
		b15.gridheight = 2;
		b15.fill = GridBagConstraints.HORIZONTAL;
		b15.anchor = GridBagConstraints.NORTH;
		b15.insets = new Insets(7,5,7,5);
		frame.add(num00,b15);
		
		JButton dot = new JButton(" . ");
		GridBagConstraints b25 = new GridBagConstraints();
		b25.gridx = 2;
		b25.gridy = 12;
		b25.gridwidth = 1;
		b25.gridheight = 2;
		b25.fill = GridBagConstraints.HORIZONTAL;
		b25.anchor = GridBagConstraints.NORTH;
		b25.insets = new Insets(7,5,7,5);
		frame.add(dot,b25);
		
		JButton equ = new JButton(" = ");
		GridBagConstraints b35 = new GridBagConstraints();
		b35.gridx = 3;
		b35.gridy = 12;
		b35.gridwidth = 1;
		b35.gridheight = 2;
		b35.fill = GridBagConstraints.HORIZONTAL;
		b35.anchor = GridBagConstraints.NORTH;
		b35.insets = new Insets(7,5,7,5);
		frame.add(equ,b35);

		//button
		num0.addActionListener(new ActionListener(){	//0
			
            public void actionPerformed(ActionEvent e) {
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 0;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "0"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 0;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "0";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 0;
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 0;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
             
            
        });
		
		babout.addActionListener(new ActionListener(){	//about
			
            public void actionPerformed(ActionEvent e) {   	
                JOptionPane.showMessageDialog(null, "Made By hae0347\nFor more info, visit\nhttps://github.com/hae0347");
             }
            
        });
		
		/*
		num00.addActionListener(new ActionListener(){	//00
			
            public void actionPerformed(ActionEvent e) {
            	//          	
                
             }
            
        });
        */

		dot.addActionListener(new ActionListener(){	//dot
			
            public void actionPerformed(ActionEvent e) {          	
                switch(phase){
                case 0:
                	n1 = "0.";
                	dothasdef = 1;
                	break;
                case 1:
                	if(dothasdef == 1){
                		// do nothing - a dot has been placed
                	}else{
                		n1 = textfield.getText() + ".";
                    	dothasdef = 1;
                	}
                	break;
                case 2:
                	if(dothasdef == 2){
                		// Generally it's impossible to get here
                		// for safety, we do nothing here
                	}else{
                		n2 = "0.";
                		dothasdef = 2;
                		// and goto phase 3 - this has been changed to number2
                		phase = 3;
                	}
                	break;
                case 3:
                	if(dothasdef == 2){
                		// do nothing - a dot has been placed
                	}else{
                		n2 = textfield.getText() + ".";
                		dothasdef = 2;
                	}
                	break;
                case 4:
                	// Similar as the calculator app in Windows - clean()
                	clean();
                	n1 = "0.";
                	dothasdef = 1;
                	phase = 1;
                	break;
                }
             }
            
        });

		equ.addActionListener(new ActionListener(){	//=
			
            public void actionPerformed(ActionEvent e) {
            	switch(phase){
                case 0:
                    // why are you pressing equal?
                    break;
                case 1:
                    // oh really?
                    break;
                case 2:
                    // similar to +=, but check operator first
                    if(a==1){
                        //plus
                    	result = number1;
                        result += number1;
                        System.out.println(result);
                        r = nf.format(result);
                        textfield.setText(r);
                        phase = 4;
                    }else if(a==2){
                        // minus
                    	result = number1;
                        result -= number1;
                        r = nf.format(result);
                        textfield.setText(r);
                    }else if(a==3){
                        // times
                    	result = number1;
                        result *= number1;
                        r = nf.format(result);
                        textfield.setText(r);
                    }else if(a == 4){
                        // divide
                    	result = number1;
                        result /= number1;
                        r = nf.format(result);
                        textfield.setText(r);
                    }else if(a == 5){
                        // sqrt
                        
                    }
                    break;
                case 3:
                    /* now results are out, so result = number1 and store
                     * the last operator with number2
                     */
                    result = operation(a);
                    number1 = result;
                    r = nf.format(result);
                    textfield.setText(r);
                    phase = 4;
                    // and keep number2 with operator
                    break;
                case 33:
                	// case 3a
                	number2 = number1;
                	result = operation(a);
                	// FOR TEST
                	System.out.println("a="+a+"res="+result+"ph="+phase);
                	r = nf.format(result);
                	textfield.setText(r);
                	phase = 4;
                	break;
                case 4:
                    // change number1 only
                    number1 = result;
                    result = operation(a);
                    // 
                    r = nf.format(result);
                    //textfield.setText(r);
                    break;
                }          	
                
             }
            
        });
		

		add.addActionListener(new ActionListener(){	//+
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // at phase 0, number1 = 0
                    number1 = 0;
                    a = 1;
                    phase = 2;
                    break;
                case 1:
                    // at phase 1, number1 and a will be defined
                    a = 1;
                    // and the next phase, 2
                    phase = 2;
                    break;
                case 2:
                    // Now, an operator has been defined, so let's rewrite
                    a = 1;
                    break;
                case 3:
                    /* A bit complicate, number1 and number 2 with operator are
                     * both defined, after pressing an operator, result will be
                     * output first, and this result will be equal to both number1&2
                     * so it's same as phase 3
                     */
                    result = operation(a);
                    number1 = number2;
                    r = nf.format(result);
                    textfield.setText(r);
                    a = 1;
                    number1 = result;
                    phase = 2;
                    break;
                case 4:
                    // Still feeling complicated? both numbers will be same as results,
                    // only rewrites operator -> goto phase 3
                    number1 = result;
                    number2 = result;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    a = 1;
                    phase = 33;
                    break;
                }
             }
            
        });
		
		sub.addActionListener(new ActionListener(){	//minus
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // at phase 0, number1 = 0
                    number1 = 0;
                    a = 2;
                    phase = 2;
                    break;	
                case 1:
                    // at phase 1, number1 and a will be defined
                    a = 2;
                    // and the next phase, 2
                    phase = 2;
                    break;
                case 2:
                    // Now, an operator has been defined, so let's rewrite
                    a = 2;
                    break;
                case 3:
                    // instructions shows at plus button
                    result = operation(a);
                    number1 = number2 = result;
                    r = nf.format(result);
                    textfield.setText(r);
                    a = 2;
                    number1 = result;
                    phase = 2;
                    break;
                case 4:
                    // Still feeling complicated? both numbers will be same as results,
                    // only rewrites operator -> goto phase 3
                    number1 = result;
                    number2 = result;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    a = 2;
                    phase = 33;
                    break;
                }
             }
            
        });
		
		mul.addActionListener(new ActionListener(){		//multiple
			
            public void actionPerformed(ActionEvent e) {
            	switch(phase){
                case 0:
                    // at phase 0, number1 = 0
                    number1 = 0;
                    a = 3;
                    phase = 2;
                    break;
                case 1:
                    // at phase 1, number1 and a will be defined
                    a = 3;
                    // and the next phase, 2
                    phase = 2;
                    break;
                case 2:
                    // Now, an operator has been defined, so let's rewrite
                    a = 3;
                    break;
                case 3:
                    // instructions shows at plus button
                    result = operation(a);
                    number1 = number2 = result;
                    r = nf.format(result);
                    textfield.setText(r);
                    a = 3;
                    number1 = result;
                    phase = 2;
                    break;
                case 4:
                    // Still feeling complicated? both numbers will be same as results,
                    // only rewrites operator -> goto phase 3
                    number1 = result;
                    number2 = result;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    a = 3;
                    phase = 33;
                    break;
                }           	
                
             }
            
        });

		sqrt.addActionListener(new ActionListener(){	//square_root
			
            public void actionPerformed(ActionEvent e) {
                result = operation(5);
                textfield.setText(nf.format(result));
                // keep display as the answer, clean everything and let it go back to phase 0
                number1 = 0;
                a = 0;
                result = 0;
                phase = 0;
             }
            
        });

		div.addActionListener(new ActionListener(){	//divide
			
            public void actionPerformed(ActionEvent e) {
            	switch(phase){
                case 0:
                    // at phase 0, number1 = 0
                    number1 = 0;
                    a = 4;
                    phase = 2;
                    break;
                case 1:
                    // at phase 1, number1 and a will be defined
                    a = 4;
                    // show this operator
                    //textfield.setText();
                    // and the next phase, 2
                    phase = 2;
                    break;
                case 2:
                    // Now, an operator has been defined, so let's rewrite
                    a = 4;
                    break;
                case 3:
                    // instructions shows at plus button
                    result = operation(a);
                    number1 = number2 = result;
                    r = nf.format(result);
                    textfield.setText(r);  
                    a = 4;
                    number1 = result;
                    phase = 2;
                    break;
                case 4:
                    // Still feeling complicated? both numbers will be same as results,
                    // only rewrites operator -> goto phase 3
                    number1 = result;
                    number2 = result;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    a = 4;
                    phase = 33;
                    break;
                }           	
                
             }
            
        });
		
		

		c.addActionListener(new ActionListener(){	//C
			
            public void actionPerformed(ActionEvent e) {         	
            	// all case here will be CLEANED, yup, all of them
                // call slaughterhouse team
                switch(phase){
                case 0:
                    clean();
                    break;
                case 1:
                    clean();
                    break;
                case 2:
                    clean();
                    break;
                case 3:
                    clean();
                    break;
                case 4:
                    clean();
                    break;
                } 
             }
            
        });

		// This will set number format (e.g. dump no needed zeros)	
		nf = new DecimalFormat("####.####");
		
		num1.addActionListener(new ActionListener(){	//1
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 1;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                    	textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "1"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 1;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                    	textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "1";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 1;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                    /* at this phase, pressing any number will
                     * overwrite number1 and move back to phase 1
                    */ 
                    number1 = 1;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // clean
                    number2 = 0;
                    a = 0;
                    result = 0;
                    phase = 1;
                    break;
                }// end switch
             }
            
        });

		num2.addActionListener(new ActionListener(){	//2
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 2;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "2"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 2;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "2";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 2;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 2;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		num3.addActionListener(new ActionListener(){	//3
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 3;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "3"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 3;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "3";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 3;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 3;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		num4.addActionListener(new ActionListener(){	//4
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 4;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "4"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 4;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "4";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 4;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 4;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		num5.addActionListener(new ActionListener(){	//5
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 5;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "5"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 5;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "5";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 5;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 5;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		num6.addActionListener(new ActionListener(){	//6
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 6;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "6"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 6;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "6";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 6;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 6;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });
		
		num7.addActionListener(new ActionListener(){	//7
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 7;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "7"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 7;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "7";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 7;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 7;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });
		
		num8.addActionListener(new ActionListener(){	//8
			
            public void actionPerformed(ActionEvent e) {
            	//          	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 8;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "8"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 8;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "8";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 8;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 8;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		num9.addActionListener(new ActionListener(){	//9
			
            public void actionPerformed(ActionEvent e) {         	
            	switch(phase){
                case 0:
                    // only one char will be input - no need to check length
                    number1 = 9;
                    n1 = nf.format(number1);
                    textfield.setText(n1);
                    // set phase to 1
                    phase = 1;
                    break;
                case 1:
                    // check length availability 
                    sys = textfield.getText(); // put next input to register string
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still under 8
                        textfield.setText(n1);
                        sys = ""; // clear String sys
                    }else if(sys.length()<8){
                        // Length will be under 8 -> store string
                        n1 += "9"; 
                        textfield.setText(n1);
                        number1 = Double.parseDouble(n1);
                        sys = ""; // clear string sys
                    }// exit check max length
                    break;
                case 2:
                    // define number2
                    // only one char will be input - no need to check length
                    number2 = 9;
                    n2 = nf.format(number2);
                    textfield.setText(n2);
                    // set phase to 3
                    phase = 3;
                    break;
                case 3:
                    // operator defined -> define number2 and check length (similar at phase 1)
                    sys = textfield.getText();
                    // check length
                    if(sys.length()>8){
                        // length of n1 will still be under 8
                        textfield.setText(n2);
                        sys = ""; // clear string sys
                    }else if(sys.length()<8){
                        // length will be under 8 here -> store string
                        n2 += "9";
                        textfield.setText(n2);
                        number2 = Double.parseDouble(n2);
                        sys = "";// clear string sys
                    }// exits check max length
                    break;
                 case 33:
                    /* This is what I called it phase 3a,
                     * at this phase, both numbers with operator are defined,
                     * BUT if user pressed any number will rewrite number2
                     */
                     number2 = 9;
                     textfield.setText(nf.format(number2));
                     // now the first char is defined, which means goto phase 3
                     phase = 3;
                     break;
                 case 4:
                	 /* at this phase, pressing any number will
                      * overwrite number1 and move back to phase 1
                     */ 
                     number1 = 9;
                     n1 = nf.format(number1);
                     textfield.setText(n1);
                     // clean
                     number2 = 0;
                     a = 0;
                     result = 0;
                     phase = 1;
                     break;
                 }// end switch
             }
            
        });

		frame.setVisible(true);
	}
	
	public double operation(int a){
		double rtn = 0;
		if(a==1){
	    	// plus
	    	rtn = number1 + number2;
		}else if(a == 2){
			// minus
			rtn = number1 - number2;
		}else if(a == 3){
			rtn = number1 * number2;
		}else if(a == 4){
			/*
			try{
				rtn = number1/number2;
			}catch(Exception ex){
				textfield.setText("ERROR");
			}*/
			if(number2 == 0){
				erhandle();
			}else{
				rtn = number1/number2;
			}
		}else if(a == 5){
			rtn = Math.sqrt(number1);
		}
		return rtn;
	}

	// rewrite operation - change to try-catch in order to add error handling
	/*public double operation(int a) throws Exception{
		double rtn = 0;
		try{
			if(a == 1){
				// plus
				rtn = number1 + number2;
			}else if(a == 2){
				// minus
				rtn = number1 - number2;
			}else if(a == 3){
				// multiple
				rtn = number1 * number2;
			}else if(a == 4){
				// divide
				rtn = number1 / number2;
			}else if(a == 5){
				// aqrt
				rtn = Math.sqrt(number1);
			}
			return rtn;
		}catch(ArithmeticException ex){
			erhandle();
		}
	}*/
	
	void clean(){
	    // Slaughterhouse
	    number1 = 0;
	    number2 = 0;
	    phase = 0;
	    a = 0;
	    dothasdef = 0;
	    textfield.setText("0");
	}
	
	void erhandle(){
		clean();
		textfield.setText("ERROR");
		JOptionPane.showMessageDialog(null, "WARNING: Cannot divide by zero");
	}
	public static void main(String[] args) {
		Test a0 = new Test();
		a0.Test();
		a0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
